package fossil.items;

import net.minecraft.item.Item;

public class ItemBrokenSword extends Item
{
    public ItemBrokenSword(int var1)
    {
        super(var1);
        this.maxStackSize = 1;
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }
}
