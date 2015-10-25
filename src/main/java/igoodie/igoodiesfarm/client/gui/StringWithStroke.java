package igoodie.igoodiesfarm.client.gui;

import cpw.mods.fml.client.FMLClientHandler;

public class StringWithStroke 
{
	public static void draw(String str, int width, int height, int strokeColor, int mainColor)
	{
		FMLClientHandler.instance().getClient().fontRenderer.drawString(
				str, 
				width-1,
				height,
				strokeColor,
				false);	
		FMLClientHandler.instance().getClient().fontRenderer.drawString(
				str, 
				width,
				height-1,
				strokeColor,
				false);	
		FMLClientHandler.instance().getClient().fontRenderer.drawString(
				str, 
				width+1,
				height,
				strokeColor,
				false);	
		FMLClientHandler.instance().getClient().fontRenderer.drawString(
				str, 
				width,
				height+1,
				strokeColor,
				false);	
		FMLClientHandler.instance().getClient().fontRenderer.drawString(
				str, 
				width,
				height,
				mainColor,
				false);	
	}
}
