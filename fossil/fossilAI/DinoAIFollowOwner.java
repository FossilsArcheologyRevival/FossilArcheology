package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilEnums.EnumOrderType;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DinoAIFollowOwner extends EntityAIBase
{
    private EntityDinosaurce DinoEntity;
    private EntityLiving FollowTarget;
    World WorldObj;
    private float speed;
    private PathNavigate selfNavigator;
    private int actionCount;
    float closeRange;
    float stayRange;
    private boolean field_48311_i;

    public DinoAIFollowOwner(EntityDinosaurce var1, float var2, float var3, float var4)
    {
        this.DinoEntity = var1;
        this.WorldObj = var1.worldObj;
        this.speed = var2;
        this.selfNavigator = var1.getNavigator();
        this.stayRange = var3;
        this.closeRange = var4;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.DinoEntity.isTamed())
        {
            return false;
        }
        else
        {
            EntityLiving var1 = this.DinoEntity.getOwner();

            if (var1 == null)
            {
                return false;
            }
            else if (this.DinoEntity.getOrderType() != null && this.DinoEntity.getOrderType() != EnumOrderType.Follow)
            {
                return false;
            }
            else if (this.DinoEntity.getDistanceSqToEntity(var1) < (double)(this.stayRange * this.stayRange))
            {
                return false;
            }
            else
            {
                this.FollowTarget = var1;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.selfNavigator.noPath() && this.DinoEntity.getDistanceSqToEntity(this.FollowTarget) > (double)(this.closeRange * this.closeRange) && !this.DinoEntity.isSitting();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.actionCount = 0;
        this.field_48311_i = this.DinoEntity.getNavigator().getAvoidsWater();
        this.DinoEntity.getNavigator().setAvoidsWater(false);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.FollowTarget = null;
        this.selfNavigator.clearPathEntity();
        this.DinoEntity.getNavigator().setAvoidsWater(this.field_48311_i);
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.DinoEntity.getLookHelper().setLookPositionWithEntity(this.FollowTarget, 10.0F, (float)this.DinoEntity.getVerticalFaceSpeed());

        if (!this.DinoEntity.isSitting() && --this.actionCount <= 0)
        {
            this.actionCount = 10;

            if (!this.selfNavigator.tryMoveToEntityLiving(this.FollowTarget, this.speed) && this.DinoEntity.getDistanceSqToEntity(this.FollowTarget) >= 144.0D)
            {
                int var1 = MathHelper.floor_double(this.FollowTarget.posX) - 2;
                int var2 = MathHelper.floor_double(this.FollowTarget.posZ) - 2;
                int var3 = MathHelper.floor_double(this.FollowTarget.boundingBox.minY);

                for (int var4 = 0; var4 <= 4; ++var4)
                {
                    for (int var5 = 0; var5 <= 4; ++var5)
                    {
                        if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && this.WorldObj.isBlockNormalCube(var1 + var4, var3 - 1, var2 + var5) && !this.WorldObj.isBlockNormalCube(var1 + var4, var3, var2 + var5) && !this.WorldObj.isBlockNormalCube(var1 + var4, var3 + 1, var2 + var5))
                        {
                            this.DinoEntity.setLocationAndAngles((double)((float)(var1 + var4) + 0.5F), (double)var3, (double)((float)(var2 + var5) + 0.5F), this.DinoEntity.rotationYaw, this.DinoEntity.rotationPitch);
                            this.selfNavigator.clearPathEntity();
                            return;
                        }
                    }
                }
            }
        }
    }
}
