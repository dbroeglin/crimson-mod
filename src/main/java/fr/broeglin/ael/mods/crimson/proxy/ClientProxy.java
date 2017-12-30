package fr.broeglin.ael.mods.crimson.proxy;

import fr.broeglin.ael.mods.crimson.CrimsonMod;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        CrimsonMod.logger.debug("Crimson Client: preInit...");
        super.preInit(event);

        OBJLoader.INSTANCE.addDomain(CrimsonMod.MODID);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        CrimsonMod.logger.info("Crimson Client: init...");
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        CrimsonMod.logger.info("Crimson Client: postInit...");
        super.postInit(event);
    }
}
