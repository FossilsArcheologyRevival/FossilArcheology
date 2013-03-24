package fossil.items.forgeItems;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

public class ForgeItemSword extends ItemSword
{
    public ForgeItemSword(int var1, EnumToolMaterial var2)
    {
        super(var1, var2);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }
}
