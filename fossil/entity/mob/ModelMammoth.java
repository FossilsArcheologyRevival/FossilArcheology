package fossil.entity.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;

public class ModelMammoth extends ModelBase
{
    ModelRenderer headmain;
    ModelRenderer buttom;
    ModelRenderer nose1;
    ModelRenderer leftArm;
    ModelRenderer rightArm;
    ModelRenderer nose2;
    ModelRenderer rightLeg;
    ModelRenderer leftLeg;
    ModelRenderer mainBody;
    ModelRenderer headHair;
    ModelRenderer HairFront;
    ModelRenderer HairBack;
    ModelRenderer rightTooth;
    ModelRenderer leftTooth;
    ModelRenderer ahoFur1;
    ModelRenderer ahoFur2;

    public ModelMammoth()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.headmain = new ModelRenderer(this, 46, 11);
        this.headmain.addBox(-2.0F, -3.0F, -3.5F, 4, 5, 5);
        this.headmain.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.headmain.setTextureSize(64, 32);
        this.headmain.mirror = true;
        this.setRotation(this.headmain, 0.0F, 0.0F, 0.0F);
        this.buttom = new ModelRenderer(this, 30, 0);
        this.buttom.addBox(-3.0F, 0.0F, 3.0F, 6, 4, 3);
        this.buttom.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.buttom.setTextureSize(64, 32);
        this.buttom.mirror = true;
        this.setRotation(this.buttom, 0.0F, 0.0F, 0.0F);
        this.nose1 = new ModelRenderer(this, 0, 21);
        this.nose1.addBox(-1.0F, 1.0F, -3.5F, 2, 4, 2);
        this.nose1.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.nose1.setTextureSize(64, 32);
        this.nose1.mirror = true;
        this.setRotation(this.nose1, -0.1897142F, 0.0F, 0.0F);
        this.leftArm = new ModelRenderer(this, 56, 0);
        this.leftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2);
        this.leftArm.setRotationPoint(1.5F, 17.0F, -1.0F);
        this.leftArm.setTextureSize(64, 32);
        this.leftArm.mirror = true;
        this.setRotation(this.leftArm, 0.0F, 0.0F, 0.0F);
        this.rightArm = new ModelRenderer(this, 48, 0);
        this.rightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2);
        this.rightArm.setRotationPoint(-1.5F, 17.0F, -1.0F);
        this.rightArm.setTextureSize(64, 32);
        this.rightArm.mirror = true;
        this.setRotation(this.rightArm, 0.0F, 0.0F, 0.0F);
        this.nose2 = new ModelRenderer(this, 0, 27);
        this.nose2.addBox(-1.0F, 5.0F, -1.5F, 2, 3, 2);
        this.nose2.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.nose2.setTextureSize(64, 32);
        this.nose2.mirror = true;
        this.setRotation(this.nose2, -0.5986789F, 0.0F, 0.0F);
        this.rightLeg = new ModelRenderer(this, 48, 0);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2);
        this.rightLeg.setRotationPoint(-1.5F, 17.0F, 4.5F);
        this.rightLeg.setTextureSize(64, 32);
        this.rightLeg.mirror = true;
        this.setRotation(this.rightLeg, 0.0F, 0.0F, 0.0F);
        this.leftLeg = new ModelRenderer(this, 56, 0);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2);
        this.leftLeg.setRotationPoint(1.5F, 17.0F, 4.5F);
        this.leftLeg.setTextureSize(64, 32);
        this.leftLeg.mirror = true;
        this.setRotation(this.leftLeg, 0.0F, 0.0F, 0.0F);
        this.mainBody = new ModelRenderer(this, 18, 20);
        this.mainBody.addBox(-3.0F, -2.0F, -3.0F, 6, 6, 6);
        this.mainBody.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.mainBody.setTextureSize(64, 32);
        this.mainBody.mirror = true;
        this.setRotation(this.mainBody, 0.0F, 0.0F, 0.0F);
        this.headHair = new ModelRenderer(this, 42, 21);
        this.headHair.addBox(-2.5F, -4.0F, -4.0F, 5, 5, 6);
        this.headHair.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.headHair.setTextureSize(64, 32);
        this.headHair.mirror = true;
        this.setRotation(this.headHair, 0.0F, 0.0F, 0.0F);
        this.HairFront = new ModelRenderer(this, 0, 0);
        this.HairFront.addBox(-3.5F, -2.5F, 0.5F, 7, 9, 7);
        this.HairFront.setRotationPoint(0.0F, 16.0F, -4.0F);
        this.HairFront.setTextureSize(64, 32);
        this.HairFront.mirror = true;
        this.setRotation(this.HairFront, 0.0F, 0.0F, 0.0F);
        this.HairBack = new ModelRenderer(this, 30, 8);
        this.HairBack.addBox(-3.0F, 4.0F, 3.0F, 6, 2, 3);
        this.HairBack.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.HairBack.setTextureSize(64, 32);
        this.HairBack.mirror = true;
        this.setRotation(this.HairBack, 0.0F, 0.0F, 0.0F);
        this.rightTooth = new ModelRenderer(this, 30, 5);
        this.rightTooth.addBox(0.0F, 1.0F, -9.5F, 0, 7, 8);
        this.rightTooth.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.rightTooth.setTextureSize(64, 32);
        this.rightTooth.mirror = true;
        this.setRotation(this.rightTooth, 0.0F, 0.0F, 0.5235988F);
        this.leftTooth = new ModelRenderer(this, 30, 5);
        this.leftTooth.addBox(0.0F, 1.0F, -9.5F, 0, 7, 8);
        this.leftTooth.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.leftTooth.setTextureSize(64, 32);
        this.leftTooth.mirror = true;
        this.setRotation(this.leftTooth, 0.0F, 0.0F, -0.5235988F);
        this.ahoFur1 = new ModelRenderer(this, 8, 24);
        this.ahoFur1.addBox(0.0F, -7.0F, -2.5F, 0, 3, 5);
        this.ahoFur1.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.ahoFur1.setTextureSize(64, 32);
        this.ahoFur1.mirror = true;
        this.setRotation(this.ahoFur1, 0.0F, ((float)Math.PI / 4F), 0.0F);
        this.ahoFur2 = new ModelRenderer(this, 8, 24);
        this.ahoFur2.addBox(0.0F, -7.0F, -2.5F, 0, 3, 5);
        this.ahoFur2.setRotationPoint(0.0F, 15.5F, -1.5F);
        this.ahoFur2.setTextureSize(64, 32);
        this.ahoFur2.mirror = true;
        this.setRotation(this.ahoFur2, 0.0F, -((float)Math.PI / 4F), 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7);
        this.headmain.render(var7);
        this.buttom.render(var7);
        this.nose1.render(var7);
        this.leftArm.render(var7);
        this.rightArm.render(var7);
        this.nose2.render(var7);
        this.rightLeg.render(var7);
        this.leftLeg.render(var7);
        this.mainBody.render(var7);
        this.headHair.render(var7);
        this.HairFront.render(var7);
        this.HairBack.render(var7);
        this.rightTooth.render(var7);
        this.leftTooth.render(var7);
        this.ahoFur1.render(var7);
        this.ahoFur2.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        this.rightArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.leftLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving var1, float var2, float var3, float var4)
    {
        EntityMammoth var5 = (EntityMammoth)var1;
        int var6 = var5.getSwingTick();

        if (var6 > 0)
        {
            this.nose1.rotateAngleX = -2.0F + 1.5F * this.func_48228_a((float)var6 - var4, 10.0F) / 3.0F - 0.1897142F;
            this.nose2.rotateAngleX = -2.0F + 1.5F * this.func_48228_a((float)var6 - var4, 10.0F) / 3.0F - 0.5986789F;
        }
        else
        {
            this.nose1.rotateAngleX = -0.1897142F;
            this.nose2.rotateAngleX = -0.5986789F;
        }
    }

    private float func_48228_a(float var1, float var2)
    {
        return (Math.abs(var1 % var2 - var2 * 0.5F) - var2 * 0.25F) / (var2 * 0.25F);
    }
}
