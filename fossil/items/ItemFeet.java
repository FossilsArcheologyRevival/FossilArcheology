package fossil.items;

import fossil.Fossil;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemFeet extends ItemArmor implements IArmorTextureProvider
{

	public ItemFeet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		
          super(par1, par2EnumArmorMaterial, par3, par4);
          //this.setCreativeTab(Fossil.tabFArmor);
 
    }
 
    public String getTextureFile()
	{
           return "/fossil/textures/Fos_items.png";
    }
 
    public String getArmorTextureFile(ItemStack par1)
    {
        if ( par1.itemID == Fossil.skullHelmet.itemID|| par1.itemID == Fossil.ribCage.itemID|| par1.itemID == Fossil.feet.itemID)
        {
              return "/fossil/armor/bone_1.png";
        }
        if(par1.itemID == Fossil.femurs.itemID)
		{
              return "/fossil/armor/bone_2.png";
        }
			  return "/fossil/armor/bone_2.png";
    }
	
}