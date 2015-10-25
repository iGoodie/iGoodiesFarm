package igoodie.igoodiesfarm.blocks;

import igoodie.igoodiesfarm.entities.TileEntityBlackberryBush;
import igoodie.igoodiesfarm.items.GoodiesFarmItems;
import igoodie.igoodiesfarm.tabs.GoodiesFarmTab;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlackberryBush extends Block implements ITileEntityProvider, IGrowable
{
	//Block(object) is initializing to be similar with a grass block.
	public BlockBlackberryBush()
	{
		super(Material.grass);
		this.setCreativeTab(GoodiesFarmTab.instance);
		this.setStepSound(soundTypeGrass);
		this.setHardness(0.2f);

		this.setTickRandomly(true);
		this.setBlockName("blockBlackberryBush");
	}
	
	//Grows bush between metadata values 0-6; Grows berry at metadata value 7.
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		super.updateTick(world, x, y, z, random);
		int light = world.getBlockLightValue(x, y, z);

		if(world.isRemote)
		{
			return;
		}

		if(light>=8)
		{
			int meta = world.getBlockMetadata(x, y, z);
			
			if(meta < 7)
			{
				if(random.nextInt(3) == 0)
				{
					world.setBlockMetadataWithNotify(x, y, z, meta+1, 12);
				}
			}

			if(meta==6 || meta==7)
			{
				if(world.isAirBlock(x, y+1, z) && !(world.getBlock(x, y-2, z) instanceof BlockBlackberryBush) )
				{
					if(random.nextInt(3) == 0)
					{
						world.setBlock(x, y+1, z, GoodiesFarmBlocks.blockBlackberryBush);
					}
				}
			}
		}
	}
	
	// Following 3 methods: Hit box and borders -> Special thanks to my lovely friend Ilke, for these calculations. :3
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

	//Drops when the block below is broken.
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

	//If the metadata is 7 when right clicked, it will harvest the berry.
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int int1, float f1, float f2, float f3)
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

	//Item drops when broken. It drops the bush block itself.
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(GoodiesFarmBlocks.blockBlackberryBush));

		return ret;
	}

	//It can be placed if the block below is grass,dirt or bush.
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return     world.getBlock(x, y-1, z) instanceof BlockGrass 
				|| world.getBlock(x, y-1, z) instanceof BlockDirt
				|| world.getBlock(x, y-1, z) instanceof BlockBlackberryBush;
	}
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z)
    {
        return     world.getBlock(x, y-1, z) instanceof BlockGrass 
				|| world.getBlock(x, y-1, z) instanceof BlockDirt
				|| world.getBlock(x, y-1, z) instanceof BlockBlackberryBush;
    }
	
	// Following 3 methods make this block flammable.
	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return true;
	}

	@Override
	public int getFlammability (IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 25;
	}

	@Override
	public int getFireSpreadSpeed (IBlockAccess world, int x, int y, int z, ForgeDirection face)
	{
		return 4;
	}

	// Following 6 methods determines rendering stuff. (including particles.)
	public int getRenderType()
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) 
	{
		return new TileEntityBlackberryBush();
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("ModelBush_par");
	}
	
	// For particles.
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) 
	{
		//world.spawnParticle("smoke", x, y+0.5d, z, 0.0d, 0.0d, 0.0d);
	}
	
	// Following 3 methods are about the functionality of item "Bone"
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean isRemote)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (!isRemote)
			return meta != 6;
		else
			return false;
	}

	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z)
	{
		return true;
	}

	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z) 
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(meta<6)
		{
			world.setBlockMetadataWithNotify(x, y, z, meta+1, 2);
		}

	}
}