package com.dilloney.speedrunnermod.mixins.block;

import com.dilloney.speedrunnermod.util.UniqueItemRegistry;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BeehiveBlock.class)
public class BeehiveBlockMixin {
    @Redirect(method = "onUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;", ordinal = 0))
    private Item onUse(ItemStack stack) {
        return UniqueItemRegistry.SHEARS.getDefaultItem(stack.getItem());
    }
}