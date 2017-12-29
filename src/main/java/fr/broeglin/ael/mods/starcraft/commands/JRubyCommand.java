package fr.broeglin.ael.mods.starcraft.commands;

import com.google.common.collect.Lists;
import fr.broeglin.ael.mods.starcraft.JRubyMod;
import fr.broeglin.ael.mods.starcraft.blocks.JRubyWorldGen;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.List;

public class JRubyCommand implements ICommand {

    private Logger logger;
    private JRubyMod container;
    private JRubyWorldGen gen;

    public JRubyCommand(Logger logger, JRubyMod container) {

        this.logger = logger;
        this.container = container;
        this.gen = null; //new JRubyWorldGen();
    }

    @Override
    public String getName() {
        return "jruby";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "jruby <filename>";
    }

    @Override
    public List<String> getAliases() {
        return Lists.newArrayList();
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        logger.info("Executing JRuby Command...");

        if (sender.getEntityWorld().isRemote) {
            logger.debug("Not processing on Client side");
            return;
        }

        logger.debug("Processing on Server side");
        if (args.length != 1) {
            sender.sendMessage(new TextComponentString("The " + getName() + " command takes exactly one argument"));
            return;
        }


        String message = container.runFile(args[0], server, sender).toString();

        sender.sendMessage(new TextComponentString(message));

    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
