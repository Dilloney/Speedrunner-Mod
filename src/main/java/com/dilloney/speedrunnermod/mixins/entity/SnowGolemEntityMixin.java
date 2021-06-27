package com.dilloney.speedrunnermod.mixins.entity;

import com.dilloney.speedrunnermod.util.UniqueItemRegistry;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SnowGolemEntity.class)
public class SnowGolemEntityMixin {
    @Redirect(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"))
    private Item interactMob(ItemStack stack) {
        return UniqueItemRegistry.SHEARS.getDefaultItem(stack.getItem());
    }
}