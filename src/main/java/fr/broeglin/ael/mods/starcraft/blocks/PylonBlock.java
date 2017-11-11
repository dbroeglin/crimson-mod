package fr.broeglin.ael.mods.starcraft.blocks;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class PylonBlock extends Block implements IGrowable
{

    public PylonBlock() {
        super(Material.ROCK);
        setUnlocalizedName(StarCraftMod.MODID + ".pylonblock");
        setRegistryName("pylonblock");
        setCreativeTab(StarCraftMod.starcraftTab);
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        StarCraftMod.logger.debug("Growing Pylon...");

        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();
        worldIn.setBlockState(pos, iblockstate2, 4);

        new WorldGenPylon(true).generate(worldIn, rand, pos);
    }


    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }
}