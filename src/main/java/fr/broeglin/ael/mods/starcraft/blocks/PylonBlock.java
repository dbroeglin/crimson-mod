package fr.broeglin.ael.mods.starcraft.blocks;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.*;

import java.util.Random;

public class PylonBlock extends Block implements IGrowable
{

    public PylonBlock() {
        super(Material.ROCK);
        setUnlocalizedName(StarCraftMod.MODID + ".pylonblock");
        setRegistryName("pylonblock");
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        System.out.println("Growing Pylon!!!");

        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();
        worldIn.setBlockState(pos, iblockstate2, 4);

        new WorldGenPylon(true).generate(worldIn, rand, pos);
        //boolean res = new WorldGenBigTree(true).generate(worldIn, rand, pos);
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