package fossil.items;

import net.minecraft.item.Item;

public class ItemSkull extends Item
{
    public ItemSkull(int var1)
    {
        super(var1);
        this.maxStackSize = 64;
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }
}