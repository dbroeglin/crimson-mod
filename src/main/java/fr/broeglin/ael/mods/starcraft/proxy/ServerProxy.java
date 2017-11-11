package fr.broeglin.ael.mods.starcraft.proxy;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        StarCraftMod.logger.info("Starcraft Server: preInit...");
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        StarCraftMod.logger.info("Starcraft Server: init...");
        super.init(event);
    }
}
