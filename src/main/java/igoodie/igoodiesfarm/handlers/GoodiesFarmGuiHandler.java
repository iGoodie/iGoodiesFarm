package igoodie.igoodiesfarm.handlers;

import igoodie.igoodiesfarm.GoodiesFarmMod;
import igoodie.igoodiesfarm.client.gui.GuiSaturationBar;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GoodiesFarmGuiHandler implements IGuiHandler
{
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		//player.openGui(GoodiesFarmMod.instance, ID, world, x, y, z);
		//return new GuiSaturationBar();
		return null;
	}
	
}
