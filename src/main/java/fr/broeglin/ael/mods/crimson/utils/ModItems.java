package fr.broeglin.ael.mods.crimson.utils;

import fr.broeglin.ael.mods.crimson.CrimsonMod;
import fr.broeglin.ael.mods.crimson.items.StarcraftItem;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder(CrimsonMod.MODID + ":starcraft_logo")
    public static StarcraftItem starcraftLogo;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        CrimsonMod.logger.debug("ModItems initModels...");

        starcraftLogo.initModel();
    }
}
