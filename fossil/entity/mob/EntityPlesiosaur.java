package fossil.entity.mob;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fossil.Fossil;
import fossil.fossilAI.DinoAIFishing;
import fossil.fossilAI.DinoAIFollowOwner;
import fossil.fossilAI.DinoAIGrowup;
import fossil.fossilAI.DinoAIPickItem;
import fossil.fossilAI.DinoAIPickItems;
import fossil.fossilAI.DinoAIStarvation;
import fossil.fossilAI.DinoAIUseFeeder;
import fossil.fossilAI.DinoAIWander;
import fossil.fossilAI.WaterDinoAISwimming;
import fossil.fossilEnums.EnumDinoEating;
import fossil.fossilEnums.EnumDinoFoodItem;
import fossil.fossilEnums.EnumDinoType;
import fossil.fossilEnums.EnumOrderType;
import fossil.fossilInterface.IWaterDino;
import fossil.guiBlocks.GuiPedia;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPlesiosaur extends EntityDinosaurce implements IWaterDino
{
    private boolean looksWithInterest;
    //public final float HuntLimit = (float)(this.getHungerLimit() * 4 / 5);
    /*private float field_25048_b;
    private float field_25054_c;//For the interesting looking angle!
    private boolean isWolfShaking;
    private boolean field_25052_g;
    public int SubSpecies = 1;
    public boolean isBaby = true;*/
    public int RushTick = 0;
    
    
    
    
    
    public float TargetY = 0.0F;
    private float randomMotionSpeed;
    private float randomMotionVecX = 0.0F;
    private float randomMotionVecY = 0.0F;
    private float randomMotionVecZ = 0.0F;
    //protected final int AGE_LIMIT = 18;

    public EntityPlesiosaur(World var1)
    {
        super(var1);
        this.SelfType = EnumDinoType.Plesiosaur;
        this.looksWithInterest = false;
        //this.SubSpecies = (new Random()).nextInt(3) + 1;
        this.setSubSpecies((new Random()).nextInt(3) + 1);
        this.texture = "/fossil/textures/Plesiosaur_adult.png";
        this.setSize(1.0F, 1.0F);
        //this.moveSpeed = 0.7F;
        this.health = 8;
        this.experienceValue=2;
        
        this.Width0=0.5F;
        this.WidthInc=0.3F;
        this.Length0=0.5F;
        this.LengthInc=0.5F;
        this.Height0=0.5F;
        this.HeightInc=0.3F;
        this.BaseattackStrength=3;
        //this.AttackStrengthIncrease=;
        //this.BreedingTime=;
        this.BaseSpeed=0.5F;
        this.SpeedIncrease=2.0F;
        this.MaxAge=12;
        this.BaseHealth=30;
        this.HealthIncrease=10;
        //this.AdultAge=;
        //this.AgingTicks=;
        this.MaxHunger=500;
        //this.Hungrylevel=;
        this.moveSpeed = this.getSpeed();//should work
        
        FoodItemList.addItem(EnumDinoFoodItem.FishRaw);
        FoodItemList.addItem(EnumDinoFoodItem.FishCooked);
        FoodItemList.addItem(EnumDinoFoodItem.Sjl);
        FoodItemList.addItem(EnumDinoFoodItem.ChickenRaw);
        
        this.getNavigator().setCanSwim(true);
        //this.tasks.addTask(0, new DinoAIGrowup(this, 12));
        //this.tasks.addTask(0, new DinoAIStarvation(this));
        this.tasks.addTask(1, new WaterDinoAISwimming(this, true, 0.09374999F, 0.018749999F));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new DinoAIFollowOwner(this, this.moveSpeed, 5.0F, 2.0F));
        this.tasks.addTask(6, new DinoAIUseFeeder(this, this.moveSpeed, 24,/* this.HuntLimit,*/ EnumDinoEating.Carnivorous));
        /*this.tasks.addTask(7, new DinoAIPickItem(this, Item.fishRaw, this.moveSpeed * 2.0F, 24, this.HuntLimit));
        this.tasks.addTask(7, new DinoAIPickItem(this, Item.fishCooked, this.moveSpeed * 2.0F, 24, this.HuntLimit));
        this.tasks.addTask(7, new DinoAIPickItem(this, Fossil.sjl, this.moveSpeed * 2.0F, 24, this.HuntLimit));*/
        this.tasks.addTask(7, new DinoAIPickItems(this,this.moveSpeed, 24));
        this.tasks.addTask(8, new DinoAIFishing(this, /*this.HuntLimit,*/ 1));
        this.tasks.addTask(9, new DinoAIWander(this, this.moveSpeed));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(11, new EntityAILookIdle(this));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return !this.isModelized();
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    public boolean canBreatheUnderwater()
    {
        return true;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    /*public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Angry", this.isSelfAngry());
    }*/

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    /*public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.setSelfAngry(var1.getBoolean("Angry"));
        //this.InitSize();
    }*/

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.worldObj.getClosestPlayerToEntity(this, 8.0D) != null ? "Pls_Living" : null;
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "Pls_hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "tri_death";
    }

    protected void updateEntityActionState()
    {
        if (!this.isModelized())
        {
            if (this.riddenByEntity == null)
            {
                super.updateEntityActionState();

                if (!this.isOnSurface() && (double)this.TargetY < this.posY)
                {
                    this.TargetY = (float)(this.posY++);
                }

                if (!this.isSitting() && !this.hasPath() && (new Random()).nextInt(1000) == 5)
                {
                    this.FindFish(6);
                }

                if (!this.worldObj.isRemote)
                {
                    this.dataWatcher.updateObject(18, Integer.valueOf(this.getHealth()));
                }
            }
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.isInWater() && this.motionY <= 0.0D)
        {
            if (this.getNavigator().noPath())
            {
                this.motionY = -0.0037499999161809683D;
            }
            else
            {
                this.motionY = -0.01874999888241291D;
            }
        }

        super.onLivingUpdate();
    }

    public boolean isOnSurface()
    {
        return this.worldObj.isAirBlock((int)Math.floor(this.posX), (int)Math.floor(this.posY + (double)(this.getEyeHeight() / 2.0F)), (int)Math.floor(this.posZ));
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.isInWater())
        {
            if (!this.hasPath() && this.riddenByEntity == null)
            {
                this.motionX *= 0.8D;
                this.motionZ *= 0.8D;
            }

            /*if (this.riddenByEntity != null)
            {
                EntityPlayerSP var1 = (EntityPlayerSP)this.riddenByEntity;

                if (var1.movementInput.moveForward + var1.movementInput.moveStrafe == 0.0F)
                {
                    this.motionX *= 0.8D;
                    this.motionZ *= 0.8D;
                }
            }*/

            if ((!this.isOnSurface() && (double)this.TargetY > this.posY || (double)this.TargetY < this.posY) && !this.isCollidedVertically)
            {
                if ((double)this.TargetY > this.posY)
                {
                    this.motionY += 0.02D;
                }
                else
                {
                    this.motionY -= 0.1D;
                }

                if (this.motionY > 0.4D)
                {
                    this.motionY = 0.4D;
                }

                if (this.motionY < -2.0D)
                {
                    this.motionY = -2.0D;
                }
            }

            if (Math.abs(this.posY - (double)this.TargetY) <= 0.125D)
            {
                this.motionY = 0.0D;
            }
        }
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float var1, float var2)
    {
        double var3;

        if (this.isInWater())
        {
            if (this.isOnSurface() && this.motionY > 0.0D)
            {
                this.motionY = 0.0D;
            }

            var3 = this.posY;
            this.moveFlying(var1, var2, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);

            if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + var3, this.motionZ))
            {
                this.motionY = 0.30000001192092896D;
            }
        }
        else if (this.handleLavaMovement())
        {
            var3 = this.posY;
            this.moveFlying(var1, var2, 0.02F);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5D;
            this.motionY *= 0.5D;
            this.motionZ *= 0.5D;
            this.motionY -= 0.02D;

            if (this.isCollidedHorizontally && this.isOffsetPositionInLiquid(this.motionX, this.motionY + 0.6000000238418579D - this.posY + var3, this.motionZ))
            {
                this.motionY = 0.30000001192092896D;
            }
        }
        else
        {
            float var8 = 0.91F;

            if (this.onGround)
            {
                var8 = 0.5460001F;
                int var4 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));

                if (var4 > 0)
                {
                    var8 = Block.blocksList[var4].slipperiness * 0.91F;
                }
            }

            float var9 = 0.1627714F / (var8 * var8 * var8);
            float var5 = this.onGround ? this.landMovementFactor * var9 : this.jumpMovementFactor;
            this.moveFlying(var1, var2, var5);
            var8 = 0.91F;

            if (this.onGround)
            {
                var8 = 0.5460001F;
                int var6 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.boundingBox.minY) - 1, MathHelper.floor_double(this.posZ));

                if (var6 > 0)
                {
                    var8 = Block.blocksList[var6].slipperiness * 0.91F;
                }
            }

            if (this.isOnLadder())
            {
                float var11 = 0.15F;

                if (this.motionX < (double)(-var11))
                {
                    this.motionX = (double)(-var11);
                }

                if (this.motionX > (double)var11)
                {
                    this.motionX = (double)var11;
                }

                if (this.motionZ < (double)(-var11))
                {
                    this.motionZ = (double)(-var11);
                }

                if (this.motionZ > (double)var11)
                {
                    this.motionZ = (double)var11;
                }

                this.fallDistance = 0.0F;

                if (this.motionY < -0.15D)
                {
                    this.motionY = -0.15D;
                }

                if (this.isSneaking() && this.motionY < 0.0D)
                {
                    this.motionY = 0.0D;
                }
            }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);

            if (this.isCollidedHorizontally && this.isOnLadder())
            {
                this.motionY = 0.2D;
            }

            if (!this.isInWater())
            {
                this.motionY -= 0.08D;
            }

            this.motionY *= 0.9800000190734863D;
            this.motionX *= (double)var8;
            this.motionZ *= (double)var8;
        }

        this.prevLegYaw = this.legYaw;
        var3 = this.posX - this.prevPosX;
        double var10 = this.posZ - this.prevPosZ;
        float var7 = MathHelper.sqrt_double(var3 * var3 + var10 * var10) * 4.0F;

        if (var7 > 1.0F)
        {
            var7 = 1.0F;
        }

        this.legYaw += (var7 - this.legYaw) * 0.4F;
        this.legSwing += this.legYaw;
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float getBlockPathWeight(int var1, int var2, int var3)
    {
        return 0.5F - this.worldObj.getLightBrightness(var1, var2, var3);
    }

    /*public float getInterestedAngle(float var1)
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

    protected void getPathOrWalkableBlock(Entity var1, float var2)
    {
        PathEntity var3 = this.worldObj.getPathEntityToEntity(this, var1, 16.0F, true, false, true, false);
        this.setPathToEntity(var3);
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
        if (this.modelizedDrop())
        {
            return true;
        }
        else
        {
            Entity var3 = var1.getEntity();

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
    }*/

    /*public void setTamed(boolean var1)
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
        this.updateSize();
        this.setPosition(this.posX, this.posY, this.posZ);
        this.moveSpeed = this.getSpeed();//0.5F + (float)(this.getDinoAge() * 3);
    }*/

    public boolean CheckSpace()
    {
        if (!this.isInWater())
        {
            return !this.isEntityInsideOpaqueBlock();
        }
        else
        {
            for (int var1 = 0; var1 < 8; ++var1)
            {
                float var2 = ((float)((var1 >> 0) % 2) - 0.5F) * this.width * 0.9F;
                float var3 = ((float)((var1 >> 1) % 2) - 0.5F) * 0.1F;
                float var4 = ((float)((var1 >> 2) % 2) - 0.5F) * this.width * 0.9F;
                int var5 = MathHelper.floor_double(this.posX + (double)var2);
                int var6 = MathHelper.floor_double(this.posY + (double)this.getEyeHeight() + (double)var3);
                int var7 = MathHelper.floor_double(this.posZ + (double)var4);
                Block var8 = Block.blocksList[this.worldObj.getBlockId(var1, var5, var6)];

                if (var8 != null && var8 != Block.waterStill && var8 != Block.waterMoving)
                {
                    return false;
                }
            }

            return true;
        }
    }

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getDinoHeight() * 0.75D + 0.07D * (double)(18 - this.getDinoAge()), this.posZ);
        }
    }

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
    }*/

    private boolean FindFish(int var1)
    {
        if (this.isSitting())
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

                        if (var4.getEntityItem().itemID == Item.fishRaw.itemID || var4.getEntityItem().itemID == Item.fishCooked.itemID)
                        {
                            this.increaseHunger(10);
                            this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, (((new Random()).nextFloat() - (new Random()).nextFloat()) * 0.7F + 1.0F) * 2.0F);
                            var4.setDead();
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

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

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump()
    {
        if (this.isInWater() && this.isCollidedHorizontally && this.riddenByEntity == null)
        {
            super.jump();
        }
    }

    /**
     * Checks if this entity is inside water (if inWater field is true as a result of handleWaterMovement() returning
     * true)
     */
    public boolean isInWater()
    {
        return this.worldObj.handleMaterialAcceleration(this.boundingBox.expand(0.0D, -0.6000000238418579D, 0.0D), Material.water, this);
    }

    private void HandleRiding()
    {
        if (this.RushTick > 0)
        {
            --this.RushTick;
        }

        if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayerSP)
        {
            if (this.onGround || this.isInWater())
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

            if (((EntityPlayerSP)this.riddenByEntity).movementInput.sneak)
            {
                this.TargetY = (float)this.posY - 0.5F;
            }
            else if (this.isOnSurface())
            {
                this.TargetY = (float)this.posY;
            }
            else if (((EntityPlayerSP)this.riddenByEntity).movementInput.moveForward == 0.0F)
            {
                this.TargetY = (float)this.posY + 0.2F;
            }
            else
            {
                this.TargetY = (float)this.posY;
            }
        }
    }

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
            if (!this.isInWater())
            {
                super.applyEntityCollision(var1);
            }
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
    	p0.PrintItemXY(Fossil.dnaPlesiosaur, 120, 7);
    }
    
    /*public void ShowPedia(EntityPlayer var1)
    {
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
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLiving var1)
    {
        super.onKillEntity(var1);

        if (var1 instanceof EntityNautilus)
        {
            this.increaseHunger(100);
        }

        this.heal(5);
    }

    public void SetOrder(EnumOrderType var1)
    {
        this.setPathToEntity((PathEntity)null);
        this.setTarget((Entity)null);
        this.OrderStatus = var1;
    }

    public EntityPlesiosaur spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityPlesiosaur(this.worldObj);
    }

    /*public void updateSize()
    {
        this.setSize((float)(1.0D + 0.3D * (double)((float)this.getDinoAge())), (float)(1.0D + 0.3D * (double)((float)this.getDinoAge())));
    }

    public float getGLX()
    {
        return (float)(1.0D + 0.3D * (double)((float)this.getDinoAge()));
    }

    public float getGLY()
    {
        return (float)(1.0D + 0.3D * (double)((float)this.getDinoAge()));
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
