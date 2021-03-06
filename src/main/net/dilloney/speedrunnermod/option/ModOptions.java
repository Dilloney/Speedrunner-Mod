package net.dilloney.speedrunnermod.option;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.dilloney.speedrunnermod.SpeedrunnerMod;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class ModOptions {
    private static final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
    private static final String CONFIG = "speedrunnermod-options.json";
    private static File file;
    public static ModOptions OPTIONS = getConfig();
    private static final String OLD_CONFIG = "speedrunnermod_options.json";
    private static File old_config_file;
    public final Main main = new Main();
    public final Advanced advanced = new Advanced();

    public static class Main {

        public boolean makeStructuresMoreCommon = true;
        public boolean makeBiomesMoreCommon = true;
        public boolean iCarusMode = false;
        public boolean infiniPearlMode = false;
        public boolean doomMode = false;
        public boolean modifiedBlockHardness = true;
        public boolean killGhastUponFireball = false;
        public int strongholdCount = 128;
        public int dragonPerchTime = 30;
    }

    public static class Advanced {

        public MobSpawningRate mobSpawningRate = MobSpawningRate.HIGH;
        public boolean modifiedBiomes = true;
        public boolean modifiedFoods = true;
        public boolean modifiedItemEffects = true;
        public boolean makeOresMoreCommon = true;
        public int mobSpawnerSpawnDuration = 40;
        public int strongholdDistance = 4;
        public boolean debugMode = false;

        public enum MobSpawningRate {
            LOW(0, "options.mob_spawning_rate.low"),
            NORMAL(1, "options.mob_spawning_rate.normal"),
            HIGH(2, "options.mob_spawning_rate.high");

            private static final MobSpawningRate[] VALUES = (MobSpawningRate[])Arrays.stream(values()).sorted(Comparator.comparingInt(MobSpawningRate::getId)).toArray((i) -> {
                return new MobSpawningRate[i];
            });
            private final int id;
            private final String translateKey;

            MobSpawningRate(int id, String translationKey) {
                this.id = id;
                this.translateKey = Objects.requireNonNull(translationKey, "translateKey");
            }

            public int getId() {
                return this.id;
            }

            public String getTranslationKey() {
                return this.translateKey;
            }
        }
    }

    public static void loadConfig() {
        File configFile = getConfigFile();
        File oldConfigFile = getOldConfigFile();
        if (oldConfigFile.exists()) {
            oldConfigFile.delete();
            SpeedrunnerMod.LOGGER.warn("Found an old configuration file, deleting.");
        }

        if (!configFile.exists()) {
            OPTIONS = new ModOptions();
        } else {
            sanitize();
            readConfig();
        }
        saveConfig();
    }

    private static void readConfig() {
        OPTIONS = getConfig();
    }

    public static void saveConfig() {
        File file = getConfigFile();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(GSON.toJson(SpeedrunnerMod.options()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setConfig(ModOptions config) {
        OPTIONS = config;
        saveConfig();
    }

    private static ModOptions getConfig() {
        File file = getConfigFile();
        try (FileReader reader = new FileReader(file)) {
            return GSON.fromJson(reader, ModOptions.class);
        } catch (Exception e) {
            ModOptions newconfig = new ModOptions();
            setConfig(newconfig);
            return newconfig;
        }
    }

    private static File getConfigFile() {
        if (file == null) {
            file = new File(FabricLoader.getInstance().getConfigDir().toFile(), CONFIG);
        }
        return file;
    }

    private static void sanitize() {
        if (SpeedrunnerMod.options().advanced.mobSpawningRate == null) {
            SpeedrunnerMod.options().advanced.mobSpawningRate = ModOptions.Advanced.MobSpawningRate.HIGH;
        }
    }

    private static File getOldConfigFile() {
        if (old_config_file == null) {
            old_config_file = new File(FabricLoader.getInstance().getConfigDir().toFile(), OLD_CONFIG);
        }
        return old_config_file;
    }
}