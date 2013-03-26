package fossil.blocks;

import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockPalaePlanks extends Block
{

	public BlockPalaePlanks(int par1, int par2)
    {
        super(par1, par2, Material.wood);
        this.setCreativeTab(Fossil.tabFBlocks);
    }
    
    public String getTextureFile()
    {
     return "/fossil/textures/Fos_terrian.png";
    }
	
}
