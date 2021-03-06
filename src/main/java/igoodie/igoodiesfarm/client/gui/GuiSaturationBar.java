package igoodie.igoodiesfarm.client.gui;

import java.util.Collection;

import org.lwjgl.opengl.GL11;

import scala.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSaturationBar extends Gui
{
	private Minecraft mc;

	public GuiSaturationBar(Minecraft mc)
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
		int saturation = (int)player.getFoodStats().getSaturationLevel();
		int breath = player.getAir();

		if(event.isCancelable() || event.type != ElementType.EXPERIENCE || this.mc.playerController.isInCreativeMode())
		{
			return;
		}

		String saturationStr = "Saturation: " + Integer.toString(saturation);
		if(!this.mc.thePlayer.isInsideOfMaterial(Material.water))
		{
			if(Integer.toString(saturation).length() == 1 && saturation != 0)
			{
				StringWithStroke.draw(
						saturationStr, 
						(width+36)/2, 
						height-49, 
						0,
						16749885);
			}
			else if(Integer.toString(saturation).length() == 2 && saturation != 0)
			{
				StringWithStroke.draw(
						saturationStr, 
						(width+30)/2, 
						height-49, 
						0,
						16749885);
			}
			else if(saturation == 0)
			{
				StringWithStroke.draw(
						saturationStr, 
						(width+36)/2, 
						height-49, 
						0,
						10592673);
			}
		}
		else if(this.mc.thePlayer.isInsideOfMaterial(Material.water) && !player.isDead)
		{
			if(saturation == 0)
			{
				StringWithStroke.draw(
						Integer.toString(saturation), 
						(width+186)/2, 
						height-38, 
						0,
						10592673);
			}
			else
			{
				StringWithStroke.draw(
						Integer.toString(saturation), 
						(width+186)/2, 
						height-38, 
						0,
						16749885);				
			}


			if(breath > 0)
			{
				StringWithStroke.draw(
						Integer.toString(breath), 
						(width+186)/2, 
						height-48, 
						0,
						5683455);
			}
			else
			{
				if(breath <= -10)
				{
					StringWithStroke.draw(
							"0", 
							(width+186)/2, 
							height-48, 
							0,
							5683455);					
				}
				else if(breath <= 0)
				{
					StringWithStroke.draw(
							"0", 
							(width+186)/2, 
							height-48, 
							0,
							9228287);		
				}
			}

		}


	}
}
