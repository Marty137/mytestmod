package mytestmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
		
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		if(tile_entity instanceof TileEntityNuggetWasher){
				return new ContainerNuggetWasher(player.inventory, (TileEntityNuggetWasher) tile_entity);
		}		
		return null;
	}
	

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z){
		
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		if(tile_entity instanceof TileEntityNuggetWasher)
			{
			return new GuiNuggetWasher(player.inventory, (TileEntityNuggetWasher) tile_entity);
			}		
		return null;
	}

}
