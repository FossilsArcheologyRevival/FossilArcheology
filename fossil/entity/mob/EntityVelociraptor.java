package fossil.entity.mob;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import fossil.Fossil;
import fossil.fossilAI.DinoAIFollowOwner;
import fossil.fossilAI.DinoAIGrowup;
import fossil.fossilAI.DinoAIPickItem;
import fossil.fossilAI.DinoAIPickItems;
import fossil.fossilAI.DinoAIStarvation;
import fossil.fossilAI.DinoAITargetNonTamedExceptSelfClass;
import fossil.fossilAI.DinoAIUseFeeder;
import fossil.fossilAI.DinoAIWander;
import fossil.fossilEnums.EnumDinoEating;
import fossil.fossilEnums.EnumDinoFoodItem;
import fossil.fossilEnums.EnumDinoType;
import fossil.fossilEnums.EnumOrderType;
import fossil.fossilEnums.EnumSituation;
import fossil.guiBlocks.GuiPedia;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.src.ModLoader;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityVelociraptor extends EntityDinosaurce
{
    private boolean looksWithInterest;
    /*public final float HuntLimit = (float)(this.getHungerLimit() * 4 / 5);
    private float field_25048_b;
    private float field_25054_c;
    private boolean isWolfShaking;
    private boolean field_25052_g;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    public ItemStack ItemInMouth = null;
    public int BreedTick = 3000;*/
    public int LearningChestTick = 900;
    public boolean PreyChecked = false;
    public boolean SupportChecked = false;
    public Vector MemberList = new Vector();
    public float SwingAngle = -1000.0F;
    public int FleeingTick = 0;
    //public int DoorOpeningTick = 0; SEEMS TO BE PLANNED

    public EntityVelociraptor(World var1)
    {
        super(var1);
        this.SelfType = EnumDinoType.Velociraptor;
        this.looksWithInterest = false;
        //this.CheckSkin();
        this.setSize(0.3F, 0.3F);
        //this.moveSpeed = 0.3F;
        this.health = 10;
        this.experienceValue=7;
        
        this.Width0=0.3F;
        this.WidthInc=0.12F;
        this.Length0=0.3F;
        this.LengthInc=0.13F;
        this.Height0=0.3F;
        this.HeightInc=0.1F;
        //this.BaseattackStrength=;
        //this.AttackStrengthIncrease=;
        //this.BreedingTime=;
        this.BaseSpeed=0.5F;
        this.SpeedIncrease=1.3F;
        this.MaxAge=9;
        this.BaseHealth=21;
        this.HealthIncrease=1;
        //this.AdultAge=;
        //this.AgingTicks=;
        //this.MaxHunger=;
        //this.Hungrylevel=;
        this.moveSpeed = this.getSpeed();//should work
        
        FoodItemList.addItem(EnumDinoFoodItem.PorkRaw);
        FoodItemList.addItem(EnumDinoFoodItem.PorkCooked);
        FoodItemList.addItem(EnumDinoFoodItem.BeefRaw);
        FoodItemList.addItem(EnumDinoFoodItem.BeefCooked);
        //FoodItemList.addItem(EnumDinoFoodItem.DinoMeatRaw);
        FoodItemList.addItem(EnumDinoFoodItem.DinoMeatCooked);
        FoodItemList.addItem(EnumDinoFoodItem.Triceratops);
        FoodItemList.addItem(EnumDinoFoodItem.Stegosaur);
        FoodItemList.addItem(EnumDinoFoodItem.Plesiosaur);
        FoodItemList.addItem(EnumDinoFoodItem.Pterosaur);
        FoodItemList.addItem(EnumDinoFoodItem.Brachiosaur);
        
        //this.setHunger(this.getHungerLimit());
        //this.attackStrength = 2 + this.getDinoAge();
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        //this.tasks.addTask(0, new DinoAIGrowup(this, 8));
        //this.tasks.addTask(0, new DinoAIStarvation(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityTRex.class, 8.0F, 0.3F, 0.35F));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityBrachiosaurus.class, 8.0F, 0.3F, 0.35F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new DinoAIFollowOwner(this, this.moveSpeed, 5.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIUseFeeder(this, this.moveSpeed, 24/*, this.HuntLimit*/, EnumDinoEating.Carnivorous));
        /*this.tasks.addTask(6, new DinoAIPickItem(this, Item.porkRaw, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIPickItem(this, Item.beefRaw, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIPickItem(this, Item.chickenRaw, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIPickItem(this, Item.porkCooked, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIPickItem(this, Item.beefCooked, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIPickItem(this, Item.chickenCooked, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIPickItem(this, Fossil.rawDinoMeat, this.moveSpeed, 24, this.HuntLimit));
        this.tasks.addTask(6, new DinoAIPickItem(this, Fossil.cookedDinoMeat, this.moveSpeed, 24, this.HuntLimit));*/
        this.tasks.addTask(6, new DinoAIPickItems(this,this.moveSpeed, 24));
        this.tasks.addTask(7, new DinoAIWander(this, this.moveSpeed));
        //this.tasks.addTask(7, new DinoAILearnChest(this));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new DinoAITargetNonTamedExceptSelfClass(this, EntityLiving.class, 16.0F, 50, false));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
    

    /*protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(24, new Byte((byte)0));
    }*/

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        if (this.isModelized())
            return super.getTexture();
        if (this.isAdult())
        {
            switch (this.getSubSpecies())
            {
                case 1:
                    return "/fossil/textures/raptor_blue_adult.png";

                case 2:
                    return "/fossil/textures/raptor_green_adult.png";
                    
                case 3:
                    return "/fossil/textures/raptor_brown_adult.png";

                default:
                	return "/fossil/textures/raptor_brown_adult.png";
            }
        }
        switch (this.getSubSpecies())
        {
            case 1:
                return "/fossil/textures/raptor_blue_Baby.png";

            case 2:
                return "/fossil/textures/raptor_green_Baby.png";
            
            case 3:
                return "/fossil/textures/raptor_brown_Baby.png";

            default:
            	return "/fossil/textures/raptor_brown_Baby.png";
        }
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump()
    {
        this.motionY = 0.41999998688697815D * (double)(1 + this.getDinoAge() / 16);

        if (this.isSprinting())
        {
            float var1 = this.rotationYaw * 0.01745329F;
            this.motionX -= (double)(MathHelper.sin(var1) * 0.2F);
            this.motionZ += (double)(MathHelper.cos(var1) * 0.2F);
        }

        this.isAirBorne = true;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setInteger("LearningChestTick", this.LearningChestTick);

        /*if (this.ItemInMouth != null)
        {
            var1.setShort("Itemid", (short)this.ItemInMouth.itemID);
            var1.setByte("ItemCount", (byte)this.ItemInMouth.stackSize);
            var1.setShort("ItemDamage", (short)this.ItemInMouth.getItemDamage());
        }
        else
        {
            var1.setShort("Itemid", (short) - 1);
            var1.setByte("ItemCount", (byte)0);
            var1.setShort("ItemDamage", (short)0);
        }*/

        //var1.setBoolean("Angry", this.isSelfAngry());
        //var1.setBoolean("Sitting", this.isSelfSitting());
        //var1.setInteger("SubType", this.getSubSpecies());
        //this.isSelfAngry()
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.LearningChestTick=var1.getInteger("LearningChestTick");
        /*short var2 = var1.getShort("Itemid");
        byte var3 = var1.getByte("ItemCount");
        short var4 = var1.getShort("ItemDamage");

        if (var2 != -1)
        {
            this.ItemInMouth = new ItemStack(var2, var3, var4);
        }
        else
        {
            this.ItemInMouth = null;
        }*/

        //this.setSelfAngry(var1.getBoolean("Angry"));
        //this.setSelfSitting(var1.getBoolean("Sitting"));

        /*if (var1.hasKey("SubType"))
        {
            this.setSubSpecies(var1.getInteger("SubType"));
        }*/

       // this.InitSize();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.isTamed() ? "raptor_living_friendly" : "raptor_living_wild";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "Raptor_hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "raptor_death";
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        if(this.LearningChestTick>0 && this.isNearbyChest() && this.isAdult())
        {
        	this.LearningChestTick--;
        	if(this.LearningChestTick==0)
        		this.SendStatusMessage(EnumSituation.LearningChest);//, this.SelfType);
        }
        /*this.field_25054_c = this.field_25048_b;

        if (this.looksWithInterest)
        {
            this.field_25048_b += (1.0F - this.field_25048_b) * 0.4F;
        }
        else
        {
            this.field_25048_b += (0.0F - this.field_25048_b) * 0.4F;
        }

        if (this.looksWithInterest)
        {
            this.numTicksToChaseTarget = 10;
        }*/
    }
    public boolean isLearnedChest()
    {
        return this.LearningChestTick == 0;
    }
    private boolean isNearbyChest()
    {
        TileEntity var5 = null;
        for (int var6 = -10; var6 <= 10; ++var6)
        {
            for (int var7 = 0; var7 <= 3; ++var7)
            {
                for (int var8 = -10; var8 <= 10; ++var8)
                {
                    var5 = this.worldObj.getBlockTileEntity((int)(this.posX + (double)var6), (int)(this.posY + (double)var7), (int)(this.posZ + (double)var8));
                    if (var5 instanceof TileEntityChest)
                        return true;
                }
            }
        }
        return false;
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
        boolean var4 = false;

        if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow))
        {
            var2 = (var2 + 1) / 2;
        }

        if (super.attackEntityFrom(var1, var2))
        {
            if (!this.isAngry())
            {
                if (var3 instanceof EntityPlayer)
                {
                    this.setTamed(false);
                    this.setOwner("");
                    this.ItemInMouth = null;
                    this.PreyChecked = true;
                    var4 = true;
                }

                if (var3 instanceof EntityArrow && ((EntityArrow)var3).shootingEntity != null)
                {
                    var3 = ((EntityArrow)var3).shootingEntity;
                }

                if (var3 instanceof EntityLiving)
                {
                    this.setAttackTarget((EntityLiving)var3);
                }
            }
            else if (var3 != this && var3 != null)
            {
                this.entityToAttack = var3;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return null;
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity var1, float var2)
    {
        if (var1.isDead)
        {
            this.setAttackTarget((EntityLiving)null);
        }

        if (var2 > 2.0F && var2 < 5.0F && this.rand.nextInt(10) == 0)
        {
            if (this.onGround)
            {
                double var3 = var1.posX - this.posX;
                double var5 = var1.posZ - this.posZ;
                float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
                this.motionX = var3 / (double)var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                this.worldObj.playSoundAtEntity(this, "Raptor_attack", this.getSoundVolume() * 2.0F, 1.0F);
                this.jump();
            }
        }
        else if ((double)var2 < 1.899999976158142D && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            var1.attackEntityFrom(DamageSource.causeMobDamage(this), 2 + this.getDinoAge());
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();
        if (var2 != null)
        {
            if (var2.getItem().getItemUseAction(var2) == EnumAction.bow)
            {
                return false;
            }
        }
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

    /*public boolean isSelfSitting()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }*/



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
            this.ItemInMouth = null;
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -5)));
        }
    }*/

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float var1)
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.fallDistance = var1;
        }

        int var2 = (int)Math.ceil((double)(var1 - 3.0F));

        if (var2 > 0)
        {
            this.attackEntityFrom(DamageSource.fall, 0);
            int var3 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.20000000298023224D - (double)this.yOffset), MathHelper.floor_double(this.posZ));

            if (this.worldObj.isRemote)
            {
                return;
            }

            if (var3 > 0)
            {
                StepSound var4 = Block.blocksList[var3].stepSound;
                this.worldObj.playSoundAtEntity(this, var4.getBreakSound(), var4.getVolume() * 0.5F, var4.getPitch() * 0.75F);
            }
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
        EnumOrderType var10001 = this.OrderStatus;

        if (this.OrderStatus == EnumOrderType.FreeMove || !this.isTamed())
        {
            for (int var6 = 0; var6 < 10; ++var6)
            {
                int var7 = MathHelper.floor_double(this.posX + (double)this.rand.nextInt(13) - 6.0D);
                int var8 = MathHelper.floor_double(this.posY + (double)this.rand.nextInt(7) - 3.0D);
                int var9 = MathHelper.floor_double(this.posZ + (double)this.rand.nextInt(13) - 6.0D);
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

   /* private void InitSize()
    {
        this.CheckSkin();
        this.updateSize();
        this.setPosition(this.posX, this.posY, this.posZ);
    }

    public void updateSize()
    {
    	this.setSize((float)(0.30000001192092896D + 0.1D * (double)((float)this.getAge())), (float)(0.30000001192092896D + 0.1D * (double)((float)this.getAge())));
    }*/
    
    /*public boolean HandleEating(int var1)
    {
        if (this.getHunger() >= this.getHungerLimit())
        {
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

    public boolean isLeartChest()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 16) == 0;
    }*/

    /*public void ChangeSubType(int var1)
    {
        if (var1 <= 2 && var1 >= 0)
        {
            this.setSubSpecies(var1);
            this.CheckSkin();
        }
    }*/

    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    	super.ShowPedia(p0);
    	p0.PrintItemXY(Fossil.dnaVelociraptor, 120, 7);
    	if(this.LearningChestTick==0)
    		p0.AddStringLR(Fossil.GetLangTextByKey("PediaText.Chest"), true);
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

            /*if (this.isLeartChest())
            {
                Fossil.ShowMessage(EnableChestText, var1);
            }*
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

            /*if (this.isLeartChest())
            {
                var2.add(EnableChestText);
            }*

            if (!var2.isEmpty())
            {
                var1 = new String[1];
                var1 = (String[])var2.toArray(var1);
            }
        }

        return var1;
    }*/

    /*public void SetOrder(EnumOrderType var1)
    {
        this.OrderStatus = var1;
    }

    public boolean HandleEating(int var1, boolean var2)
    {
        return this.HandleEating(var1);
    }

    public boolean CheckEatable(int var1)
    {
        if (!(Item.itemsList[var1] instanceof ItemFood))
        {
            return false;
        }
        else
        {
            Item var2 = Item.itemsList[var1];
            boolean var3 = false;
            var3 = var2 == Item.beefCooked || var2 == Item.beefRaw || var2 == Item.fishCooked || var2 == Item.fishRaw || var2 == Item.chickenCooked || var2 == Item.chickenRaw || var2 == Item.porkRaw || var2 == Item.porkCooked;
            return var3;
        }
    }*/

    public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
    {
        return new EntityVelociraptor(this.worldObj);
    }

    public boolean IsIdle()
    {
        return this.motionX < 0.03125D && this.motionY < 0.03125D && this.motionZ < 0.03125D;
    }

    /*public void setLearntChest(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(24);

        if (var1)
        {
            this.dataWatcher.updateObject(24, Byte.valueOf((byte)(var2 & -17)));
        }
        else
        {
            this.dataWatcher.updateObject(24, Byte.valueOf((byte)(var2 | 16)));
        }
    }*/

    /*public float getGLX()
    {
        return (float)(0.20000000298023224D + 0.1D * (double)this.getDinoAge());
    }

    public float getGLY()
    {
        return (float)(0.3199999928474426D + 0.1D * (double)this.getDinoAge());
    }*/

    public EntityAgeable func_90011_a(EntityAgeable var1)
    {
        return null;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable var1) 
	{
		return null;
	}
}
