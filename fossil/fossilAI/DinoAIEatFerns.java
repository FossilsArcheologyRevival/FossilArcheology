package fossil.fossilAI;

import fossil.Fossil;
import fossil.entity.mob.EntityDinosaurce;
import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DinoAIEatFerns extends EntityAIBase
{
    protected EntityDinosaurce entityVar;
    protected World worldObj;
    int eatTick = 0;
    //final float HUNT_LIMIT;

    public DinoAIEatFerns(EntityDinosaurce var1/*, float var2*/)
    {
        this.entityVar = var1;
        this.worldObj = var1.worldObj;
        this.setMutexBits(7);
        //this.HUNT_LIMIT = var2;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entityVar.IsHungry()/*(float)this.entityVar.getHunger() >= this.HUNT_LIMIT*/)
        {
            int var1 = MathHelper.floor_double(this.entityVar.posX);
            int var2 = MathHelper.floor_double(this.entityVar.posY);
            int var3 = MathHelper.floor_double(this.entityVar.posZ);
            return this.worldObj.getBlockId(var1, var2, var3) == Fossil.ferns.blockID;
        }
        return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.eatTick = 40;
        this.worldObj.setEntityState(this.entityVar, (byte)10);
        this.entityVar.getNavigator().clearPathEntity();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.eatTick = 0;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return this.eatTick > 0;
    }

    public int func_48396_h()
    {
        return this.eatTick;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.eatTick = Math.max(0, this.eatTick - 1);

        if (this.eatTick == 4)
        {
            int var1 = MathHelper.floor_double(this.entityVar.posX);
            int var2 = MathHelper.floor_double(this.entityVar.posY);
            int var3 = MathHelper.floor_double(this.entityVar.posZ);

            if (this.worldObj.getBlockId(var1, var2, var3) == Fossil.ferns.blockID)
            {
                this.worldObj.playAuxSFX(2001, var1, var2, var3, Block.tallGrass.blockID + 4096);
                this.worldObj.setBlockWithNotify(var1, var2, var3, 0);
                this.entityVar.increaseHunger(25);
            }
        }
    }
}
