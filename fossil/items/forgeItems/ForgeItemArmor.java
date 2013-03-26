package fossil.items.forgeItems;

import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ForgeItemArmor extends ItemArmor
{
    public ForgeItemArmor(int var1, EnumArmorMaterial var2, int var3, int var4)
    {
        super(var1, var2, var3, var4);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }
}
