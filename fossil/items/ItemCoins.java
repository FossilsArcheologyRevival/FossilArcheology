package fossil.items;

import fossil.fossilEnums.EnumCoinType;
import fossil.items.forgeItems.*;
import net.minecraft.item.ItemStack;

public class ItemCoins extends ForgeItem
{
    public static final int BASEICONLOC = 45;
    private EnumCoinType delfWorldType = null;

    protected ItemCoins(int var1, EnumCoinType var2)
    {
        super(var1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 64;
        this.delfWorldType = var2;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int var1)
    {
        return 45 + var1;
    }

    public String getItemNameIS(ItemStack var1)
    {
        return "coins";
    }

    public int getTargetDimension()
    {
        return this.delfWorldType.targetDimension;
    }
}
