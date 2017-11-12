package fr.broeglin.ael.mods.starcraft.utils;

import fr.broeglin.ael.mods.starcraft.StarcraftMod;
import fr.broeglin.ael.mods.starcraft.blocks.PylonBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    @GameRegistry.ObjectHolder(StarcraftMod.MODID + ":pylonblock")
    public static PylonBlock pylonBlock;

}
