package igoodie.igoodiesfarm.items;

import igoodie.igoodiesfarm.tabs.GoodiesFarmTab;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCookedMutton extends ItemFood
{
	public ItemCookedMutton()
	{
		super(6, 5.0f, true);
		this.setCreativeTab(GoodiesFarmTab.instance);
		this.setMaxStackSize(64);
		this.setUnlocalizedName("itemCookedMutton");
		this.setTextureName("itemCookedMutton");
		
		this.bFull3D = true;
	}
	
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
