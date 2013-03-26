package fossil.items;

import java.util.List;

import fossil.fossilEnums.EnumEmbryos;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemNonDinoDNA extends Item
{
    public static final int TypeCount = EnumEmbryos.values().length;

    public ItemNonDinoDNA(int var1)
    {
        super(var1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 64;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    //public int getIconFromDamage(int var1)
    //{
    //    return var1 < TypeCount ? 70 + var1 : 0;
    //}

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }

    /*public String getItemNameIS(ItemStack var1)
    {
        switch (ItemNonDinoDNA$1.$SwitchMap$mod_Fossil$EnumAnimalType[this.GetTypeFromInt(var1.getItemDamage()).ordinal()])
        {
            case 1:
                return "DNAPig";

            case 2:
                return "DNASheep";

            case 3:
                return "DNATCow";

            case 4:
                return "DNAChicken";

            case 5:
                return "DNASaberCat";

            default:
                return "AnimalDNA";
        }
    }*/

    /*private EnumEmbryos GetTypeFromInt(int var1)
    {
        EnumEmbryos[] var2 = EnumEmbryos.values();
        return var2[var1];
    }*/

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    /*public void getSubItems(int var1, CreativeTabs var2, List var3)
    {
        for (int var4 = 0; var4 < TypeCount; ++var4)
        {
            var3.add(new ItemStack(var1, 1, var4));
        }
    }*/
}
