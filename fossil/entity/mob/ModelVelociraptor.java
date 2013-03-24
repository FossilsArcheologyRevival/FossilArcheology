package fossil.entity.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelVelociraptor extends ModelBase
{
    public ModelRenderer noumenon2 = new ModelRenderer(this, 0, 0);
    public ModelRenderer noumenon3;
    public ModelRenderer noumenon4;
    public ModelRenderer thigh_L2;
    public ModelRenderer thigh_L1;
    public ModelRenderer noumenon1;
    public ModelRenderer head1;
    public ModelRenderer head2;
    public ModelRenderer head3_up;
    public ModelRenderer head3_down;
    public ModelRenderer leg_L1;
    public ModelRenderer leg_L2;
    public ModelRenderer left_nail_1;
    public ModelRenderer left_nail_2;
    public ModelRenderer horn_2_L;
    public ModelRenderer leg_R1;
    public ModelRenderer thigh_R2;
    public ModelRenderer thigh_R1;
    public ModelRenderer leg_R2;
    public ModelRenderer right_nail_2;
    public ModelRenderer right_nail_1;
    public ModelRenderer horn_1_R;

    public ModelVelociraptor()
    {
        this.noumenon2.addBox(-3.0F, -3.0F, -6.0F, 8, 6, 7, 0.0F);
        this.noumenon2.setRotationPoint(-1.0F, 13.0F, 3.0F);
        this.noumenon2.rotateAngleX = 0.0F;
        this.noumenon2.rotateAngleY = 0.0F;
        this.noumenon2.rotateAngleZ = 0.0F;
        this.noumenon2.mirror = false;
        this.noumenon3 = new ModelRenderer(this, 3, 1);
        this.noumenon3.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
        this.noumenon3.setRotationPoint(0.0F, 10.0F, 4.0F);
        this.noumenon3.rotateAngleX = -0.5235988F;
        this.noumenon3.rotateAngleY = 0.0F;
        this.noumenon3.rotateAngleZ = 0.0F;
        this.noumenon3.mirror = false;
        this.noumenon4 = new ModelRenderer(this, 20, 11);
        this.noumenon4.addBox(-1.0F, 0.0F, 6.0F, 2, 2, 12, 0.0F);
        this.noumenon4.setRotationPoint(0.0F, 10.0F, 4.0F);
        this.noumenon4.rotateAngleX = -((float)Math.PI * 2F / 9F);
        this.noumenon4.rotateAngleY = 0.0F;
        this.noumenon4.rotateAngleZ = 0.0F;
        this.noumenon4.mirror = false;
        this.thigh_L2 = new ModelRenderer(this, 48, 1);
        this.thigh_L2.addBox(0.0F, -1.0F, -2.0F, 3, 5, 5, 0.0F);
        this.thigh_L2.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.thigh_L2.rotateAngleX = 0.0F;
        this.thigh_L2.rotateAngleY = 0.0F;
        this.thigh_L2.rotateAngleZ = 0.0F;
        this.thigh_L2.mirror = false;
        this.thigh_L1 = new ModelRenderer(this, 43, 0);
        this.thigh_L1.addBox(0.0F, -1.0F, -1.0F, 2, 3, 3, 0.0F);
        this.thigh_L1.setRotationPoint(3.0F, 12.0F, -6.0F);
        this.thigh_L1.rotateAngleX = 0.0F;
        this.thigh_L1.rotateAngleY = 0.0F;
        this.thigh_L1.rotateAngleZ = 0.0F;
        this.thigh_L1.mirror = false;
        this.noumenon1 = new ModelRenderer(this, 3, 2);
        this.noumenon1.addBox(-3.0F, -6.0F, -5.0F, 6, 6, 5, 0.0F);
        this.noumenon1.setRotationPoint(0.0F, 16.0F, -4.0F);
        this.noumenon1.rotateAngleX = -0.5235988F;
        this.noumenon1.rotateAngleY = 0.0F;
        this.noumenon1.rotateAngleZ = 0.0F;
        this.noumenon1.mirror = false;
        this.head1 = new ModelRenderer(this, 3, 1);
        this.head1.addBox(-2.0F, 0.0F, -6.0F, 4, 4, 6, 0.0F);
        this.head1.setRotationPoint(0.0F, 10.0F, -5.0F);
        this.head1.rotateAngleX = -2.094395F;
        this.head1.rotateAngleY = 0.0F;
        this.head1.rotateAngleZ = 0.0F;
        this.head1.mirror = false;
        this.head2 = new ModelRenderer(this, 0, 17);
        this.head2.addBox(-3.0F, -7.0F, -8.0F, 6, 7, 8, 0.0F);
        this.head2.setRotationPoint(0.0F, 5.0F, -3.0F);
        this.head2.rotateAngleX = 0.08726646F;
        this.head2.rotateAngleY = 0.0F;
        this.head2.rotateAngleZ = 0.0F;
        this.head2.mirror = false;
        this.head3_up = new ModelRenderer(this, 44, 22);
        this.head3_up.addBox(-2.0F, -4.0F, -6.0F, 4, 4, 6, 0.0F);
        this.head3_up.setRotationPoint(0.0F, 5.0F, -11.0F);
        this.head3_up.rotateAngleX = 0.08726646F;
        this.head3_up.rotateAngleY = 0.0F;
        this.head3_up.rotateAngleZ = 0.0F;
        this.head3_up.mirror = false;
        this.head3_down = new ModelRenderer(this, 23, 0);
        this.head3_down.addBox(-2.0F, 0.0F, -5.0F, 4, 1, 6, 0.0F);
        this.head3_down.setRotationPoint(0.0F, 5.0F, -10.0F);
        this.head3_down.rotateAngleX = 0.0F;
        this.head3_down.rotateAngleY = 0.0F;
        this.head3_down.rotateAngleZ = 0.0F;
        this.head3_down.mirror = false;
        this.leg_L1 = new ModelRenderer(this, 20, 18);
        this.leg_L1.addBox(0.0F, 2.0F, -4.0F, 2, 2, 4, 0.0F);
        this.leg_L1.setRotationPoint(3.0F, 12.0F, -6.0F);
        this.leg_L1.rotateAngleX = 0.994461F;
        this.leg_L1.rotateAngleY = 0.0F;
        this.leg_L1.rotateAngleZ = 0.0F;
        this.leg_L1.mirror = false;
        this.leg_L2 = new ModelRenderer(this, 14, 8);
        this.leg_L2.addBox(0.0F, 4.0F, -7.0F, 2, 2, 7, 0.0F);
        this.leg_L2.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.leg_L2.rotateAngleX = 0.9948377F;
        this.leg_L2.rotateAngleY = 0.0F;
        this.leg_L2.rotateAngleZ = 0.0F;
        this.leg_L2.mirror = false;
        this.left_nail_1 = new ModelRenderer(this, 32, 7);
        this.left_nail_1.addBox(0.0F, 5.0F, 3.0F, 1, 1, 3, 0.0F);
        this.left_nail_1.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.left_nail_1.rotateAngleX = -0.8726646F;
        this.left_nail_1.rotateAngleY = 0.0F;
        this.left_nail_1.rotateAngleZ = 0.0F;
        this.left_nail_1.mirror = false;
        this.left_nail_2 = new ModelRenderer(this, 32, 7);
        this.left_nail_2.addBox(0.0F, -5.0F, 5.0F, 1, 1, 1, 0.0F);
        this.left_nail_2.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.left_nail_2.rotateAngleX = -2.6529F;
        this.left_nail_2.rotateAngleY = 0.0F;
        this.left_nail_2.rotateAngleZ = 0.0F;
        this.left_nail_2.mirror = false;
        this.horn_2_L = new ModelRenderer(this, 30, 26);
        this.horn_2_L.addBox(0.0F, 8.0F, -3.0F, 3, 2, 4, 0.0F);
        this.horn_2_L.setRotationPoint(4.0F, 14.0F, 1.0F);
        this.horn_2_L.rotateAngleX = 0.0F;
        this.horn_2_L.rotateAngleY = 0.0F;
        this.horn_2_L.rotateAngleZ = 0.0F;
        this.horn_2_L.mirror = false;
        this.leg_R1 = new ModelRenderer(this, 20, 18);
        this.leg_R1.addBox(-2.0F, 2.0F, -4.0F, 2, 2, 4, 0.0F);
        this.leg_R1.setRotationPoint(-3.0F, 12.0F, -6.0F);
        this.leg_R1.rotateAngleX = 0.994461F;
        this.leg_R1.rotateAngleY = 0.0F;
        this.leg_R1.rotateAngleZ = 0.0F;
        this.leg_R1.mirror = false;
        this.thigh_R2 = new ModelRenderer(this, 48, 12);
        this.thigh_R2.addBox(-3.0F, -1.0F, -2.0F, 3, 5, 5, 0.0F);
        this.thigh_R2.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.thigh_R2.rotateAngleX = 0.0F;
        this.thigh_R2.rotateAngleY = 0.0F;
        this.thigh_R2.rotateAngleZ = 0.0F;
        this.thigh_R2.mirror = false;
        this.thigh_R1 = new ModelRenderer(this, 43, 11);
        this.thigh_R1.addBox(-2.0F, -1.0F, -1.0F, 2, 3, 3, 0.0F);
        this.thigh_R1.setRotationPoint(-3.0F, 12.0F, -6.0F);
        this.thigh_R1.rotateAngleX = 0.0F;
        this.thigh_R1.rotateAngleY = 0.0F;
        this.thigh_R1.rotateAngleZ = 0.0F;
        this.thigh_R1.mirror = false;
        this.leg_R2 = new ModelRenderer(this, 14, 8);
        this.leg_R2.addBox(-2.0F, 4.0F, -7.0F, 2, 2, 7, 0.0F);
        this.leg_R2.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.leg_R2.rotateAngleX = 0.9948377F;
        this.leg_R2.rotateAngleY = 0.0F;
        this.leg_R2.rotateAngleZ = 0.0F;
        this.leg_R2.mirror = false;
        this.right_nail_2 = new ModelRenderer(this, 32, 7);
        this.right_nail_2.addBox(-1.0F, -5.0F, 5.0F, 1, 1, 1, 0.0F);
        this.right_nail_2.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.right_nail_2.rotateAngleX = -2.617994F;
        this.right_nail_2.rotateAngleY = 0.0F;
        this.right_nail_2.rotateAngleZ = 0.0F;
        this.right_nail_2.mirror = false;
        this.right_nail_1 = new ModelRenderer(this, 32, 7);
        this.right_nail_1.addBox(-1.0F, 5.0F, 3.0F, 1, 1, 3, 0.0F);
        this.right_nail_1.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.right_nail_1.rotateAngleX = -0.8726646F;
        this.right_nail_1.rotateAngleY = 0.0F;
        this.right_nail_1.rotateAngleZ = 0.0F;
        this.right_nail_1.mirror = false;
        this.horn_1_R = new ModelRenderer(this, 30, 26);
        this.horn_1_R.addBox(-3.0F, 8.0F, -3.0F, 3, 2, 4, 0.0F);
        this.horn_1_R.setRotationPoint(-4.0F, 14.0F, 1.0F);
        this.horn_1_R.rotateAngleX = 0.0F;
        this.horn_1_R.rotateAngleY = 0.0F;
        this.horn_1_R.rotateAngleZ = 0.0F;
        this.horn_1_R.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.render(var1, var2, var3, var4, var5, var6, var7, false);
    }

    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7, boolean var8)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var8);
        this.noumenon2.render(var7);
        this.noumenon3.render(var7);
        this.noumenon4.render(var7);
        this.thigh_L2.render(var7);
        this.thigh_L1.render(var7);
        this.noumenon1.render(var7);
        this.head1.render(var7);
        this.head2.render(var7);
        this.head3_up.render(var7);
        this.head3_down.render(var7);
        this.leg_L1.render(var7);
        this.leg_L2.render(var7);
        this.left_nail_1.render(var7);
        this.left_nail_2.render(var7);
        this.horn_2_L.render(var7);
        this.leg_R1.render(var7);
        this.thigh_R2.render(var7);
        this.thigh_R1.render(var7);
        this.leg_R2.render(var7);
        this.right_nail_2.render(var7);
        this.right_nail_1.render(var7);
        this.horn_1_R.render(var7);
    }

    public void HuntingPose()
    {
        this.noumenon2.setRotationPoint(-1.0F, 10.0F, 3.0F);
        this.noumenon2.rotateAngleX = -0.558F;
        this.noumenon3.setRotationPoint(0.0F, 7.0F, 2.0F);
        this.noumenon3.rotateAngleX = 0.555F;
        this.noumenon4.setRotationPoint(0.0F, 11.0F, 4.0F);
        this.noumenon4.rotateAngleX = 1.161F;
        this.thigh_L2.setRotationPoint(4.0F, 9.0F, 0.0F);
        this.thigh_L2.rotateAngleX = -0.611F;
        this.thigh_L1.setRotationPoint(3.0F, 7.0F, -6.0F);
        this.thigh_L1.rotateAngleX = 0.0F;
        this.noumenon1.setRotationPoint(0.0F, 9.5F, -2.0F);
        this.noumenon1.rotateAngleX = -0.43F;
        this.head1.setRotationPoint(0.0F, 2.0F, -3.0F);
        this.head1.rotateAngleX = -0.273F;
        this.head2.setRotationPoint(0.0F, 2.0F, -6.0F);
        this.head2.rotateAngleX = 0.873F;
        this.head3_up.setRotationPoint(0.0F, 7.0F, -12.0F);
        this.head3_up.rotateAngleX = 0.873F;
        this.head3_down.setRotationPoint(0.0F, 7.0F, -12.0F);
        this.head3_down.rotateAngleX = 1.589F;
        this.leg_L1.setRotationPoint(3.0F, 7.0F, -6.0F);
        this.leg_L1.rotateAngleX = 0.994F;
        this.leg_L2.setRotationPoint(4.0F, 9.0F, 0.0F);
        this.leg_L2.rotateAngleX = 0.177F;
        this.left_nail_1.setRotationPoint(4.0F, 9.0F, 0.0F);
        this.left_nail_1.rotateAngleX = -1.616F;
        this.left_nail_2.setRotationPoint(4.0F, 9.0F, 0.0F);
        this.left_nail_2.rotateAngleX = 2.961F;
        this.horn_2_L.setRotationPoint(4.0F, 9.0F, 1.0F);
        this.horn_2_L.rotateAngleX = -0.706F;
        this.leg_R1.setRotationPoint(-3.0F, 7.0F, -6.0F);
        this.leg_R1.rotateAngleX = 0.994F;
        this.thigh_R2.setRotationPoint(-4.0F, 9.0F, 0.0F);
        this.thigh_R2.rotateAngleX = 0.186F;
        this.thigh_R1.setRotationPoint(-3.0F, 7.0F, -6.0F);
        this.thigh_R1.rotateAngleX = 0.0F;
        this.leg_R2.setRotationPoint(-4.0F, 11.0F, -2.0F);
        this.leg_R2.rotateAngleX = 1.515F;
        this.right_nail_2.setRotationPoint(-4.0F, 9.0F, 0.0F);
        this.right_nail_2.rotateAngleX = -2.358F;
        this.right_nail_1.setRotationPoint(-4.0F, 9.0F, 0.0F);
        this.right_nail_1.rotateAngleX = -0.63F;
        this.horn_1_R.setRotationPoint(-4.0F, 9.0F, 0.0F);
        this.horn_1_R.rotateAngleX = 0.335F;
    }

    public void ReturnPose()
    {
        this.noumenon2.setRotationPoint(-1.0F, 13.0F, 3.0F);
        this.noumenon2.rotateAngleX = 0.0F;
        this.noumenon3.setRotationPoint(0.0F, 10.0F, 4.0F);
        this.noumenon3.rotateAngleX = -0.524F;
        this.noumenon4.setRotationPoint(0.0F, 10.0F, 4.0F);
        this.noumenon4.rotateAngleX = -0.698F;
        this.thigh_L2.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.thigh_L2.rotateAngleX = 0.0F;
        this.thigh_L1.setRotationPoint(3.0F, 12.0F, -6.0F);
        this.thigh_L1.rotateAngleX = 0.0F;
        this.noumenon1.setRotationPoint(0.0F, 16.0F, -4.0F);
        this.noumenon1.rotateAngleX = -0.524F;
        this.head1.setRotationPoint(0.0F, 10.0F, -5.0F);
        this.head1.rotateAngleX = -2.094F;
        this.head2.setRotationPoint(0.0F, 5.0F, -3.0F);
        this.head2.rotateAngleX = 0.087F;
        this.head3_up.setRotationPoint(0.0F, 1.0F, -11.0F);
        this.head3_up.rotateAngleX = 0.087F;
        this.head3_down.setRotationPoint(0.0F, 5.0F, -10.0F);
        this.head3_down.rotateAngleX = 0.436F;
        this.leg_L1.setRotationPoint(3.0F, 12.0F, -6.0F);
        this.leg_L1.rotateAngleX = 0.994F;
        this.leg_L2.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.leg_L2.rotateAngleX = 0.995F;
        this.left_nail_1.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.left_nail_1.rotateAngleX = -0.873F;
        this.left_nail_2.setRotationPoint(4.0F, 14.0F, 0.0F);
        this.left_nail_2.rotateAngleX = -2.653F;
        this.horn_2_L.setRotationPoint(4.0F, 14.0F, 1.0F);
        this.horn_2_L.rotateAngleX = 0.0F;
        this.leg_R1.setRotationPoint(-3.0F, 12.0F, -6.0F);
        this.leg_R1.rotateAngleX = 0.994F;
        this.thigh_R2.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.thigh_R2.rotateAngleX = 0.0F;
        this.thigh_R1.setRotationPoint(-3.0F, 12.0F, -6.0F);
        this.thigh_R1.rotateAngleX = 0.0F;
        this.leg_R2.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.leg_R2.rotateAngleX = 0.995F;
        this.right_nail_2.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.right_nail_2.rotateAngleX = -2.618F;
        this.right_nail_1.setRotationPoint(-4.0F, 14.0F, 0.0F);
        this.right_nail_1.rotateAngleX = -0.873F;
        this.horn_1_R.setRotationPoint(-4.0F, 14.0F, 1.0F);
        this.horn_1_R.rotateAngleX = 0.0F;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (!var7)
        {
            this.thigh_R2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.leg_R2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 + 0.9948377F;
            this.horn_1_R.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.right_nail_1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 - 0.8726646F;
            this.right_nail_2.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 - 2.617994F;
            this.thigh_L2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.leg_L2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2 + 0.9948377F;
            this.horn_2_L.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.left_nail_1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2 - 0.8726646F;
            this.left_nail_2.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2 - 2.617994F;
            this.thigh_R1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
            this.leg_R1.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2 + 0.994461F;
            this.thigh_L1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
            this.leg_L1.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 + 0.994461F;

            if (Math.abs(this.thigh_L2.rotateAngleX) >= 0.174532F)
            {
                this.TailUpper();
            }
            else
            {
                this.TailLower();
            }

            if (Math.abs(this.thigh_L2.rotateAngleX) >= 0.174532F)
            {
                this.HeadLower();
            }
            else
            {
                this.HeadUpper();
            }
        }
    }

    public boolean SwingHead(float var1, int var2)
    {
        float var3 = var1 / (float)var2;
        int var4 = 0;
        boolean var5 = var1 >= 0.0F;

        if (var5)
        {
            if (this.head2.rotateAngleZ < var1)
            {
                this.head2.rotateAngleZ += var3;
            }
            else
            {
                this.head2.rotateAngleZ = var1;
                ++var4;
            }

            if (this.head3_up.rotateAngleZ < var1)
            {
                this.head3_up.rotateAngleZ += var3;
            }
            else
            {
                this.head3_up.rotateAngleZ = var1;
                ++var4;
            }

            if (this.head3_down.rotateAngleZ < var1)
            {
                this.head3_down.rotateAngleZ += var3;
            }
            else
            {
                this.head3_down.rotateAngleZ = var1;
                ++var4;
            }
        }
        else
        {
            if (this.head2.rotateAngleZ > var1)
            {
                this.head2.rotateAngleZ += var3;
            }
            else
            {
                this.head2.rotateAngleZ = var1;
                ++var4;
            }

            if (this.head3_up.rotateAngleZ > var1)
            {
                this.head3_up.rotateAngleZ += var3;
            }
            else
            {
                this.head3_up.rotateAngleZ = var1;
                ++var4;
            }

            if (this.head3_down.rotateAngleZ > var1)
            {
                this.head3_down.rotateAngleZ += var3;
            }
            else
            {
                this.head3_down.rotateAngleZ = var1;
                ++var4;
            }
        }

        return var4 == 3;
    }

    public void SwingHeadBack()
    {
        this.head2.rotateAngleZ = 0.0F;
        this.head3_up.rotateAngleZ = 0.0F;
        this.head3_down.rotateAngleZ = 0.0F;
    }

    public void TailUpper()
    {
        if (this.noumenon3.rotateAngleX < 0.0F)
        {
            this.noumenon3.rotateAngleX += 0.05235988F;
        }
        else
        {
            this.noumenon3.rotateAngleX = 0.0F;
        }

        if (this.noumenon4.rotateAngleX < 0.0F)
        {
            this.noumenon4.rotateAngleX += 0.06981318F;
        }
        else
        {
            this.noumenon4.rotateAngleX = 0.0F;
        }
    }

    public void TailLower()
    {
        if (this.noumenon3.rotateAngleX > -0.5235988F)
        {
            this.noumenon3.rotateAngleX -= 0.05235988F;
        }
        else
        {
            this.noumenon3.rotateAngleX = -0.5235988F;
        }

        if (this.noumenon4.rotateAngleX > -((float)Math.PI * 2F / 9F))
        {
            this.noumenon4.rotateAngleX -= 0.06981318F;
        }
        else
        {
            this.noumenon4.rotateAngleX = -((float)Math.PI * 2F / 9F);
        }
    }

    public void HeadLower()
    {
        if (this.noumenon1.rotationPointZ < -3.0F)
        {
            this.noumenon1.rotationPointZ = (float)((double)this.noumenon1.rotationPointZ + 0.1D);
        }
        else
        {
            this.noumenon1.rotationPointZ = -3.0F;
        }

        if (this.noumenon1.rotateAngleX < 0.0F)
        {
            this.noumenon1.rotateAngleX += 0.05235988F;
        }
        else
        {
            this.noumenon1.rotateAngleX = 0.0F;
        }

        if (this.head1.rotationPointZ > -8.0F)
        {
            this.head1.rotationPointZ -= 0.0F;
        }
        else
        {
            this.head1.rotationPointZ = -8.0F;
        }

        if (this.head1.rotateAngleX < 0.0F)
        {
            this.head1.rotateAngleX += 0.20943949F;
        }
        else
        {
            this.head1.rotateAngleX = 0.0F;
        }

        if (this.head2.rotationPointY < 15.0F)
        {
            ++this.head2.rotationPointY;
        }
        else
        {
            this.head2.rotationPointY = 15.0F;
        }

        if (this.head2.rotationPointZ > -12.0F)
        {
            this.head2.rotationPointZ -= 0.0F;
        }
        else
        {
            this.head2.rotationPointZ = -12.0F;
        }

        if (this.head3_up.rotationPointY < 15.0F)
        {
            ++this.head3_up.rotationPointY;
        }
        else
        {
            this.head3_up.rotationPointY = 15.0F;
        }

        if (this.head3_up.rotationPointZ > -20.0F)
        {
            this.head3_up.rotationPointZ -= 0.0F;
        }
        else
        {
            this.head3_up.rotationPointZ = -20.0F;
        }

        if (this.head3_down.rotationPointY < 15.0F)
        {
            ++this.head3_down.rotationPointY;
        }
        else
        {
            this.head3_down.rotationPointY = 15.0F;
        }

        if (this.head3_down.rotationPointZ > -19.0F)
        {
            this.head3_down.rotationPointZ -= 0.0F;
        }
        else
        {
            this.head3_down.rotationPointZ = -19.0F;
        }
    }

    public void HeadUpper()
    {
        if (this.noumenon1.rotationPointZ > -4.0F)
        {
            this.noumenon1.rotationPointZ = (float)((double)this.noumenon1.rotationPointZ - 0.1D);
        }
        else
        {
            this.noumenon1.rotationPointZ = -4.0F;
        }

        if (this.noumenon1.rotateAngleX > -0.5235988F)
        {
            this.noumenon1.rotateAngleX -= 0.05235988F;
        }
        else
        {
            this.noumenon1.rotateAngleX = -0.5235988F;
        }

        if (this.head1.rotationPointZ < -5.0F)
        {
            this.head1.rotationPointZ += 0.0F;
        }
        else
        {
            this.head1.rotationPointZ = -5.0F;
        }

        if (this.head1.rotateAngleX > -2.094395F)
        {
            this.head1.rotateAngleX -= 0.20943949F;
        }
        else
        {
            this.head1.rotateAngleX = -2.094395F;
        }

        if (this.head2.rotationPointY > 5.0F)
        {
            --this.head2.rotationPointY;
        }
        else
        {
            this.head2.rotationPointY = 5.0F;
        }

        if (this.head2.rotationPointZ < -3.0F)
        {
            this.head2.rotationPointZ += 0.0F;
        }
        else
        {
            this.head2.rotationPointZ = -3.0F;
        }

        if (this.head3_up.rotationPointY > 5.0F)
        {
            --this.head3_up.rotationPointY;
        }
        else
        {
            this.head3_up.rotationPointY = 5.0F;
        }

        if (this.head3_up.rotationPointZ < -11.0F)
        {
            this.head3_up.rotationPointZ += 0.0F;
        }
        else
        {
            this.head3_up.rotationPointZ = -11.0F;
        }

        if (this.head3_down.rotationPointY > 5.0F)
        {
            --this.head3_down.rotationPointY;
        }
        else
        {
            this.head3_down.rotationPointY = 5.0F;
        }

        if (this.head3_down.rotationPointZ < -10.0F)
        {
            this.head3_down.rotationPointZ += 0.0F;
        }
        else
        {
            this.head3_down.rotationPointZ = -10.0F;
        }
    }

    public void OpenMouth(int var1)
    {
        if (this.head3_down.rotateAngleX < 0.4363323F)
        {
            this.head3_down.rotateAngleX += 0.4363323F / (float)var1;
        }
        else
        {
            this.head3_down.rotateAngleX = 0.4363323F;
        }
    }

    public void CloseMouth(int var1)
    {
        if (this.head3_down.rotateAngleX > 0.0F)
        {
            this.head3_down.rotateAngleX -= 0.4363323F / (float)var1;
        }
        else
        {
            this.head3_down.rotateAngleX = 0.0F;
        }
    }
}
