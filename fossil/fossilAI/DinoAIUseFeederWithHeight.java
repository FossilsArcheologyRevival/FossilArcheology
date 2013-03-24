package fossil.fossilAI;

import fossil.entity.mob.EntityDinosaurce;
import fossil.fossilEnums.EnumDinoEating;
import fossil.guiBlocks.TileEntityFeeder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class DinoAIUseFeederWithHeight extends DinoAIUseFeeder
{
    private float ownerHeight;

    public DinoAIUseFeederWithHeight(EntityDinosaurce var1, float var2, int var3)//, float var4)
    {
        super(var1, var2, var3,/* var4,*/ EnumDinoEating.Herbivorous);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        this.ownerHeight = this.entityVar.getEyeHeight();
        return super.shouldExecute();
    }

    protected Vec3 GetNearestFeeder()
    {
        World var1 = this.entityVar.worldObj;
        Vec3 var2 = null;
        double var3 = this.entityVar.posX;
        double var5 = this.entityVar.posY;
        double var7 = this.entityVar.posZ;
        boolean var9 = true;
        double var10 = 0.0D;
        double var12 = (double)(this.SEARCH_RANGE * this.SEARCH_RANGE * 2);

        for (int var15 = (int)(var3 - (double)this.SEARCH_RANGE); var15 < (int)(var3 + (double)this.SEARCH_RANGE); ++var15)
        {
            for (int var16 = (int)(var5 + (double)this.ownerHeight - 2.0D); var16 < (int)(var5 + (double)this.ownerHeight + 2.0D); ++var16)
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
}
