package fr.broeglin.ael.mods.starcraft.proxy;

import fr.broeglin.ael.mods.starcraft.StarcraftMod;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        StarcraftMod.logger.debug("Starcraft Client: preInit...");
        super.preInit(event);

        OBJLoader.INSTANCE.addDomain(StarcraftMod.MODID);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        StarcraftMod.logger.info("Starcraft Client: init...");
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        StarcraftMod.logger.info("Starcraft Client: postInit...");
        super.postInit(event);
    }
}
