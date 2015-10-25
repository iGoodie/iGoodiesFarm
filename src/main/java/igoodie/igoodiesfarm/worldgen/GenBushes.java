package igoodie.igoodiesfarm.worldgen;

import igoodie.igoodiesfarm.blocks.GoodiesFarmBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMelon;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.IWorldGenerator;

public class GenBushes implements IWorldGenerator
{	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		int chunkSize = 16;
		int x = chunkX + random.nextInt(chunkSize);
		int y = findGround(world, chunkX, chunkZ);
		int z = chunkZ + random.nextInt(chunkSize);
		
		BiomeGenBase gen2 = world.getBiomeGenForCoords(chunkX, chunkZ);
		//WorldGenFlowers gen = new WorldGenFlowers(GoodiesFarmBlocks.blockBlackberryBush);
		WorldGenMinable gen = new WorldGenMinable(Blocks.diamond_block, 13); 
		
		switch(world.provider.dimensionId)
		{
		case -1: //Nether
			break;
		case 0: //Overworld
			for(int i=0; i<5; i++)
			{
				gen.generate(world, random, x, 255, z);
			}
			break;
		case 1: //End
			break;
		}
		
	}
	
	private void genBush()
	{
		
	}
	
	private int findGround(World world, int x, int z)
	{
		int returnY = -1;
		for(int y=world.getActualHeight(); y>=0; y--)
		{
			Block blockBelow = world.getBlock(x, y-1, z);
			if(!world.isAirBlock(x, y, z) && (blockBelow instanceof BlockDirt || blockBelow instanceof BlockGrass) && blockBelow.isOpaqueCube())
			{
				returnY = y;
			}
		}
		return returnY;
	}

	
}