package fr.broeglin.ael.mods.starcraft.tabs;

import fr.broeglin.ael.mods.starcraft.utils.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class StarcraftTab extends CreativeTabs {

    public StarcraftTab() {
        super("starcraft");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.starcraftLogo);
    }
}
