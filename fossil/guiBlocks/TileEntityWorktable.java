package fossil.guiBlocks;

import fossil.Fossil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityWorktable extends TileEntity implements IInventory, ISidedInventory
{
    private ItemStack[] furnaceItemStacks = new ItemStack[3];
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int var1)
    {
        return this.furnaceItemStacks[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.furnaceItemStacks[var1] != null)
        {
            ItemStack var3;

            if (this.furnaceItemStacks[var1].stackSize <= var2)
            {
                var3 = this.furnaceItemStacks[var1];
                this.furnaceItemStacks[var1] = null;
                return var3;
            }
            else
            {
                var3 = this.furnaceItemStacks[var1].splitStack(var2);

                if (this.furnaceItemStacks[var1].stackSize == 0)
                {
                    this.furnaceItemStacks[var1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int var1, ItemStack var2)
    {
        this.furnaceItemStacks[var1] = var2;

        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
        {
            var2.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "Worktable";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound var1)
    {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = var1.getShort("BurnTime");
        this.furnaceCookTime = var1.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound var1)
    {
        super.writeToNBT(var1);
        var1.setShort("BurnTime", (short)this.furnaceBurnTime);
        var1.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3)
        {
            if (this.furnaceItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.furnaceItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        var1.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    public int getCookProgressScaled(int var1)
    {
        return this.furnaceCookTime * var1 / this.timeToSmelt();
    }

    public int getBurnTimeRemainingScaled(int var1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = timeToSmelt();
        }

        return this.furnaceBurnTime * var1 / this.currentItemBurnTime;
    }

    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var1 = this.furnaceBurnTime > 0;
        boolean var2 = false;

        if (this.furnaceBurnTime > 0)
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.furnaceBurnTime = this.getItemBurnTime(this.furnaceItemStacks[1]);

                if (this.furnaceBurnTime > 0)
                {
                    var2 = true;

                    if (this.furnaceItemStacks[1] != null)
                    {
                        if (this.furnaceItemStacks[1].getItem().hasContainerItem())
                        {
                            this.furnaceItemStacks[1] = new ItemStack(this.furnaceItemStacks[1].getItem().getContainerItem());
                        }
                        else
                        {
                            --this.furnaceItemStacks[1].stackSize;
                        }

                        if (this.furnaceItemStacks[1].stackSize == 0)
                        {
                            this.furnaceItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == timeToSmelt())
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceBurnTime > 0)
            {
                var2 = true;
                BlockWorktable.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    private boolean canSmelt()
    {
        if (this.furnaceItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            //ItemStack var1 = this.CheckSmelt(this.furnaceItemStacks[0].getItem().itemID);
        	ItemStack var1 = this.CheckSmelt(this.furnaceItemStacks[0]);
            return var1 == null ? false : (this.furnaceItemStacks[2] == null ? true : (!this.furnaceItemStacks[2].isItemEqual(var1) ? false : (this.furnaceItemStacks[2].stackSize < this.getInventoryStackLimit() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize() ? true : this.furnaceItemStacks[2].stackSize < var1.getMaxStackSize())));
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = this.CheckSmelt(this.furnaceItemStacks[0]);

            if (this.furnaceItemStacks[2] == null)
            {
                this.furnaceItemStacks[2] = var1.copy();
            }
            else if (this.furnaceItemStacks[2].itemID == var1.itemID)
            {
                this.furnaceItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.furnaceItemStacks[0].getItem().hasContainerItem())
            {
                this.furnaceItemStacks[0] = new ItemStack(this.furnaceItemStacks[0].getItem().getContainerItem());
            }
            else
            {
                --this.furnaceItemStacks[0].stackSize;
            }

            if (this.furnaceItemStacks[0].stackSize <= 0)
            {
                this.furnaceItemStacks[0] = null;
            }
        }
    }

    private int getItemBurnTime(ItemStack var1)
    {
        if (var1 == null)
        {
            return 0;
        }
        else
        {
            int var2 = var1.getItem().itemID;
            return var2 == Fossil.relic.itemID ? 300 : 0;
        }
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    /*private ItemStack CheckSmelt(int var1)
    {
        return var1 == Fossil.brokenSword.itemID ? new ItemStack(Fossil.ancientSword) : (var1 == Fossil.brokenhelmet.itemID ? new ItemStack(Fossil.ancienthelmet) : (var1 == Fossil.gemAxe.itemID ? new ItemStack(Fossil.gemAxe) : (var1 == Fossil.gemPickaxe.itemID ? new ItemStack(Fossil.gemPickaxe) : (var1 == Fossil.gemSword.itemID ? new ItemStack(Fossil.gemSword) : (var1 == Fossil.gemHoe.itemID ? new ItemStack(Fossil.gemHoe) : (var1 == Fossil.gemShovel.itemID ? new ItemStack(Fossil.gemShovel) : null))))));
    }*/
    
    private ItemStack CheckSmelt(ItemStack var1)
    {
    	ItemStack n=null;
        if(var1.getItem().itemID == Fossil.brokenSword.itemID)return new ItemStack(Fossil.ancientSword);
        if(var1.getItem().itemID == Fossil.brokenhelmet.itemID)return new ItemStack(Fossil.ancienthelmet);
        
        if(var1.getItem().itemID == Fossil.gemAxe.itemID)n= new ItemStack(Fossil.gemAxe);
        if(var1.getItem().itemID == Fossil.gemPickaxe.itemID)n= new ItemStack(Fossil.gemPickaxe);
        if(var1.getItem().itemID == Fossil.gemSword.itemID)n= new ItemStack(Fossil.gemSword);
        if(var1.getItem().itemID == Fossil.gemHoe.itemID)n= new ItemStack(Fossil.gemHoe);
        if(var1.getItem().itemID == Fossil.gemShovel.itemID)n= new ItemStack(Fossil.gemShovel);
        if(n!=null)
        {
        	if(var1.getItemDamage()/var1.getMaxDamage()>=0.1F)
        		n.setItemDamage(var1.getItemDamage()-(int)(0.1*var1.getMaxDamage()));
        	else
        		n.setItemDamage(0);
        	return n;
        }
        if(var1.getItem().itemID == Fossil.woodjavelin.itemID)n=new ItemStack(Fossil.woodjavelin,1);
        if(var1.getItem().itemID == Fossil.stonejavelin.itemID)n=new ItemStack(Fossil.stonejavelin,1);
        if(var1.getItem().itemID == Fossil.ironjavelin.itemID)n=new ItemStack(Fossil.ironjavelin,1);
        if(var1.getItem().itemID == Fossil.goldjavelin.itemID)n=new ItemStack(Fossil.goldjavelin,1);
        if(var1.getItem().itemID == Fossil.diamondjavelin.itemID)n=new ItemStack(Fossil.diamondjavelin,1);
        if(n!=null)
        {
        	if(var1.getItemDamage()>5)
        		n.setItemDamage(var1.getItemDamage()-5);
        	else
        		n.setItemDamage(0);
        	return n;
        }
        if(var1.getItem().itemID == Fossil.ancientJavelin.itemID)
        {
        	n=new ItemStack(Fossil.ancientJavelin,1);
        	if(var1.getItemDamage()>3)
        		n.setItemDamage(var1.getItemDamage()-3);
        	else
        		n.setItemDamage(0);
        	return n;
        }
        return null;
    }
    private int timeToSmelt()
    {
    	if(this.furnaceItemStacks[0]==null)return 3000;
    	if(this.furnaceItemStacks[0].getItem().itemID==Fossil.ancientSword.itemID)return 3000;
    	if(this.furnaceItemStacks[0].getItem().itemID==Fossil.ancienthelmet.itemID)return 3000;
    	return 300;
    }

    public void openChest() {}

    public void closeChest() {}

    public int getSizeInventorySide(ForgeDirection var1)
    {
        return 1;
    }

    public int getStartInventorySide(ForgeDirection var1)
    {
        return var1 == ForgeDirection.DOWN ? 1 : (var1 == ForgeDirection.UP ? 0 : 2);
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int var1)
    {
        return null;
    }
}
