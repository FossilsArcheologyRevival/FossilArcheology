package fossil.blocks;

import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fossil.Fossil;
import fossil.gens.WorldGenPalaeoraphe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BlockPalmSapling extends BlockFlower
{
	
	public BlockPalmSapling(int i, int j)
	{
        super(i, j);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        this.setCreativeTab(Fossil.tabFBlocks);
	}

	//@SideOnly(Side.SERVER)
    public void updateTick(World world, int i, int j, int k, Random random)
    {
    	if(!world.isRemote)
    	{
	        super.updateTick(world, i, j, k, random);
	
	        if(world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(7) == 0)
	        {
	            int l = world.getBlockMetadata(i, j, k);
	            if((l & 8) == 0)
	            	world.setBlockMetadataWithNotify(i, j, k, l | 8);
	            else
	                growTree(world, i, j, k, random);
	        }
    	}
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        j &= 3;
        if(j == 1)
        {
            return 62;  //63
        }
        if(j == 2)
        {
            return 62; //79
        } 
        else
        {
            //return super.getBlockTextureFromSideAndMetadata(i, j);
        	return 62;
        }
    }

    public void growTree(World world, int i, int j, int k, Random random)
    {
       //int l = world.getBlockMetadata(i, j, k) & 3;
        //world.setBlock(i, j, k, 0);
        WorldGenPalaeoraphe w0 = new WorldGenPalaeoraphe();
        int j1 = world.getBlockId(i, j - 1, k);
		if((j1 == Block.grass.blockID || j1 == Block.dirt.blockID) && j < 128 - 12 - 1)
        {
            w0.generate(world,random,i,j,k);
            world.setBlock/*AndMetadata*/(i, j, k, Fossil.palmLog.blockID);//, l);
        }
    }

    /*public int damageDropped(int i)
    {
        return i & 3;
    }*/

    public String getTextureFile()
    {
    	return ("/fossil/textures/Fos_items.png");
    }

    //@SideOnly(Side.SERVER)
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5)
    {
    	if(!world.isRemote)
    	{
    		ItemStack equipped = entityplayer.getCurrentEquippedItem();
    		if (equipped != null && (equipped.getItem() == Item.dyePowder) && (equipped.getItemDamage() == 15)) //if bone meal
    		{
    			int j1 = world.getBlockId(i, j, k);
    			if((j1 == Fossil.palmSap.blockID))
    			{
    				growTree(world, i, j, k, world.rand);
    				equipped.stackSize -= 1;
    			}
    			return true;
    		}
    	}
	    return false;
    }
}
