package fossil.entity.mob;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import fossil.Fossil;
import fossil.fossilAI.DinoAIEatFerns;
import fossil.fossilAI.DinoAIFollowOwner;
import fossil.fossilAI.DinoAIGrowup;
import fossil.fossilAI.DinoAIPickItem;
import fossil.fossilAI.DinoAIPickItems;
import fossil.fossilAI.DinoAIStarvation;
import fossil.fossilAI.DinoAIUseFeeder;
import fossil.fossilAI.DinoAIWander;
import fossil.fossilEnums.EnumDinoEating;
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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityStegosaurus extends EntityDinosaurce
{
    private boolean looksWithInterest;
    /*public final float HuntLimit = (float)this.getHungerLimit() * 0.9F;
    private float field_25048_b;
    private float field_25054_c;
    private boolean isWolfShaking;
    private boolean field_25052_g;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    public int SubSpecies = 1;
    public boolean isBaby = true;*/
    public int RushTick = 0;
    //public int BreedTick = 3000;
    public boolean Running = false;

    public EntityStegosaurus(World var1)
    {
        super(var1);
        this.SelfType = EnumDinoType.Stegosaurus;
        this.looksWithInterest = false;
        //this.SubSpecies = (new Random()).nextInt(3) + 1;
        //this.texture = "/fossil/textures/Stegosaurus_Baby.png";
        //this.CheckSkin();
        this.setSize(1.0F, 1.0F);
        //this.moveSpeed = 0.3F;
        this.health = 8;
        this.experienceValue=3;
        
        
        this.Width0=1.2F;
        this.WidthInc=0.5F;
        this.Length0=1.0F;
        this.LengthInc=0.7F;
        this.Height0=1.2F;
        this.HeightInc=0.36F;
        //this.BaseattackStrength=;
        //this.AttackStrengthIncrease=;
        //this.BreedingTime=;
        //this.BaseSpeed=;
        //this.SpeedIncrease=;
        this.MaxAge=13;
        this.BaseHealth=21;
        this.HealthIncrease=1;
        //this.AdultAge=;
        //this.AgingTicks=;
        this.MaxHunger=500;
        this.Hungrylevel=0.9F;
        this.moveSpeed = this.getSpeed();//should work
        
        this.setSubSpecies((new Random()).nextInt(3) + 1);
        FoodItemList.addItem(EnumDinoFoodItem.Wheat);
        FoodItemList.addItem(EnumDinoFoodItem.Melon);
        FoodItemList.addItem(EnumDinoFoodItem.Carrot);
        FoodItemList.addItem(EnumDinoFoodItem.Sugar);
        FoodItemList.addItem(EnumDinoFoodItem.Cookie);
        FoodItemList.addItem(EnumDinoFoodItem.Bread);
        
        this.getNavigator().setAvoidsWater(true);
        //this.tasks.addTask(0, new DinoAIStarvation(this));
        //this.tasks.addTask(0, new DinoAIGrowup(this, 12));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new DinoAIFollowOwner(this, this.moveSpeed, 5.0F, 2.0F));
        this.tasks.addTask(5, new DinoAIEatFerns(this/*, this.HuntLimit)*/));
        this.tasks.addTask(6, new DinoAIUseFeeder(this, this.moveSpeed, 24/*, this.HuntLimit*/, EnumDinoEating.Herbivorous));
        //this.tasks.addTask(6, new DinoAIPickItem(this, Item.wheat, this.moveSpeed, 24, this.HuntLimit));
        //this.tasks.addTask(6, new DinoAIPickItem(this, Item.appleRed, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(7, new DinoAIPickItems(this,this.moveSpeed, 24));
        this.tasks.addTask(7, new DinoAIWander(this, this.moveSpeed));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return this.riddenByEntity == null;
    }
    
    public String getTexture()
    {
        if (this.isModelized())
            return super.getTexture();
        if(this.isAdult())
            return "/fossil/textures/Stegosaurus_Adult.png";
		return "/fossil/textures/Stegosaurus_Baby.png";
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    /*public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        //var1.setInteger("SubSpecies", this.SubSpecies);
        //var1.setBoolean("Angry", this.isSelfAngry());
        //var1.setBoolean("isBaby", this.isBaby);
    }*/

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    /*public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        //this.SubSpecies = var1.getInteger("SubSpecies");
        //this.isBaby = var1.getBoolean("isBaby");
        this.CheckSkin();
        //this.setSelfAngry(var1.getBoolean("Angry"));
        //this.setSelfSitting(var1.getBoolean("Sitting"));
        //this.InitSize();
    }*/

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.worldObj.getClosestPlayerToEntity(this, 8.0D) != null ? "Steg_living" : null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "Steg_Hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "Steg_death";
    }

    protected void updateEntityActionState()
    {
        if (this.riddenByEntity == null)
        {
            super.updateEntityActionState();
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        /*this.field_25054_c = this.field_25048_b;

        if (this.looksWithInterest)
        {
            this.field_25048_b += (1.0F - this.field_25048_b) * 0.4F;
        }
        else
        {
            this.field_25048_b += (0.0F - this.field_25048_b) * 0.4F;
        }*/

        if (this.looksWithInterest)
        {
            this.numTicksToChaseTarget = 10;
        }
    }

    /*public boolean getSelfShaking()
    {
        return false;
    }

    public float getShadingWhileShaking(float var1)
    {
        return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * var1) / 2.0F * 0.25F;
    }

    public float getShakeAngle(float var1, float var2)
    {
        float var3 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * var1 + var2) / 1.8F;

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }
        else if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        return MathHelper.sin(var3 * (float)Math.PI) * MathHelper.sin(var3 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
    }

    public float getInterestedAngle(float var1)
    {
        return (this.field_25054_c + (this.field_25048_b - this.field_25054_c) * var1) * 0.15F * (float)Math.PI;
    }*/

    public float getEyeHeight()
    {
        return this.height * 0.8F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return this.isSitting();// || this.field_25052_g;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, int var2)
    {
        Entity var3 = var1.getEntity();
        this.setSitting(false);

        if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow))
        {
            var2 = (var2 + 1) / 2;
        }

        if (!super.attackEntityFrom(var1, var2))
        {
            return false;
        }
        else
        {
            if (!this.isTamed() && !this.isSelfAngry())
            {
                if (var3 instanceof EntityPlayer)
                {
                    this.setSelfAngry(true);
                    this.entityToAttack = var3;
                }

                if (var3 instanceof EntityArrow && ((EntityArrow)var3).shootingEntity != null)
                {
                    var3 = ((EntityArrow)var3).shootingEntity;
                }

                if (var3 instanceof EntityLiving)
                {
                    ;
                }
            }
            else if (var3 != this && var3 != null)
            {
                if (this.isTamed() && var3 instanceof EntityPlayer && ((EntityPlayer)var3).username.equalsIgnoreCase(this.getOwnerName()))
                {
                    return true;
                }

                this.entityToAttack = var3;
            }

            return true;
        }
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return this.isSelfAngry() ? this.worldObj.getClosestPlayerToEntity(this, 16.0D) : null;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
    	//Add special item interaction code here
        return super.interact(var1);
    }
    public void handleHealthUpdate(byte var1)
    {
        if (var1 == 7)
        {
            this.showHeartsOrSmokeFX(true);
        }
        else if (var1 == 6)
        {
            this.showHeartsOrSmokeFX(false);
        }
        else if (var1 == 8)
        {
            //this.field_25052_g = true;
            //this.timeWolfIsShaking = 0.0F;
            //this.prevTimeWolfIsShaking = 0.0F;
        }
        else
        {
            super.handleHealthUpdate(var1);
        }
    }

    public boolean isSelfAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    /*public boolean isSelfSitting()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }*/

    public void setSelfAngry(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 2)));
            this.moveSpeed = 2.0F;
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -3)));
            this.moveSpeed = 0.5F;
        }
    }

    /*public void setSelfSitting(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -2)));
        }
    }

    public void setTamed(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 4)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -5)));
        }
    }*/

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /*private void InitSize()
    {
        this.CheckSkin();
        this.updateSize();
        this.setPosition(this.posX, this.posY, this.posZ);
        this.moveSpeed = this.getSpeed();//0.5F + (float)(this.getDinoAge() * 3);
    }
    public void updateSize()
    {
    	this.setSize((float)(1.5D + 0.3D * (double)((float)this.getDinoAge())), (float)(1.5D + 0.3D * (double)((float)this.getDinoAge())));
    }*/

    public boolean CheckSpace()
    {
        return !this.isEntityInsideOpaqueBlock();
    }
    /*public void CheckSkin()
    {
        if (this.isAdult())
        {
            this.texture = "/fossil/textures/Stegosaurus_Adult.png";
        }
        else
        {
            this.texture = "/fossil/textures/Stegosaurus_Baby.png";
        }
    }*/

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getDinoHeight() * 0.65D + 0.07D * (double)(12 - this.getDinoAge()), this.posZ);
        }
    }

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
    }*/

    /*private boolean FindWheats(int var1)
    {
        if (this.isSelfSitting())
        {
            return false;
        }
        else
        {
            List var2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(1.0D, 0.0D, 1.0D));

            if (var2 != null)
            {
                for (int var3 = 0; var3 < var2.size(); ++var3)
                {
                    if (var2.get(var3) instanceof EntityItem)
                    {
                        EntityItem var4 = (EntityItem)var2.get(var3);

                        if (var4.func_92014_d().itemID == Item.wheat.itemID)
                        {
                            this.HandleEating(10);
                            this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, (((new Random()).nextFloat() - (new Random()).nextFloat()) * 0.7F + 1.0F) * 2.0F);
                            var4.setDead();
                            return true;
                        }
                    }
                }
            }

            EntityItem var8 = null;
            List var9 = this.worldObj.getEntitiesWithinAABB(EntityItem.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand((double)var1, 4.0D, (double)var1));
            Iterator var5 = var9.iterator();

            while (var5.hasNext())
            {
                Entity var6 = (Entity)var5.next();

                if (var6 instanceof EntityItem)
                {
                    EntityItem var7 = (EntityItem)var6;

                    if (var7.func_92014_d().getItem().itemID == Item.wheat.itemID)
                    {
                        if (var8 != null)
                        {
                            if (this.GetDistanceWithEntity(var7) < this.GetDistanceWithEntity(var8))
                            {
                                var8 = var7;
                            }
                        }
                        else
                        {
                            var8 = var7;
                        }
                    }
                }
            }

            if (var8 != null)
            {
                this.setPathToEntity(this.worldObj.getPathEntityToEntity(this, var8, (float)var1, true, false, true, false));
                return true;
            }
            else
            {
                return false;
            }
        }
    }*/

    public void FaceToCoord(int var1, int var2, int var3)
    {
        double var4 = (double)var1;
        double var6 = (double)var3;
        float var8 = (float)(Math.atan2(var6, var4) * 180.0D / Math.PI) - 90.0F;
        this.rotationYaw = this.updateRotation(this.rotationYaw, var8, 360.0F);
    }

    private float updateRotation(float var1, float var2, float var3)
    {
        float var4;

        for (var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F)
        {
            ;
        }

        while (var4 >= 180.0F)
        {
            var4 -= 360.0F;
        }

        if (var4 > var3)
        {
            var4 = var3;
        }

        if (var4 < -var3)
        {
            var4 = -var3;
        }

        return var1 + var4;
    }

    /*private void HandleRiding()
    {
        if (this.RushTick > 0)
        {
            --this.RushTick;
        }

        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerSP && this.onGround)
        {
            if (((EntityPlayerSP)this.riddenByEntity).movementInput.jump)
            {
                this.jump();
                ((EntityPlayerSP)this.riddenByEntity).movementInput.jump = false;
            }

            this.Running = ((EntityPlayerSP)this.riddenByEntity).movementInput.sneak && this.RushTick == 0;

            if (((EntityPlayerSP)this.riddenByEntity).movementInput.sneak)
            {
                if (this.getDinoAge() > 4 && this.motionX != 0.0D && this.motionZ != 0.0D)
                {
                    this.BlockInteractive();
                }

                if (this.RushTick == 0)
                {
                    for (this.rotationYaw -= ((EntityPlayerSP)this.riddenByEntity).movementInput.moveStrafe * 5.0F; this.rotationYaw < -180.0F; this.rotationYaw += 360.0F)
                    {
                        ;
                    }

                    while (this.rotationYaw >= 180.0F)
                    {
                        this.rotationYaw -= 360.0F;
                    }

                    this.moveForward = ((EntityPlayerSP)this.riddenByEntity).movementInput.moveForward * this.moveSpeed * 8.0F;
                }
                else
                {
                    for (this.rotationYaw -= ((EntityPlayerSP)this.riddenByEntity).movementInput.moveStrafe * 5.0F; this.rotationYaw < -180.0F; this.rotationYaw += 360.0F)
                    {
                        ;
                    }

                    while (this.rotationYaw >= 180.0F)
                    {
                        this.rotationYaw -= 360.0F;
                    }

                    this.moveForward = ((EntityPlayerSP)this.riddenByEntity).movementInput.moveForward * this.moveSpeed * 0.0F;
                }
            }
            else
            {
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
    }*/

    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     */
    public void applyEntityCollision(Entity var1)
    {
        if (var1 instanceof EntityLiving && !(var1 instanceof EntityPlayer) && this.riddenByEntity != null && this.onGround)
        {
            this.onKillEntity((EntityLiving)var1);
            ((EntityLiving)var1).attackEntityFrom(DamageSource.causeMobDamage(this), 10);
        }
        else
        {
            super.applyEntityCollision(var1);
        }
    }

    public void BlockInteractive()
    {
        for (int var1 = (int)Math.round(this.boundingBox.minX) - 1; var1 <= (int)Math.round(this.boundingBox.maxX) + 1; ++var1)
        {
            for (int var2 = (int)Math.round(this.boundingBox.minY); var2 <= (int)Math.round(this.boundingBox.maxY); ++var2)
            {
                for (int var3 = (int)Math.round(this.boundingBox.minZ) - 1; var3 <= (int)Math.round(this.boundingBox.maxZ) + 1; ++var3)
                {
                    if (!this.worldObj.isAirBlock(var1, var2, var3))
                    {
                        int var4 = this.worldObj.getBlockId(var1, var2, var3);

                        if (!this.inWater)
                        {
                            if (this.isTamed() && this.riddenByEntity == null)
                            {
                                if (var4 == Block.wood.blockID || var4 == Block.leaves.blockID)
                                {
                                    this.worldObj.setBlockWithNotify(var1, var2, var3, 0);
                                    this.RushTick = 10;
                                }
                            }
                            else if ((double)Block.blocksList[var4].getBlockHardness(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ) < 5.0D || var4 == Block.wood.blockID)
                            {
                                if ((new Random()).nextInt(10) == 5)
                                {
                                    Block.blocksList[var4].dropBlockAsItem(this.worldObj, var1, var2, var3, 1, 0);
                                }

                                this.worldObj.setBlockWithNotify(var1, var2, var3, 0);
                                this.RushTick = 10;
                            }
                        }
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    	super.ShowPedia(p0);
    	p0.PrintItemXY(Fossil.dnaStegosaurus, 120, 7);
    }
    
    /*public void ShowPedia(EntityPlayer var1)
    {
        this.PediaTextCorrection(this.SelfType, var1);

        if (this.isTamed())
        {
            Fossil.ShowMessage(OwnerText + this.getOwnerName(), var1);
            Fossil.ShowMessage(AgeText + this.getDinoAge(), var1);
            Fossil.ShowMessage(HelthText + this.health + "/" + 20, var1);
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

        return var1;
    }*/


    /*public boolean CheckEatable(int var1)
    {
        Item var2 = Item.itemsList[var1];
        boolean var3 = false;
        var3 = var2 == Item.wheat || var2 == Item.melon;
        return var3;
    }*/

    public EntityStegosaurus spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityStegosaurus(this.worldObj);
    }

    /*public float getGLX()
    {
        return (float)(1.5D + 0.3D * (double)this.getDinoAge());
    }

    public float getGLY()
    {
        return (float)(1.5D + 0.3D * (double)this.getDinoAge());
    }*/

    public EntityAgeable func_90011_a(EntityAgeable var1)
    {
        return this.spawnBabyAnimal(var1);
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1) 
	{
		return null;
	}
}
