package io.github.rjcren.portalgun;

import io.github.rjcren.portalgun.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


/**
 * ClassName: EventHandling
 * Package: io.github.rjcren
 * Description: 事件处理类
 *
 * @Author ren
 * @Create 2023/8/15 22:53
 */

//事件处理类
@Mod.EventBusSubscriber
public class EventHandling {
    //测试用，手持传送枪右键可以传送
    @SubscribeEvent
    public static void rightClick(PlayerInteractEvent.RightClickItem e) {
        Player player = e.getPlayer();
        Level level = player.level;

        //获取玩家手中物品
        ItemStack itemStack = e.getItemStack();
        Item item = itemStack.getItem();
        if (item == ModItems.PORTAL_GUN.get()) {
            //获取玩家准星对准，参数为：准星延伸的距离、？、是否穿透流体
            HitResult hitResult = player.pick(20, 0, false);
            //获取准星对准位置
            Vec3 location = hitResult.getLocation();
            //传送玩家至该位置
            player.teleportTo(location.x, location.y, location.z);
        }
    }
}
