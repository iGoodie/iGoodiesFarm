package igoodie.igoodiesfarm.handlers;

import java.util.Random;

import igoodie.igoodiesfarm.items.GoodiesFarmItems;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;


public class GoodiesFarmDropHandlers 
{	
	@SubscribeEvent
	public void onSheepKilled(LivingDropsEvent event)
	{	
		if(event.entityLiving instanceof EntitySheep && !event.entityLiving.isChild())
		{
			Random chance = new Random();
			int rand = chance.nextInt(2);
			if(event.entityLiving.isBurning())
			{
				event.entityLiving.dropItem(GoodiesFarmItems.itemCookedMutton, rand);
			}
			else
			{
				event.entityLiving.dropItem(GoodiesFarmItems.itemRawMutton, rand);					
			}
		}
	}
}
