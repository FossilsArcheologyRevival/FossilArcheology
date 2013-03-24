package fossil.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockPalmLog extends Block
{
    public BlockPalmLog(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(Fossil.tabFBlocks);
    }

    // this sets how the block is rendered. i recomend keeping it at 31. 
    public int getRenderType()
    {
        return 31;
    }
    
    /*public boolean isOpaqueCube()
    {
        return true;
    }*/
    
    /*public boolean renderAsNormalBlock()
    {
        return false;
    }*/

    // this sets the amount droped when broken.
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    // this tells the game what to drop if the block is brocken with an explosion. an example of this would be creeper explosions
    // making stone drop cobblestone. 
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Fossil.palmLog.blockID;
    }

    // this essentially helps leaves to decay when they are not conected to wood. 
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        byte var7 = 4;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
        {
            for (int var9 = -var7; var9 <= var7; ++var9)
            {
                for (int var10 = -var7; var10 <= var7; ++var10)
                {
                    for (int var11 = -var7; var11 <= var7; ++var11)
                    {
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

                        if (Block.blocksList[var12] != null)
                        {
                            Block.blocksList[var12].beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
                        }
                    }
                }
            }
        }
    }

    //this code is used for meta data. it is also used to get the mounted orientations
    /*public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        int var9 = par1World.getBlockMetadata(par2, par3, par4) & 3;
        byte var10 = 0;

        switch (par5)
        {
            case 0:
            case 1:
                var10 = 0;
                break;
            case 2:
            case 3:
                var10 = 8;
                break;
            case 4:
            case 5:
                var10 = 4;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 | var10);
    }*/
    
    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var10 = par9 & 3;
        byte var11 = 0;

        switch (par5)
        {
            case 0:
            case 1:
                var11 = 0;
                break;
            case 2:
            case 3:
                var11 = 8;
                break;
            case 4:
            case 5:
                var11 = 4;
        }

        return var10 | var11;
    }

    //this code here separates the textures top,bottom etc. to simplify things for you just replace the 2 and 1 with values of 
    //your textures. i have put some /**/ behind the said values to help you find what im talking about. 
    //replace a 2 with what the top and bottom textures would be. replace 1 with the sides
    //if this for some reason does not work play around with this till you get it ^_^
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        int var3 = par2 & 12;
        int var4 = par2 & 3;
        return var3 == 0 && (par1 == 1 || par1 == 0) ? 68 : (var3 == 4 && (par1 == 5 || par1 == 4) ? 68 : (var3 == 8 && (par1 == 2 || par1 == 3) ? 68 : (var4 == 1 ? 24 : (var4 == 2 ? 25 : (var4 == 3 ? 26 : 52)))));
    }
    //this can be ignored
    /*public int damageDropped(int par1)
    {
        return par1 & 3;
    }

    //this can be ignored
    public static int limitToValidMetadata(int par0)
    {
        return par0 & 3;
    }*/

    @SideOnly(Side.CLIENT)

    // i dont think this is needed however i kept it. this adds metadata blocks to the creative inventory. as you can see this
    // one will only add the first metablock
    /*public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));

    }*/

    //best to just ignore this
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(this.blockID, 1,0);//, limitToValidMetadata(par1));
    }

    @Override
    //sustains leaves
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }

    @Override
    //tells minecraft that this block is wood. 
    public boolean isWood(World world, int x, int y, int z)
    {
        return true;
    }
    public String getTextureFile() //this specifies the texture path. 
    {
     return "/fossil/textures/Fos_terrian.png";
    }

}
