package igoodie.igoodiesfarm.handlers.overrides;

import igoodie.igoodiesfarm.items.type.GoodiesFarmItemFood;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GoodiesFarmTooltipOverrides 
{
	private float getSatAmount(Item item)
	{
		float result = 0.0f;
		if(item instanceof ItemFood)
		{
			float satK = ((ItemFood) item).func_150906_h(new ItemStack(item));
			float hung = ((ItemFood) item).func_150905_g(new ItemStack(item));
			result = (float) (Math.floor((2*satK * hung)*100) / 100.0);			
		}
		else if(item instanceof GoodiesFarmItemFood)
		{
			float satK = ((GoodiesFarmItemFood) item).func_150906_h(new ItemStack(item));
			float hung = ((GoodiesFarmItemFood) item).func_150905_g(new ItemStack(item));
			result = (float) (Math.floor((2*satK * hung)*100) / 100.0);	
		}
		
		return result;
	}

	@SubscribeEvent
	public void overrideAppleTooltip(ItemTooltipEvent event)
	{
		Item curItem = event.itemStack.getItem();
		if(curItem instanceof ItemFood)
		{
			event.toolTip.add(
					event.toolTip.size(),
					EnumChatFormatting.GOLD + "Saturation +" + getSatAmount((ItemFood)event.itemStack.getItem()));
		}
		else if(curItem instanceof GoodiesFarmItemFood)
		{
			event.toolTip.add(
					event.toolTip.size(),
					EnumChatFormatting.GOLD + "Saturation +" + getSatAmount((GoodiesFarmItemFood)event.itemStack.getItem()));
		}
		else if(curItem == Items.cake)
		{
			event.toolTip.add(
					event.toolTip.size(),
					EnumChatFormatting.GOLD + "Saturation +0.4 per slice");
		}
	}

	@SubscribeEvent
	public void tooltipDurabilities(ItemTooltipEvent event)
	{
		if(event.itemStack.getItem().isDamageable())
		{
			int damageTook = event.itemStack.getItemDamage();
			int damageMax = event.itemStack.getMaxDamage();
			int curDurability = damageMax - damageTook;

			event.toolTip.add(
					event.toolTip.size(),
					EnumChatFormatting.DARK_GRAY + "Durability: "+curDurability+"/"+damageMax);
		}
	}
}
