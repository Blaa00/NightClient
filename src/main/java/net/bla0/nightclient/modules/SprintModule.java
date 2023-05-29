package net.bla0.nightclient.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class SprintModule extends Module {

    protected SprintModule() {
        super("Sprint", "Makes you sprint automatically", ModuleType.TEST);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick() {
        MinecraftClient.getInstance().player.setSprinting(true);
    }

    @Override
    public void onBackgroundTick() {

    }

    @Override
    public void onWorldRender(MatrixStack stack) {

    }

    @Override
    public void onHudRender(MatrixStack stack) {

    }
}
