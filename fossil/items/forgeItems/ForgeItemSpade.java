package fossil.items.forgeItems;

import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

public class ForgeItemSpade extends ItemSpade
{
    public ForgeItemSpade(int var1, EnumToolMaterial var2)
    {
        super(var1, var2);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }
}
