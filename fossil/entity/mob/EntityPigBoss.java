package fossil.entity.mob;

import java.util.List;

import java.util.Random;

import fossil.client.FossilOptions;
import fossil.Fossil;
import fossil.fossilEnums.EnumPigBossSpeaks;
import fossil.fossilEnums.EnumPigmenSpeaks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityPigBoss extends EntityZombie
{
    private final int Melee = 0;
    private final int Ranged = 1;
    private int angerLevel = 0;
    private int randomSoundDelay = 0;
    public int AttackType = 1;
    public int FireballCount = 0;
    private final ItemStack defaultHeldItem = null;
    public PigBossSpeaker Mouth = new PigBossSpeaker();

    public EntityPigBoss(World var1)
    {
        super(var1);
        this.texture = "/fossil/textures/PigBoss.png";
        this.moveSpeed = 0.5F;
        this.health = 100;
        this.isImmuneToFire = true;
    }

    /**
     * Heal living entity (param: amount of half-hearts)
     */
    public void heal(int var1)
    {
        if (this.health > 0)
        {
            this.health += var1;

            if (this.worldObj.provider.isHellWorld)
            {
                if (this.health > 100)
                {
                    this.health = 100;
                }
            }
            else if (this.health > 200)
            {
                this.health = 200;
            }
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (this.randomSoundDelay > 0 && --this.randomSoundDelay == 0)
        {
            this.worldObj.playSoundAtEntity(this, "mob.zombiepig.zpigangry", this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
        }

        this.BlockTimeInteract();
        super.onUpdate();
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        if (!FossilOptions.ShouldAnuSpawn)
        {
            return false;
        }
        else
        {
            boolean var1 = this.worldObj.difficultySetting > 0 && this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox);

            if (!var1)
            {
                return false;
            }
            else
            {
                List var2 = this.worldObj.getEntitiesWithinAABB(EntityPigBoss.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(200.0D, 200.0D, 200.0D));
                var1 = var2.size() < 2;
                return var1;
            }
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setShort("Anger", (short)this.angerLevel);
        var1.setInteger("AttackMode", this.getAttackMode());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.angerLevel = var1.getShort("Anger");

        if (var1.hasKey("AttackMode"))
        {
            this.SetAttackMode(var1.getInteger("AttackMode"));
        }
    }

    /**
     * Finds the closest player within 16 blocks to attack, or null if this Entity isn't interested in attacking
     * (Animals, Spiders at day, peaceful PigZombies).
     */
    protected Entity findPlayerToAttack()
    {
        Entity var1 = super.findPlayerToAttack();

        if (var1 instanceof EntityPlayer && ((EntityPlayer)var1).getHealth() > 0)
        {
            this.Mouth.SendSpeech(EnumPigBossSpeaks.Hello);

            if (!this.worldObj.provider.isHellWorld)
            {
                ((EntityPlayer)var1).addStat(Fossil.pigbossOnEarth, 1);
            }
        }

        return var1;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (this.FireballCount < 50)
        {
            if (this.texture != "/fossil/textures/PigBoss.png")
            {
                this.texture = "/fossil/textures/PigBoss.png";
            }

            ++this.FireballCount;
        }

        if (this.FireballCount > 50 && this.getAttackMode() == 1 && this.getAITarget() != null)
        {
            if (this.texture != "/fossil/textures/PigBoss_Charging.png")
            {
                this.texture = "/fossil/textures/PigBoss_Charging.png";
            }

            this.setPathToEntity((PathEntity)null);
            this.faceEntity(this.getAITarget(), 30.0F, 30.0F);
        }

        if (this.getAttackMode() != 1)
        {
            this.FireballCount = 0;

            if ((new Random()).nextInt(5000) <= 5 && this.worldObj.getClosestPlayerToEntity(this, 16.0D) != null)
            {
                this.SkillSwordQi();
            }
        }

        List var1;

        if (this.getAITarget() != null && (new Random()).nextInt(100) <= 25)
        {
            var1 = this.worldObj.getEntitiesWithinAABB(EntityPigZombie.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(16.0D, 4.0D, 16.0D));

            if (!var1.isEmpty() && var1.size() >= 5)
            {
                this.CallSolders(var1, this.getAITarget());
            }
        }

        if (this.getAITarget() == null && (new Random()).nextInt(100) <= 20 && !this.worldObj.provider.isHellWorld)
        {
            var1 = this.worldObj.getEntitiesWithinAABB(EntityPig.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(16.0D, 4.0D, 16.0D));

            if (var1.size() >= 3)
            {
                this.TranferPigs(var1);
            }
        }
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, int var2)
    {
        Entity var3 = var1.getEntity();

        if (var3 instanceof EntityGhast)
        {
            return false;
        }
        else
        {
            if (var3 instanceof EntityPlayer)
            {
                this.becomeAngryAt(var3);

                if (var2 != 0)
                {
                    ItemStack var4 = ((EntityPlayer)var3).inventory.getCurrentItem();

                    if (var4 == null)
                    {
                        if (this.getAttackMode() != 0)
                        {
                            this.Mouth.SendSpeech(EnumPigBossSpeaks.BareHand);
                            this.SetAttackMode(0);
                            return super.attackEntityFrom(var1, var2);
                        }
                    }
                    else
                    {
                        if (var4.getItem() instanceof ItemSword && this.getAttackMode() != 0)
                        {
                            this.Mouth.SendSpeech(EnumPigBossSpeaks.Draw);
                            this.SetAttackMode(0);
                            return super.attackEntityFrom(var1, var2);
                        }

                        if (var1.damageType == "arrow" && this.getAttackMode() != 1)
                        {
                            this.Mouth.SendSpeech(EnumPigBossSpeaks.Coward);
                            this.SetAttackMode(1);
                            return super.attackEntityFrom(var1, var2);
                        }

                        if (!(var4.getItem() instanceof ItemBow) && !(var4.getItem() instanceof ItemSword))
                        {
                            double var5 = Math.sqrt(this.getDistanceSqToEntity(this.worldObj.getClosestPlayerToEntity(this, 24.0D)));

                            if (var5 > 6.0D && this.getAttackMode() != 1)
                            {
                                if (this.worldObj.provider.isHellWorld)
                                {
                                    this.Mouth.SendSpeech(EnumPigBossSpeaks.LeartHere);
                                }
                                else
                                {
                                    this.Mouth.SendSpeech(EnumPigBossSpeaks.LeartThere);
                                }

                                this.SetAttackMode(1);
                                return super.attackEntityFrom(var1, var2);
                            }

                            if (var5 < 6.0D && this.getAttackMode() != 0)
                            {
                                this.Mouth.SendSpeech(EnumPigBossSpeaks.UnknownRanged);
                                this.SetAttackMode(0);
                                return super.attackEntityFrom(var1, var2);
                            }
                        }
                    }
                }
                else if (this.getAttackMode() != 1)
                {
                    this.Mouth.SendSpeech(EnumPigBossSpeaks.UnknownMelee);
                    this.SetAttackMode(1);
                    return super.attackEntityFrom(var1, var2);
                }
            }

            return super.attackEntityFrom(var1, var2);
        }
    }

    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity var1, float var2)
    {
        if (this.getAttackMode() == 0)
        {
            super.attackEntity(var1, var2);
        }
        else if (this.getAttackMode() == 1)
        {
            if (this.FireballCount >= 100)
            {
                if ((new Random()).nextInt(1000) <= 950)
                {
                    double var3 = var1.posX - this.posX;
                    double var5 = var1.boundingBox.minY + (double)(var1.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
                    double var7 = var1.posZ - this.posZ;
                    this.worldObj.playSoundAtEntity(this, "mob.ghast.fireball", 10.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                    EntityLargeFireball var9 = new EntityLargeFireball(this.worldObj, this, var3, var5, var7);
                    double var10 = 4.0D;
                    Vec3 var12 = this.getLook(1.0F);
                    var9.posX = this.posX + var12.xCoord * var10;
                    var9.posY = this.posY + 0.8D;
                    var9.posZ = this.posZ + var12.zCoord * var10;
                    this.worldObj.spawnEntityInWorld(var9);
                }
                else
                {
                    this.SkillFireballRain(var1);
                }

                this.FireballCount = 0;
            }
            else
            {
                ++this.FireballCount;
            }
        }
    }

    private void becomeAngryAt(Entity var1) {}

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.zombiepig.zpig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombiepig.zpighurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombiepig.zpigdeath";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.porkCooked.itemID;
    }

    /**
     * Returns the item that this EntityLiving is holding, if any.
     */
    public ItemStack getHeldItem()
    {
        return this.getAttackMode() == 0 ? new ItemStack(Item.swordSteel) : this.defaultHeldItem;
    }

    public int getAttackMode()
    {
        return this.AttackType;
    }

    public void SetAttackMode(int var1)
    {
        if (var1 < 2)
        {
            this.AttackType = var1;

            if (var1 == 0)
            {
                this.moveSpeed = 0.9F;
            }

            if (var1 == 1)
            {
                this.moveSpeed = 0.5F;
            }
        }
    }

    public void SwitchAttackMode()
    {
        this.SetAttackMode((this.AttackType + 1) % 2);
    }

    private float GetDistanceWithEntity(Entity var1)
    {
        return (float)Math.sqrt(Math.pow(this.posX - var1.posX, 2.0D) + Math.pow(this.posY - var1.posY, 2.0D) + Math.pow(this.posZ - var1.posZ, 2.0D));
    }

    private void BlockTimeInteract()
    {
        if (!this.worldObj.provider.isHellWorld)
        {
            for (int var1 = (int)(Math.round(this.posX) - 1L); var1 <= (int)(Math.round(this.posX) + 1L); ++var1)
            {
                for (int var2 = (int)(Math.round(this.posZ) - 1L); var2 <= (int)(Math.round(this.posZ) + 1L); ++var2)
                {
                    int var3 = this.worldObj.getBlockId(var1, (int)(Math.round(this.posY) - 1L), var2);

                    if (var3 == Block.stone.blockID || var3 == Block.cobblestone.blockID)
                    {
                        this.worldObj.setBlockWithNotify(var1, (int)(Math.round(this.posY) - 1L), var2, Block.netherrack.blockID);
                    }

                    if (var3 == Block.dirt.blockID || var3 == Block.grass.blockID || var3 == Block.sand.blockID || var3 == Block.gravel.blockID)
                    {
                        this.worldObj.setBlockWithNotify(var1, (int)(Math.round(this.posY) - 1L), var2, Block.slowSand.blockID);
                    }

                    if (var3 == Block.ice.blockID)
                    {
                        this.worldObj.setBlockWithNotify(var1, (int)(Math.round(this.posY) - 1L), var2, Block.obsidian.blockID);
                    }

                    if (var3 == Block.blockClay.blockID)
                    {
                        this.worldObj.setBlockWithNotify(var1, (int)(Math.round(this.posY) - 1L), var2, Block.glowStone.blockID);
                    }

                    if ((long)var1 != Math.round(this.posX) && (long)var2 != Math.round(this.posZ) && (new Random()).nextInt(2000) <= 1 && this.worldObj.isAirBlock(var1, (int)Math.round(this.posY), var2))
                    {
                        this.worldObj.setBlockWithNotify(var1, (int)Math.round(this.posY), var2, Block.fire.blockID);
                    }
                }
            }

            if (this.worldObj.getWorldTime() > 19000L || this.worldObj.getWorldTime() < 17000L)
            {
                this.worldObj.setWorldTime(17000L);
            }
        }
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return !this.worldObj.provider.isHellWorld;
    }

    private void CallSolders(List var1, Entity var2)
    {
        this.Mouth.SendSpeech(EnumPigBossSpeaks.summon);

        for (int var3 = 0; var3 < var1.size(); ++var3)
        {
            Entity var4 = (Entity)var1.get(var3);

            if (var4 instanceof EntityPigZombie && ((EntityPigZombie)var4).getAITarget() == null)
            {
                EntityPigZombie var5 = (EntityPigZombie)var4;
                var5.setAttackTarget((EntityLiving)var2);
                (new PigmenSpeaker((EntityFriendlyPigZombie)null)).SendSpeech(EnumPigmenSpeaks.AnuSommon);
            }
        }
    }

    private void TranferPigs(List var1)
    {
        this.Mouth.SendSpeech(EnumPigBossSpeaks.Trans);

        for (int var2 = 0; var2 < var1.size(); ++var2)
        {
            Entity var3 = (Entity)var1.get(var2);

            if (var3 instanceof EntityPig)
            {
                var3.onStruckByLightning(new EntityLightningBolt(this.worldObj, var3.posX, var3.posY, var3.posZ));
            }
        }
    }

    private void SkillSwordQi()
    {
        List var1 = this.worldObj.getEntitiesWithinAABB(EntityLiving.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool(this.posX, this.posY, this.posZ, this.posX + 1.0D, this.posY + 1.0D, this.posZ + 1.0D).expand(32.0D, 4.0D, 32.0D));

        if (!var1.isEmpty())
        {
            this.Mouth.SendSpeech(EnumPigBossSpeaks.Qi);
            this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 6.0F, (1.0F + (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
            this.worldObj.spawnParticle("hugeexplosion", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

            for (int var2 = 0; var2 < var1.size(); ++var2)
            {
                EntityLiving var3 = (EntityLiving)var1.get(var2);
                double var4 = this.posX - var3.posX;
                double var6;

                for (var6 = this.posZ - var3.posZ; var4 * var4 + var6 * var6 < 1.0E-4D; var6 = (Math.random() - Math.random()) * 0.01D)
                {
                    var4 = (Math.random() - Math.random()) * 0.01D;
                }

                if (var3 != this)
                {
                    var3.knockBack(this, 0, var4 * 5.0D, var6 * 5.0D);
                }

                if (var3 instanceof EntityPlayer && (new Random()).nextInt(1000) >= 950)
                {
                    ((EntityPlayer)var3).inventory.dropAllItems();
                }
            }
        }
    }

    /**
     * knocks back this entity
     */
    public void knockBack(Entity var1, int var2, double var3, double var5)
    {
        if ((new Random()).nextInt(100) >= 25)
        {
            super.knockBack(var1, var2, var3, var5);
        }
    }

    public void SkillFireballRain(Entity var1)
    {
        this.Mouth.SendSpeech(EnumPigBossSpeaks.FireRain);
        double var3 = var1.posX - this.posX;
        double var5 = var1.boundingBox.minY + (double)(var1.height / 2.0F) - (this.posY + (double)(this.height / 2.0F));
        double var7 = var1.posZ - this.posZ;

        for (int var9 = 1; var9 <= 16; ++var9)
        {
            EntityLargeFireball var2 = new EntityLargeFireball(this.worldObj, this, var3, var5, var7);
            var2.posX += (double)((new Random()).nextInt(30) - 10);
            var2.posY = this.posY + 15.0D;
            var2.posZ += (double)((new Random()).nextInt(30) - 10);
            this.worldObj.spawnEntityInWorld(var2);
        }
    }
}
