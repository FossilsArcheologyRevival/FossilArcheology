package fossil.entity.mob;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPigBoss extends ModelBiped
{
    public ModelRenderer HornLeft;
    public ModelRenderer HornRight;
    public ModelRenderer LeftTooth;
    public ModelRenderer RightTooth;
    public ModelRenderer Mouth;
    public boolean RangedAttack;

    public ModelPigBoss()
    {
        this.isSneak = false;
        this.bipedBody = new ModelRenderer(this, 40, 18);
        this.bipedBody.addBox(-4.0F, -4.0F, -2.0F, 8, 10, 4, 0.0F);
        this.bipedBody.setRotationPoint(4.0F, 7.0F, 4.0F);
        this.bipedBody.rotateAngleX = 0.0F;
        this.bipedBody.rotateAngleY = 0.0F;
        this.bipedBody.rotateAngleZ = 0.0F;
        this.bipedBody.mirror = false;
        this.bipedRightArm = new ModelRenderer(this, 16, 0);
        this.bipedRightArm.addBox(-4.0F, -1.0F, -2.0F, 4, 10, 4, 0.0F);
        this.bipedRightArm.setRotationPoint(0.0F, 5.0F, 6.0F);
        this.bipedRightArm.rotateAngleX = 0.0F;
        this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedRightArm.mirror = false;
        this.bipedLeftArm = new ModelRenderer(this, 0, 0);
        this.bipedLeftArm.addBox(0.0F, -1.0F, -2.0F, 4, 10, 4, 0.0F);
        this.bipedLeftArm.setRotationPoint(8.0F, 4.0F, 4.0F);
        this.bipedLeftArm.rotateAngleX = 0.0F;
        this.bipedLeftArm.rotateAngleY = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.mirror = false;
        this.bipedRightLeg = new ModelRenderer(this, 47, 0);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.bipedRightLeg.setRotationPoint(2.0F, 13.0F, 4.0F);
        this.bipedRightLeg.rotateAngleX = 0.0F;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedRightLeg.rotateAngleZ = 0.0F;
        this.bipedRightLeg.mirror = false;
        this.bipedLeftLeg = new ModelRenderer(this, 47, 0);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 10, 4, 0.0F);
        this.bipedLeftLeg.setRotationPoint(6.0F, 13.0F, 4.0F);
        this.bipedLeftLeg.rotateAngleX = 0.0F;
        this.bipedLeftLeg.rotateAngleY = (float)Math.PI;
        this.bipedLeftLeg.rotateAngleZ = 0.0F;
        this.bipedLeftLeg.mirror = false;
        this.bipedHead = new ModelRenderer(this, 0, 16);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.bipedHead.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.bipedHead.rotateAngleX = 0.0F;
        this.bipedHead.rotateAngleY = 0.0F;
        this.bipedHead.rotateAngleZ = 0.0F;
        this.bipedHead.mirror = false;
        this.HornLeft = new ModelRenderer(this, 0, 17);
        this.HornLeft.addBox(2.0F, -14.0F, 3.0F, 2, 6, 1, 0.0F);
        this.HornLeft.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.HornLeft.rotateAngleX = 0.0F;
        this.HornLeft.rotateAngleY = 0.0F;
        this.HornLeft.rotateAngleZ = 0.0F;
        this.HornLeft.mirror = false;
        this.HornRight = new ModelRenderer(this, 0, 17);
        this.HornRight.addBox(-4.0F, -14.0F, 3.0F, 2, 6, 1, 0.0F);
        this.HornRight.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.HornRight.rotateAngleX = 0.0F;
        this.HornRight.rotateAngleY = 0.0F;
        this.HornRight.rotateAngleZ = 0.0F;
        this.HornRight.mirror = false;
        this.bipedHeadwear = new ModelRenderer(this, 24, 2);
        this.bipedHeadwear.addBox(-2.0F, -10.0F, -8.0F, 4, 3, 12, 0.0F);
        this.bipedHeadwear.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.bipedHeadwear.rotateAngleX = 0.0F;
        this.bipedHeadwear.rotateAngleY = 0.0F;
        this.bipedHeadwear.rotateAngleZ = 0.0F;
        this.bipedHeadwear.mirror = false;
        this.LeftTooth = new ModelRenderer(this, 0, 0);
        this.LeftTooth.addBox(2.0F, -4.0F, -6.0F, 1, 1, 1, 0.0F);
        this.LeftTooth.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.LeftTooth.rotateAngleX = 0.0F;
        this.LeftTooth.rotateAngleY = 0.0F;
        this.LeftTooth.rotateAngleZ = 0.0F;
        this.LeftTooth.mirror = false;
        this.RightTooth = new ModelRenderer(this, 0, 0);
        this.RightTooth.addBox(-3.0F, -4.0F, -6.0F, 1, 1, 1, 0.0F);
        this.RightTooth.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.RightTooth.rotateAngleX = 0.0F;
        this.RightTooth.rotateAngleY = 0.0F;
        this.RightTooth.rotateAngleZ = 0.0F;
        this.RightTooth.mirror = false;
        this.Mouth = new ModelRenderer(this, 26, 17);
        this.Mouth.addBox(-3.0F, -3.0F, -6.0F, 6, 3, 2, 0.0F);
        this.Mouth.setRotationPoint(4.0F, 3.0F, 4.0F);
        this.Mouth.rotateAngleX = 0.0F;
        this.Mouth.rotateAngleY = 0.0F;
        this.Mouth.rotateAngleZ = 0.0F;
        this.Mouth.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        this.bipedBody.render(var7);
        this.bipedRightArm.render(var7);
        this.bipedLeftArm.render(var7);
        this.bipedRightLeg.render(var7);
        this.bipedLeftLeg.render(var7);
        this.bipedHead.render(var7);
        this.HornLeft.render(var7);
        this.HornRight.render(var7);
        this.bipedHeadwear.render(var7);
        this.LeftTooth.render(var7);
        this.RightTooth.render(var7);
        this.Mouth.render(var7);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
    {
        this.bipedHead.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.bipedHead.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;

        if (this.heldItemLeft != 0)
        {
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
        }

        if (this.heldItemRight != 0)
        {
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
        }

        this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedLeftArm.rotateAngleY = 0.0F;

        if (this.onGround > -9990.0F)
        {
            float var8 = this.onGround;
            this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var8) * (float)Math.PI * 2.0F) * 0.2F;
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
            var8 = 1.0F - this.onGround;
            var8 *= var8;
            var8 *= var8;
            var8 = 1.0F - var8;
            float var9 = MathHelper.sin(var8 * (float)Math.PI);
            float var10 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
            this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)var9 * 1.2D + (double)var10));
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
            this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
        }

        this.bipedRightArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.HornLeft.rotateAngleX = this.HornRight.rotateAngleX = this.bipedHeadwear.rotateAngleX;
        this.HornLeft.rotateAngleY = this.HornRight.rotateAngleY = this.bipedHeadwear.rotateAngleY;
        this.Mouth.rotateAngleX = this.bipedHead.rotateAngleX;
        this.Mouth.rotateAngleY = this.bipedHead.rotateAngleY;
        this.LeftTooth.rotateAngleX = this.RightTooth.rotateAngleX = this.bipedHead.rotateAngleX;
        this.LeftTooth.rotateAngleY = this.RightTooth.rotateAngleY = this.bipedHead.rotateAngleY;

        if (this.RangedAttack)
        {
            this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
            this.bipedRightArm.rotateAngleY = this.bipedHead.rotateAngleY;
        }
    }
}
