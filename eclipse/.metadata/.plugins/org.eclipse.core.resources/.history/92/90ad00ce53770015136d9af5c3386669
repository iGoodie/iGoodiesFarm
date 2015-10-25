package igoodie.igoodiesfarm;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class GoodiesFarmConfig 
{
	public static boolean isCustomHUDEnabled; 
	
	public static void init(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		isCustomHUDEnabled = config.get("HUD", "DisplayCustomHUD", true).getBoolean(true);
		
		config.save();
	}
}
