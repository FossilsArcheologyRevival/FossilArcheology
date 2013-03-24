package fossil.fossilAI;

import java.util.Collections;

import java.util.Iterator;
import java.util.List;

import fossil.entity.mob.EntityDinosaurce;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class DinoAIPickItem extends EntityAIBase
{
    private EntityDinosaurce entityVar;
    private double destX;
    private double destY;
    private double destZ;
    private float field_48317_e;
    private final int SEARCH_RANGE;
    private final float HUNT_LIMIT;
    private final int USE_RANGE;
    private EntityItem targetItem;
    private DinoAINearestAttackableTargetSorter targetSorter;
    private final Item WANTED_ITEM;
    protected boolean shouldCheckHunt;

    public DinoAIPickItem(EntityDinosaurce var1, Item var2, float var3, int var4, float var5)
    {
        this(var1, var2, var3, var4, var5, false);
    }

    public DinoAIPickItem(EntityDinosaurce var1, Item var2, float var3, int var4, float var5, boolean var6)
    {
        this.USE_RANGE = 3;
        this.targetItem = null;
        this.shouldCheckHunt = false;
        this.entityVar = var1;
        this.field_48317_e = var3;
        this.setMutexBits(1);
        this.SEARCH_RANGE = var4;
        this.HUNT_LIMIT = var5;
        this.targetSorter = new DinoAINearestAttackableTargetSorter(this, this.entityVar);
        this.WANTED_ITEM = var2;
        this.shouldCheckHunt = var6;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if ((float)this.entityVar.getHunger() > this.HUNT_LIMIT)
        {
            return false;
        }
        else
        {
            Vec3 var1 = this.getNearestItem();

            if (var1 == null)
            {
                return false;
            }
            else
            {
                this.destX = var1.xCoord;
                this.destY = var1.yCoord;
                this.destZ = var1.zCoord;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entityVar.getNavigator().noPath() && this.targetItem.isEntityAlive();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        double var10000 = Math.pow(this.entityVar.posX - this.destX, 2.0D) + Math.pow(this.entityVar.posZ - this.destZ, 2.0D);
        this.getClass();

        if (var10000 < Math.pow(3.0D, 2.0D))
        {
            this.entityVar.PickUpItem(this.targetItem.getEntityItem());
            this.targetItem.setDead();
            this.entityVar.getNavigator().clearPathEntity();
        }
        else
        {
            this.entityVar.getNavigator().tryMoveToXYZ(this.destX, this.destY, this.destZ, this.field_48317_e);
        }
    }

    private Vec3 getNearestItem()
    {
        List var1 = this.entityVar.worldObj.getEntitiesWithinAABB(EntityItem.class, this.entityVar.boundingBox.expand((double)this.SEARCH_RANGE, 4.0D, (double)this.SEARCH_RANGE));
        Collections.sort(var1, this.targetSorter);
        Iterator var2 = var1.iterator();
        Vec3 var3 = null;

        while (var2.hasNext())
        {
            EntityItem var4 = (EntityItem)var2.next();

            if (this.WANTED_ITEM == null || var4.getEntityItem().itemID == this.WANTED_ITEM.itemID)
            {
                this.targetItem = var4;
                var3 = Vec3.createVectorHelper(var4.posX, var4.posY, var4.posZ);
                break;
            }
        }

        return var3;
    }

    protected boolean checkTargetReachable(Entity var1, boolean var2)
    {
        if (var1 == null)
        {
            return false;
        }
        else if (!var1.isEntityAlive())
        {
            return false;
        }
        else if (var1.boundingBox.maxY > this.entityVar.boundingBox.minY && var1.boundingBox.minY < this.entityVar.boundingBox.maxY)
        {
            if (this.entityVar instanceof EntityTameable && this.entityVar.isTamed())
            {
                if (var1 instanceof EntityTameable && ((EntityTameable)var1).isTamed())
                {
                    return false;
                }

                if (var1 == this.entityVar.getOwner())
                {
                    return false;
                }
            }
            else if (var1 instanceof EntityPlayer && !var2 && ((EntityPlayer)var1).capabilities.disableDamage)
            {
                return false;
            }

            return this.entityVar.isWithinHomeDistance(MathHelper.floor_double(var1.posX), MathHelper.floor_double(var1.posY), MathHelper.floor_double(var1.posZ));
        }
        else
        {
            return false;
        }
    }
}
