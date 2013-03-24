package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilEnums.EnumOrderType;
import fossil.fossilInterface.IWaterDino;
import net.minecraft.block.material.Material;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;

public class WaterDinoAISwimming extends EntityAIBase
{
    protected EntityDinosaurce entity;
    protected IWaterDino entityInterface;
    protected boolean usuallySurface;
    protected final float FLOAT_SPEED;
    protected final float SINK_SPEED;
    protected final float FAST_FLOAT_SPEED;
    protected final float FAST_SINK_SPEED;
    protected final float FOLLOW_RANGE;
    protected boolean fastFlag;
    protected boolean diveAtNight;

    public WaterDinoAISwimming(EntityDinosaurce var1, boolean var2, float var3, float var4)
    {
        this.entityInterface = null;
        this.usuallySurface = true;
        this.FOLLOW_RANGE = 1.5F;
        this.diveAtNight = false;
        this.entity = var1;

        if (this.entity instanceof IWaterDino)
        {
            this.entityInterface = (IWaterDino)this.entity;
        }

        this.usuallySurface = var2;
        this.setMutexBits(4);
        this.FLOAT_SPEED = var3 > 1.0F ? 1.0F : var3;
        this.SINK_SPEED = -var4;
        this.FAST_FLOAT_SPEED = this.FLOAT_SPEED * 50.0F;
        this.FAST_SINK_SPEED = -this.FAST_FLOAT_SPEED;
    }

    public WaterDinoAISwimming(EntityDinosaurce var1, boolean var2, float var3)
    {
        this(var1, var2, var3, var3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.entityInterface == null ? false : this.entity.isInWater() || this.entity.handleLavaMovement();
    }

    public EntityAIBase setDiveAtNight()
    {
        this.diveAtNight = true;
        return this;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        EntityPlayer var1 = (EntityPlayer)((EntityPlayer)this.entity.getOwner());

        if (this.entity.getOrderType() == EnumOrderType.Follow && var1 != null && var1.isInWater())
        {
            double var10000 = Math.abs(this.entity.posY - var1.posY);
            this.getClass();

            if (var10000 > 1.5D)
            {
                this.entity.motionY = var1.posY < this.entity.posY ? (double)this.FAST_SINK_SPEED : (double)this.FAST_FLOAT_SPEED;
            }
            else
            {
                this.entity.motionY = var1.posY < this.entity.posY ? (double)this.SINK_SPEED : (double)this.FLOAT_SPEED;
            }
        }
        else
        {
            if (this.entity.getNavigator().noPath() && (!this.diveAtNight || this.diveAtNight && this.entity.worldObj.isDaytime()))
            {
                this.entity.motionY = (double)this.FLOAT_SPEED;
            }
        }
    }

    protected void controlSurfacing()
    {
        byte var1 = 5;
        double var2 = 0.0D;

        for (int var6 = 0; var6 < var1; ++var6)
        {
            double var7 = this.entity.boundingBox.minY + (this.entity.boundingBox.maxY - this.entity.boundingBox.minY) * (double)(var6 + 0) / (double)var1 - 0.125D;
            double var9 = this.entity.boundingBox.minY + (this.entity.boundingBox.maxY - this.entity.boundingBox.minY) * (double)(var6 + 1) / (double)var1 - 0.125D;
            AxisAlignedBB var11 = AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.entity.boundingBox.minX, var7, this.entity.boundingBox.minZ, this.entity.boundingBox.maxX, var9, this.entity.boundingBox.maxZ);

            if (this.entity.worldObj.isAABBInMaterial(var11, Material.water))
            {
                var2 += 1.0D / (double)var1;
            }
        }

        if (var2 < 1.0D)
        {
            double var4 = var2 * 2.0D - 1.0D;
            this.entity.motionY += 0.03999999910593033D * var4;
        }
        else
        {
            if (this.entity.motionY < 0.0D)
            {
                this.entity.motionY = 0.0D;
            }

            this.entity.motionY += (double)this.FAST_FLOAT_SPEED;
        }
    }
}
