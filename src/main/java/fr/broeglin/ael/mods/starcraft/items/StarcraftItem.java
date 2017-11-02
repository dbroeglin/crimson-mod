package fr.broeglin.ael.mods.starcraft.items;

import fr.broeglin.ael.mods.starcraft.StarCraftMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
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

    /**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer) null,
                playerIn.posX, playerIn.posY, playerIn.posZ,
                SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS,
                0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            StarcraftEntity entityegg = new StarcraftEntity(worldIn, playerIn);
            entityegg.setHeadingFromThrower(playerIn, playerIn.rotationPitch,
                    playerIn.rotationYaw,
                    0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entityegg);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
