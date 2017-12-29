package fr.broeglin.ael.mods.starcraft;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StringUtils;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.Logger;
import org.jruby.RubyObject;
import org.jruby.embed.ScriptingContainer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class JRubyMod {
    private ScriptingContainer container;
    private Logger logger;
    private ClassLoader classLoader;
    private RubyObject rubyMod;
    private StarcraftMod mod;



    public JRubyMod(ClassLoader classLoader,  Logger logger, StarcraftMod mod) {
        this.logger = logger;
        this.classLoader = classLoader;
        this.container = new ScriptingContainer();
        this.mod = mod;
        container.getVarMap().put("$MOD", mod);
        container.getVarMap().put("$rand", new Random());
    }

    public void preInit(FMLPreInitializationEvent event) throws IOException {
        final String modFilename = "mod.rb";
        container.setClassLoader(classLoader);

        container.getVarMap().put("$LOGGER", logger);

        URL url = getClass().getResource("/ruby/" + modFilename);
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

    public Object runFile(String fileName, MinecraftServer server, ICommandSender sender)  {
        InputStream is;
        if (StringUtils.isNullOrEmpty(fileName)) {
            throw new RuntimeException("A file name is mandatory");
        }
        if (!fileName.endsWith(".rb")) {
            fileName += ".rb";
        }
        try {
            URL url = getClass().getResource("/ruby/" + fileName);
            if (url == null) {
                String absolutePath = System.getenv("HOME") + "/Documents/MineCraft/" + fileName;

                is = new FileInputStream(absolutePath);
            } else {
                    is = url.openStream();
            }
        } catch (IOException e) {
            logger.error("Error while reading stream {}", fileName, e);
            return "ERROR!!!";
        }
        try {

            container.getVarMap().put("$server", server);
            container.getVarMap().put("$sender", sender);

            return container.runScriptlet(is, fileName);
        } catch (Exception e) {
            logger.error("Error while calling ruby script {}", fileName, e);
            return "ERROR!!!";
        } finally {
            try {
                is.close();
            } catch (Exception e){
                logger.warn("Error occurred when close stream", e);
            }
        }
    }
}