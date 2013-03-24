package fossil.entity.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelNautilus extends ModelBase
{
    public ModelRenderer Shell = new ModelRenderer(this, 0, 12);
    public ModelRenderer Head;
    public ModelRenderer Tech1;
    public ModelRenderer Tech2;
    public ModelRenderer Tech3;
    public ModelRenderer Tech4;
    public ModelRenderer Tech5;
    public ModelRenderer Tech6;

    public ModelNautilus()
    {
        this.Shell.addBox(-2.0F, -5.0F, -5.0F, 4, 10, 10, 0.0F);
        this.Shell.setRotationPoint(2.0F, 1.0F, 1.0F);
        this.Shell.rotateAngleX = 0.0F;
        this.Shell.rotateAngleY = 0.0F;
        this.Shell.rotateAngleZ = 0.0F;
        this.Shell.mirror = false;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-3.0F, 1.0F, -7.0F, 6, 6, 6, 0.0F);
        this.Head.setRotationPoint(2.0F, 1.0F, 1.0F);
        this.Head.rotateAngleX = -0.8588527F;
        this.Head.rotateAngleY = 0.0F;
        this.Head.rotateAngleZ = 0.0F;
        this.Head.mirror = false;
        this.Tech1 = new ModelRenderer(this, 0, 12);
        this.Tech1.addBox(-1.0F, -1.0F, -2.0F, 1, 8, 1, 0.0F);
        this.Tech1.setRotationPoint(2.0F, 2.0F, -6.0F);
        this.Tech1.rotateAngleX = 0.0F;
        this.Tech1.rotateAngleY = 0.0F;
        this.Tech1.rotateAngleZ = 0.0F;
        this.Tech1.mirror = false;
        this.Tech2 = new ModelRenderer(this, 0, 12);
        this.Tech2.addBox(-2.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Tech2.setRotationPoint(2.0F, 2.0F, -6.0F);
        this.Tech2.rotateAngleX = 0.0F;
        this.Tech2.rotateAngleY = 0.0F;
        this.Tech2.rotateAngleZ = 0.0F;
        this.Tech2.mirror = false;
        this.Tech3 = new ModelRenderer(this, 0, 12);
        this.Tech3.addBox(2.0F, 1.0F, 0.0F, 1, 8, 1, 0.0F);
        this.Tech3.setRotationPoint(1.0F, 2.0F, -6.0F);
        this.Tech3.rotateAngleX = 0.0F;
        this.Tech3.rotateAngleY = 0.0F;
        this.Tech3.rotateAngleZ = 0.0F;
        this.Tech3.mirror = false;
        this.Tech4 = new ModelRenderer(this, 0, 12);
        this.Tech4.addBox(1.0F, 0.0F, -1.0F, 1, 8, 1, 0.0F);
        this.Tech4.setRotationPoint(2.0F, 2.0F, -6.0F);
        this.Tech4.rotateAngleX = 0.0F;
        this.Tech4.rotateAngleY = 0.0F;
        this.Tech4.rotateAngleZ = 0.0F;
        this.Tech4.mirror = false;
        this.Tech5 = new ModelRenderer(this, 0, 12);
        this.Tech5.addBox(0.0F, -1.0F, -2.0F, 1, 8, 1, 0.0F);
        this.Tech5.setRotationPoint(2.0F, 2.0F, -6.0F);
        this.Tech5.rotateAngleX = 0.0F;
        this.Tech5.rotateAngleY = 0.0F;
        this.Tech5.rotateAngleZ = 0.0F;
        this.Tech5.mirror = false;
        this.Tech6 = new ModelRenderer(this, 0, 12);
        this.Tech6.addBox(-2.0F, 1.0F, 0.0F, 1, 8, 1, 0.0F);
        this.Tech6.setRotationPoint(2.0F, 2.0F, -6.0F);
        this.Tech6.rotateAngleX = 0.0F;
        this.Tech6.rotateAngleY = 0.0F;
        this.Tech6.rotateAngleZ = 0.0F;
        this.Tech6.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        this.Shell.render(var7);
        this.Head.render(var7);
        this.Tech1.render(var7);
        this.Tech2.render(var7);
        this.Tech3.render(var7);
        this.Tech4.render(var7);
        this.Tech5.render(var7);
        this.Tech6.render(var7);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        this.Tech1.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 1.0F) + 0.4F;
        this.Tech2.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 2.0F) + 0.4F;
        this.Tech3.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 3.0F) + 0.4F;
        this.Tech4.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 4.0F) + 0.4F;
        this.Tech5.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 5.0F) + 0.4F;
        this.Tech6.rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + 6.0F) + 0.4F;
    }
}
