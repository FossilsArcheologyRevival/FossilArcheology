package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBrachiosaurus extends ModelDinosaurs
{
    ModelRenderer Snout = (new ModelRenderer(this, 50, 8)).setTextureSize(64, 32);
    ModelRenderer Head;
    ModelRenderer Crest;
    ModelRenderer Neck;
    ModelRenderer Neck1;
    ModelRenderer Neck12;
    ModelRenderer Neck121;
    ModelRenderer Neck1211;
    ModelRenderer Neck1212;
    ModelRenderer Neck12121;
    ModelRenderer Neck121211;
    ModelRenderer Lower_Neck;
    ModelRenderer Lower_Neck1;
    ModelRenderer Body;
    ModelRenderer Lower_Body;
    ModelRenderer Front_Thigh;
    ModelRenderer Front_Thigh1;
    ModelRenderer Back_CalfRight;
    ModelRenderer Front_Calf1;
    ModelRenderer Back_Thigh;
    ModelRenderer Back_Thigh1;
    ModelRenderer Front_Calf2;
    ModelRenderer Back_CalfLeft;
    ModelRenderer Tail;
    ModelRenderer Tail1;
    ModelRenderer Tail11;

    public ModelBrachiosaurus()
    {
        this.Snout.addBox(-1.5F, -1.0F, -6.5F, 3, 2, 4);
        this.Snout.setRotationPoint(0.0F, -6.0F, -11.0F);
        this.setRotation(this.Snout, 0.2617994F, 0.0F, 0.0F);
        this.Snout.mirror = true;
        this.Head = (new ModelRenderer(this, 48, 14)).setTextureSize(64, 32);
        this.Head.addBox(-2.0F, -1.0F, -4.0F, 4, 3, 4);
        this.Head.setRotationPoint(0.0F, -6.0F, -10.5F);
        this.setRotation(this.Head, 0.0F, 0.0F, 0.0F);
        this.Head.mirror = true;
        this.Crest = (new ModelRenderer(this, 52, 0)).setTextureSize(64, 32);
        this.Crest.addBox(-1.0F, -3.0F, -5.0F, 2, 4, 4);
        this.Crest.setRotationPoint(0.0F, -6.0F, -11.0F);
        this.setRotation(this.Crest, 0.0F, 0.0F, 0.0F);
        this.Crest.mirror = true;
        this.Neck = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        this.Neck.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        this.Neck.setRotationPoint(0.0F, -6.0F, -10.5F);
        this.setRotation(this.Neck, -((float)Math.PI / 4F), 0.0F, 0.0F);
        this.Neck.mirror = true;
        this.Neck1 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        this.Neck1.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        this.Neck1.setRotationPoint(0.0F, -4.5F, -9.0F);
        this.setRotation(this.Neck1, -0.9599311F, 0.0F, 0.0F);
        this.Neck1.mirror = true;
        this.Neck12 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        this.Neck12.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        this.Neck12.setRotationPoint(0.0F, -3.0F, -8.0F);
        this.setRotation(this.Neck12, -1.23464F, 0.0F, 0.0F);
        this.Neck12.mirror = true;
        this.Neck121 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        this.Neck121.addBox(-1.5F, 0.0F, 2.0F, 3, 2, 2);
        this.Neck121.setRotationPoint(0.0F, -1.5F, -7.5F);
        this.setRotation(this.Neck121, -1.343904F, 0.0F, 0.0F);
        this.Neck121.mirror = true;
        this.Neck1211 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        this.Neck1211.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 2);
        this.Neck1211.setRotationPoint(0.0F, -1.5F, -7.5F);
        this.setRotation(this.Neck1211, -1.343904F, 0.0F, 0.0F);
        this.Neck1211.mirror = true;
        this.Neck1212 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        this.Neck1212.addBox(-1.5F, 0.0F, 4.0F, 3, 2, 2);
        this.Neck1212.setRotationPoint(0.0F, -1.5F, -7.5F);
        this.setRotation(this.Neck1212, -1.343904F, 0.0F, 0.0F);
        this.Neck1212.mirror = true;
        this.Neck12121 = (new ModelRenderer(this, 22, 0)).setTextureSize(64, 32);
        this.Neck12121.addBox(-1.5F, 0.0F, 6.0F, 3, 2, 2);
        this.Neck12121.setRotationPoint(0.0F, -1.5F, -7.5F);
        this.setRotation(this.Neck12121, -1.343904F, 0.0F, 0.0F);
        this.Neck12121.mirror = true;
        this.Neck121211 = (new ModelRenderer(this, 34, 11)).setTextureSize(64, 32);
        this.Neck121211.addBox(-2.0F, -1.0F, -0.5F, 4, 3, 3);
        this.Neck121211.setRotationPoint(0.0F, 6.0F, -6.5F);
        this.setRotation(this.Neck121211, -0.9637522F, 0.0F, 0.0F);
        this.Neck121211.mirror = true;
        this.Lower_Neck = (new ModelRenderer(this, 32, 24)).setTextureSize(64, 32);
        this.Lower_Neck.addBox(-2.5F, -0.5F, -0.5F, 5, 4, 4);
        this.Lower_Neck.setRotationPoint(0.0F, 7.0F, -5.0F);
        this.setRotation(this.Lower_Neck, -0.8377581F, 0.0F, 0.0F);
        this.Lower_Neck.mirror = true;
        this.Lower_Neck1 = (new ModelRenderer(this, 10, 21)).setTextureSize(64, 32);
        this.Lower_Neck1.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 5);
        this.Lower_Neck1.setRotationPoint(0.0F, 7.0F, -5.0F);
        this.setRotation(this.Lower_Neck1, -0.3907885F, 0.0F, 0.0F);
        this.Lower_Neck1.mirror = true;
        this.Body = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
        this.Body.addBox(-4.0F, 0.0F, 0.0F, 8, 7, 6);
        this.Body.setRotationPoint(0.0F, 8.0F, -3.0F);
        this.setRotation(this.Body, -0.1115358F, 0.0F, 0.0F);
        this.Body.mirror = true;
        this.Lower_Body = (new ModelRenderer(this, 28, 0)).setTextureSize(64, 32);
        this.Lower_Body.addBox(-3.5F, 0.0F, 0.0F, 7, 6, 5);
        this.Lower_Body.setRotationPoint(0.0F, 9.0F, 2.0F);
        this.setRotation(this.Lower_Body, -0.3346075F, 0.0F, 0.0F);
        this.Lower_Body.mirror = true;
        this.Front_Thigh = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        this.Front_Thigh.addBox(0.0F, 0.0F, -2.0F, 3, 7, 4);
        this.Front_Thigh.setRotationPoint(3.0F, 12.0F, -3.5F);
        this.setRotation(this.Front_Thigh, 0.0F, 0.0F, 0.0F);
        this.Front_Thigh.mirror = true;
        this.Front_Thigh1 = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        this.Front_Thigh1.addBox(-3.0F, 0.0F, -2.0F, 3, 7, 4);
        this.Front_Thigh1.setRotationPoint(-3.0F, 12.0F, -3.5F);
        this.setRotation(this.Front_Thigh1, 0.0F, 0.0F, 0.0F);
        this.Front_Thigh1.mirror = true;
        this.Back_CalfRight = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        this.Back_CalfRight.addBox(-0.5F, 5.0F, -1.0F, 2, 5, 3);
        this.Back_CalfRight.setRotationPoint(3.0F, 14.0F, 4.5F);
        this.setRotation(this.Back_CalfRight, 0.0F, 0.0F, 0.0F);
        this.Back_CalfRight.mirror = true;
        this.Front_Calf1 = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        this.Front_Calf1.addBox(0.5F, 7.0F, -2.0F, 2, 5, 3);
        this.Front_Calf1.setRotationPoint(3.0F, 12.0F, -3.5F);
        this.setRotation(this.Front_Calf1, 0.0F, 0.0F, 0.0F);
        this.Front_Calf1.mirror = true;
        this.Back_Thigh = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        this.Back_Thigh.addBox(-2.0F, 0.0F, -2.0F, 3, 5, 4);
        this.Back_Thigh.setRotationPoint(-3.0F, 14.0F, 4.5F);
        this.setRotation(this.Back_Thigh, 0.0F, 0.0F, 0.0F);
        this.Back_Thigh.mirror = true;
        this.Back_Thigh1 = (new ModelRenderer(this, 50, 21)).setTextureSize(64, 32);
        this.Back_Thigh1.addBox(-1.0F, 0.0F, -2.0F, 3, 5, 4);
        this.Back_Thigh1.setRotationPoint(3.0F, 14.0F, 4.5F);
        this.setRotation(this.Back_Thigh1, 0.0F, 0.0F, 0.0F);
        this.Back_Thigh1.mirror = true;
        this.Front_Calf2 = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        this.Front_Calf2.addBox(-2.5F, 7.0F, -2.0F, 2, 5, 3);
        this.Front_Calf2.setRotationPoint(-3.0F, 12.0F, -3.5F);
        this.setRotation(this.Front_Calf2, 0.0F, 0.0F, 0.0F);
        this.Front_Calf2.mirror = true;
        this.Back_CalfLeft = (new ModelRenderer(this, 0, 24)).setTextureSize(64, 32);
        this.Back_CalfLeft.addBox(-1.5F, 5.0F, -1.0F, 2, 5, 3);
        this.Back_CalfLeft.setRotationPoint(-3.0F, 14.0F, 4.5F);
        this.setRotation(this.Back_CalfLeft, 0.0F, 0.0F, 0.0F);
        this.Back_CalfLeft.mirror = true;
        this.Tail = (new ModelRenderer(this, 0, 13)).setTextureSize(64, 32);
        this.Tail.addBox(-2.5F, 0.0F, 0.0F, 5, 4, 4);
        this.Tail.setRotationPoint(0.0F, 11.0F, 6.0F);
        this.setRotation(this.Tail, -0.7064018F, 0.0F, 0.0F);
        this.Tail.mirror = true;
        this.Tail1 = (new ModelRenderer(this, 18, 13)).setTextureSize(64, 32);
        this.Tail1.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 4);
        this.Tail1.setRotationPoint(0.0F, 14.0F, 8.0F);
        this.setRotation(this.Tail1, -0.5576873F, 0.0F, 0.0F);
        this.Tail1.mirror = true;
        this.Tail11 = (new ModelRenderer(this, 34, 17)).setTextureSize(64, 32);
        this.Tail11.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4);
        this.Tail11.setRotationPoint(0.0F, 16.5F, 10.5F);
        this.setRotation(this.Tail11, -0.3717943F, 0.0F, 0.0F);
        this.Tail11.mirror = true;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.Snout.render(var7);
        this.Head.render(var7);
        this.Crest.render(var7);
        this.Neck.render(var7);
        this.Neck1.render(var7);
        this.Neck12.render(var7);
        this.Neck121.render(var7);
        this.Neck1211.render(var7);
        this.Neck1212.render(var7);
        this.Neck12121.render(var7);
        this.Neck121211.render(var7);
        this.Lower_Neck.render(var7);
        this.Lower_Neck1.render(var7);
        this.Body.render(var7);
        this.Lower_Body.render(var7);
        this.Front_Thigh.render(var7);
        this.Front_Thigh1.render(var7);
        this.Back_CalfRight.render(var7);
        this.Front_Calf1.render(var7);
        this.Back_Thigh.render(var7);
        this.Back_Thigh1.render(var7);
        this.Front_Calf2.render(var7);
        this.Back_CalfLeft.render(var7);
        this.Tail.render(var7);
        this.Tail1.render(var7);
        this.Tail11.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (var7==false)
        {
            this.Front_Thigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.Front_Calf1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.Front_Thigh1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.Front_Calf2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.Back_Thigh1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.Back_CalfRight.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.Back_Thigh.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.Back_CalfLeft.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        }
    }
}
