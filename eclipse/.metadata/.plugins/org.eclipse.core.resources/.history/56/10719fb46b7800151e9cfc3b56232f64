package igoodie.igoodiesfarm.handlers;

import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GoodiesFarmHoeHandler 
{
	@SubscribeEvent
	public void onHoeRightClick(UseHoeEvent event)
	{
		int x = event.x;
		int y = event.y;
		int z = event.z;
		event.world.setBlock(x, y, z, Blocks.farmland);
	}
}
