package io.github.rjcren.portalgun.item;

import io.github.rjcren.portalgun.PortalGunMod;
import io.github.rjcren.portalgun.item.custom.PortalGunItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * ClassName: ModItems
 * Package: io.github.rjcren.portalgun.item
 * Description:
 *
 * @Author ren
 * @Create 2023/8/16 0:22
 */

//物品类
public class ModItems {
    //创建延迟寄存器保存在“portalgun”命名空间下注册的所有项目。
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PortalGunMod.MODID);

    //注册物品
    public static final RegistryObject<Item> PORTAL_GUN = ITEMS.register("portal_gun",
            () -> new PortalGunItem(new Item.Properties().tab(ModCreativeModeTab.PORTALGUNMOD).
                    durability(100)));
    public static final RegistryObject<Item> PORTAL_GUN_SHARD_WHITE = ITEMS.register("portal_gun_shard_white",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PORTALGUNMOD)));
    public static final RegistryObject<Item> PORTAL_GUN_SHARD_BLACK = ITEMS.register("portal_gun_shard_black",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.PORTALGUNMOD)));

    //物品注册方法
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
