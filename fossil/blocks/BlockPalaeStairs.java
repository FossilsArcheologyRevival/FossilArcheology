package fossil.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fossil.Fossil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockPalaeStairs extends BlockStairs
{
        /** The block that is used as model for the stair. */
        private  Block modelBlock;
        public BlockPalaeStairs(int par1,Block modelBlockx,int par2)
        {
                super(par1, modelBlockx, par2);
                blockIndexInTexture = par2;
                this.modelBlock = modelBlockx;
                this.setLightOpacity(0);
                this.setCreativeTab(Fossil.tabFBlocks);
        }
        //this deals with the block texture. 
        @Override
        public int getBlockTextureFromSideAndMetadata(int par1, int par2)
        {
            return blockIndexInTexture;
        }

      //gets texture file
        public String getTextureFile()
        {
        	return "/fossil/textures/Fos_terrian.png";
        }

        @SideOnly(Side.CLIENT) //Client side only
        public int getBlockTextureFromSide(int i)
        { //Tells it which texture from the sprite sheet
        	return 80;
        }
    }
