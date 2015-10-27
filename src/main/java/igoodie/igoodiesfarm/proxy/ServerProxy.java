package igoodie.igoodiesfarm.proxy;

import igoodie.igoodiesfarm.entities.TileEntityBlackberryBush;
import igoodie.igoodiesfarm.handlers.GoodiesFarmDropHandlers;
import igoodie.igoodiesfarm.handlers.GoodiesFarmHoeHandler;
import igoodie.igoodiesfarm.handlers.overrides.GoodiesFarmTooltipOverrides;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy 
{
	public void init(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new GoodiesFarmDropHandlers());
		MinecraftForge.EVENT_BUS.register(new GoodiesFarmTooltipOverrides());
		MinecraftForge.EVENT_BUS.register(new GoodiesFarmHoeHandler());
	}
	
	public void registerRenderThings() {}
	
	public void registerTileEntitySpecialRenderer() {}
	
	public void initClientHandlers() {}
}
