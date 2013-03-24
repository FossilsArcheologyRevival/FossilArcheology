package fossil.entity;

import java.util.Random;

import fossil.Fossil;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityAncientJavelin extends EntityJavelin
{
    private boolean lighteningShot = false;
    private int damaged;

    public EntityAncientJavelin(World var1)
    {
        super(var1);
    }

    public EntityAncientJavelin(World var1, double var2, double var4, double var6)
    {
        super(var1, var2, var4, var6);
    }

    public EntityAncientJavelin(World var1, EntityLiving var2, float var3, EnumToolMaterial var4, int damagevalue)
    {
        super(var1, var2, var3);
        this.SelfMaterial = var4;
        this.damaged=damagevalue;
    }

    public EntityAncientJavelin(World var1, EntityLiving var2, float var3)
    {
        super(var1, var2, var3);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setBoolean("lighteningShot", this.lighteningShot);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);

        if (var1.hasKey("lighteningShot"))
        {
            this.lighteningShot = var1.getBoolean("lighteningShot");
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        if (this.inGround && !this.lighteningShot)
        {
        	if((new Random()).nextInt(100)<30)
        		this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, this.posX, this.posY, this.posZ));
            this.lighteningShot = true;
        }
    }

    protected boolean addJavelinToPlayer(EntityPlayer var1)
    {
        ItemStack var2 = new ItemStack(Fossil.ancientJavelin, 1);
        var2.setItemDamage(damaged);
        return var1.inventory.addItemStackToInventory(var2);
    }
}
