package fr.broeglin.ael.mods.starcraft.commands;

import com.google.common.collect.Lists;
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

    public JRubyCommand(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String getName() {
        return "jruby";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "jruby";
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
        } else {
            logger.debug("Processing on Server side");

            sender.sendMessage(new TextComponentString("JRuby!!!"));
        }
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
