package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPTSLanding extends ModelDinosaurs
{
    ModelRenderer Body = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Head;
    ModelRenderer Crown;
    ModelRenderer Jaw1;
    ModelRenderer Jaw2;
    ModelRenderer LeftWing1;
    ModelRenderer RightWing1;
    ModelRenderer LeftWing2;
    ModelRenderer RightWing2;
    ModelRenderer TAil;
    ModelRenderer LeftLeg;
    ModelRenderer RightLeg;

    public ModelPTSLanding()
    {
        this.Body.addBox(-2.0F, -3.0F, -2.0F, 4, 7, 4);
        this.Body.setRotationPoint(0.0F, 17.0F, 2.0F);
        this.setRotation(this.Body, 0.5876361F, 0.0F, 0.0F);
        this.Body.mirror = true;
        this.Neck1 = (new ModelRenderer(this, 8, 16)).setTextureSize(64, 32);
        this.Neck1.addBox(-1.0F, -2.0F, -1.0F, 2, 4, 2);
        this.Neck1.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.setRotation(this.Neck1, 1.130069F, 0.0F, 0.0F);
        this.Neck1.mirror = true;
        this.Neck2 = (new ModelRenderer(this, 0, 16)).setTextureSize(64, 32);
        this.Neck2.addBox(-1.0F, -2.0F, -1.0F, 2, 4, 2);
        this.Neck2.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.Neck2, 1.446489F, 0.0F, 0.0F);
        this.Neck2.mirror = true;
        this.Head = (new ModelRenderer(this, 0, 23)).setTextureSize(64, 32);
        this.Head.addBox(-2.0F, -4.0F, 0.0F, 4, 5, 4);
        this.Head.setRotationPoint(0.0F, 16.0F, -5.0F);
        this.setRotation(this.Head, 2.12453F, 0.0F, 0.0F);
        this.Head.mirror = true;
        this.Crown = (new ModelRenderer(this, 16, 22)).setTextureSize(64, 32);
        this.Crown.addBox(-1.0F, -4.0F, -2.0F, 2, 4, 6);
        this.Crown.setRotationPoint(0.0F, 13.0F, -6.0F);
        this.setRotation(this.Crown, 1.084867F, 0.0F, 0.0F);
        this.Crown.mirror = true;
        this.Jaw1 = (new ModelRenderer(this, 44, 0)).setTextureSize(64, 32);
        this.Jaw1.addBox(-1.0F, -1.0F, -8.0F, 2, 1, 8);
        this.Jaw1.setRotationPoint(0.0F, 17.0F, -9.0F);
        this.setRotation(this.Jaw1, 0.5235988F, 0.0F, 0.0F);
        this.Jaw1.mirror = true;
        this.Jaw2 = (new ModelRenderer(this, 44, 9)).setTextureSize(64, 32);
        this.Jaw2.addBox(-1.0F, 0.0F, -8.0F, 2, 1, 8);
        this.Jaw2.setRotationPoint(0.0F, 16.0F, -8.0F);
        this.setRotation(this.Jaw2, 0.7684471F, 0.0F, 0.0F);
        this.Jaw2.mirror = true;
        this.LeftWing1 = (new ModelRenderer(this, 16, 0)).setTextureSize(64, 32);
        this.LeftWing1.addBox(0.0F, 0.0F, 0.0F, 8, 6, 1);
        this.LeftWing1.setRotationPoint(2.0F, 14.0F, 1.0F);
        this.setRotation(this.LeftWing1, -2.617994F, -2.740167F, 2.792527F);
        this.LeftWing1.mirror = true;
        this.RightWing1 = (new ModelRenderer(this, 16, 7)).setTextureSize(64, 32);
        this.RightWing1.addBox(0.0F, 0.0F, -1.0F, 8, 6, 1);
        this.RightWing1.setRotationPoint(-2.0F, 14.0F, 1.0F);
        this.setRotation(this.RightWing1, 2.617994F, -0.4363323F, -2.792527F);
        this.RightWing1.mirror = true;
        this.LeftWing2 = (new ModelRenderer(this, 46, 23)).setTextureSize(64, 32);
        this.LeftWing2.addBox(0.0F, 0.0F, -1.0F, 8, 4, 1);
        this.LeftWing2.setRotationPoint(8.0F, 11.0F, 5.0F);
        this.setRotation(this.LeftWing2, 0.6108652F, 0.0F, 0.0F);
        this.LeftWing2.mirror = true;
        this.RightWing2 = (new ModelRenderer(this, 46, 18)).setTextureSize(64, 32);
        this.RightWing2.addBox(0.0F, 0.0F, 0.0F, 8, 4, 1);
        this.RightWing2.setRotationPoint(-8.0F, 11.0F, 5.0F);
        this.setRotation(this.RightWing2, -0.6108652F, (float)Math.PI, 0.0F);
        this.RightWing2.mirror = true;
        this.TAil = (new ModelRenderer(this, 0, 11)).setTextureSize(64, 32);
        this.TAil.addBox(-1.0F, 0.0F, -2.0F, 2, 3, 2);
        this.TAil.setRotationPoint(0.0F, 19.0F, 5.0F);
        this.setRotation(this.TAil, 0.2260139F, 0.0F, 0.0F);
        this.TAil.mirror = true;
        this.LeftLeg = (new ModelRenderer(this, 40, 0)).setTextureSize(64, 32);
        this.LeftLeg.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.LeftLeg.setRotationPoint(1.0F, 21.0F, 2.0F);
        this.setRotation(this.LeftLeg, -0.2712166F, 0.0F, 0.0F);
        this.LeftLeg.mirror = true;
        this.RightLeg = (new ModelRenderer(this, 40, 4)).setTextureSize(64, 32);
        this.RightLeg.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
        this.RightLeg.setRotationPoint(-1.0F, 21.0F, 2.0F);
        this.setRotation(this.RightLeg, -0.2712166F, 0.0F, 0.0F);
        this.RightLeg.mirror = true;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.Body.render(var7);
        this.Neck1.render(var7);
        this.Neck2.render(var7);
        this.Head.render(var7);
        this.Crown.render(var7);
        this.Jaw1.render(var7);
        this.Jaw2.render(var7);
        this.LeftWing2.render(var7);
        this.RightWing2.render(var7);
        this.TAil.render(var7);
        this.LeftLeg.render(var7);
        this.RightLeg.render(var7);
        this.LeftWing1.render(var7);
        this.RightWing1.render(var7);
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {}
}
