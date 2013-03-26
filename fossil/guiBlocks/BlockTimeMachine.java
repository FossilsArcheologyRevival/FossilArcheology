package fossil.guiBlocks;

import java.util.Random;


import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTimeMachine extends BlockContainer
{
    public BlockTimeMachine(int var1, int var2, Material var3)
    {
        super(var1, 1, var3);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
        this.setLightOpacity(0);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/T_mac_o.png";
    }

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public int getBlockTexture(IBlockAccess var1, int var2, int var3, int var4, int var5)
    {
        return var5 == 1 ? 0 : (var5 == 0 ? 1 : 16 + (var5 <= 3 ? 0 : 1));
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World var1)
    {
        return new TileEntityTimeMachine();
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World var1, int var2, int var3, int var4, Random var5)
    {
        super.randomDisplayTick(var1, var2, var3, var4, var5);

        for (int var6 = var2 - 2; var6 <= var2 + 2; ++var6)
        {
            for (int var7 = var4 - 2; var7 <= var4 + 2; ++var7)
            {
                if (var6 > var2 - 2 && var6 < var2 + 2 && var7 == var4 - 1)
                {
                    var7 = var4 + 2;
                }

                if (var5.nextInt(16) == 0)
                {
                    for (int var8 = var3; var8 <= var3 + 1; ++var8)
                    {
                        if (var1.getBlockId(var6, var8, var7) == Block.bookShelf.blockID)
                        {
                            if (!var1.isAirBlock((var6 - var2) / 2 + var2, var8, (var7 - var4) / 2 + var4))
                            {
                                break;
                            }

                            var1.spawnParticle("enchantmenttable", (double)var2 + 0.5D, (double)var3 + 2.0D, (double)var4 + 0.5D, (double)((float)(var6 - var2) + var5.nextFloat()) - 0.5D, (double)((float)(var8 - var3) - var5.nextFloat() - 1.0F), (double)((float)(var7 - var4) + var5.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int var1, int var2)
    {
        return this.getBlockTextureFromSide(var1);
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int var1)
    {
        return var1 == 0 ? this.blockIndexInTexture : (var1 == 1 ? this.blockIndexInTexture : this.blockIndexInTexture + 16);
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
            TileEntityTimeMachine var10 = (TileEntityTimeMachine)var1.getBlockTileEntity(var2, var3, var4);

            if (var10 != null)
            {
            	var5.openGui(Fossil.instance, 5, var1, var2, var3, var4);
            }

            return true;
        }
    }
}