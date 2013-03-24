package fossil.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import fossil.CommonProxy;
import fossil.entity.EntityAncientJavelin;
import fossil.entity.EntityDinoEgg;
import fossil.entity.EntityJavelin;
import fossil.entity.EntityStoneboard;
import fossil.entity.RenderDinoEgg;
import fossil.entity.RenderJavelin;
import fossil.entity.RenderStoneboard;
import fossil.entity.mob.EntityBones;
import fossil.entity.mob.EntityBrachiosaurus;
import fossil.entity.mob.EntityFailuresaurus;
import fossil.entity.mob.EntityFriendlyPigZombie;
import fossil.entity.mob.EntityMammoth;
import fossil.entity.mob.EntityMosasaurus;
import fossil.entity.mob.EntityNautilus;
import fossil.entity.mob.EntityPigBoss;
import fossil.entity.mob.EntityPlesiosaur;
import fossil.entity.mob.EntityPregnantPig;
import fossil.entity.mob.EntityPterosaur;
import fossil.entity.mob.EntityVelociraptor;
import fossil.entity.mob.EntitySaberCat;
import fossil.entity.mob.EntityStegosaurus;
import fossil.entity.mob.EntityTRex;
import fossil.entity.mob.EntityTriceratops;
import fossil.entity.mob.EntityDilophosaurus;
import fossil.entity.mob.ModelFailuresaurus;
import fossil.entity.mob.ModelMammoth;
import fossil.entity.mob.ModelNautilus;
import fossil.entity.mob.ModelPigBoss;
import fossil.entity.mob.ModelPterosaurGround;
import fossil.entity.mob.ModelVelociraptor;
import fossil.entity.mob.ModelSaberCat;
import fossil.entity.mob.ModelStegosaurus;
import fossil.entity.mob.ModelTRex;
import fossil.entity.mob.ModelTriceratops;
import fossil.entity.mob.ModelDilophosaurus;
import fossil.entity.mob.RenderBrachiosaurus;
import fossil.entity.mob.RenderFailuresaurus;
import fossil.entity.mob.RenderMammoth;
import fossil.entity.mob.RenderMosasaurus;
import fossil.entity.mob.RenderNautilus;
import fossil.entity.mob.RenderPigBoss;
import fossil.entity.mob.RenderPlesiosaur;
import fossil.entity.mob.RenderPterosaur;
import fossil.entity.mob.RenderVelociraptor;
import fossil.entity.mob.RenderSaberCat;
import fossil.entity.mob.RenderStegosaurus;
import fossil.entity.mob.RenderTRex;
import fossil.entity.mob.RenderTriceratops;
import fossil.entity.mob.RenderDilophosaurus;
import fossil.guiBlocks.RenderTNClock;
import fossil.guiBlocks.TileEntityTimeMachine;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{
		
		MinecraftForgeClient.preloadTexture("/fossil/textures/Fos_terrian.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Fos_items.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/AncientJavelin.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Brachiosaurus.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/DiamondJavelin.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/dinoegg.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/DinoModelBrachiosaurus.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/DinoModelPlesiosaur.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/DinoModelPterosaur.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/DinoModelTriceratops.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/DNA4.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture1.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture2.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture3.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture4.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture5.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture6.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture7.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture8.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/eggTexture9.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Failuresaurus.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/GoldJavelin.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/IronJavelin.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/MammothAdult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/MammothFur.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/MammothFurless.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/MammothYoung.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Mosasaurus.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Nautilus.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/PigBoss_Charging.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/PigBoss_r.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/PigBoss.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/PigBossCharged_r.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Plesiosaur_adult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/pr1.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Pterosaur.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Raptor_Adult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Raptor_Baby.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/raptor_blue_adult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/raptor_blue_Baby.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/raptor_green_adult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/raptor_green_Baby.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Raptor_Tamed.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/RenderPassMosasaurus.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/SaberCat_Adult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/SaberCat_Young.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Stegosaurus_Adult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Stegosaurus_Baby.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/StoneJavelin.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/T_mac_o.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/TextureAncientHalmet.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/TRex.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/TRex_Adult.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/TRexWeak.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Tri_Hurt.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Adult_1.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Adult_2.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Adult_3.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Baby_1.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Baby_2.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Baby_3.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Tamed.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Teen_1.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Teen_2.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/Triceratops_Teen_3.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/UIAnalyzer.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/UICultivate.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/UIFeeder.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/UIPazzle.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/UtaAttack.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/UtaCalm.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/WoodenJavelin.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/TMGui.png");
		MinecraftForgeClient.preloadTexture("/fossil/textures/TNClock.png");
		
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityStoneboard.class, new RenderStoneboard());
		RenderingRegistry.registerEntityRenderingHandler(EntityTriceratops.class, new RenderTriceratops(new ModelTriceratops(), new ModelTriceratops(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderVelociraptor(new ModelVelociraptor(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityTRex.class, new RenderTRex(new ModelTRex(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFailuresaurus.class, new RenderFailuresaurus(new ModelFailuresaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPigBoss.class, new RenderPigBoss(new ModelPigBoss(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityFriendlyPigZombie.class, new RenderBiped(new ModelZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPterosaur.class, new RenderPterosaur(new ModelPterosaurGround(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, new RenderNautilus(new ModelNautilus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPlesiosaur.class, new RenderPlesiosaur(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMosasaurus.class, new RenderMosasaurus(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityStegosaurus.class, new RenderStegosaurus(new ModelStegosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDinoEgg.class, new RenderDinoEgg(1.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPregnantPig.class, new RenderPig(new ModelPig(), new ModelPig(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDilophosaurus.class, new RenderDilophosaurus(new ModelDilophosaurus(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntitySaberCat.class, new RenderSaberCat(new ModelSaberCat(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, new RenderJavelin());
		RenderingRegistry.registerEntityRenderingHandler(EntityAncientJavelin.class, new RenderJavelin());
		RenderingRegistry.registerEntityRenderingHandler(EntityBones.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBrachiosaurus.class, new RenderBrachiosaurus(0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMammoth.class, new RenderMammoth(new ModelMammoth(), 0.5F));

		RenderingRegistry.registerBlockHandler(new FossilBlockRenderHandler());
		
	}
	
	@Override
	public void registerTileEntitySpecialRenderer()
	{
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeMachine.class, new RenderTNClock());
	}
	
	@Override
	public void registerSounds()
	{
		MinecraftForge.EVENT_BUS.register(new DinoSoundHandler());
	}
	
}
