package igoodie.igoodiesfarm.client.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

@SideOnly(Side.CLIENT)
public class GuiHealthBar extends Gui
{
private Minecraft mc;
	
	public GuiHealthBar(Minecraft mc)
	{
		super();
		this.mc = mc;
	}
	
	@SubscribeEvent
	public void onOverlayDraw(RenderGameOverlayEvent event)
	{
		EntityClientPlayerMP player = mc.thePlayer;
		int width = event.resolution.getScaledWidth();
		int height = event.resolution.getScaledHeight();
		int health = (int)player.getHealth();
		int armor = (int)player.getTotalArmorValue();
		
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE || this.mc.playerController.isInCreativeMode())
		{
			return;
		}
		
		String healthStr = "Health: "+Integer.toString((int)health);

		if(armor == 0)
		{
			int posX = mc.fontRenderer.getStringWidth(healthStr)+100;
			
			StringWithStroke.draw(
					healthStr, 
					(width-posX)/2, 
					height-49, 
					0,
					16716563);
		}
		else
		{
			if(Integer.toString(health).length() == 1)
			{
				StringWithStroke.draw(
						Integer.toString(health), 
						(width-196)/2, 
						height-38, 
						0,
						16716563);
			}
			else if(Integer.toString(health).length() == 2)
			{
				StringWithStroke.draw(
						Integer.toString(health), 
						(width-208)/2, 
						height-38, 
						0,
						16716563);
			}
			else
			{
				StringWithStroke.draw(
						Integer.toString(health), 
						(width-220)/2, 
						height-38, 
						0,
						16716563);
			}
			/////////////////////////////////////////////////////////////
			if(Integer.toString(armor).length() == 1)
			{
				StringWithStroke.draw(
						Integer.toString(armor), 
						(width-196)/2, 
						height-48, 
						0,
						12106180);
			}
			else if(Integer.toString(armor).length() == 2)
			{
				StringWithStroke.draw(
						Integer.toString(armor), 
						(width-208)/2, 
						height-48, 
						0,
						12106180);
			}
			else
			{
				
			}
		}
	}
}
