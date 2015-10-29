package igoodie.igoodiesfarm.items.type;

import igoodie.igoodiesfarm.tabs.GoodiesFarmTab;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

public class GoodiesFarmItemSeed extends ItemSeeds
{
	public GoodiesFarmItemSeed(Block crop, Block soil) 
	{
		super(crop, soil);
		this.setCreativeTab(GoodiesFarmTab.instance);
	}
	
}
