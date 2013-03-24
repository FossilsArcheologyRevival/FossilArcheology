package fossil.entity;

import com.google.common.io.ByteArrayDataInput;

import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;

import fossil.Fossil;
import fossil.fossilEnums.EnumStoneboard;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityStoneboard extends Entity implements IEntityAdditionalSpawnData
{
    private int tickCounter1;
    public int direction;
    public int xPosition;
    public int yPosition;
    public int zPosition;
    public EnumStoneboard art;

    public EntityStoneboard(World var1)
    {
        super(var1);
        this.tickCounter1 = 0;
        this.direction = 0;
        this.yOffset = 0.0F;
        this.setSize(0.5F, 0.5F);
    }

    public EntityStoneboard(World var1, int var2, int var3, int var4, int var5)
    {
        this(var1);        
        this.xPosition = var2;
        this.yPosition = var3;
        this.zPosition = var4;
        ArrayList var6 = new ArrayList();
        EnumStoneboard[] var7 = EnumStoneboard.values();
        int var8 = var7.length;

        for (int var9 = 0; var9 < var8; ++var9)
        {
            EnumStoneboard var10 = var7[var9];
            this.art = var10;
            this.setDirection(var5);

            if (this.onValidSurface())
            {
                var6.add(var10);
            }
        }

        if (var6.size() > 0)
        {
            this.art = (EnumStoneboard)var6.get(this.rand.nextInt(var6.size()));
        }

        this.setDirection(var5);
    }

    @SideOnly(Side.CLIENT)
    public EntityStoneboard(World var1, int var2, int var3, int var4, int var5, String var6)
    {
        this(var1);
        this.xPosition = var2;
        this.yPosition = var3;
        this.zPosition = var4;
        EnumStoneboard[] var7 = EnumStoneboard.values();
        int var8 = var7.length;

        for (int var9 = 0; var9 < var8; ++var9)
        {
            EnumStoneboard var10 = var7[var9];

            if (var10.title.equals(var6))
            {
                this.art = var10;
                break;
            }
        }

        this.setDirection(var5);
    }

    protected void entityInit() {}

    public void setDirection(int var1)
    {
        this.direction = var1;
        this.prevRotationYaw = this.rotationYaw = (float)(var1 * 90);
        float var2 = (float)this.art.sizeX;
        float var3 = (float)this.art.sizeY;
        float var4 = (float)this.art.sizeX;

        if (var1 != 0 && var1 != 2)
        {
            var2 = 0.5F;
        }
        else
        {
            var4 = 0.5F;
            this.rotationYaw = this.prevRotationYaw = (float)(Direction.footInvisibleFaceRemap[var1] * 90);//necessary?
        }

        var2 /= 32.0F;
        var3 /= 32.0F;
        var4 /= 32.0F;
        float var5 = (float)this.xPosition + 0.5F;
        float var6 = (float)this.yPosition + 0.5F;
        float var7 = (float)this.zPosition + 0.5F;
        float var8 = 0.5625F;

        if (var1 == 2)
        {
            var7 -= var8;
        }

        if (var1 == 1)
        {
            var5 -= var8;
        }

        if (var1 == 0)
        {
            var7 += var8;
        }

        if (var1 == 3)
        {
            var5 += var8;
        }

        if (var1 == 2)
        {
            var5 -= this.func_411_c(this.art.sizeX);
        }

        if (var1 == 1)
        {
            var7 += this.func_411_c(this.art.sizeX);
        }

        if (var1 == 0)
        {
            var5 += this.func_411_c(this.art.sizeX);
        }

        if (var1 == 3)
        {
            var7 -= this.func_411_c(this.art.sizeX);
        }

        var6 += this.func_411_c(this.art.sizeY);
        this.setPosition((double)var5, (double)var6, (double)var7);
        float var9 = -0.00625F;
        this.boundingBox.setBounds((double)(var5 - var2 - var9), (double)(var6 - var3 - var9), (double)(var7 - var4 - var9), (double)(var5 + var2 + var9), (double)(var6 + var3 + var9), (double)(var7 + var4 + var9));
    }

    private float func_411_c(int var1)
    {
        return var1 == 32 ? 0.5F : (var1 != 64 ? 0.0F : 0.5F);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (this.tickCounter1++ == 100 && !this.worldObj.isRemote)
        {
            this.tickCounter1 = 0;

            if (!this.onValidSurface())
            {
                this.setDead();
                this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Fossil.stoneboard)));
            }
        }
    }

    public boolean onValidSurface()
    {
        if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() > 0)		//test for collisions
        {
            return false;
        }
        else
        {
            int Width = this.art.sizeX / 16;	//Size of The Tablet
            int Height = this.art.sizeY / 16;
            
            
            int xPos = this.xPosition;			//Starting Position of the Tablet
            int yPos = MathHelper.floor_double(this.posY - (double)((float)this.art.sizeY / 32.0F)); // Center is where you clicked: start at -sizeY/2
            int zPos = this.zPosition;
            
            if (this.direction == 0 || this.direction == 2)//adjust the center for the corresponding directions
            {
                xPos = MathHelper.floor_double(this.posX - (double)((float)this.art.sizeX / 32.0F));
            }

            if (this.direction == 1 || this.direction == 3)//adjust the center for the corresponding directions
            {
                zPos = MathHelper.floor_double(this.posZ - (double)((float)this.art.sizeX / 32.0F));
            }

            for (int side = 0; side < Width; side++)//check for the whole plane if solid blocks behind
            {
                for (int up = 0; up < Height; up++)
                {
                    if (this.direction == 1 || this.direction == 3)
                    {
                        if(!this.worldObj.getBlockMaterial(this.xPosition, yPos + up, zPos + side).isSolid())
                        	return false;
                    }
                    else
                    {
                        if(!this.worldObj.getBlockMaterial(xPos + side, yPos + up, this.zPosition).isSolid())
                        	return false;
                    }
                }
            }

            List collidingEntities = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox);//check for colliding entities

            for (int i = 0; i < collidingEntities.size(); i++)
            {
                if ((collidingEntities.get(i) instanceof EntityStoneboard))// || (collidingEntities.get(i) instanceof EntityHanging))this line seems not to be necessary
                {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return true;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource var1, int var2)
    {
        if (!this.isDead && !this.worldObj.isRemote)
        {
            this.setDead();
            this.setBeenAttacked();
            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Fossil.stoneboard)));
        }

        return true;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        var1.setByte("Dir", (byte)this.direction);
        var1.setString("Motive", this.art.title);
        var1.setInteger("TileX", this.xPosition);
        var1.setInteger("TileY", this.yPosition);
        var1.setInteger("TileZ", this.zPosition);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        this.direction = var1.getByte("Dir");
        this.xPosition = var1.getInteger("TileX");
        this.yPosition = var1.getInteger("TileY");
        this.zPosition = var1.getInteger("TileZ");
        String var2 = var1.getString("Motive");
        EnumStoneboard[] var3 = EnumStoneboard.values();
        int var4 = var3.length;

        for (int var5 = 0; var5 < var4; ++var5)
        {
            EnumStoneboard var6 = var3[var5];

            if (var6.title.equals(var2))
            {
                this.art = var6;
            }
        }

        if (this.art == null)
        {
            this.art = EnumStoneboard.Portol;
        }

        this.setDirection(this.direction);
    }

    /**
     * Tries to moves the entity by the passed in displacement. Args: x, y, z
     */
    public void moveEntity(double var1, double var3, double var5)
    {
        if (!this.worldObj.isRemote && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D)
        {
            this.setDead();
            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Fossil.stoneboard)));
        }
    }

    /**
     * Adds to the current velocity of the entity. Args: x, y, z
     */
    public void addVelocity(double var1, double var3, double var5)
    {
        if (!this.worldObj.isRemote && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D)
        {
            this.setDead();
            this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Fossil.stoneboard)));
        }
    }

    public void writeSpawnData(ByteArrayDataOutput var1)
    {
        EnumStoneboard[] var2 = EnumStoneboard.values();

        for (int var3 = 0; var3 < var2.length; ++var3)
        {
            if (var2[var3] == this.art)
            {
                var1.writeInt(var3);
                return;
            }
        }

        var1.writeInt(0);
    }

    public void readSpawnData(ByteArrayDataInput var1)
    {
        int var2 = var1.readInt();
        this.art = EnumStoneboard.values()[var2];
    }
}
