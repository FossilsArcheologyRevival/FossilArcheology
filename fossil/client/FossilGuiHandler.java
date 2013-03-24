package fossil.client;

import fossil.entity.mob.EntityDinosaurce;
import fossil.guiBlocks.ContainerAnalyzer;
import fossil.guiBlocks.ContainerCultivate;
import fossil.guiBlocks.ContainerFeeder;
import fossil.guiBlocks.ContainerPedia;
import fossil.guiBlocks.ContainerTimeMachine;
import fossil.guiBlocks.ContainerWorktable;
import fossil.guiBlocks.GuiAnalyzer;
import fossil.guiBlocks.GuiCultivate;
import fossil.guiBlocks.GuiFeeder;
import fossil.guiBlocks.GuiPedia;
import fossil.guiBlocks.GuiTimeMachine;
import fossil.guiBlocks.GuiWorktable;
import fossil.guiBlocks.TileEntityAnalyzer;
import fossil.guiBlocks.TileEntityCultivate;
import fossil.guiBlocks.TileEntityFeeder;
import fossil.guiBlocks.TileEntityTimeMachine;
import fossil.guiBlocks.TileEntityWorktable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class FossilGuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		switch(id)
		{

		case 0: return new ContainerAnalyzer(player.inventory, (TileEntityAnalyzer) tile_entity);
		case 1: return new ContainerCultivate(player.inventory, (TileEntityCultivate) tile_entity);
		case 2: return new ContainerFeeder(player.inventory, (TileEntityFeeder) tile_entity);
		case 3: return new ContainerWorktable(player.inventory, (TileEntityWorktable) tile_entity);
		case 4: return new ContainerPedia();
		case 5: return new ContainerTimeMachine(player.inventory, (TileEntityTimeMachine) tile_entity);
		
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{

		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

		switch(id)
		{

		case 0: return new GuiAnalyzer(player.inventory, (TileEntityAnalyzer) tile_entity);
		case 1: return new GuiCultivate(player.inventory, (TileEntityCultivate) tile_entity);
		case 2: return new GuiFeeder(player.inventory, (TileEntityFeeder) tile_entity);
		case 3: return new GuiWorktable(player.inventory, (TileEntityWorktable) tile_entity);
		case 4: return new GuiPedia(/*player.inventory/*, EntityDinosaurce.pediaingDino, world*/);
		case 5: return new GuiTimeMachine(player.inventory, (TileEntityTimeMachine) tile_entity);
		
		}

		return null;

	}
}
