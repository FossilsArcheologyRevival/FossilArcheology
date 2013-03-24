package fossil.fossilAI;

import fossil.entity.mob.EntityFriendlyPigZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class FPZAIFollowOwner extends EntityAIBase
{
    private EntityFriendlyPigZombie thePet;
    private EntityLiving theOwner;
    World theWorld;
    private float field_48303_f;
    private PathNavigate petPathfinder;
    private int field_48310_h;
    float maxDist;
    float minDist;
    private boolean field_48311_i;

    public FPZAIFollowOwner(EntityFriendlyPigZombie var1, float var2, float var3, float var4)
    {
        this.thePet = var1;
        this.theWorld = var1.worldObj;
        this.field_48303_f = var2;
        this.petPathfinder = var1.getNavigator();
        this.minDist = var3;
        this.maxDist = var4;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLiving var1 = this.thePet.getOwner();

        if (var1 == null)
        {
            return false;
        }
        else if (this.thePet.getDistanceSqToEntity(var1) < (double)(this.minDist * this.minDist))
        {
            return false;
        }
        else
        {
            this.theOwner = var1;
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.petPathfinder.noPath() && this.thePet.getDistanceSqToEntity(this.theOwner) > (double)(this.maxDist * this.maxDist);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.field_48310_h = 0;
        this.field_48311_i = this.thePet.getNavigator().getAvoidsWater();
        this.thePet.getNavigator().setAvoidsWater(false);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.theOwner = null;
        this.petPathfinder.clearPathEntity();
        this.thePet.getNavigator().setAvoidsWater(this.field_48311_i);
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.thePet.getLookHelper().setLookPositionWithEntity(this.theOwner, 10.0F, (float)this.thePet.getVerticalFaceSpeed());

        if (--this.field_48310_h <= 0)
        {
            this.field_48310_h = 10;

            if (!this.petPathfinder.tryMoveToEntityLiving(this.theOwner, this.field_48303_f) && this.thePet.getDistanceSqToEntity(this.theOwner) >= 144.0D)
            {
                int var1 = MathHelper.floor_double(this.theOwner.posX) - 2;
                int var2 = MathHelper.floor_double(this.theOwner.posZ) - 2;
                int var3 = MathHelper.floor_double(this.theOwner.boundingBox.minY);

                for (int var4 = 0; var4 <= 4; ++var4)
                {
                    for (int var5 = 0; var5 <= 4; ++var5)
                    {
                        if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && this.theWorld.isBlockNormalCube(var1 + var4, var3 - 1, var2 + var5) && !this.theWorld.isBlockNormalCube(var1 + var4, var3, var2 + var5) && !this.theWorld.isBlockNormalCube(var1 + var4, var3 + 1, var2 + var5))
                        {
                            this.thePet.setLocationAndAngles((double)((float)(var1 + var4) + 0.5F), (double)var3, (double)((float)(var2 + var5) + 0.5F), this.thePet.rotationYaw, this.thePet.rotationPitch);
                            this.petPathfinder.clearPathEntity();
                            return;
                        }
                    }
                }
            }
        }
    }
}
