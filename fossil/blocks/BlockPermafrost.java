package fossil.blocks;

import java.util.Random;

import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPermafrost extends BlockBreakable
{
    public BlockPermafrost(int var1, int var2)
    {
        super(var1, var2, Material.ice, false);
        this.setTickRandomly(true);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_terrian.png";
    }

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5)
    {
        return super.shouldSideBeRendered(var1, var2, var3, var4, 1 - var5);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        if (var1.getSavedLightValue(EnumSkyBlock.Block, var2, var3, var4) <= 11 - Block.lightOpacity[this.blockID] && (!var1.canBlockSeeTheSky(var2, var3 + 1, var4) || !var1.isDaytime()))
        {
            for (int var6 = -1; var6 <= 1; ++var6)
            {
                for (int var7 = -1; var7 <= 1; ++var7)
                {
                    for (int var8 = -1; var8 <= 1; ++var8)
                    {
                        if (var1.getBlockId(var2 + var6, var3 + var7, var4 + var8) == Block.waterMoving.blockID || var1.getBlockId(var2 + var6, var3 + var7, var4 + var8) == Block.waterStill.blockID)
                        {
                            var1.setBlock(var2 + var6, var3 + var7, var4 + var8, Block.ice.blockID);
                        }

                        if (var1.getBlockId(var2 + var6, var3 + var7, var4 + var8) == Block.lavaMoving.blockID || var1.getBlockId(var2 + var6, var3 + var7, var4 + var8) == Block.lavaStill.blockID || var1.getBlockId(var2 + var6, var3 + var7, var4 + var8) == Block.fire.blockID)
                        {
                            var1.setBlock(var2, var3, var4, Block.dirt.blockID);
                            return;
                        }

                        if (var1.getBlockId(var2 + var6, var3 + var7, var4 + var8) == Block.stone.blockID)
                        {
                            var1.setBlock(var2 + var6, var3 + var7, var4 + var8, Fossil.blockIcedStone.blockID);
                            var1.setBlockMetadata(var2 + var6, var3 + var7, var4 + var8, 1);
                        }
                    }
                }
            }
        }
        else
        {
            var1.setBlock(var2, var3, var4, Block.dirt.blockID);
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (var1.getSavedLightValue(EnumSkyBlock.Block, var2, var3, var4) <= 11 - Block.lightOpacity[this.blockID] && (!var1.canBlockSeeTheSky(var2, var3 + 1, var4) || !var1.isDaytime()))
        {
            int var6 = 0;

            while (var6 < 5)
            {
                int var7 = (new Random()).nextInt(3) - 1;
                int var8 = (new Random()).nextInt(3) - 1;
                int var9 = (new Random()).nextInt(3) - 1;

                if (var1.getBlockId(var2 + var7, var3 + var8, var4 + var9) != Block.waterMoving.blockID && var1.getBlockId(var2 + var7, var3 + var8, var4 + var9) != Block.waterStill.blockID)
                {
                    if (var1.getBlockId(var2 + var7, var3 + var8, var4 + var9) != Block.lavaMoving.blockID && var1.getBlockId(var2 + var7, var3 + var8, var4 + var9) != Block.lavaStill.blockID && var1.getBlockId(var2 + var7, var3 + var8, var4 + var9) != Block.fire.blockID)
                    {
                        ++var6;
                        continue;
                    }

                    var1.setBlockWithNotify(var2, var3, var4, Block.stone.blockID);
                    return;
                }

                var1.setBlockWithNotify(var2 + var7, var3 + var8, var4 + var9, Block.ice.blockID);
                return;
            }
        }
        else
        {
            var1.setBlockWithNotify(var2, var3, var4, Block.dirt.blockID);
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int var1, Random var2, int var3)
    {
        int var4 = (new Random()).nextInt(20000);
        return var4 >= 0 && var4 < 4000 ? Fossil.fernSeed.itemID : (var4 >= 4000 && var4 < 8000 ? Fossil.blockSkull.blockID : (var4 >= 8000 && var4 < 12000 ? Fossil.icedMeat.itemID : (var4 >= 12000 && var4 < 16000 ? Item.bone.itemID : (var4 >= 16000 && var4 < 20000 ? Item.book.itemID : Block.dirt.blockID))));
    }
}
