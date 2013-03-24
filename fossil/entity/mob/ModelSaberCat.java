package fossil.entity.mob;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelSaberCat extends ModelBase
{
    protected float field_40331_g = 4.0F;
    protected float field_40332_n = 2.0F;
    ModelRenderer T1 = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 32);
    ModelRenderer T2;
    ModelRenderer T3;
    ModelRenderer T4;
    ModelRenderer T5__R1;
    ModelRenderer T5__L1;
    ModelRenderer T5__R2;
    ModelRenderer T5__L2;
    ModelRenderer H1;
    ModelRenderer H2;
    ModelRenderer H3;
    ModelRenderer D__R1;
    ModelRenderer D__L1;
    ModelRenderer D__R2;
    ModelRenderer D__L2;
    ModelRenderer T6__R;
    ModelRenderer T6__L;
    ModelRenderer C1;
    ModelRenderer C2;

    public ModelSaberCat()
    {
        this.T1.addBox(-2.5F, -1.5F, -4.0F, 5, 4, 4);
        this.T1.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T1, 0.0F, 0.0F, 0.0F);
        this.T1.mirror = true;
        this.T2 = (new ModelRenderer(this, 18, 0)).setTextureSize(64, 32);
        this.T2.addBox(-1.0F, -1.0F, -7.0F, 2, 1, 3);
        this.T2.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T2, 0.0F, 0.0F, 0.0F);
        this.T2.mirror = true;
        this.T3 = (new ModelRenderer(this, 18, 5)).setTextureSize(64, 32);
        this.T3.addBox(-2.0F, 0.0F, -7.0F, 4, 2, 3);
        this.T3.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T3, 0.0F, 0.0F, 0.0F);
        this.T3.mirror = true;
        this.T4 = (new ModelRenderer(this, 48, 7)).setTextureSize(64, 32);
        this.T4.addBox(-1.0F, 0.0F, -3.5F, 2, 1, 3);
        this.T4.setRotationPoint(0.0F, 16.5F, -6.0F);
        this.setRotation(this.T4, 0.1745329F, 0.0F, 0.0F);
        this.T4.mirror = true;
        this.T5__R1 = (new ModelRenderer(this, 44, 14)).setTextureSize(64, 32);
        this.T5__R1.addBox(-1.5F, 2.0F, -6.0F, 1, 2, 1);
        this.T5__R1.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T5__R1, 0.0F, 0.0F, 0.0F);
        this.T5__R1.mirror = true;
        this.T5__L1 = (new ModelRenderer(this, 44, 14)).setTextureSize(64, 32);
        this.T5__L1.addBox(0.5F, 2.0F, -6.0F, 1, 2, 1);
        this.T5__L1.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T5__L1, 0.0F, 0.0F, 0.0F);
        this.T5__L1.mirror = true;
        this.T5__R2 = (new ModelRenderer(this, 44, 17)).setTextureSize(64, 32);
        this.T5__R2.addBox(-1.5F, 4.0F, -6.0F, 1, 2, 1);
        this.T5__R2.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T5__R2, 0.0F, 0.0F, 0.0F);
        this.T5__R2.mirror = true;
        this.T5__L2 = (new ModelRenderer(this, 44, 17)).setTextureSize(64, 32);
        this.T5__L2.addBox(0.5F, 4.0F, -6.0F, 1, 2, 1);
        this.T5__L2.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T5__L2, 0.0F, 0.0F, 0.0F);
        this.T5__L2.mirror = true;
        this.H1 = (new ModelRenderer(this, 0, 11)).setTextureSize(64, 32);
        this.H1.addBox(-3.5F, -2.5F, -3.0F, 7, 6, 4);
        this.H1.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.setRotation(this.H1, 0.0F, 0.0F, 0.0F);
        this.H1.mirror = true;
        this.H2 = (new ModelRenderer(this, 0, 21)).setTextureSize(64, 32);
        this.H2.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 6);
        this.H2.setRotationPoint(0.0F, 16.0F, 1.0F);
        this.setRotation(this.H2, 0.0F, 0.0F, 0.0F);
        this.H2.mirror = true;
        this.H3 = (new ModelRenderer(this, 44, 7)).setTextureSize(64, 32);
        this.H3.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1);
        this.H3.setRotationPoint(0.0F, 14.0F, 6.5F);
        this.setRotation(this.H3, 0.5576792F, 0.0F, 0.0F);
        this.H3.mirror = true;
        this.D__R1 = (new ModelRenderer(this, 40, 0)).setTextureSize(64, 32);
        this.D__R1.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.D__R1.setRotationPoint(-1.5F, 19.0F, -2.0F);
        this.setRotation(this.D__R1, 0.0F, 0.0F, 0.0F);
        this.D__R1.mirror = true;
        this.D__L1 = (new ModelRenderer(this, 32, 0)).setTextureSize(64, 32);
        this.D__L1.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.D__L1.setRotationPoint(1.5F, 19.0F, -2.0F);
        this.setRotation(this.D__L1, 0.0F, 0.0F, 0.0F);
        this.D__L1.mirror = true;
        this.D__R2 = (new ModelRenderer(this, 56, 0)).setTextureSize(64, 32);
        this.D__R2.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.D__R2.setRotationPoint(-1.5F, 19.0F, 6.0F);
        this.setRotation(this.D__R2, 0.0F, 0.0F, 0.0F);
        this.D__R2.mirror = true;
        this.D__L2 = (new ModelRenderer(this, 48, 0)).setTextureSize(64, 32);
        this.D__L2.addBox(-1.0F, -0.5F, -1.0F, 2, 5, 2);
        this.D__L2.setRotationPoint(1.5F, 19.0F, 6.0F);
        this.setRotation(this.D__L2, 0.0F, 0.0F, 0.0F);
        this.D__L2.mirror = true;
        this.T6__R = (new ModelRenderer(this, 6, 8)).setTextureSize(64, 32);
        this.T6__R.addBox(-2.5F, -2.5F, -3.0F, 1, 1, 2);
        this.T6__R.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T6__R, 0.0F, 0.0F, 0.0F);
        this.T6__R.mirror = true;
        this.T6__L = (new ModelRenderer(this, 0, 8)).setTextureSize(64, 32);
        this.T6__L.addBox(1.5F, -2.5F, -3.0F, 1, 1, 2);
        this.T6__L.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.T6__L, 0.0F, 0.0F, 0.0F);
        this.T6__L.mirror = true;
        this.C1 = (new ModelRenderer(this, 22, 20)).setTextureSize(64, 32);
        this.C1.addBox(-4.0F, -3.0F, -3.5F, 8, 7, 5);
        this.C1.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.setRotation(this.C1, 0.0F, 0.0F, 0.0F);
        this.C1.mirror = true;
        this.C2 = (new ModelRenderer(this, 22, 10)).setTextureSize(64, 32);
        this.C2.addBox(-3.0F, -2.0F, -4.5F, 6, 5, 5);
        this.C2.setRotationPoint(0.0F, 15.0F, -3.0F);
        this.setRotation(this.C2, 0.0F, 0.0F, 0.0F);
        this.C2.mirror = true;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving var1, float var2, float var3, float var4)
    {
        EntitySaberCat var5 = (EntitySaberCat)var1;

        if (var5.isAngry())
        {
            this.H3.rotateAngleY = 0.0F;
        }
        else
        {
            this.H3.rotateAngleY = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
        }

        if (var5.isSitting())
        {
            this.H1.setRotationPoint(0.0F, 17.0F, 0.0F);
            this.H1.rotateAngleX = -0.314F;
            this.H1.rotateAngleY = 0.0F;
            this.C1.setRotationPoint(0.0F, 17.0F, 0.0F);
            this.C1.rotateAngleX = -0.314F;
            this.C1.rotateAngleY = 0.0F;
            this.H2.setRotationPoint(0.0F, 20.0F, -1.0F);
            this.H2.rotateAngleX = -((float)Math.PI / 4F);
            this.H3.setRotationPoint(0.0F, 23.0F, 4.5F);
            this.D__R2.setRotationPoint(-1.5F, 25.0F, 1.0F);
            this.D__R2.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.D__L2.setRotationPoint(1.5F, 25.0F, 1.0F);
            this.D__L2.rotateAngleX = ((float)Math.PI * 3F / 2F);
            this.D__R1.rotateAngleX = 5.811947F;
            this.D__R1.setRotationPoint(-1.5F, 20.0F, -2.0F);
            this.D__L1.rotateAngleX = 5.811947F;
            this.D__L1.setRotationPoint(1.5F, 20.0F, -2.0F);
        }
        else
        {
            this.H1.setRotationPoint(0.0F, 15.0F, 0.0F);
            this.H2.setRotationPoint(0.0F, 16.0F, 1.0F);
            this.H2.rotateAngleX = 0.0F;
            this.H1.rotateAngleX = this.H2.rotateAngleX;
            this.C1.setRotationPoint(0.0F, 15.0F, 0.0F);
            this.C1.rotateAngleX = this.H1.rotateAngleX;
            this.H3.setRotationPoint(0.0F, 14.0F, 6.5F);
            this.D__R2.setRotationPoint(-1.5F, 19.0F, 6.0F);
            this.D__L2.setRotationPoint(1.5F, 19.0F, 6.0F);
            this.D__R1.setRotationPoint(-1.5F, 19.0F, -2.0F);
            this.D__L1.setRotationPoint(1.5F, 19.0F, -2.0F);
            this.D__R2.rotateAngleX = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
            this.D__L2.rotateAngleX = MathHelper.cos(var2 * 0.6662F + (float)Math.PI) * 1.4F * var3;
            this.D__R1.rotateAngleX = MathHelper.cos(var2 * 0.6662F + (float)Math.PI) * 1.4F * var3;
            this.D__L1.rotateAngleX = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
        }

        float var6 = var5.getInterestedAngle(var4) + var5.getShakeAngle(var4, 0.0F);
        this.T1.rotateAngleZ = this.T2.rotateAngleZ = this.T3.rotateAngleZ = this.T4.rotateAngleZ = this.T5__R1.rotateAngleZ = this.T5__L1.rotateAngleZ = this.T5__R2.rotateAngleZ = this.T5__L2.rotateAngleZ = this.T6__R.rotateAngleZ = this.T6__L.rotateAngleZ = var6;
        this.H1.rotateAngleZ = var5.getShakeAngle(var4, -0.08F);
        this.H2.rotateAngleZ = var5.getShakeAngle(var4, -0.16F);
        this.H3.rotateAngleZ = var5.getShakeAngle(var4, -0.2F);

        if (var5.getWolfShaking())
        {
            float var7 = var5.getBrightness(var4) * var5.getShadingWhileShaking(var4);
            GL11.glColor3f(var7, var7, var7);
        }
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
        float var8 = 2.0F;

        if (this.isChild)
        {
            float var9 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 0.0F, 0.0F);
            this.T1.render(var7);
            this.T2.render(var7);
            this.T3.render(var7);
            this.T4.render(var7);
            this.T5__R1.render(var7);
            this.T5__L1.render(var7);
            this.T5__R2.render(var7);
            this.T5__L2.render(var7);
            this.T6__R.render(var7);
            this.T6__L.render(var7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(2.0F / var9, 2.0F / var9, 2.0F / var9);
            GL11.glTranslatef(0.0F, 0.0F, 0.0F);
            this.H1.render(var7);
            this.H2.render(var7);
            this.H3.render(var7);
            this.D__R1.render(var7);
            this.D__L1.render(var7);
            this.D__R2.render(var7);
            this.D__L2.render(var7);
            this.C1.render(var7);
            this.C2.render(var7);
            GL11.glPopMatrix();
        }
        else
        {
            GL11.glPushMatrix();
            GL11.glScalef(2.0F, 2.0F, 2.0F);
            GL11.glTranslatef(0.0F, -0.8F, 0.0F);
            this.T1.render(var7);
            this.T2.render(var7);
            this.T3.render(var7);
            this.T4.render(var7);
            this.T5__R1.render(var7);
            this.T5__L1.render(var7);
            this.T5__R2.render(var7);
            this.T5__L2.render(var7);
            this.H1.render(var7);
            this.H2.render(var7);
            this.H3.render(var7);
            this.D__R1.render(var7);
            this.D__L1.render(var7);
            this.D__R2.render(var7);
            this.D__L2.render(var7);
            this.T6__R.render(var7);
            this.T6__L.render(var7);
            this.C1.render(var7);
            this.C2.render(var7);
            GL11.glPopMatrix();
        }
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7)
    {
        super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
}
