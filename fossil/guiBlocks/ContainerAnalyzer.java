package fossil.guiBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;

public class ContainerAnalyzer extends Container
{
    private TileEntityAnalyzer analyzer;
    private int cookTime = 0;
    private int burnTime = 0;
    private int itemBurnTime = 0;

    public ContainerAnalyzer(InventoryPlayer var1, TileEntity var2)
    {
        this.analyzer = (TileEntityAnalyzer)var2;
        int var3;
        int var4;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (var4 = 0; var4 < 3; ++var4)
            {
                this.addSlotToContainer(new Slot(this.analyzer, var4 + var3 * 3, 20 + var4 * 18, 17 + var3 * 18));
            }
        }

        this.addSlotToContainer(new SlotFurnace(var1.player, this.analyzer, 9, 116, 21));

        for (var3 = 0; var3 < 3; ++var3)
        {
            this.addSlotToContainer(new SlotFurnace(var1.player, this.analyzer, 10 + var3, 111 + 18 * var3, 53));
        }

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

    public void addCraftingToCrafters(ICrafting var1)
    {
        super.addCraftingToCrafters(var1);
        var1.sendProgressBarUpdate(this, 0, this.analyzer.analyzerCookTime);
        var1.sendProgressBarUpdate(this, 1, this.analyzer.analyzerBurnTime);
        var1.sendProgressBarUpdate(this, 2, this.analyzer.currentItemBurnTime);
    }

    /**
     * Updates crafting matrix; called from onCraftMatrixChanged. Args: none
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            if (this.cookTime != this.analyzer.analyzerCookTime)
            {
                var2.sendProgressBarUpdate(this, 0, this.analyzer.analyzerCookTime);
            }

            if (this.burnTime != this.analyzer.analyzerBurnTime)
            {
                var2.sendProgressBarUpdate(this, 1, this.analyzer.analyzerBurnTime);
            }

            if (this.itemBurnTime != this.analyzer.currentItemBurnTime)
            {
                var2.sendProgressBarUpdate(this, 2, this.analyzer.currentItemBurnTime);
            }
        }

        this.cookTime = this.analyzer.analyzerCookTime;
        this.burnTime = this.analyzer.analyzerBurnTime;
        this.itemBurnTime = this.analyzer.currentItemBurnTime;
    }

    public void updateProgressBar(int var1, int var2)
    {
        if (var1 == 0)
        {
            this.analyzer.analyzerCookTime = var2;
        }

        if (var1 == 1)
        {
            this.analyzer.analyzerBurnTime = var2;
        }

        if (var1 == 2)
        {
            this.analyzer.currentItemBurnTime = var2;
        }
    }

    public boolean canInteractWith(EntityPlayer var1)
    {
        return this.analyzer.isUseableByPlayer(var1);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer var1, int var2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(var2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (var2 == 2)
            {
                if (!this.mergeItemStack(var5, 3, 39, true))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            else if (var2 != 1 && var2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null)
                {
                    if (!this.mergeItemStack(var5, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (var2 >= 3 && var2 < 30)
                {
                    if (!this.mergeItemStack(var5, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (var2 >= 30 && var2 < 39 && !this.mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 3, 39, false))
            {
                return null;
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack)null);
            }
            else
            {
                var4.onSlotChanged();
            }

            if (var5.stackSize == var3.stackSize)
            {
                return null;
            }

            var4.onPickupFromSlot(var1, var5);
        }

        return var3;
    }
}
