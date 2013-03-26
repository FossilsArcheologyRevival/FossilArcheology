package fossil.gens;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenShips implements IWorldGenerator
{
	
    @Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch (world.provider.dimensionId)
		  {
		   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
		   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
		  }		
	}
    
    private void generateSurface(World world, Random random, int blockX, int blockZ) 
    {
    	BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(blockX, blockZ);
    	WorldGeneratorBigShip bigship = new WorldGeneratorBigShip();
    	if(biome instanceof BiomeGenOcean)
   	 	{
    		
    		if (random.nextInt(50)==0)
    		{
    			int var6 = blockX + random.nextInt(128);
    			int var7 = blockZ + random.nextInt(128);
    			int var8 = world.getHeightValue(var6, var7);

    			if (random.nextInt(100) == 0 && (world.getBlockId(var6, var8 - 4, var7) == Block.waterStill.blockID)) //|| world.getBlockId(var6, var8 - 1, var7) == 2 || world.getBlockId(var6, var8 - 1, var7) == Block.sand.blockID))
    			{
    				bigship.generate(world, random, var6, var8, var7);
    			}
    		}
    		
   	 	}
    	
    	WorldGeneratorCheheWreck chehewreck = new WorldGeneratorCheheWreck();
    	if(biome instanceof BiomeGenRiver)
   	 	{
    		if(random.nextInt(20) == 0) //adjust the number in nextInt(). Higher values == rarer.
			{
				int var6 = blockX + random.nextInt(16);
    			int var7 = blockZ + random.nextInt(16);
    			int var8 = world.getHeightValue(var6, var7);

    			if (random.nextInt(100) == 0 && (world.getBlockId(var6, var8 - 4, var7) == Block.waterStill.blockID)) //|| world.getBlockId(var6, var8 - 1, var7) == 2 || world.getBlockId(var6, var8 - 1, var7) == Block.sand.blockID))
    			{
    				chehewreck.generate(world, random, var6, var8, var7);
    			}
    		}
   	 	}
    	
    	WorldGeneratorVikingWreck vikingwreck = new WorldGeneratorVikingWreck();
    	if(biome instanceof BiomeGenSwamp)
   	 	{
    	
    		for (int x = 0;x<2;x++)
    		{
    			int var6 = blockX + random.nextInt(512);
    			int var7 = blockZ + random.nextInt(512);
    			int var8 = world.getHeightValue(var6, var7);

    			if (random.nextInt(100) == 0 && (world.getBlockId(var6, var8 - 1, var7) == Block.waterStill.blockID))// || world.getBlockId(var6, var8 - 1, var7) == 2 || world.getBlockId(var6, var8 - 1, var7) == Block.sand.blockID))
    			{
    				vikingwreck.generate(world, random, var6, var8, var7);
    			}
    		}
   	 	}
    	
   	 }
    
	private void generateNether(World world, Random random, int blockX, int blockZ) 
	{
			  
	}
    
}
