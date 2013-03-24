package fossil.items;

import net.minecraft.item.Item;

public class ItemRelic extends Item
{
    public ItemRelic(int var1)
    {
        super(var1);
        this.maxStackSize = 64;
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }
}
