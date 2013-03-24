package fossil.entity.mob;

import java.util.ArrayList;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fossil.Fossil;
import fossil.guiBlocks.GuiPedia;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.IShearable;

public class EntityMammoth extends EntityTameable implements IShearable
{
    private static final int SIZE_MULTIFER = 5;
    private static final int EATING_TIMES_TO_GROW_FUR = 5;
    private static final float CHILD_SIZE_Y = 1.3F;
    private static final float CHILD_SIZE_X = 0.9F;
    private static final float ADULT_SIZE_Y = 6.5F;
    private static final float ADULT_SIZE_X = 4.5F;
    private static final Potion BIOME_SICK = Potion.weakness;
    private static final PotionEffect BIOME_EFFECT = new PotionEffect(Potion.weakness.id, 60, 1);
    private static final BiomeGenBase[] COLD_BIOMES = new BiomeGenBase[] {BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.taiga, BiomeGenBase.taigaHills};
    private static final BiomeGenBase[] HOT_BIOMES = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.swampland, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.hell, BiomeGenBase.desertHills};
    private EntityAIEatGrass aiEatGrass = new EntityAIEatGrass(this);
    private int eatGrassTimes = 0;
    private int swingTick;

    public EntityMammoth(World var1)
    {
        super(var1);
        this.texture = "/fossil/textures/MammothAdult.png";
        this.setSize(0.9F, 1.3F);
        float var2 = 0.23F;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, 0.25F, true));
        this.tasks.addTask(3, new EntityAIPanic(this, 0.38F));
        this.tasks.addTask(4, new EntityAIMate(this, var2));
        this.tasks.addTask(5, new EntityAITempt(this, 0.25F, Item.wheat.itemID, false));
        this.tasks.addTask(6, new EntityAIFollowParent(this, 0.25F));
        this.tasks.addTask(7, this.aiEatGrass);
        this.tasks.addTask(8, new EntityAIWander(this, var2));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.experienceValue=5;
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
    public boolean attackEntityAsMob(Entity var1)
    {
        this.swingTick = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean var2 = var1.attackEntityFrom(DamageSource.causeMobDamage(this), this.isChild() ? 2 : 7);

        if (var2)
        {
            var1.motionY += 0.4000000059604645D;
        }

        this.worldObj.playSoundAtEntity(this, "mob.irongolem.throw", 1.0F, 1.0F);
        return var2;
    }

    public int getMaxHealth()
    {
        return 24;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 360;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.updateSize();

        if (this.swingTick > 0)
        {
            --this.swingTick;
        }

        if (!this.isPotionActive(BIOME_SICK) && this.checkBiomeAndWeakness())
        {
            this.addPotionEffect(BIOME_EFFECT);
        }
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        return this.isChild() ? "/fossil/textures/MammothYoung.png" : (!this.getSheared() ? "/fossil/textures/MammothAdult.png" : "/fossil/textures/MammothFurless.png");
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Sheared", this.getSheared());
        var1.setByte("Color", (byte)this.getFleeceColor());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.setSheared(var1.getBoolean("Sheared"));
        this.setFleeceColor(var1.getByte("Color"));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "Mammoth_living";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "Mammoth_hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "Mammoth_death";
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
        return Item.leather.itemID;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean var1, int var2)
    {
        int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + var2);
        int var4;

        for (var4 = 0; var4 < var3; ++var4)
        {
            this.dropItem(Item.leather.itemID, 1);
        }

        var3 = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + var2);

        for (var4 = 0; var4 < var3; ++var4)
        {
            if (this.isBurning())
            {
                this.dropItem(Item.beefCooked.itemID, 1);
            }
            else
            {
                this.dropItem(Item.beefRaw.itemID, 1);
            }
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, new Byte((byte)3));
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (var2 != null)
        {
        	if(var2.getItem().equals(Fossil.chickenEss))
        	{
        		this.setGrowingAge(this.getGrowingAge() + 2000);
        		var2.stackSize--;
        		return true;
        	}
        	if (FMLCommonHandler.instance().getSide().isClient() && var2.getItem().itemID == Fossil.dinoPedia.itemID)
            {
            	this.setPedia();
                var1.openGui(Fossil.instance, 4, this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
                return true;
            }
        }

        return super.interact(var1);
    }
    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    	p0.reset();
    	p0.PrintStringXY(Fossil.GetLangTextByKey("Animal.Mammoth"), 97, 23,40,90,245);
    	if(this.isTamed())
    	{
    		p0.AddStringLR(Fossil.GetLangTextByKey("PediaText.Owner"), true);
    		String s0=this.getOwnerName();
    		if(s0.length()>11)
    			s0=this.getOwnerName().substring(0, 11);
    		p0.AddStringLR(s0, true);
    	}
    	p0.PrintItemXY(Fossil.embryoMammoth, 120, 7);
    }
    public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
    {
        EntityMammoth var2 = new EntityMammoth(this.worldObj);

        if (this.isTamed())
        {
            var2.setOwner(this.getOwnerName());
            var2.setTamed(true);
        }

        return var2;
    }

    public boolean isShearable(ItemStack var1, World var2, int var3, int var4, int var5)
    {
        this.eatGrassTimes = 0;
        return !this.getSheared() && !this.isChild();
    }

    public void setSheared(boolean var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(18);

        if (var1)
        {
            this.dataWatcher.updateObject(18, Byte.valueOf((byte)(var2 | 16)));
        }
        else
        {
            this.dataWatcher.updateObject(18, Byte.valueOf((byte)(var2 & -17)));
        }
    }

    public ArrayList onSheared(ItemStack var1, World var2, int var3, int var4, int var5, int var6)
    {
        ArrayList var7 = new ArrayList();
        int var8 = 1 + this.rand.nextInt(20);

        for (int var9 = 0; var9 < var8; ++var9)
        {
            var7.add(new ItemStack(Block.cloth.blockID, 1, 12));
        }

        this.setSheared(true);
        return var7;
    }

    public int getFleeceColor()
    {
        return this.dataWatcher.getWatchableObjectByte(18) & 15;
    }

    public void setFleeceColor(int var1)
    {
        byte var2 = this.dataWatcher.getWatchableObjectByte(18);
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)(var2 & 240 | var1 & 15)));
    }

    public boolean getSheared()
    {
        return (this.dataWatcher.getWatchableObjectByte(18) & 16) != 0;
    }

    public void updateSize()
    {
        if (!this.isChild())
        {
            if (this.width != 4.5F || this.height != 6.5F)
            {
                this.setSize(4.5F, 6.5F);
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
    }

    /**
     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
     * function is used in the AIEatGrass)
     */
    public void eatGrassBonus()
    {
        if (this.getSheared())
        {
            ++this.eatGrassTimes;

            if (this.eatGrassTimes >= 5)
            {
                this.setSheared(false);
                this.eatGrassTimes = 0;
            }
        }

        if (this.isChild())
        {
            int var1 = this.getGrowingAge() + 1200;

            if (var1 > 0)
            {
                var1 = 0;
            }

            this.setGrowingAge(var1);
        }
    }

    private boolean checkBiomeAndWeakness()
    {
        if (this.isChild())
        {
            return false;
        }
        else
        {
            BiomeGenBase var1 = this.worldObj.getBiomeGenForCoords((int)this.posX, (int)this.posZ);
            boolean var2 = this.isBiomeCold(var1);
            boolean var3 = this.isBiomeHot(var1);
            return this.getSheared() ? var2 : var3;
        }
    }

    private boolean isBiomeHot(BiomeGenBase var1)
    {
        return this.isBiomeInList(HOT_BIOMES, var1);
    }

    private boolean isBiomeCold(BiomeGenBase var1)
    {
        return this.isBiomeInList(COLD_BIOMES, var1);
    }

    private boolean isBiomeInList(BiomeGenBase[] var1, BiomeGenBase var2)
    {
        for (int var3 = 0; var3 < var1.length; ++var3)
        {
            if (var1[var3].equals(var2))
            {
                return true;
            }
        }

        return false;
    }

    public EntityMammoth Imprinting(double var1, double var3, double var5)
    {
        EntityPlayer var7 = this.worldObj.getClosestPlayer(var1, var3, var5, 50.0D);

        if (var7 == null)
        {
            return this;
        }
        else
        {
            this.setOwner(var7.username);
            this.setTamed(true);
            return this;
        }
    }

    public int getSwingTick()
    {
        return this.swingTick;
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
