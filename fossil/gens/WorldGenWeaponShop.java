package fossil.gens;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenWeaponShop implements IWorldGenerator
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
    	WorldGeneratorWeaponShop shop = new WorldGeneratorWeaponShop();
    	
    	if(biome instanceof BiomeGenDesert)// then add ||BiomeGenXYZ if you want more.
   	 	{
    		if(random.nextInt(1024) == 0) //adjust the number in nextInt(). Higher values == rarer.
			{
				int Xcoord1 = blockX + random.nextInt(16);
				int Ycoord1 = random.nextInt(5);
				int Zcoord1 = blockZ + random.nextInt(16);

    			shop.generate(world, random, Xcoord1, Ycoord1 - 60, Zcoord1);
    		}
		}
    }
	private void generateNether(World world, Random random, int blockX, int blockZ) 
	{
			  
	}
    
}
