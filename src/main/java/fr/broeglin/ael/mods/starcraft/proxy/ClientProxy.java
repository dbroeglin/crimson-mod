package fr.broeglin.ael.mods.starcraft.proxy;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        StarCraftMod.logger.debug("Starcraft Client: preInit...");
        super.preInit(event);

        OBJLoader.INSTANCE.addDomain(StarCraftMod.MODID);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        StarCraftMod.logger.info("Starcraft Client: init...");
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        StarCraftMod.logger.info("Starcraft Client: postInit...");
        super.postInit(event);
    }
}
