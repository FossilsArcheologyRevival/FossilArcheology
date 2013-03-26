package fossil.fossilAI;

import java.util.Random;

import fossil.entity.mob.EntityDinosaurce;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;

public class DinoAIFishing extends EntityAIBase
{
    private EntityDinosaurce theEntity;
    //private final float huntLimit;
    private final int percentage;

    public DinoAIFishing(EntityDinosaurce var1/*, float var2*/, int var3)
    {
        this.theEntity = var1;
        this.setMutexBits(4);
        var1.getNavigator().setCanSwim(true);
        this.percentage = var3 > 100 ? 100 : (var3 < 0 ? 0 : var3);
        //this.huntLimit = var2;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return !this.nearbyGotWater() ? false : this.theEntity.IsHungry()/*(float)this.theEntity.getHunger() < this.huntLimit*/ && this.theEntity.getRNG().nextInt(100) < this.percentage;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        Random var1 = this.theEntity.getRNG();

        for (int var2 = 0; var2 <= var1.nextInt(3); ++var2)
        {
            EntityItem var3 = new EntityItem(this.theEntity.worldObj, this.theEntity.posX, this.theEntity.posY, this.theEntity.posZ, new ItemStack(Item.fishRaw));
            double var4 = (double)(var1.nextInt(5) - 2);
            double var6 = (double)(var1.nextInt(5) - 2);
            double var8 = (double)(var1.nextInt(5) - 2);
            double var10 = (double)MathHelper.sqrt_double(var4 * var4 + var6 * var6 + var8 * var8);
            double var12 = 0.1D;
            var3.motionX = var4 * var12;
            var3.motionY = var6 * var12 + (double)MathHelper.sqrt_double(var10) * 0.08D;
            var3.motionZ = var8 * var12;
            this.theEntity.worldObj.spawnEntityInWorld(var3);
        }
    }

    private boolean nearbyGotWater()
    {
        if (this.theEntity.isInWater())
        {
            return true;
        }
        else
        {
            AxisAlignedBB var1 = this.theEntity.boundingBox.expand(2.0D, 2.0D, 2.0D);
            return this.theEntity.worldObj.isAnyLiquid(var1);
        }
    }
}
