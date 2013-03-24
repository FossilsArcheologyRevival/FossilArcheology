package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWeakTRex extends ModelTRex
{
    public ModelRenderer foot_R_1 = new ModelRenderer(this, 40, 2);
    public ModelRenderer head_1;
    public ModelRenderer head_2;
    public ModelRenderer head_3;
    public ModelRenderer noumenon_1;
    public ModelRenderer hand_L;
    public ModelRenderer hand_R;
    public ModelRenderer foot_L_1;
    public ModelRenderer noumenon_2;
    public ModelRenderer foot_R_3;
    public ModelRenderer foot_L_3;
    public ModelRenderer foot_L_2;
    public ModelRenderer foot_R_2;
    public ModelRenderer noumenon_3;
    public ModelRenderer noumenon_4;
    public ModelRenderer noumenon_5;

    public ModelWeakTRex()
    {
        this.foot_R_1.addBox(-4.0F, -4.0F, -4.0F, 4, 8, 8, 0.0F);
        this.foot_R_1.setRotationPoint(-2.0F, 20.0F, 5.0F);
        this.foot_R_1.rotateAngleX = 0.0F;
        this.foot_R_1.rotateAngleY = 0.0F;
        this.foot_R_1.rotateAngleZ = 0.0F;
        this.foot_R_1.mirror = false;
        this.head_1 = new ModelRenderer(this, 0, 16);
        this.head_1.addBox(-4.0F, 0.0F, -6.0F, 8, 8, 6, 0.0F);
        this.head_1.setRotationPoint(0.0F, 16.0F, -8.0F);
        this.head_1.rotateAngleX = -7.905835E-16F;
        this.head_1.rotateAngleY = 0.0F;
        this.head_1.rotateAngleZ = 0.0F;
        this.head_1.mirror = false;
        this.head_2 = new ModelRenderer(this, 34, 18);
        this.head_2.addBox(-4.0F, 1.0F, -11.0F, 6, 6, 8, 0.0F);
        this.head_2.setRotationPoint(1.0F, 16.0F, -8.0F);
        this.head_2.rotateAngleX = 0.0F;
        this.head_2.rotateAngleY = 0.0F;
        this.head_2.rotateAngleZ = 0.0F;
        this.head_2.mirror = false;
        this.head_3 = new ModelRenderer(this, 13, 23);
        this.head_3.addBox(-4.0F, 6.0F, -10.0F, 4, 2, 7, 0.0F);
        this.head_3.setRotationPoint(2.0F, 16.0F, -8.0F);
        this.head_3.rotateAngleX = 0.0F;
        this.head_3.rotateAngleY = 0.0F;
        this.head_3.rotateAngleZ = 0.0F;
        this.head_3.mirror = false;
        this.noumenon_1 = new ModelRenderer(this, 4, 2);
        this.noumenon_1.addBox(-3.0F, 0.0F, -10.0F, 6, 8, 10, 0.0F);
        this.noumenon_1.setRotationPoint(0.0F, 13.0F, -1.0F);
        this.noumenon_1.rotateAngleX = 0.3164194F;
        this.noumenon_1.rotateAngleY = 0.0F;
        this.noumenon_1.rotateAngleZ = 0.0F;
        this.noumenon_1.mirror = false;
        this.hand_L = new ModelRenderer(this, 34, 0);
        this.hand_L.addBox(0.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
        this.hand_L.setRotationPoint(2.0F, 22.0F, -4.0F);
        this.hand_L.rotateAngleX = 1.039664F;
        this.hand_L.rotateAngleY = 0.0F;
        this.hand_L.rotateAngleZ = 0.0F;
        this.hand_L.mirror = false;
        this.hand_R = new ModelRenderer(this, 34, 0);
        this.hand_R.addBox(-2.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
        this.hand_R.setRotationPoint(-2.0F, 22.0F, -4.0F);
        this.hand_R.rotateAngleX = 0.994461F;
        this.hand_R.rotateAngleY = 0.0F;
        this.hand_R.rotateAngleZ = 0.0F;
        this.hand_R.mirror = false;
        this.foot_L_1 = new ModelRenderer(this, 40, 2);
        this.foot_L_1.addBox(0.0F, -4.0F, -4.0F, 4, 8, 8, 0.0F);
        this.foot_L_1.setRotationPoint(2.0F, 19.0F, 5.0F);
        this.foot_L_1.rotateAngleX = 0.0F;
        this.foot_L_1.rotateAngleY = 0.0F;
        this.foot_L_1.rotateAngleZ = 0.0F;
        this.foot_L_1.mirror = false;
        this.noumenon_2 = new ModelRenderer(this, 1, 0);
        this.noumenon_2.addBox(-5.0F, 0.0F, -6.0F, 8, 11, 12, 0.0F);
        this.noumenon_2.setRotationPoint(1.0F, 13.0F, 4.0F);
        this.noumenon_2.rotateAngleX = 0.0F;
        this.noumenon_2.rotateAngleY = 0.0F;
        this.noumenon_2.rotateAngleZ = 0.0F;
        this.noumenon_2.mirror = false;
        this.foot_R_3 = new ModelRenderer(this, 36, 0);
        this.foot_R_3.addBox(-2.0F, 0.0F, -6.0F, 3, 2, 8, 0.0F);
        this.foot_R_3.setRotationPoint(-6.0F, 23.0F, 4.0F);
        this.foot_R_3.rotateAngleX = 0.0F;
        this.foot_R_3.rotateAngleY = 0.0F;
        this.foot_R_3.rotateAngleZ = 0.0F;
        this.foot_R_3.mirror = false;
        this.foot_L_3 = new ModelRenderer(this, 36, 0);
        this.foot_L_3.addBox(-1.0F, 0.0F, -6.0F, 3, 2, 8, 0.0F);
        this.foot_L_3.setRotationPoint(6.0F, 23.0F, 4.0F);
        this.foot_L_3.rotateAngleX = 0.0F;
        this.foot_L_3.rotateAngleY = 0.0F;
        this.foot_L_3.rotateAngleZ = 0.0F;
        this.foot_L_3.mirror = false;
        this.foot_L_2 = new ModelRenderer(this, 0, 9);
        this.foot_L_2.addBox(-1.0F, -3.0F, 0.0F, 2, 8, 3, 0.0F);
        this.foot_L_2.setRotationPoint(4.0F, 25.0F, 4.0F);
        this.foot_L_2.rotateAngleX = ((float)Math.PI / 2F);
        this.foot_L_2.rotateAngleY = 0.0F;
        this.foot_L_2.rotateAngleZ = 0.0F;
        this.foot_L_2.mirror = false;
        this.foot_R_2 = new ModelRenderer(this, 0, 9);
        this.foot_R_2.addBox(-1.0F, -3.0F, 0.0F, 2, 8, 3, 0.0F);
        this.foot_R_2.setRotationPoint(-4.0F, 25.0F, 4.0F);
        this.foot_R_2.rotateAngleX = ((float)Math.PI / 2F);
        this.foot_R_2.rotateAngleY = 0.0F;
        this.foot_R_2.rotateAngleZ = 0.0F;
        this.foot_R_2.mirror = false;
        this.noumenon_3 = new ModelRenderer(this, 4, 4);
        this.noumenon_3.addBox(-3.0F, 0.0F, 0.0F, 6, 5, 10, 0.0F);
        this.noumenon_3.setRotationPoint(0.0F, 14.0F, 9.0F);
        this.noumenon_3.rotateAngleX = -0.3616222F;
        this.noumenon_3.rotateAngleY = 0.4972305F;
        this.noumenon_3.rotateAngleZ = 0.0F;
        this.noumenon_3.mirror = false;
        this.noumenon_4 = new ModelRenderer(this, 5, 2);
        this.noumenon_4.addBox(-2.0F, 0.0F, 0.0F, 4, 3, 10, 0.0F);
        this.noumenon_4.setRotationPoint(2.0F, 17.0F, 16.0F);
        this.noumenon_4.rotateAngleX = -0.4520277F;
        this.noumenon_4.rotateAngleY = 1.6273F;
        this.noumenon_4.rotateAngleZ = 0.0F;
        this.noumenon_4.mirror = false;
        this.noumenon_5 = new ModelRenderer(this, 10, 6);
        this.noumenon_5.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 6, 0.0F);
        this.noumenon_5.setRotationPoint(12.0F, 22.0F, 11.0F);
        this.noumenon_5.rotateAngleX = 0.0F;
        this.noumenon_5.rotateAngleY = -0.4520277F;
        this.noumenon_5.rotateAngleZ = 0.0F;
        this.noumenon_5.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.foot_R_1.render(var7);
        this.head_1.render(var7);
        this.head_2.render(var7);
        this.head_3.render(var7);
        this.noumenon_1.render(var7);
        this.hand_L.render(var7);
        this.hand_R.render(var7);
        this.foot_L_1.render(var7);
        this.noumenon_2.render(var7);
        this.foot_R_3.render(var7);
        this.foot_L_3.render(var7);
        this.foot_L_2.render(var7);
        this.foot_R_2.render(var7);
        this.noumenon_3.render(var7);
        this.noumenon_4.render(var7);
        this.noumenon_5.render(var7);
    }
}
