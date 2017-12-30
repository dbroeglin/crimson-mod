package fr.broeglin.ael.mods.crimson.tabs;

import fr.broeglin.ael.mods.crimson.utils.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class StarcraftTab extends CreativeTabs {

    public StarcraftTab() {
        super("crimson");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.starcraftLogo);
    }
}
