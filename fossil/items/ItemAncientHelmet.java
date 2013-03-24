package fossil.items;

import fossil.Fossil;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemAncientHelmet extends ItemArmor implements IArmorTextureProvider
{

	public ItemAncientHelmet(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) 
	{
		
          super(par1, par2EnumArmorMaterial, par3, par4);
          this.setCreativeTab(Fossil.tabFArmor);
 
    }
 
    public String getTextureFile()
	{
           return "/fossil/textures/Fos_items.png";
    }
 
    public String getArmorTextureFile(ItemStack par1)
    {
    	return "/fossil/armor/TextureAncientHelmet.png";
    }
	
}