package net.bla0.nightclient.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.bla0.nightclient.modules.Module;
import net.bla0.nightclient.modules.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin  {

    @Inject(method="render", at=@At("RETURN"), cancellable = true)
    public void onRender(MatrixStack matrices, float tickDelta, CallbackInfo ci) {

        for (Module module : ModuleRegistry.getModules()) {
            if (module.isEnabled()) {
                module.onHudRender(matrices);
            }
        }

        DrawableHelper.drawTextWithShadow(matrices, MinecraftClient.getInstance().textRenderer, Text.of("NightClient"), MinecraftClient.getInstance().getWindow().getScaledWidth()-60, 5, 0xFFFFFF);
    }
}
