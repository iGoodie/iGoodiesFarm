package igoodie.igoodiesfarm.blocks;

import cpw.mods.fml.common.registry.GameRegistry;


public class GoodiesFarmBlocks 
{
	public static BlockBlackberryBush blockBlackberryBush = new BlockBlackberryBush();
	public static BlockBlueberryBush blockBlueberryBush = new BlockBlueberryBush();
	public static BlockRaspberryBush blockRaspberryBush = new BlockRaspberryBush();
	
	public static void init()
	{
		GameRegistry.registerBlock(blockBlackberryBush, "blockBlackberryBush");
		GameRegistry.registerBlock(blockBlueberryBush, "blockBlueberryBush");
		GameRegistry.registerBlock(blockRaspberryBush, "blockRaspberryBush");
	}
}
