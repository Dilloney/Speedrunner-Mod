package com.dilloney.speedrunnermod.mixins.misc;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.world.dimension.AreaHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AreaHelper.class)
public class AreaHelperMixin {

    @Shadow final static AbstractBlock.ContextPredicate IS_VALID_FRAME_BLOCK;

    static {
        IS_VALID_FRAME_BLOCK = (state, world, pos) -> {
            return state.isOf(Blocks.OBSIDIAN) || state.isOf(Blocks.CRYING_OBSIDIAN);
        };
    }
}