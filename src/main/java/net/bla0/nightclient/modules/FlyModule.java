package net.bla0.nightclient.modules;

import net.bla0.nightclient.utils.PacketHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

public class FlyModule extends Module {

    protected FlyModule() {
        super("Fly", "Gives you creative fly", ModuleType.TEST);
    }

    int tickCounter = 0;

    float flySpeed = 2;

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onTick() {
        MinecraftClient.getInstance().player.getAbilities().setFlySpeed((float) (flySpeed*0.1));
        tickCounter++;
        if (tickCounter >= 10) {
            PacketHelper.sendPosition(MinecraftClient.getInstance().player.getPos().subtract(0, 0.05, 0));
            tickCounter = 0;
        }
    }

    @Override
    public void onBackgroundTick() {
        MinecraftClient.getInstance().player.getAbilities().allowFlying = this.isEnabled();
    }

    @Override
    public void onWorldRender(MatrixStack stack) {

    }

    @Override
    public void onHudRender(MatrixStack stack) {

    }
}
