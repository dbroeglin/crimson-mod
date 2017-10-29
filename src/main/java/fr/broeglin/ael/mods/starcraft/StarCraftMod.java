package fr.broeglin.ael.mods.starcraft;

import fr.broeglin.ael.mods.starcraft.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = StarCraftMod.MODID, version = StarCraftMod.VERSION)
public class StarCraftMod {
    public static final String MODID = "starcraftmod";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "fr.broeglin.ael.mods.starcraft.proxy.ClientProxy",
            serverSide = "fr.broeglin.ael.mods.starcraft.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MODID)
    public static StarCraftMod instance;


    @EventHandler
    public void init(FMLPreInitializationEvent event) {
        System.out.println("StarCraft MOD : PreInit! ");
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        System.out.println("StarCraft MOD : Hello! ");
        proxy.init();
    }
}
