package igoodie.igoodiesfarm.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class GoodiesFarmItems 
{
	public static ItemRawMutton itemRawMutton = new ItemRawMutton();
	public static ItemCookedMutton itemCookedMutton = new ItemCookedMutton();
	public static ItemBlackberry itemBlackberry = new ItemBlackberry();
	public static ItemBlueberry itemBlueberry = new ItemBlueberry();
	public static ItemRaspberry itemRaspberry = new ItemRaspberry();
	
	private static void initRecipes()
	{
		GameRegistry.addSmelting(itemRawMutton, new ItemStack(itemCookedMutton), 0.1f);
	}
	
	private static void initSeeds()
	{
		//MinecraftForge.addGrassSeed(new ItemStack(Items.apple), 1);
		//MinecraftForge.addGrassSeed(new ItemStack(Items.carrot), 100);
	}
	
	public static void init()
	{
		GameRegistry.registerItem(itemRawMutton, "itemRawMutton");
		GameRegistry.registerItem(itemCookedMutton, "itemCookedMutton");
		GameRegistry.registerItem(itemBlackberry, "itemBlackberry");
		GameRegistry.registerItem(itemBlueberry, "itemBlueberry");
		GameRegistry.registerItem(itemRaspberry, "itemRaspberry");
		
		initRecipes();
		initSeeds();
	}
}
