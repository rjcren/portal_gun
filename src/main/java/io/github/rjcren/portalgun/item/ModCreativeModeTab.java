package io.github.rjcren.portalgun.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

/**
 * ClassName: ModCreativeModeTab
 * Package: io.github.rjcren.portalgun.item
 * Description:
 *
 * @Author ren
 * @Create 2023/8/20 21:52
 */

//创建创造模式选项卡
public class ModCreativeModeTab {
    public static final CreativeModeTab PORTALGUNMOD = new CreativeModeTab("portalgunmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.PORTAL_GUN.get());
        }
    };
}
