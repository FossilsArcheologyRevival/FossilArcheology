package fossil.guiBlocks;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

public class GuiTimeMachine extends GuiContainer
{
    private TileEntityTimeMachine timeMachineInstance;
    final int SQR_WIDTH = 34;
    final int SQR_HEIGHT = 13;
    final int SQR_POSX = 131;

    public GuiTimeMachine(InventoryPlayer var1, TileEntityTimeMachine var2)
    {
        super(new ContainerTimeMachine(var1, var2));
        this.timeMachineInstance = var2;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        super.initGui();
        this.controlList.clear();
    }

    protected void drawGuiContainerForegroundLayer()
    {
        //int var1 = 16711680;
        String var2 = this.timeMachineInstance.getChargeLevel() / 10 + "%";
        int var3 = (34 - this.fontRenderer.getStringWidth(var2)) / 2;
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        this.fontRenderer.drawString(var2, 131 + var3, 40, 16711680);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
    {
        boolean var4 = true;
        int var5 = this.mc.renderEngine.getTexture("/fossil/textures/TMGui.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var5);
        int var6 = (this.width - this.xSize) / 2;
        int var7 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var6, var7, 0, 0, this.xSize, this.ySize);
        this.timeMachineInstance.getClass();
        float var10000 = (float)(1000 - this.timeMachineInstance.getChargeLevel());
        this.timeMachineInstance.getClass();
        float var9 = var10000 / 1000.0F;
        int var8 = (int)(var9 * 75.0F);
        this.drawTexturedModalRect(var6 + 51, var7 + 6, 176, 1, 75, var8);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton var1)
    {
        switch (var1.id)
        {
            case 1:
                if (this.timeMachineInstance.isCharged() && !this.timeMachineInstance.isRestoring)
                {
                    this.timeMachineInstance.startWork();
                }

            case 2:
                if (!this.timeMachineInstance.isRestoring)
                {
                    this.timeMachineInstance.startMemory();
                }

            default:
        }
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        //((GuiButton)this.controlList.get(0)).enabled = this.timeMachineInstance.isCharged() && !this.timeMachineInstance.isRestoring;
        //((GuiButton)this.controlList.get(1)).enabled = !this.timeMachineInstance.isRestoring;
    }
}
