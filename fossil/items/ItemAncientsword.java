package fossil.items;

import java.util.Random;

import fossil.Fossil;
import fossil.entity.EntityMLighting;
import fossil.entity.mob.EntityFriendlyPigZombie;
import fossil.fossilEnums.EnumPigmenSpeaks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemAncientsword extends ItemSword
{
    public ItemAncientsword(int var1, EnumToolMaterial var2)
    {
        super(var1, var2);
        this.maxStackSize = 1;
    }

    public ItemAncientsword(int var1)
    {
        this(var1, EnumToolMaterial.IRON);
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }

    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity var1)
    {
        if (var1 != null && var1.worldObj.difficultySetting > 0 && (var1 instanceof EntityPig || var1 instanceof EntityPigZombie))
        {
            EntityPlayer var2 = this.SearchUser(var1);

            if (var2 != null && this.checkHelmet(var2) && !var1.worldObj.isRemote)
            {
                EntityFriendlyPigZombie var3 = new EntityFriendlyPigZombie(var1.worldObj);
                var3.LeaderName = var2.username;
                var3.setLocationAndAngles(var1.posX, var1.posY, var1.posZ, var1.rotationYaw, var1.rotationPitch);
                var1.setDead();
                var1.worldObj.spawnEntityInWorld(var3);
                var3.Mouth.SendSpeech(EnumPigmenSpeaks.LifeFor, var3.LeaderName);
            }
        }
        if((new Random()).nextInt(100)<15)
        	var1.worldObj.addWeatherEffect(new EntityMLighting(var1.worldObj, var1.posX, var1.posY, var1.posZ));
        return 4 + EnumToolMaterial.IRON.getDamageVsEntity() * 2;
    }

    private EntityPlayer SearchUser(Entity var1)
    {
        EntityPlayer var2 = (EntityPlayer)var1.worldObj.findNearestEntityWithinAABB(EntityPlayer.class, var1.boundingBox.expand(6.0D, 6.0D, 6.0D), var1);
        return var2 == null ? null : var2;
    }

    private boolean checkHelmet(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.armorInventory[3];
        return var2 == null ? false : var2.itemID == Fossil.ancienthelmet.itemID;
    }
}
