package fr.broeglin.ael.mods.starcraft.utils;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import fr.broeglin.ael.mods.starcraft.items.StarcraftItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems {

    @GameRegistry.ObjectHolder(StarCraftMod.MODID + ":starcraft_logo")
    public static StarcraftItem starcraftLogo;



    @SideOnly(Side.CLIENT)
    public static void initModels() {
        starcraftLogo.initModel();
    }
}
