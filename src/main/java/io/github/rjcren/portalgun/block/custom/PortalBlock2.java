package io.github.rjcren.portalgun.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * ClassName: PortalBlock1
 * Package: io.github.rjcren.portalgun.block
 * Description: 传送块2
 *
 * @Author ren
 * @Create 2023/8/22 14:29
 */
public class PortalBlock2 extends Block {
    public PortalBlock2(Properties properties) {
        super(properties);
    }

    //当实体踩上该方块
    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {

        super.stepOn(level, blockPos, blockState, entity);
    }
}
