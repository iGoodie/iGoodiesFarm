package igoodie.igoodiesfarm.client.renderers;

import igoodie.igoodiesfarm.client.models.ModelBush;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderRaspberryBush extends TileEntitySpecialRenderer// implements IItemRenderer
{

	private static final ResourceLocation texture0 = new ResourceLocation("textures/model/ModelBush_0.png");
	private static final ResourceLocation texture1 = new ResourceLocation("textures/model/ModelBush_1.png");
	private static final ResourceLocation texture2 = new ResourceLocation("textures/model/ModelBush_2.png");
	private static final ResourceLocation texture3 = new ResourceLocation("textures/model/ModelBush_3.png");
	private static final ResourceLocation texture4 = new ResourceLocation("textures/model/ModelBush_4.png");
	private static final ResourceLocation texture5 = new ResourceLocation("textures/model/ModelBush_5.png");
	private static final ResourceLocation texture6 = new ResourceLocation("textures/model/ModelBush_6.png");
	private static final ResourceLocation texture7 = new ResourceLocation("textures/model/ModelRaspberryBush_7.png");
	
	private ModelBush model = new ModelBush();
	
	public void renderTileEntityAt(double x, double y, double z)
	{
		GL11.glPushMatrix();

		GL11.glTranslatef((float)x+0.5f, (float)y+1.5f, (float)z+0.5f);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(texture3);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625f, 3);
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) 
	{
		GL11.glPushMatrix();

		GL11.glTranslatef((float)x+0.5f, (float)y+1.5f, (float)z+0.5f);
		GL11.glRotatef(180, 0F, 0F, 1F);

		int meta = tileEntity.getWorldObj().getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
		switch(meta)
		{
		case 0: this.bindTexture(texture0); break;
		case 1: this.bindTexture(texture1); break;
		case 2: this.bindTexture(texture2); break;
		case 3: this.bindTexture(texture3); break;
		case 4: this.bindTexture(texture4); break;
		case 5: this.bindTexture(texture5); break;
		case 6: this.bindTexture(texture6); break;
		case 7: this.bindTexture(texture7); break;
		default: this.bindTexture(texture0); break;
		}

		GL11.glPushMatrix();
		this.model.renderModel(0.0625f, meta);
		GL11.glPopMatrix();

		GL11.glPopMatrix();
	}
}