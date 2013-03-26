package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilEnums.EnumDinoEating;
import fossil.guiBlocks.TileEntityFeeder;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class DinoAIUseFeeder extends EntityAIBase
{
    protected EntityDinosaurce entityVar;
    private double destX;
    private double destY;
    private double destZ;
    private float field_48317_e;
    protected final int SEARCH_RANGE;
    //private final float HUNT_LIMIT;
    private final int USE_RANGE = 3;
    protected TileEntityFeeder targetFeeder = null;
    protected EnumDinoEating eating;

    public DinoAIUseFeeder(EntityDinosaurce var1, float var2, int var3/*, float var4*/, EnumDinoEating var5)
    {
        this.entityVar = var1;
        this.field_48317_e = var2;
        this.setMutexBits(1);
        this.SEARCH_RANGE = var3;
        //this.HUNT_LIMIT = var4;
        this.eating = var5;
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.entityVar.IsHungry())//(float)this.entityVar.getHunger() > this.HUNT_LIMIT)
        {
            Vec3 var1 = this.GetNearestFeeder();

            if (var1 != null)
            {
                this.destX = var1.xCoord;
                this.destY = var1.yCoord;
                this.destZ = var1.zCoord;
                return true;
            }
        }
        return false;
    }

    protected Vec3 GetNearestFeeder()
    {
        World var1 = this.entityVar.worldObj;
        Vec3 var2 = null;
        double var3 = this.entityVar.posX;
        double var5 = this.entityVar.posY;
        double var7 = this.entityVar.posZ;
        int var9 = this.SEARCH_RANGE / 2;
        double var10 = 0.0D;
        double var12 = (double)(this.SEARCH_RANGE * this.SEARCH_RANGE * 2);

        for (int var15 = (int)(var3 - (double)this.SEARCH_RANGE); var15 < (int)(var3 + (double)this.SEARCH_RANGE); ++var15)
        {
            for (int var16 = (int)(var5 - (double)var9); var16 < (int)(var5 + (double)var9); ++var16)
            {
                for (int var17 = (int)(var7 - (double)this.SEARCH_RANGE); var17 < (int)(var7 + (double)this.SEARCH_RANGE); ++var17)
                {
                    if (var16 >= 0 && var16 <= var1.getHeight())
                    {
                        TileEntity var14 = var1.getBlockTileEntity(var15, var16, var17);

                        if (var14 != null && var14 instanceof TileEntityFeeder && ((TileEntityFeeder)var14).isFilled())
                        {
                            var10 = ((double)var15 - var3) * ((double)var15 - var3) + ((double)var17 - var7) * ((double)var17 - var7);

                            if (var10 < var12)
                            {
                                var12 = var10;
                                this.targetFeeder = (TileEntityFeeder)var14;
                                var2 = Vec3.createVectorHelper((double)var15, (double)var16, (double)var17);
                            }
                        }
                    }
                }
            }
        }

        return var2;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entityVar.getNavigator().noPath() && !this.targetFeeder.isInvalid();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        double var10000 = Math.pow(this.entityVar.posX - this.destX, 2.0D) + Math.pow(this.entityVar.posZ - this.destZ, 2.0D);
        //this.getClass();

        if (var10000 < Math.pow(3.0D, 2.0D))
        	/*TileEntity var14 = var1.getBlockTileEntity(var15, var16, var17);

                        if (var14 != null && var14 instanceof TileEntityFeeder && ((TileEntityFeeder)var14).isFilled())*/
        {
            this.targetFeeder.Feed(this.entityVar, this.eating);

            if (!this.entityVar.IsHungry())//(float)this.entityVar.getHunger() > this.HUNT_LIMIT)
            {
                this.entityVar.getNavigator().clearPathEntity();
            }
        }
        else
        {
            this.entityVar.getNavigator().tryMoveToXYZ(this.destX, this.destY, this.destZ, this.field_48317_e);
        }
    }
}
