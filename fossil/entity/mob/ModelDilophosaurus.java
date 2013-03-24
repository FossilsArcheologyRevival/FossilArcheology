package fossil.entity.mob;


import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDilophosaurus extends ModelDinosaurs
{
    ModelRenderer Head = (new ModelRenderer(this, 0, 20)).setTextureSize(64, 32);
    ModelRenderer Jaw1;
    ModelRenderer Jaw2;
    ModelRenderer Crest;
    ModelRenderer Crest2;
    ModelRenderer Crest3;
    ModelRenderer Crest4;
    ModelRenderer Neck;
    ModelRenderer UpperBody;
    ModelRenderer LowerBody;
    ModelRenderer Thigh1;
    ModelRenderer Thigh2;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Heel1;
    ModelRenderer Heel2;
    ModelRenderer Feet1;
    ModelRenderer Feet2;
    ModelRenderer UpperArm1;
    ModelRenderer UpperArm2;
    ModelRenderer LowerArm1;
    ModelRenderer LowerArm2;
    ModelRenderer Frill2;
    ModelRenderer Frill1;

    public ModelDilophosaurus()
    {
        this.Head.addBox(-3.0F, 0.0F, -6.0F, 6, 6, 6);
        this.Head.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Head.mirror = true;
        this.Jaw1 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
        this.Jaw1.addBox(-2.0F, 0.0F, -12.0F, 4, 4, 6);
        this.Jaw1.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setRotation(this.Jaw1, 0.0F, 0.0F, 0.0F);
        this.Jaw1.mirror = true;
        this.Jaw2 = (new ModelRenderer(this, 1, 10)).setTextureSize(64, 32);
        this.Jaw2.addBox(-1.5F, 4.0F, -11.0F, 3, 1, 7);
        this.Jaw2.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setRotation(this.Jaw2, 0.0F, 0.0F, 0.0F);
        this.Jaw2.mirror = true;
        this.Crest = (new ModelRenderer(this, 18, 11)).setTextureSize(64, 32);
        this.Crest.addBox(-2.0F, -4.0F, -10.0F, 0, 4, 10);
        this.Crest.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setRotation(this.Crest, 0.0F, 0.0F, 0.0F);
        this.Crest.mirror = true;
        this.Crest2 = (new ModelRenderer(this, 18, 11)).setTextureSize(64, 32);
        this.Crest2.addBox(2.0F, -4.0F, -10.0F, 0, 4, 10);
        this.Crest2.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setRotation(this.Crest2, 0.0F, 0.0F, 0.0F);
        this.Crest2.mirror = true;
        this.Crest3 = (new ModelRenderer(this, 16, -5)).setTextureSize(64, 32);
        this.Crest3.addBox(0.0F, 0.0F, 0.0F, 0, 6, 5);
        this.Crest3.setRotationPoint(-3.0F, 4.0F, -10.0F);
        this.setRotation(this.Crest3, 0.0F, -0.5235988F, 0.0F);
        this.Crest3.mirror = true;
        this.Crest4 = (new ModelRenderer(this, 16, -5)).setTextureSize(64, 32);
        this.Crest4.addBox(0.0F, 0.0F, 0.0F, 0, 6, 5);
        this.Crest4.setRotationPoint(3.0F, 4.0F, -10.0F);
        this.setRotation(this.Crest4, 0.0F, 0.5235988F, 0.0F);
        this.Crest4.mirror = true;
        this.Neck = (new ModelRenderer(this, 42, 21)).setTextureSize(64, 32);
        this.Neck.addBox(-2.0F, -1.5F, -7.0F, 4, 4, 7);
        this.Neck.setRotationPoint(0.0F, 10.0F, -6.0F);
        this.setRotation(this.Neck, -0.7063936F, 0.0F, 0.0F);
        this.Neck.mirror = true;
        this.UpperBody = (new ModelRenderer(this, 40, 0)).setTextureSize(64, 32);
        this.UpperBody.addBox(-3.0F, -3.0F, -6.5F, 6, 6, 6);
        this.UpperBody.setRotationPoint(0.0F, 11.5F, -1.0F);
        this.setRotation(this.UpperBody, -0.2602438F, 0.0F, 0.0F);
        this.UpperBody.mirror = true;
        this.LowerBody = (new ModelRenderer(this, 32, 5)).setTextureSize(64, 32);
        this.LowerBody.addBox(-4.0F, -0.5F, -4.5F, 8, 8, 8);
        this.LowerBody.setRotationPoint(0.0F, 9.0F, 2.0F);
        this.setRotation(this.LowerBody, 0.0F, 0.0F, 0.0F);
        this.LowerBody.mirror = true;
        this.Thigh1 = (new ModelRenderer(this, 24, 2)).setTextureSize(64, 32);
        this.Thigh1.addBox(0.0F, -1.5F, -2.5F, 3, 5, 5);
        this.Thigh1.setRotationPoint(4.0F, 13.0F, 3.0F);
        this.setRotation(this.Thigh1, 0.0F, 0.0F, 0.0F);
        this.Thigh1.mirror = true;
        this.Thigh2 = (new ModelRenderer(this, 24, 2)).setTextureSize(64, 32);
        this.Thigh2.addBox(-3.0F, -1.5F, -2.5F, 3, 5, 5);
        this.Thigh2.setRotationPoint(-4.0F, 13.0F, 3.0F);
        this.setRotation(this.Thigh2, 0.0F, 0.0F, 0.0F);
        this.Thigh2.mirror = true;
        this.Tail1 = (new ModelRenderer(this, 44, 0)).setTextureSize(64, 32);
        this.Tail1.addBox(-2.0F, -0.5F, 0.0F, 4, 4, 6);
        this.Tail1.setRotationPoint(0.0F, 9.0F, 5.5F);
        this.setRotation(this.Tail1, 0.0F, 0.0F, 0.0F);
        this.Tail1.mirror = true;
        this.Tail2 = (new ModelRenderer(this, 36, 0)).setTextureSize(64, 32);
        this.Tail2.addBox(-1.0F, -0.5F, 0.0F, 2, 2, 12);
        this.Tail2.setRotationPoint(0.0F, 10.0F, 11.5F);
        this.setRotation(this.Tail2, 0.0F, 0.0F, 0.0F);
        this.Tail2.mirror = true;
        this.Heel1 = (new ModelRenderer(this, 24, 12)).setTextureSize(64, 32);
        this.Heel1.addBox(0.0F, 2.0F, 2.0F, 2, 7, 2);
        this.Heel1.setRotationPoint(4.0F, 13.0F, 3.0F);
        this.setRotation(this.Heel1, -0.3717861F, 0.0F, 0.0F);
        this.Heel1.mirror = true;
        this.Heel2 = (new ModelRenderer(this, 24, 12)).setTextureSize(64, 32);
        this.Heel2.addBox(-2.0F, 2.0F, 2.0F, 2, 7, 2);
        this.Heel2.setRotationPoint(-4.0F, 13.0F, 3.0F);
        this.setRotation(this.Heel2, -0.3717861F, 0.0F, 0.0F);
        this.Heel2.mirror = true;
        this.Feet1 = (new ModelRenderer(this, 35, 21)).setTextureSize(64, 32);
        this.Feet1.addBox(0.0F, 9.0F, -3.0F, 3, 2, 4);
        this.Feet1.setRotationPoint(4.0F, 13.0F, 3.0F);
        this.setRotation(this.Feet1, 0.0F, 0.0F, 0.0F);
        this.Feet1.mirror = true;
        this.Feet2 = (new ModelRenderer(this, 35, 21)).setTextureSize(64, 32);
        this.Feet2.addBox(-3.0F, 9.0F, -3.0F, 3, 2, 4);
        this.Feet2.setRotationPoint(-4.0F, 13.0F, 3.0F);
        this.setRotation(this.Feet2, 0.0F, 0.0F, 0.0F);
        this.Feet2.mirror = true;
        this.UpperArm1 = (new ModelRenderer(this, 14, 10)).setTextureSize(64, 32);
        this.UpperArm1.addBox(0.0F, -1.0F, -2.0F, 2, 3, 3);
        this.UpperArm1.setRotationPoint(3.0F, 11.0F, -5.5F);
        this.setRotation(this.UpperArm1, 0.0F, 0.0F, 0.0F);
        this.UpperArm1.mirror = true;
        this.UpperArm2 = (new ModelRenderer(this, 14, 10)).setTextureSize(64, 32);
        this.UpperArm2.addBox(-2.0F, -1.0F, -2.0F, 2, 3, 3);
        this.UpperArm2.setRotationPoint(-3.0F, 11.0F, -5.5F);
        this.setRotation(this.UpperArm2, 0.0F, 0.0F, 0.0F);
        this.UpperArm2.mirror = true;
        this.LowerArm1 = (new ModelRenderer(this, 0, 10)).setTextureSize(64, 32);
        this.LowerArm1.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2);
        this.LowerArm1.setRotationPoint(4.0F, 11.5F, -5.5F);
        this.setRotation(this.LowerArm1, -0.2602503F, 0.0F, 0.0F);
        this.LowerArm1.mirror = true;
        this.LowerArm2 = (new ModelRenderer(this, 0, 10)).setTextureSize(64, 32);
        this.LowerArm2.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 2);
        this.LowerArm2.setRotationPoint(-4.0F, 11.5F, -5.5F);
        this.setRotation(this.LowerArm2, -0.2602503F, 0.0F, 0.0F);
        this.LowerArm2.mirror = true;
        this.Frill2 = (new ModelRenderer(this, 24, 27)).setTextureSize(64, 32);
        this.Frill2.addBox(-1.0F, 3.0F, 0.0F, 9, 5, 0);
        this.Frill2.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setRotation(this.Frill2, 0.0F, (float)Math.PI, -((float)Math.PI / 2F));
        this.Frill2.mirror = true;
        this.Frill1 = (new ModelRenderer(this, 24, 27)).setTextureSize(64, 32);
        this.Frill1.addBox(-1.0F, 3.0F, 0.0F, 9, 5, 0);
        this.Frill1.setRotationPoint(0.0F, 4.0F, -10.0F);
        this.setRotation(this.Frill1, 0.0F, 0.0F, ((float)Math.PI / 2F));
        this.Frill1.mirror = true;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.Head.render(var7);
        this.Jaw1.render(var7);
        this.Jaw2.render(var7);
        this.Crest.render(var7);
        this.Crest2.render(var7);
        this.Crest3.render(var7);
        this.Crest4.render(var7);
        this.Neck.render(var7);
        this.UpperBody.render(var7);
        this.LowerBody.render(var7);
        this.Thigh1.render(var7);
        this.Thigh2.render(var7);
        this.Tail1.render(var7);
        this.Tail2.render(var7);
        this.Heel1.render(var7);
        this.Heel2.render(var7);
        this.Feet1.render(var7);
        this.Feet2.render(var7);
        this.UpperArm1.render(var7);
        this.UpperArm2.render(var7);
        this.LowerArm1.render(var7);
        this.LowerArm2.render(var7);
        this.Frill2.render(var7);
        this.Frill1.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    public void OpenMouth(int var1)
    {
        if (this.Jaw2.rotateAngleX < 0.4363323F)
        {
            this.Jaw2.rotateAngleX += 0.4363323F / (float)var1;
        }
        else
        {
            this.Jaw2.rotateAngleX = 0.4363323F;
        }
    }

    public void CloseMouth(int var1)
    {
        if (this.Jaw2.rotateAngleX > 0.0F)
        {
            this.Jaw2.rotateAngleX -= 0.4363323F / (float)var1;
        }
        else
        {
            this.Jaw2.rotateAngleX = 0.0F;
        }
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (!var7)
        {
            this.Thigh2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.Heel2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 - 0.372F;
            this.Feet2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.Thigh1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.Heel1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2 - 0.372F;
            this.Feet1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        }
    }
}
