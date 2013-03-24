package fossil.items;

import fossil.Fossil;
import fossil.entity.EntityStoneboard;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.world.World;

public class ItemStoneBoard extends Item
{
    public ItemStoneBoard(int var1)
    {
        super(var1);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }

    public boolean onItemUse(ItemStack var1, EntityPlayer var2, World var3, int var4, int var5, int var6, int var7, float var8, float var9, float var10)
    {
        if (var7 == 0)
        {
            return false;
        }
        else if (var7 == 1)
        {
            return false;
        }
        else
        {
            int var11 = Direction.vineGrowth[var7];
            EntityStoneboard var12 = new EntityStoneboard(var3, var4, var5, var6, var11);

            if (!var2.canPlayerEdit(var4, var5, var6, var7, var1))
            {
                return false;
            }
            else
            {
                if (var12 != null && var12.onValidSurface())
                {
                    if (!var3.isRemote)
                    {
                        var3.spawnEntityInWorld(var12);
                    }
                    --var1.stackSize;
                }
                return true;
            }
        }
    }
}
