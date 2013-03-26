package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

public class DinoAIControlledByPlayer extends EntityAIBase
{
    private final EntityDinosaurce motionTarget;
    private final float maxSpeed;
    private float currentSpeed = 0.0F;

    /** Whether the entity's speed is boosted. */
    private boolean speedBoosted = false;

    /**
     * Counter for speed boosting, upon reaching maxSpeedBoostTime the speed boost will be disabled
     */
    private int speedBoostTime = 0;

    /** Maximum time the entity's speed should be boosted for. */
    private int maxSpeedBoostTime = 0;

    public DinoAIControlledByPlayer(EntityDinosaurce var1, float var2)
    {
        this.motionTarget = var1;
        this.maxSpeed = var2;
        this.setMutexBits(7);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.currentSpeed = 0.0F;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.speedBoosted = false;
        this.currentSpeed = 0.0F;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.motionTarget.isEntityAlive() && this.motionTarget.riddenByEntity != null && this.motionTarget.riddenByEntity instanceof EntityPlayer && (this.speedBoosted || this.motionTarget.canBeSteered());
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        EntityPlayer var1 = (EntityPlayer)this.motionTarget.riddenByEntity;
        EntityDinosaurce var2 = this.motionTarget;
        float var3 = MathHelper.wrapAngleTo180_float(var1.rotationYaw - this.motionTarget.rotationYaw) * 0.5F;

        if (var3 > 5.0F)
        {
            var3 = 5.0F;
        }

        if (var3 < -5.0F)
        {
            var3 = -5.0F;
        }

        this.motionTarget.rotationYaw = MathHelper.wrapAngleTo180_float(this.motionTarget.rotationYaw + var3);

        if (this.currentSpeed < this.maxSpeed)
        {
            this.currentSpeed += (this.maxSpeed - this.currentSpeed) * 0.01F;
        }

        if (this.currentSpeed > this.maxSpeed)
        {
            this.currentSpeed = this.maxSpeed;
        }

        int var4 = MathHelper.floor_double(this.motionTarget.posX);
        int var5 = MathHelper.floor_double(this.motionTarget.posY);
        int var6 = MathHelper.floor_double(this.motionTarget.posZ);
        float var7 = this.currentSpeed;

        if (this.speedBoosted)
        {
            if (this.speedBoostTime++ > this.maxSpeedBoostTime)
            {
                this.speedBoosted = false;
            }

            var7 += var7 * 1.15F * MathHelper.sin((float)this.speedBoostTime / (float)this.maxSpeedBoostTime * (float)Math.PI);
        }

        float var8 = 0.91F;

        if (this.motionTarget.onGround)
        {
            var8 = 0.54600006F;
            int var9 = this.motionTarget.worldObj.getBlockId(MathHelper.floor_float((float)var4), MathHelper.floor_float((float)var5) - 1, MathHelper.floor_float((float)var6));

            if (var9 > 0)
            {
                var8 = Block.blocksList[var9].slipperiness * 0.91F;
            }
        }

        float var20 = 0.16277136F / (var8 * var8 * var8);
        float var10 = MathHelper.sin(var2.rotationYaw * (float)Math.PI / 180.0F);
        float var11 = MathHelper.cos(var2.rotationYaw * (float)Math.PI / 180.0F);
        float var12 = var2.getAIMoveSpeed() * var20;
        float var13 = Math.max(var7, 1.0F);
        var13 = var12 / var13;
        float var14 = var7 * var13;
        float var15 = -(var14 * var10);
        float var16 = var14 * var11;

        if (MathHelper.abs(var15) > MathHelper.abs(var16))
        {
            if (var15 < 0.0F)
            {
                var15 -= this.motionTarget.width / 2.0F;
            }

            if (var15 > 0.0F)
            {
                var15 += this.motionTarget.width / 2.0F;
            }

            var16 = 0.0F;
        }
        else
        {
            var15 = 0.0F;

            if (var16 < 0.0F)
            {
                var16 -= this.motionTarget.width / 2.0F;
            }

            if (var16 > 0.0F)
            {
                var16 += this.motionTarget.width / 2.0F;
            }
        }

        int var17 = MathHelper.floor_double(this.motionTarget.posX + (double)var15);
        int var18 = MathHelper.floor_double(this.motionTarget.posZ + (double)var16);
        PathPoint var19 = new PathPoint(MathHelper.floor_float(this.motionTarget.width + 1.0F), MathHelper.floor_float(this.motionTarget.height + var1.height + 1.0F), MathHelper.floor_float(this.motionTarget.width + 1.0F));

        if ((var4 != var17 || var6 != var18) && PathFinder.func_82565_a(this.motionTarget, var17, var5, var18, var19, false, false, true) == 0 && PathFinder.func_82565_a(this.motionTarget, var4, var5 + 1, var6, var19, false, false, true) == 1 && PathFinder.func_82565_a(this.motionTarget, var17, var5 + 1, var18, var19, false, false, true) == 1)
        {
            var2.getJumpHelper().setJumping();
        }

        this.motionTarget.moveEntityWithHeading(0.0F, var7);

        if (this.speedBoosted)
        {
            this.motionTarget.BlockInteractive();
        }
    }

    /**
     * Return whether the entity's speed is boosted.
     */
    public boolean isSpeedBoosted()
    {
        return this.speedBoosted;
    }

    /**
     * Boost the entity's movement speed.
     */
    public void boostSpeed()
    {
        this.speedBoosted = true;
        this.speedBoostTime = 0;
        this.maxSpeedBoostTime = this.motionTarget.getRNG().nextInt(841) + 140;
    }

    /**
     * Return whether the entity is being controlled by a player.
     */
    public boolean isControlledByPlayer()
    {
        return !this.isSpeedBoosted() && this.currentSpeed > this.maxSpeed * 0.3F;
    }
}
