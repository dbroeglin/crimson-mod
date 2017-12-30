package fr.broeglin.ael.mods.crimson;

import fr.broeglin.ael.mods.crimson.commands.JRubyCommand;
import fr.broeglin.ael.mods.crimson.proxy.CommonProxy;
import fr.broeglin.ael.mods.crimson.tabs.StarcraftTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Mod(modid = CrimsonMod.MODID, version = CrimsonMod.VERSION)
public class CrimsonMod {
    public static final String MODID = "crimson";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "fr.broeglin.ael.mods.crimson.proxy.ClientProxy",
            serverSide = "fr.broeglin.ael.mods.crimson.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Instance(MODID)
    public static CrimsonMod instance;
    public static Logger logger;
    public static JRubyMod container;

    public static final StarcraftTab starcraftTab = new StarcraftTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IOException {
        logger = event.getModLog();
        logger.info("CrimsonMod: preInit...");
        proxy.preInit(event);

        container = new JRubyMod(this.getClass().getClassLoader(), logger, this);
        container.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("CrimsonMod: init...");
        proxy.init(event);
        container.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("CrimsonMod: postInit...");
        proxy.postInit(event);
        container.postInit(event);

    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        logger.info("CrimsonMod: serverStarting...");
        // event.registerServerCommand(new TeleportCommand());
        container.serverStarting(event);
        event.registerServerCommand(new JRubyCommand(logger, container));
    }
}
