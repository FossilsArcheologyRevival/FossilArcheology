package fossil.client;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class FossilBlockRenderHandler implements ISimpleBlockRenderingHandler
{
    public FossilBlockRenderHandler()
    {
        Fossil.blockRendererID = this.getRenderId();
    }

    public void renderInventoryBlock(Block var1, int var2, int var3, RenderBlocks var4) {}

    public boolean renderWorldBlock(IBlockAccess var1, int var2, int var3, int var4, Block var5, int var6, RenderBlocks var7)
    {
        return false;
    }

    public boolean shouldRender3DInInventory()
    {
        return false;
    }

    public int getRenderId()
    {
        return 633;
    }
}
