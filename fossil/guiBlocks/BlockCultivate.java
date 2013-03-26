package fossil.guiBlocks;

import java.util.Random;

import fossil.Fossil;
import fossil.entity.mob.EntityFailuresaurus;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCultivate extends BlockContainer
{
    //private final String VAT = "Vat.";
    //private final String ERR_OUTBREAK = "Err.OutBreak";
    private Random furnaceRand = new Random();
    private final boolean isActive;
    private static boolean keepFurnaceInventory = false;

    public BlockCultivate(int var1, boolean var2)
    {
        super(var1, Material.glass);
        this.isActive = var2;
        this.blockIndexInTexture = 20;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        return Fossil.blockcultivateIdle.blockID;
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World var1, int var2, int var3, int var4)
    {
        super.onBlockAdded(var1, var2, var3, var4);
        this.setDefaultDirection(var1, var2, var3, var4);
    }

    private void setDefaultDirection(World var1, int var2, int var3, int var4)
    {
        if (!var1.isRemote)
        {
            int var5 = var1.getBlockId(var2, var3, var4 - 1);
            int var6 = var1.getBlockId(var2, var3, var4 + 1);
            int var7 = var1.getBlockId(var2 - 1, var3, var4);
            int var8 = var1.getBlockId(var2 + 1, var3, var4);
            byte var9 = 3;

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
            {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
            {
                var9 = 4;
            }

            var1.setBlockMetadataWithNotify(var2, var3, var4, var9);
        }
    }

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTexture(IBlockAccess var1, int var2, int var3, int var4, int var5)
    {
        if (var5 == 1)
        {
            return 36;
        }
        else if (var5 == 0)
        {
            return 36;
        }
        else
        {
            int var6 = var1.getBlockMetadata(var2, var3, var4);
            return var5 != var6 ? (this.isActive ? 21 : 20) : (this.isActive ? 21 : 20);
        }
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5) {}

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int var1)
    {
        return var1 == 1 ? 36 : (var1 == 0 ? 36 : (var1 == 3 ? 20 : 20));
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer var5, int var6, float var7, float var8, float var9)
    {
        if (var1.isRemote)
        {
            return true;
        }
        else
        {
        	var5.openGui(Fossil.instance, 1, var1, var2, var3, var4);
            return true;
        }
    }

    public static void updateFurnaceBlockState(boolean var0, World var1, int var2, int var3, int var4)
    {
        int var5 = var1.getBlockMetadata(var2, var3, var4);
        TileEntity var6 = var1.getBlockTileEntity(var2, var3, var4);
        keepFurnaceInventory = true;

        if (var0)
        {
            var1.setBlockWithNotify(var2, var3, var4, Fossil.blockcultivateActive.blockID);
        }
        else
        {
            var1.setBlockWithNotify(var2, var3, var4, Fossil.blockcultivateIdle.blockID);
        }

        keepFurnaceInventory = false;
        var1.setBlockMetadataWithNotify(var2, var3, var4, var5);
        var6.validate();
        var1.setBlockTileEntity(var2, var3, var4, var6);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntityCultivate();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World var1, int var2, int var3, int var4, EntityLiving var5)
    {
        int var6 = MathHelper.floor_double((double)(var5.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 2);
        }

        if (var6 == 1)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 5);
        }

        if (var6 == 2)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 3);
        }

        if (var6 == 3)
        {
            var1.setBlockMetadataWithNotify(var2, var3, var4, 4);
        }
    }

    private void ReturnIron(World var1, int var2, int var3, int var4)
    {
        ItemStack var5 = new ItemStack(Item.ingotIron, 3);
        float var6 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
        float var7 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
        float var8 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

        while (var5.stackSize > 0)
        {
            int var9 = this.furnaceRand.nextInt(21) + 10;

            if (var9 > var5.stackSize)
            {
                var9 = var5.stackSize;
            }

            var5.stackSize -= var9;
            EntityItem var10 = new EntityItem(var1, (double)((float)var2 + var6), (double)((float)var3 + var7), (double)((float)var4 + var8), new ItemStack(var5.itemID, var9, var5.getItemDamage()));
            float var11 = 0.05F;
            var10.motionX = (double)((float)this.furnaceRand.nextGaussian() * var11);
            var10.motionY = (double)((float)this.furnaceRand.nextGaussian() * var11 + 0.2F);
            var10.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var11);
            var1.spawnEntityInWorld(var10);
        }
    }

    public void onBlockRemovalLost(World var1, int var2, int var3, int var4, boolean var5)
    {
        keepFurnaceInventory = false;
        String var6 = Fossil.GetLangTextByKey("Cultivate.OutBreak");

        for (int var7 = 0; var7 < var1.playerEntities.size(); ++var7)
        {
            Fossil.ShowMessage(var6, (EntityPlayer)var1.playerEntities.get(var7));
        }

        this.ReturnIron(var1, var2, var3, var4);
        var1.setBlockWithNotify(var2, var3, var4, 0);
        var1.removeBlockTileEntity(var2, var3, var4);

        if (var5)
        {
            Object var9 = null;
            var1.playAuxSFX(2001, var2, var3, var4, Block.glass.blockID);
            var1.setBlockWithNotify(var2, var3, var4, Block.waterMoving.blockID);

            if (var1.isRemote)
            {
                return;
            }

            int var8 = var1.rand.nextInt(100);

            if (var8 <= 5)
            {
                var9 = new EntityCreeper(var1);
            }

            if (var8 > 5 && var8 < 10)
            {
                var9 = new EntityPigZombie(var1);
            }

            if (var8 >= 10)
            {
                var9 = new EntityFailuresaurus(var1);
            }

            ((EntityLiving)var9).setLocationAndAngles((double)var2, (double)var3, (double)var4, var1.rand.nextFloat() * 360.0F, 0.0F);
            var1.spawnEntityInWorld((Entity)var9);
        }
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World var1, int var2, int var3, int var4, int var5, int var6)
    {
        if (!keepFurnaceInventory)
        {
            TileEntityCultivate var7 = (TileEntityCultivate)var1.getBlockTileEntity(var2, var3, var4);

            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null)
                {
                    float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                    while (var9.stackSize > 0)
                    {
                        int var13 = this.furnaceRand.nextInt(21) + 10;

                        if (var13 > var9.stackSize)
                        {
                            var13 = var9.stackSize;
                        }

                        var9.stackSize -= var13;
                        EntityItem var14 = new EntityItem(var1, (double)((float)var2 + var10), (double)((float)var3 + var11), (double)((float)var4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));
                        float var15 = 0.05F;
                        var14.motionX = (double)((float)this.furnaceRand.nextGaussian() * var15);
                        var14.motionY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
                        var14.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
                        var1.spawnEntityInWorld(var14);
                    }
                }
            }
        }

        super.breakBlock(var1, var2, var3, var4, var5, var6);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_terrian.png";
    }
}
