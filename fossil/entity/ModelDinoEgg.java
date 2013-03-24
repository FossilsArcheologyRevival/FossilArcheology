package fossil.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDinoEgg extends ModelBase
{
    ModelRenderer egg4 = new ModelRenderer(this, 24, 18);
    ModelRenderer egg3;
    ModelRenderer egg2;
    ModelRenderer egg1;

    public ModelDinoEgg()
    {
        this.egg4.addBox(-1.5F, -9.0F, -1.5F, 3, 3, 3);
        this.egg4.setRotationPoint(0.0F, 24.13333F, 0.0F);
        this.egg4.rotateAngleX = 0.0F;
        this.egg4.rotateAngleY = 0.0F;
        this.egg4.rotateAngleZ = 0.0F;
        this.egg4.mirror = false;
        this.egg3 = new ModelRenderer(this, 24, 24);
        this.egg3.addBox(-2.5F, -8.0F, -2.5F, 5, 3, 5);
        this.egg3.setRotationPoint(0.0F, 24.13333F, 0.0F);
        this.egg3.rotateAngleX = 0.0F;
        this.egg3.rotateAngleY = 0.0F;
        this.egg3.rotateAngleZ = 0.0F;
        this.egg3.mirror = false;
        this.egg2 = new ModelRenderer(this, 0, 21);
        this.egg2.addBox(-3.0F, -6.0F, -3.0F, 6, 5, 6);
        this.egg2.setRotationPoint(0.0F, 24.13333F, 0.0F);
        this.egg2.rotateAngleX = 0.0F;
        this.egg2.rotateAngleY = 0.0F;
        this.egg2.rotateAngleZ = 0.0F;
        this.egg2.mirror = false;
        this.egg1 = new ModelRenderer(this, 0, 14);
        this.egg1.addBox(-2.5F, -2.0F, -2.5F, 5, 2, 5);
        this.egg1.setRotationPoint(0.0F, 24.13333F, 0.0F);
        this.egg1.rotateAngleX = 0.0F;
        this.egg1.rotateAngleY = 0.0F;
        this.egg1.rotateAngleZ = 0.0F;
        this.egg1.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        this.egg4.render(var7);
        this.egg3.render(var7);
        this.egg2.render(var7);
        this.egg1.render(var7);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
    }
}
