package igoodie.igoodiesfarm.proxy;

import igoodie.igoodiesfarm.GoodiesFarmConfig;
import igoodie.igoodiesfarm.blocks.GoodiesFarmBlocks;
import igoodie.igoodiesfarm.client.gui.GuiHealthBar;
import igoodie.igoodiesfarm.client.gui.GuiSaturationBar;
import igoodie.igoodiesfarm.client.renderers.RenderBlackberryBush;
import igoodie.igoodiesfarm.client.renderers.RenderBlueberryBush;
import igoodie.igoodiesfarm.client.renderers.RenderRaspberryBush;
import igoodie.igoodiesfarm.client.renderersinventory.RenderInventoryBush;
import igoodie.igoodiesfarm.entities.TileEntityBlackberryBush;
import igoodie.igoodiesfarm.entities.TileEntityBlueberryBush;
import igoodie.igoodiesfarm.entities.TileEntityRaspberryBush;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;

//@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		//All the blackberry bush rendering
		TileEntitySpecialRenderer renderBlackberryBush = new RenderBlackberryBush();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlackberryBush.class, renderBlackberryBush);
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(GoodiesFarmBlocks.blockBlackberryBush), 
				new RenderInventoryBush(renderBlackberryBush, new TileEntityBlackberryBush()));
		
		//All the blueberry bush rendering
		TileEntitySpecialRenderer renderBlueberryBush = new RenderBlueberryBush();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlueberryBush.class, renderBlueberryBush);
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(GoodiesFarmBlocks.blockBlueberryBush), 
				new RenderInventoryBush(renderBlackberryBush, new TileEntityBlackberryBush()));
		
		//All the raspberry bush rendering
		TileEntitySpecialRenderer renderRaspberryBush = new RenderRaspberryBush();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRaspberryBush.class, renderRaspberryBush);
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(GoodiesFarmBlocks.blockRaspberryBush), 
				new RenderInventoryBush(renderBlackberryBush, new TileEntityBlackberryBush()));
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
