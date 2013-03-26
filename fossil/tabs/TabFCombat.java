package fossil.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossil.Fossil;
import net.minecraft.creativetab.CreativeTabs;

public class TabFCombat extends CreativeTabs 
{

	public TabFCombat(int par1, String par2Str)
    {
            super(par1, par2Str);
    }
    
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
       return Fossil.ancienthelmet.itemID;
    }
    
    public String getTranslatedTabLabel()
    {
     return Fossil.GetLangTextByKey("Tab.Combat.Name");
    }
	
}
