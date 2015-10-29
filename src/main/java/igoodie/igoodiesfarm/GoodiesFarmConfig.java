package igoodie.igoodiesfarm;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class GoodiesFarmConfig 
{
	public static boolean isCustomHUDEnabled; 
	public static boolean generateBerryBushes;
	public static int generateBerryBushesEveryXChunks;
	
	public static void init(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		//HUD
		isCustomHUDEnabled = config.getBoolean("Display Custom HUD", "hud", true, "Custom HUD includes Saturation status and numeric values of player.");

		//World-gen
		generateBerryBushes = config.get("world-gen", "Enable Berry Bush Generation", true).getBoolean();
		generateBerryBushesEveryXChunks = config.get("world-gen", "Generate Nodes of Berry Bushes Every X Chunks", 9).getInt();
		
		config.save();
	}
}
