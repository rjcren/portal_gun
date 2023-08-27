package io.github.rjcren.portalgun.block;

import io.github.rjcren.portalgun.PortalGunMod;
import io.github.rjcren.portalgun.block.custom.PortalBlock1;
import io.github.rjcren.portalgun.block.custom.PortalBlock2;
import io.github.rjcren.portalgun.item.ModCreativeModeTab;
import io.github.rjcren.portalgun.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

/**
 * ClassName: ModBlocks
 * Package: io.github.rjcren.portalgun.block
 * Description: 方块类
 *
 * @Author ren
 * @Create 2023/8/16 0:25
 */

//方块类
public class ModBlocks {
    //创建延迟寄存器保存在“portalgun”命名空间下注册的块
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PortalGunMod.MODID);

    //注册方块
    public static final RegistryObject<Block> PORTAL_BLOCK_1 = registryBlock("portal_block_1",
            () -> new PortalBlock1(BlockBehaviour.Properties.of(Material.PORTAL).strength(0)), ModCreativeModeTab.PORTALGUNMOD, "tooltip.portalgun.portal_block_1");
    public static final RegistryObject<Block> PORTAL_BLOCK_2 = registryBlock("portal_block_2",
            () -> new PortalBlock2(BlockBehaviour.Properties.of(Material.PORTAL).strength(0)), ModCreativeModeTab.PORTALGUNMOD, "tooltip.portalgun.portal_block_2");

    //注册方块方法
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }
    //绑定物品与方块方法
    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    //带方块描述的方法
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab, String tooltipkey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab, tooltipkey);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, String tooltipkey) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> Ptooltip, TooltipFlag pFlag) {
                Ptooltip.add(new TranslatableComponent(tooltipkey));
            }
        });
    }

    //方块注册方法
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
