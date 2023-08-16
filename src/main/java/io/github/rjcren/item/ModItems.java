package io.github.rjcren.item;

import io.github.rjcren.PortalGunMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * ClassName: ModItems
 * Package: io.github.rjcren.item
 * Description:
 *
 * @Author ren
 * @Create 2023/8/16 0:22
 */

//物品类
public class ModItems {
    // 创建延迟寄存器保存在“portalgun”命名空间下注册的所有项目。
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PortalGunMod.MODID);
    //注册物品 传送枪
    public static final RegistryObject<Item> PORTAL_GUN = ITEMS.register("portal_gun",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
