package fr.broeglin.ael.mods.starcraft.utils;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import fr.broeglin.ael.mods.starcraft.blocks.PylonBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    @GameRegistry.ObjectHolder(StarCraftMod.MODID + ":pylonblock")
    public static PylonBlock pylonBlock;

}
