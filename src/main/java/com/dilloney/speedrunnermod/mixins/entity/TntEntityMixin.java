package com.dilloney.speedrunnermod.mixins.entity;

import com.dilloney.speedrunnermod.SpeedrunnerMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(TntEntity.class)
public abstract class TntEntityMixin extends Entity {

    protected TntEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Overwrite
    private void explode() {
        if (SpeedrunnerMod.CONFIG.doomMode) {
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 10.0F, Explosion.DestructionType.BREAK);
        } else if (SpeedrunnerMod.CONFIG.difficulty == 1) {
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 3.0F, Explosion.DestructionType.BREAK);
        } else if (SpeedrunnerMod.CONFIG.difficulty == 2 || SpeedrunnerMod.CONFIG.difficulty == 3) {
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 4.0F, Explosion.DestructionType.BREAK);
        } else if (SpeedrunnerMod.CONFIG.difficulty == 4) {
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 5.0F, Explosion.DestructionType.BREAK);
        } else {
            this.world.createExplosion(this, this.getX(), this.getBodyY(0.0625D), this.getZ(), 3.0F, Explosion.DestructionType.BREAK);
        }
    }

    @Override
    public boolean canExplosionDestroyBlock(Explosion explosion, BlockView world, BlockPos pos, BlockState state, float explosionPower) {
        return !(this.world instanceof ServerWorld) || this.world.getRegistryKey() != World.END || !SpeedrunnerMod.CONFIG.doomMode;
    }
}