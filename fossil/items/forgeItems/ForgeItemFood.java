package fossil.items.forgeItems;

import fossil.Fossil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ForgeItemFood extends ItemFood
{
    public ForgeItemFood(int var1, int var2, float var3, boolean var4)
    {
        super(var1, var2, var3, var4);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }

    public ItemStack onFoodEaten(ItemStack var1, World var2, EntityPlayer var3)
    {
        if (var1.getItem().itemID == Fossil.chickenEss.itemID)
        {
            var3.inventory.addItemStackToInventory(new ItemStack(Item.glassBottle));
        }

        return super.onFoodEaten(var1, var2, var3);
    }
}
