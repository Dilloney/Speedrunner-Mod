package net.dilloney.speedrunnermod.client.gui.screen.option;

import net.dilloney.speedrunnermod.SpeedrunnerMod;
import net.dilloney.speedrunnermod.option.CLModOptions;
import net.dilloney.speedrunnermod.option.ModOptions;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Option;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.OrderedText;
import net.minecraft.text.TranslatableText;

import java.util.List;

@Environment(EnvType.CLIENT)
public class ModOptionsScreen extends GameOptionsScreen {
    private static final Option[] OPTIONS;
    private ButtonListWidget list;

    public ModOptionsScreen(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("speedrunnermod.title.options"));
    }

    protected void init() {
        this.list = new ButtonListWidget(this.client, this.width, this.height, 32, this.height - 32, 25);
        this.list.addSingleOptionEntry(ModOption.MAKE_STRUCTURES_MORE_COMMON);
        this.list.addSingleOptionEntry(ModOption.MAKE_BIOMES_MORE_COMMON);
        this.list.addSingleOptionEntry(ModOption.MODIFIED_BLOCK_HARDNESS);
        this.list.addAll(OPTIONS);
        this.addSelectableChild(this.list);
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 29, 200, 20, ScreenTexts.DONE, (button) -> {
            ModOptions.saveConfig();
            CLModOptions.saveClientConfig();
            SpeedrunnerMod.LOGGER.info("Flushed changes to the Speedrunner Mod");
            this.client.setScreen(this.parent);
        }));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.list.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 12, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
        List<OrderedText> list = getHoveredButtonTooltip(this.list, mouseX, mouseY);
        if (list != null) {
            this.renderOrderedTooltip(matrices, list, mouseX, mouseY);
        }
    }

    public void onClose() {
        ModOptions.saveConfig();
        CLModOptions.saveClientConfig();
        SpeedrunnerMod.LOGGER.info("Flushed changes to the Speedrunner Mod");
        super.onClose();
    }

    static {
        OPTIONS = new Option[]{ModOption.ICARUS_MODE, ModOption.INFINITY_PEARL_MODE, ModOption.FOG, ModOption.DOOM_MODE, ModOption.KILL_GHAST_UPON_FIREBALL, ModOption.STRONGHOLD_COUNT, ModOption.DRAGON_PERCH_TIME, ModOption.AUTO_CREATE_WORLD, ModOption.WORLD_DIFFICULTY, ModOption.ALLOW_CHEATS};
    }
}