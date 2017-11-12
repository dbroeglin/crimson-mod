package fr.broeglin.ael.mods.starcraft;

import fr.broeglin.ael.mods.starcraft.blocks.PylonBlock;
import fr.broeglin.ael.mods.starcraft.items.StarcraftItem;
import fr.broeglin.ael.mods.starcraft.utils.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        StarcraftMod.logger.debug("RegistryHandler registerBlocks {}...", event.getName());

        // register only items that have models...
        event.getRegistry().register(new PylonBlock());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        StarcraftMod.logger.debug("RegistryHandler registerItems {}...", event.getName());
        event.getRegistry().register(new StarcraftItem());

        event.getRegistry().register(
                new ItemBlock(ModBlocks.pylonBlock)
                        .setRegistryName(ModBlocks.pylonBlock.getRegistryName()));
    }


}
