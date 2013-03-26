package fossil.fossilAI;

//import fossil.entity.mob.EntityDinosaurce;
import fossil.entity.mob.EntityPterosaur;
import fossil.fossilEnums.EnumDinoType;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

public class DinoAIFlightControlledByPlayer extends EntityAIBase
{
    private final EntityPterosaur motionTarget;
    private final float maxSpeed;
    private float currentSpeed = 0.0F;
    
    /** Variables for the flight program*/
    public float AirSpeed = 0.0F;
    public float AirAngle = 0.0F;
    public float AirPitch = 0.0F;
    public float LastAirPitch = 0.0F;
    public boolean Landing = false;

    /** Whether the entity's speed is boosted. */
    private boolean speedBoosted = false;

    /**
     * Counter for speed boosting, upon reaching maxSpeedBoostTime the speed boost will be disabled
     */
    private int speedBoostTime = 0;

    /** Maximum time the entity's speed should be boosted for. */
    private int maxSpeedBoostTime = 0;

    public DinoAIFlightControlledByPlayer(EntityPterosaur var1, float var2)
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
    	EntityClientPlayerMP var1 = (EntityClientPlayerMP)this.motionTarget.riddenByEntity;
    	//EntityPlayer var1 = (EntityPlayer)this.motionTarget.riddenByEntity;
    	EntityPterosaur Dino = this.motionTarget;
    	if (Dino.riddenByEntity != null && !Dino.isCollidedVertically && !Dino.onGround && !Dino.isInWater())
        {
            if (!this.Landing && this.AirPitch > 60.0F)
            {
                this.Landing = true;
            }
        }
        else
        {
            this.Landing = false;
        }
    	//Dino.moveEntityWithHeading(0.0F, this.maxSpeed);

        if (!Dino.onGround && !Dino.isInWater())
        {
            this.AirAngle -= var1.movementInput.moveStrafe;

            if (this.AirAngle > 30.0F)
            {
                this.AirAngle = 30.0F;
            }

            if (this.AirAngle < -30.0F)
            {
                this.AirAngle = -30.0F;
            }

            if (Math.abs(this.AirAngle) > 10.0F)
            {
            	Dino.rotationYaw += (float)(this.AirAngle > 0.0F ? 1 : -1);
            }

            while (Dino.rotationYaw < -180.0F)
            {
            	Dino.rotationYaw += 360.0F;
            }

            while (Dino.rotationYaw >= 180.0F)
            {
            	Dino.rotationYaw -= 360.0F;
            }

            if (this.Landing)
            {
                this.AirPitch = 0.0F;

                if (!Dino.isCollidedVertically)
                {
                	Dino.motionY = -0.2D;
                }
                else
                {
                	Dino.motionY = 0.0D;
                }

                Dino.setMoveForward(this.AirSpeed);
            }
            else
            {
                if ((Dino.isCollidedHorizontally || Dino.isCollidedVertically) && this.AirSpeed != 0.0F)
                {
                    this.AirSpeed = 0.0F;
                    Dino.setMoveForward(0.0F);
                    return;
                }

                //if (this.AirSpeed == 0.0F && Dino.getMoveForward() != 0.0F)
                {
                    //this.AirSpeed = Dino.getMoveForward() * Dino.getMoveSpeed();
                }

                this.AirAngle -= var1.movementInput.moveStrafe;

                if (this.AirAngle > 30.0F)
                {
                    this.AirAngle = 30.0F;
                }

                if (this.AirAngle < -30.0F)
                {
                    this.AirAngle = -30.0F;
                }

                this.AirPitch -= var1.movementInput.moveForward * 2.0F;

                if (this.AirPitch > 90.0F)
                {
                    this.AirPitch = 90.0F;
                }

                if (this.AirPitch < -60.0F)
                {
                    this.AirPitch = -60.0F;
                }

                float var2 = (float)((double)this.AirPitch * 0.017453292519943295D);

                if (this.LastAirPitch >= this.AirPitch)
                {
                    double var3 = Math.cos((double)var2);

                    if (var2 < 0.0F)
                    {
                        ++var3;
                    }

                    Dino.setMoveForward(this.AirSpeed * (float)var3);

                    //if (this.AirPitch < 60.0F && Dino.getMoveForward() > 0.1F)
                    {
                        Dino.motionY = Math.sin((double)var2) * 0.4D;
                    }
                }

                this.LastAirPitch = this.AirPitch;
            }
        }
        else
        {
            if (this.AirSpeed != 0.0F)
            {
                this.AirSpeed = 0.0F;
            }

            if (this.AirAngle != 0.0F)
            {
                this.AirAngle = 0.0F;
            }

            if (this.AirPitch != 0.0F)
            {
                this.AirPitch = 0.0F;
            }

            for (Dino.rotationYaw -= var1.movementInput.moveStrafe * 5.0F; Dino.rotationYaw < -180.0F; Dino.rotationYaw += 360.0F)
            {
                ;
            }

            while (Dino.rotationYaw >= 180.0F)
            {
            	Dino.rotationYaw -= 360.0F;
            }

            //Dino.setMoveForward(var1.movementInput.moveForward * Dino.getMoveSpeed());
            //Dino.moveEntityWithHeading(0.0F, var1.movementInput.moveForward * Dino.getMoveSpeed());
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
