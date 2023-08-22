package io.github.rjcren.portalgun.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * ClassName: PortalGun
 * Package: io.github.rjcren.portalgun.item.custom
 * Description:
 *
 * @Author ren
 * @Create 2023/8/22 14:58
 */
public class PortalGun extends Item {
    public PortalGun(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        return super.useOn(pContext);
    }

    //物品描述
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown())
            pTooltipComponents.add(new TranslatableComponent("tooltip.portalgun.portal_gun.shift"));
        else pTooltipComponents.add(new TranslatableComponent("tooltip.portalgun.portal_gun"));

    }
}
