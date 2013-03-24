package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilEnums.EnumOrderType;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;

public class DinoAIWander extends EntityAIBase
{
    private EntityDinosaurce entity;
    private double targetX;
    private double targetY;
    private double targetZ;
    private float field_48317_e;

    public DinoAIWander(EntityDinosaurce var1, float var2)
    {
        this.entity = var1;
        this.field_48317_e = var2;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entity.OrderStatus == null)
        {
            this.entity.OrderStatus = EnumOrderType.FreeMove;
        }

        if (this.entity.getRNG().nextInt(20) != 0)
        {
            return false;
        }
        else if (this.entity.getOwnerName() != null && this.entity.worldObj.getPlayerEntityByName(this.entity.getOwnerName()) != null && this.entity.OrderStatus != EnumOrderType.FreeMove)
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
                this.targetY = var1.yCoord;
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
    public void startExecuting()
    {
        this.entity.getNavigator().tryMoveToXYZ(this.targetX, this.targetY, this.targetZ, this.field_48317_e);
    }
}
