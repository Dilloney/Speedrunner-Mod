package com.dilloney.speedrunnermod.mixins.entity.mob;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import static com.dilloney.speedrunnermod.SpeedrunnerMod.OPTIONS;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin extends HostileEntity {

    @Deprecated
    protected EndermanEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * Changes the Endermans health.
     * @author Dilloney
     * @reason
     */
    @Overwrite
    public static DefaultAttributeContainer.Builder createEndermanAttributes() {
        if (OPTIONS.doomMode) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000002192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 72.0D);
        } else if (OPTIONS.getModDifficulty() == 1) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 25.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0D);
        } else if (OPTIONS.getModDifficulty() == 2) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 35.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 24.0D);
        } else if (OPTIONS.getModDifficulty() == 3) {
            return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40.0D);
        } else {
            return OPTIONS.getModDifficulty() == 4 ? HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 60.0D) : HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 25.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.30000001192092896D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12.0D);
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (!super.tryAttack(target)) {
            return false;
        } else {
            if (target instanceof PlayerEntity) {
                if (OPTIONS.doomMode) {
                    ((PlayerEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0));
                }
            }

            return true;
        }
    }
}