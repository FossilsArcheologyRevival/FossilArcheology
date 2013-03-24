package fossil.entity.mob;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelPterosaurGround extends ModelDinosaurs
{
    public ModelRenderer Body = new ModelRenderer(this, 0, 0);
    public ModelRenderer Tail;
    public ModelRenderer right_leg;
    public ModelRenderer Left_leg;
    public ModelRenderer Neck_1;
    public ModelRenderer Neck_2;
    public ModelRenderer Head;
    public ModelRenderer lower_mouth;
    public ModelRenderer upper_mouth;
    public ModelRenderer crown;
    public ModelRenderer Right_wing_1;
    public ModelRenderer Right_wing_2;
    public ModelRenderer Left_wing_1;
    public ModelRenderer Left_wing_2;

    public ModelPterosaurGround()
    {
        this.Body.addBox(-2.0F, -3.0F, -2.0F, 4, 7, 4, 0.0F);
        this.Body.setRotationPoint(0.0F, 18.0F, 2.0F);
        this.Body.rotateAngleX = 0.587636F;
        this.Body.rotateAngleY = 0.0F;
        this.Body.rotateAngleZ = 0.0F;
        this.Body.mirror = false;
        this.Tail = new ModelRenderer(this, 0, 11);
        this.Tail.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 2, 0.0F);
        this.Tail.setRotationPoint(0.0F, 20.0F, 5.0F);
        this.Tail.rotateAngleX = 0.2260139F;
        this.Tail.rotateAngleY = 0.0F;
        this.Tail.rotateAngleZ = 0.0F;
        this.Tail.mirror = false;
        this.right_leg = new ModelRenderer(this, 40, 4);
        this.right_leg.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.right_leg.setRotationPoint(-1.0F, 22.0F, 2.0F);
        this.right_leg.rotateAngleX = -0.2712166F;
        this.right_leg.rotateAngleY = 0.0F;
        this.right_leg.rotateAngleZ = 0.0F;
        this.right_leg.mirror = false;
        this.Left_leg = new ModelRenderer(this, 40, 0);
        this.Left_leg.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.Left_leg.setRotationPoint(1.0F, 22.0F, 2.0F);
        this.Left_leg.rotateAngleX = -0.2712166F;
        this.Left_leg.rotateAngleY = 0.0F;
        this.Left_leg.rotateAngleZ = 0.0F;
        this.Left_leg.mirror = false;
        this.Neck_1 = new ModelRenderer(this, 8, 16);
        this.Neck_1.addBox(-1.0F, -2.0F, -1.0F, 2, 4, 2, 0.0F);
        this.Neck_1.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.Neck_1.rotateAngleX = 1.130069F;
        this.Neck_1.rotateAngleY = 0.0F;
        this.Neck_1.rotateAngleZ = 0.0F;
        this.Neck_1.mirror = false;
        this.Neck_2 = new ModelRenderer(this, 0, 16);
        this.Neck_2.addBox(-1.0F, -2.0F, -1.0F, 2, 4, 2, 0.0F);
        this.Neck_2.setRotationPoint(0.0F, 14.0F, -3.0F);
        this.Neck_2.rotateAngleX = 1.446489F;
        this.Neck_2.rotateAngleY = 0.0F;
        this.Neck_2.rotateAngleZ = 0.0F;
        this.Neck_2.mirror = false;
        this.Head = new ModelRenderer(this, 0, 23);
        this.Head.addBox(-2.0F, -5.0F, -1.0F, 4, 5, 4, 0.0F);
        this.Head.setRotationPoint(0.0F, 14.0F, -4.0F);
        this.Head.rotateAngleX = 1.571F;
        this.Head.rotateAngleY = 0.0F;
        this.Head.rotateAngleZ = 0.0F;
        this.Head.mirror = false;
        this.lower_mouth = new ModelRenderer(this, 44, 9);
        this.lower_mouth.addBox(-1.0F, -1.0F, -12.0F, 2, 1, 8, 0.0F);
        this.lower_mouth.setRotationPoint(0.0F, 14.0F, -4.0F);
        this.lower_mouth.rotateAngleX = 0.0F;
        this.lower_mouth.rotateAngleY = 0.0F;
        this.lower_mouth.rotateAngleZ = 0.0F;
        this.lower_mouth.mirror = false;
        this.upper_mouth = new ModelRenderer(this, 44, 0);
        this.upper_mouth.addBox(-1.0F, -2.0F, -12.0F, 2, 1, 8, 0.0F);
        this.upper_mouth.setRotationPoint(0.0F, 14.0F, -4.0F);
        this.upper_mouth.rotateAngleX = 0.0F;
        this.upper_mouth.rotateAngleY = 0.0F;
        this.upper_mouth.rotateAngleZ = 0.0F;
        this.upper_mouth.mirror = false;
        this.crown = new ModelRenderer(this, 16, 22);
        this.crown.addBox(-1.0F, -5.0F, -1.0F, 2, 4, 6, 0.0F);
        this.crown.setRotationPoint(0.0F, 14.0F, -4.0F);
        this.crown.rotateAngleX = 0.698F;
        this.crown.rotateAngleY = 0.0F;
        this.crown.rotateAngleZ = 0.0F;
        this.crown.mirror = false;
        this.Right_wing_1 = new ModelRenderer(this, 16, 7);
        this.Right_wing_1.addBox(0.0F, 0.0F, -1.0F, 8, 6, 1, 0.0F);
        this.Right_wing_1.setRotationPoint(-2.0F, 16.0F, 1.0F);
        this.Right_wing_1.rotateAngleX = -0.349F;
        this.Right_wing_1.rotateAngleY = 2.269F;
        this.Right_wing_1.rotateAngleZ = -0.524F;
        this.Right_wing_1.mirror = false;
        this.Right_wing_2 = new ModelRenderer(this, 46, 18);
        this.Right_wing_2.addBox(-1.0F, -1.0F, -1.0F, 8, 4, 1, 0.0F);
        this.Right_wing_2.setRotationPoint(-6.9F, 20.0F, -4.0F);
        this.Right_wing_2.rotateAngleX = 2.541F;
        this.Right_wing_2.rotateAngleY = -0.419F;
        this.Right_wing_2.rotateAngleZ = -3.002F;
        this.Right_wing_2.mirror = false;
        this.Left_wing_1 = new ModelRenderer(this, 16, 0);
        this.Left_wing_1.addBox(0.0F, 0.0F, 0.0F, 8, 6, 1, 0.0F);
        this.Left_wing_1.setRotationPoint(2.0F, 16.0F, 1.0F);
        this.Left_wing_1.rotateAngleX = 0.349F;
        this.Left_wing_1.rotateAngleY = 0.873F;
        this.Left_wing_1.rotateAngleZ = 0.542F;
        this.Left_wing_1.mirror = false;
        this.Left_wing_2 = new ModelRenderer(this, 46, 23);
        this.Left_wing_2.addBox(-1.0F, -1.0F, 0.0F, 8, 4, 1, 0.0F);
        this.Left_wing_2.setRotationPoint(6.9F, 20.0F, -4.0F);
        this.Left_wing_2.rotateAngleX = 0.583F;
        this.Left_wing_2.rotateAngleY = -0.419F;
        this.Left_wing_2.rotateAngleZ = -0.14F;
        this.Left_wing_2.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.Body.render(var7);
        this.Tail.render(var7);
        this.right_leg.render(var7);
        this.Left_leg.render(var7);
        this.Neck_1.render(var7);
        this.Neck_2.render(var7);
        this.Head.render(var7);
        this.lower_mouth.render(var7);
        this.upper_mouth.render(var7);
        this.crown.render(var7);
        this.Right_wing_1.render(var7);
        this.Right_wing_2.render(var7);
        this.Left_wing_1.render(var7);
        this.Left_wing_2.render(var7);
    }

    public void OpenMouth(int var1)
    {
        if (this.lower_mouth.rotateAngleX < 0.109F)
        {
            this.lower_mouth.rotateAngleX += 0.109F / (float)var1;
        }
        else
        {
            this.lower_mouth.rotateAngleX = 0.109F;
        }
    }

    public void CloseMouth(int var1)
    {
        if (this.lower_mouth.rotateAngleX > 0.0F)
        {
            this.lower_mouth.rotateAngleX -= 0.109F / (float)var1;
        }
        else
        {
            this.lower_mouth.rotateAngleX = 0.0F;
        }
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (var7==false)
        {
            this.crown.rotateAngleY = this.upper_mouth.rotateAngleY = this.lower_mouth.rotateAngleY = this.Head.rotateAngleY = -var4 / (180F / (float)Math.PI);
            this.right_leg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2 - 0.271F;
            this.Left_leg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2 - 0.271F;
        }
    }
}
