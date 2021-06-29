package com.dilloney.speedrunnermod.mixins.world;

import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StrongholdConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Mixin(ChunkGenerator.class)
public class ChunkGeneratorMixin {

    @Shadow @Final BiomeSource populationSource;

    @Shadow @Final StructuresConfig structuresConfig;

    @Shadow @Final long worldSeed;

    @Shadow @Final List<ChunkPos> strongholds;

    @Overwrite
    private void generateStrongholdPositions() {
        if (this.strongholds.isEmpty()) {
            StrongholdConfig strongholdConfig = this.structuresConfig.getStronghold();
            if (strongholdConfig != null && strongholdConfig.getCount() != 0) {
                List<Biome> list = Lists.newArrayList();
                Iterator var3 = this.populationSource.getBiomes().iterator();

                while(var3.hasNext()) {
                    Biome biome = (Biome)var3.next();
                    if (biome.getGenerationSettings().hasStructureFeature(StructureFeature.STRONGHOLD)) {
                        list.add(biome);
                    }
                }

                int i = 4;
                int j = strongholdConfig.getCount();
                int k = 3;
                Random random = new Random();
                random.setSeed(this.worldSeed);
                double d = random.nextDouble() * 3.141592653589793D * 2.0D;
                int l = 0;
                int m = 0;

                for(int n = 0; n < j; ++n) {
                    double e = (double)(4 * i + i * m * 6) + (random.nextDouble() - 0.5D) * (double)i * 2.5D;
                    int o = (int)Math.round(Math.cos(d) * e);
                    int p = (int)Math.round(Math.sin(d) * e);
                    BlockPos blockPos = this.populationSource.locateBiome((o << 4) + 8, 0, (p << 4) + 8, 112, list::contains, random);
                    if (blockPos != null) {
                        o = blockPos.getX() >> 4;
                        p = blockPos.getZ() >> 4;
                    }

                    this.strongholds.add(new ChunkPos(o, p));
                    d += 6.283185307179586D / (double)k;
                    ++l;
                    if (l == k) {
                        ++m;
                        l = 0;
                        k += 2 * k / (m + 1);
                        k = Math.min(k, j - n);
                        d += random.nextDouble() * 3.141592653589793D * 2.0D;
                    }
                }

            }
        }
    }
}