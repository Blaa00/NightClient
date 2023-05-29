package net.bla0.nightclient.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

import java.util.Objects;

public class FreecamModule extends Module {

    OtherClientPlayerEntity fakePlayer;

    protected FreecamModule() {
        super("Freecam", "Lets you move your camera without effecting the player", ModuleType.TEST);
    }

    @Override
    public void onEnable() {
        assert MinecraftClient.getInstance().world != null;
        assert MinecraftClient.getInstance().player != null;
        fakePlayer = new OtherClientPlayerEntity(MinecraftClient.getInstance().world, MinecraftClient.getInstance().player.getGameProfile());
        fakePlayer.copyFrom(MinecraftClient.getInstance().player);
        MinecraftClient.getInstance().world.addEntity(fakePlayer.getId(), fakePlayer);
        fakePlayer.setCustomName(Text.of("Hello"));
        MinecraftClient.getInstance().player.sendMessage(Text.of("Cloning started!"), true);
        System.out.println(fakePlayer.getHeight());
    }

    @Override
    public void onDisable() {
        MinecraftClient.getInstance().world.removeEntity(fakePlayer.getId(), Entity.RemovalReason.DISCARDED);
        MinecraftClient.getInstance().player.sendMessage(Text.of("Cloning stopped!"), true);
    }

    @Override
    public void onTick() {
        //MinecraftClient.getInstance().cameraEntity.move(MovementType.PLAYER, MinecraftClient.getInstance().player.getVelocity().add(2, 2, 2));
        fakePlayer.baseTick();
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
