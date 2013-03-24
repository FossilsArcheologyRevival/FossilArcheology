package fossil.items;

import fossil.Fossil;
import fossil.entity.EntityAncientJavelin;
import fossil.entity.EntityJavelin;
import fossil.items.forgeItems.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemJavelin extends ForgeItem
{
    public EnumToolMaterial SelfMaterial;
    //private boolean isAncient = false;

    public ItemJavelin(int var1, EnumToolMaterial var2)
    {
        super(var1);
        this.maxStackSize=16;
        this.setMaxDamage(30);
        //this.iconIndex = 48;
        this.hasSubtypes = false;
        this.SelfMaterial = var2;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    /*public int getIconFromDamage(int var1)
    {
        return this.SelfMaterial == EnumToolMaterial.GOLD ? 52 : (this.SelfMaterial == EnumToolMaterial.EMERALD ? 51 : (this.isAncient ? 64 : this.SelfMaterial.getHarvestLevel() + 48));
    }*/

    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack var1, World var2, EntityPlayer var3, int var4)
    {
        boolean var5 = EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, var1) > 0;

        if (var5 || var3.inventory.hasItem(this.itemID))
        {
            int var6 = this.getMaxItemUseDuration(var1) - var4;
            float var7 = (float)var6 / 20.0F;
            var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;

            if ((double)var7 < 0.1D)
            {
                return;
            }

            if (var7 > 1.0F)
            {
                var7 = 1.0F;
            }

            Object var8;

            if (this.itemID!=Fossil.ancientJavelin.itemID)//!this.isAncient)
            {
                var8 = new EntityJavelin(var2, var3, var7 * 2.0F, this.SelfMaterial,var1.getItemDamage()+1);
            }
            else
            {
                var8 = new EntityAncientJavelin(var2, var3, var7 * 2.0F, this.SelfMaterial,var1.getItemDamage()+1);
            }

            if (var7 == 1.0F)
            {
                ((EntityJavelin)var8).arrowCritical = true;
            }

            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, var1);

            if (var9 > 0)
            {
                ((EntityJavelin)var8).setDamage(((EntityJavelin)var8).getDamage() + (double)var9 * 0.5D + 0.5D);
            }

            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, var1);

            if (var10 > 0)
            {
                ((EntityJavelin)var8).setKnockbackStrength(var10);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, var1) > 0)
            {
                ((EntityJavelin)var8).setFire(100);
            }

            var2.playSoundAtEntity(var3, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);

            if (!var5)
            {
                var3.inventory.consumeInventoryItem(this.itemID);
            }
            else
            {
                ((EntityJavelin)var8).canBePickedUp = 2;
            }

            if (!var2.isRemote)
            {
                var2.spawnEntityInWorld((Entity)var8);
            }
        }
    }

    public ItemStack onFoodEaten(ItemStack var1, World var2, EntityPlayer var3)
    {
        return var1;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack var1)
    {
        return 720000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack var1)
    {
        return EnumAction.bow;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        if (var3.capabilities.isCreativeMode || var3.inventory.hasItem(this.itemID))
        {
            var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
        }

        return var1;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }

    /*public boolean isAncient()
    {
        return this.isAncient;
    }

    public Item setAncient(boolean var1)
    {
        this.isAncient = var1;
        return this;
    }*/
}
