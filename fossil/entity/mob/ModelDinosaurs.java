package fossil.entity.mob;

import net.minecraft.client.model.ModelBase;

public abstract class ModelDinosaurs extends ModelBase
{
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        this.setRotationAngles(var1, var2, var3, var4, var5, var6, false);
    }

    protected abstract void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7);
}
