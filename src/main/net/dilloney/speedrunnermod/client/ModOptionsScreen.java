package net.dilloney.speedrunnermod.client;

import net.dilloney.speedrunnermod.option.ModOptions;
import net.dilloney.speedrunnermod.option.OptionsFileManager;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.TranslatableText;

@Environment(EnvType.CLIENT)
class ModOptionsScreen {

    protected static ConfigBuilder openScreen() {

        ConfigBuilder builder = ConfigBuilder.create().setParentScreen(MinecraftClient.getInstance().currentScreen).setTitle(new TranslatableText("speedrunnermod.title.options"));

        ModOptions options = OptionsFileManager.getMain();

        ConfigEntryBuilder entryBuilder = builder.entryBuilder();

        builder.setSavingRunnable(() -> {
            OptionsFileManager.setMain(options);
        });

        ConfigCategory speedrunnermodoptions = builder.getOrCreateCategory(new TranslatableText("speedrunnermod.options.main"));
        ConfigCategory speedrunnermodMoptions = builder.getOrCreateCategory(new TranslatableText("speedrunnermod.options.misc"));

        speedrunnermodoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.make_structures_more_common"), options.makeStructuresMoreCommon).setDefaultValue(options.makeStructuresMoreCommon).setTooltip(new TranslatableText("options.make_structures_more_common.tooltip")).requireRestart().setSaveConsumer(newValue -> options.makeStructuresMoreCommon = newValue).build());
        speedrunnermodoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.icarus_mode"), options.iCarusMode).setDefaultValue(options.iCarusMode).setTooltip(new TranslatableText("options.icarus_mode.tooltip")).setSaveConsumer(newValue -> options.iCarusMode = newValue).build());
        speedrunnermodoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.infini_pearl_mode"), options.infiniPearlMode).setDefaultValue(options.infiniPearlMode).setTooltip(new TranslatableText("options.infini_pearl_mode.tooltip")).setSaveConsumer(newValue -> options.infiniPearlMode = newValue).build());
        speedrunnermodoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.fog"), options.fog).setDefaultValue(options.fog).setTooltip(new TranslatableText("options.fog.tooltip")).setSaveConsumer(newValue -> options.fog = newValue).build());
        speedrunnermodoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.timer"), options.timer).setDefaultValue(options.timer).setTooltip(new TranslatableText("options.timer.tooltip")).requireRestart().setSaveConsumer(newValue -> options.timer = newValue).build());
        speedrunnermodoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.doom_mode"), options.doomMode).setDefaultValue(options.doomMode).setTooltip(new TranslatableText("options.doom_mode.tooltip")).requireRestart().setSaveConsumer(newValue -> options.doomMode = newValue).build());

        speedrunnermodMoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.make_biomes_more_common"), options.makeBiomesMoreCommon).setDefaultValue(options.makeBiomesMoreCommon).setTooltip(new TranslatableText("options.make_biomes_more_common.tooltip")).requireRestart().setSaveConsumer(newValue -> options.makeBiomesMoreCommon = newValue).build());
        speedrunnermodMoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.modified_saturation_and_hunger_values"), options.modifiedSaturationAndHungerValues).setDefaultValue(options.modifiedSaturationAndHungerValues).setTooltip(new TranslatableText("options.modified_saturation_and_hunger_values.tooltip")).requireRestart().setSaveConsumer(newValue -> options.modifiedSaturationAndHungerValues = newValue).build());
        speedrunnermodMoptions.addEntry(entryBuilder.startIntField(new TranslatableText("options.stronghold_count"), options.strongholdCount).setDefaultValue(options.strongholdCount).setMin(64).setMax(256).setTooltip(new TranslatableText("options.stronghold_count.tooltip")).requireRestart().setSaveConsumer(newValue -> options.strongholdCount = newValue).build());
        speedrunnermodMoptions.addEntry(entryBuilder.startBooleanToggle(new TranslatableText("options.kill_ghast_upon_fireball"), options.killGhastUponFireball).setDefaultValue(options.killGhastUponFireball).setTooltip(new TranslatableText("options.kill_ghast_upon_fireball.tooltip")).setSaveConsumer(newValue -> options.killGhastUponFireball = newValue).build());
        speedrunnermodMoptions.addEntry(entryBuilder.startIntField(new TranslatableText("options.ender_eyes_lifespan"), options.enderEyesLifespan).setDefaultValue(options.enderEyesLifespan).setMin(40).setMax(80).setTooltip(new TranslatableText("options.ender_eyes_lifespan.tooltip")).setSaveConsumer(newValue -> options.enderEyesLifespan = newValue).build());
        speedrunnermodMoptions.addEntry(entryBuilder.startEnumSelector(new TranslatableText("options.mod_button_side"), ModOptions.ModButtonSide.class, options.modButtonSide).setDefaultValue(options.modButtonSide).setTooltip(new TranslatableText("options.mod_button_side.tooltip")).setSaveConsumer(newValue -> options.modButtonSide = newValue).build());
        return builder;
    }
}