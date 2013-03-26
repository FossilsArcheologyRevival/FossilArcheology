package fossil.items;

import java.util.Iterator;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import fossil.Fossil;
import fossil.entity.EntityDinoEgg;
import fossil.entity.mob.EntityNautilus;
import fossil.fossilEnums.EnumDinoType;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemAncientEgg extends Item
{
    public static final int TypeCount = EnumDinoType.values().length;

    public ItemAncientEgg(int var1)
    {
        super(var1);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.maxStackSize = 1;
    }

    public String getTextureFile()
    {
        return "/fossil/textures/Fos_items.png";
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    /*public int getIconFromDamage(int var1)
    {
        return var1 < TypeCount ? 22 + var1 : 0;
    }*/

    /*public String getItemNameIS(ItemStack var1)
    {
        switch (ItemAncientEgg$1.$SwitchMap$mod_Fossil$EnumDinoType[this.GetTypeFromInt(var1.getItemDamage()).ordinal()])
        {
            case 1:
                return "Eggtriceratops";

            case 2:
                return "EggRaptor";

            case 3:
                return "EggTRex";

            case 4:
                return "EggPterosaur";

            case 5:
                return "ShellNautilus";

            case 6:
                return "EggPlesiosaur";

            case 7:
                return "EggMosasaurus";

            case 8:
                return "EggStegosaurus";

            case 9:
                return "EggUtahraptor";

            case 10:
                return "EggBrachiosaurus";

            default:
                return "Ancient egg";
        }
    }*/

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3)
    {
        float var4 = 1.0F;
        float var5 = var3.prevRotationPitch + (var3.rotationPitch - var3.prevRotationPitch) * var4;
        float var6 = var3.prevRotationYaw + (var3.rotationYaw - var3.prevRotationYaw) * var4;
        double var7 = var3.prevPosX + (var3.posX - var3.prevPosX) * (double)var4;
        double var9 = var3.prevPosY + (var3.posY - var3.prevPosY) * (double)var4 + 1.62D - (double)var3.yOffset;
        double var11 = var3.prevPosZ + (var3.posZ - var3.prevPosZ) * (double)var4;
        Vec3 var13 = var2.getWorldVec3Pool().getVecFromPool(var7, var9, var11);
        float var14 = MathHelper.cos(-var6 * 0.017453292F - (float)Math.PI);
        float var15 = MathHelper.sin(-var6 * 0.017453292F - (float)Math.PI);
        float var16 = -MathHelper.cos(-var5 * 0.017453292F);
        float var17 = MathHelper.sin(-var5 * 0.017453292F);
        float var18 = var15 * var16;
        float var19 = var14 * var16;
        double var20 = 5.0D;
        Vec3 var22 = var13.addVector((double)var18 * var20, (double)var17 * var20, (double)var19 * var20);
        MovingObjectPosition var23 = var2.rayTraceBlocks_do(var13, var22, true);

        if (var23 == null)
        {
            return var1;
        }
        else
        {
            Vec3 var24 = var3.getLook(var4);
            boolean var25 = false;
            float var26 = 1.0F;
            List var27 = var2.getEntitiesWithinAABBExcludingEntity(var3, var3.boundingBox.addCoord(var24.xCoord * var20, var24.yCoord * var20, var24.zCoord * var20).expand((double)var26, (double)var26, (double)var26));
            Iterator var28 = var27.iterator();

            while (var28.hasNext())
            {
                Entity var29 = (Entity)var28.next();

                if (var29.canBeCollidedWith())
                {
                    float var30 = var29.getCollisionBorderSize();
                    AxisAlignedBB var31 = var29.boundingBox.expand((double)var30, (double)var30, (double)var30);

                    if (var31.isVecInside(var13))
                    {
                        var25 = true;
                    }
                }
            }

            if (var25)
            {
                return var1;
            }
            else
            {
                if (var23.typeOfHit == EnumMovingObjectType.TILE)
                {
                    int var34 = var23.blockX;
                    int var32 = var23.blockY;
                    int var33 = var23.blockZ;

                    if (!var2.isRemote)
                    {
                        if (var2.getBlockId(var34, var32, var33) == Block.snow.blockID)
                        {
                            --var32;
                        }
                        EnumDinoType i=this.GetTypeFromInt(/*var1.itemID*/var3.inventory.getCurrentItem().itemID);
                        if (!spawnCreature(var2, i, (double)((float)var34 + 0.5F), (double)((float)var32 + 1.0F), (double)((float)var33 + 0.5F)))
                        {
                            return var1;
                        }
                    }

                    if (!var3.capabilities.isCreativeMode)
                    {
                        --var1.stackSize;
                    }
                }

                return var1;
            }
        }
    }

    public static boolean spawnCreature(World var0, EnumDinoType var1, double var2, double var4, double var6)
    {
        Object var8;

        if (var1 == EnumDinoType.Nautilus)
        {
            var8 = new EntityNautilus(var0);
            System.out.println("WRONG");
        }
        else
        {
            var8 = new EntityDinoEgg(var0, var1);
        }

        if (var8 != null)
        {
            ((Entity)var8).setLocationAndAngles(var2, var4, var6, var0.rand.nextFloat() * 360.0F, 0.0F);
            var0.spawnEntityInWorld((Entity)var8);
        }

        return var8 != null;
    }

    private EnumDinoType GetTypeFromInt(int var1)
    {
    	if(var1==Fossil.eggTriceratops.itemID)return EnumDinoType.Triceratops;
    	if(var1==Fossil.eggBrachiosaurus.itemID)return EnumDinoType.Brachiosaurus;
    	if(var1==Fossil.eggPlesiosaur.itemID)return EnumDinoType.Plesiosaur;
    	if(var1==Fossil.eggVelociraptor.itemID)return EnumDinoType.Velociraptor;
    	if(var1==Fossil.eggTRex.itemID)return EnumDinoType.TRex;
    	if(var1==Fossil.eggDilophosaurus.itemID)return EnumDinoType.Dilophosaurus;
    	if(var1==Fossil.eggMosasaurus.itemID)return EnumDinoType.Mosasaurus;
    	if(var1==Fossil.eggPterosaur.itemID)return EnumDinoType.Pterosaur;
    	if(var1==Fossil.eggStegosaurus.itemID)return EnumDinoType.Stegosaurus;
    	if(var1==Fossil.shellNautilus.itemID)return EnumDinoType.Nautilus;
    	System.out.println("FAULT!!!!:Dinotype " + String.valueOf(var1)+ " does not exist!");
    	return EnumDinoType.Triceratops;
    }

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
