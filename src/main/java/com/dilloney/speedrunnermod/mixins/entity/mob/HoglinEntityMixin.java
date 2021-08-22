package com.dilloney.speedrunnermod.mixins.entity.mob;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.HostileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static com.dilloney.speedrunnermod.SpeedrunnerMod.OPTIONS;

@Mixin(HoglinEntity.class)
public class HoglinEntityMixin {

    /**
     * Changes the Hoglins health.
     * @author Dilloney
     * @reason
     */
    @Overwrite
    public static DefaultAttributeContainer.Builder createHoglinAttributes() {
        if (OPTIONS.doomMode) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000002193092896D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.7000000238518589D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.5D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D);
        } else if (OPTIONS.getModDifficulty() == 1) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.6000000238418579D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.5D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D);
        } else if (OPTIONS.getModDifficulty() == 2) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 30.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.6000000238418579D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.7D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D);
        } else if (OPTIONS.getModDifficulty() == 3) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.6000000238418579D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.9D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0D);
        } else {
            return OPTIONS.getModDifficulty() == 4 ? HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.6000000238418579D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.1D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D) : HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.6000000238418579D).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.5D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D);
        }
    }
}