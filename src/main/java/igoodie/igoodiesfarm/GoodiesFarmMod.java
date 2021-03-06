package igoodie.igoodiesfarm;

import igoodie.igoodiesfarm.blocks.GoodiesFarmBlocks;
import igoodie.igoodiesfarm.items.GoodiesFarmItems;
import igoodie.igoodiesfarm.proxy.ServerProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
public class GoodiesFarmMod 
{
	@Mod.Instance(References.MOD_ID)
	public static GoodiesFarmMod instance = new GoodiesFarmMod();

	@SidedProxy(modId=References.MOD_ID, clientSide=References.PROXY_CLIENT, serverSide=References.PROXY_SERVER)
	public static ServerProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		GoodiesFarmConfig.init(event);
		proxy.init(event);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		GoodiesFarmItems.init();
		GoodiesFarmBlocks.init();
		proxy.registerRenderThings();
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GoodiesFarmGuiHandler());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		proxy.initClientHandlers();
	}
}
