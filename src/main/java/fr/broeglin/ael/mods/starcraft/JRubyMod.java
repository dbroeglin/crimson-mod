package fr.broeglin.ael.mods.starcraft;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import org.jruby.RubyObject;
import org.jruby.embed.ScriptingContainer;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;

public class JRubyMod {
    private ScriptingContainer container;
    private Logger logger;
    private ClassLoader classLoader;
    private RubyObject rubyMod;


    public JRubyMod(ClassLoader classLoader,  Logger logger) {
        this.logger = logger;
        this.classLoader = classLoader;
        this.container = new ScriptingContainer();
    }

    public void preInit(FMLPreInitializationEvent event) throws IOException {
        final String modFilename = "mod.rb";
        container.setClassLoader(classLoader);

        container.getVarMap().put("$LOGGER", logger);

        URL url = getClass().getResource("/ruby/" + modFilename);
        String unescapedurl = URLDecoder.decode(url.toString(), "UTF-8");
        Object klass = container.runScriptlet(url.openStream(), modFilename);
        rubyMod = (RubyObject)container.callMethod(klass, "new", logger);

        container.callMethod(rubyMod, "pre_init", event);
    }

    public void init(FMLInitializationEvent event) {
        container.callMethod(rubyMod, "init", event);
    }

    public void postInit(FMLPostInitializationEvent event) {
        container.callMethod(rubyMod, "post_init", event);
    }

    public void serverStarting(FMLServerStartingEvent event) {
        container.callMethod(rubyMod, "server_starting", event);
    }
}
