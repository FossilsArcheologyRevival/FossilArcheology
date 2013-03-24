package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilInterface.IWaterDino;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class WaterDinoAIWander extends EntityAIBase
{
    private EntityDinosaurce entity;
    protected IWaterDino entityInterface = null;
    private double targetX;
    private double targetZ;
    private float speed;
    private final float FLOAT_SPEED;

    public WaterDinoAIWander(EntityDinosaurce var1, float var2, float var3)
    {
        this.entity = var1;

        if (this.entity instanceof IWaterDino)
        {
            this.entityInterface = (IWaterDino)this.entity;
        }

        this.speed = var2;
        this.FLOAT_SPEED = var3;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entity.getDinoAge() >= 100)
        {
            return false;
        }
        else if (this.entity.getRNG().nextInt(30) != 0)
        {
            return false;
        }
        else
        {
            Vec3 var1 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);

            if (var1 == null)
            {
                return false;
            }
            else
            {
                this.targetX = var1.xCoord;
                this.targetZ = var1.zCoord;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entity.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {}
}
