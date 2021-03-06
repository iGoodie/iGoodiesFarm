package igoodie.igoodiesfarm.blocks;

import igoodie.igoodiesfarm.client.renderers.RendererBush;
import igoodie.igoodiesfarm.items.GoodiesFarmItems;
import igoodie.igoodiesfarm.tabs.GoodiesFarmTab;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlackberryBush extends BlockLeavesBase implements IPlantable, IGrowable
{
	public IIcon[] icons;

	public BlockBlackberryBush()
	{
		super(Material.leaves, false);
		this.setTickRandomly(true);
		this.setHardness(0.3f);
		this.setStepSound(soundTypeGrass);

		this.setBlockName("blockBlackberryBush");
		this.setCreativeTab(GoodiesFarmTab.instance);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{	
		this.icons = new IIcon[8];

		for(int i=0; i<this.icons.length; i++)
		{
			if(i!=7)
				this.icons[i] = iconRegister.registerIcon("igoodiesfarm:blockBush");
			else
				this.icons[i] = iconRegister.registerIcon("igoodiesfarm:blackberryBush");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return this.icons[meta];
	}

	@Override
	public int damageDropped(int meta)
	{
		return 0;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block changingBlock) 
	{
		if(world.isAirBlock(x, y-1, z))
		{
			if(world.isRemote)
			{
				return;
			}
			world.setBlockToAir(x, y, z);
			GoodiesFarmBlocks.blockBlackberryBush.dropBlockAsItem(world, x, y, z, new ItemStack(GoodiesFarmBlocks.blockBlackberryBush, 1, 0));
		}
	}

	/* Hitbox and Borders -> Special thanks to my lovely friend Ilke, for these calculations. :3 */
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool (World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		int cubeSideLengthPixels = 2*meta + 4;
		float pixelMeterSize = (1f/16f);
		double cubeSideLength = (double) (cubeSideLengthPixels * pixelMeterSize);

		if(meta == 7)
			cubeSideLength = 1d;

		return AxisAlignedBB.getBoundingBox(
				x + (1d-cubeSideLength)/2d,
				y + 0d,
				z + (1d-cubeSideLength)/2d,

				x + (1d+cubeSideLength)/2d,
				y + cubeSideLength,
				z + (1d+cubeSideLength)/2d);
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool (World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		int cubeSideLengthPixels = 2*meta + 4;
		float pixelMeterSize = (1f/16f);
		double cubeSideLength = (double) (cubeSideLengthPixels * pixelMeterSize);

		if(meta == 7)
			cubeSideLength = 1d;

		return AxisAlignedBB.getBoundingBox(
				x + (1d-cubeSideLength)/2d,
				y + 0d,
				z + (1d-cubeSideLength)/2d,

				x + (1d+cubeSideLength)/2d,
				y + cubeSideLength,
				z + (1d+cubeSideLength)/2d);
	}

	@Override
	public void setBlockBoundsBasedOnState (IBlockAccess iblockaccess, int x, int y, int z)
	{
		int meta = iblockaccess.getBlockMetadata(x, y, z);
		int cubeSideLengthPixels = 2*meta + 4;
		float pixelMeterSize = (1f/16f);
		float cubeSideLength = cubeSideLengthPixels * pixelMeterSize;

		if(meta==7)
			cubeSideLength = 1f;
		this.setBlockBounds(
				(1f - cubeSideLength)/2f,
				0f,
				(1f - cubeSideLength)/2f,

				(1f + cubeSideLength)/2f,
				cubeSideLength,
				(1f + cubeSideLength)/2f);
	}

	/* Harvestability */

	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player)
	{
		int meta = world.getBlockMetadata(x, y, z);
		
		if(meta == 7)
		{
			world.setBlockMetadataWithNotify(x, y, z, 6, 2);
			player.inventory.addItemStackToInventory(new ItemStack(GoodiesFarmItems.itemBlackberry, world.rand.nextInt(3)+1));
		}
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i1, float f1, float f2, float f3)
	{
		int meta = world.getBlockMetadata(x, y, z);
		boolean success = false;
		if(meta == 7)
		{
			success = true;
			world.setBlockMetadataWithNotify(x, y, z, 6, 2);
			player.inventory.addItemStackToInventory(new ItemStack(GoodiesFarmItems.itemBlackberry, world.rand.nextInt(3)+1));
		}
		return success;
	}

	/* Rendering Mechanics */

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType ()
	{
		return RendererBush.id;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int x, int y, int z, int meta)
	{
		if(meta==7)
			return false;
		else
			return true;
	}

	/* Growth */

	@Override
	public void updateTick(World world, int x, int y, int z, Random randomPar)
	{
		int light = world.getBlockLightValue(x, y, z);

		if(light>=8)
		{
			int meta = world.getBlockMetadata(x, y, z);

			if(meta < 7)
			{
				if(randomPar.nextInt(3) == 0)
				{
					world.setBlockMetadataWithNotify(x, y, z, meta+1, 2);
				}
			}

			if(meta==6 || meta==7)
			{
				if(world.isAirBlock(x, y+1, z) && !(world.getBlock(x, y-2, z) instanceof BlockBlackberryBush) )
				{
					if(randomPar.nextInt(3) == 0)
					{
						world.setBlock(x, y+1, z, GoodiesFarmBlocks.blockBlackberryBush);
					}
				}
			}
		}
	}	

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return     world.getBlock(x, y-1, z) instanceof BlockGrass 
				|| world.getBlock(x, y-1, z) instanceof BlockDirt
				|| (world.getBlock(x, y-1, z) instanceof BlockBlackberryBush && world.getBlockMetadata(x, y-1, z)>=6);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z)
	{
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}

	/* Bone Meal */
	
	// Should particles be shown?
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean isRemote)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (!isRemote)
			return meta != 6;
		else
			return false;
	}

	// Can it be bonemeal'd?
	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z)
	{
		return true;
	}

	// What is going to happen after bonemeal is used?
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z) 
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(meta<6)
		{
			world.setBlockMetadataWithNotify(x, y, z, meta+1, 2);
		}

	}

	/* @Override
    public void onEntityCollidedWithBlock (World world, int x, int y, int z, Entity entity)
    {
        if (!(entity instanceof EntityItem))
            entity.attackEntityFrom(DamageSource.cactus, 1);
    }*/
}
