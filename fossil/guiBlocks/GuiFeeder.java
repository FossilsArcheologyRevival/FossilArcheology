package fossil.guiBlocks;

import cpw.mods.fml.relauncher.Side;

import cpw.mods.fml.relauncher.SideOnly;
import fossil.Fossil;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class GuiFeeder extends GuiContainer
{
    private TileEntityFeeder FeederInventory;

    public GuiFeeder(InventoryPlayer var1, TileEntity var2)
    {
        super(new ContainerFeeder(var1, var2));
        this.FeederInventory = (TileEntityFeeder)var2;
    }

    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(Fossil.GetLangTextByKey("block.Feeder.Name"), 8, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int var1, int var2, float var3)
    {
        this.drawDefaultBackground();
        int var4 = this.guiLeft;
        int var5 = this.guiTop;
        this.drawGuiContainerBackgroundLayer(var3, var1, var2);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        super.drawScreen(var1, var2, var3);
        RenderHelper.enableGUIStandardItemLighting();
        GL11.glPushMatrix();
        GL11.glTranslatef((float)var4, (float)var5, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        Object var6 = null;
        short var7 = 240;
        short var8 = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var7 / 1.0F, (float)var8 / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.drawGuiContainerForegroundLayer();
        InventoryPlayer var9 = this.mc.thePlayer.inventory;

        if (var9.getItemStack() != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, 32.0F);
            this.zLevel = 200.0F;
            itemRenderer.zLevel = 200.0F;
            itemRenderer.renderItemAndEffectIntoGUI(this.fontRenderer, this.mc.renderEngine, var9.getItemStack(), var1 - var4 - 8, var2 - var5 - 8);
            itemRenderer.renderItemOverlayIntoGUI(this.fontRenderer, this.mc.renderEngine, var9.getItemStack(), var1 - var4 - 8, var2 - var5 - 8);
            this.zLevel = 0.0F;
            itemRenderer.zLevel = 0.0F;
        }

        this.fontRenderer.drawString("" + this.FeederInventory.getCurrentMeat(), 23, 32, 16711680);
        this.fontRenderer.drawString("" + this.FeederInventory.getCurreentVeg(), 120, 32, 243459);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        RenderHelper.enableStandardItemLighting();
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        int var4 = this.mc.renderEngine.getTexture("/fossil/textures/UIFeeder.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7 = this.FeederInventory.getMeatBarScaled(46);
        this.drawTexturedModalRect(var5 + 66, var6 + 55 - var7, 176, 46 - var7, 3, var7);
        int var8 = this.FeederInventory.getVegBarScaled(46);
        this.drawTexturedModalRect(var5 + 110, var6 + 55 - var8, 176, 46 - var8, 3, var8);
    }
}
