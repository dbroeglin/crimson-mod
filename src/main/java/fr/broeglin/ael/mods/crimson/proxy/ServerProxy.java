package fr.broeglin.ael.mods.crimson.proxy;

import fr.broeglin.ael.mods.crimson.CrimsonMod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        CrimsonMod.logger.info("Crimson Server: preInit...");
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        CrimsonMod.logger.info("Crimson Server: init...");
        super.init(event);
    }
}
