package igoodie.igoodiesfarm.tabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import igoodie.igoodiesfarm.References;
import igoodie.igoodiesfarm.items.GoodiesFarmItems;
import igoodie.igoodiesfarm.items.ItemRawMutton;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class GoodiesFarmTab extends CreativeTabs
{
	public static GoodiesFarmTab instance = new GoodiesFarmTab();

	public GoodiesFarmTab() 
	{
		super(CreativeTabs.getNextID(), References.MOD_ID);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() 
	{
		return GoodiesFarmItems.itemRawMutton;
	}

	@Override
	public boolean hasSearchBar()
	{
		return true;
	}
	
	@Override
	public int getSearchbarWidth()
    {
        return 50;
    }

}
