package fossil.blocks;

import java.util.Random;

import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTar extends Block
{
    public BlockTar(int i, int j)
    {
        super(i, j, Material.sand);
        this.setCreativeTab(Fossil.tabFBlocks);
    }
    
    

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.motionX = 0.000000000000000004D;
        entity.motionY = 0.070000000745058064D;
        entity.fallDistance = 0.0F;
        entity.motionZ = 0.000000000000000004D;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random, int j)
    {
        return Fossil.tar.blockID;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1;
    }
    
    public boolean isOpaqueCube()
    {
        return true;
    }

    public boolean renderAsNormalBlock()
    {
        return true;
    }
    
    public boolean shouldSideBeRendered(IBlockAccess var1, int var2, int var3, int var4, int var5)
    {
        return true;
    }
    
    public String getTextureFile()
    {
    	return "/fossil/textures/Fos_terrian.png";
    }
    
}
