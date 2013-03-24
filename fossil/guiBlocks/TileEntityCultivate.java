package fossil.guiBlocks;

import java.util.Random;

import fossil.Fossil;
import fossil.fossilEnums.EnumDinoType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityCultivate extends TileEntity implements IInventory, ISidedInventory
{
    private ItemStack[] cultivateItemStacks = new ItemStack[3];
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public int furnaceCookTime = 0;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.cultivateItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int var1)
    {
        return this.cultivateItemStacks[var1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int var1, int var2)
    {
        if (this.cultivateItemStacks[var1] != null)
        {
            ItemStack var3;

            if (this.cultivateItemStacks[var1].stackSize <= var2)
            {
                var3 = this.cultivateItemStacks[var1];
                this.cultivateItemStacks[var1] = null;
                return var3;
            }
            else
            {
                var3 = this.cultivateItemStacks[var1].splitStack(var2);

                if (this.cultivateItemStacks[var1].stackSize == 0)
                {
                    this.cultivateItemStacks[var1] = null;
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
        this.cultivateItemStacks[var1] = var2;

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
        return "Cultivate";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound var1)
    {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items");
        this.cultivateItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.cultivateItemStacks.length)
            {
                this.cultivateItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.furnaceBurnTime = var1.getShort("BurnTime");
        this.furnaceCookTime = var1.getShort("CookTime");
        this.currentItemBurnTime = this.getItemBurnTime(this.cultivateItemStacks[1]);
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

        for (int var3 = 0; var3 < this.cultivateItemStacks.length; ++var3)
        {
            if (this.cultivateItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.cultivateItemStacks[var3].writeToNBT(var4);
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
        return this.furnaceCookTime * var1 / 6000;
    }

    public int getBurnTimeRemainingScaled(int var1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 6000;
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
        boolean var1 = this.furnaceCookTime > 0;
        boolean var2 = false;

        if (this.furnaceBurnTime > 0)
        {
            --this.furnaceBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.furnaceBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.furnaceBurnTime = this.getItemBurnTime(this.cultivateItemStacks[1]);

                if (this.furnaceBurnTime > 0)
                {
                    var2 = true;

                    if (this.cultivateItemStacks[1] != null)
                    {
                        if (this.cultivateItemStacks[1].getItem().hasContainerItem())
                        {
                            this.cultivateItemStacks[1] = new ItemStack(this.cultivateItemStacks[1].getItem().getContainerItem());
                        }
                        else
                        {
                            --this.cultivateItemStacks[1].stackSize;
                        }

                        if (this.cultivateItemStacks[1].stackSize == 0)
                        {
                            this.cultivateItemStacks[1] = null;
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.furnaceCookTime;

                if (this.furnaceCookTime == 6000)
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else if (this.furnaceCookTime != 0 && !this.canSmelt())
            {
                this.furnaceCookTime = 0;
            }

            if (var1 != this.furnaceCookTime > 0)
            {
                var2 = true;
                BlockCultivate.updateFurnaceBlockState(this.furnaceCookTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }

        if (this.furnaceCookTime == 3001 && (new Random()).nextInt(100) < 20)
        {
            ((BlockCultivate)Fossil.blockcultivateIdle).onBlockRemovalLost(this.worldObj, this.xCoord, this.yCoord, this.zCoord, true);
        }
    }

    private boolean canSmelt()
    {
        if (this.cultivateItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = this.CheckSmelt(this.cultivateItemStacks[0]);
            return var1 == null ? false : (this.cultivateItemStacks[2] == null ? true : (!this.cultivateItemStacks[2].isItemEqual(var1) ? false : (this.cultivateItemStacks[2].stackSize < this.getInventoryStackLimit() && this.cultivateItemStacks[2].stackSize < this.cultivateItemStacks[2].getMaxStackSize() ? true : this.cultivateItemStacks[2].stackSize < var1.getMaxStackSize())));
        }
    }

    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = this.CheckSmelt(this.cultivateItemStacks[0]);

            if (this.cultivateItemStacks[2] == null)
            {
                this.cultivateItemStacks[2] = var1.copy();
            }
            else if (this.cultivateItemStacks[2].itemID == var1.itemID)
            {
                this.cultivateItemStacks[2].stackSize += var1.stackSize;
            }

            if (this.cultivateItemStacks[0].getItem().hasContainerItem())
            {
                this.cultivateItemStacks[0] = new ItemStack(this.cultivateItemStacks[0].getItem().getContainerItem());
            }
            else
            {
                --this.cultivateItemStacks[0].stackSize;
            }

            if (this.cultivateItemStacks[0].stackSize <= 0)
            {
                this.cultivateItemStacks[0] = null;
            }
        }
    }

    private int getItemBurnTime(ItemStack var1)
    {
        if (var1 != null)
        {
            int var2 = var1.getItem().itemID;
            if(var2 == Fossil.biofossil.itemID) return 300;
            if(var2 == Item.porkRaw.itemID)return 3000;
            if(var2 == Item.fishRaw.itemID)return 3000;
            if(var2 == Item.beefRaw.itemID)return 4000;
            if(var2 == Item.chickenRaw.itemID)return 1500;
            if(var2 == Item.egg.itemID)return 1000;
            if(var2 == Item.slimeBall.itemID)return 800;
            if(var2 == Item.bucketMilk.itemID)return 6000;
        }
        return 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer var1)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    private ItemStack CheckSmelt(int var1)
    {
        return null;
    }

    private ItemStack CheckSmelt(ItemStack var1)
    {
       /* if (var1.itemID == Fossil.dna.itemID)
        {
            return new ItemStack(Fossil.ancientegg, 1, var1.getItemDamage());
        }
        else if (var1.itemID == Fossil.animalDNA.itemID)
        {
            int var2 = var1.getItemDamage();
            return var2 != 3 ? new ItemStack(Fossil.embyoSyringe, 1, var2 > 3 ? var2 - 1 : var2) : new ItemStack(Item.egg, 1);
        }
        else
        {
            return null;
        }*/
    	if(var1.itemID==Fossil.dnaTriceratops.itemID)return new ItemStack(Fossil.eggTriceratops, 1);
    	if(var1.itemID==Fossil.dnaBrachiosaurus.itemID)return new ItemStack(Fossil.eggBrachiosaurus, 1);
    	if(var1.itemID==Fossil.dnaPlesiosaur.itemID)return new ItemStack(Fossil.eggPlesiosaur, 1);
    	if(var1.itemID==Fossil.dnaVelociraptor.itemID)return new ItemStack(Fossil.eggVelociraptor, 1);
    	if(var1.itemID==Fossil.dnaTRex.itemID)return new ItemStack(Fossil.eggTRex, 1);
    	if(var1.itemID==Fossil.dnaDilophosaurus.itemID)return new ItemStack(Fossil.eggDilophosaurus, 1);
    	if(var1.itemID==Fossil.dnaMosasaurus.itemID)return new ItemStack(Fossil.eggMosasaurus, 1);
    	if(var1.itemID==Fossil.dnaPterosaur.itemID)return new ItemStack(Fossil.eggPterosaur, 1);
    	if(var1.itemID==Fossil.dnaStegosaurus.itemID)return new ItemStack(Fossil.eggStegosaurus, 1);
    	if(var1.itemID==Fossil.dnaNautilus.itemID)return new ItemStack(Fossil.shellNautilus, 1);
    	if(var1.itemID==Fossil.brokenSapling.itemID)return new ItemStack(Fossil.palmSap, 1);
    	if(var1.itemID==Fossil.dnaSheep.itemID)return new ItemStack(Fossil.embryoSheep, 1);
    	if(var1.itemID==Fossil.dnaCow.itemID)return new ItemStack(Fossil.embryoCow, 1);
    	if(var1.itemID==Fossil.dnaChicken.itemID)return new ItemStack(Fossil.embryoChicken, 1);
    	if(var1.itemID==Fossil.dnaPig.itemID)return new ItemStack(Fossil.embryoPig, 1);
    	if(var1.itemID==Fossil.dnaSaberCat.itemID)return new ItemStack(Fossil.embryoSaberCat, 1);
    	if(var1.itemID==Fossil.dnaMammoth.itemID)return new ItemStack(Fossil.embryoMammoth, 1);
    	return null;
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
