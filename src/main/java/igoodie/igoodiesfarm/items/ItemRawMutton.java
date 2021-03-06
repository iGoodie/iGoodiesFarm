package igoodie.igoodiesfarm.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import igoodie.igoodiesfarm.tabs.GoodiesFarmTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemRawMutton extends ItemFood
{
	public ItemRawMutton() 
	{
		super(1, 1.0f, true);
		this.setCreativeTab(GoodiesFarmTab.instance);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("itemRawMutton");
		this.setTextureName("itemRawMutton");

		//@SideOnly(Side.CLIENT)
		this.bFull3D = true;
	}

	//@SideOnly(Side.CLIENT)
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onEaten(stack, world, player);
		player.inventory.addItemStackToInventory(new ItemStack(Items.bone, 1));
		return stack;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) 
	{
		list.add(EnumChatFormatting.GRAY + "The bone in it will still remain");
		list.add(EnumChatFormatting.GRAY + "after being eaten.");
	}
}
