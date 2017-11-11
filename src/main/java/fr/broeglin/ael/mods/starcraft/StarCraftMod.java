package fr.broeglin.ael.mods.starcraft;

import fr.broeglin.ael.mods.starcraft.proxy.CommonProxy;
import fr.broeglin.ael.mods.starcraft.tabs.StarcraftTab;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = StarCraftMod.MODID, version = StarCraftMod.VERSION)
public class StarCraftMod {
    public static final String MODID = "starcraft";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "fr.broeglin.ael.mods.starcraft.proxy.ClientProxy",
            serverSide = "fr.broeglin.ael.mods.starcraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Instance(MODID)
    public static StarCraftMod instance;
    public static Logger logger;

    public static final StarcraftTab starcraftTab = new StarcraftTab();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("StarCraftMod: preInit...");
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("StarCraftMod: init...");
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("StarCraftMod: postInit...");
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        logger.info("StarCraftMod: serverStarting...");
        // event.registerServerCommand(new TeleportCommand());
    }

}
