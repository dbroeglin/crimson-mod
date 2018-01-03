package fr.broeglin.ael.mods.crimson;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public abstract class JRubyWorldGen extends WorldGenerator {

    public JRubyWorldGen() {
        super(true);
        this.logger = CrimsonMod.logger;
    }

    protected void info(String msg) {
        logger.info(msg);
    }

    protected abstract boolean gen();

    // plumbing

    World world;
    Random rand;
    BlockPos position;
    Logger logger;


    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        this.world = worldIn;
        this.rand = rand;
        this.position = position;

        return gen();
    }

    public World getWorld() {
        return world;
    }

    public Random getRand() {
        return rand;
    }

    public BlockPos getPosition() {
        return position;
    }

    public void setPosition(BlockPos position) {
        this.position = position;
    }
}
