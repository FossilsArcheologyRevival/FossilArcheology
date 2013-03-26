package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStegosaurus extends ModelDinosaurs
{
    ModelRenderer H1 = (new ModelRenderer(this, 20, 0)).setTextureSize(64, 32);
    ModelRenderer H2;
    ModelRenderer H3;
    ModelRenderer H4;
    ModelRenderer H5;
    ModelRenderer H6;
    ModelRenderer D_L_1;
    ModelRenderer D_R_1;
    ModelRenderer D_L_2;
    ModelRenderer D_R_2;
    ModelRenderer DD_L_1;
    ModelRenderer D_D_R_1;
    ModelRenderer DD_L_2;
    ModelRenderer DD_R_2;
    ModelRenderer T1;
    ModelRenderer T2;
    ModelRenderer T3;
    ModelRenderer T4;

    public ModelStegosaurus()
    {
        this.H1.addBox(-3.0F, 0.0F, 0.0F, 7, 8, 8);
        this.H1.setRotationPoint(0.0F, 14.0F, -6.0F);
        this.setRotation(this.H1, 0.0F, 0.0F, 0.0F);
        this.H1.mirror = true;
        this.H2 = (new ModelRenderer(this, 46, 14)).setTextureSize(64, 32);
        this.H2.addBox(-2.0F, 2.0F, -4.0F, 5, 5, 4);
        this.H2.setRotationPoint(0.0F, 14.0F, -6.0F);
        this.setRotation(this.H2, 0.2094395F, 0.0F, 0.0F);
        this.H2.mirror = true;
        this.H3 = (new ModelRenderer(this, 32, 24)).setTextureSize(64, 32);
        this.H3.addBox(-0.5F, 3.5F, -8.0F, 2, 3, 5);
        this.H3.setRotationPoint(0.0F, 14.0F, -6.0F);
        this.setRotation(this.H3, 0.1745329F, 0.0F, 0.0F);
        this.H3.mirror = true;
        this.H4 = (new ModelRenderer(this, 46, 23)).setTextureSize(64, 32);
        this.H4.addBox(-2.0F, 1.5F, 2.0F, 5, 5, 4);
        this.H4.setRotationPoint(0.0F, 14.0F, -1.0F);
        this.setRotation(this.H4, 0.0F, 0.0F, 0.0F);
        this.H4.mirror = true;
        this.H5 = (new ModelRenderer(this, 32, 16)).setTextureSize(64, 32);
        this.H5.addBox(-1.0F, 2.0F, 4.5F, 3, 3, 4);
        this.H5.setRotationPoint(0.0F, 14.0F, -1.0F);
        this.setRotation(this.H5, 0.0F, 0.0F, 0.0F);
        this.H5.mirror = true;
        this.H6 = (new ModelRenderer(this, 52, 6)).setTextureSize(64, 32);
        this.H6.addBox(-0.5F, 2.5F, 7.5F, 2, 2, 4);
        this.H6.setRotationPoint(0.0F, 14.0F, -1.0F);
        this.setRotation(this.H6, 0.0F, 0.0F, 0.0F);
        this.H6.mirror = true;
        this.D_L_1 = (new ModelRenderer(this, 54, 0)).setTextureSize(64, 32);
        this.D_L_1.addBox(-2.0F, -1.5F, -2.0F, 2, 3, 3);
        this.D_L_1.setRotationPoint(-2.0F, 20.0F, -6.0F);
        this.setRotation(this.D_L_1, 0.0F, 0.0F, 0.0F);
        this.D_L_1.mirror = true;
        this.D_R_1 = (new ModelRenderer(this, 44, 0)).setTextureSize(64, 32);
        this.D_R_1.addBox(-1.0F, -1.5F, -2.0F, 2, 3, 3);
        this.D_R_1.setRotationPoint(4.0F, 20.0F, -6.0F);
        this.setRotation(this.D_R_1, 0.0F, 0.0F, 0.0F);
        this.D_R_1.mirror = true;
        this.D_L_2 = (new ModelRenderer(this, 20, 0)).setTextureSize(64, 32);
        this.D_L_2.addBox(-1.5F, 0.0F, -4.0F, 1, 2, 3);
        this.D_L_2.setRotationPoint(-2.0F, 20.0F, -6.0F);
        this.setRotation(this.D_L_2, 0.8726646F, 0.0F, 0.0F);
        this.D_L_2.mirror = true;
        this.D_R_2 = (new ModelRenderer(this, 12, 0)).setTextureSize(64, 32);
        this.D_R_2.addBox(-0.5F, 0.0F, -4.0F, 1, 2, 3);
        this.D_R_2.setRotationPoint(4.0F, 20.0F, -6.0F);
        this.setRotation(this.D_R_2, 0.8726646F, 0.0F, 0.0F);
        this.D_R_2.mirror = true;
        this.DD_L_1 = (new ModelRenderer(this, 0, 22)).setTextureSize(64, 32);
        this.DD_L_1.addBox(-2.0F, -2.5F, -2.0F, 2, 5, 5);
        this.DD_L_1.setRotationPoint(-2.0F, 19.0F, 1.0F);
        this.setRotation(this.DD_L_1, 0.0F, 0.0F, 0.0F);
        this.DD_L_1.mirror = true;
        this.D_D_R_1 = (new ModelRenderer(this, 14, 22)).setTextureSize(64, 32);
        this.D_D_R_1.addBox(-1.0F, -2.5F, -2.0F, 2, 5, 5);
        this.D_D_R_1.setRotationPoint(4.0F, 19.0F, 1.0F);
        this.setRotation(this.D_D_R_1, 0.0F, 0.0F, 0.0F);
        this.D_D_R_1.mirror = true;
        this.DD_L_2 = (new ModelRenderer(this, 24, 21)).setTextureSize(64, 32);
        this.DD_L_2.addBox(-1.5F, 2.5F, -4.0F, 1, 2, 3);
        this.DD_L_2.setRotationPoint(-2.0F, 19.0F, 1.0F);
        this.setRotation(this.DD_L_2, 1.22173F, 0.0F, 0.0F);
        this.DD_L_2.mirror = true;
        this.DD_R_2 = (new ModelRenderer(this, 24, 16)).setTextureSize(64, 32);
        this.DD_R_2.addBox(-0.5F, 2.533333F, -4.0F, 1, 2, 3);
        this.DD_R_2.setRotationPoint(4.0F, 19.0F, 1.0F);
        this.setRotation(this.DD_R_2, 1.22173F, 0.0F, 0.0F);
        this.DD_R_2.mirror = true;
        this.T1 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
        this.T1.addBox(0.0F, -2.5F, 8.0F, 1, 5, 3);
        this.T1.setRotationPoint(0.0F, 14.0F, -1.0F);
        this.setRotation(this.T1, 0.0F, 0.0F, 0.0F);
        this.T1.mirror = true;
        this.T2 = (new ModelRenderer(this, 12, 13)).setTextureSize(64, 32);
        this.T2.addBox(-0.5F, -3.5F, 2.0F, 2, 5, 4);
        this.T2.setRotationPoint(0.0F, 14.0F, -1.0F);
        this.setRotation(this.T2, 0.0F, 0.0F, 0.0F);
        this.T2.mirror = true;
        this.T3 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
        this.T3.addBox(-0.5F, -5.0F, 0.0F, 2, 5, 8);
        this.T3.setRotationPoint(0.0F, 14.0F, -6.0F);
        this.setRotation(this.T3, 0.0F, 0.0F, 0.0F);
        this.T3.mirror = true;
        this.T4 = (new ModelRenderer(this, 0, 13)).setTextureSize(64, 32);
        this.T4.addBox(-0.5F, -3.0F, -3.0F, 2, 5, 4);
        this.T4.setRotationPoint(0.0F, 14.0F, -6.0F);
        this.setRotation(this.T4, 0.2617994F, 0.0F, 0.0F);
        this.T4.mirror = true;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.H1.render(var7);
        this.H2.render(var7);
        this.H3.render(var7);
        this.H4.render(var7);
        this.H5.render(var7);
        this.H6.render(var7);
        this.D_L_1.render(var7);
        this.D_R_1.render(var7);
        this.D_L_2.render(var7);
        this.D_R_2.render(var7);
        this.DD_L_1.render(var7);
        this.D_D_R_1.render(var7);
        this.DD_L_2.render(var7);
        this.DD_R_2.render(var7);
        this.T1.render(var7);
        this.T2.render(var7);
        this.T3.render(var7);
        this.T4.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (!var7)
        {
            this.H4.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.34906584F * var2 + 0.0F;
            this.H5.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.43633232F * var2 + 0.0F;
            this.H6.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.4886922F * var2 + 0.0F;
            this.D_L_1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 0.0F;
            this.D_R_1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.D_L_2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 0.87266463F;
            this.D_R_2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.87266463F;
            this.DD_L_1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.DD_L_1.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.D_D_R_1.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 0.0F;
            this.D_D_R_1.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.DD_L_2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 1.2217305F;
            this.DD_L_2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.DD_R_2.rotateAngleX = MathHelper.cos(var1 / 0.95955384F) * -0.17453292F * var2 + 1.2217305F;
            this.DD_R_2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.T1.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.4886922F * var2 + 0.0F;
            this.T2.rotateAngleY = MathHelper.cos(var1 / 0.95955384F) * 0.34906584F * var2 + 0.0F;
            this.T2.rotateAngleZ = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.T3.rotateAngleZ = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
            this.T4.rotateAngleZ = MathHelper.cos(var1 / 0.95955384F) * 0.17453292F * var2 + 0.0F;
        }
    }
}
