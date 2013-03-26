package fossil.fossilAI;

import java.util.Comparator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;

public class DinoAINearestAttackableTargetSorter implements Comparator
{
    private Entity field_48470_b;
    final EntityAIBase field_48471_a;

    public DinoAINearestAttackableTargetSorter(EntityAIBase var1, Entity var2)
    {
        this.field_48471_a = var1;
        this.field_48470_b = var2;
    }

    public int func_48469_a(Entity var1, Entity var2)
    {
        double var3 = this.field_48470_b.getDistanceSqToEntity(var1);
        double var5 = this.field_48470_b.getDistanceSqToEntity(var2);
        return var3 < var5 ? -1 : (var3 > var5 ? 1 : 0);
    }

    public int compare(Object var1, Object var2)
    {
        return this.func_48469_a((Entity)var1, (Entity)var2);
    }
}
