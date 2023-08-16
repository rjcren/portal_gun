package io.github.rjcren.block;

import io.github.rjcren.PortalGunMod;
import io.github.rjcren.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * ClassName: ModBlocks
 * Package: io.github.rjcren.block
 * Description:
 *
 * @Author ren
 * @Create 2023/8/16 0:25
 */

//方块类
@Mod(PortalGunMod.MODID)
public class ModBlocks {
    // 创建延迟寄存器保存在“portalgun”命名空间下注册的块
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PortalGunMod.MODID);

    //
    private static <T extends Block>RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
