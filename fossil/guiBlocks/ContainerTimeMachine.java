package fossil.guiBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTimeMachine extends Container
{
    private TileEntityTimeMachine timeMachine;
    private int lastCookTime = 0;
    private int lastBurnTime = 0;
    private int lastItemBurnTime = 0;

    public ContainerTimeMachine(InventoryPlayer var1, TileEntityTimeMachine var2)
    {
        this.timeMachine = var2;
        int var3;
        int var4;

        for (var3 = 0; var3 < 2; ++var3)
        {
            for (var4 = 0; var4 < 3; ++var4)
            {
                this.addSlotToContainer(new Slot(var2, var4 + var3 * 3, 7 + 18 * var3, 17 + 18 * var4));
            }
        }

        this.addSlotToContainer(new Slot(var2, 6, 79, 36));

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(var1, var3, 8 + var3 * 18, 142));
        }
    }

    public void updateProgressBar(int var1, int var2) {}

    public boolean canInteractWith(EntityPlayer var1)
    {
        return this.timeMachine.isUseableByPlayer(var1);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(int var1)
    {
        return null;
    }
}
