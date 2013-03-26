package fossil.items;

import net.minecraft.item.Item;

public class ItemBrokenHelmet extends Item
{
    public ItemBrokenHelmet(int var1)
    {
        super(var1);
        this.maxStackSize = 1;
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }
}
