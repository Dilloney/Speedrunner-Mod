package net.dilloney.speedrunnermod.client.gui.widget;

import net.dilloney.speedrunnermod.SpeedrunnerModClient;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.SaveLevelScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class ModButtonGM extends Screen {

    public ModButtonGM(Text title) {
        super(title);
    }

    @Shadow @Final
    private boolean showMenu;

    @Inject(method = "initWidgets", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        if (SpeedrunnerModClient.clOptions().autoCreateWorld && showMenu) {
            ButtonWidget createWorldButton = this.addButton(new ButtonWidget(this.width / 2 - 4 - 120 - 2, this.height / 4 + 72 + -16, 20, 20, new LiteralText(""), (buttonWidget) -> {
                if (this.client.inGameHud != null) {
                    this.client.inGameHud.getChatHud().clear(false);
                }
                this.client.world.disconnect();
                this.client.disconnect(new SaveLevelScreen(new TranslatableText("menu.savingLevel")));
                this.client.openScreen(CreateWorldScreen.method_31130(this));
            }));
            createWorldButton.active = SpeedrunnerModClient.clOptions().autoCreateWorld;
        }
    }

    @Inject(method = "render", at = @At("TAIL"))
    private void renderButton(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (SpeedrunnerModClient.clOptions().autoCreateWorld && showMenu) {
            this.client.getTextureManager().bindTexture(new Identifier("speedrunnermod:textures/item/speedrunner_boots.png"));
            drawTexture(matrices, this.width / 2 - 4 - 118 - 2, this.height / 4 + 72 + -16 + 2, 0.0F, 0.0F, 16, 16, 16, 16);
        }
    }
}