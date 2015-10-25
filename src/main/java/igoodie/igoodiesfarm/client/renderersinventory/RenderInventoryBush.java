package igoodie.igoodiesfarm.client.renderersinventory;

import igoodie.igoodiesfarm.client.renderers.RenderBlackberryBush;
import igoodie.igoodiesfarm.entities.TileEntityBlackberryBush;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class RenderInventoryBush implements IItemRenderer
{
	RenderBlackberryBush render;
	private TileEntity entity = new TileEntityBlackberryBush();

	public RenderInventoryBush(TileEntitySpecialRenderer render, TileEntity entity)
	{
		this.render = (RenderBlackberryBush) render;
		this.entity = entity;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) 
	{
		if(type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		//this.render.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);
		this.render.renderTileEntityAt(0d, 0d, 0d);
	}
}