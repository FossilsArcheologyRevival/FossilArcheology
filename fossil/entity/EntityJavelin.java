package fossil.entity;

import com.google.common.io.ByteArrayDataInput;

import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import java.util.Iterator;
import java.util.List;

import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityJavelin extends EntityArrow implements IEntityAdditionalSpawnData
{
    private int xTile;
    private int yTile;
    private int zTile;
    private int inTile;
    private int inData;
    protected boolean inGround;
    private double damage = 2.0D;
    private int ticksInGround;
    private int ticksInAir;
    private int field_46027_au;
    public boolean arrowCritical;
    public EnumToolMaterial SelfMaterial;
    private int damaged;

    public EntityJavelin(World var1)
    {
        super(var1);
        this.SelfMaterial = EnumToolMaterial.WOOD;
    }

    public EntityJavelin(World var1, double var2, double var4, double var6)
    {
        super(var1, var2, var4, var6);
        this.SelfMaterial = EnumToolMaterial.WOOD;
    }

    public EntityJavelin(World var1, EntityLiving var2, float var3, EnumToolMaterial var4, int damagevalue)
    {
        super(var1, var2, var3);
        //this.SelfMaterial = EnumToolMaterial.WOOD;
        this.SelfMaterial = var4;
        this.damaged=damagevalue;
    }

    public EntityJavelin(World var1, EntityLiving var2, float var3)
    {
        super(var1, var2, var3);
        this.SelfMaterial = EnumToolMaterial.WOOD;
    }

    protected void entityInit() {}

    public void setArrowHeading(double var1, double var3, double var5, float var7, float var8)
    {
        float var9 = MathHelper.sqrt_double(var1 * var1 + var3 * var3 + var5 * var5);
        var1 /= (double)var9;
        var3 /= (double)var9;
        var5 /= (double)var9;
        var1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
        var3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
        var5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)var8;
        var1 *= (double)var7;
        var3 *= (double)var7;
        var5 *= (double)var7;
        this.motionX = var1;
        this.motionY = var3;
        this.motionZ = var5;
        float var10 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(var1, var5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(var3, (double)var10) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    /**
     * Sets the velocity to the args. Args: x, y, z
     */
    public void setVelocity(double var1, double var3, double var5)
    {
        this.motionX = var1;
        this.motionY = var3;
        this.motionZ = var5;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float var7 = MathHelper.sqrt_double(var1 * var1 + var5 * var5);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(var1, var5) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(var3, (double)var7) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.onEntityUpdate();

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float var1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)var1) * 180.0D / Math.PI);
        }

        int var16 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);

        if (var16 > 0)
        {
            Block.blocksList[var16].setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB var2 = Block.blocksList[var16].getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);

            if (var2 != null && var2.isVecInside(this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        if (this.arrowShake > 0)
        {
            --this.arrowShake;
        }

        if (this.inGround)
        {
            int var18 = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
            int var19 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

            if (var18 == this.inTile && var19 == this.inData)
            {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200)
                {
                    this.setDead();
                }
            }
            else
            {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else
        {
            ++this.ticksInAir;
            Vec3 var17 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
            Vec3 var3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition var4 = this.worldObj.rayTraceBlocks_do_do(var17, var3, false, true);
            var17 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
            var3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (var4 != null)
            {
                var3 = this.worldObj.getWorldVec3Pool().getVecFromPool(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
            }

            Entity var5 = null;
            List var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double var7 = 0.0D;
            Iterator var9 = var6.iterator();
            MovingObjectPosition var13;

            while (var9.hasNext())
            {
                Entity var11 = (Entity)var9.next();

                if (var11.canBeCollidedWith() && (var11 != this.shootingEntity || this.ticksInAir >= 5))
                {
                    float var10 = 0.3F;
                    AxisAlignedBB var12 = var11.boundingBox.expand((double)var10, (double)var10, (double)var10);
                    var13 = var12.calculateIntercept(var17, var3);

                    if (var13 != null)
                    {
                        double var14 = var17.distanceTo(var13.hitVec);

                        if (var14 < var7 || var7 == 0.0D)
                        {
                            var5 = var11;
                            var7 = var14;
                        }
                    }
                }
            }

            if (var5 != null)
            {
                var4 = new MovingObjectPosition(var5);
            }

            float var20;

            if (var4 != null)
            {
                if (var4.entityHit != null)
                {
                    var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int var21 = (int)Math.ceil((double)var20 * this.damage);
                    var21 += this.SelfMaterial.getDamageVsEntity();

                    if (this.arrowCritical)
                    {
                        var21 += this.rand.nextInt(var21 / 2 + 2);
                    }

                    var13 = null;
                    DamageSource var23;

                    if (this.shootingEntity == null)
                    {
                        var23 = DamageSource.causeArrowDamage(this, this);
                    }
                    else
                    {
                        var23 = DamageSource.causeThrownDamage(this, this.shootingEntity);
                    }
                    this.setVelocity(0, 0, 0);

                    if (this.isBurning())
                    {
                        var4.entityHit.setFire(5);
                    }

                    if (var4.entityHit.attackEntityFrom(var23, var21))
                    {
                        if (var4.entityHit instanceof EntityLiving)
                        {
                            if (!this.worldObj.isRemote)
                            {
                                EntityLiving var26 = (EntityLiving)var4.entityHit;
                                var26.setArrowCountInEntity(var26.getArrowCountInEntity() + 1);
                            }

                            if (this.field_46027_au > 0)
                            {
                                float var28 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                if (var28 > 0.0F)
                                {
                                    var4.entityHit.addVelocity(this.motionX * (double)this.field_46027_au * 0.6000000238418579D / (double)var28, 0.1D, this.motionZ * (double)this.field_46027_au * 0.6000000238418579D / (double)var28);
                                }
                            }
                        }

                        this.worldObj.playSoundAtEntity(this, "random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

                        if (!this.arrowCritical)
                        {
                            this.setDead();
                        }
                    }
                }
                else
                {
                    this.xTile = var4.blockX;
                    this.yTile = var4.blockY;
                    this.zTile = var4.blockZ;
                    this.inTile = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (double)((float)(var4.hitVec.xCoord - this.posX));
                    this.motionY = (double)((float)(var4.hitVec.yCoord - this.posY));
                    this.motionZ = (double)((float)(var4.hitVec.zCoord - this.posZ));
                    var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / (double)var20 * 0.05000000074505806D;
                    this.posY -= this.motionY / (double)var20 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / (double)var20 * 0.05000000074505806D;
                    this.worldObj.playSoundAtEntity(this, "random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.arrowCritical = false;
                }
            }

            if (this.arrowCritical)
            {
                for (int var22 = 0; var22 < 4; ++var22)
                {
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)var22 / 4.0D, this.posY + this.motionY * (double)var22 / 4.0D, this.posZ + this.motionZ * (double)var22 / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)var20) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
            {
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
            {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F)
            {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
            {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float var24 = 0.99F;
            float var27 = 0.05F;

            if (this.isInWater())
            {
                for (int var25 = 0; var25 < 4; ++var25)
                {
                    float var15 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)var15, this.posY - this.motionY * (double)var15, this.posZ - this.motionZ * (double)var15, this.motionX, this.motionY, this.motionZ);
                }

                var24 = 0.8F;
            }

            this.motionX *= (double)var24;
            this.motionY *= (double)var24;
            this.motionZ *= (double)var24;
            this.motionY -= (double)var27;
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        var1.setShort("xTile", (short)this.xTile);
        var1.setShort("yTile", (short)this.yTile);
        var1.setShort("zTile", (short)this.zTile);
        var1.setByte("inTile", (byte)this.inTile);
        var1.setByte("inData", (byte)this.inData);
        var1.setByte("shake", (byte)this.arrowShake);
        var1.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        var1.setByte("pickup", (byte)this.canBePickedUp);
        var1.setDouble("damage", this.damage);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        this.xTile = var1.getShort("xTile");
        this.yTile = var1.getShort("yTile");
        this.zTile = var1.getShort("zTile");
        this.inTile = var1.getByte("inTile") & 255;
        this.inData = var1.getByte("inData") & 255;
        this.arrowShake = var1.getByte("shake") & 255;
        this.inGround = var1.getByte("inGround") == 1;

        if (var1.hasKey("pickup"))
        {
            this.canBePickedUp = var1.getByte("pickup");
        }

        if (var1.hasKey("damage"))
        {
            this.damage = var1.getDouble("damage");
        }
    }

    /**
     * Called by a player entity when they collide with an entity
     */
    public void onCollideWithPlayer(EntityPlayer var1)
    {
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0)
        {
            boolean var2 = this.canBePickedUp == 1 || this.canBePickedUp == 2 && var1.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1 && !this.addJavelinToPlayer(var1))
            {
                var2 = false;
            }

            if (var2)
            {
                this.worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                var1.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }

    protected boolean addJavelinToPlayer(EntityPlayer var1)
    {
        ItemStack var2;

        switch (this.SelfMaterial.ordinal())//EntityJavelin$1.$SwitchMap$net$minecraft$item$EnumToolMaterial[this.SelfMaterial.ordinal()])
        {
            case 0:
            default:
                var2 = new ItemStack(Fossil.woodjavelin, 1);
                break;

            case 2:
                var2 = new ItemStack(Fossil.ironjavelin, 1);
                break;

            case 3:
                var2 = new ItemStack(Fossil.diamondjavelin, 1);
                break;

            case 1:
                var2 = new ItemStack(Fossil.stonejavelin, 1);
                break;

            case 4:
                var2 = new ItemStack(Fossil.goldjavelin, 1);
        }
        var2.setItemDamage(damaged);
        return var1.inventory.addItemStackToInventory(var2);
    }

    public float getShadowSize()
    {
        return 0.0F;
    }

    public void setDamage(double var1)
    {
        this.damage = var1;
    }

    private Item GetJavelinByMaterial()
    {
        switch (this.SelfMaterial.ordinal())//EntityJavelin$1.$SwitchMap$net$minecraft$item$EnumToolMaterial[this.SelfMaterial.ordinal()])
        {
            case 0:
            default:
                return Fossil.woodjavelin;

            case 2:
                return Fossil.ironjavelin;

            case 3:
                return Fossil.diamondjavelin;

            case 1:
                return Fossil.stonejavelin;

            case 4:
                return Fossil.goldjavelin;
        }
    }

    public void writeSpawnData(ByteArrayDataOutput var1)
    {
        var1.writeInt(this.SelfMaterial.ordinal());
    }

    public void readSpawnData(ByteArrayDataInput var1)
    {
        this.SelfMaterial = EnumToolMaterial.values()[var1.readInt()];
    }
}
