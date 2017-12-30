package fr.broeglin.ael.mods.crimson.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenPylon extends WorldGenerator {


    public WorldGenPylon(boolean notify)
    {
        super(notify);
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        BlockPos pylonPos = position.up(1);
        Block block = Blocks.DIAMOND_BLOCK;

        for(int i = 0; i < 5; i++) {
            this.setBlockAndNotifyAdequately(worldIn, pylonPos.up(i), block.getDefaultState());
        }

        block = Blocks.GOLD_BLOCK;
        for(int i = 1; i <= 3; i += 1) {
            this.setBlockAndNotifyAdequately(worldIn, pylonPos.up(i).north(), block.getDefaultState());
            this.setBlockAndNotifyAdequately(worldIn, pylonPos.up(i).east(), block.getDefaultState());
            this.setBlockAndNotifyAdequately(worldIn, pylonPos.up(i).south(), block.getDefaultState());
            this.setBlockAndNotifyAdequately(worldIn, pylonPos.up(i).west(), block.getDefaultState());
        }
        return true;
    }
}
