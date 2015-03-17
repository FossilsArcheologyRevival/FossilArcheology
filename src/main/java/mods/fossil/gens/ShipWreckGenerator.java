package mods.fossil.gens;

import cpw.mods.fml.common.IWorldGenerator;
import mods.fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class ShipWreckGenerator implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                // not currently generating anything in the nether
                // generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;

            case 0:

                // 25% chance of a single structure per chunk; could make a weighted list
                // Recall that a chunk is only 16x16 blocks in area, so this is quite a lot of structures
                if (random.nextInt(1500) < 1)//Fossil.FossilOptions.Debug_Gen_Rate_Shipwreck)
                {
                    generateStructure(world, random, chunkX * 16, chunkZ * 16);
                }

                break;

            default:
                break;
        }
    }

EntityBones entitybones = new EntityBones(world);
entitybones.setLocationAndAngles((double)i, j, (double)k, 0.0F, 0.0F);
world.spawnEntityInWorld(entitybones);

    private final void generateStructure(World world, Random rand, int chunkX, int chunkZ)
    {
        // Need to create a new instance each time or the generate() methods may overlap themselves and cause a crash
        //WorldGeneratorAcademy gen = new WorldGeneratorAcademy();
        FossilWaterStructureGenerator gen = new FossilWaterStructureGenerator();
        int struct; // This will store a random index of the structure to generate
        struct = rand.nextInt(gen.structures.size());
        int x = chunkX + rand.nextInt(16);
        int z = chunkZ + rand.nextInt(16);
        // nice way of getting a height to work from; it returns the topmost
        // non-air block at an x/z position, such as tall grass, dirt or leaves
        int y = world.getHeightValue(x, z);

        // find ground level, ignoring blocks such as grass and water

        while ((!world.doesBlockHaveSolidTopSurface(x, y, z))//  && y > world.provider.getAverageGroundLevel())
                //	&& (!world.doesBlockHaveSolidTopSurface(x + 10, y+4, z + 11)
                //	|| !world.doesBlockHaveSolidTopSurface(x - 10, y+4, z - 11)
                //	|| !world.doesBlockHaveSolidTopSurface(x + 10, y+4, z - 11)
                //	|| !world.doesBlockHaveSolidTopSurface(x - 10, y+4, z + 11))
              )
        {
            --y;
        }

        if (!world.doesBlockHaveSolidTopSurface(x, y, z)
                || (world.getBlockId(x, y + 2, z) != Block.waterStill.blockID)
                //	|| !world.doesBlockHaveSolidTopSurface(x + 10, y, z + 11)
                //		|| !world.doesBlockHaveSolidTopSurface(x - 10, y, z - 11)
                //		|| !world.doesBlockHaveSolidTopSurface(x + 10, y, z - 11)
                //		|| !world.doesBlockHaveSolidTopSurface(x - 10, y, z + 11))
                //&& world.canBlockSeeTheSky(x, y, z)
           )
        {
            return;
        }
        else
        {
            Fossil.Console("Gen: Shipwreck Spawn at " + x + ", " + y + ", " + z);
        }

        int widthX = gen.structures.get(struct).getWidthX();
        int widthZ = gen.structures.get(struct).getWidthZ();
        int height = gen.structures.get(struct).getHeight();
        // Set structure and random facing, then generate; no offset needed here
        gen.setStructure(gen.structures.get(struct));
        gen.setStructureFacing(rand.nextInt(4));
        gen.generate(world, rand, x, y-(rand.nextInt(3)+3), z);
    }
}
