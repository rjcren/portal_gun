package io.github.rjcren.portalgun.util;

import io.github.rjcren.portalgun.PortalGunMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;


/**
 * ClassName: ModTags
 * Package: io.github.rjcren.portalgun.util
 * Description:
 *
 * @Author ren
 * @Create 2023/8/22 16:42
 */

//添加标签
public class ModTags {
    public static class Blocks {
        //用于分组，可以将需要区分的方块放入data/portalgun/tags/blocks/portal_gun_valuable.json中
        public static final Tags.IOptionalNamedTag<Block> PORTAL_GUM_VALUABLE = tag("portal_gun_valuable");

        private static Tags.IOptionalNamedTag<Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation(PortalGunMod.MODID, name));
        }
        private static Tags.IOptionalNamedTag<Block> forgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }
    public static class Items {
        //分组，填入data/forge/tags/items/portal_gun.json的物品都可合成传送枪（portal_gun）
        public static final Tags.IOptionalNamedTag<Item> PORTAL_BLOCK = forgeTag("portal_gun");
        private static Tags.IOptionalNamedTag<Item> tag(String name) {
            return ItemTags.createOptional(new ResourceLocation(PortalGunMod.MODID, name));
        }
        private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
