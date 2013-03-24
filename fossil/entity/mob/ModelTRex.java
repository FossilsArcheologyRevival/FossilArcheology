package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTRex extends ModelDinosaurs
{
    final float SwingAngle = 0.174533F;
    public ModelRenderer noumenon_1 = new ModelRenderer(this, 4, 2);
    public ModelRenderer noumenon_2;
    public ModelRenderer hand_R;
    public ModelRenderer hand_L;
    public ModelRenderer foot_R_1;
    public ModelRenderer noumenon_3;
    public ModelRenderer noumenon_4;
    public ModelRenderer foot_R_2;
    public ModelRenderer foot_R_3;
    public ModelRenderer foot_L_1;
    public ModelRenderer foot_L_2;
    public ModelRenderer foot_L_3;
    public ModelRenderer noumenon_5;
    public ModelRenderer head_1;
    public ModelRenderer head_2;
    public ModelRenderer head_3;
    public ModelRenderer New_Shape10;

    public ModelTRex()
    {
        this.noumenon_1.addBox(-3.0F, 0.0F, -10.0F, 6, 8, 10, 0.0F);
        this.noumenon_1.setRotationPoint(0.0F, 9.0F, -1.0F);
        this.noumenon_1.rotateAngleX = -0.9948377F;
        this.noumenon_1.rotateAngleY = 0.0F;
        this.noumenon_1.rotateAngleZ = 0.0F;
        this.noumenon_1.mirror = false;
        this.noumenon_2 = new ModelRenderer(this, 1, 0);
        this.noumenon_2.addBox(-5.0F, 0.0F, -6.0F, 8, 11, 12, 0.0F);
        this.noumenon_2.setRotationPoint(1.0F, 6.0F, 2.0F);
        this.noumenon_2.rotateAngleX = -0.4068249F;
        this.noumenon_2.rotateAngleY = 0.0F;
        this.noumenon_2.rotateAngleZ = 0.0F;
        this.noumenon_2.mirror = false;
        this.hand_R = new ModelRenderer(this, 34, 0);
        this.hand_R.addBox(-2.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
        this.hand_R.setRotationPoint(-2.0F, 10.0F, -9.0F);
        this.hand_R.rotateAngleX = 0.6328388F;
        this.hand_R.rotateAngleY = 0.0F;
        this.hand_R.rotateAngleZ = 0.0F;
        this.hand_R.mirror = false;
        this.hand_L = new ModelRenderer(this, 34, 0);
        this.hand_L.addBox(0.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
        this.hand_L.setRotationPoint(2.0F, 10.0F, -9.0F);
        this.hand_L.rotateAngleX = 0.6328388F;
        this.hand_L.rotateAngleY = 0.0F;
        this.hand_L.rotateAngleZ = 0.0F;
        this.hand_L.mirror = false;
        this.foot_R_1 = new ModelRenderer(this, 40, 2);
        this.foot_R_1.addBox(-4.0F, -4.0F, -4.0F, 4, 8, 8, 0.0F);
        this.foot_R_1.setRotationPoint(-4.0F, 14.0F, 2.0F);
        this.foot_R_1.rotateAngleX = 0.0F;
        this.foot_R_1.rotateAngleY = 0.0F;
        this.foot_R_1.rotateAngleZ = 0.0F;
        this.foot_R_1.mirror = false;
        this.noumenon_3 = new ModelRenderer(this, 4, 4);
        this.noumenon_3.addBox(-3.0F, 0.0F, 0.0F, 6, 5, 10, 0.0F);
        this.noumenon_3.setRotationPoint(0.0F, 8.0F, 6.0F);
        this.noumenon_3.rotateAngleX = -0.7684471F;
        this.noumenon_3.rotateAngleY = 0.0F;
        this.noumenon_3.rotateAngleZ = 0.0F;
        this.noumenon_3.mirror = false;
        this.noumenon_4 = new ModelRenderer(this, 5, 2);
        this.noumenon_4.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 10, 0.0F);
        this.noumenon_4.setRotationPoint(0.0F, 15.0F, 12.0F);
        this.noumenon_4.rotateAngleX = -0.5424333F;
        this.noumenon_4.rotateAngleY = 0.0F;
        this.noumenon_4.rotateAngleZ = 0.0F;
        this.noumenon_4.mirror = false;
        this.foot_R_2 = new ModelRenderer(this, 0, 9);
        this.foot_R_2.addBox(-2.0F, 0.0F, 3.0F, 2, 8, 3, 0.0F);
        this.foot_R_2.setRotationPoint(-4.0F, 14.0F, 2.0F);
        this.foot_R_2.rotateAngleX = -0.6108652F;
        this.foot_R_2.rotateAngleY = 0.0F;
        this.foot_R_2.rotateAngleZ = 0.0F;
        this.foot_R_2.mirror = false;
        this.foot_R_3 = new ModelRenderer(this, 36, 0);
        this.foot_R_3.addBox(-3.0F, 8.0F, -5.0F, 3, 2, 8, 0.0F);
        this.foot_R_3.setRotationPoint(-4.0F, 14.0F, 2.0F);
        this.foot_R_3.rotateAngleX = 0.0F;
        this.foot_R_3.rotateAngleY = 0.0F;
        this.foot_R_3.rotateAngleZ = 0.0F;
        this.foot_R_3.mirror = false;
        this.foot_L_1 = new ModelRenderer(this, 40, 2);
        this.foot_L_1.addBox(0.0F, -4.0F, -4.0F, 4, 8, 8, 0.0F);
        this.foot_L_1.setRotationPoint(4.0F, 14.0F, 2.0F);
        this.foot_L_1.rotateAngleX = 0.0F;
        this.foot_L_1.rotateAngleY = 0.0F;
        this.foot_L_1.rotateAngleZ = 0.0F;
        this.foot_L_1.mirror = false;
        this.foot_L_2 = new ModelRenderer(this, 0, 9);
        this.foot_L_2.addBox(0.0F, 0.0F, 3.0F, 2, 8, 3, 0.0F);
        this.foot_L_2.setRotationPoint(4.0F, 14.0F, 2.0F);
        this.foot_L_2.rotateAngleX = -0.6108652F;
        this.foot_L_2.rotateAngleY = 0.0F;
        this.foot_L_2.rotateAngleZ = 0.0F;
        this.foot_L_2.mirror = false;
        this.foot_L_3 = new ModelRenderer(this, 36, 0);
        this.foot_L_3.addBox(0.0F, 8.0F, -5.0F, 3, 2, 8, 0.0F);
        this.foot_L_3.setRotationPoint(4.0F, 14.0F, 2.0F);
        this.foot_L_3.rotateAngleX = 0.0F;
        this.foot_L_3.rotateAngleY = 0.0F;
        this.foot_L_3.rotateAngleZ = 0.0F;
        this.foot_L_3.mirror = false;
        this.noumenon_5 = new ModelRenderer(this, 10, 6);
        this.noumenon_5.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 6, 0.0F);
        this.noumenon_5.setRotationPoint(0.0F, 20.0F, 19.0F);
        this.noumenon_5.rotateAngleX = -0.3616222F;
        this.noumenon_5.rotateAngleY = 0.0F;
        this.noumenon_5.rotateAngleZ = 0.0F;
        this.noumenon_5.mirror = false;
        this.head_1 = new ModelRenderer(this, 0, 16);
        this.head_1.addBox(-4.0F, 0.0F, -6.0F, 8, 8, 6, 0.0F);
        this.head_1.setRotationPoint(0.0F, 0.0F, -8.0F);
        this.head_1.rotateAngleX = -7.905835E-16F;
        this.head_1.rotateAngleY = 0.0F;
        this.head_1.rotateAngleZ = 0.0F;
        this.head_1.mirror = false;
        this.head_2 = new ModelRenderer(this, 34, 18);
        this.head_2.addBox(-4.0F, 1.0F, -11.0F, 6, 6, 8, 0.0F);
        this.head_2.setRotationPoint(1.0F, 0.0F, -8.0F);
        this.head_2.rotateAngleX = 0.0F;
        this.head_2.rotateAngleY = 0.0F;
        this.head_2.rotateAngleZ = 0.0F;
        this.head_2.mirror = false;
        this.head_3 = new ModelRenderer(this, 13, 23);
        this.head_3.addBox(-4.0F, 6.0F, -10.0F, 4, 2, 7, 0.0F);
        this.head_3.setRotationPoint(2.0F, 1.0F, -8.0F);
        this.head_3.rotateAngleX = 0.0F;
        this.head_3.rotateAngleY = 0.0F;
        this.head_3.rotateAngleZ = 0.0F;
        this.head_3.mirror = false;
        this.New_Shape10 = new ModelRenderer(this, 0, 0);
        this.New_Shape10.addBox(-1.0F, -2.0F, -2.0F, 2, 2, 3, 0.0F);
        this.New_Shape10.setRotationPoint(0.0F, 10.0F, -8.0F);
        this.New_Shape10.rotateAngleX = 2.181662F;
        this.New_Shape10.rotateAngleY = 0.0F;
        this.New_Shape10.rotateAngleZ = 0.0F;
        this.New_Shape10.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.noumenon_1.render(var7);
        this.noumenon_2.render(var7);
        this.hand_R.render(var7);
        this.hand_L.render(var7);
        this.foot_R_1.render(var7);
        this.noumenon_3.render(var7);
        this.noumenon_4.render(var7);
        this.foot_R_2.render(var7);
        this.foot_R_3.render(var7);
        this.foot_L_1.render(var7);
        this.foot_L_2.render(var7);
        this.foot_L_3.render(var7);
        this.noumenon_5.render(var7);
        this.head_1.render(var7);
        this.head_2.render(var7);
        this.head_3.render(var7);
        this.New_Shape10.render(var7);
    }

    private double GetDistance(ModelRenderer var1, ModelRenderer var2)
    {
        return Math.sqrt(Math.pow((double)(var1.rotationPointX - var2.rotationPointX), 2.0D) + Math.pow((double)(var1.rotationPointY - var2.rotationPointY), 2.0D) + Math.pow((double)(var1.rotationPointZ - var2.rotationPointZ), 2.0D));
    }

    public void RunPose()
    {
        this.RunPose(20.0F);
    }

    public void RunPose(float var1)
    {
        if (this.noumenon_1.rotationPointY > 7.0F)
        {
            this.noumenon_1.rotationPointY -= 2.0F / var1;
        }
        else
        {
            this.noumenon_1.rotationPointY = 7.0F;
        }

        if (this.noumenon_1.rotationPointZ > -4.0F)
        {
            this.noumenon_1.rotationPointZ -= 3.0F / var1;
        }
        else
        {
            this.noumenon_1.rotationPointZ = -4.0F;
        }

        if (this.noumenon_1.rotateAngleX < 0.0F)
        {
            this.noumenon_1.rotateAngleX += 0.9948377F / var1;
        }
        else
        {
            this.noumenon_1.rotateAngleX = 0.0F;
        }

        if (this.noumenon_2.rotationPointZ > 0.0F)
        {
            this.noumenon_2.rotationPointZ -= 2.0F / var1;
        }
        else
        {
            this.noumenon_2.rotationPointZ = 0.0F;
        }

        if (this.noumenon_2.rotateAngleX < 0.0F)
        {
            this.noumenon_2.rotateAngleX += 0.4068249F / var1;
        }
        else
        {
            this.noumenon_2.rotateAngleX = 0.0F;
        }

        if (this.hand_R.rotationPointY < 14.0F)
        {
            this.hand_R.rotationPointY += 4.0F / var1;
        }
        else
        {
            this.hand_R.rotationPointY = 14.0F;
        }

        if (this.hand_L.rotationPointY < 14.0F)
        {
            this.hand_L.rotationPointY += 4.0F / var1;
        }
        else
        {
            this.hand_L.rotationPointY = 14.0F;
        }

        if (this.noumenon_3.rotateAngleX < -0.2260139F)
        {
            this.noumenon_3.rotateAngleX += 0.5424332F / var1;
        }
        else
        {
            this.noumenon_3.rotateAngleX = -0.2260139F;
        }

        if (this.noumenon_4.rotationPointY > 11.0F)
        {
            this.noumenon_4.rotationPointY -= 4.0F / var1;
        }
        else
        {
            this.noumenon_4.rotationPointY = 11.0F;
        }

        if (this.noumenon_4.rotationPointZ < 14.0F)
        {
            this.noumenon_4.rotationPointZ += 2.0F / var1;
        }
        else
        {
            this.noumenon_4.rotationPointZ = 14.0F;
        }

        if (this.noumenon_4.rotateAngleX < -0.1356083F)
        {
            this.noumenon_4.rotateAngleX += 0.406825F / var1;
        }
        else
        {
            this.noumenon_4.rotateAngleX = -0.1356083F;
        }

        if (this.noumenon_5.rotationPointY > 13.0F)
        {
            this.noumenon_5.rotationPointY -= 7.0F / var1;
        }
        else
        {
            this.noumenon_5.rotationPointY = 13.0F;
        }

        if (this.noumenon_5.rotationPointZ < 22.0F)
        {
            this.noumenon_5.rotationPointZ += 3.0F / var1;
        }
        else
        {
            this.noumenon_5.rotationPointZ = 22.0F;
        }

        if (this.noumenon_5.rotateAngleX < 0.0F)
        {
            this.noumenon_5.rotateAngleX += 0.3616222F / var1;
        }
        else
        {
            this.noumenon_5.rotateAngleX = 0.0F;
        }

        if (this.head_1.rotationPointY < 7.0F)
        {
            this.head_1.rotationPointY += 7.0F / var1;
        }
        else
        {
            this.head_1.rotationPointY = 7.0F;
        }

        if (this.head_1.rotationPointZ > -14.0F)
        {
            this.head_1.rotationPointZ -= 6.0F / var1;
        }
        else
        {
            this.head_1.rotationPointZ = -14.0F;
        }

        if (this.head_2.rotationPointY < 7.0F)
        {
            this.head_2.rotationPointY += 7.0F / var1;
        }
        else
        {
            this.head_2.rotationPointY = 7.0F;
        }

        if (this.head_2.rotationPointZ > -14.0F)
        {
            this.head_2.rotationPointZ -= 6.0F / var1;
        }
        else
        {
            this.head_2.rotationPointZ = -14.0F;
        }

        if (this.head_3.rotationPointY < 7.0F)
        {
            this.head_3.rotationPointY += 6.0F / var1;
        }
        else
        {
            this.head_3.rotationPointY = 7.0F;
        }

        if (this.head_3.rotationPointZ > -14.0F)
        {
            this.head_3.rotationPointZ -= 6.0F / var1;
        }
        else
        {
            this.head_3.rotationPointZ = -14.0F;
        }
    }

    public void StandPose()
    {
        this.StandPose(20.0F);
    }

    public void StandPose(float var1)
    {
        if (this.noumenon_1.rotationPointY < 9.0F)
        {
            this.noumenon_1.rotationPointY += 2.0F / var1;
        }
        else
        {
            this.noumenon_1.rotationPointY = 9.0F;
        }

        if (this.noumenon_1.rotationPointZ < -1.0F)
        {
            this.noumenon_1.rotationPointZ += 3.0F / var1;
        }
        else
        {
            this.noumenon_1.rotationPointZ = -1.0F;
        }

        if (this.noumenon_1.rotateAngleX > -0.9948377F)
        {
            this.noumenon_1.rotateAngleX -= 0.9948377F / var1;
        }
        else
        {
            this.noumenon_1.rotateAngleX = -0.9948377F;
        }

        if (this.noumenon_2.rotationPointZ < 2.0F)
        {
            this.noumenon_2.rotationPointZ += 2.0F / var1;
        }
        else
        {
            this.noumenon_2.rotationPointZ = 2.0F;
        }

        if (this.noumenon_2.rotateAngleX > -0.4068249F)
        {
            this.noumenon_2.rotateAngleX -= 0.4068249F / var1;
        }
        else
        {
            this.noumenon_2.rotateAngleX = -0.4068249F;
        }

        if (this.hand_R.rotationPointY > 10.0F)
        {
            this.hand_R.rotationPointY -= 4.0F / var1;
        }
        else
        {
            this.hand_R.rotationPointY = 10.0F;
        }

        if (this.hand_L.rotationPointY > 10.0F)
        {
            this.hand_L.rotationPointY -= 4.0F / var1;
        }
        else
        {
            this.hand_L.rotationPointY = 10.0F;
        }

        if (this.noumenon_3.rotateAngleX > -0.7684471F)
        {
            this.noumenon_3.rotateAngleX -= 0.5424332F / var1;
        }
        else
        {
            this.noumenon_3.rotateAngleX = -0.7684471F;
        }

        if (this.noumenon_4.rotationPointY < 15.0F)
        {
            this.noumenon_4.rotationPointY += 4.0F / var1;
        }
        else
        {
            this.noumenon_4.rotationPointY = 15.0F;
        }

        if (this.noumenon_4.rotationPointZ > 12.0F)
        {
            this.noumenon_4.rotationPointZ -= 2.0F / var1;
        }
        else
        {
            this.noumenon_4.rotationPointZ = 12.0F;
        }

        if (this.noumenon_4.rotateAngleX > -0.5424333F)
        {
            this.noumenon_4.rotateAngleX -= 0.406825F / var1;
        }
        else
        {
            this.noumenon_4.rotateAngleX = -0.5424333F;
        }

        if (this.noumenon_5.rotationPointY < 20.0F)
        {
            this.noumenon_5.rotationPointY += 7.0F / var1;
        }
        else
        {
            this.noumenon_5.rotationPointY = 20.0F;
        }

        if (this.noumenon_5.rotationPointZ > 19.0F)
        {
            this.noumenon_5.rotationPointZ -= 3.0F / var1;
        }
        else
        {
            this.noumenon_5.rotationPointZ = 19.0F;
        }

        if (this.noumenon_5.rotateAngleX < -0.3616222F)
        {
            this.noumenon_5.rotateAngleX += 0.3616222F / var1;
        }
        else
        {
            this.noumenon_5.rotateAngleX = -0.3616222F;
        }

        if (this.head_1.rotationPointY > 0.0F)
        {
            this.head_1.rotationPointY -= 7.0F / var1;
        }
        else
        {
            this.head_1.rotationPointY = 0.0F;
        }

        if (this.head_1.rotationPointZ < -8.0F)
        {
            this.head_1.rotationPointZ += 6.0F / var1;
        }
        else
        {
            this.head_1.rotationPointZ = -8.0F;
        }

        if (this.head_2.rotationPointY > 1.0F)
        {
            this.head_2.rotationPointY -= 7.0F / var1;
        }
        else
        {
            this.head_2.rotationPointY = 1.0F;
        }

        if (this.head_2.rotationPointZ < -8.0F)
        {
            this.head_2.rotationPointZ += 6.0F / var1;
        }
        else
        {
            this.head_2.rotationPointZ = -8.0F;
        }

        if (this.head_3.rotationPointY > 1.0F)
        {
            this.head_3.rotationPointY -= 6.0F / var1;
        }
        else
        {
            this.head_3.rotationPointY = 1.0F;
        }

        if (this.head_3.rotationPointZ < -8.0F)
        {
            this.head_3.rotationPointZ += 6.0F / var1;
        }
        else
        {
            this.head_3.rotationPointZ = -8.0F;
        }
    }

    public void OpenMouth(float var1)
    {
        if (this.head_1.rotateAngleX < 0.2260139F)
        {
            this.head_1.rotateAngleX += 0.2260139F / var1;
        }
        else
        {
            this.head_1.rotateAngleX = 0.2260139F;
        }

        if (this.head_2.rotateAngleX > -0.1356083F)
        {
            this.head_2.rotateAngleX -= 0.1356083F / var1;
        }
        else
        {
            this.head_2.rotateAngleX = -0.1356083F;
        }

        if (this.head_3.rotateAngleX < 0.4520277F)
        {
            this.head_3.rotateAngleX += 0.4520277F / var1;
        }
        else
        {
            this.head_3.rotateAngleX = 0.4520277F;
        }
    }

    public void CloseMouth(float var1)
    {
        if (this.head_1.rotateAngleX > 0.0F)
        {
            this.head_1.rotateAngleX -= 0.2260139F / var1;
        }
        else
        {
            this.head_1.rotateAngleX = 0.0F;
        }

        if (this.head_2.rotateAngleX < 0.0F)
        {
            this.head_2.rotateAngleX += 0.1356083F / var1;
        }
        else
        {
            this.head_2.rotateAngleX = 0.0F;
        }

        if (this.head_3.rotateAngleX > 0.0F)
        {
            this.head_3.rotateAngleX -= 0.4520277F / var1;
        }
        else
        {
            this.head_3.rotateAngleX = 0.0F;
        }
    }

    public boolean SwingHeadLeft(int var1)
    {
        int var2 = 0;
        float var10000 = this.head_3.rotateAngleZ;
        this.getClass();
        ModelRenderer var3;
        float var10001;

        if (var10000 > -0.174533F)
        {
            var3 = this.head_3;
            var10001 = this.head_3.rotateAngleZ;
            this.getClass();
            var3.rotateAngleZ = var10001 - 0.174533F / (float)var1;
        }
        else
        {
            ++var2;
            var3 = this.head_3;
            this.getClass();
            var3.rotateAngleZ = -0.174533F;
        }

        var10000 = this.head_2.rotateAngleZ;
        this.getClass();

        if (var10000 > -0.174533F)
        {
            var3 = this.head_2;
            var10001 = this.head_2.rotateAngleZ;
            this.getClass();
            var3.rotateAngleZ = var10001 - 0.174533F / (float)var1;
        }
        else
        {
            ++var2;
            var3 = this.head_2;
            this.getClass();
            var3.rotateAngleZ = -0.174533F;
        }

        var10000 = this.head_1.rotateAngleZ;
        this.getClass();

        if (var10000 > -0.174533F)
        {
            var3 = this.head_1;
            var10001 = this.head_1.rotateAngleZ;
            this.getClass();
            var3.rotateAngleZ = var10001 - 0.174533F / (float)var1;
        }
        else
        {
            ++var2;
            var3 = this.head_1;
            this.getClass();
            var3.rotateAngleZ = -0.174533F;
        }

        return var2 == 3;
    }

    public boolean SwingHeadRight(int var1)
    {
        int var2 = 0;
        float var10000 = this.head_3.rotateAngleZ;
        this.getClass();
        ModelRenderer var3;
        float var10001;

        if (var10000 < 0.174533F)
        {
            var3 = this.head_3;
            var10001 = this.head_3.rotateAngleZ;
            this.getClass();
            var3.rotateAngleZ = var10001 + 0.174533F / (float)var1;
        }
        else
        {
            ++var2;
            var3 = this.head_3;
            this.getClass();
            var3.rotateAngleZ = 0.174533F;
        }

        var10000 = this.head_2.rotateAngleZ;
        this.getClass();

        if (var10000 > 0.174533F)
        {
            var3 = this.head_2;
            var10001 = this.head_2.rotateAngleZ;
            this.getClass();
            var3.rotateAngleZ = var10001 + 0.174533F / (float)var1;
        }
        else
        {
            ++var2;
            var3 = this.head_2;
            this.getClass();
            var3.rotateAngleZ = 0.174533F;
        }

        var10000 = this.head_1.rotateAngleZ;
        this.getClass();

        if (var10000 > 0.174533F)
        {
            var3 = this.head_1;
            var10001 = this.head_1.rotateAngleZ;
            this.getClass();
            var3.rotateAngleZ = var10001 + 0.174533F / (float)var1;
        }
        else
        {
            ++var2;
            var3 = this.head_1;
            this.getClass();
            var3.rotateAngleZ = 0.174533F;
        }

        return var2 == 3;
    }

    public void SwingHeadBack()
    {
        this.head_1.rotateAngleZ = 0.0F;
        this.head_2.rotateAngleZ = 0.0F;
        this.head_3.rotateAngleZ = 0.0F;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (!var7)
        {
            this.head_1.rotateAngleY = -var4 / (180F / (float)Math.PI);
            this.head_2.rotateAngleY = -var4 / (180F / (float)Math.PI);
            this.head_3.rotateAngleY = -var4 / (180F / (float)Math.PI);
            this.foot_R_1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.foot_R_2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 - 0.6108652F;
            this.foot_R_3.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.foot_L_1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.foot_L_2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2 - 0.6108652F;
            this.foot_L_3.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;

            if (Math.abs(this.foot_R_1.rotateAngleX) >= 0.174532F)
            {
                this.RunPose();
            }
            else
            {
                this.StandPose();
            }
        }
    }
}
