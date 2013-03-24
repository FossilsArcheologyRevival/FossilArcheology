package fossil.blocks;

import java.util.ArrayList;

import fossil.client.FossilOptions;
import fossil.entity.mob.EntityDinosaurce;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockBreakingRule
{
    World worldObj = null;
    EntityDinosaurce destroyer = null;
    int ageLimit;
    Block[] targetBlocks = null;

    public BlockBreakingRule(World var1, EntityDinosaurce var2, int var3, Block[] var4)
    {
        this.worldObj = var1;
        this.destroyer = var2;
        this.ageLimit = var3;
        this.targetBlocks = var4;
    }

    public BlockBreakingRule(World var1, EntityDinosaurce var2, int var3, float var4)
    {
        ArrayList var5 = new ArrayList();
        Block[] var6 = Block.blocksList;

        if (var6 != null)
        {
            int var7;

            for (var7 = 0; var7 < var6.length; ++var7)
            {
                if (var6[var7] != null && var6[var7].getBlockHardness(var1, 0, 0, 0) < var4)
                {
                    var5.add(var6[var7]);
                }
            }

            this.targetBlocks = new Block[var5.size()];

            for (var7 = 0; var7 < var5.size(); ++var7)
            {
                this.targetBlocks[var7] = (Block)var5.get(var7);
            }
        }
        else
        {
            this.targetBlocks = new Block[0];
        }

        this.worldObj = var1;
        this.destroyer = var2;
        this.ageLimit = var3;
    }

    public void execute()
    {
        if (FossilOptions.TRexBreakingBlocks)
        {
            if (this.destroyer.getDinoAge() >= this.ageLimit)
            {
                for (int var1 = (int)Math.round(this.destroyer.boundingBox.minX) - 1; var1 <= (int)Math.round(this.destroyer.boundingBox.maxX) + 1; ++var1)
                {
                    for (int var2 = (int)Math.round(this.destroyer.boundingBox.minY); var2 <= (int)Math.round(this.destroyer.boundingBox.maxY) + 2 && var2 <= 127; ++var2)
                    {
                        for (int var3 = (int)Math.round(this.destroyer.boundingBox.minZ) - 1; var3 <= (int)Math.round(this.destroyer.boundingBox.maxZ) + 1; ++var3)
                        {
                            if (var2 < 0)
                            {
                                return;
                            }

                            if ((double)var2 >= this.destroyer.posY)
                            {
                                int var4 = this.worldObj.getBlockId(var1, var2, var3);

                                for (int var5 = 0; var5 < this.targetBlocks.length; ++var5)
                                {
                                    if (this.targetBlocks[var5] == Block.blocksList[var4])
                                    {
                                        this.worldObj.playAuxSFX(2001, var1, var2, var3, var4);
                                        this.worldObj.setBlockWithNotify(var1, var2, var3, 0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
