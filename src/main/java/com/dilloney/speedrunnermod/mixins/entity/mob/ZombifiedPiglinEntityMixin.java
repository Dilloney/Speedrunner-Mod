package com.dilloney.speedrunnermod.mixins.entity.mob;

import com.dilloney.speedrunnermod.SpeedrunnerMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(ZombifiedPiglinEntity.class)
public class ZombifiedPiglinEntityMixin extends ZombieEntity {

    protected ZombifiedPiglinEntityMixin(EntityType<? extends ZombieEntity> entityType, World world) {
        super(entityType, world);
    }

    @Overwrite
    public static DefaultAttributeContainer.Builder createZombifiedPiglinAttributes() {
        if (SpeedrunnerMod.CONFIG.doomMode) {
            return ZombieEntity.createZombieAttributes().add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 1.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.33000000427232513D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7.0D);
        } else if (SpeedrunnerMod.CONFIG.difficulty == 1) {
            return ZombieEntity.createZombieAttributes().add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
        } else if (SpeedrunnerMod.CONFIG.difficulty == 2) {
            return ZombieEntity.createZombieAttributes().add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0D);
        } else if (SpeedrunnerMod.CONFIG.difficulty == 3) {
            return ZombieEntity.createZombieAttributes().add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0D);
        } else if (SpeedrunnerMod.CONFIG.difficulty == 4) {
            return ZombieEntity.createZombieAttributes().add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0D);
        } else {
            return ZombieEntity.createZombieAttributes().add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0D).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23000000417232513D).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.0D);
        }
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (!super.tryAttack(target)) {
            return false;
        } else {
            if (target instanceof PlayerEntity) {
                if (SpeedrunnerMod.CONFIG.doomMode) {
                    ((PlayerEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0));
                }
            }

            return true;
        }
    }
}