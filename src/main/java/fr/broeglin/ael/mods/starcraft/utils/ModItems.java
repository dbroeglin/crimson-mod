package fr.broeglin.ael.mods.starcraft.utils;

import fr.broeglin.ael.mods.starcraft.StarcraftMod;
import fr.broeglin.ael.mods.starcraft.items.StarcraftItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder(StarcraftMod.MODID + ":starcraft_logo")
    public static StarcraftItem starcraftLogo;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        StarcraftMod.logger.debug("ModItems initModels...");

        starcraftLogo.initModel();
    }
}
