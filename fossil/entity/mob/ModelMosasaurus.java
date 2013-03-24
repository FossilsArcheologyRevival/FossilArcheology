package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMosasaurus extends ModelDinosaurs
{
    ModelRenderer Body = new ModelRenderer(this, 32, 0);
    ModelRenderer Tail_1;
    ModelRenderer Tail_2;
    ModelRenderer Tail_3;
    ModelRenderer Head;
    ModelRenderer Upper_Jaws;
    ModelRenderer right_arm;
    ModelRenderer Left_arm;
    ModelRenderer Right_Leg;
    ModelRenderer Left_Leg;
    ModelRenderer Lower_jaw;
    ModelRenderer Upper_Teeth;
    ModelRenderer Tail_3_dec;
    ModelRenderer Tail_2_dec;

    public ModelMosasaurus()
    {
        this.Body.addBox(-4.0F, 0.0F, 0.0F, 8, 6, 8);
        this.Body.setRotationPoint(1.0F, 16.0F, 0.0F);
        this.Body.rotateAngleX = 0.0F;
        this.Body.rotateAngleY = 0.0F;
        this.Body.rotateAngleZ = 0.0F;
        this.Body.mirror = false;
        this.Tail_1 = new ModelRenderer(this, 35, 14);
        this.Tail_1.addBox(-3.0F, -2.0F, -4.0F, 6, 4, 6);
        this.Tail_1.setRotationPoint(1.0F, 19.0F, 11.0F);
        this.Tail_1.rotateAngleX = 0.0F;
        this.Tail_1.rotateAngleY = 0.0F;
        this.Tail_1.rotateAngleZ = 0.0F;
        this.Tail_1.mirror = false;
        this.Tail_2 = new ModelRenderer(this, 36, 24);
        this.Tail_2.addBox(-2.0F, -1.0F, -4.0F, 4, 2, 6);
        this.Tail_2.setRotationPoint(1.0F, 19.0F, 16.0F);
        this.Tail_2.rotateAngleX = 0.0F;
        this.Tail_2.rotateAngleY = 0.0F;
        this.Tail_2.rotateAngleZ = 0.0F;
        this.Tail_2.mirror = false;
        this.Tail_3 = new ModelRenderer(this, 16, 8);
        this.Tail_3.addBox(-1.0F, -1.0F, -4.0F, 2, 2, 6);
        this.Tail_3.setRotationPoint(1.0F, 19.0F, 21.0F);
        this.Tail_3.rotateAngleX = 0.0F;
        this.Tail_3.rotateAngleY = 0.0F;
        this.Tail_3.rotateAngleZ = 0.0F;
        this.Tail_3.mirror = false;
        this.Head = new ModelRenderer(this, 0, 24);
        this.Head.addBox(-3.0F, -2.0F, -4.0F, 6, 4, 4);
        this.Head.setRotationPoint(1.0F, 19.0F, 0.0F);
        this.Head.rotateAngleX = 0.0F;
        this.Head.rotateAngleY = 0.0F;
        this.Head.rotateAngleZ = 0.0F;
        this.Head.mirror = false;
        this.Upper_Jaws = new ModelRenderer(this, 17, 22);
        this.Upper_Jaws.addBox(-2.0F, -1.0F, -9.0F, 4, 1, 5);
        this.Upper_Jaws.setRotationPoint(1.0F, 19.0F, 0.0F);
        this.Upper_Jaws.rotateAngleX = 0.0F;
        this.Upper_Jaws.rotateAngleY = 0.0F;
        this.Upper_Jaws.rotateAngleZ = 0.0F;
        this.Upper_Jaws.mirror = false;
        this.right_arm = new ModelRenderer(this, 0, 0);
        this.right_arm.addBox(-4.0F, 0.0F, 0.0F, 4, 1, 6);
        this.right_arm.setRotationPoint(-3.0F, 20.0F, 0.0F);
        this.right_arm.rotateAngleX = -0.34907F;
        this.right_arm.rotateAngleY = -1.0472F;
        this.right_arm.rotateAngleZ = -0.43633F;
        this.right_arm.mirror = false;
        this.Left_arm = new ModelRenderer(this, 0, 0);
        this.Left_arm.addBox(0.0F, 0.0F, 0.0F, 4, 1, 6);
        this.Left_arm.setRotationPoint(5.0F, 20.0F, 0.0F);
        this.Left_arm.rotateAngleX = -0.34907F;
        this.Left_arm.rotateAngleY = 1.0472F;
        this.Left_arm.rotateAngleZ = 0.43633F;
        this.Left_arm.mirror = false;
        this.Right_Leg = new ModelRenderer(this, 20, 1);
        this.Right_Leg.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 5);
        this.Right_Leg.setRotationPoint(-2.0F, 20.0F, 7.0F);
        this.Right_Leg.rotateAngleX = -0.34907F;
        this.Right_Leg.rotateAngleY = -0.87266F;
        this.Right_Leg.rotateAngleZ = -0.43633F;
        this.Right_Leg.mirror = false;
        this.Left_Leg = new ModelRenderer(this, 20, 1);
        this.Left_Leg.addBox(0.0F, 0.0F, 0.0F, 3, 1, 5);
        this.Left_Leg.setRotationPoint(4.0F, 20.0F, 7.0F);
        this.Left_Leg.rotateAngleX = -0.34907F;
        this.Left_Leg.rotateAngleY = 0.87266F;
        this.Left_Leg.rotateAngleZ = 0.43633F;
        this.Left_Leg.mirror = false;
        this.Lower_jaw = new ModelRenderer(this, 0, 7);
        this.Lower_jaw.addBox(-1.0F, 0.0F, -8.0F, 2, 2, 6);
        this.Lower_jaw.setRotationPoint(1.0F, 19.0F, 0.0F);
        this.Lower_jaw.rotateAngleX = 0.0F;
        this.Lower_jaw.rotateAngleY = 0.0F;
        this.Lower_jaw.rotateAngleZ = 0.0F;
        this.Lower_jaw.mirror = false;
        this.Upper_Teeth = new ModelRenderer(this, 0, 16);
        this.Upper_Teeth.addBox(-2.0F, 0.0F, -9.0F, 4, 2, 6);
        this.Upper_Teeth.setRotationPoint(1.0F, 19.0F, 0.0F);
        this.Upper_Teeth.rotateAngleX = 0.0F;
        this.Upper_Teeth.rotateAngleY = 0.0F;
        this.Upper_Teeth.rotateAngleZ = 0.0F;
        this.Upper_Teeth.mirror = false;
        this.Tail_3_dec = new ModelRenderer(this, 26, 23);
        this.Tail_3_dec.addBox(0.0F, -2.0F, -2.0F, 1, 2, 5);
        this.Tail_3_dec.setRotationPoint(1.0F, 19.0F, 20.0F);
        this.Tail_3_dec.rotateAngleX = 0.0F;
        this.Tail_3_dec.rotateAngleY = 0.0F;
        this.Tail_3_dec.rotateAngleZ = 0.0F;
        this.Tail_3_dec.mirror = false;
        this.Tail_2_dec = new ModelRenderer(this, 26, 22);
        this.Tail_2_dec.addBox(0.0F, -3.0F, -4.0F, 1, 2, 6);
        this.Tail_2_dec.setRotationPoint(1.0F, 19.0F, 16.0F);
        this.Tail_2_dec.rotateAngleX = 0.0F;
        this.Tail_2_dec.rotateAngleY = 0.0F;
        this.Tail_2_dec.rotateAngleZ = 0.0F;
        this.Tail_2_dec.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.Body.render(var7);
        this.Tail_1.render(var7);
        this.Tail_2.render(var7);
        this.Tail_3.render(var7);
        this.Head.render(var7);
        this.Upper_Jaws.render(var7);
        this.right_arm.render(var7);
        this.Left_arm.render(var7);
        this.Right_Leg.render(var7);
        this.Left_Leg.render(var7);
        this.Lower_jaw.render(var7);
        this.Upper_Teeth.render(var7);
        this.Tail_3_dec.render(var7);
        this.Tail_2_dec.render(var7);
    }

    public void OpenMouth(int var1)
    {
        if ((double)this.Lower_jaw.rotateAngleX < 0.349066D)
        {
            this.Lower_jaw.rotateAngleX = (float)((double)this.Lower_jaw.rotateAngleX + 0.349066D / (double)var1);
        }
        else
        {
            this.Lower_jaw.rotateAngleX = 0.349066F;
        }

        if ((double)this.Upper_Jaws.rotateAngleX > -0.174533D)
        {
            this.Upper_Jaws.rotateAngleX = (float)((double)this.Upper_Jaws.rotateAngleX - 0.174533D / (double)var1);
        }
        else
        {
            this.Upper_Jaws.rotateAngleX = -0.174533F;
        }

        this.Upper_Teeth.rotateAngleX = this.Upper_Jaws.rotateAngleX;
    }

    public void CloseMouth(int var1)
    {
        if (this.Lower_jaw.rotateAngleX > 0.0F)
        {
            this.Lower_jaw.rotateAngleX = (float)((double)this.Lower_jaw.rotateAngleX - 0.349066D / (double)var1);
        }
        else
        {
            this.Lower_jaw.rotateAngleX = 0.0F;
        }

        if (this.Upper_Jaws.rotateAngleX < 0.0F)
        {
            this.Upper_Jaws.rotateAngleX = (float)((double)this.Upper_Jaws.rotateAngleX + 0.174533D / (double)var1);
        }
        else
        {
            this.Upper_Jaws.rotateAngleX = 0.0F;
        }

        this.Upper_Teeth.rotateAngleX = this.Upper_Jaws.rotateAngleX;
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (!var7)
        {
            this.Body.rotateAngleY = (float)((double)MathHelper.cos(var1 / 1.9191077F) * -0.0872664625997165D * (double)var2 + 0.0D);
            this.Tail_1.rotateAngleY = (float)((double)MathHelper.cos(var1 / 1.9191077F) * 0.174532925199433D * (double)var2 + 0.0D);
            this.Tail_2.rotateAngleY = (float)((double)MathHelper.cos(var1 / 1.9191077F) * -0.174532925199433D * (double)var2 + 0.0D);
            this.Tail_3.rotateAngleY = (float)((double)MathHelper.cos(var1 / 1.9191077F) * 0.174532925199433D * (double)var2 + 0.0D);
            this.right_arm.rotateAngleY = (float)((double)MathHelper.cos(var1 / 5.7573233F) * -0.174532925199433D * (double)var2 + -1.0471975511966D);
            this.Left_arm.rotateAngleY = (float)((double)MathHelper.cos(var1 / 5.7573233F) * 0.174532925199433D * (double)var2 + 1.0471975511966D);
            this.Right_Leg.rotateAngleY = (float)((double)MathHelper.cos(var1 / 5.7573233F) * -0.174532925199433D * (double)var2 + -0.872664625997165D);
            this.Left_Leg.rotateAngleY = (float)((double)MathHelper.cos(var1 / 5.7573233F) * 0.174532925199433D * (double)var2 + 0.872664625997165D);
            this.Tail_3_dec.rotateAngleY = (float)((double)MathHelper.cos(var1 / 1.9191077F) * 0.174532925199433D * (double)var2 + 0.0D);
            this.Tail_2_dec.rotateAngleY = (float)((double)MathHelper.cos(var1 / 1.9191077F) * -0.174532925199433D * (double)var2 + 0.0D);
        }
    }
}
