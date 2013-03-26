package fossil.entity.mob;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import fossil.Fossil;
import fossil.fossilAI.DinoAIGrowup;
import fossil.fossilAI.DinoAIStarvation;
import fossil.fossilAI.WaterDinoAINearestAttackableTarget;
import fossil.fossilAI.WaterDinoAISwimming;
import fossil.fossilAI.WaterDinoAIWander;
import fossil.fossilEnums.EnumDinoType;
import fossil.fossilEnums.EnumOrderType;
import fossil.fossilInterface.IWaterDino;
import fossil.guiBlocks.GuiPedia;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMosasaurus extends EntityDinosaurce implements IWaterDino
{
    public final int Areas = 60;
    //public final float HuntLimit = (float)(this.getHungerLimit() * 4 / 5);
    private boolean looksWithInterest;
    
    /*private float field_25048_b;
    private float field_25054_c;/7What are theese for?
    private boolean field_25052_g;*/
    
    public float TargetY = 0.0F;

    public EntityMosasaurus(World var1)
    {
        super(var1);
        this.SelfType = EnumDinoType.Mosasaurus;
        this.looksWithInterest = false;
        this.texture = "/fossil/textures/Mosasaurus.png";
        this.setSize(0.5F, 0.5F);
        //this.moveSpeed = 0.3F;
        this.health = 10;
        //this.attackStrength = 4 + 2 * this.getDinoAge();
        this.experienceValue=20;
        
        this.Width0=0.25F;
        this.WidthInc=0.25F;
        this.Length0=0.5F;
        this.LengthInc=0.45F;
        this.Height0=0.2F;
        this.HeightInc=0.15F;
        this.BaseattackStrength=4;
        this.AttackStrengthIncrease=2;
        //this.BreedingTime=;
        this.BaseSpeed=0.5F;
        this.SpeedIncrease=0.4F;
        this.MaxAge=20;
        this.BaseHealth=50;
        this.HealthIncrease=10;
        this.AdultAge=8;
        //this.AgingTicks=;
        this.MaxHunger=500;
        //this.Hungrylevel=;
        this.moveSpeed = this.getSpeed();//should work
        
        this.getNavigator().setCanSwim(true);
        //this.tasks.addTask(0, new DinoAIGrowup(this, 8));
        //this.tasks.addTask(0, new DinoAIStarvation(this));
        this.tasks.addTask(1, (new WaterDinoAISwimming(this, true, 0.09374999F, 0.018749999F)).setDiveAtNight());
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(4, new WaterDinoAIWander(this, this.moveSpeed, 0.003F));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new WaterDinoAINearestAttackableTarget(this, EntityNautilus.class, 16.0F, 0, true));
        this.targetTasks.addTask(3, new WaterDinoAINearestAttackableTarget(this, EntitySquid.class, 16.0F, 0, true));
        this.targetTasks.addTask(4, new WaterDinoAINearestAttackableTarget(this, EntityAnimal.class, 16.0F, 0, true));
        this.targetTasks.addTask(5, new WaterDinoAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, false));
    }

    /**
     * Returns true if the Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

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
        return super.getTexture();
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
   /* public void writeEntityToNBT(NBTTagCompound var1)
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
        this.InitSize();
    }*/

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "";
    }

    protected void updateEntityActionState()
    {
    	super.updateEntityActionState();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && this.worldObj.isAnyLiquid(this.boundingBox);
    }

    public boolean canBreatheUnderwater()
    {
        return true;
    }

    public boolean isOnSurface()
    {
        AxisAlignedBB var1 = this.boundingBox;
        AxisAlignedBB var2 = AxisAlignedBB.getBoundingBox(var1.minX, var1.minY, var1.minZ, var1.maxX, var1.maxY / 2.0D, var1.maxZ);
        AxisAlignedBB var3 = AxisAlignedBB.getBoundingBox(var1.minX, var1.minY + (var1.maxY - var1.minY) / 4.0D, var1.minZ, var1.maxX, var1.maxY, var1.maxZ);
        return this.worldObj.isAABBInMaterial(var2, Material.water) && this.worldObj.isAABBInMaterial(var2, Material.air);
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
            this.motionX *= 0.800000011920929D;
            this.motionY *= 0.800000011920929D;
            this.motionZ *= 0.800000011920929D;
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
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.motionY <= 0.0D && this.isInWater())
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

    public boolean getSelfShaking()
    {
        return false;
    }

    public float getEyeHeight()
    {
        return this.height * 0.2F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return super.getVerticalFaceSpeed();
    }

    public void getPathOrWalkableBlock(Entity var1, float var2)
    {
        PathEntity var3 = this.worldObj.getPathEntityToEntity(this, var1, 16.0F, true, false, true, false);

        if (var3 == null && var2 > 12.0F)
        {
            this.TargetY = (float)var1.posY;
            int var4 = MathHelper.floor_double(var1.posX) - 2;
            int var5 = MathHelper.floor_double(var1.posZ) - 2;
            int var6 = MathHelper.floor_double(var1.boundingBox.minY);

            for (int var7 = 0; var7 <= 4; ++var7)
            {
                for (int var8 = 0; var8 <= 4; ++var8)
                {
                    if ((var7 < 1 || var8 < 1 || var7 > 3 || var8 > 3) && this.worldObj.isBlockNormalCube(var4 + var7, var6 - 1, var5 + var8) && !this.worldObj.isBlockNormalCube(var4 + var7, var6, var5 + var8) && !this.worldObj.isBlockNormalCube(var4 + var7, var6 + 1, var5 + var8))
                    {
                        this.setLocationAndAngles((double)((float)(var4 + var7) + 0.5F), (double)var6, (double)((float)(var5 + var8) + 0.5F), this.rotationYaw, this.rotationPitch);
                        return;
                    }
                }
            }
        }
        else
        {
            this.setPathToEntity(var3);
        }
    }

    /**
     * Disables a mob's ability to move on its own while true.
     */
    protected boolean isMovementCeased()
    {
        return false;//this.isSitting() || this.field_25052_g;
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
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity var1, float var2)
    {
        if ((double)var2 > (double)this.width * 1.6D && var2 < 60.0F && var1.isInWater())
        {
            double var3 = var1.posX - this.posX;
            double var5 = var1.posZ - this.posZ;
            float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
            this.motionX = var3 / (double)var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
            this.motionZ = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
            this.TargetY = (float)var1.posY;
        }
        else if ((double)var2 <= (double)this.width * 1.6D && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY)
        {
            var1.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength());
        }
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLiving var1)
    {
        super.onKillEntity(var1);

        if (var1 instanceof EntityPig)
        {
            this.increaseHunger(30);
        }

        if (var1 instanceof EntitySheep)
        {
            this.increaseHunger(35);
        }

        if (var1 instanceof EntityCow)
        {
            this.increaseHunger(50);
        }

        if (var1 instanceof EntityChicken)
        {
            this.increaseHunger(20);
        }

        if (var1 instanceof EntityMob)
        {
            this.increaseHunger(20);
        }

        if (var1 instanceof EntityNautilus)
        {
            this.increaseHunger(100);
        }
        if (var1 instanceof EntitySquid)
        {
            this.increaseHunger(30);
        }

        this.heal(5);
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

        if (var1 != this.isSelfAngry())
        {
            if (var1)
            {
                this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 2)));
                this.moveSpeed = 2.0F;
            }
            else
            {
                this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -3)));
            }
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

    /*private void InitSize()
    {
    	this.updateSize();
        this.setPosition(this.posX, this.posY, this.posZ);
        this.moveSpeed = this.getSpeed();
    }
    public void updateSize()
    {
    	this.setSize((float)(0.5D + 0.5125D * (double)((float)this.getDinoAge())), (float)(0.5D + 0.5125D * (double)((float)this.getDinoAge())));
    }*/

    public boolean CheckSpace()
    {
        if (this.isCollidedHorizontally)
        {
            return false;
        }
        else if (!this.isInWater())
        {
            return false;
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

    public void updateRiderPosition()
    {
        if (this.riddenByEntity != null)
        {
            this.riddenByEntity.setPosition(this.posX, this.posY + (double)this.getGLY() * 1.5D, this.posZ);
        }
    }*/

    private void Flee(Entity var1, int var2)
    {
        int var3 = (new Random()).nextInt(var2) + 1;
        int var4 = (int)Math.round(Math.sqrt(Math.pow((double)var2, 2.0D) - Math.pow((double)var3, 2.0D)));
        boolean var5 = false;
        int var6 = 0;
        boolean var7 = false;
        int var9;

        if (var1.posX <= this.posX)
        {
            var9 = (int)Math.round(this.posX) + var3;
        }
        else
        {
            var9 = (int)Math.round(this.posX) - var3;
        }

        int var10;

        if (var1.posZ <= this.posZ)
        {
            var10 = (int)Math.round(this.posZ) + var4;
        }
        else
        {
            var10 = (int)Math.round(this.posZ) - var4;
        }

        for (int var8 = 128; var8 > 0; --var8)
        {
            if (!this.worldObj.isAirBlock(var9, var8, var10))
            {
                var6 = var8;
                break;
            }
        }

        this.setTamed(false);
        //this.setSelfSitting(false);
        this.setPathToEntity(this.worldObj.getEntityPathToXYZ(this, var9, var6, var10, (float)var2, true, false, true, false));
    }

    private boolean HuntForPrey(int var1)
    {
        if (this.getEntityToAttack() != null && this.getEntityToAttack() instanceof EntityPlayer)
        {
            return false;
        }
        else
        {
            EntityLiving var2 = null;
            EntityLiving var3 = null;
            float var4 = (float)var1 * 2.0F;
            List var5 = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand((double)var1, (double)(var1 * 2), (double)var1));
            Iterator var6 = var5.iterator();

            while (var6.hasNext())
            {
                var3 = (EntityLiving)var6.next();

                if (!(var3 instanceof EntityPlayer) && (var3 instanceof EntitySquid || var3 instanceof EntityNautilus) && this.GetDistanceWithEntity(var3) < var4)
                {
                    var4 = this.GetDistanceWithEntity(var3);
                    var2 = var3;
                }
            }

            if (var2 != null)
            {
                this.setTarget(var2);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /**
     * Causes this entity to do an upwards motion (jumping).
     */
    protected void jump()
    {
        this.isJumping = false;
    }

    /*/**
     * Heal living entity (param: amount of half-hearts)
     *
    public void heal(int var1)
    {
        if (this.health > 0)
        {
            this.health += var1;

            if (this.health > 200)
            {
                this.health = 200;
            }
        }
    }*/
    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    	super.ShowPedia(p0);
    	p0.PrintItemXY(Fossil.dnaMosasaurus, 120, 7);
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
            Fossil.ShowMessage(CautionText, var1);
        }
    }

    public String[] additionalPediaMessage()
    {
        String[] var1 = null;

        if (!this.isTamed())
        {
            var1 = new String[] {UntamedText};
        }

        return var1;
    }*/

    public void HandleBoatSinking()
    {
        EntityBoat var1 = null;
        List var2 = this.worldObj.getEntitiesWithinAABB(EntityBoat.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(10.0D, 4.0D, 10.0D));
        Iterator var3 = var2.iterator();

        while (var3.hasNext())
        {
            var1 = (EntityBoat)var3.next();

            if (var1.isInWater())
            {
                break;
            }
        }

        if (var1 != null)
        {
            if (var1.riddenByEntity != null)
            {
                var1.riddenByEntity.mountEntity(var1);
            }

            var1.attackEntityFrom(DamageSource.causeMobDamage(this), 50);
        }
    }

    public EntityMosasaurus spawnBabyAnimal(EntityAgeable var1)
    {
        return new EntityMosasaurus(this.worldObj);
    }
    
    /*public float getGLX()
    {
        return (float)(0.5D + 0.5125D * (double)this.getDinoAge());
    }

    public float getGLY()
    {
        return (float)(0.5D + 0.5125D * (double)this.getDinoAge());
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
