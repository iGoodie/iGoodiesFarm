package igoodie.igoodiesfarm.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import igoodie.igoodiesfarm.items.type.GoodiesFarmItemFood;
import igoodie.igoodiesfarm.tabs.GoodiesFarmTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemBlueberry extends GoodiesFarmItemFood
{
	public ItemBlueberry() 
	{
		super(1, 0.5f, false, 8);
		this.setCreativeTab(GoodiesFarmTab.instance);
		this.setUnlocalizedName("itemBlueberry");
		this.setTextureName("itemBlueberry");
		this.setMaxStackSize(64);
		this.setAlwaysEdible();
	}
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
    {
    	list.add(EnumChatFormatting.GRAY + "You can eat this even if you're not hungry.");
    	list.add(EnumChatFormatting.GRAY + "It will increase your" + EnumChatFormatting.GOLD + " saturation.");
    }
}
