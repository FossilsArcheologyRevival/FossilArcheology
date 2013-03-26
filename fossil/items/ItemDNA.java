package fossil.items;

import java.util.List;

import fossil.fossilEnums.EnumDinoType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDNA extends Item
{
    public static final int TypeCount = EnumDinoType.values().length;

    public ItemDNA(int var1)
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
    //    return var1 < TypeCount ? 6 + var1 : 0;
    //}

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }

    /*public int getItemName(ItemStack var1)
    {
        switch (itemID)
        {
            case 1:
                return Fossil.dnaTriceratops.itemID;

            case 2:
                return Fossil.dnaRaptor.itemID;

            case 3:
                return Fossil.dnaTRex.itemID;

            case 4:
                return Fossil.dnaPterosaur.itemID;

            case 5:
                return Fossil.dnaNautilus.itemID;

            case 6:
                return Fossil.dnaPlesiosaur.itemID;

            case 7:
                return Fossil.dnaMosasaurus.itemID;

            case 8:
                return Fossil.dnaStegosaurus.itemID;

            case 9:
                return Fossil.dnaUtahraptor.itemID;

            case 10:
                return Fossil.dnaBrachiosaurus.itemID;

            default:
                return Fossil.dna.itemID;
        }
    }*/

    /*private EnumDinoType GetTypeFromInt(int var1)
    {
        EnumDinoType[] var2 = EnumDinoType.values();
        return var2[var1];
    }*/

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
