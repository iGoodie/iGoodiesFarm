package igoodie.igoodiesfarm.blocks;

import igoodie.igoodiesfarm.entities.TileEntityBlackberryBush;
import igoodie.igoodiesfarm.entities.TileEntityBlueberryBush;
import igoodie.igoodiesfarm.entities.TileEntityRaspberryBush;
import cpw.mods.fml.common.registry.GameRegistry;

public class GoodiesFarmBlocks 
{
	public static BlockBlackberryBush blockBlackberryBush = new BlockBlackberryBush();
	public static BlockBlueberryBush blockBlueberryBush = new BlockBlueberryBush();
	public static BlockRaspberryBush blockRaspberryBush = new BlockRaspberryBush();
	
	public static void init()
	{
		//Register Blocks
		GameRegistry.registerBlock(blockBlackberryBush, "blockBlackberryBush");
		GameRegistry.registerBlock(blockBlueberryBush, "blockBlueberryBush");
		GameRegistry.registerBlock(blockRaspberryBush, "blockRaspberryBush");
		
		
		//Register TileEntities
		GameRegistry.registerTileEntity(TileEntityBlackberryBush.class, "igoodiesfarm:TileEntityBlackberryBush");
		GameRegistry.registerTileEntity(TileEntityBlueberryBush.class, "igoodiesfarm:TileEntityBlueberryBush");
		GameRegistry.registerTileEntity(TileEntityRaspberryBush.class, "igoodiesfarm:TileEntityRaspberryBush");
	}
}
