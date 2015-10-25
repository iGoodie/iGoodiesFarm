package igoodie.igoodiesfarm;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import igoodie.igoodiesfarm.blocks.GoodiesFarmBlocks;
import igoodie.igoodiesfarm.client.gui.GuiHealthBar;
import igoodie.igoodiesfarm.client.gui.GuiSaturationBar;
import igoodie.igoodiesfarm.entities.TileEntityBlackberryBush;
import igoodie.igoodiesfarm.handlers.GoodiesFarmGuiHandler;
import igoodie.igoodiesfarm.handlers.overrides.GoodiesFarmTooltipOverrides;
import igoodie.igoodiesfarm.items.GoodiesFarmItems;
import igoodie.igoodiesfarm.proxy.ClientProxy;
import igoodie.igoodiesfarm.proxy.ServerProxy;
import igoodie.igoodiesfarm.tabs.GoodiesFarmTab;
import igoodie.igoodiesfarm.worldgen.GenBushes;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=References.MOD_ID, name=References.MOD_NAME, version=References.MOD_VERSION)
public class GoodiesFarmMod 
{
	@Mod.Instance(References.MOD_ID)
	public static GoodiesFarmMod instance = new GoodiesFarmMod();

	@SidedProxy(modId=References.MOD_ID, clientSide=References.PROXY_CLIENT, serverSide=References.PROXY_SERVER)
	public static ServerProxy proxy;

	@Mod.EventHandler
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
		
		GameRegistry.registerWorldGenerator(new GenBushes(), 1);
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GoodiesFarmGuiHandler());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		if(GoodiesFarmConfig.isCustomHUDEnabled)
		{
			MinecraftForge.EVENT_BUS.register(new GuiHealthBar(Minecraft.getMinecraft()));
			MinecraftForge.EVENT_BUS.register(new GuiSaturationBar(Minecraft.getMinecraft()));			
		}
	}
}
