package fossil.gens;

import cpw.mods.fml.common.IWorldGenerator;
import java.util.Random;

import fossil.Fossil;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class FossilGenerator implements IWorldGenerator 
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
		for(int i=0;i<38;i++)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(100);
			int Zcoord = blockZ + random.nextInt(16);	  
			(new WorldGenMinable(Fossil.blockFossil.blockID, 5+random.nextInt(6))).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
		for(int i=0;i<8;i++)
		{
			int Xcoord = blockX + random.nextInt(16);
			int Ycoord = random.nextInt(30);
			int Zcoord = blockZ + random.nextInt(16);		  
			(new WorldGenMinable(Fossil.blockPermafrost.blockID, 2+random.nextInt(4))).generate(world, random, Xcoord, Ycoord, Zcoord);
		}
	 }
	private void generateNether(World world, Random random, int blockX, int blockZ) 
	{
			  
	}
}