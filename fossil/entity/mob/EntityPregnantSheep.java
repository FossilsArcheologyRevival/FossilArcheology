package fossil.entity.mob;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossil.Fossil;
import fossil.fossilEnums.EnumEmbryos;
import fossil.fossilInterface.IViviparous;
import fossil.guiBlocks.GuiPedia;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityPregnantSheep extends EntitySheep implements IViviparous, IEntityAdditionalSpawnData
{
    public int EmbryoProgress = 0;
    //public final int EmbryoGrowTime = 3000;
    public EnumEmbryos Embryo = null;
    //public String InsideText = "Embyo inside:";
    //spublic String GrowingText = "Growing progress:";

    public EntityPregnantSheep(World var1)
    {
        super(var1);
    }
    private void setPedia()
    {Fossil.ToPedia = (Object)this;}

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound var1)
    {
        super.writeEntityToNBT(var1);
        var1.setInteger("EmbryoProgress", this.EmbryoProgress);
        var1.setByte("Inside", (byte)this.Embryo.ordinal());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound var1)
    {
        super.readEntityFromNBT(var1);
        this.EmbryoProgress = var1.getInteger("EmbryoProgress");
        if (var1.hasKey("Inside"))
            this.Embryo = EnumEmbryos.values()[var1.getByte("Inside")];
    }

    public void SetEmbryo(EnumEmbryos var1)
    {
        this.Embryo = var1;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer var1)
    {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (FMLCommonHandler.instance().getSide().isClient() && var2 != null && var2.itemID == Fossil.dinoPedia.itemID)
        {
        	this.setPedia();
        	var1.openGui(Fossil.instance, 4, this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ);
            return true;
        }
        return super.interact(var1);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        EntitySheep var1 = new EntitySheep(this.worldObj);

        if (this.Embryo == null)
        {
            this.setDead();
            this.worldObj.spawnEntityInWorld(var1);
        }

        ++this.EmbryoProgress;
        //int var10000 = this.EmbryoProgress;
        this.getClass();

        if (this.EmbryoProgress==this.Embryo.GrowTime)//var10000 == 3000)
        {
            ((EntitySheep)var1).setFleeceColor(this.getFleeceColor());
            ((EntitySheep)var1).setSheared(this.getSheared());
            Object var2;

            switch (this.Embryo)//EntityPregnantSheep$1.$SwitchMap$mod_Fossil$EnumEmbyos[this.Embyos.ordinal()])
            {
                case Pig:
                    var2 = new EntityPig(this.worldObj);
                    break;

                case Sheep:
                    var2 = new EntitySheep(this.worldObj);
                    break;

                case Cow:
                    var2 = new EntityCow(this.worldObj);
                    break;
                    
                case Chicken:
                    var2 = new EntityChicken(this.worldObj);
                    break;

                case SaberCat:
                    var2 = new EntitySaberCat(this.worldObj);
                    break;

                case Mammoth:
                    var2 = (new EntityMammoth(this.worldObj)).Imprinting(this.posX, this.posY, this.posZ);
                    break;

                default:
                    var2 = new EntityPig(this.worldObj);
            }

            ((EntityAnimal)var2).setGrowingAge(-24000);
            ((EntityAnimal)var2).setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            var1.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);

            for (int var3 = 0; var3 < 7; ++var3)
            {
                double var4 = this.rand.nextGaussian() * 0.02D;
                double var6 = this.rand.nextGaussian() * 0.02D;
                double var8 = this.rand.nextGaussian() * 0.02D;
                this.worldObj.spawnParticle("heart", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var4, var6, var8);
            }

            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.worldObj.spawnEntityInWorld((Entity)var2);
                this.worldObj.spawnEntityInWorld(var1);
            }
        }
        else
        {
            super.onLivingUpdate();
        }
    }
    @SideOnly(Side.CLIENT)
    public void ShowPedia(GuiPedia p0)
    {
    	int quot = (int)Math.floor(((float)this.EmbryoProgress / (float)this.Embryo.GrowTime * 100.0F));
    	p0.reset();
    	p0.AddStringLR(Fossil.GetLangTextByKey("PediaText.Embryo.inside"),false);
    	p0.AddStringLR(Fossil.GetLangTextByKey("PediaText.Embryo."+this.Embryo.toString()),false);
    	p0.AddStringLR(Fossil.GetLangTextByKey("PediaText.Embryo.growing"),false);
    	p0.AddStringLR(String.valueOf(quot) + "/100", false);
    	
    	
        /*String var2 = "";
        this.UpdatePediaText();
        int var3 = (int)Math.floor((double)((float)this.EmbyoProgress / 3000.0F * 100.0F));
        Fossil.ShowMessage(this.InsideText + Fossil.GetEmbyoName(this.Embyos), var1);
        Fossil.ShowMessage(this.GrowingText + var3 + "%", var1);*/
    }

    public EntityAnimal spawnBabyAnimal(EntityAnimal var1)
    {
        return null;
    }

    /*public void UpdatePediaText()
    {
        String var1 = "PediaText.vivi.";
        this.InsideText = Fossil.GetLangTextByKey("PediaText.vivi.inside");
        this.GrowingText = Fossil.GetLangTextByKey("PediaText.vivi.growing");
    }*/

    public void writeSpawnData(ByteArrayDataOutput var1)
    {
        var1.writeInt(this.Embryo.ordinal());
    }

    public void readSpawnData(ByteArrayDataInput var1)
    {
        this.Embryo = EnumEmbryos.values()[var1.readInt()];
    }
}
