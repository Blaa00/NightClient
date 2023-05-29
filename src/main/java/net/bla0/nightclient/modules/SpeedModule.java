package net.bla0.nightclient.modules;

import net.bla0.nightclient.NightClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;


public class SpeedModule extends Module {


    protected SpeedModule() {
        super("Speed", "Makes you go fast", ModuleType.TEST);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    float walkSpeed = 50;
    float defaultSpeed;

    @Override
    public void onTick() {
        float speed = NightClient.speed.getValue();
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if(player.isSneaking()
                || player.forwardSpeed == 0 && player.sidewaysSpeed == 0)
            return;

        if (!player.isOnGround()) return;

        Vec3d currentVelocity = player.getVelocity();
        player.setVelocity(currentVelocity.x*speed, currentVelocity.y+0.1, currentVelocity.z*speed);
        currentVelocity = player.getVelocity();
        double currentSpeed = Math.sqrt(Math.pow(currentVelocity.x, 2)+Math.pow(currentVelocity.z, 2));

        double maxSpeed = 0.66f;
        if (currentSpeed > maxSpeed) {
            System.out.println(maxSpeed);
            player.setVelocity(currentVelocity.x/currentSpeed*maxSpeed, currentVelocity.y, currentVelocity.z/currentSpeed*maxSpeed);
        }
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
