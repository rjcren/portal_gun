package io.github.rjcren.block;

import io.github.rjcren.PortalGunMod;
import io.github.rjcren.item.ModCreativeModeTab;
import io.github.rjcren.item.ModItems;
import net.minecraft.world.Nameable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

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

    public static final RegistryObject<Block> PORTAL_BLOCK_1 = registryBlock("portal_block_1",
            () -> new Block(BlockBehaviour.Properties.of(Material.PORTAL).strength(0)), ModCreativeModeTab.PORTALGUNMOD);
    public static final RegistryObject<Block> PORTAL_BLOCK_2 = registryBlock("portal_block_2",
            () -> new Block(BlockBehaviour.Properties.of(Material.PORTAL).strength(0)), ModCreativeModeTab.PORTALGUNMOD);
    //
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //
    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
