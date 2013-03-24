package fossil.items;

import java.util.List;

import fossil.fossilEnums.EnumDinoType;
import fossil.items.forgeItems.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemDinoMeat extends ForgeItemFood
{
    //public static final int TypeCount = EnumDinoType.values().length;

    public ItemDinoMeat(int var1, int var2, float var3, boolean var4)
    {
        super(var1, var2, var3, var4);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 64;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int var1)
    {
        return 54;
    }

    /*public String getItemNameIS(ItemStack var1)
    {
        switch (ItemDinoMeat$1.$SwitchMap$mod$fossil$common$fossilEnums$EnumDinoType[this.GetTypeFromInt(var1.getItemDamage()).ordinal()])
        {
            case 1:
                return "Meattriceratops";

            case 2:
                return "MeatRaptor";

            case 3:
                return "MeatTRex";

            case 4:
                return "MeatPterosaur";

            case 5:
                return "MeatNautilus";

            case 6:
                return "MeatPlesiosaur";

            case 7:
                return "MeatMosasaurus";

            case 8:
                return "MeatStegosaurus";

            case 9:
                return "MeatUtahraptor";

            case 10:
                return "MeatBrachiosaurus";

            default:
                return "DinoMeat";
        }
    }*/

    //private EnumDinoType GetTypeFromInt(int var1)
    //{
    //    EnumDinoType[] var2 = EnumDinoType.values();
    //    return var2[var1];
    //}

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    /*public void getSubItems(int var1, CreativeTabs var2, List var3)
    {
        for (int var4 = 0; var4 < EnumDinoType.values().length; ++var4)
        {
            var3.add(new ItemStack(var1, 1, var4));
        }
    }*/
}
