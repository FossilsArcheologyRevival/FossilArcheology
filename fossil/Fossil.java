package fossil;

import java.io.BufferedReader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;

import fossil.client.FossilCfgLoader;
import fossil.client.FossilGuiHandler;
import fossil.client.FossilMessageHandler;
import fossil.client.FossilOptions;
import fossil.blocks.BlockFern;
import fossil.blocks.BlockFossil;
import fossil.blocks.BlockFossilSkull;
import fossil.blocks.BlockIcedStone;
import fossil.blocks.BlockPalaePlanks;
import fossil.blocks.BlockPalaeSlab;
import fossil.blocks.BlockPalaeStairs;
import fossil.blocks.BlockPalmLeaves;
import fossil.blocks.BlockPalmLog;
import fossil.blocks.BlockPalmSapling;
import fossil.blocks.BlockPermafrost;
import fossil.blocks.BlockTar;
import fossil.blocks.BlockVolcanicAsh;
import fossil.blocks.BlockVolcanicRock;
import fossil.blocks.FossilSlabs;
import fossil.entity.EntityAncientJavelin;
import fossil.entity.EntityDinoEgg;
import fossil.entity.EntityJavelin;
import fossil.entity.EntityMLighting;
import fossil.entity.EntityStoneboard;
import fossil.entity.mob.EntityBones;
import fossil.entity.mob.EntityBrachiosaurus;
import fossil.entity.mob.EntityDinosaurce;
import fossil.entity.mob.EntityFailuresaurus;
import fossil.entity.mob.EntityFriendlyPigZombie;
import fossil.entity.mob.EntityMammoth;
import fossil.entity.mob.EntityMosasaurus;
import fossil.entity.mob.EntityNautilus;
import fossil.entity.mob.EntityPigBoss;
import fossil.entity.mob.EntityPlesiosaur;
import fossil.entity.mob.EntityPregnantCow;
import fossil.entity.mob.EntityPregnantPig;
import fossil.entity.mob.EntityPregnantSheep;
import fossil.entity.mob.EntityPterosaur;
import fossil.entity.mob.EntityVelociraptor;
import fossil.entity.mob.EntitySaberCat;
import fossil.entity.mob.EntityStegosaurus;
import fossil.entity.mob.EntityTRex;
import fossil.entity.mob.EntityTriceratops;
import fossil.entity.mob.EntityDilophosaurus;
import fossil.entity.BehaviorJavelinDispense;
//import fossil.fossilEnums.EnumAnimalType;
import fossil.fossilEnums.EnumDinoType;
import fossil.fossilEnums.EnumEmbryos;
import fossil.fossilEnums.EnumOrderType;
import fossil.gens.FossilGenerator;
import fossil.gens.TarGenerator;
import fossil.gens.WorldGenAcademy;
/*import fossil.gens.WorldGenBigShip;
import fossil.gens.WorldGenCheheWreck;
import fossil.gens.WorldGenDukeWreck;
import fossil.gens.WorldGenGalleonWreck;*/
import fossil.gens.WorldGenPalaeoraphe;
import fossil.gens.WorldGenShipWreck;
/*import fossil.gens.WorldGenShipWreck180;
import fossil.gens.WorldGenShipWreck270;
import fossil.gens.WorldGenShipWreck90;
import fossil.gens.WorldGenShortRangeWreck;
import fossil.gens.WorldGenVikingWreck;*/
import fossil.gens.WorldGenShips;
import fossil.gens.WorldGenWeaponShop;
import fossil.gens.WorldGeneratorPalaeoraphe;
import fossil.guiBlocks.BlockAnalyzer;
import fossil.guiBlocks.BlockCultivate;
import fossil.guiBlocks.BlockDrum;
import fossil.guiBlocks.BlockFeeder;
import fossil.guiBlocks.BlockWorktable;
import fossil.guiBlocks.BlockTimeMachine;
import fossil.guiBlocks.TileEntityAnalyzer;
import fossil.guiBlocks.TileEntityCultivate;
import fossil.guiBlocks.TileEntityDrum;
import fossil.guiBlocks.TileEntityFeeder;
import fossil.guiBlocks.TileEntityTimeMachine;
import fossil.guiBlocks.TileEntityWorktable;
import fossil.items.ItemAncientEgg;
import fossil.items.ItemAncientHelmet;
import fossil.items.ItemAncientsword;
import fossil.items.ItemBioFossil;
import fossil.items.ItemBrokenHelmet;
import fossil.items.ItemBrokenSapling;
import fossil.items.ItemBrokenSword;
import fossil.items.ItemChickenSoup;
import fossil.items.ItemClaw;
import fossil.items.ItemDNA;
import fossil.items.ItemDinoMeat;
import fossil.items.ItemEmbryoSyringe;
import fossil.items.ItemFeet;
import fossil.items.ItemFemurs;
import fossil.items.ItemFernSeed;
import fossil.items.ItemFoot;
import fossil.items.ItemGem;
import fossil.items.ItemIcedMeat;
import fossil.items.ItemJavelin;
import fossil.items.ItemLegBone;
import fossil.items.ItemMagicConch;
import fossil.items.ItemNonDinoDNA;
import fossil.items.ItemRelic;
import fossil.items.ItemRibCage;
import fossil.items.ItemSkull;
import fossil.items.ItemSkullHelmet;
import fossil.items.ItemStoneBoard;
import fossil.items.ItemWhip;
import fossil.items.forgeItems.ForgeItem;
import fossil.items.forgeItems.ForgeItemAxe;
import fossil.items.forgeItems.ForgeItemArmor;
import fossil.items.forgeItems.ForgeItemFood;
import fossil.items.forgeItems.ForgeItemHoe;
import fossil.items.forgeItems.ForgeItemPickaxe;
import fossil.items.forgeItems.ForgeItemSpade;
import fossil.items.forgeItems.ForgeItemSword;
import fossil.tabs.TabFArmor;
import fossil.tabs.TabFBlocks;
import fossil.tabs.TabFCombat;
import fossil.tabs.TabFFood;
import fossil.tabs.TabFItems;
import fossil.tabs.TabFMaterial;
import fossil.tabs.TabFTools;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.stats.Achievement;
import net.minecraft.util.StringTranslate;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IChatListener;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = "Fossil", name = "Fossil/Archeology", version = "1.47 0003")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class Fossil 
{
	@SidedProxy(clientSide = "fossil.client.ClientProxy", serverSide = "fossil.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance("Fossil")
	public static Fossil instance;
	
	public static FossilGuiHandler GH = new FossilGuiHandler();
	public static Properties LangProps = new Properties();
	public static int blockRendererID = 0;
	public static Object ToPedia;
	
	//private static final File Langdir = new File("/lang");
    //public static String LastLangSetting = "en_US";
	//private static File Langfile = new File(Langdir, LastLangSetting + ".lang");
	public static IChatListener messagerHandler = new FossilMessageHandler();
	
	/*
	 * If DebugMode = true
	 * HatchTime is set to 1
	 */
	public static boolean DebugMode = false;
	public static final double MESSAGE_DISTANCE = 25.0D;
	
    //private static int[] blockIDs = new int[] {1137, 1138, 1139, 1140, 1141, 1142, 1143, 1144, 1145, 1146, 1147, 1148, 1149, 1151, 1152, 1153};
    //private static String[] BlockName = new String[] {"block Fossil", "block Skull", "block SkullLantern", "block analyzerIdle", "block analyzerActive", "block cultivateIdle", "block cultivateActive", "block worktableIdle", "block worktableActive", "block fern", "block fernUpper", "block Drum", "block FeederIdle", "block FeederActive", "Block Permafrost", "Block IcedStone"};
    //private static int[] ItemIDs = new int[] {600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636};
    //private static String[] ItemName = new String[] {"Item biofossil", "Item relic", "Item stoneboard", "Item DNA", "Item Ancientegg", "Item AncientSword", "Item BrokenSword", "Item FernSeed", "Item AncientHelmet", "Item BrokenHelmet", "Item SkullStick", "Item Gen", "Item GenAxe", "Item GenPickaxe", "Item GenSword", "Item GenHoe", "Item GenShovel", "Item DinoPedia", "Item TRexTooth", "Item ToothDagger", "Item RawChickenSoup", "Item ChickenEss", "Item EmptyShell", "Item Magic conch", "Item SJL", "Item RawDinoMeat", "Item CookedDinoMeat", "Item EmbyoSyringe", "Item AnimalDNA", "Item IcedMeat", "Item WoodJavelin", "Item StonrJavelin", "Item IronJavelin", "Item GoldJavelin", "Item DiamondJavelin", "Item AncientJavelin", "Item Whip"};
    public static int[] fernPics = new int[] {38, 39, 40, 41, 42, 43, 26, 27, 71, 72, 73, 74, 58};
    //public static final int MultiCount = EnumDinoType.values().length * 3 + EnumAnimalType.values().length * 2 - 1 + 2;
    //public static ItemStack[] SingleTotalList;
    //public static ItemStack[] MultiTotalList = new ItemStack[MultiCount];
    
    public static CreativeTabs tabFBlocks = new TabFBlocks(CreativeTabs.getNextID(), "Fossil Blocks");
	public static CreativeTabs tabFItems = new TabFItems(CreativeTabs.getNextID(), "Fossil Items");
	public static CreativeTabs tabFFood = new TabFFood(CreativeTabs.getNextID(), "Fossil Food");
	public static CreativeTabs tabFCombat = new TabFCombat(CreativeTabs.getNextID(), "Fossil Combat");
	public static CreativeTabs tabFArmor = new TabFArmor(CreativeTabs.getNextID(), "Fossil Armor");
	public static CreativeTabs tabFTools = new TabFTools(CreativeTabs.getNextID(), "Fossil Deco");
	public static CreativeTabs tabFMaterial = new TabFMaterial(CreativeTabs.getNextID(), "Fossil Material");
	
	//public static WorldType fossil = new WorldTypeFossil(3, "Dino Test");
	
    public static Achievement pigbossOnEarth = (new Achievement(18000, "PigbossOnEarth", 0, 0, new ItemStack(Item.dyePowder, 1, 4), (Achievement)null)).registerAchievement();
    public static AchievementPage selfArcPage = new AchievementPage("FOSSIL / ARCHEOLOGY", new Achievement[] {pigbossOnEarth});
    
	//Blocks
	public static Block blockFossil;
	public static Block blockSkull;
	public static Block skullLantern;
	public static Block blockanalyzerIdle;
	public static Block blockanalyzerActive;
	public static Block blockcultivateIdle;
	public static Block blockcultivateActive;
	public static Block blockworktableIdle;
	public static Block blockworktableActive;
	public static Block blockTimeMachine;
	public static Block ferns;
	//public static Block fernUpper;
	public static Block drum;
	public static Block feederIdle;
	public static Block feederActive;
	public static Block blockPermafrost;
	public static Block blockIcedStone;
	public static Block volcanicAsh;
	public static Block volcanicRock;
	public static Block volcanicRockHot;
	public static Block tar;
	public static Block palmLog;
	public static Block palmLeaves;
	public static Block palmSap;
	public static Block palaePlanks;
	public static FossilSlabs palaeSingleSlab;
	public static FossilSlabs palaeDoubleSlab;
	public static Block palaeStairs;
	//public static Block newBlock;
	//public static Block newBlock;
	//public static Block newBlock;
	//public static Block newBlock;
	//public static Block newBlock;
	//public static Block newBlock;
	//public static Block newBlock;
	//public static Block newBlock;
	
    //Items
    public static Item biofossil;
    public static Item relic;
    public static Item stoneboard;
    public static Item ancientSword;
    public static Item brokenSword;
    public static Item fernSeed;
    public static Item ancienthelmet;
    public static Item brokenhelmet;
    public static Item skullStick;
    public static Item gem;
    public static Item gemAxe;
    public static Item gemPickaxe;
    public static Item gemSword;
    public static Item gemHoe;
    public static Item gemShovel;
    public static Item dinoPedia;
    public static Item emptyShell;
    public static Item magicConch;
    public static Item icedMeat;
    public static Item woodjavelin;
    public static Item stonejavelin;
    public static Item ironjavelin;
    public static Item goldjavelin;
    public static Item diamondjavelin;
    public static Item ancientJavelin;
    public static Item whip;
    public static Item legBone;
	public static Item claw;
	public static Item foot;
	public static Item skull;
	public static Item brokenSapling;
    //public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
    //public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
    //public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
	//public static Item newItem;
	
    //Armor
    public static Item skullHelmet;
	public static Item ribCage;
	public static Item femurs;
	public static Item feet;
	//public static Item newArmor;
	//public static Item newArmor;
	//public static Item newArmor;
	//public static Item newArmor;
	//public static Item newArmor;
	//public static Item newArmor;
	//public static Item newArmor;
	//public static Item newArmor;
	
	//DNA
	//public static Item dna;
	public static Item dnaTriceratops;
	public static Item dnaVelociraptor;
	public static Item dnaTRex;
	public static Item dnaPterosaur;
	public static Item dnaNautilus;
	public static Item dnaPlesiosaur;
	public static Item dnaMosasaurus;
	public static Item dnaStegosaurus;
	public static Item dnaDilophosaurus;
	public static Item dnaBrachiosaurus;
	//public static Item newDinoDNA;
	//public static Item newDinoDNA;
	//public static Item newDinoDNA;
	//public static Item newDinoDNA;
	//public static Item newDinoDNA;
	//public static Item newDinoDNA;

	//Animal Dna
	//public static Item animalDNA;
	public static Item dnaPig;
	public static Item dnaSheep;
	public static Item dnaCow;
	public static Item dnaChicken;
	public static Item dnaSaberCat;
	public static Item dnaMammoth;
	
	//Mob DNA
	//public static Item mobDNA;
	//public static Item dnaPigZombie;
	//public static Item dnaZombie;
	//public static Item dnaGhast;
	//public static Item dnaWither;
	//public static Item dnaSpider;
	//public static Item dnaSkeleton;
	
	//Ancient Egg
	//public static Item ancientegg;
	public static Item eggTriceratops;
	public static Item eggVelociraptor;
	public static Item eggTRex;
	public static Item eggPterosaur;
	public static Item shellNautilus;
	public static Item eggPlesiosaur;
	public static Item eggMosasaurus;
	public static Item eggStegosaurus;
	public static Item eggDilophosaurus;
	public static Item eggBrachiosaurus;
	//public static Item eggNew;
	//public static Item eggNew;
	//public static Item eggNew;
	//public static Item eggNew;
	//public static Item eggNew;
	//public static Item eggNew;
	
	//Embryos
	//public static Item embyoSyringe;
	public static Item embryoPig;
	public static Item embryoSheep;
	public static Item embryoCow;
	public static Item embryoChicken;
	public static Item embryoSaberCat;
	public static Item embryoMammoth;
	//public static Item embryoPigZombie;
	//public static Item embryoZombie;
	//public static Item embryoGhast;
	//public static Item embryoWither;
	//public static Item embryoSkeleton;
	//public static Item embryoSpider;
	
	//Item Food
	public static Item cookedChickenSoup;
	public static Item rawChickenSoup;
    public static Item chickenEss;
	public static Item sjl;
	//public static Item rawDinoMeat;
	public static Item rawTriceratops;
	public static Item rawVelociraptor;
	public static Item rawTRex;
	public static Item rawPterosaur;
	public static Item rawNautilus;
	public static Item rawPlesiosaur;
	public static Item rawMosasaurus;
	public static Item rawStegosaurus;
	public static Item rawDilophosaurus;
	public static Item rawBrachiosaurus;
	public static Item cookedDinoMeat;
	
	//Config ID INTs
	//Blocks
	public static int blockFossilID;
	public static int blockSkullID;
	public static int skullLanternID;
	public static int blockanalyzerIdleID;
	public static int blockanalyzerActiveID;
	public static int blockcultivateIdleID;
	public static int blockcultivateActiveID;
	public static int blockworktableIdleID;
	public static int blockworktableActiveID;
	public static int blockTimeMachineID;
	public static int fernsID;
	//public static int fernUpperID;
	public static int drumID;
	public static int feederIdleID;
	public static int feederActiveID;
	public static int blockPermafrostID;
	public static int blockIcedStoneID;
	public static int volcanicAshID;
	public static int volcanicRockID;
	public static int volcanicRockHotID;
	public static int tarID;
	public static int palmLogID;
	public static int palmLeavesID;
	public static int palmSapID;
	public static int palaePlanksID;
	public static int palaeSingleSlabID;
	public static int palaeDoubleSlabID;
	public static int palaeStairsID;
	//public static int newBlockID;
	//public static int newBlockID;
	//public static int newBlockID;
	//public static int newBlockID;
	//public static int newBlockID;
	//public static int newBlockID;
	//public static int newBlockID;
	//public static int newBlockID;
	
    //Items
    public static int biofossilID;
    public static int relicID;
    public static int stoneboardID;
    public static int ancientSwordID;
    public static int brokenSwordID;
    public static int fernSeedID;
    public static int ancienthelmetID;
    public static int brokenhelmetID;
    public static int skullStickID;
    public static int gemID;
    public static int gemAxeID;
    public static int gemPickaxeID;
    public static int gemSwordID;
    public static int gemHoeID;
    public static int gemShovelID;
    public static int dinoPediaID;
    public static int emptyShellID;
    public static int magicConchID;
    public static int icedMeatID;
    public static int woodjavelinID;
    public static int stonejavelinID;
    public static int ironjavelinID;
    public static int goldjavelinID;
    public static int diamondjavelinID;
    public static int ancientJavelinID;
    public static int whipID;
	public static int legBoneID;
	public static int clawID;
	public static int footID;
	public static int skullID;
	public static int brokenSaplingID;
    //public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
    //public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
    //public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
	//public static int newItemID;
	
	//Armor
	public static int skullHelmetID;
	public static int ribCageID;
	public static int femursID;
	public static int feetID;
	//public static int newArmorID;
	//public static int newArmorID;
	//public static int newArmorID;
	//public static int newArmorID;
	//public static int newArmorID;
	//public static int newArmorID;
	//public static int newArmorID;
	//public static int newArmorID;
	
	//DNA
	//public static int dnaID;
	public static int dnaTriceratopsID;
	public static int dnaVelociraptorID;
	public static int dnaTRexID;
	public static int dnaPterosaurID;
	public static int dnaNautilusID;
	public static int dnaPlesiosaurID;
	public static int dnaMosasaurusID;
	public static int dnaStegosaurusID;
	public static int dnaDilophosaurusID;
	public static int dnaBrachiosaurusID;
	//public static int newDinoDNAID;
	//public static int newDinoDNAID;
	//public static int newDinoDNAID;
	//public static int newDinoDNAID;
	//public static int newDinoDNAID;
	//public static int newDinoDNAID;

	//Animal DNA
	//public static int animalDNAID;
	public static int dnaPigID;
	public static int dnaSheepID;
	public static int dnaCowID;
	public static int dnaChickenID;
	public static int dnaSaberCatID;
	public static int dnaMammothID;
	
	//Mob DNA
	//public static int mobDNAID;
	//public static int dnaPigZombieID;
	//public static int dnaZombieID;
	//public static int dnaGhastID;
	//public static int dnaWitherID;
	//public static int dnaSpiderID;
	//public static int dnaSkeletonID;
	
	//Ancient Egg
	//public static int ancienteggID;
	public static int eggTriceratopsID;
	public static int eggVelociraptorID;
	public static int eggTRexID;
	public static int eggPterosaurID;
	public static int shellNautilusID;
	public static int eggPlesiosaurID;
	public static int eggMosasaurusID;
	public static int eggStegosaurusID;
	public static int eggDilophosaurusID;
	public static int eggBrachiosaurusID;
	//public static int eggNewID;
	//public static int eggNewID;
	//public static int eggNewID;
	//public static int eggNewID;
	//public static int eggNewID;
	//public static int eggNewID;
	
	//Embryos
	//public static int embyoSyringeID;
	public static int embryoPigID;
	public static int embryoSheepID;
	public static int embryoCowID;
	public static int embryoChickenID;
	public static int embryoSaberCatID;
	public static int embryoMammothID;
	//public static int embryoPigZombieID;
	//public static int embryoZombieID;
	//public static int embryoGhastID;
	//public static int embryoWitherID;
	//public static int embryoSkeletonID;
	//public static int embryoSpiderID;
	
	//Food
	public static int cookedChickenSoupID;
	public static int rawChickenSoupID;
    public static int chickenEssID;
	public static int sjlID;
	//public static int rawDinoMeatID;
	public static int rawTriceratopsID;
	public static int rawVelociraptorID;
	public static int rawTRexID;
	public static int rawPterosaurID;
	public static int rawNautilusID;
	public static int rawPlesiosaurID;
	public static int rawMosasaurusID;
	public static int rawStegosaurusID;
	public static int rawDilophosaurusID;
	public static int rawBrachiosaurusID;
	public static int cookedDinoMeatID;
	
	public static boolean Option_Gen_Palaeoraphe;
	public static boolean Option_Gen_Academy;
	public static boolean Option_Gen_Ships;
	public static String Option_Lang_Server;
	
	static EnumArmorMaterial dinoBone = EnumHelper.addArmorMaterial("DinoBone", 35, new int[]{4,9,7,6}, 15);
	
    @cpw.mods.fml.common.Mod.PreInit
	public void PreInit(FMLPreInitializationEvent event)
	{
		Configuration var2 = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			var2.load();
		
		//Blocks
		blockFossilID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockFossil", 3000).getInt(3000);
		blockSkullID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockSkull", 3001).getInt(3001);
		skullLanternID = var2.getBlock(Configuration.CATEGORY_BLOCK, "skullLantern", 3002).getInt(3002);
		blockanalyzerIdleID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockanalyzerIdle", 3003).getInt(3003);
		blockanalyzerActiveID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockanalyzerActive", 3004).getInt(3004);
		blockcultivateIdleID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockcultivateIdle", 3005).getInt(3005);
		blockcultivateActiveID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockcultivateActive", 3006).getInt(3006);
		blockworktableIdleID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockworktableIdle", 3007).getInt(3007);
		blockworktableActiveID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockworktableActive", 3008).getInt(3008);
		blockTimeMachineID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockTimeMachine", 3009).getInt(3009);
		fernsID = var2.getBlock(Configuration.CATEGORY_BLOCK, "ferns", 3010).getInt(3010);
		//fernUpperID = var2.getBlock(Configuration.CATEGORY_BLOCK, "fernUpper", 3011).getInt(3011);
		drumID = var2.getBlock(Configuration.CATEGORY_BLOCK, "drum", 3012).getInt(3012);
		feederIdleID = var2.getBlock(Configuration.CATEGORY_BLOCK, "feederIdle", 3013).getInt(3013);
		feederActiveID = var2.getBlock(Configuration.CATEGORY_BLOCK, "feederActive", 3014).getInt(3014);
		blockPermafrostID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockPermafrost", 3015).getInt(3015);
		blockIcedStoneID = var2.getBlock(Configuration.CATEGORY_BLOCK, "blockIcedStone", 3016).getInt(3016);
		volcanicAshID = var2.getBlock(Configuration.CATEGORY_BLOCK, "volcanicAsh", 3017).getInt(3017);
		volcanicRockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "volcanicRock", 3018).getInt(3018);
		volcanicRockHotID = var2.getBlock(Configuration.CATEGORY_BLOCK, "volcanicRockHot", 3019).getInt(3019);
		tarID = var2.getBlock(Configuration.CATEGORY_BLOCK, "tar", 3020).getInt(3020);
		palmLogID = var2.getBlock(Configuration.CATEGORY_BLOCK, "palmLog", 3021).getInt(3021);
		palmLeavesID = var2.getBlock(Configuration.CATEGORY_BLOCK, "palmLeaves", 3022).getInt(3022);
		palmSapID = var2.getBlock(Configuration.CATEGORY_BLOCK, "palmSap", 3023).getInt(3023);
		palaePlanksID = var2.getBlock(Configuration.CATEGORY_BLOCK, "palaePlanks", 3024).getInt(3024);
		palaeSingleSlabID = var2.getBlock(Configuration.CATEGORY_BLOCK, "palaeSingleSlab", 3024).getInt(3024);
		palaeDoubleSlabID = var2.getBlock(Configuration.CATEGORY_BLOCK, "palaeDoubleSlab", 3025).getInt(3025);
		palaeStairsID = var2.getBlock(Configuration.CATEGORY_BLOCK, "palaeStairs", 3026).getInt(3026);
		//newBlockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "newBlock", 3027).getInt(3027);
		//newBlockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "newBlock", 3028).getInt(3028);
		//newBlockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "newBlock", 3029).getInt(3029);
		//newBlockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "newBlock", 3030).getInt(3030);
		//newBlockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "newBlock", 3031).getInt(3031);
		//newBlockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "newBlock", 3032).getInt(3032);
		//newBlockID = var2.getBlock(Configuration.CATEGORY_BLOCK, "newBlock", 3033).getInt(3033);
	
		//Items
		biofossilID = var2.getItem(Configuration.CATEGORY_ITEM, "biofossil", 10000).getInt(10000);
		relicID = var2.getItem(Configuration.CATEGORY_ITEM, "relic", 10001).getInt(10001);
		stoneboardID = var2.getItem(Configuration.CATEGORY_ITEM, "stoneboard", 10002).getInt(10002);
		ancientSwordID = var2.getItem(Configuration.CATEGORY_ITEM, "ancientSword", 10003).getInt(10003);
		brokenSwordID = var2.getItem(Configuration.CATEGORY_ITEM, "brokenSword", 10004).getInt(10004);
		fernSeedID = var2.getItem(Configuration.CATEGORY_ITEM, "fernSeed", 10005).getInt(10005);
		ancienthelmetID = var2.getItem(Configuration.CATEGORY_ITEM, "ancienthelmet", 10006).getInt(10006);
		brokenhelmetID = var2.getItem(Configuration.CATEGORY_ITEM, "brokenhelmet", 10007).getInt(10007);
		skullStickID = var2.getItem(Configuration.CATEGORY_ITEM, "skullStick", 10008).getInt(10008);
		gemID = var2.getItem(Configuration.CATEGORY_ITEM, "gem", 10009).getInt(10009);
		gemAxeID = var2.getItem(Configuration.CATEGORY_ITEM, "gemAxe", 10010).getInt(10010);
		gemPickaxeID = var2.getItem(Configuration.CATEGORY_ITEM, "gemPickaxe", 10011).getInt(10011);
		gemSwordID = var2.getItem(Configuration.CATEGORY_ITEM, "gemSword", 10012).getInt(10012);
		gemHoeID = var2.getItem(Configuration.CATEGORY_ITEM, "gemHoe", 10013).getInt(10013);
		gemShovelID = var2.getItem(Configuration.CATEGORY_ITEM, "gemShovel", 10014).getInt(10014);
		dinoPediaID = var2.getItem(Configuration.CATEGORY_ITEM, "dinoPedia", 10015).getInt(10015);
		emptyShellID = var2.getItem(Configuration.CATEGORY_ITEM, "emptyShell", 10016).getInt(10016);
		magicConchID = var2.getItem(Configuration.CATEGORY_ITEM, "magicConch", 10017).getInt(10017);
		icedMeatID = var2.getItem(Configuration.CATEGORY_ITEM, "icedMeat", 10018).getInt(10018);
		woodjavelinID = var2.getItem(Configuration.CATEGORY_ITEM, "woodjavelin", 10019).getInt(10019);
		stonejavelinID = var2.getItem(Configuration.CATEGORY_ITEM, "stonejavelin", 10020).getInt(10020);
		ironjavelinID = var2.getItem(Configuration.CATEGORY_ITEM, "ironjavelin", 10021).getInt(10021);
		goldjavelinID = var2.getItem(Configuration.CATEGORY_ITEM, "goldjavelin", 10022).getInt(10022);
		diamondjavelinID = var2.getItem(Configuration.CATEGORY_ITEM, "diamondjavelin", 10023).getInt(10023);
		ancientJavelinID = var2.getItem(Configuration.CATEGORY_ITEM, "ancientJavelin", 10024).getInt(10024);
		whipID = var2.getItem(Configuration.CATEGORY_ITEM, "whip", 10025).getInt(10025);
		legBoneID = var2.getItem(Configuration.CATEGORY_ITEM, "legBone", 10026).getInt(10026);
		clawID = var2.getItem(Configuration.CATEGORY_ITEM, "claw", 10027).getInt(10027);
		footID = var2.getItem(Configuration.CATEGORY_ITEM, "foot", 10028).getInt(10028);
		skullID = var2.getItem(Configuration.CATEGORY_ITEM, "skull", 10029).getInt(10029);
		brokenSaplingID = var2.getItem(Configuration.CATEGORY_ITEM, "brokenSapling", 10030).getInt(10030);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10031).getInt(10031);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10032).getInt(10032);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10033).getInt(10033);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10034).getInt(10034);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10035).getInt(10035);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10036).getInt(10036);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10037).getInt(10037);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10038).getInt(10038);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10039).getInt(10039);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10040).getInt(10040);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10041).getInt(10041);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10042).getInt(10042);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10043).getInt(10043);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10044).getInt(10044);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10045).getInt(10045);
		//newItemID = var2.getItem(Configuration.CATEGORY_ITEM, "newItem", 10046).getInt(10046);
		
		//Armor
		skullHelmetID = var2.getItem(Configuration.CATEGORY_ITEM, "skullHelmet", 10047).getInt(10047);
		ribCageID = var2.getItem(Configuration.CATEGORY_ITEM, "ribCage", 10048).getInt(10048);
		femursID = var2.getItem(Configuration.CATEGORY_ITEM, "femurs", 10049).getInt(10049);
		feetID = var2.getItem(Configuration.CATEGORY_ITEM, "feet", 10050).getInt(10050);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10051).getInt(10051);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10052).getInt(10052);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10053).getInt(10053);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10054).getInt(10054);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10055).getInt(10055);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10056).getInt(10056);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10057).getInt(10057);
		//newArmorID = var2.getItem(Configuration.CATEGORY_ITEM, "newArmor", 10058).getInt(10058);
	
		//DNA
		//dnaID = var2.getItem(Configuration.CATEGORY_ITEM, "dna", 10059).getInt(10059);
		dnaTriceratopsID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaTriceratops", 10060).getInt(10060);
		dnaVelociraptorID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaVelociraptor", 10061).getInt(10061);
		dnaTRexID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaTRex", 10062).getInt(10062);
		dnaPterosaurID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaPterosaur", 10063).getInt(10063);
		dnaNautilusID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaNautilus", 10064).getInt(10064);
		dnaPlesiosaurID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaPlesiosaur", 10065).getInt(10065);
		dnaMosasaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMosasaurus", 10066).getInt(10066);
		dnaStegosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaStegosaurus", 10067).getInt(10067);
		dnaDilophosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaDilophosaurus", 10068).getInt(10068);
		dnaBrachiosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaBrachiosaurus", 10069).getInt(10069);
		//newDinoDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "newDinoDNA", 10070).getInt(10070);
		//newDinoDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "newDinoDNA", 10071).getInt(10071);
		//newDinoDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "newDinoDNA", 10072).getInt(10072);
		//newDinoDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "newDinoDNA", 10073).getInt(10073);
		//newDinoDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "newDinoDNA", 10074).getInt(10074);
		//newDinoDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "newDinoDNA", 10075).getInt(10075);

		//Animal DNA
		//animalDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "animalDNA", 10076).getInt(10076);
		dnaPigID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaPig", 10077).getInt(10077);
		dnaSheepID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaSheep", 10078).getInt(10078);
		dnaCowID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaCow", 10079).getInt(10079);
		dnaChickenID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaChicken", 10080).getInt(10080);
		dnaSaberCatID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaSaberCat", 10081).getInt(10081);
		dnaMammothID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10082).getInt(10082);
		
		//MobDNA
		//mobDNAID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10083).getInt(10083);
		//dnaPigZombieID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10084).getInt(10084);
		//dnaZombieID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10085).getInt(10085);
		//dnaGhastID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10086).getInt(10086);
		//dnaWitherID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10087).getInt(10087);
		//dnaSpiderID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10088).getInt(10088);
		//dnaSkeletonID = var2.getItem(Configuration.CATEGORY_ITEM, "dnaMammoth", 10089).getInt(10089);

		//Ancient Egg
		//ancienteggID = var2.getItem(Configuration.CATEGORY_ITEM, "ancientegg", 10090).getInt(10090);
		eggTriceratopsID = var2.getItem(Configuration.CATEGORY_ITEM, "eggTriceratops", 10091).getInt(10091);
		eggVelociraptorID = var2.getItem(Configuration.CATEGORY_ITEM, "eggVelociraptor", 10092).getInt(10092);
		eggTRexID = var2.getItem(Configuration.CATEGORY_ITEM, "eggTRex", 10093).getInt(10093);
		eggPterosaurID = var2.getItem(Configuration.CATEGORY_ITEM, "eggPterosaur", 10094).getInt(10094);
		shellNautilusID = var2.getItem(Configuration.CATEGORY_ITEM, "shellNautilus", 10095).getInt(10095);
		eggPlesiosaurID = var2.getItem(Configuration.CATEGORY_ITEM, "eggPlesiosaur", 10096).getInt(10096);
		eggMosasaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "eggMosasaurus", 10097).getInt(10097);
		eggStegosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "eggStegosaurus", 10098).getInt(10098);
		eggDilophosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "eggDilophosaurus", 10099).getInt(10099);
		eggBrachiosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "eggBrachiosaurus", 10100).getInt(10100);
		//eggNewID = var2.getItem(Configuration.CATEGORY_ITEM, "eggNew", 10101).getInt(10101);
		//eggNewID = var2.getItem(Configuration.CATEGORY_ITEM, "eggNew", 10102).getInt(10102);
		//eggNewID = var2.getItem(Configuration.CATEGORY_ITEM, "eggNew", 10103).getInt(10103);
		//eggNewID = var2.getItem(Configuration.CATEGORY_ITEM, "eggNew", 10104).getInt(10104);
		//eggNewID = var2.getItem(Configuration.CATEGORY_ITEM, "eggNew", 10105).getInt(10105);
		//eggNewID = var2.getItem(Configuration.CATEGORY_ITEM, "eggNew", 10106).getInt(10106);
	
		//Embryos
		//embyoSyringeID = var2.getItem(Configuration.CATEGORY_ITEM, "embyoSyringe", 10107).getInt(10107);
		embryoPigID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoPig", 10108).getInt(10108);
		embryoSheepID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoSheep", 10109).getInt(10109);
		embryoCowID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoCow", 10110).getInt(10110);
		embryoChickenID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoChicken", 10111).getInt(10111);
		embryoSaberCatID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoSaberCat", 10112).getInt(10112);
		embryoMammothID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoMammoth", 10113).getInt(10113);
		//embryoPigZombieID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoPigZombie", 10114).getInt(10114);
		//embryoZombieID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoZombie", 10115).getInt(10115);
		//embryoGhastID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoGhast", 10116).getInt(10116);
		//embryoWitherID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoWither", 10117).getInt(10117);
		//embryoSkeletonID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoSkeleton", 10118).getInt(10118);
		//embryoSpiderID = var2.getItem(Configuration.CATEGORY_ITEM, "embryoSpider", 10119).getInt(10119);
		
		//Food
		cookedChickenSoupID = var2.getItem(Configuration.CATEGORY_ITEM, "cookedChickenSoup", 10120).getInt(10120);
		rawChickenSoupID = var2.getItem(Configuration.CATEGORY_ITEM, "rawChickenSoup", 10121).getInt(10121);
		chickenEssID = var2.getItem(Configuration.CATEGORY_ITEM, "chickenEss", 10122).getInt(10122);
		sjlID = var2.getItem(Configuration.CATEGORY_ITEM, "sjl", 10123).getInt(10123);
		//rawDinoMeatID = var2.getItem(Configuration.CATEGORY_ITEM, "rawDinoMeat", 10124).getInt(10124);
		rawTriceratopsID = var2.getItem(Configuration.CATEGORY_ITEM, "rawTriceratops", 10125).getInt(10125);
		rawVelociraptorID = var2.getItem(Configuration.CATEGORY_ITEM, "rawVelociraptor", 10126).getInt(10126);
		rawTRexID = var2.getItem(Configuration.CATEGORY_ITEM, "rawTRex", 10127).getInt(10127);
		rawPterosaurID = var2.getItem(Configuration.CATEGORY_ITEM, "rawPterosaur", 10128).getInt(10128);
		rawNautilusID = var2.getItem(Configuration.CATEGORY_ITEM, "rawNautilus", 10129).getInt(10129);
		rawPlesiosaurID = var2.getItem(Configuration.CATEGORY_ITEM, "rawPlesiosaur", 10130).getInt(10130);
		rawMosasaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "rawMosasaurus", 10131).getInt(10131);
		rawStegosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "rawStegosaurus", 10132).getInt(10132);
		rawDilophosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "rawDilophosaurus", 10133).getInt(10133);
		rawBrachiosaurusID = var2.getItem(Configuration.CATEGORY_ITEM, "rawBrachiosaurus", 10134).getInt(10134);
		cookedDinoMeatID = var2.getItem(Configuration.CATEGORY_ITEM, "cookedDinoMeat", 10135).getInt(10135);
		
		Option_Gen_Palaeoraphe = var2.get("option", "Palaeoraphe", false).getBoolean(false);
		Option_Gen_Academy = var2.get("option", "Academy", true).getBoolean(true);
		Option_Gen_Ships = var2.get("option", "Ships", true).getBoolean(true);
		Option_Lang_Server = var2.get("option", "Serverlanguage", "en_US").value;
	
		}
        catch (Exception var7)
        {
            FMLLog.log(Level.SEVERE, var7, "Fossil Mod Not loading configuration", new Object[0]);
        }
        finally
        {
            var2.save();
        }
		if (event.getSide() == Side.CLIENT)
    		proxy.registerSounds();
    	UpdateLangProp(event.getSide() == Side.CLIENT);
    	/*else
    	{
    		String path="mods/Fossil-Archeology/fossil/Fossillang/";
    		System.out.println(Minecraft.getMinecraft().mcDataDir.getAbsolutePath());
    		System.out.println(path+Minecraft.getMinecraft().gameSettings.language+".lang");
    	}*/		
	}
	
	@cpw.mods.fml.common.Mod.Init
	public void Init(FMLInitializationEvent event)
	{
		//fillCreativeList();
		this.forgeHarvestLevelSetUp();
		//Blocks
		skullLantern = new BlockFossilSkull(skullLanternID, 0, true).setHardness(1.0F).setLightValue(0.9375F).setStepSound(Block.soundStoneFootstep).setBlockName("SkullLantern").setCreativeTab(this.tabFBlocks);
        blockanalyzerIdle = new BlockAnalyzer(blockanalyzerIdleID, false).setHardness(3.0F).setStepSound(Block.soundMetalFootstep).setBlockName("analyzerIdle").setCreativeTab(this.tabFBlocks);
        blockanalyzerActive = new BlockAnalyzer(blockanalyzerActiveID, true).setLightValue(0.9375F).setHardness(3.0F).setStepSound(Block.soundMetalFootstep).setBlockName("analyzerActive");
        blockcultivateIdle = new BlockCultivate(blockcultivateIdleID, false).setLightValue(0.9375F).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("cultivateIdle").setCreativeTab(this.tabFBlocks);
        blockcultivateActive = new BlockCultivate(blockcultivateActiveID, true).setLightValue(0.9375F).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("cultivateActive");
        blockworktableIdle = new BlockWorktable(blockworktableIdleID, false).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setBlockName("worktableIdle").setCreativeTab(this.tabFBlocks);
        blockworktableActive = new BlockWorktable(blockworktableActiveID, true).setHardness(2.5F).setStepSound(Block.soundWoodFootstep).setBlockName("worktableActive");
        feederIdle = new BlockFeeder(feederIdleID, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setBlockName("Feeder").setRequiresSelfNotify().setCreativeTab(this.tabFBlocks);
        feederActive = new BlockFeeder(feederActiveID, false).setHardness(3.5F).setStepSound(Block.soundStoneFootstep).setBlockName("Feeder").setRequiresSelfNotify();
        blockTimeMachine = new BlockTimeMachine(blockTimeMachineID, 0, Material.glass).setLightValue(0.9375F).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("BlockTimeMachine").setCreativeTab(this.tabFBlocks);
        /*, false*/ferns = new BlockFern(fernsID, 0).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify().setCreativeTab((CreativeTabs)null);
        //fernUpper = new BlockFern(fernUpperID, 0, true).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setRequiresSelfNotify().setCreativeTab((CreativeTabs)null);
        drum = new BlockDrum(drumID).setHardness(0.8F).setBlockName("drum").setRequiresSelfNotify().setCreativeTab(this.tabFBlocks);
        blockPermafrost = new BlockPermafrost(blockPermafrostID, 5).setHardness(0.5F).setLightOpacity(3).setStepSound(Block.soundGrassFootstep).setBlockName("Permafrost").setRequiresSelfNotify().setCreativeTab(this.tabFBlocks);
        blockIcedStone = new BlockIcedStone(blockIcedStoneID, 6).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setBlockName("IcedStone").setRequiresSelfNotify().setCreativeTab(this.tabFBlocks);
        blockFossil = new BlockFossil(blockFossilID, 1).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("fossil").setCreativeTab(this.tabFBlocks);
        blockSkull = new BlockFossilSkull(blockSkullID, 0, false).setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setBlockName("Skull").setCreativeTab(this.tabFBlocks);
        palmLog = new BlockPalmLog(palmLogID).setStepSound(Block.soundWoodFootstep).setHardness(2.0F)/*.setResistance(1.0F)*/.setBlockName("Palm Log").setRequiresSelfNotify();
        palmLeaves = new BlockPalmLeaves(palmLeavesID, 53).setStepSound(Block.soundGrassFootstep).setHardness(0.2F).setResistance(1F).setBlockName("Palm Leaves").setRequiresSelfNotify();
        palmSap = new BlockPalmSapling(palmSapID, 62).setStepSound(Block.soundGrassFootstep).setHardness(0.2F).setResistance(1F).setBlockName("Palm Sapling").setRequiresSelfNotify();
        palaePlanks = new BlockPalaePlanks(palaePlanksID, 80).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundWoodFootstep).setBlockName("palaePlanks").setRequiresSelfNotify();
        palaeDoubleSlab = (FossilSlabs)(new BlockPalaeSlab(palaeDoubleSlabID, true)).setHardness(1.6F).setResistance(7.5F).setStepSound(Block.soundWoodFootstep).setBlockName("blackWoodSlab");
        palaeSingleSlab = (FossilSlabs)(new BlockPalaeSlab(palaeSingleSlabID, false)).setHardness(1.6F).setResistance(7.5F).setStepSound(Block.soundWoodFootstep).setBlockName("blackWoodSlab").setCreativeTab(this.tabFBlocks);
        palaeStairs = new BlockPalaeStairs(palaeStairsID, palaePlanks, 80).setBlockName("blackWoodStairs").setRequiresSelfNotify();
        //volcanicAsh = new BlockVolcanicAsh(volcanicAshID, 1).setHardness(0.5F).setStepSound(Block.soundGrassFootstep).setBlockName("VolcanicAsh").setCreativeTab(this.tabFBlocks);
		//volcanicRock = new BlockVolcanicRock(volcanicRockID, 1).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("VolcanicRock").setCreativeTab(this.tabFBlocks);
		tar = new BlockTar(tarID, 22).setHardness(100.0F).setBlockName("Tar");
		Block.fire.setBurnProperties(Fossil.ferns.blockID, 30, 60);
		Block.fire.setBurnProperties(Fossil.palmLog.blockID, 5, 5);
		Block.fire.setBurnProperties(Fossil.palmLeaves.blockID, 30, 60);
		Block.fire.setBurnProperties(Fossil.palaePlanks.blockID, 5, 20);
		Block.fire.setBurnProperties(Fossil.tar.blockID, 500, 1);
		
        
        //Items
		biofossil = new ItemBioFossil(biofossilID).setIconIndex(38).setItemName("biofossil").setCreativeTab(this.tabFItems);
		relic = new ItemRelic(relicID).setIconIndex(39).setItemName("relic").setCreativeTab(this.tabFItems);
		stoneboard = new ItemStoneBoard(stoneboardID).setIconIndex(44).setItemName("stoneboard").setCreativeTab(this.tabFItems);
		ancientSword = new ItemAncientsword(ancientSwordID).setIconIndex(1).setItemName("ancientsword").setCreativeTab(this.tabFCombat);
		brokenSword = new ItemBrokenSword(brokenSwordID).setIconIndex(0).setItemName("Brokensword").setCreativeTab(this.tabFMaterial);
		fernSeed = new ItemFernSeed(fernSeedID, ferns.blockID).setIconIndex(40).setItemName("FernSeed").setCreativeTab(this.tabFItems);
		ancienthelmet = new ItemAncientHelmet(ancienthelmetID, EnumArmorMaterial.IRON, 3, 0).setIconIndex(3).setItemName("ancientHelmet").setCreativeTab(this.tabFArmor);
		brokenhelmet = new ItemBrokenHelmet(brokenhelmetID).setIconIndex(2).setItemName("BrokenHelmet").setCreativeTab(this.tabFMaterial);
		skullStick = new ForgeItem(skullStickID).setIconIndex(5).setItemName("SkullStick").setCreativeTab(this.tabFItems);
		gem = new ItemGem(gemID).setIconIndex(4).setItemName("Gem").setCreativeTab(this.tabFItems);
		gemAxe = new ForgeItemAxe(gemAxeID, EnumToolMaterial.EMERALD).setIconIndex(19).setItemName("GemAxe").setCreativeTab(this.tabFTools);
		gemPickaxe = new ForgeItemPickaxe(gemPickaxeID, EnumToolMaterial.EMERALD).setIconIndex(18).setItemName("GemPickaxe").setCreativeTab(this.tabFTools);
		gemSword = new ForgeItemSword(gemSwordID, EnumToolMaterial.EMERALD).setIconIndex(16).setItemName("GemSword").setCreativeTab(this.tabFCombat);;
		gemHoe = new ForgeItemHoe(gemHoeID, EnumToolMaterial.EMERALD).setIconIndex(20).setItemName("GemHoe").setCreativeTab(this.tabFTools);
		gemShovel = new ForgeItemSpade(gemShovelID, EnumToolMaterial.EMERALD).setIconIndex(17).setItemName("GemShovel").setCreativeTab(this.tabFTools);
		dinoPedia = new ForgeItem(dinoPediaID).setIconIndex(53).setItemName("dinopedia").setCreativeTab(this.tabFItems);
		emptyShell = new ForgeItem(emptyShellID).setIconIndex(42).setItemName("EmptyShell").setCreativeTab(this.tabFItems);
		magicConch = new ItemMagicConch(magicConchID).setIconIndex(21).setItemName("MagicConch").setCreativeTab(this.tabFTools);
		icedMeat = new ItemIcedMeat(icedMeatID, EnumToolMaterial.EMERALD).setIconIndex(57).setItemName("IcedMeat").setCreativeTab(this.tabFItems);
		woodjavelin = new ItemJavelin(woodjavelinID, EnumToolMaterial.WOOD).setIconIndex(48).setItemName("WoodJavelin").setCreativeTab(this.tabFCombat);
		stonejavelin = new ItemJavelin(stonejavelinID, EnumToolMaterial.STONE).setIconIndex(49).setItemName("StoneJavelin").setCreativeTab(this.tabFCombat);
		ironjavelin = new ItemJavelin(ironjavelinID, EnumToolMaterial.IRON).setIconIndex(50).setItemName("IronJavelin").setCreativeTab(this.tabFCombat);
		goldjavelin = new ItemJavelin(goldjavelinID, EnumToolMaterial.GOLD).setIconIndex(52).setItemName("GoldJavelin").setCreativeTab(this.tabFCombat);
		diamondjavelin = new ItemJavelin(diamondjavelinID, EnumToolMaterial.EMERALD).setIconIndex(51).setItemName("DiamondJavelin").setCreativeTab(this.tabFCombat);
		ancientJavelin = new ItemJavelin(ancientJavelinID, EnumToolMaterial.IRON).setIconIndex(64).setItemName("AncientJavelin").setCreativeTab(this.tabFCombat);
		whip = new ItemWhip(whipID).setIconIndex(65).setItemName("FossilWhip").setCreativeTab(this.tabFTools);
        legBone = new ItemLegBone(legBoneID).setIconIndex(80).setItemName("LegBone").setCreativeTab(this.tabFItems);
		claw = new ItemClaw(clawID).setIconIndex(81).setItemName("Claw").setCreativeTab(this.tabFItems);
		foot = new ItemFoot(footID).setIconIndex(82).setItemName("Foot").setCreativeTab(this.tabFItems);
		skull = new ItemSkull(skullID).setIconIndex(83).setItemName("Skull").setCreativeTab(this.tabFItems);
		brokenSapling = new ItemBrokenSapling(brokenSaplingID).setIconIndex(61).setItemName("BrokenSapling").setCreativeTab(this.tabFMaterial);
		
		//BoneArmor
		skullHelmet = new ItemSkullHelmet(skullHelmetID, dinoBone, 3, 0).setIconIndex(66).setItemName("SkullHelmet").setCreativeTab(Fossil.tabFArmor);;
		ribCage = new ItemRibCage(ribCageID, dinoBone, 3, 1).setIconIndex(67).setItemName("RibCage").setCreativeTab(Fossil.tabFArmor);;
		femurs = new ItemFemurs(femursID, dinoBone, 3, 2).setIconIndex(68).setItemName("ShinGuard").setCreativeTab(Fossil.tabFArmor);;
		feet = new ItemFeet(feetID, dinoBone, 3, 3).setIconIndex(69).setItemName("Feet").setCreativeTab(this.tabFArmor);
		
		//Ancient Egg
		//ancientegg = new ItemAncientEgg(ancienteggID);
		eggTriceratops = new ItemAncientEgg(eggTriceratopsID).setIconIndex(22).setItemName("eggTriceratops").setCreativeTab(this.tabFMaterial);
		eggVelociraptor = new ItemAncientEgg(eggVelociraptorID).setIconIndex(23).setItemName("eggVelociraptor").setCreativeTab(this.tabFMaterial);
		eggTRex = new ItemAncientEgg(eggTRexID).setIconIndex(24).setItemName("eggTRex").setCreativeTab(this.tabFMaterial);
		eggPterosaur = new ItemAncientEgg(eggPterosaurID).setIconIndex(25).setItemName("eggPterosaur").setCreativeTab(this.tabFMaterial);
		shellNautilus = new ItemAncientEgg(shellNautilusID).setIconIndex(26).setItemName("shellNautilus").setCreativeTab(this.tabFMaterial);
		eggPlesiosaur = new ItemAncientEgg(eggPlesiosaurID).setIconIndex(27).setItemName("eggPlesiosaur").setCreativeTab(this.tabFMaterial);
		eggMosasaurus = new ItemAncientEgg(eggMosasaurusID).setIconIndex(28).setItemName("eggMosasaurus").setCreativeTab(this.tabFMaterial);
		eggStegosaurus = new ItemAncientEgg(eggStegosaurusID).setIconIndex(29).setItemName("eggStegosaurus").setCreativeTab(this.tabFMaterial);
		eggDilophosaurus = new ItemAncientEgg(eggDilophosaurusID).setIconIndex(30).setItemName("eggDilophosaurus").setCreativeTab(this.tabFMaterial);
		eggBrachiosaurus = new ItemAncientEgg(eggBrachiosaurusID).setIconIndex(31).setItemName("eggBrachiosaurus").setCreativeTab(this.tabFMaterial);
		
		//DNA
		//dna = new ItemDNA(dnaID);
		dnaTriceratops = new ItemDNA(dnaTriceratopsID).setIconIndex(6).setItemName("dnaTriceratops").setCreativeTab(this.tabFMaterial);
		dnaVelociraptor = new ItemDNA(dnaVelociraptorID).setIconIndex(7).setItemName("dnaVelociraptor").setCreativeTab(this.tabFMaterial);
		dnaTRex = new ItemDNA(dnaTRexID).setIconIndex(8).setItemName("dnaTRex").setCreativeTab(this.tabFMaterial);
		dnaPterosaur = new ItemDNA(dnaPterosaurID).setIconIndex(9).setItemName("dnaPterosaur").setCreativeTab(this.tabFMaterial);
		dnaNautilus = new ItemDNA(dnaNautilusID).setIconIndex(10).setItemName("dnaNautilus").setCreativeTab(this.tabFMaterial);
		dnaPlesiosaur = new ItemDNA(dnaPlesiosaurID).setIconIndex(11).setItemName("dnaPlesiosaur").setCreativeTab(this.tabFMaterial);
		dnaMosasaurus = new ItemDNA(dnaMosasaurusID).setIconIndex(12).setItemName("dnaMosasaurus").setCreativeTab(this.tabFMaterial);
		dnaStegosaurus = new ItemDNA(dnaStegosaurusID).setIconIndex(13).setItemName("dnaStegosaurus").setCreativeTab(this.tabFMaterial);
		dnaDilophosaurus = new ItemDNA(dnaDilophosaurusID).setIconIndex(14).setItemName("dnaDilophosaurus").setCreativeTab(this.tabFMaterial);
		dnaBrachiosaurus = new ItemDNA(dnaBrachiosaurusID).setIconIndex(15).setItemName("dnaBrachiosaurus").setCreativeTab(this.tabFMaterial);

		//animalDNA
		//animalDNA = new ItemNonDinoDNA(animalDNAID);
		dnaPig = new ItemNonDinoDNA(dnaPigID).setIconIndex(70).setItemName("dnaPig").setCreativeTab(this.tabFMaterial);
		dnaSheep = new ItemNonDinoDNA(dnaSheepID).setIconIndex(71).setItemName("dnaSheep").setCreativeTab(this.tabFMaterial);
		dnaCow = new ItemNonDinoDNA(dnaCowID).setIconIndex(72).setItemName("dnaCow").setCreativeTab(this.tabFMaterial);
		dnaChicken = new ItemNonDinoDNA(dnaChickenID).setIconIndex(73).setItemName("dnaChicken").setCreativeTab(this.tabFMaterial);
		dnaSaberCat = new ItemNonDinoDNA(dnaSaberCatID).setIconIndex(74).setItemName("dnaSaberCat").setCreativeTab(this.tabFMaterial);
		dnaMammoth = new ItemNonDinoDNA(dnaMammothID).setIconIndex(75).setItemName("dnaMammoth").setCreativeTab(this.tabFMaterial);
		
		//Ebryos
		//embyoSyringe = new ItemEmbryoSyringe(embyoSyringeID);
		embryoPig = new ItemEmbryoSyringe(embryoPigID).setIconIndex(84).setItemName("embryoPig").setCreativeTab(this.tabFItems);
		embryoSheep = new ItemEmbryoSyringe(embryoSheepID).setIconIndex(85).setItemName("embryoSheep").setCreativeTab(this.tabFItems);
		embryoCow = new ItemEmbryoSyringe(embryoCowID).setIconIndex(86).setItemName("embryoCow").setCreativeTab(this.tabFItems);
		embryoChicken = new ItemEmbryoSyringe(embryoChickenID).setIconIndex(89).setItemName("embryoChicken").setCreativeTab(this.tabFItems);
		embryoSaberCat = new ItemEmbryoSyringe(embryoSaberCatID).setIconIndex(87).setItemName("embryoSaberCat").setCreativeTab(this.tabFItems);
		embryoMammoth = new ItemEmbryoSyringe(embryoMammothID).setIconIndex(88).setItemName("embryoMammoth").setCreativeTab(this.tabFItems);
		
		//Item Food
		//rawDinoMeat = new ItemDinoMeat(rawDinoMeatID, 3, 0.3F, true).setCreativeTab(this.tabFFood);
		rawTriceratops = new ItemDinoMeat(rawTriceratopsID, 3, 0.3F, true).setIconIndex(0).setItemName("Triceratops Meat").setCreativeTab(this.tabFFood);
		rawVelociraptor = new ItemDinoMeat(rawVelociraptorID, 3, 0.3F, true).setIconIndex(0).setItemName("Velociraptor Meat").setCreativeTab(this.tabFFood);
		rawTRex = new ItemDinoMeat(rawTRexID, 3, 0.3F, true).setIconIndex(0).setItemName("TRex Meat").setCreativeTab(this.tabFFood);
		rawPterosaur = new ItemDinoMeat(rawPterosaurID, 3, 0.3F, true).setIconIndex(0).setItemName("Pterosaur Meat").setCreativeTab(this.tabFFood);
		rawNautilus = new ItemDinoMeat(rawNautilusID, 3, 0.3F, true).setIconIndex(0).setItemName("Nautilus Meat").setCreativeTab(this.tabFFood);
		rawPlesiosaur = new ItemDinoMeat(rawPlesiosaurID, 3, 0.3F, true).setIconIndex(0).setItemName("Plesiosaur Meat").setCreativeTab(this.tabFFood);
		rawMosasaurus = new ItemDinoMeat(rawMosasaurusID, 3, 0.3F, true).setIconIndex(0).setItemName("Mosasaurus Meat").setCreativeTab(this.tabFFood);
		rawStegosaurus = new ItemDinoMeat(rawStegosaurusID, 3, 0.3F, true).setIconIndex(0).setItemName("Stegosaurus Meat").setCreativeTab(this.tabFFood);
		rawDilophosaurus = new ItemDinoMeat(rawDilophosaurusID, 3, 0.3F, true).setIconIndex(0).setItemName("Dilophosaurus Meat").setCreativeTab(this.tabFFood);
		rawBrachiosaurus = new ItemDinoMeat(rawBrachiosaurusID, 3, 0.3F, true).setIconIndex(0).setItemName("Brachiosaurus Meat").setCreativeTab(this.tabFFood);
		cookedDinoMeat = new ForgeItemFood(cookedDinoMeatID, 8, 0.8F, true).setIconIndex(56).setItemName("CookedDinoMeat").setCreativeTab(this.tabFFood);
		cookedChickenSoup = new ItemChickenSoup(cookedChickenSoupID).setIconIndex(60).setItemName("ChickenSoup").setMaxStackSize(1).setContainerItem(Item.bucketEmpty).setCreativeTab(this.tabFFood);
		rawChickenSoup = new ItemChickenSoup(rawChickenSoupID).setIconIndex(58).setItemName("RawChickenSoup").setMaxStackSize(1).setContainerItem(Item.bucketEmpty).setCreativeTab(this.tabFFood);
		chickenEss = new ForgeItemFood(chickenEssID, 10, 0.0F, false).setIconIndex(59).setItemName("ChickenEss").setContainerItem(Item.glassBottle).setCreativeTab(this.tabFFood);
		sjl = new ForgeItemFood(sjlID, 8, 2.0F, false).setIconIndex(43).setItemName("SioChiuLe").setCreativeTab(this.tabFFood);
		
		//make the dino types complete by registering the dinos items
		EnumDinoType.init();
		//Initiate some other things...
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.ancientJavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(),-1));
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.woodjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(),0));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.stonejavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(),1));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.ironjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(),2));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.diamondjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(),3));
		BlockDispenser.dispenseBehaviorRegistry.putObject(Fossil.goldjavelin, new BehaviorJavelinDispense(MinecraftServer.getServer(),4));
		
		//HarvestLevel
		MinecraftForge.setBlockHarvestLevel(blockFossil, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(blockPermafrost, 0, "shovel", 2);
		MinecraftForge.setBlockHarvestLevel(blockIcedStone, 0, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockIcedStone, 1, "pickaxe", 1);
		
		//Block Registry
		GameRegistry.registerBlock(blockFossil, "fossil_blockFossil");
		GameRegistry.registerBlock(blockSkull, "fossil_blockSkull");
	 	GameRegistry.registerBlock(skullLantern, "fossil_SkullLantern");
		GameRegistry.registerBlock(blockanalyzerIdle, "fossil_blockanalyzerIdle");
		GameRegistry.registerBlock(blockanalyzerActive, "fossil_blockanalyzerActive");
		GameRegistry.registerBlock(blockcultivateIdle, "fossil_blockcultivateIdle");
		GameRegistry.registerBlock(blockcultivateActive, "fossil_blockcultivateActive");
		GameRegistry.registerBlock(blockworktableIdle, "fossil_blockworktableIdle");
		GameRegistry.registerBlock(blockworktableActive, "fossil_blockworktableActive");
		GameRegistry.registerBlock(ferns, "fossil_Ferns");
		//GameRegistry.registerBlock(fernUpper, "fossil_FernUpper");
		GameRegistry.registerBlock(drum, "fossil_Dump");
		GameRegistry.registerBlock(feederIdle, "fossil_FeederIdle");
		GameRegistry.registerBlock(feederActive, "fossil_FeederActive");
		GameRegistry.registerBlock(blockPermafrost, "fossil_blockPermafrost");
		GameRegistry.registerBlock(blockIcedStone, "fossil_blockIcedStone");
		GameRegistry.registerBlock(blockTimeMachine, "blockTimeMachine");
		GameRegistry.registerBlock(palmLog, "palmLog");
		GameRegistry.registerBlock(palmLeaves, "palmLeaves");
		GameRegistry.registerBlock(palmSap, "palmSap");
		GameRegistry.registerBlock(palaeSingleSlab, "palaeSingleSlab");
		GameRegistry.registerBlock(palaeDoubleSlab, "palaeDoubleSlab");
		GameRegistry.registerBlock(palaeStairs, "palaeStairs");
		GameRegistry.registerBlock(palaePlanks, "palaePlanks");

		//GameRegistry.registerBlock(volcanicAsh, "VolcanicAsh");
		//GameRegistry.registerBlock(volcanicRock, "VolcanicRock");
		GameRegistry.registerBlock(tar, "Tar");
		
		//Items & Block Names
        LanguageRegistry.addName(blockFossil, GetLangTextByKey("Block.Fossil.Name"));//"Block Fossil");
        LanguageRegistry.addName(blockSkull, GetLangTextByKey("Block.Skull.Name"));
        LanguageRegistry.addName(skullLantern, GetLangTextByKey("Block.SkullLantern.Name"));
        LanguageRegistry.addName(blockanalyzerIdle, GetLangTextByKey("Block.Analyzer.Name"));
        LanguageRegistry.addName(blockcultivateIdle, GetLangTextByKey("Block.CultureVat.Name"));
        LanguageRegistry.addName(blockworktableIdle, GetLangTextByKey("Block.Workbench.Name"));
        LanguageRegistry.addName(feederIdle, GetLangTextByKey("Block.Feeder.Name"));
        LanguageRegistry.addName(drum, GetLangTextByKey("Block.Drum.Name"));
        LanguageRegistry.addName(blockPermafrost, GetLangTextByKey("Block.Permafrost.Name"));
        LanguageRegistry.addName(blockIcedStone, GetLangTextByKey("Block.IcedStone.Name"));
        LanguageRegistry.addName(blockTimeMachine, GetLangTextByKey("Block.TimeMachine.Name"));
        LanguageRegistry.addName(tar, GetLangTextByKey("Block.Tar.Name"));
		LanguageRegistry.addName(palmLog, GetLangTextByKey("Block.PalLog.Name"));
        LanguageRegistry.addName(palmLeaves, GetLangTextByKey("Block.PalLeaves.Name"));
		LanguageRegistry.addName(palmSap, GetLangTextByKey("Block.PalSap.Name"));
		LanguageRegistry.addName(palaePlanks, GetLangTextByKey("Block.PalPlank.Name"));
		LanguageRegistry.addName(palaeSingleSlab, "palaeSingleSlab");
		LanguageRegistry.addName(palaeDoubleSlab, "palaeDoubleSlab");
		LanguageRegistry.addName(palaeStairs, "palaeStairs");
		//LanguageRegistry.addName(volcanicAsh, "Volcanic Ash");
		//LanguageRegistry.addName(volcanicRock, "Volcanic Rock");
        
        LanguageRegistry.addName(biofossil, GetLangTextByKey("Item.BioFossil.Name"));
        LanguageRegistry.addName(relic, GetLangTextByKey("Item.Relic.Name"));
        LanguageRegistry.addName(stoneboard, GetLangTextByKey("Item.Tablet.Name"));
        LanguageRegistry.addName(brokenSword, GetLangTextByKey("Item.BrokenSword.Name"));
        LanguageRegistry.addName(ancientSword, GetLangTextByKey("Item.AncientSword.Name"));
        LanguageRegistry.addName(fernSeed, GetLangTextByKey("Item.FernSeeds.Name"));
        LanguageRegistry.addName(brokenhelmet, GetLangTextByKey("Item.BrokenHelmet.Name"));
        LanguageRegistry.addName(ancienthelmet, GetLangTextByKey("Item.AncientHelmet.Name"));
        LanguageRegistry.addName(skullStick, GetLangTextByKey("Item.SkullStick.Name"));
        LanguageRegistry.addName(gem, GetLangTextByKey("Item.Gem.Name"));
        LanguageRegistry.addName(gemAxe, GetLangTextByKey("Item.ScarabAxe.Name"));
        LanguageRegistry.addName(gemPickaxe, GetLangTextByKey("Item.ScarabPickAxe.Name"));
        LanguageRegistry.addName(gemSword, GetLangTextByKey("Item.ScarabSword.Name"));
        LanguageRegistry.addName(gemHoe, GetLangTextByKey("Item.ScarabHoe.Name"));
        LanguageRegistry.addName(gemShovel, GetLangTextByKey("Item.ScarabShovel.Name"));
        LanguageRegistry.addName(dinoPedia, GetLangTextByKey("Item.DinoPedia.Name"));
        LanguageRegistry.addName(emptyShell, GetLangTextByKey("Item.Shell.Name"));
        LanguageRegistry.addName(magicConch, GetLangTextByKey("Item.MagicConch.Name"));
		
		LanguageRegistry.addName(legBone, GetLangTextByKey("Item.LegBone.Name"));
		LanguageRegistry.addName(claw, GetLangTextByKey("Item.Claw.Name"));
		LanguageRegistry.addName(foot, GetLangTextByKey("Item.Foot.Name"));
		LanguageRegistry.addName(skull, GetLangTextByKey("Item.Skull.Name"));
		LanguageRegistry.addName(brokenSapling, GetLangTextByKey("Item.BrokenSapling.Name"));
		LanguageRegistry.addName(skullHelmet, GetLangTextByKey("Item.SkullHelmet.Name"));
		LanguageRegistry.addName(ribCage, GetLangTextByKey("Item.RibCage.Name"));
		LanguageRegistry.addName(femurs, GetLangTextByKey("Item.Femurs.Name"));
		LanguageRegistry.addName(feet, GetLangTextByKey("Item.Feet.Name"));
		
        LanguageRegistry.addName(icedMeat, GetLangTextByKey("Item.IcedMeat.Name"));
        LanguageRegistry.addName(woodjavelin, GetLangTextByKey("Item.WoodJavelin.Name"));
        LanguageRegistry.addName(stonejavelin, GetLangTextByKey("Item.StoneJavelin.Name"));
        LanguageRegistry.addName(ironjavelin, GetLangTextByKey("Item.IronJavelin.Name"));
        LanguageRegistry.addName(diamondjavelin, GetLangTextByKey("Item.DiamondJavelin.Name"));
        LanguageRegistry.addName(goldjavelin, GetLangTextByKey("Item.GoldJavelin.Name"));
        LanguageRegistry.addName(ancientJavelin, GetLangTextByKey("Item.AncientJavelin.Name"));
        LanguageRegistry.addName(whip, GetLangTextByKey("Item.Whip.Name"));
		
		LanguageRegistry.addName(sjl, GetLangTextByKey("Item.SJL.Name"));
		LanguageRegistry.addName(chickenEss, GetLangTextByKey("Item.EOC.Name"));
		LanguageRegistry.addName(cookedChickenSoup, GetLangTextByKey("Item.CookedChickenSoup.Name"));
		LanguageRegistry.addName(rawChickenSoup, GetLangTextByKey("Item.RawChickenSoup.Name"));
		
		LanguageRegistry.addName(cookedDinoMeat, GetLangTextByKey("Item.DinoSteak.Name"));
		LanguageRegistry.addName(rawTriceratops, GetLangTextByKey("Item.rawTriceratops.Name"));
        LanguageRegistry.addName(rawVelociraptor, GetLangTextByKey("Item.rawVelociraptor.Name"));
        LanguageRegistry.addName(rawTRex, GetLangTextByKey("Item.rawTRex.Name"));
        LanguageRegistry.addName(rawPterosaur, GetLangTextByKey("Item.rawPterosaur.Name"));
        LanguageRegistry.addName(rawNautilus, GetLangTextByKey("Item.rawNautilus.Name"));
        LanguageRegistry.addName(rawPlesiosaur, GetLangTextByKey("Item.rawPlesiosaur.Name"));
        LanguageRegistry.addName(rawMosasaurus, GetLangTextByKey("Item.rawMosasaurus.Name"));
        LanguageRegistry.addName(rawStegosaurus, GetLangTextByKey("Item.rawStegosaurus.Name"));
        LanguageRegistry.addName(rawDilophosaurus, GetLangTextByKey("Item.rawDilophosaurus.Name"));
        LanguageRegistry.addName(rawBrachiosaurus, GetLangTextByKey("Item.rawBrachiosaurus.Name"));
        
		
		//Ancient Egg
		LanguageRegistry.addName(eggTriceratops, GetLangTextByKey("Item.eggTriceratops.Name"));
		LanguageRegistry.addName(eggVelociraptor, GetLangTextByKey("Item.eggVelociraptor.Name"));
		LanguageRegistry.addName(eggTRex, GetLangTextByKey("Item.eggTRex.Name"));
		LanguageRegistry.addName(eggPterosaur, GetLangTextByKey("Item.eggPterosaur.Name"));
		LanguageRegistry.addName(shellNautilus, GetLangTextByKey("Item.shellNautilus.Name"));
		LanguageRegistry.addName(eggPlesiosaur, GetLangTextByKey("Item.eggPlesiosaur.Name"));
		LanguageRegistry.addName(eggMosasaurus, GetLangTextByKey("Item.eggMosasaurus.Name"));
		LanguageRegistry.addName(eggStegosaurus, GetLangTextByKey("Item.eggStegosaurus.Name"));
		LanguageRegistry.addName(eggDilophosaurus, GetLangTextByKey("Item.eggDilophosaurus.Name"));
		LanguageRegistry.addName(eggBrachiosaurus, GetLangTextByKey("Item.eggBrachiosaurus.Name"));
		
		//DNA
		LanguageRegistry.addName(dnaTriceratops, GetLangTextByKey("Item.dnaTriceratops.Name"));
		LanguageRegistry.addName(dnaTRex, GetLangTextByKey("Item.dnaTRex.Name"));
		LanguageRegistry.addName(dnaVelociraptor, GetLangTextByKey("Item.dnaVelociraptor.Name"));
		LanguageRegistry.addName(dnaPterosaur, GetLangTextByKey("Item.dnaPterosaur.Name"));
		LanguageRegistry.addName(dnaNautilus, GetLangTextByKey("Item.dnaNautilus.Name"));
		LanguageRegistry.addName(dnaPlesiosaur, GetLangTextByKey("Item.dnaPlesiosaur.Name"));
		LanguageRegistry.addName(dnaMosasaurus, GetLangTextByKey("Item.dnaMosasaurus.Name"));
		LanguageRegistry.addName(dnaStegosaurus, GetLangTextByKey("Item.dnaStegosaurus.Name"));
		LanguageRegistry.addName(dnaDilophosaurus, GetLangTextByKey("Item.dnaDilophosaurus.Name"));
		LanguageRegistry.addName(dnaBrachiosaurus, GetLangTextByKey("Item.dnaBrachiosaurus.Name"));
		
		LanguageRegistry.addName(dnaPig, GetLangTextByKey("Item.dnaPig.Name"));
		LanguageRegistry.addName(dnaSheep, GetLangTextByKey("Item.dnaSheep.Name"));
		LanguageRegistry.addName(dnaCow, GetLangTextByKey("Item.dnaCow.Name"));
		LanguageRegistry.addName(dnaChicken, GetLangTextByKey("Item.dnaChicken.Name"));
		LanguageRegistry.addName(dnaSaberCat, GetLangTextByKey("Item.dnaSaberCat.Name"));
		LanguageRegistry.addName(dnaMammoth, GetLangTextByKey("Item.dnaMammoth.Name"));
		
		//Embryo
		LanguageRegistry.addName(embryoPig, GetLangTextByKey("Item.embryoPig.Name"));
		LanguageRegistry.addName(embryoSheep, GetLangTextByKey("Item.embryoSheep.Name"));
		LanguageRegistry.addName(embryoCow, GetLangTextByKey("Item.embryoCow.Name"));
		LanguageRegistry.addName(embryoChicken, GetLangTextByKey("Item.embryoChicken.Name"));
		LanguageRegistry.addName(embryoSaberCat, GetLangTextByKey("Item.embryoSaberCat.Name"));
		LanguageRegistry.addName(embryoMammoth, GetLangTextByKey("Item.embryoMammoth.Name"));

		GameRegistry.addRecipe(new ItemStack(skullLantern, 1), new Object[] {"X", "Y", 'X', blockSkull, 'Y', Block.torchWood});
		GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 5, 15), new Object[] {"X", 'X', blockSkull});
		GameRegistry.addRecipe(new ItemStack(Item.dyePowder, 5, 15), new Object[] {"X", 'X', skullLantern});
		GameRegistry.addRecipe(new ItemStack(blockcultivateIdle, 1), new Object[] {"XYX", "XWX", "ZZZ", 'X', Block.glass, 'Y', new ItemStack(Item.dyePowder, 1, 2), 'W', Item.bucketWater, 'Z', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(blockanalyzerIdle, 1), new Object[] {"XYX", "XWX", 'X', Item.ingotIron, 'Y', relic, 'W', biofossil});
		GameRegistry.addRecipe(new ItemStack(blockworktableIdle, 1), new Object[] {"X", "Y", 'X', Item.paper, 'Y', Block.workbench});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggTriceratops});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggVelociraptor});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggTRex});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggPterosaur});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.shellNautilus});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggPlesiosaur});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggMosasaurus});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggStegosaurus});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggBrachiosaurus});
		GameRegistry.addRecipe(new ItemStack(Item.cake, 1), new Object[] {"AAA", "BEB", "CCC", 'A', Item.bucketMilk, 'B', Item.sugar, 'C', Item.wheat, 'E', this.eggDilophosaurus});
		GameRegistry.addRecipe(new ItemStack(skullStick, 1), new Object[] {"X", "Y", 'X', blockSkull, 'Y', Item.stick});
		GameRegistry.addRecipe(new ItemStack(drum, 1), new Object[] {"ZZZ", "XYX", "XXX", 'X', Block.planks, 'Y', Item.redstone, 'Z', Item.leather});
		GameRegistry.addRecipe(new ItemStack(feederIdle, 1), new Object[] {"XYX", "ZAB", "BBB", 'X', Item.ingotIron, 'Y', Block.glass, 'Z', Block.stoneButton, 'A', Item.bucketEmpty, 'B', Block.stone});
		GameRegistry.addShapelessRecipe(new ItemStack(gemAxe), new Object[] {Item.axeWood, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemAxe), new Object[] {Item.axeStone, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemAxe), new Object[] {Item.axeSteel, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemAxe), new Object[] {Item.axeGold, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemAxe), new Object[] {Item.axeDiamond, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemPickaxe), new Object[] {Item.pickaxeWood, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemPickaxe), new Object[] {Item.pickaxeStone, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemPickaxe), new Object[] {Item.pickaxeSteel, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemPickaxe), new Object[] {Item.pickaxeGold, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemPickaxe), new Object[] {Item.pickaxeDiamond, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemHoe), new Object[] {Item.hoeWood, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemHoe), new Object[] {Item.hoeStone, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemHoe), new Object[] {Item.hoeSteel, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemHoe), new Object[] {Item.hoeGold, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemHoe), new Object[] {Item.hoeDiamond, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemSword), new Object[] {Item.swordWood, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemSword), new Object[] {Item.swordStone, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemSword), new Object[] {Item.swordSteel, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemSword), new Object[] {Item.swordGold, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemSword), new Object[] {Item.swordDiamond, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemShovel), new Object[] {Item.shovelWood, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemShovel), new Object[] {Item.shovelStone, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemShovel), new Object[] {Item.shovelSteel, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemShovel), new Object[] {Item.shovelGold, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(gemShovel), new Object[] {Item.shovelDiamond, gem});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaTriceratops});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaBrachiosaurus});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaMosasaurus});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaStegosaurus});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaPterosaur});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaPlesiosaur});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaTRex});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaDilophosaurus});
		GameRegistry.addShapelessRecipe(new ItemStack(dinoPedia), new Object[] {Item.book, dnaVelociraptor});
		GameRegistry.addShapelessRecipe(new ItemStack(rawChickenSoup, 1, 0), new Object[] {Item.bucketEmpty, Item.chickenRaw});
		//GameRegistry.addShapelessRecipe(new ItemStack(magicConch, 1, 1), new Object[] {new ItemStack(magicConch, 1, 0)});
		//GameRegistry.addShapelessRecipe(new ItemStack(magicConch, 1, 2), new Object[] {new ItemStack(magicConch, 1, 1)});
		//GameRegistry.addShapelessRecipe(new ItemStack(magicConch, 1, 0), new Object[] {new ItemStack(magicConch, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(chickenEss, 8), new Object[] {"XXX", "XYX", "XXX", 'X', Item.glassBottle, 'Y', cookedChickenSoup});
		GameRegistry.addRecipe(new ItemStack(whip, 1), new Object[] {"XXS", "XTS", "TXS", 'T', Item.stick, 'S', Item.silk});
		
		GameRegistry.addRecipe(new ItemStack(palaePlanks, 4), new Object[] {"P", 'P', this.palmLog});
		GameRegistry.addRecipe(new ItemStack(Block.woodenButton, 1), new Object[] {"P", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Item.stick, 3), new Object[] { "P", "P", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Block.pressurePlatePlanks, 1), new Object[] { "PP", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Item.boat, 1), new Object[] { "PXP", "PPP", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Item.bowlEmpty, 3), new Object[] { "PXP", "XPX", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Block.workbench, 1), new Object[] { "PP", "PP", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Item.doorWood, 1), new Object[] {"PPX", "PPX", "PPX", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Block.trapdoor, 2), new Object[] { "PPP", "PPP", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(Block.chest, 1), new Object[] {"PPP", "PXP", "PPP", 'P', this.palaePlanks});
		
		GameRegistry.addRecipe(new ItemStack(Item.shovelWood, 1), new Object[] {"P", "S", "S", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.swordWood, 1), new Object[] {"P", "P", "S", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1), new Object[] {"PP", "XS", "XS", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.hoeWood, 1), new Object[] {"PP", "SX", "SX", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1), new Object[] {"PP", "PS", "XS", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.axeWood, 1), new Object[] {"PP", "SP", "SX", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.pickaxeWood, 1), new Object[] {"PPP", "XSX", "XSX", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Block.fenceGate, 1), new Object[] { "SPS", "SPS", 'P', this.palaePlanks, 'S', Item.stick});
		GameRegistry.addRecipe(new ItemStack(Item.sign, 3), new Object[] {"PPP", "PPP", "XSX", 'P', this.palaePlanks, 'S', Item.stick});
		
		GameRegistry.addRecipe(new ItemStack(Item.bed, 1), new Object[] { "WWW", "PPP", 'P', this.palaePlanks, 'W',blockanalyzerActive.cloth});
		GameRegistry.addRecipe(new ItemStack(Block.jukebox, 1), new Object[] {"PPP", "PDP", "PPP", 'P', this.palaePlanks, 'D', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(Block.music, 1), new Object[] {"PPP", "PRP", "PPP", 'P', this.palaePlanks, 'R', Item.redstone});
		GameRegistry.addRecipe(new ItemStack(Block.pistonBase, 1), new Object[] {"PPP", "CIC", "CRC", 'P', this.palaePlanks, 'R', Item.redstone, 'I',Item.ingotIron,'C',Block.cobblestone});
		GameRegistry.addRecipe(new ItemStack(Block.bookShelf, 1), new Object[] {"PPP", "BBB", "PPP", 'P', this.palaePlanks, 'B', Item.book});
		
		GameRegistry.addRecipe(new ItemStack(palaeSingleSlab, 6), new Object[] {"PPP", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(palaeStairs, 4), new Object[] {"P  ", "PP ", "PPP", 'P', this.palaePlanks});
		GameRegistry.addRecipe(new ItemStack(palaeStairs, 4), new Object[] {"  P", " PP", "PPP", 'P', this.palaePlanks});
		
		GameRegistry.addRecipe(new ItemStack(feet, 1), new Object[] {"* *","# #", '#', this.foot, '*', this.claw});
		GameRegistry.addRecipe(new ItemStack(femurs, 1), new Object[] {"###","* *","# #", '#', Item.bone,'*', this.legBone});
		GameRegistry.addRecipe(new ItemStack(ribCage, 1), new Object[] {"# #"," # ","###", '#', Item.bone});
		GameRegistry.addRecipe(new ItemStack(skullHelmet, 1), new Object[] {"#X#","# #", '#', Item.bone,'X', Fossil.skull});
		
        GameRegistry.addSmelting(rawChickenSoup.itemID, new ItemStack(cookedChickenSoup), 3.0F);
        //GameRegistry.addSmelting(rawDinoMeat.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawTriceratops.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawStegosaurus.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawVelociraptor.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawDilophosaurus.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawTRex.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawPlesiosaur.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawPterosaur.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawMosasaurus.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(rawBrachiosaurus.itemID, new ItemStack(cookedDinoMeat), 3.0F);
        GameRegistry.addSmelting(icedMeat.itemID, new ItemStack(Item.beefCooked), 3.0F);
		
		EntityRegistry.registerModEntity(EntityStoneboard.class, 		"StoneBoard", 			1, this, 250, 5, false);
		EntityRegistry.registerModEntity(EntityJavelin.class, 			"Javelin", 				2, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityAncientJavelin.class, 	"AncientJavelin", 		3, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityMLighting.class, 		"FriendlyLighting", 	4, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityFailuresaurus.class, 	"Failuresaurus", 		5, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityBones.class, 			"Bones", 				6, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityNautilus.class, 			"Nautilus", 			7, this, 250, 5, true);
		EntityRegistry.addSpawn(EntityNautilus.class, 5, 4, 14, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river,BiomeGenBase.ocean});
		EntityRegistry.registerModEntity(EntityDinoEgg.class, 			"DinoEgg", 				8, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityVelociraptor.class, 		"Velociraptor", 		9, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityTriceratops.class, 		"Triceratops", 			10, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityTRex.class, 				"Tyrannosaurus", 		11, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityFriendlyPigZombie.class, "FriendlyPigZombie", 	12, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityPigBoss.class, 			"PigBoss", 				13, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityPterosaur.class, 		"Pterosaur", 			14, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityPlesiosaur.class, 		"Plesiosaur", 			15, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityMosasaurus.class, 		"Mosasaurus", 			16, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityStegosaurus.class, 		"Stegosaurus", 			17, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityDilophosaurus.class, 	"Dilophosaurus", 		18, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityPregnantSheep.class, 	"PregnantSheep", 		19, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityPregnantCow.class, 		"PregnantCow", 			20, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityPregnantPig.class, 		"PregnantPig", 			21, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntitySaberCat.class, 			"SaberCat", 			22, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityBrachiosaurus.class, 	"Brachiosaurus", 		23, this, 250, 5, true);
		EntityRegistry.registerModEntity(EntityMammoth.class, 			"Mammoth", 				24, this, 250, 5, true);

		
		GameRegistry.registerWorldGenerator(new FossilGenerator());
		GameRegistry.registerWorldGenerator(new TarGenerator());
		//GameRegistry.registerWorldGenerator(new WorldGenPalaeoraphe());//not needed?
		if(Fossil.Option_Gen_Ships==true)
			GameRegistry.registerWorldGenerator(new WorldGenShips());
		if(Fossil.Option_Gen_Academy==true)
			GameRegistry.registerWorldGenerator(new WorldGenAcademy());
		//GameRegistry.registerWorldGenerator(new WorldGenBigShip());
		//GameRegistry.registerWorldGenerator(new WorldGenCheheWreck());
		//GameRegistry.registerWorldGenerator(new WorldGenVikingWreck());
		//GameRegistry.registerWorldGenerator(new WorldGenShortRangeWreck());
		//GameRegistry.registerWorldGenerator(new WorldGenShipWreck180());
		//GameRegistry.registerWorldGenerator(new WorldGenShipWreck270());
		//GameRegistry.registerWorldGenerator(new WorldGenShipWreck90());
		//GameRegistry.registerWorldGenerator(new WorldGenGalleonWreck());
		if(Fossil.Option_Gen_Palaeoraphe==true)
			GameRegistry.registerWorldGenerator(new WorldGeneratorPalaeoraphe());
		GameRegistry.registerWorldGenerator(new WorldGenWeaponShop());

		NetworkRegistry.instance().registerChatListener(messagerHandler);
		NetworkRegistry.instance().registerGuiHandler(this, GH);

		GameRegistry.registerTileEntity(TileEntityCultivate.class, "Cultivate");
		GameRegistry.registerTileEntity(TileEntityAnalyzer.class, "Analyzer");
		GameRegistry.registerTileEntity(TileEntityWorktable.class, "Worktable");
		GameRegistry.registerTileEntity(TileEntityDrum.class, "Drum");
		GameRegistry.registerTileEntity(TileEntityFeeder.class, "Feeder");
		GameRegistry.registerTileEntity(TileEntityTimeMachine.class, "TimeMachine");
		
		proxy.registerTileEntitySpecialRenderer();
        proxy.registerRenderThings();
        
	}
	
	/*public static void fillCreativeList()
    {
        int var2 = 0;
        int var0;

        for (var0 = 0; var0 < EnumDinoType.values().length; ++var0)
        {
            MultiTotalList[var2++] = new ItemStack(dna, 1, var0);
        }

        for (var0 = 0; var0 < EnumDinoType.values().length; ++var0)
        {
            MultiTotalList[var2++] = new ItemStack(ancientegg, 1, var0);
        }

        for (var0 = 0; var0 < EnumDinoType.values().length; ++var0)
        {
            MultiTotalList[var2++] = new ItemStack(rawDinoMeat, 1, var0);
        }

        int var1;

        for (var1 = 0; var1 < EnumAnimalType.values().length; ++var1)
        {
            MultiTotalList[var2++] = new ItemStack(animalDNA, 1, var1);
        }

        for (var1 = 0; var1 < EnumEmbyos.values().length; ++var1)
        {
            MultiTotalList[var2++] = new ItemStack(embyoSyringe, 1, var1);
        }

        for (var1 = 0; var1 < 2; ++var1)
        {
            MultiTotalList[var2++] = new ItemStack(chickenSoup, 1, var1);
        }

        SingleTotalList = new ItemStack[] {new ItemStack(blockFossil, 1, 0), new ItemStack(blockSkull, 1, 0), new ItemStack(skullLantern, 1, 0), new ItemStack(blockanalyzerIdle, 1, 0), new ItemStack(blockcultivateIdle, 1, 0), new ItemStack(blockworktableIdle, 1, 0), new ItemStack(ferns, 1, 0), new ItemStack(drum, 1, 0), new ItemStack(feederIdle, 1, 0), new ItemStack(blockPermafrost, 1, 0), new ItemStack(blockIcedStone, 1, 0)};
    }*/
	
    private void forgeHarvestLevelSetUp()
    {
        MinecraftForge.setBlockHarvestLevel(blockFossil, 0, "pickaxe", 2);
        MinecraftForge.setBlockHarvestLevel(blockPermafrost, 0, "shovel", 2);
        MinecraftForge.setBlockHarvestLevel(blockIcedStone, 0, "pickaxe", 1);
        MinecraftForge.setBlockHarvestLevel(blockIcedStone, 1, "pickaxe", 1);
    }
	
	public static String GetLangTextByKey(String var0)
	{
		String var1 = LangProps.getProperty(var0, "");
		if(var1=="" && DebugMode)
				System.err.println("Error finding language key entry: " + var0);
		//if(var1=="")
		//	var1="--Empty--";
		return var1;
	}

	public static void ShowMessage(String var0, EntityPlayer var1)
	{
			if (var1 != null)
			{
				//var1.getTranslator().currentLanguage==>Use to give each Player the language messages he needs if possible
    			var1.addChatMessage(var0);
			}
	}

	public static void DebugMessage(String var0)
	{
			 if (DebugMode)
		{
    			System.out.println(var0);
		}
	}

	/*public static int EnumToInt(EnumOrderType var0)
	{// NOT NEEDED BY ANYONE==>USE .ordinal
			return var0.ToInt();
	}*/

	public static void UpdateLangProp(boolean opt)//true=client, false=server
	{
		//Thread.currentThread().getContextClassLoader().getResourceAsStream(".");
			try
			{
				String path;
				if(DebugMode)
					path="resources/Fossillang/";
				else
					path="mods/Fossil-Archeology/fossil/Fossillang/";
				BufferedReader var2;
				if(opt)//client
					var2 = new BufferedReader(new FileReader(new File(Minecraft.getMinecraftDir(), path+Minecraft.getMinecraft().gameSettings.language+".lang")));
				else//server
					var2 = new BufferedReader(new FileReader(new File(".", path+Fossil.Option_Lang_Server+".lang")));
				for (String var3 = var2.readLine(); var3 != null; var3 = var2.readLine())
				{
		    		if (!var3.startsWith("#"))
		    		{
		        		String[] var4 = var3.split("=");
		        		if (var4 != null && var4.length == 2)
		        			LangProps.setProperty(var4[0].trim(), new String(var4[1].trim().getBytes(),"UTF-8"));
		    		}
				}
				
				//Complete the key list with the en_US language File
				if(opt)//client
					var2 = new BufferedReader(new FileReader(new File(Minecraft.getMinecraftDir(), path+"en_US.lang")));
				else//server
					var2 = new BufferedReader(new FileReader(new File(".", path+"en_US.lang")));
				for (String var3 = var2.readLine(); var3 != null; var3 = var2.readLine())
				{
		    		if (!var3.startsWith("#"))
		    		{
		        		String[] var4 = var3.split("=");
		        		if (var4 != null && var4.length == 2 && LangProps.getProperty(var4[0].trim(), "")=="")
		        			LangProps.setProperty(var4[0].trim(), new String(var4[1].trim().getBytes(),"UTF-8"));
		    		}
				}
			}
			catch(FileNotFoundException e)
			{//Try to load the en_US File if the language file doesn't exist
				System.err.println("Error loading language file: " + e.getMessage()+" Using en_US instead.");//+ file);
				try
				{
					String path;
					if(DebugMode)
						path="resources/Fossillang/";
					else
						path="mods/Fossil-Archeology/fossil/Fossillang/";
					BufferedReader var2;
					if(opt)//client
						var2 = new BufferedReader(new FileReader(new File(Minecraft.getMinecraftDir(), path+"en_US.lang")));
					else//server
						var2 = new BufferedReader(new FileReader(new File(".", path+"en_US.lang")));
					for (String var3 = var2.readLine(); var3 != null; var3 = var2.readLine())
					{
			    		if (!var3.startsWith("#"))
			    		{
			        		String[] var4 = var3.split("=");
			        		if (var4 != null && var4.length == 2)
			        			LangProps.setProperty(var4[0].trim(), new String(var4[1].trim().getBytes(),"UTF-8"));
			    		}
					}
				}
				catch(FileNotFoundException f)
				{
					System.err.println("Error loading en_US file: " + f.getMessage()+" No Language!!!");//+ file);
				}
				catch(IOException f)//IOException e)
				{
					System.err.println("Error loading language file: " + f.getMessage());//+ file);
				}
				catch(NullPointerException f)//IOException e)
				{
					System.err.println("Error loading language file: " + f.getMessage());//+ file);
				}
			}
			catch(IOException e)//IOException e)
			{
				System.err.println("Error loading language file: " + e.getMessage());//+ file);
			}
			catch(NullPointerException e)//IOException e)
			{
				System.err.println("Error loading language file: " + e.getMessage());//+ file);
			}
	}

	/*private static void UTF8Reader(Properties var0)
	{
		System.out.println("LANGUAGE: "+Minecraft.getMinecraft().gameSettings.language);

		try
		{
			//InputStream i0=Fossil.class.getResourceAsStream(file);
			//BufferedReader var2 = new BufferedReader(new InputStreamReader(Fossil.class.getResourceAsStream(file), "UTF-8"));
			BufferedReader var2 = new BufferedReader(new FileReader(file));
			for (String var3 = var2.readLine(); var3 != null; var3 = var2.readLine())//"/Fossillang/" + var1 + ".lang"
			{
	    		var3 = var3.trim();
	
	    		if (!var3.startsWith("#"))
	    		{
	        		String[] var4 = var3.split("=");
	        		if (var4 != null && var4.length == 2)
	        		{
	        			var0.setProperty(var4[0], var4[1]);
	        			if(Fossil.DebugMode)
	        				System.out.println("SUCCESS: "+var4[0]+" added");
	        		}
	    		}
			}
		}
		catch(IOException e)
		{
			System.err.println("Error loading language file: " + e.getMessage());
		}
	}*/

	/*private void SetupOptions()
	{
		boolean var1 = false;

		try
		{
			Properties var2 = FossilCfgLoader.loadOptionConfig();
			Properties var3 = new Properties();

			if (var2 != null)
			{
				String var4;

				if (var2.containsKey("AnuSpawn") && !var1)
				{
					var4 = var2.getProperty("AnuSpawn");

					if (FossilOptions.isNegtiveWord(var4))
					{
						FossilOptions.ShouldAnuSpawn = false;
					}
				}

				if (var2.containsKey("SpawnShipWrecks") && !var1)
				{
					var4 = var2.getProperty("SpawnShipWrecks");

					if (FossilOptions.isNegtiveWord(var4))
					{
						FossilOptions.SpawnShipwrecks = false;
					}
				}

        if (var2.containsKey("SpawnWeaponShop") && !var1)
        {
            var4 = var2.getProperty("SpawnWeaponShop");

            if (FossilOptions.isNegtiveWord(var4))
            {
                FossilOptions.SpawnWeaponShop = false;
            }
        }

        if (var2.containsKey("SpawnAcademy") && !var1)
        {
            var4 = var2.getProperty("SpawnAcademy");

            if (FossilOptions.isNegtiveWord(var4))
            {
                FossilOptions.SpawnAcademy = false;
            }
        }

        if (var2.containsKey("DinoGrows") && !var1)
        {
            var4 = var2.getProperty("DinoGrows");

            if (FossilOptions.isNegtiveWord(var4))
            {
                FossilOptions.DinoGrows = false;
            }
        }

        if (var2.containsKey("DinoHunger") && !var1)
        {
            var4 = var2.getProperty("DinoHunger");

            if (FossilOptions.isNegtiveWord(var4))
            {
                FossilOptions.DinoHunger = false;
            }
        }

        if (var2.containsKey("TRexBreakingBlocks") && !var1)
        {
            var4 = var2.getProperty("TRexBreakingBlocks");

            if (FossilOptions.isNegtiveWord(var4))
            {
                FossilOptions.TRexBreakingBlocks = false;
            }
        }

        if (var2.containsKey("BraBreakingBlocks") && !var1)
        {
            var4 = var2.getProperty("BraBreakingBlocks");

            if (FossilOptions.isNegtiveWord(var4))
            {
                FossilOptions.BraBreakingBlocks = false;
            }
        }
    }

    var3.setProperty("AnuSpawn", FossilOptions.ShouldAnuSpawn ? "true" : "false");
    var3.setProperty("SpawnShipWrecks", FossilOptions.SpawnShipwrecks ? "true" : "false");
    var3.setProperty("SpawnWeaponShop", FossilOptions.SpawnWeaponShop ? "true" : "false");
    var3.setProperty("SpawnAcademy", FossilOptions.SpawnAcademy ? "true" : "false");
    var3.setProperty("DinoGrows", FossilOptions.DinoGrows ? "true" : "false");
    var3.setProperty("DinoHunger", FossilOptions.DinoHunger ? "true" : "false");
    var3.setProperty("TRexBreakingBlocks", FossilOptions.TRexBreakingBlocks ? "true" : "false");
    var3.setProperty("BraBreakingBlocks", FossilOptions.BraBreakingBlocks ? "true" : "false");
    var3.setProperty("PalaeorapheSpawn", FossilOptions.PalaeorapheSpawn ? "true" : "false");
    FossilCfgLoader.saveOptionConfig(var3);
    
		}
		catch (IOException var5)
		{
			;
		}
	}*/

	/*public static String GetEmbyoName(EnumEmbyos var0)
	{
		String var1 = "";

		switch (var0.ordinal())
		{
        	case 1:
        	case 2:
        	case 3:
            var1 = " " + StringTranslate.getInstance().translateNamedKey("entity." + var0.toString()).toString();
            break;

        	default:
            var1 = GetLangTextByKey("AnimalType." + var0.toString());
		}

		return var1;
	}*/
	
	@cpw.mods.fml.common.Mod.PostInit
	public void PostInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
