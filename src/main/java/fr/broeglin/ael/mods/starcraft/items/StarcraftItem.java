package fr.broeglin.ael.mods.starcraft.items;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StarcraftItem extends Item {

    public static final String REGISTRY_NAME = "starcraft_logo";

    public StarcraftItem() {
        setRegistryName(REGISTRY_NAME);
        setUnlocalizedName(StarCraftMod.MODID + "." + REGISTRY_NAME);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0,
                new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
