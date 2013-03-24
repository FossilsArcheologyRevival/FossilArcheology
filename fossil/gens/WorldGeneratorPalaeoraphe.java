package fossil.gens;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorPalaeoraphe implements IWorldGenerator 
{
 public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
 {
  switch (world.provider.dimensionId)
  {
   case -1: generateNether(world, random, chunkX*16, chunkZ*16);
   case 0: generateSurface(world, random, chunkX*16, chunkZ*16);
  }
 }

 private void generateSurface(World world, Random rand, int chunkX, int chunkZ) 
 {
	 BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
	 WorldGenPalaeoraphe tree = new WorldGenPalaeoraphe();
	 
	 if((biome instanceof BiomeGenSwamp))// then add ||BiomeGenXYZ if you want more.
	 {
		 for(int x = 0;x<2;x++)
		 {
			 int i = chunkX + rand.nextInt(128);
			 int k = chunkZ + rand.nextInt(128);
			 int j = world.getHeightValue(i, k);
			 tree.generate(world, rand, i, j, k);
		 }
	 }
 }
 

 private void generateNether(World world, Random random, int blockX, int blockZ) 
 {

 }

}
