package fossil.gens;

import cpw.mods.fml.common.IWorldGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import fossil.Fossil;
import fossil.RelicHoleList;
import fossil.entity.mob.EntityBones;
import fossil.fossilEnums.EnumShipTypes;
import fossil.tags.ByteArrayTag;
import fossil.tags.CompoundTag;
import fossil.tags.NBTInputStream;
import fossil.tags.ShortTag;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldGenShipWreck implements IWorldGenerator
{
    private File SchFile;
    private InputStream SchInp;
    private NBTInputStream SchSource = null;
    private ArrayList ModelTagList = new ArrayList();
    private int WidthX;
    private int Layers;
    private int WidthZ;
    private byte[] BlockArray;
    private byte[] MDArray;
    private int ShipCount = 0;
    private static final int ShipLimit = 12500;
    private RelicHoleList Damages;
    public EnumShipTypes SelfType;
    private final int OCEAN_DEPTH = 14;
    private final String[] shipList = new String[] {"cheheWreck", "dukeWreck", "galleonWreck", "ShipWreck", "shortRangeWreck", "vikingWreck"};
    private boolean loaded = true;

    public WorldGenShipWreck()
    {
        String var1 = "/fossil/structers/shipWrecks/";
        String var2 = "/fossil/structers/shipWrecks/";
        String var3 = ".schematic";

        for (int var4 = 0; var4 < this.shipList.length; ++var4)
        {
            for (int var5 = 0; var5 < 360; var5 += 90)
            {
                String var6 = var5 == 0 ? "" : "_" + String.valueOf(var5);
                URL var7 = this.getClass().getResource("/fossil/structers/shipWrecks/" + this.shipList[var4] + var6 + ".schematic");

                if (var7 != null)
                {
                    try
                    {
                        this.SchFile = new File(var7.getFile());
                        this.SchInp = new FileInputStream(this.SchFile);
                        Fossil.DebugMessage("Model route:" + this.SchFile.getPath());
                        this.SchSource = new NBTInputStream(this.SchInp);
                        this.ModelTagList.add((CompoundTag)this.SchSource.readTag());
                        Fossil.DebugMessage("Ship model " + this.SchFile.getName() + " loaded");
                    }
                    catch (Throwable var18)
                    {
                        this.loaded = false;
                    }
                    finally
                    {
                        try
                        {
                            if (this.SchSource != null)
                            {
                                this.SchSource.close();
                            }
                        }
                        catch (IOException var17)
                        {
                            ;
                        }
                    }
                }
            }
        }
    }
    
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
        int var7 = 60;
        blockX *= 16;
        blockZ *= 16;

        if (this.loaded)
        {
            int var8 = 0;

            if (!this.ModelTagList.isEmpty())
            {
                CompoundTag var9 = (CompoundTag)this.ModelTagList.get(random.nextInt(this.ModelTagList.size()));
                this.WidthX = ((ShortTag)((ShortTag)var9.getValue().get("Width"))).getValue().shortValue();
                this.Layers = ((ShortTag)((ShortTag)var9.getValue().get("Height"))).getValue().shortValue();
                int var10000 = this.Layers;
                this.getClass();

                if (var10000 > 14)
                {
                    var10000 = this.Layers;
                    this.getClass();
                    var8 = var10000 - 14;
                }

                this.WidthZ = ((ShortTag)((ShortTag)var9.getValue().get("Length"))).getValue().shortValue();
                this.BlockArray = ((ByteArrayTag)((ByteArrayTag)var9.getValue().get("Blocks"))).getValue();
                this.MDArray = ((ByteArrayTag)((ByteArrayTag)var9.getValue().get("Data"))).getValue();

                if (this.ShipCount != 0)
                {
                    --this.ShipCount;
                }
                else
                {
                    this.ShipCount = 12500;
                    int var14 = 0;
                    this.SelfType = EnumShipTypes.GetRandom(random);

                    for (this.Damages = new RelicHoleList(random, this.WidthX, this.Layers, this.WidthZ, this.BlockArray, -1, -1); !world.isBlockNormalCube(blockX + this.WidthX / 2, var7, blockZ + this.WidthZ / 2); --var7)
                    {
                        ;
                    }

                    int var11;

                    for (var11 = 0; var11 < this.Layers - var8; ++var11)
                    {
                        if (world.getBlockMaterial(blockX - this.WidthX / 2, var7 + var11, blockZ - this.WidthZ / 2) == Material.water)
                        {
                            ++var14;

                            if (var14 >= this.Layers / 2)
                            {
                                break;
                            }
                        }
                    }

                    if (var14 >= this.Layers / 2)
                    {
                        var7 -= var8;

                        for (var11 = 0; var11 < this.Layers; ++var11)
                        {
                            for (int var12 = 0; var12 < this.WidthZ; ++var12)
                            {
                                for (int var10 = 0; var10 < this.WidthX; ++var10)
                                {
                                    int var13 = var11 * this.WidthX * this.WidthZ + var12 * this.WidthX + var10;

                                    if (var13 >= this.BlockArray.length)
                                    {
                                        return;
                                    }

                                    byte var15 = this.BlockArray[var13];
                                    int var16 = this.MDArray[var13];

                                    if (var15 == Block.torchWood.blockID)
                                    {
                                        var15 = 0;
                                    }
                                    else if (this.Damages.isHole(var10, var11, var12))
                                    {
                                        var15 = 0;
                                    }

                                    if (var15 != 0)
                                    {
                                        if (var15 == Block.planks.blockID)
                                        {
                                            var16 = this.SelfType.getMetaData();
                                        }

                                        world.setBlockAndMetadata(blockX - this.WidthX / 2 + var10, var7 + var11, blockZ - this.WidthZ / 2 + var12, var15, var16);

                                        if (Block.blocksList[var15].hasTileEntity(var16))
                                        {
                                            this.SetupTileEntitys(world, random, blockX - this.WidthX / 2 + var10, var7 + var11, blockZ - this.WidthZ / 2 + var12);
                                        }
                                    }
                                    else if (random.nextInt(10000) < 5)
                                    {
                                        EntityBones var17 = new EntityBones(world);
                                        var17.setLocationAndAngles((double)(blockX - this.WidthX / 2 + var10), (double)(var7 + var11), (double)(blockZ - this.WidthZ / 2 + var12), random.nextFloat() * 360.0F, 0.0F);

                                        if (world.checkIfAABBIsClear(var17.boundingBox) && world.getCollidingBoundingBoxes(var17, var17.boundingBox).size() == 0)
                                        {
                                            world.spawnEntityInWorld(var17);
                                        }
                                    }
                                }
                            }
                        }

                        Fossil.DebugMessage("Placing shipwreck of " + this.SelfType.toString() + " at " + blockX + ',' + var7 + ',' + blockZ);
                    }
                }
            }
        }
    }

    private short SwapCargoBlock(Random var1)
    {
        int var2 = var1.nextInt(1000);

        switch (this.SelfType.ordinal())
        {
            case 1:
                if (var2 < 10)
                {
                    return (short)Fossil.blockanalyzerIdle.blockID;
                }

                if (var2 < 20)
                {
                    return (short)Fossil.blockcultivateIdle.blockID;
                }

                if (var2 < 30)
                {
                    return (short)Fossil.blockworktableIdle.blockID;
                }

                break;

            case 2:
                if (var2 < 500)
                {
                    return (short)Block.blockSteel.blockID;
                }

                if (var2 < 600)
                {
                    return (short)Block.blockGold.blockID;
                }

                break;

            case 3:
                if (var2 < 333)
                {
                    return (short)Block.tnt.blockID;
                }

                break;

            case 4:
            default:
                if (var2 < 100)
                {
                    return (short)Fossil.blockSkull.blockID;
                }
        }

        return (short)0;
    }

    private byte SwapCargoMD(Random var1)
    {
        return (byte)0;
    }

    public void SetupTileEntitys(World var1, Random var2, int var3, int var4, int var5)
    {
        TileEntity var6 = var1.getBlockTileEntity(var3, var4, var5);

        if (var6 != null)
        {
            if (!(var6 instanceof TileEntityFurnace))
            {
                ItemStack var8;
                int var9;
                int var10;

                if (var6 instanceof TileEntityChest)
                {
                    TileEntityChest var7 = (TileEntityChest)var6;
                    var8 = null;
                    var9 = var2.nextInt(27);

                    for (var10 = 1; var10 <= var9; ++var10)
                    {
                        var8 = this.GetRandomContent(var2);

                        if (var8 != null)
                        {
                            var7.setInventorySlotContents(var2.nextInt(var7.getSizeInventory()), var8);
                        }
                    }
                }
                else
                {
                    if (!(var6 instanceof TileEntityDispenser))
                    {
                        return;
                    }

                    if (this.SelfType != EnumShipTypes.Battleship)
                    {
                        return;
                    }

                    TileEntityDispenser var11 = (TileEntityDispenser)var6;
                    var9 = var2.nextInt(3);

                    for (var10 = 1; var10 <= var9; ++var10)
                    {
                        var8 = new ItemStack(Item.arrow, var2.nextInt(63) + 1);

                        if (var8 != null)
                        {
                            var11.setInventorySlotContents(var10, var8);
                        }
                    }
                }
            }
        }
    }

    public ItemStack GetRandomContent(Random var1)
    {
        int var2 = var1.nextInt(1000);

        switch (this.SelfType.ordinal())
        {
            case 1:
                if (var2 < 100)
                {
                    return new ItemStack(Item.potion, 1, 1 + var1.nextInt(19));
                }

                if (var2 < 200)
                {
                    return new ItemStack(Fossil.relic, var1.nextInt(63) + 1);
                }

                if (var2 < 300)
                {
                    return new ItemStack(Fossil.stoneboard);
                }

                break;

            case 2:
                if (var2 == 0)
                {
                    return new ItemStack(Fossil.gem);
                }

                if (var2 <= 10)
                {
                    return new ItemStack(Block.blockDiamond);
                }

                if (var2 < 250)
                {
                    return new ItemStack(Block.blockSteel, var1.nextInt(14) + 1);
                }

                if (var2 < 350)
                {
                    return new ItemStack(Item.ingotGold, var1.nextInt(31) + 1);
                }

                break;

            case 3:
                if (var2 < 2)
                {
                    return new ItemStack(Fossil.ancientJavelin);
                }

                if (var2 <= 35)
                {
                    return new ItemStack(Block.tnt, var1.nextInt(9) + 1);
                }

                if (var2 < 70)
                {
                    return new ItemStack(Item.swordSteel);
                }

                if (var2 < 90)
                {
                    return new ItemStack(Fossil.ironjavelin, var1.nextInt(63) + 1);
                }

                if (var2 < 240)
                {
                    return new ItemStack(Item.bow);
                }

                if (var2 < 750)
                {
                    return new ItemStack(Item.arrow, var1.nextInt(63) + 1);
                }

                break;

            case 4:
            default:
                if (var2 < 15)
                {
                    return new ItemStack(Fossil.blockSkull);
                }

                if (var2 < 100)
                {
                    return new ItemStack(Item.egg, var1.nextInt(63) + 1);
                }

                if (var2 < 300)
                {
                    return new ItemStack(Item.fishRaw, var1.nextInt(63) + 1);
                }

                if (var2 < 750)
                {
                    return new ItemStack(Item.rottenFlesh, var1.nextInt(63) + 1);
                }
        }

        return var2 == 900 ? new ItemStack(Item.compass) : null;
    }
    
    private void generateNether(World world, Random random, int blockX, int blockZ) 
	{
			  
	}
    
}
