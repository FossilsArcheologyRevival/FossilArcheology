package fossil.entity.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFailuresaurus extends ModelBase
{
    public ModelRenderer noumenon1 = new ModelRenderer(this, 0, 1);
    public ModelRenderer noumenon2;
    public ModelRenderer noumenon3;
    public ModelRenderer hand1;

    public ModelFailuresaurus()
    {
        this.noumenon1.addBox(0.0F, 0.0F, 0.0F, 10, 1, 14, 0.0F);
        this.noumenon1.setRotationPoint(-5.0F, 23.0F, -7.0F);
        this.noumenon1.rotateAngleX = 0.0F;
        this.noumenon1.rotateAngleY = 0.0F;
        this.noumenon1.rotateAngleZ = 0.0F;
        this.noumenon1.mirror = false;
        this.noumenon2 = new ModelRenderer(this, 2, 3);
        this.noumenon2.addBox(0.0F, 0.0F, 0.0F, 14, 3, 10, 0.0F);
        this.noumenon2.setRotationPoint(-7.0F, 21.0F, -5.0F);
        this.noumenon2.rotateAngleX = 0.0F;
        this.noumenon2.rotateAngleY = 0.0F;
        this.noumenon2.rotateAngleZ = 0.0F;
        this.noumenon2.mirror = false;
        this.noumenon3 = new ModelRenderer(this, 18, 6);
        this.noumenon3.addBox(0.0F, 0.0F, 0.0F, 10, 4, 5, 0.0F);
        this.noumenon3.setRotationPoint(-5.0F, 17.0F, -2.0F);
        this.noumenon3.rotateAngleX = 0.0F;
        this.noumenon3.rotateAngleY = 0.0F;
        this.noumenon3.rotateAngleZ = 0.0F;
        this.noumenon3.mirror = false;
        this.hand1 = new ModelRenderer(this, 0, 16);
        this.hand1.addBox(0.0F, 0.0F, 0.0F, 8, 6, 10, 0.0F);
        this.hand1.setRotationPoint(-4.0F, 12.0F, -8.0F);
        this.hand1.rotateAngleX = 0.0F;
        this.hand1.rotateAngleY = 0.0F;
        this.hand1.rotateAngleZ = 0.0F;
        this.hand1.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        this.noumenon1.render(var7);
        this.noumenon2.render(var7);
        this.noumenon3.render(var7);
        this.hand1.render(var7);
    }
}
