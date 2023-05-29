package net.bla0.nightclient.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public class ElytraModule extends Module {

    protected ElytraModule() {
        super("Elytra", "Makes the elytra controls easier", ModuleType.TEST);
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
        int speed = 2;
        Vec3d velocity = new Vec3d(0,0,0);
        if (MinecraftClient.getInstance().player.isFallFlying()) {
            if (MinecraftClient.getInstance().options.jumpKey.isPressed()) {
                velocity = velocity.add(0, 0.5, 0);
            }
            if (MinecraftClient.getInstance().options.sneakKey.isPressed()) {
                velocity = velocity.add(0, -0.5, 0);
            }
            if (MinecraftClient.getInstance().options.forwardKey.isPressed()) {
                //velocity = velocity.add(MinecraftClient.getInstance().player.getRotationVecClient().multiply(1, 0, 1));
                velocity = velocity.add(new Vec3d(Math.cos(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw())), 0, Math.sin(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw()))).multiply(-1, 0, 1));
            }
            if (MinecraftClient.getInstance().options.leftKey.isPressed()) {
                velocity = velocity.add(new Vec3d(Math.cos(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw()-90)), 0, Math.sin(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw()-90))).multiply(-1, 0, 1));
            }
            if (MinecraftClient.getInstance().options.rightKey.isPressed()) {
                velocity = velocity.add(new Vec3d(Math.cos(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw()+90)), 0, Math.sin(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw()+90))).multiply(-1, 0, 1));
            }
            if (MinecraftClient.getInstance().options.backKey.isPressed()) {
                velocity = velocity.add(new Vec3d(Math.cos(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw()+180)), 0, Math.sin(Math.PI/2-Math.toRadians(MinecraftClient.getInstance().player.getYaw()+180))).multiply(-1, 0, 1));
            }
            velocity = velocity.multiply(speed, speed, speed);
            HitResult hitResult = MinecraftClient.getInstance().player.world.raycast(new RaycastContext(MinecraftClient.getInstance().player.getEyePos(), MinecraftClient.getInstance().player.getEyePos().add(velocity), RaycastContext.ShapeType.COLLIDER   , RaycastContext.FluidHandling.NONE, MinecraftClient.getInstance().player));
            if (hitResult != null && hitResult.getType() == HitResult.Type.MISS) {
                MinecraftClient.getInstance().player.setPosition(lastTickPos.add(velocity));
            } else {
                MinecraftClient.getInstance().player.setPosition(lastTickPos);
            }
        }
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
