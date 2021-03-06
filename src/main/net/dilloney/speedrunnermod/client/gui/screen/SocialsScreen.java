package net.dilloney.speedrunnermod.client.gui.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ConfirmChatLinkScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget.TooltipSupplier;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
class SocialsScreen extends GameOptionsScreen {
    private static final String CURSEFORGE_LINK = "https://www.curseforge.com/minecraft/mc-mods/speedrunner-mod";
    private static final String DISCORD_LINK = "https://discord.gg/Qu8utnCwkq";
    private static final String GITHUB_LINK = "https://github.com/Dilloney/Speedrunner-Mod/";
    private static final String YOUTUBE_LINK = "https://www.youtube.com/channel/UCNZVI8pFpzn-eXEZsyDEagg";
    private static final String TWITCH_LINK = "https://www.twitch.tv/dilloney";
    private final Screen parent;

    protected SocialsScreen(Screen parent, GameOptions options) {
        super(parent, options, new TranslatableText("speedrunnermod.socials"));
        this.parent = parent;
    }

    protected void init() {
        super.init();
        int leftSide = this.width / 2 - 155;
        int rightSide = leftSide + 160;
        int height = this.height / 6 - 12;
        this.addDrawableChild(new ButtonWidget(leftSide, height, 150, 20, new TranslatableText("speedrunnermod.curseforge"), (buttonWidget) -> {
            this.client.setScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open(CURSEFORGE_LINK);
                }

                this.client.setScreen(this);
            }, CURSEFORGE_LINK, true));
        }));
        this.addDrawableChild(new ButtonWidget(rightSide, height, 150, 20, new TranslatableText("speedrunnermod.discord"), (buttonWidget) -> {
            this.client.setScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open(DISCORD_LINK);
                }

                this.client.setScreen(this);
            }, DISCORD_LINK, false));
        }, new TooltipSupplier() {
            public void onTooltip(ButtonWidget button, MatrixStack matrices, int mouseX, int mouseY) {
                SocialsScreen.this.renderTooltip(matrices, new TranslatableText("speedrunnermod.discord.tooltip"), mouseX, mouseY);
            }

            public void supply(Consumer<Text> consumer) {
                consumer.accept(new TranslatableText("speedrunnermod.discord.tooltip"));
            }
        }));
        height += 24;
        this.addDrawableChild(new ButtonWidget(leftSide, height, 150, 20, new TranslatableText("speedrunnermod.github"), (buttonWidget) -> {
            this.client.setScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open(GITHUB_LINK);
                }

                this.client.setScreen(this);
            }, GITHUB_LINK, false));
        }));
        this.addDrawableChild(new ButtonWidget(rightSide, height, 150, 20, new TranslatableText("speedrunnermod.youtube"), (buttonWidget) -> {
            this.client.setScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open(YOUTUBE_LINK);
                }

                this.client.setScreen(this);
            }, YOUTUBE_LINK, true));
        }, new TooltipSupplier() {
            public void onTooltip(ButtonWidget button, MatrixStack matrices, int mouseX, int mouseY) {
                SocialsScreen.this.renderTooltip(matrices, new TranslatableText("speedrunnermod.youtube.tooltip"), mouseX, mouseY);
            }

            public void supply(Consumer<Text> consumer) {
                consumer.accept(new TranslatableText("speedrunnermod.youtube.tooltip"));
            }
        }));
        height += 24;
        this.addDrawableChild(new ButtonWidget(leftSide, height, 150, 20, new TranslatableText("speedrunnermod.twitch"), (buttonWidget) -> {
            this.client.setScreen(new ConfirmChatLinkScreen((openInBrowser) -> {
                if (openInBrowser) {
                    Util.getOperatingSystem().open(TWITCH_LINK);
                }

                this.client.setScreen(this);
            }, TWITCH_LINK, false));
        }, new TooltipSupplier() {
            public void onTooltip(ButtonWidget button, MatrixStack matrices, int mouseX, int mouseY) {
                SocialsScreen.this.renderTooltip(matrices, new TranslatableText("speedrunnermod.twitch.tooltip"), mouseX, mouseY);
            }

            public void supply(Consumer<Text> consumer) {
                consumer.accept(new TranslatableText("speedrunnermod.twitch.tooltip"));
            }
        }));
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height - 29, 200, 20, ScreenTexts.DONE, (button) -> {
            this.client.setScreen(this.parent);
        }));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
    }
}