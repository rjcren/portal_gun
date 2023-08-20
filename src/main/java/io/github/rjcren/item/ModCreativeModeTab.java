package io.github.rjcren.item;

import io.github.rjcren.PortalGunMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;

/**
 * ClassName: ModCreativeModeTab
 * Package: io.github.rjcren.item
 * Description:
 *
 * @Author ren
 * @Create 2023/8/20 21:52
 */

@Mod(PortalGunMod.MODID)
public class ModCreativeModeTab {
    public static final CreativeModeTab PORTALGUNMOD = new CreativeModeTab("portalgunmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PORTAL_GUN.get());
        }
    };
}
