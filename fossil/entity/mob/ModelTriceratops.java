package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTriceratops extends ModelDinosaurs
{
    ModelRenderer noumenon1 = new ModelRenderer(this, 42, 0);
    ModelRenderer noumenon2;
    ModelRenderer noumenon3;
    ModelRenderer noumenon4;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer thigh_R1;
    ModelRenderer leg_R1;
    ModelRenderer thigh_L1;
    ModelRenderer leg_L1;
    ModelRenderer thigh_R2;
    ModelRenderer leg_R2;
    ModelRenderer thigh_L2;
    ModelRenderer leg_L2;
    ModelRenderer horn_3;
    ModelRenderer head1;
    ModelRenderer head11;
    ModelRenderer horn_1_R;
    ModelRenderer horn_2_L;
    ModelRenderer horn_1_R1;
    ModelRenderer horn_1_R2;

    public ModelTriceratops()
    {
        this.noumenon1.addBox(-3.0F, -3.0F, -2.0F, 6, 5, 5);
        this.noumenon1.setRotationPoint(0.0F, 20.0F, -1.0F);
        this.SetRotation(this.noumenon1, 0.0F, 0.0F, 0.0F);
        this.noumenon2 = new ModelRenderer(this, 48, 10);
        this.noumenon2.addBox(-2.5F, -0.2F, 0.0F, 5, 4, 3);
        this.noumenon2.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.SetRotation(this.noumenon2, -0.2712F, 0.0F, 0.0F);
        this.noumenon3 = new ModelRenderer(this, 54, 17);
        this.noumenon3.addBox(-1.5F, 0.0F, 3.0F, 3, 2, 2);
        this.noumenon3.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.SetRotation(this.noumenon3, -0.4519F, 0.0F, 0.0F);
        this.noumenon4 = new ModelRenderer(this, 54, 21);
        this.noumenon4.addBox(-1.0F, 2.0F, 4.0F, 2, 1, 3);
        this.noumenon4.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.SetRotation(this.noumenon4, -0.1808F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 0, 0);
        this.head2.addBox(-2.0F, -3.0F, -2.0F, 4, 4, 6);
        this.head2.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.head2, 0.1396F, 0.0F, 0.0F);
        this.head3 = new ModelRenderer(this, 0, 10);
        this.head3.addBox(-1.0F, -2.5F, -3.0F, 2, 3, 3);
        this.head3.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.head3, 0.81364F, 0.0F, 0.0F);
        this.thigh_R1 = new ModelRenderer(this, 0, 20);
        this.thigh_R1.addBox(-4.0F, 1.0F, -2.0F, 2, 2, 2);
        this.thigh_R1.setRotationPoint(0.0F, 19.0F, -2.0F);
        this.SetRotation(this.thigh_R1, 0.0F, 0.0F, 0.0F);
        this.leg_R1 = new ModelRenderer(this, 8, 19);
        this.leg_R1.addBox(-3.0F, 1.0F, -6.0F, 1, 2, 3);
        this.leg_R1.setRotationPoint(0.0F, 18.0F, -2.0F);
        this.SetRotation(this.leg_R1, 1.0F, 0.0F, 0.0F);
        this.thigh_L1 = new ModelRenderer(this, 0, 16);
        this.thigh_L1.addBox(2.0F, 2.0F, -2.0F, 2, 2, 2);
        this.thigh_L1.setRotationPoint(0.0F, 18.0F, -2.0F);
        this.SetRotation(this.thigh_L1, 0.0F, 0.0F, 0.0F);
        this.leg_L1 = new ModelRenderer(this, 16, 19);
        this.leg_L1.addBox(2.0F, 1.0F, -6.0F, 1, 2, 3);
        this.leg_L1.setRotationPoint(0.0F, 18.0F, -2.0F);
        this.SetRotation(this.leg_L1, 1.0F, 0.0F, 0.0F);
        this.thigh_R2 = new ModelRenderer(this, 0, 24);
        this.thigh_R2.addBox(-4.0F, 0.0F, -2.0F, 2, 4, 4);
        this.thigh_R2.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.SetRotation(this.thigh_R2, 0.0F, 0.0F, 0.0F);
        this.leg_R2 = new ModelRenderer(this, 24, 19);
        this.leg_R2.addBox(-3.0F, 2.0F, -5.0F, 1, 2, 3);
        this.leg_R2.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.SetRotation(this.leg_R2, 1.0F, 0.0F, 0.0F);
        this.thigh_L2 = new ModelRenderer(this, 12, 24);
        this.thigh_L2.addBox(2.0F, 0.0F, -2.0F, 2, 4, 4);
        this.thigh_L2.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.SetRotation(this.thigh_L2, 0.0F, 0.0F, 0.0F);
        this.leg_L2 = new ModelRenderer(this, 32, 19);
        this.leg_L2.addBox(2.0F, 2.0F, -5.0F, 1, 2, 3);
        this.leg_L2.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.SetRotation(this.leg_L2, 1.0F, 0.0F, 0.0F);
        this.horn_3 = new ModelRenderer(this, 24, 24);
        this.horn_3.addBox(-0.5F, 2.0F, -3.0F, 1, 1, 2);
        this.horn_3.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.horn_3, -1.13F, 0.0F, 0.0F);
        this.head1 = new ModelRenderer(this, 20, 0);
        this.head1.addBox(-4.0F, -8.0F, 0.0F, 8, 7, 1);
        this.head1.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.head1, -0.4F, 0.0F, 0.0F);
        this.head11 = new ModelRenderer(this, 20, 8);
        this.head11.addBox(-5.0F, -9.0F, 0.0F, 10, 8, 1);
        this.head11.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.head11, -0.4F, 0.0F, 0.0F);
        this.horn_1_R = new ModelRenderer(this, 24, 27);
        this.horn_1_R.addBox(-2.0F, -4.0F, -3.0F, 1, 1, 4);
        this.horn_1_R.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.horn_1_R, -0.31642F, 0.0F, 0.0F);
        this.horn_2_L = new ModelRenderer(this, 24, 27);
        this.horn_2_L.addBox(1.0F, -4.0F, -3.0F, 1, 1, 4);
        this.horn_2_L.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.horn_2_L, -0.31642F, 0.0F, 0.0F);
        this.horn_1_R1 = new ModelRenderer(this, 33, 27);
        this.horn_1_R1.addBox(-2.0F, -4.0F, -6.0F, 1, 1, 4);
        this.horn_1_R1.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.horn_1_R1, -0.31642F, 0.0F, 0.0F);
        this.horn_1_R2 = new ModelRenderer(this, 33, 27);
        this.horn_1_R2.addBox(1.0F, -4.0F, -6.0F, 1, 1, 4);
        this.horn_1_R2.setRotationPoint(0.0F, 21.0F, -5.0F);
        this.SetRotation(this.horn_1_R2, -0.31642F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.noumenon1.render(var7);
        this.noumenon2.render(var7);
        this.noumenon3.render(var7);
        this.noumenon4.render(var7);
        this.head2.render(var7);
        this.head3.render(var7);
        this.thigh_R1.render(var7);
        this.leg_R1.render(var7);
        this.thigh_L1.render(var7);
        this.leg_L1.render(var7);
        this.thigh_R2.render(var7);
        this.leg_R2.render(var7);
        this.thigh_L2.render(var7);
        this.leg_L2.render(var7);
        this.horn_3.render(var7);
        this.head1.render(var7);
        this.head11.render(var7);
        this.horn_1_R.render(var7);
        this.horn_1_R1.render(var7);
        this.horn_2_L.render(var7);
        this.horn_1_R2.render(var7);
    }

    public void renderRun(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.RunningPose(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.noumenon1.render(var7);
        this.noumenon2.render(var7);
        this.noumenon3.render(var7);
        this.noumenon4.render(var7);
        this.head2.render(var7);
        this.head3.render(var7);
        this.thigh_R1.render(var7);
        this.leg_R1.render(var7);
        this.thigh_L1.render(var7);
        this.leg_L1.render(var7);
        this.thigh_R2.render(var7);
        this.leg_R2.render(var7);
        this.thigh_L2.render(var7);
        this.leg_L2.render(var7);
        this.horn_3.render(var7);
        this.head1.render(var7);
        this.head11.render(var7);
        this.horn_1_R.render(var7);
        this.horn_1_R1.render(var7);
        this.horn_2_L.render(var7);
        this.horn_1_R2.render(var7);
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (!var7)
        {
            this.noumenon2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.noumenon3.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.2617994F * var2 + 0.0F;
            this.noumenon4.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.34906584F * var2 + 0.0F;
            this.thigh_R1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 0.0F;
            this.thigh_R1.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
            this.leg_R1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 0.994461F;
            this.leg_R1.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
            this.thigh_L1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.thigh_L1.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
            this.leg_L1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.994461F;
            this.leg_L1.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
            this.thigh_R2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.thigh_R2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
            this.leg_R2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.994461F;
            this.leg_R2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
            this.thigh_L2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 0.0F;
            this.thigh_L2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
            this.leg_L2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 0.994461F;
            this.leg_L2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.08726646F * var2 + 0.0F;
        }
    }

    public void RunningPose(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6);
        if (var7==false)
        {
            this.noumenon1.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.08726646F * var2 + 0.0F;
            this.noumenon2.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.17453292F * var2 + -0.27121663F;
            this.noumenon3.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.2617994F * var2 + -0.4520277F;
            this.noumenon4.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.34906584F * var2 + -0.18081109F;
            this.thigh_R1.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * -0.17453292F * var2 + 0.0F;
            this.leg_R1.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * -0.17453292F * var2 + 0.994461F;
            this.thigh_L1.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * -0.2617994F * var2 + 0.0F;
            this.leg_L1.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * -0.2617994F * var2 + 0.994461F;
            this.thigh_R2.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.2617994F * var2 + 0.0F;
            this.leg_R2.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.2617994F * var2 + 0.994461F;
            this.thigh_L2.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.17453292F * var2 + 0.0F;
            this.leg_L2.rotateAngleX = MathHelper.cos(var1 / 0.63330555F) * 0.17453292F * var2 + 0.994461F;
        }
    }

    private void SetRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
}
