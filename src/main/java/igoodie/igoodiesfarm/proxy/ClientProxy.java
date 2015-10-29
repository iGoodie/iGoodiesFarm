package igoodie.igoodiesfarm.proxy;

import igoodie.igoodiesfarm.GoodiesFarmConfig;
import igoodie.igoodiesfarm.client.gui.GuiHealthBar;
import igoodie.igoodiesfarm.client.gui.GuiSaturationBar;
import igoodie.igoodiesfarm.client.renderers.RendererBush;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;

//@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		/*TileEntitySpecialRenderer renderBlackberryBush = new RenderBlackberryBush();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlackberryBush.class, renderBlackberryBush);
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(GoodiesFarmBlocks.blockBlackberryBush), 
				new RenderInventoryBush(renderBlackberryBush, new TileEntityBlackberryBush()));*/
		RendererBush renderBush = new RendererBush();
		RenderingRegistry.registerBlockHandler(renderBush.id, renderBush);
	}

	public void registerTileEntitySpecialRenderer()
	{

	}
	
	public void initClientHandlers()
	{
		if(GoodiesFarmConfig.isCustomHUDEnabled)
		{
			MinecraftForge.EVENT_BUS.register(new GuiHealthBar(Minecraft.getMinecraft()));
			MinecraftForge.EVENT_BUS.register(new GuiSaturationBar(Minecraft.getMinecraft()));			
		}
	}
}
