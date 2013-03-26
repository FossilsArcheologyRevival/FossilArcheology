package fossil.gens;

import java.util.Random;

import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenPalaeoraphe extends WorldGenerator
{
	
	public WorldGenPalaeoraphe()
    {
		
    }
	
    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
    	
    	int j1 = var1.getBlockId(var3, var4 - 1, var5);
		if(j1 != Block.grass.blockID && j1 != Block.dirt.blockID || var4 >= 128 - 12 - 1)
        {
        	return false;
        }
        //int deltaY = 5;
        int deltaY = var2.nextInt(6);
        for(int y=var4+1;y<=var4+10+deltaY;y++)
            var1.setBlockAndMetadata(var3, y, var5, Fossil.palmLog.blockID, 0);
            /*var1.setBlockAndMetadata(var3, var4 + 2, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 3, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 4, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 5, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 6, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 6, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 7, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 8, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 9, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 10, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 11, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 12, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 13, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5, Fossil.palmLog.blockID, 0);*/
		 var4=var4-5+deltaY;
            /*var1.setBlockAndMetadata(var3 + 1, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 2, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 3, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 4, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 5, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 + 1, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 + 2, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 + 3, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 + 4, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 13, var5 + 5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 1, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 2, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 3, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 4, var4 + 14, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 5, var4 + 13, var5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 - 1, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 - 2, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 - 3, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 - 4, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 13, var5 - 5, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 1, var4 + 14, var5 + 1, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 1, var4 + 14, var5 - 1, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 1, var4 + 14, var5 + 1, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 1, var4 + 14, var5 - 1, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 2, var4 + 14, var5 + 2, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 2, var4 + 14, var5 - 2, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 2, var4 + 14, var5 + 2, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 2, var4 + 14, var5 - 2, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 3, var4 + 13, var5 + 3, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 + 3, var4 + 13, var5 - 3, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 3, var4 + 13, var5 + 3, Fossil.palmLog.blockID, 0);
            var1.setBlockAndMetadata(var3 - 3, var4 + 13, var5 - 3, Fossil.palmLog.blockID, 0);*/
            
            var1.setBlockAndMetadata(var3, var4 + 16, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 1, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 2, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 3, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 4, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 5, var4 + 14, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 + 1, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 + 2, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 + 3, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 + 4, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 + 5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 1, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 2, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 3, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 4, var4 + 15, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 5, var4 + 14, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 - 1, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 - 2, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 - 3, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 15, var5 - 4, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 14, var5 - 5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 1, var4 + 15, var5 + 1, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 1, var4 + 15, var5 - 1, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 1, var4 + 15, var5 + 1, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 1, var4 + 15, var5 - 1, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 2, var4 + 15, var5 + 2, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 2, var4 + 15, var5 - 2, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 2, var4 + 15, var5 + 2, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 2, var4 + 15, var5 - 2, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 3, var4 + 14, var5 + 3, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 + 3, var4 + 14, var5 - 3, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 3, var4 + 14, var5 + 3, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 3, var4 + 14, var5 - 3, Fossil.palmLeaves.blockID, 0);
            
            /*var1.setBlockAndMetadata(var3 + 6, var4 + 14, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 13, var5 + 6, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3 - 6, var4 + 13, var5, Fossil.palmLeaves.blockID, 0);
            var1.setBlockAndMetadata(var3, var4 + 13, var5 - 6, Fossil.palmLeaves.blockID, 0);*/
            
            return true;
        }
    }
