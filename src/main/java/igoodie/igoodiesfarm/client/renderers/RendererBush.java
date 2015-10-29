package igoodie.igoodiesfarm.client.renderers;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RendererBush implements ISimpleBlockRenderingHandler
{
	public static int id = RenderingRegistry.getNextAvailableRenderId();
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		if(modelId==id)
		{
			int meta = world.getBlockMetadata(x, y, z);
			int cubeSideLengthPixels = 2*meta + 4;
			float pixelMeterSize = (1f/16f);
			float cubeSideLength = cubeSideLengthPixels * pixelMeterSize;

			if(meta==7)
				cubeSideLength = 1f;
			renderer.setRenderBounds(
					(1f - cubeSideLength)/2f,
					0f,
					(1f - cubeSideLength)/2f,

					(1f + cubeSideLength)/2f,
					cubeSideLength,
					(1f + cubeSideLength)/2f);
			renderer.renderStandardBlock(block, x, y, z);
			return true;
		}
		return false;
	}
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) 
	{
		if (modelId == id)
        {
            renderer.setRenderBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.75F, 0.875F);
            RenderInInventory.renderStandardInvBlock(renderer, block, metadata);
        }
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}

	@Override
	public int getRenderId() 
	{
		return id;
	}
	
}
