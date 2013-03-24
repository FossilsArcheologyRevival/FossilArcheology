package fossil.entity.mob;


import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPterosaurFlying extends ModelPterosaurGround
{
    public ModelRenderer Body = new ModelRenderer(this, 0, 0);
    public ModelRenderer Neck_1;
    public ModelRenderer New_Shape1;
    public ModelRenderer Left_wing_1;
    public ModelRenderer Right_wing_1;
    public ModelRenderer Left_wing_2;
    public ModelRenderer Right_wing_2;
    public ModelRenderer Tail;
    public ModelRenderer crown;
    public ModelRenderer Head;
    public ModelRenderer upper_mouth;
    public ModelRenderer lower_mouth;
    public ModelRenderer Left_leg;
    public ModelRenderer right_leg;
    public float LeftWingRandomFlap = 0.0F;
    public float RightWingRandomFlap = 0.0F;
    public float AirRoll = 0.0F;
    public float AirPitch = 0.0F;

    public ModelPterosaurFlying()
    {
        this.Body.addBox(-2.0F, -3.5F, -2.0F, 4, 7, 4, 0.0F);
        this.Body.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Body.rotateAngleX = ((float)Math.PI / 2F);
        this.Body.rotateAngleY = 0.0F;
        this.Body.rotateAngleZ = 0.0F;
        this.Body.mirror = false;
        this.Neck_1 = new ModelRenderer(this, 8, 16);
        this.Neck_1.addBox(-1.0F, -7.0F, -1.0F, 2, 4, 2, 0.0F);
        this.Neck_1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Neck_1.rotateAngleX = ((float)Math.PI / 2F);
        this.Neck_1.rotateAngleY = 0.0F;
        this.Neck_1.rotateAngleZ = 0.0F;
        this.Neck_1.mirror = false;
        this.New_Shape1 = new ModelRenderer(this, 0, 16);
        this.New_Shape1.addBox(-1.0F, -11.0F, -1.0F, 2, 4, 2, 0.0F);
        this.New_Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.New_Shape1.rotateAngleX = ((float)Math.PI / 2F);
        this.New_Shape1.rotateAngleY = 0.0F;
        this.New_Shape1.rotateAngleZ = 0.0F;
        this.New_Shape1.mirror = false;
        this.Left_wing_1 = new ModelRenderer(this, 16, 0);
        this.Left_wing_1.addBox(2.0F, -3.0F, 0.0F, 8, 6, 1, 0.0F);
        this.Left_wing_1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Left_wing_1.rotateAngleX = -((float)Math.PI / 2F);
        this.Left_wing_1.rotateAngleY = (float)Math.PI;
        this.Left_wing_1.rotateAngleZ = 2.792527F;
        this.Left_wing_1.mirror = false;
        this.Right_wing_1 = new ModelRenderer(this, 16, 7);
        this.Right_wing_1.addBox(2.0F, -3.0F, -1.0F, 8, 6, 1, 0.0F);
        this.Right_wing_1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Right_wing_1.rotateAngleX = ((float)Math.PI / 2F);
        this.Right_wing_1.rotateAngleY = 0.0F;
        this.Right_wing_1.rotateAngleZ = -2.792527F;
        this.Right_wing_1.mirror = false;
        this.Left_wing_2 = new ModelRenderer(this, 46, 23);
        this.Left_wing_2.addBox(9.0F, -3.0F, 3.0F, 8, 4, 1, 0.0F);
        this.Left_wing_2.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Left_wing_2.rotateAngleX = ((float)Math.PI / 2F);
        this.Left_wing_2.rotateAngleY = 0.0F;
        this.Left_wing_2.rotateAngleZ = 0.0F;
        this.Left_wing_2.mirror = false;
        this.Right_wing_2 = new ModelRenderer(this, 46, 18);
        this.Right_wing_2.addBox(9.0F, -3.0F, -4.0F, 8, 4, 1, 0.0F);
        this.Right_wing_2.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Right_wing_2.rotateAngleX = -((float)Math.PI / 2F);
        this.Right_wing_2.rotateAngleY = (float)Math.PI;
        this.Right_wing_2.rotateAngleZ = 0.0F;
        this.Right_wing_2.mirror = false;
        this.Tail = new ModelRenderer(this, 0, 11);
        this.Tail.addBox(-2.0F, 2.0F, 0.0F, 4, 3, 2, 0.0F);
        this.Tail.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Tail.rotateAngleX = ((float)Math.PI / 2F);
        this.Tail.rotateAngleY = 0.0F;
        this.Tail.rotateAngleZ = 0.0F;
        this.Tail.mirror = false;
        this.crown = new ModelRenderer(this, 16, 22);
        this.crown.addBox(-1.0F, -10.0F, -9.0F, 2, 4, 6, 0.0F);
        this.crown.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.crown.rotateAngleX = 0.4859298F;
        this.crown.rotateAngleY = 0.0F;
        this.crown.rotateAngleZ = 0.0F;
        this.crown.mirror = false;
        this.Head = new ModelRenderer(this, 0, 23);
        this.Head.addBox(-2.0F, -13.0F, -1.0F, 4, 5, 4, 0.0F);
        this.Head.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Head.rotateAngleX = ((float)Math.PI / 2F);
        this.Head.rotateAngleY = 0.0F;
        this.Head.rotateAngleZ = 0.0F;
        this.Head.mirror = false;
        this.upper_mouth = new ModelRenderer(this, 44, 0);
        this.upper_mouth.addBox(-1.0F, -1.0F, -21.0F, 2, 1, 8, 0.0F);
        this.upper_mouth.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.upper_mouth.rotateAngleX = 0.0F;
        this.upper_mouth.rotateAngleY = 0.0F;
        this.upper_mouth.rotateAngleZ = 0.0F;
        this.upper_mouth.mirror = false;
        this.lower_mouth = new ModelRenderer(this, 44, 9);
        this.lower_mouth.addBox(-1.0F, -2.0F, -20.0F, 2, 1, 8, 0.0F);
        this.lower_mouth.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.lower_mouth.rotateAngleX = 0.1356083F;
        this.lower_mouth.rotateAngleY = 0.0F;
        this.lower_mouth.rotateAngleZ = 0.0F;
        this.lower_mouth.mirror = false;
        this.Left_leg = new ModelRenderer(this, 40, 0);
        this.Left_leg.addBox(1.0F, 3.0F, -2.0F, 1, 3, 1, 0.0F);
        this.Left_leg.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Left_leg.rotateAngleX = ((float)Math.PI / 2F);
        this.Left_leg.rotateAngleY = 0.0F;
        this.Left_leg.rotateAngleZ = 0.0F;
        this.Left_leg.mirror = false;
        this.right_leg = new ModelRenderer(this, 40, 4);
        this.right_leg.addBox(-2.0F, 3.0F, -2.0F, 1, 3, 1, 0.0F);
        this.right_leg.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.right_leg.rotateAngleX = ((float)Math.PI / 2F);
        this.right_leg.rotateAngleY = 0.0F;
        this.right_leg.rotateAngleZ = 0.0F;
        this.right_leg.mirror = false;
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, ((EntityDinosaurce)var1).isModelized());
        this.Body.render(var7);
        this.Neck_1.render(var7);
        this.New_Shape1.render(var7);
        this.Left_wing_1.render(var7);
        this.Right_wing_1.render(var7);
        this.Left_wing_2.render(var7);
        this.Right_wing_2.render(var7);
        this.Tail.render(var7);
        this.crown.render(var7);
        this.Head.render(var7);
        this.upper_mouth.render(var7);
        this.lower_mouth.render(var7);
        this.Left_leg.render(var7);
        this.right_leg.render(var7);
    }

    protected void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7)
    {
        if (var7==false)
        {
            this.Left_wing_1.rotateAngleX = -((float)Math.PI / 2F) + this.AirPitch;
            this.Left_wing_2.rotateAngleX = ((float)Math.PI / 2F) + this.AirPitch;
            this.Right_wing_1.rotateAngleX = ((float)Math.PI / 2F) - this.AirPitch;
            this.Right_wing_2.rotateAngleX = -((float)Math.PI / 2F) - this.AirPitch;
            this.Body.rotateAngleX = ((float)Math.PI / 2F) + this.AirPitch;
            this.Neck_1.rotateAngleX = ((float)Math.PI / 2F) + this.AirPitch;
            this.New_Shape1.rotateAngleX = ((float)Math.PI / 2F) + this.AirPitch;
            this.Tail.rotateAngleX = ((float)Math.PI / 2F) + this.AirPitch;
            this.crown.rotateAngleX = 0.4859298F + this.AirPitch;
            this.Head.rotateAngleX = ((float)Math.PI / 2F) + this.AirPitch;
            this.upper_mouth.rotateAngleX = this.AirPitch;
            this.lower_mouth.rotateAngleX = 0.1356083F + this.AirPitch;
            this.Left_leg.rotateAngleX = this.right_leg.rotateAngleX = ((float)Math.PI / 2F) + this.AirPitch;
            this.Body.rotateAngleZ = this.AirRoll;
            this.Neck_1.rotateAngleZ = this.AirRoll;
            this.New_Shape1.rotateAngleZ = this.AirRoll;
            this.Left_wing_1.rotateAngleZ = 2.792527F + this.AirRoll;
            this.Left_wing_2.rotateAngleZ = this.AirRoll;
            this.Right_wing_1.rotateAngleZ = -2.792527F + this.AirRoll;
            this.Right_wing_2.rotateAngleZ = this.AirRoll;
            this.Tail.rotateAngleZ = this.AirRoll;
            this.crown.rotateAngleZ = this.AirRoll;
            this.Head.rotateAngleZ = this.AirRoll;
            this.upper_mouth.rotateAngleZ = this.AirRoll;
            this.lower_mouth.rotateAngleZ = this.AirRoll;
            this.Left_leg.rotateAngleZ = this.right_leg.rotateAngleZ = this.AirRoll;
        }
    }
}
