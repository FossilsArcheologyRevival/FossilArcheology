package fossil.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossil.Fossil;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockPalaeSlab extends FossilSlabs
{
	
	public BlockPalaeSlab(int par1, boolean par2)
	{
		super(par1, par2, Material.wood);
		setLightOpacity(0);
	}

	public int idDropped(int par1, Random par2Random, int par3)
	{
		return Fossil.palaeSingleSlab.blockID;
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	{
		if(par1World.getBlockId(par2, par3 - 1, par4) == Fossil.palaeSingleSlab.blockID)
		{
			par1World.setBlockWithNotify(par2, par3, par4, 0);
			par1World.setBlockWithNotify(par2, par3 - 1, par4, Fossil.palaeDoubleSlab.blockID);
		}
		if(par1World.getBlockId(par2, par3 + 1, par4) == Fossil.palaeSingleSlab.blockID)
		{
			par1World.setBlockWithNotify(par2, par3, par4, 0);
			par1World.setBlockWithNotify(par2, par3 + 1, par4, Fossil.palaeDoubleSlab.blockID);
		}
	}

	protected ItemStack createStackedBlock(int par1)
	{
		return new ItemStack(Fossil.palaeSingleSlab.blockID, 2, par1 & 7);
	}

	public String getFullSlabName(int var1)
	{
		return null;
	}

	//gets texture file
	public String getTextureFile()
	{
		return "/fossil/textures/Fos_terrian.png";
	}

	@SideOnly(Side.CLIENT) //Client side only
	public int getBlockTextureFromSide(int i)
	{ 
		return 80;
	}

}
