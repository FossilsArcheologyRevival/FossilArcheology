package fossil.guiBlocks;

import fossil.Fossil;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiAnalyzer extends GuiContainer
{
    private TileEntityAnalyzer analyzerInventory;

    public GuiAnalyzer(InventoryPlayer var1, TileEntity var2)
    {
        super(new ContainerAnalyzer(var1, var2));
        this.analyzerInventory = (TileEntityAnalyzer)var2;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(Fossil.GetLangTextByKey("block.Analyzer.Name"), 19, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        int var4 = this.mc.renderEngine.getTexture("/fossil/textures/UIAnalyzer.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7 = this.analyzerInventory.getCookProgressScaled(21);
        this.drawTexturedModalRect(var5 + 80, var6 + 22, 177, 18, var7 + 1, 9);
    }
}
