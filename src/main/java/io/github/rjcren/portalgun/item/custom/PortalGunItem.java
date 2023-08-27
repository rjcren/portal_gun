package io.github.rjcren.portalgun.item.custom;

import io.github.rjcren.portalgun.block.ModBlocks;
import io.github.rjcren.portalgun.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.List;

/**
 * ClassName: PortalGun
 * Package: io.github.rjcren.portalgun.item.custom
 * Description:
 *
 * @Author ren
 * @Create 2023/8/22 14:58
 */
public class PortalGunItem extends Item {
    private BooleanProperty f = BooleanProperty.create("flag");
    private int flag = 0;
    private long timeFlag = new Date().getTime();

    public PortalGunItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockPosOld = pContext.getClickedPos();
        BlockPos blockPos = blockPosOld.atY(blockPosOld.getY() + 1);
        Player player = pContext.getPlayer();

        long time = new Date().getTime();
        if (!level.isClientSide) {
            if (time - timeFlag > 1000) {
                if (flag % 2 == 0)
                    level.setBlock(blockPos, ModBlocks.PORTAL_BLOCK_1.get().defaultBlockState(), 3);
                else level.setBlock(blockPos, ModBlocks.PORTAL_BLOCK_2.get().defaultBlockState(), 0);
                flag++;
                timeFlag = new Date().getTime();
            } else if (time - timeFlag <= 1000)
                player.sendMessage(new TranslatableComponent("item.portalgun.portal_gun.cooling"), player.getUUID());
        }
        return super.useOn(pContext);
    }

    //物品描述
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown())
            pTooltipComponents.add(new TranslatableComponent("tooltip.portalgun.portal_gun.shift"));
        else pTooltipComponents.add(new TranslatableComponent("tooltip.portalgun.portal_gun"));
    }

    //以下为标签（tag）的用法举例，判断传入的方块是否在该标签组内
    private boolean isValuableBlock(Block block) {
        return ModTags.Blocks.PORTAL_GUM_VALUABLE.contains(block);
    }
}
