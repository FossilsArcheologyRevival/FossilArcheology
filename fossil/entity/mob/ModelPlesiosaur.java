package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;

public class ModelPlesiosaur extends ModelDinosaurs
{
    ModelRenderer Body = new ModelRenderer(this, 0, 0);
    ModelRenderer Neck1;
    ModelRenderer tail3;
    ModelRenderer tail2;
    ModelRenderer tail1;
    ModelRenderer Neck2;
    ModelRenderer Neck3;
    ModelRenderer Neck4;
    ModelRenderer head;
    ModelRenderer right_arm;
    ModelRenderer left_arm;
    ModelRenderer right_leg;
    ModelRenderer left_leg;
    public boolean LandFlag = false;

    public ModelPlesiosaur()
    {
        this.Body.addBox(-4.0F, -4.0F, -4.0F, 8, 6, 8);
        this.Body.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.Body.rotateAngleX = 0.0F;
        this.Body.rotateAngleY = 0.0F;
        this.Body.rotateAngleZ = 0.0F;
        this.Body.mirror = false;
        this.Neck1 = new ModelRenderer(this, 20, 23);
        this.Neck1.addBox(-3.0F, 0.0F, -4.0F, 6, 5, 4);
        this.Neck1.setRotationPoint(0.0F, 17.0F, 0.0F);
        this.Neck1.rotateAngleX = -0.99446F;
        this.Neck1.rotateAngleY = 0.0F;
        this.Neck1.rotateAngleZ = 0.0F;
        this.Neck1.mirror = false;
        this.tail3 = new ModelRenderer(this, 24, 0);
        this.tail3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6);
        this.tail3.setRotationPoint(0.0F, 21.0F, 11.0F);
        this.tail3.rotateAngleX = -0.18081F;
        this.tail3.rotateAngleY = 0.0F;
        this.tail3.rotateAngleZ = 0.0F;
        this.tail3.mirror = false;
        this.tail2 = new ModelRenderer(this, 18, 14);
        this.tail2.addBox(-2.0F, -2.0F, 0.0F, 4, 3, 6);
        this.tail2.setRotationPoint(0.0F, 20.0F, 5.0F);
        this.tail2.rotateAngleX = -0.27122F;
        this.tail2.rotateAngleY = 0.0F;
        this.tail2.rotateAngleZ = 0.0F;
        this.tail2.mirror = false;
        this.tail1 = new ModelRenderer(this, 0, 14);
        this.tail1.addBox(-3.0F, -5.0F, 2.0F, 6, 5, 3);
        this.tail1.setRotationPoint(0.0F, 20.0F, 0.0F);
        this.tail1.rotateAngleX = -0.45203F;
        this.tail1.rotateAngleY = 0.0F;
        this.tail1.rotateAngleZ = 0.0F;
        this.tail1.mirror = false;
        this.Neck2 = new ModelRenderer(this, 47, 23);
        this.Neck2.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 5);
        this.Neck2.setRotationPoint(0.0F, 16.0F, -4.0F);
        this.Neck2.rotateAngleX = -0.88974F;
        this.Neck2.rotateAngleY = 0.0F;
        this.Neck2.rotateAngleZ = 0.0F;
        this.Neck2.mirror = false;
        this.Neck3 = new ModelRenderer(this, 35, 3);
        this.Neck3.addBox(-1.0F, -2.0F, -5.0F, 2, 3, 5);
        this.Neck3.setRotationPoint(0.0F, 12.73333F, -8.0F);
        this.Neck3.rotateAngleX = -0.58764F;
        this.Neck3.rotateAngleY = 0.0F;
        this.Neck3.rotateAngleZ = 0.0F;
        this.Neck3.mirror = false;
        this.Neck4 = new ModelRenderer(this, 35, 3);
        this.Neck4.addBox(-1.0F, -2.0F, -5.0F, 2, 3, 5);
        this.Neck4.setRotationPoint(0.0F, 10.0F, -11.0F);
        this.Neck4.rotateAngleX = -0.13561F;
        this.Neck4.rotateAngleY = 0.0F;
        this.Neck4.rotateAngleZ = 0.0F;
        this.Neck4.mirror = false;
        this.head = new ModelRenderer(this, 0, 22);
        this.head.addBox(-2.0F, -2.0F, -6.0F, 4, 4, 6);
        this.head.setRotationPoint(0.0F, 9.0F, -15.0F);
        this.head.rotateAngleX = 0.49723F;
        this.head.rotateAngleY = 0.0F;
        this.head.rotateAngleZ = 0.0F;
        this.head.mirror = false;
        this.right_arm = new ModelRenderer(this, 44, 13);
        this.right_arm.addBox(0.0F, 0.0F, 0.0F, 6, 1, 4);
        this.right_arm.setRotationPoint(-3.0F, 21.0F, -3.0F);
        this.right_arm.rotateAngleX = -0.5236F;
        this.right_arm.rotateAngleY = -2.35619F;
        this.right_arm.rotateAngleZ = 0.0F;
        this.right_arm.mirror = false;
        this.left_arm = new ModelRenderer(this, 44, 18);
        this.left_arm.addBox(0.0F, 0.0F, -4.0F, 6, 1, 4);
        this.left_arm.setRotationPoint(3.0F, 21.0F, -3.0F);
        this.left_arm.rotateAngleX = 0.5236F;
        this.left_arm.rotateAngleY = -0.7854F;
        this.left_arm.rotateAngleZ = 0.0F;
        this.left_arm.mirror = true;
        this.right_leg = new ModelRenderer(this, 48, 0);
        this.right_leg.addBox(0.0F, 0.0F, 0.0F, 5, 1, 3);
        this.right_leg.setRotationPoint(-3.0F, 21.0F, 4.0F);
        this.right_leg.rotateAngleX = -0.5236F;
        this.right_leg.rotateAngleY = -2.0944F;
        this.right_leg.rotateAngleZ = 0.0F;
        this.right_leg.mirror = false;
        this.left_leg = new ModelRenderer(this, 48, 4);
        this.left_leg.addBox(0.0F, 0.0F, -3.0F, 5, 1, 3);
        this.left_leg.setRotationPoint(3.0F, 21.0F, 4.0F);
        this.left_leg.rotateAngleX = 0.5236F;
        this.left_leg.rotateAngleY = -1.0472F;
        this.left_leg.rotateAngleZ = 0.0F;
        this.left_leg.mirror = false;
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
        this.tail3.render(var7);
        this.tail2.render(var7);
        this.tail1.render(var7);
        this.Neck2.render(var7);
        this.Neck3.render(var7);
        this.Neck4.render(var7);
        this.head.render(var7);
        this.right_arm.render(var7);
        this.left_arm.render(var7);
        this.right_leg.render(var7);
        this.left_leg.render(var7);
    }

    public boolean WaveTail(float var1, boolean var2, int var3)
    {
        boolean var6 = false;

        if (var1 < 0.0F)
        {
            return false;
        }
        else if (var3 <= 0)
        {
            return false;
        }
        else
        {
            boolean var4;
            boolean var5;
            float var7;

            if (var2)
            {
                if (this.tail1.rotateAngleY < var1)
                {
                    this.tail1.rotateAngleY += var1 / (float)var3;
                }
                else
                {
                    this.tail1.rotateAngleY = var1;
                }

                var4 = this.tail1.rotateAngleY >= var1;
                var7 = var1 + var1;

                if (!var4)
                {
                    this.tail2.rotationPointX = (float)((double)(this.tail2.rotationPointX - this.tail1.rotationPointX) * Math.cos((double)(-(var7 / (float)var3))) - (double)(this.tail2.rotationPointZ - this.tail1.rotationPointZ) * Math.sin((double)(-(var7 / (float)var3))) + (double)this.tail1.rotationPointX);
                    this.tail2.rotationPointZ = (float)((double)(this.tail2.rotationPointX - this.tail1.rotationPointX) * Math.sin((double)(-(var7 / (float)var3))) + (double)(this.tail2.rotationPointZ - this.tail1.rotationPointZ) * Math.cos((double)(-(var7 / (float)var3))) + (double)this.tail1.rotationPointZ);
                }

                if (this.tail2.rotateAngleY < var7)
                {
                    this.tail2.rotateAngleY += var7 / (float)var3;
                }
                else
                {
                    this.tail2.rotateAngleY = var7;
                }

                var5 = this.tail2.rotateAngleY >= var7;
                var7 += var1;

                if (!var5)
                {
                    this.tail3.rotationPointX = (float)((double)(this.tail3.rotationPointX - this.tail2.rotationPointX) * Math.cos((double)(-(var7 / (float)var3))) - (double)(this.tail3.rotationPointZ - this.tail2.rotationPointZ) * Math.sin((double)(-(var7 / (float)var3))) + (double)this.tail2.rotationPointX);
                    this.tail3.rotationPointZ = (float)((double)(this.tail3.rotationPointX - this.tail2.rotationPointX) * Math.sin((double)(-(var7 / (float)var3))) + (double)(this.tail3.rotationPointZ - this.tail2.rotationPointZ) * Math.cos((double)(-(var7 / (float)var3))) + (double)this.tail2.rotationPointZ);
                }

                if (this.tail3.rotateAngleY < var7)
                {
                    this.tail3.rotateAngleY += var7 / (float)var3;
                }
                else
                {
                    this.tail3.rotateAngleY = var7;
                }

                var6 = this.tail3.rotateAngleY >= var7;
            }
            else
            {
                var7 = -var1;

                if (this.tail1.rotateAngleY > var7)
                {
                    this.tail1.rotateAngleY += var7 / (float)var3;
                }
                else
                {
                    this.tail1.rotateAngleY = var7;
                }

                var4 = this.tail1.rotateAngleY <= var7;
                var7 -= var1;

                if (!var4)
                {
                    this.tail2.rotationPointX = (float)((double)(this.tail2.rotationPointX - this.tail1.rotationPointX) * Math.cos((double)(-(var7 / (float)var3))) - (double)(this.tail2.rotationPointZ - this.tail1.rotationPointZ) * Math.sin((double)(-(var7 / (float)var3))) + (double)this.tail1.rotationPointX);
                    this.tail2.rotationPointZ = (float)((double)(this.tail2.rotationPointX - this.tail1.rotationPointX) * Math.sin((double)(-(var7 / (float)var3))) + (double)(this.tail2.rotationPointZ - this.tail1.rotationPointZ) * Math.cos((double)(-(var7 / (float)var3))) + (double)this.tail1.rotationPointZ);
                }

                if (this.tail2.rotateAngleY > var7)
                {
                    this.tail2.rotateAngleY += var7 / (float)var3;
                }
                else
                {
                    this.tail2.rotateAngleY = var7;
                }

                var5 = this.tail2.rotateAngleY <= var7;
                var7 -= var1;

                if (!var5)
                {
                    this.tail3.rotationPointX = (float)((double)(this.tail3.rotationPointX - this.tail2.rotationPointX) * Math.cos((double)(-(var7 / (float)var3))) - (double)(this.tail3.rotationPointZ - this.tail2.rotationPointZ) * Math.sin((double)(-(var7 / (float)var3))) + (double)this.tail2.rotationPointX);
                    this.tail3.rotationPointZ = (float)((double)(this.tail3.rotationPointX - this.tail2.rotationPointX) * Math.sin((double)(-(var7 / (float)var3))) + (double)(this.tail3.rotationPointZ - this.tail2.rotationPointZ) * Math.cos((double)(-(var7 / (float)var3))) + (double)this.tail2.rotationPointZ);
                }

                if (this.tail3.rotateAngleY > var7)
                {
                    this.tail3.rotateAngleY += var7 / (float)var3;
                }
                else
                {
                    this.tail3.rotateAngleY = var7;
                }

                var6 = this.tail3.rotateAngleY <= var7;
            }

            return var4 && var5 && var6;
        }
    }

    public void ReturnTail()
    {
        this.tail1.rotateAngleY = this.tail2.rotateAngleY = this.tail3.rotateAngleY = 0.0F;
        this.tail1.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.tail2.setRotationPoint(0.0F, 19.0F, 5.0F);
        this.tail3.setRotationPoint(0.0F, 19.0F, 11.0F);
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {}

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving var1, float var2, float var3, float var4)
    {
        if (!((EntityDinosaurce)var1).isModelized())
        {
            EntityPlesiosaur var5 = (EntityPlesiosaur)var1;
            int var6 = 16 + var5.getDinoAge();

            if (var5.riddenByEntity != null && !var5.isOnSurface())
            {
                this.PoseDive(var6);
            }
            else
            {
                this.PoseSurface(var6);
            }
        }
    }

    public boolean PoseDive(int var1)
    {
        boolean var2 = true;

        if (this.Neck1.rotateAngleX < -0.453F)
        {
            this.Neck1.rotateAngleX += 0.541F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck1.rotateAngleX = -0.453F;
        }

        if (this.Neck2.rotateAngleX < -0.174F)
        {
            this.Neck2.rotateAngleX += 0.71599996F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck2.rotateAngleX = -0.174F;
        }

        if (this.Neck2.rotationPointY < 18.0F)
        {
            this.Neck2.rotationPointY += 2.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck2.rotationPointY = 18.0F;
        }

        if (this.Neck2.rotationPointZ < -3.0F)
        {
            this.Neck2.rotationPointZ += 1.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck2.rotationPointZ = -3.0F;
        }

        if (this.Neck3.rotateAngleX < -0.116F)
        {
            this.Neck3.rotateAngleX += 0.472F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck3.rotateAngleX = -0.116F;
        }

        if (this.Neck3.rotationPointY < 17.7F)
        {
            this.Neck3.rotationPointY += 5.000001F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck3.rotationPointY = 17.7F;
        }

        if (this.Neck3.rotationPointZ > -9.0F)
        {
            this.Neck3.rotationPointZ -= 1.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck3.rotationPointZ = -9.0F;
        }

        if (this.Neck4.rotateAngleX < -0.013F)
        {
            this.Neck4.rotateAngleX += 0.12300001F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck4.rotateAngleX = -0.013F;
        }

        if (this.Neck4.rotationPointY < 17.0F)
        {
            this.Neck4.rotationPointY += 7.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck4.rotationPointY = 17.0F;
        }

        if (this.Neck4.rotationPointZ > -13.0F)
        {
            this.Neck4.rotationPointZ -= 2.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck4.rotationPointZ = -13.0F;
        }

        if (this.head.rotateAngleX > 0.009F)
        {
            this.head.rotateAngleX -= 0.488F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.head.rotateAngleX = 0.009F;
        }

        if (this.head.rotationPointY < 16.0F)
        {
            this.head.rotationPointY += 7.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.head.rotationPointY = 16.0F;
        }

        if (this.head.rotationPointZ > -18.0F)
        {
            this.head.rotationPointZ -= 3.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.head.rotationPointZ = -18.0F;
        }

        return var2;
    }

    public boolean PoseSurface(int var1)
    {
        boolean var2 = true;

        if (this.Neck1.rotateAngleX > -0.994F)
        {
            this.Neck1.rotateAngleX -= 0.541F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck1.rotateAngleX = -0.994F;
        }

        if (this.Neck2.rotateAngleX > -0.89F)
        {
            this.Neck2.rotateAngleX -= 0.71599996F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck2.rotateAngleX = -0.89F;
        }

        if (this.Neck2.rotationPointY > 16.0F)
        {
            this.Neck2.rotationPointY -= 2.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck2.rotationPointY = 16.0F;
        }

        if (this.Neck2.rotationPointZ > -4.0F)
        {
            this.Neck2.rotationPointZ -= 1.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck2.rotationPointZ = -4.0F;
        }

        if (this.Neck3.rotateAngleX > -0.588F)
        {
            this.Neck3.rotateAngleX -= 0.472F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck3.rotateAngleX = -0.588F;
        }

        if (this.Neck3.rotationPointY > 12.7F)
        {
            this.Neck3.rotationPointY -= 5.000001F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck3.rotationPointY = 12.7F;
        }

        if (this.Neck3.rotationPointZ < -8.0F)
        {
            this.Neck3.rotationPointZ += 1.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck3.rotationPointZ = -8.0F;
        }

        if (this.Neck4.rotateAngleX > -0.136F)
        {
            this.Neck4.rotateAngleX -= 0.12300001F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck4.rotateAngleX = -0.136F;
        }

        if (this.Neck4.rotationPointY > 10.0F)
        {
            this.Neck4.rotationPointY -= 7.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck4.rotationPointY = 10.0F;
        }

        if (this.Neck4.rotationPointZ < -11.0F)
        {
            this.Neck4.rotationPointZ += 2.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.Neck4.rotationPointZ = -11.0F;
        }

        if (this.head.rotateAngleX < 0.497F)
        {
            this.head.rotateAngleX += 0.488F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.head.rotateAngleX = 0.497F;
        }

        if (this.head.rotationPointY > 9.0F)
        {
            this.head.rotationPointY -= 7.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.head.rotationPointY = 9.0F;
        }

        if (this.head.rotationPointZ < -15.0F)
        {
            this.head.rotationPointZ += 3.0F / (float)var1;
            var2 &= false;
        }
        else
        {
            this.head.rotationPointZ = -15.0F;
        }

        return var2;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (var7==false)
        {
            this.right_arm.rotateAngleY = (float)((double)MathHelper.cos(var1 / 0.95955384F) * (Math.PI / 4D) * (double)var2 + -2.35619449019234D);
            this.right_leg.rotateAngleY = (float)((double)MathHelper.cos(var1 / 0.95955384F) * (Math.PI / 4D) * (double)var2 + -2.0943951023932D);

            if (this.LandFlag)
            {
                this.left_arm.rotateAngleY = (float)((double)MathHelper.cos(var1 / 0.95955384F) * (Math.PI / 4D) * (double)var2 + -(Math.PI / 4D));
                this.left_leg.rotateAngleY = (float)((double)MathHelper.cos(var1 / 0.95955384F) * (Math.PI / 4D) * (double)var2 + -1.0471975511966D);
            }
            else
            {
                this.left_arm.rotateAngleY = (float)((double)MathHelper.cos(var1 / 0.95955384F) * -(Math.PI / 4D) * (double)var2 + -(Math.PI / 4D));
                this.left_leg.rotateAngleY = (float)((double)MathHelper.cos(var1 / 0.95955384F) * -(Math.PI / 4D) * (double)var2 + -1.0471975511966D);
            }
        }
    }
}
