package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class DinoAIAvoidEntityWhenYoung extends EntityAIAvoidEntity
{
    EntityDinosaurce dinoEntity;

    public DinoAIAvoidEntityWhenYoung(EntityCreature var1, Class var2, float var3, float var4, float var5)
    {
        super(var1, var2, var3, var4, var5);
        this.dinoEntity = (EntityDinosaurce)var1;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.dinoEntity.isAdult() ? false : super.shouldExecute();
    }
}
