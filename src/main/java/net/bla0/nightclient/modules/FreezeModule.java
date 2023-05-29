package net.bla0.nightclient.modules;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class FreezeModule extends Module {

    public FreezeModule() {
        super("Freeze", "Freezes your player", ModuleType.TEST);
    }

    private Vec3d lastTickPos;

    @Override
    public void onEnable() {
        lastTickPos = MinecraftClient.getInstance().player.getPos();
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick() {
        MinecraftClient.getInstance().player.setPosition(lastTickPos);//MinecraftClient.getInstance().player.setVelocity(0,0,0);
    }

    @Override
    public void onBackgroundTick() {
        lastTickPos = MinecraftClient.getInstance().player.getPos();
    }

    @Override
    public void onWorldRender(MatrixStack stack) {
    }

    @Override
    public void onHudRender(MatrixStack stack) {
    }
}
