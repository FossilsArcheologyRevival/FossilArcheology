package fossil.fossilAI;

import fossil.entity.mob.EntityBones;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIDeadBones extends EntityAIBase
{
    private EntityBones asker;

    public EntityAIDeadBones(EntityBones var1)
    {
        this.asker = var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return true;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        float var1 = this.asker.rotationYaw;
        this.asker.rotationPitch = 45.0F;
        this.asker.rotationYaw = var1;
    }
}
