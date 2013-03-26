package fossil.entity.mob;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Random;

import fossil.client.FossilOptions;
import fossil.Fossil;
import fossil.fossilAI.DinoAIControlledByPlayer;
import fossil.fossilAI.DinoAIEatLeavesWithHeight;
import fossil.fossilAI.DinoAIFollowOwner;
import fossil.fossilAI.DinoAIGrowup;
import fossil.fossilAI.DinoAIPickItems;
import fossil.fossilAI.DinoAIStarvation;
import fossil.fossilAI.DinoAIUseFeederWithHeight;
import fossil.fossilAI.DinoAIWander;
import fossil.fossilEnums.EnumDinoFoodItem;
import fossil.fossilEnums.EnumDinoType;
import fossil.fossilEnums.EnumOrderType;
import fossil.fossilEnums.EnumSituation;
import fossil.guiBlocks.GuiPedia;
import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBrachiosaurus extends EntityDinosaurce
{
    public boolean isTamed = false;
    //public final float HuntLimit = (float)(this.getHungerLimit() * 4 / 5);
    
    //public String OwnerName;
    final float PUSHDOWN_HARDNESS = 5.0F;
    //protected final int AGE_LIMIT = 36;

    public EntityBrachiosaurus(World var1)
    {
        super(var1);
        this.texture = "/fossil/textures/Brachiosaurus.png";
        this.SelfType = EnumDinoType.Brachiosaurus;
        this.setSize(1.5F, 1.5F);
        this.health = 8;
        this.experienceValue=5;
        
        
        this.Width0=1.5F;
        this.WidthInc=0.2F;
        this.Length0=2.0F;
        this.LengthInc=0.52F;
        this.Height0=1.2F;
        this.HeightInc=0.16F;
        //this.BaseattackStrength=;
        //this.AttackStrengthIncrease=;
        //this.BreedingTime=;
        //this.BaseSpeed=;
        //this.SpeedIncrease=;
        this.MaxAge=36;
        //this.BaseHealth=;
        this.HealthIncrease=5;
        this.AdultAge=12;
        //this.AgingTicks=;
        this.MaxHunger=500;
        //this.Hungrylevel=;
        this.moveSpeed = this.getSpeed();//should work
        
        FoodItemList.addItem(EnumDinoFoodItem.Sugar);
        FoodItemList.addItem(EnumDinoFoodItem.Cookie);
        FoodItemList.addItem(EnumDinoFoodItem.Apple);
        
        //this.setHunger(this.getHungerLimit());
        this.getNavigator().setAvoidsWater(true);
        //this.tasks.addTask(0, new DinoAIGrowup(this, 36));
        //this.tasks.addTask(0, new DinoAIStarvation(this));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.ridingHandler = new DinoAIControlledByPlayer(this, 0.34F));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, this.moveSpeed, 5.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIEatLeavesWithHeight(this, this.moveSpeed, 24));//, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIUseFeederWithHeight(this, this.moveSpeed, 24));//, this.HuntLimit));
        this.tasks.addTask(7, new DinoAIWander(this, this.moveSpeed));
        this.tasks.addTask(7, new DinoAIPickItems(this,this.moveSpeed, 24));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
    }

    /*public int getHungerLimit()
    {
        return 500;
    }*/

    /**
     * Returns true if the Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return !this.isModelized();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.worldObj.getClosestPlayerToEntity(this, 16.0D) != null ? "Brach_living" : null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cowhurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "Brach_death";
    }

    /*public String getOwnerName()
    {
        return this.OwnerName;
    }

    public void setOwner(String var1)
    {
        this.OwnerName = var1.toString();
    }

    public boolean isTamed()
    {
        return this.isTamed;
    }

    public void setTamed(boolean var1)
    {
        this.isTamed = var1;
    }*/

    /*public void SetOrder(EnumOrderType var1)
    {
        this.OrderStatus = var1;
    }*/

    /*public boolean HandleEating(int var1)
    {
        return this.HandleEating(var1, false);
    }

    public boolean HandleEating(int var1, boolean var2)
    {
        if (this.getHunger() >= this.getHungerLimit())
        {
            if (this.isTamed() && !var2)
            {
                this.SendStatusMessage(EnumSituation.Full, this.SelfType);
            }

            return false;
        }
        else
        {
            this.increaseHunger(var1);
            this.showHeartsOrSmokeFX(false);

            if (this.getHunger() >= this.getHungerLimit())
            {
                this.setHunger(this.getHungerLimit());
            }

            return true;
        }
    }

    public boolean CheckEatable(int var1)
    {
        Item var2 = Item.itemsList[var1];
        boolean var3 = false;
        var3 = var2 == Item.wheat || var2 == Item.melon;
        return var3;
    }*/
    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    	super.ShowPedia(p0);
    	p0.PrintItemXY(Fossil.dnaBrachiosaurus, 120, 7);
    }
    /*public void ShowPedia(EntityPlayer var1)
    {
        this.PediaTextCorrection(this.SelfType, var1);

        if (this.isTamed())
        {
            Fossil.ShowMessage(OwnerText + this.getOwnerName(), var1);
            Fossil.ShowMessage(AgeText + this.getDinoAge(), var1);
            Fossil.ShowMessage(HelthText + this.health + "/" + this.getMaxHealth(), var1);
            Fossil.ShowMessage(HungerText + this.getHunger() + "/" + this.MaxHunger, var1);
        }
        else
        {
            Fossil.ShowMessage(UntamedText, var1);
        }
    }*/

    /*public String[] additionalPediaMessage()
    {
        String[] var1 = null;

        if (!this.isTamed())
        {
            var1 = new String[] {UntamedText};
        }
        else
        {
            ArrayList var2 = new ArrayList();

            if (this.isTamed() && this.getDinoAge() > 4 && this.riddenByEntity == null)
            {
                var2.add(RidiableText);
            }

            if (!var2.isEmpty())
            {
                var1 = new String[1];
                var1 = (String[])var2.toArray(var1);
            }
        }

        return var1;
    }*/

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
    	//Add special item interaction code here
        return super.interact(var1);
    }

    public EntityBrachiosaurus spawnBabyAnimal(EntityAnimal var1)
    {
        return null;
    }

    /*public int getMaxHealth()
    {
        return 20 + 10 * this.getDinoAge();
    }*/

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    /*public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        //var1.setByte("OrderStatus", (byte)Fossil.EnumToInt(this.OrderStatus));//already done
    }*/

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    /*public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        //this.InitSize();
        //this.OrderStatus = EnumOrderType.values()[var1.getByte("OrderStatus")];//already done
    }*/

    /*private void InitSize()
    {
        this.updateSize();
        this.setPosition(this.posX, this.posY, this.posZ);
        this.moveSpeed = this.getSpeed();//0.3F + (float)this.getDinoAge() * 0.05F;//done centrally
    }*/

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.isAdult())//this.getDinoAge() >= 4)
        {
            this.BlockInteractive();
        }
    }

    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     */
    public void applyEntityCollision(Entity var1)
    {
        if (!this.isModelized())
        {
            if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.onGround && ((EntityLiving)var1).getEyeHeight() < this.getHalfHeight())
            {
                this.onKillEntity((EntityLiving)var1);
                ((EntityLiving)var1).attackEntityFrom(DamageSource.causeMobDamage(this), 10);
            }
            else
            {
                super.applyEntityCollision(var1);
            }
        }
    }

    /*public void setSelfSitting(boolean var1)
    {//handled in dinosaurce
        if (var1)
        {
            this.OrderStatus = EnumOrderType.Stay;
        }
        else
        {
            this.OrderStatus = EnumOrderType.FreeMove;
        }
    }

    public boolean isSelfSitting()
    {
        return this.OrderStatus == EnumOrderType.Stay;
    }*/

    public float getEyeHeight()
    {
        return 4.0F + (float)this.getDinoAge() / 1.8F;
    }

    public float getHalfHeight()
    {
        return this.getEyeHeight() / 2.0F;
    }

    /*/** Should'nt bee needed as the speed itself is applied to tha age already
     * This method returns a value to be applied directly to entity speed, this factor is less than 1 when a slowdown
     * potion effect is applied, more than 1 when a haste potion effect is applied and 2 for fleeing entities.
     *
    public float getSpeedModifier()
    {
        float var1 = 1.0F + (float)Math.floor((double)((float)this.getDinoAge() / 5.0F));
        return var1;
    }*/

    public void BlockInteractive()
    {
        if (FossilOptions.TRexBreakingBlocks)
        {
            if (!this.isModelized())
            {
                boolean var1 = false;
                boolean var2 = false;
                boolean var3 = false;
                boolean var4 = false;

                for (int var5 = (int)Math.round(this.boundingBox.minX) - 1; var5 <= (int)Math.round(this.boundingBox.maxX) + 1; ++var5)
                {
                    for (int var9 = 0; var9 <= (int)this.getHalfHeight(); ++var9)
                    {
                        for (int var6 = (int)Math.round(this.boundingBox.minZ) - 1; var6 <= (int)Math.round(this.boundingBox.maxZ) + 1; ++var6)
                        {
                            int var10 = (int)Math.round(this.boundingBox.minY) + var9;
                            int var8 = this.worldObj.getBlockId(var5, var10, var6);

                            if (Block.blocksList[var8] != null)
                            {
                                float var10000 = Block.blocksList[var8].getBlockHardness(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
                                this.getClass();

                                if (var10000 < 5.0F)
                                {
                                    int var7 = this.GetObjectTall(var5, var10, var6);

                                    if (var7 > 0 && !this.isObjectTooTall(var7 + var9))
                                    {
                                        this.DestroyTower(var5, var10, var6, var7);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isObjectTooTall(int var1, int var2, int var3)
    {
        return (float)this.GetObjectTall(var1, var2, var3) > this.getHalfHeight();
    }

    private boolean isObjectTooTall(int var1)
    {
        float var2 = this.getHalfHeight();
        return (float)var1 > var2;
    }

    private int GetObjectTall(int var1, int var2, int var3)
    {
        int var4;

        for (var4 = 0; !this.worldObj.isAirBlock(var1, var2 + var4, var3); ++var4)
        {
            ;
        }

        return var4;
    }

    private void DestroyTower(int var1, int var2, int var3, int var4)
    {
        boolean var5 = false;

        for (int var6 = var2; var6 <= var2 + var4; ++var6)
        {
            int var7 = this.worldObj.getBlockId(var1, var6, var3);
            this.worldObj.playAuxSFX(2001, var1, var6, var3, var7);
            this.worldObj.setBlockWithNotify(var1, var6, var3, 0);
        }
    }

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getHalfHeight() * 1.2D, this.posZ);
        }
    }

    /**
     * Time remaining during which the Animal is sped up and flees.
     */
    protected void updateWanderPath()
    {
        boolean var1 = false;
        int var2 = -1;
        int var3 = -1;
        int var4 = -1;
        float var5 = -99999.0F;

        if (this.OrderStatus == EnumOrderType.FreeMove || !this.isTamed())
        {
            for (int var6 = 0; var6 < 10 + this.getDinoAge(); ++var6)
            {
                int var7 = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(24 + (int)(this.width * this.width * 4.0F)) - (12.0D + (double)(this.width * this.width * 2.0F)));
                int var8 = MathHelper.floor_double(this.posY + (double)this.rand.nextInt(7) - 3.0D);
                int var9 = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(24 + (int)(this.width * this.width * 4.0F)) - (12.0D + (double)(this.width * this.width * 2.0F)));
                float var10 = this.getBlockPathWeight(var7, var8, var9);

                if (var10 > var5)
                {
                    var5 = var10;
                    var2 = var7;
                    var3 = var8;
                    var4 = var9;
                    var1 = true;
                }
            }

            if (var1)
            {
                this.setPathToEntity(this.worldObj.getEntityPathToXYZ(this, var2, var3, var4, 10.0F, true, false, true, false));
            }
        }
    }

    private void HandleRiding()
    {
        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerSP && this.onGround)
        {
            if (((EntityPlayerSP)this.riddenByEntity).movementInput.jump)
            {
                this.jump();
                ((EntityPlayerSP)this.riddenByEntity).movementInput.jump = false;
            }

            for (this.rotationYaw -= ((EntityPlayerSP)this.riddenByEntity).movementInput.moveStrafe * 5.0F; this.rotationYaw < -180.0F; this.rotationYaw += 360.0F)
            {
                ;
            }

            while (this.rotationYaw >= 180.0F)
            {
                this.rotationYaw -= 360.0F;
            }
            this.moveForward = ((EntityPlayerSP)this.riddenByEntity).movementInput.moveForward * this.moveSpeed;
        }
    }

    /*public void updateSize()
    {
        this.setSize((float)(1.5D + 0.15D * (double)((float)this.getDinoAge())), (float)(1.5D + 0.15D * (double)((float)this.getDinoAge())));
    }

    public float getGLX()
    {
        return (float)(1.5D + 0.3D * (double)((float)this.getDinoAge()));
    }

    public float getGLY()
    {
        return (float)(1.5D + 0.3D * (double)((float)this.getDinoAge()));
    }*/

    /*public EntityAgeable func_90011_a(EntityAgeable var1)
    {
        return null;
    }*/
}
