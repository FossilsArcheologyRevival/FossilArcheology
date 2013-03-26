package fossil.entity.mob;

import java.util.List;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossil.Fossil;
import fossil.fossilAI.EntityAIBegSC;
import fossil.guiBlocks.GuiPedia;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySaberCat extends EntityTameable
{
    private boolean looksWithInterest = false;
    private float field_25048_b;
    private float field_25054_c;
    private boolean isShaking;
    private boolean field_25052_g;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;

    public EntitySaberCat(World var1)
    {
        super(var1);
        this.texture = "/fossil/textures/SaberCat_Adult.png";
        this.setSize(0.8F, 0.8F);
        this.moveSpeed = 0.3F;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, this.moveSpeed, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, this.moveSpeed));
        this.tasks.addTask(7, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(8, new EntityAIBegSC(this, 8.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 16.0F, 200, false));
        this.targetTasks.addTask(5, new EntityAITargetNonTamed(this, EntityPig.class, 16.0F, 200, false));
        this.targetTasks.addTask(6, new EntityAITargetNonTamed(this, EntityCow.class, 16.0F, 200, false));
        this.targetTasks.addTask(7, new EntityAITargetNonTamed(this, EntityChicken.class, 16.0F, 200, false));
        this.targetTasks.addTask(8, new EntityAITargetNonTamed(this, EntityVillager.class, 16.0F, 200, false));
        this.experienceValue=5;
    }

    public int getMaxHealth()
    {
        return !this.isTamed() ? 8 : 20;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }
    private void setPedia()
    {Fossil.ToPedia = (Object)this;}

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(EntityLiving var1)
    {
        super.setAttackTarget(var1);

        if (var1 instanceof EntityPlayer)
        {
            this.setAngry(true);
        }
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    protected void updateAITick()
    {
        this.dataWatcher.updateObject(18, Integer.valueOf(this.getHealth()));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, new Integer(this.getHealth()));
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
        return this.isChild() ? "/fossil/textures/SaberCat_Young.png" : "/fossil/textures/SaberCat_Adult.png";
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Angry", this.isAngry());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.setAngry(var1.getBoolean("Angry"));
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return this.isAngry();
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "SaberCat_Living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "SaberCat_Hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "SaberCat_death";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return -1;
    }

    protected void updateEntityActionState()
    {
        super.updateEntityActionState();

        if (!this.hasAttacked && !this.hasPath() && this.isTamed() && this.ridingEntity == null)
        {
            EntityPlayer var4 = this.worldObj.getPlayerEntityByName(this.getOwnerName());

            if (var4 != null)
            {
                float var5 = var4.getDistanceToEntity(this);

                if (var5 > 5.0F)
                {
                    this.getPathOrWalkableBlock(var4, var5);
                }
            }
            else if (!this.isInWater())
            {
                this.setIsSitting(true);
            }
        }
        else if (this.entityToAttack == null && !this.hasPath() && !this.isTamed() && !this.isChild() && this.worldObj.rand.nextInt(100) == 0)
        {
            List var3 = this.worldObj.getEntitiesWithinAABB(EntityAnimal.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(16.0D, 4.0D, 16.0D));

            if (!var3.isEmpty())
            {
                EntityAnimal var2 = (EntityAnimal)var3.get(this.worldObj.rand.nextInt(var3.size()));

                if (!(var2 instanceof EntitySaberCat))
                {
                    this.setAttackTarget(var2);
                }
            }
        }
        else if (this.isChild() && !this.isTamed())
        {
            Entity var1 = this.getEntityToAttack();

            if (!(var1 instanceof EntityPlayer))
            {
                this.setAttackTarget((EntityLiving)null);
            }
        }

        if (this.isInWater())
        {
            this.setIsSitting(false);
        }

        if (!this.worldObj.isRemote)
        {
            this.dataWatcher.updateObject(18, Integer.valueOf(this.getHealth()));
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!this.worldObj.isRemote && this.isShaking && !this.field_25052_g && !this.hasPath() && this.onGround)
        {
            this.field_25052_g = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.worldObj.setEntityState(this, (byte)8);
        }
    }

    private boolean isInterest(int var1)
    {
        return this.isChild() ? var1 == Item.bucketMilk.itemID : var1 == Item.beefRaw.itemID || var1 == Item.porkRaw.itemID || var1 == Item.chickenRaw.itemID;// || var1 == Fossil.rawDinoMeat.itemID;
    }

    private boolean TamedInterest(int var1)
    {
        return !this.isTamed() ? this.isInterest(var1) : var1 == Item.beefRaw.itemID || var1 == Item.porkRaw.itemID || var1 == Item.chickenRaw.itemID;// || var1 == Fossil.rawDinoMeat.itemID;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        this.field_25054_c = this.field_25048_b;

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
        }

        if (this.isWet())
        {
            this.isShaking = true;
            this.field_25052_g = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else if ((this.isShaking || this.field_25052_g) && this.field_25052_g)
        {
            if (this.timeWolfIsShaking == 0.0F)
            {
                this.worldObj.playSoundAtEntity(this, "mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;

            if (this.prevTimeWolfIsShaking >= 2.0F)
            {
                this.isShaking = false;
                this.field_25052_g = false;
                this.prevTimeWolfIsShaking = 0.0F;
                this.timeWolfIsShaking = 0.0F;
            }

            if (this.timeWolfIsShaking > 0.4F)
            {
                float var1 = (float)this.boundingBox.minY;
                int var2 = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for (int var3 = 0; var3 < var2; ++var3)
                {
                    float var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.worldObj.spawnParticle("splash", this.posX + (double)var4, (double)(var1 + 0.8F), this.posZ + (double)var5, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
    }

    public boolean getWolfShaking()
    {
        return this.isShaking;
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
    }

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

    private void getPathOrWalkableBlock(Entity var1, float var2)
    {
        PathEntity var3 = this.worldObj.getPathEntityToEntity(this, var1, 16.0F, true, false, true, false);

        if (var3 == null && var2 > 12.0F)
        {
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
        return this.isSitting() || this.field_25052_g;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, int var2)
    {
        Entity var3 = var1.getEntity();
        this.aiSit.setSitting(false);

        if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow))
        {
            var2 = (var2 + 1) / 2;
        }

        return super.attackEntityFrom(var1, var2);
    }

    public boolean attackEntityAsMob(Entity var1)
    {
        int var2 = this.isTamed() ? 4 : 2;
        return var1.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        return this.isAngry() ? this.worldObj.getClosestPlayerToEntity(this, 16.0D) : null;
    }

    /**
     * This method gets called when the entity kills another one.
     */
    public void onKillEntity(EntityLiving var1)
    {
        if (var1 instanceof EntityAnimal)
        {
            int var2 = this.getGrowingAge();

            if (var2 < 0)
            {
                var2 += 3000;

                if (var2 > 0)
                {
                    var2 = 0;
                }

                this.setGrowingAge(var2);
            }
        }

        super.onKillEntity(var1);
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity var1, float var2)
    {
        if (var2 > 2.0F && var2 < 6.0F && this.rand.nextInt(10) == 0)
        {
            if (this.onGround)
            {
                double var8 = var1.posX - this.posX;
                double var5 = var1.posZ - this.posZ;
                float var7 = MathHelper.sqrt_double(var8 * var8 + var5 * var5);
                this.motionX = var8 / (double)var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                this.motionY = 0.4000000059604645D;
            }
        }
        else if ((double)var2 < 1.5D && var1.boundingBox.maxY > this.boundingBox.minY && var1.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            byte var3 = 4;

            if (!this.isChild())
            {
                var3 = 8;
            }

            var1.attackEntityFrom(DamageSource.causeMobDamage(this), var3);
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();
        if (var2!=null && FMLCommonHandler.instance().getSide().isClient() && var2.getItem().itemID == Fossil.dinoPedia.itemID)
        {
        	this.setPedia();
            var1.openGui(Fossil.instance, 4, this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
            return true;
        }
        if (!this.isTamed())
        {
            if (var2 != null && this.isInterest(var2.itemID) && !this.isAngry())
            {
                --var2.stackSize;

                if (var2.stackSize <= 0)
                {
                    if (var2.getItem().hasContainerItem())
                    {
                        var1.inventory.setInventorySlotContents(var1.inventory.currentItem, new ItemStack(var2.getItem().getContainerItem()));
                    }
                    else
                    {
                        var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
                    }
                }

                if (!this.worldObj.isRemote)
                {
                    if (this.rand.nextInt(this.isChild() ? 1 : 3) == 0)
                    {
                        this.setIsTamed(true);
                        this.setPathToEntity((PathEntity)null);
                        this.aiSit.setSitting(true);
                        this.setEntityHealth(20);
                        this.setOwner(var1.username);
                        this.showHeartsOrSmokeFX(true);
                        this.worldObj.setEntityState(this, (byte)7);
                    }
                    else
                    {
                        this.showHeartsOrSmokeFX(false);
                        this.worldObj.setEntityState(this, (byte)6);
                    }
                }

                return true;
            }
        }
        else
        {
            if (var2 != null && Item.itemsList[var2.itemID] instanceof ItemFood)
            {
                ItemFood var3 = (ItemFood)Item.itemsList[var2.itemID];

                if (this.TamedInterest(var2.itemID) && this.dataWatcher.getWatchableObjectInt(18) < 20)
                {
                    --var2.stackSize;
                    this.heal(var3.getHealAmount());

                    if (var2.stackSize <= 0)
                    {
                        var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }

                if (var3 == Item.rottenFlesh && this.getGrowingAge() < 0)
                {
                    int var4 = this.getGrowingAge();
                    var4 -= 3000;
                    this.setGrowingAge(var4);
                    return true;
                }
            }

            if (var1.username.equalsIgnoreCase(this.getOwnerName()))
            {
                if (!this.worldObj.isRemote)
                {
                    this.aiSit.setSitting(!this.isSitting());
                    this.isJumping = false;
                    this.setPathToEntity((PathEntity)null);
                }

                return true;
            }
        }

        return super.interact(var1);
    }

    void showHeartsOrSmokeFX(boolean var1)
    {
        String var2 = "heart";

        if (!var1)
        {
            var2 = "smoke";
        }

        for (int var3 = 0; var3 < 7; ++var3)
        {
            double var4 = this.rand.nextGaussian() * 0.02D;
            double var6 = this.rand.nextGaussian() * 0.02D;
            double var8 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(var2, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var4, var6, var8);
        }
    }

    public void handleHealthUpdate(byte var1)
    {
        if (var1 == 8)
        {
            this.field_25052_g = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else
        {
            super.handleHealthUpdate(var1);
        }
    }

    public float setTailRotation()
    {
        return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (float)(20 - this.dataWatcher.getWatchableObjectInt(18)) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F));
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 8;
    }

    public boolean isWheat(ItemStack var1)
    {
        return var1 == null ? false : (!(Item.itemsList[var1.itemID] instanceof ItemFood) ? false : ((ItemFood)Item.itemsList[var1.itemID]).isWolfsFavoriteMeat());
    }

    public void setIsSitting(boolean var1)
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
    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    	p0.reset();
    	p0.PrintStringXY(Fossil.GetLangTextByKey("Animal.SaberCat"), 97, 23,40,90,245);
    	if(this.isTamed())
    	{
    		p0.AddStringLR(Fossil.GetLangTextByKey("PediaText.Owner"), true);
    		String s0=this.getOwnerName();
    		if(s0.length()>11)
    			s0=this.getOwnerName().substring(0, 11);
    		p0.AddStringLR(s0, true);
    	}
    	p0.PrintItemXY(Fossil.embryoSaberCat, 120, 7);
    }

    public boolean isAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setAngry(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 2)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -3)));
        }
    }

    public boolean isTamed()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 4) != 0;
    }

    public void setIsTamed(boolean var1)
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
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
    {
        EntitySaberCat var2 = new EntitySaberCat(this.worldObj);
        var2.setOwner(this.getOwnerName());
        var2.setTamed(true);
        return var2;
    }

    public void func_48150_h(boolean var1)
    {
        this.looksWithInterest = var1;
    }

    public boolean func_48135_b(EntityAnimal var1)
    {
        if (var1 == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(var1 instanceof EntityWolf))
        {
            return false;
        }
        else
        {
            EntityWolf var2 = (EntityWolf)var1;
            return !var2.isTamed() ? false : (var2.isSitting() ? false : this.isInLove() && var2.isInLove());
        }
    }

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
