package fossil.guiBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Iterator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerFeeder extends Container
{
    int lastVegValue = 0;
    int lastMeatValue = 0;
    private TileEntityFeeder tileEntityFeeder;

    public ContainerFeeder(IInventory var1, TileEntity var2)
    {
        this.tileEntityFeeder = (TileEntityFeeder)var2;
        this.addSlotToContainer(new Slot(this.tileEntityFeeder, 0, 60, 62));
        this.addSlotToContainer(new Slot(this.tileEntityFeeder, 1, 104, 62));
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(var1, var3, 8 + var3 * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting var1)
    {
        super.addCraftingToCrafters(var1);
        var1.sendProgressBarUpdate(this, 0, this.tileEntityFeeder.VegCurrent);
        var1.sendProgressBarUpdate(this, 1, this.tileEntityFeeder.MeatCurrent);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        Iterator var1 = this.crafters.iterator();

        while (var1.hasNext())
        {
            ICrafting var2 = (ICrafting)var1.next();

            if (this.lastVegValue != this.tileEntityFeeder.VegCurrent)
            {
                var2.sendProgressBarUpdate(this, 0, this.tileEntityFeeder.VegCurrent);
            }

            if (this.lastMeatValue != this.tileEntityFeeder.MeatCurrent)
            {
                var2.sendProgressBarUpdate(this, 1, this.tileEntityFeeder.MeatCurrent);
            }
        }

        this.lastVegValue = this.tileEntityFeeder.VegCurrent;
        this.lastMeatValue = this.tileEntityFeeder.MeatCurrent;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int var1, int var2)
    {
        if (var1 == 0)
        {
            this.tileEntityFeeder.VegCurrent = var2;
        }

        if (var1 == 1)
        {
            this.tileEntityFeeder.MeatCurrent = var2;
        }
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return this.tileEntityFeeder.isUseableByPlayer(var1);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer var1, int var2)
    {
        return null;
    }
}
