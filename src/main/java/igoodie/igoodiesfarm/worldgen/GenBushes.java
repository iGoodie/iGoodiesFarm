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
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.IWorldGenerator;

public class GenBushes implements IWorldGenerator
{	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		int perChunk = 9;
		
		if(chunkX%perChunk==0 && chunkZ%perChunk==0 && world.provider.dimensionId==0)
		{
			int chunkSize = perChunk*16;
			int node = random.nextInt(2)+1;
			int x = chunkX*16 + random.nextInt(chunkSize);
			int z = chunkZ*16 + random.nextInt(chunkSize);
			Block[] bushes = {GoodiesFarmBlocks.blockBlackberryBush, GoodiesFarmBlocks.blockBlueberryBush, GoodiesFarmBlocks.blockRaspberryBush};

			switch(node)
			{
			case 1:
				int[][] coords1 = {{x,z}, {x+1,z}, {x+2,z}, {x+1,z-1}, {x+1,z+1}};
				for(int i=0; i<coords1.length; i++)
				{
					if(findGround(world, coords1[i][0], coords1[i][1]) != -1)
					{
						int metaRand = random.nextInt(7);
						world.setBlock(coords1[i][0], findGround(world, coords1[i][0], coords1[i][1]),  coords1[i][1], bushes[random.nextInt(3)]);
						world.setBlockMetadataWithNotify(coords1[i][0], findGround(world, coords1[i][0], coords1[i][1]), coords1[i][1], metaRand, 2);
					}
				}
				break;
			case 2:
				int[][] coords2 = {{x,z}, {x+1,z-1}, {x+2,z-1}, {x+1,z}, {x+2,z}, {x+3,z}, {x,z+1}, {x+1,z+1}, {x+2,z+1}, {x+3,z+1}, {x+1,z+2}, {x+2,z+2}};
				for(int i=0; i<coords2.length; i++)
				{
					if(findGround(world, coords2[i][0], coords2[i][1]) != -1)
					{
						int metaRand = random.nextInt(7);
						world.setBlock(coords2[i][0], findGround(world, coords2[i][0], coords2[i][1]),  coords2[i][1], bushes[random.nextInt(3)]);
						world.setBlockMetadataWithNotify(coords2[i][0], findGround(world, coords2[i][0], coords2[i][1]), coords2[i][1], metaRand, 2);
					}
				}
			}

		}
	}

	private int findGround(World world, int x, int z)
	{
		int returnY = -1;
		for(int i=0; i<=world.getActualHeight(); i++)
		{
			if(world.getBlock(x, i, z) == Blocks.grass)
			{
				returnY = i+1;
			}
		}
		return returnY;
	}
}
