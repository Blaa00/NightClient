package net.bla0.nightclient.modules;

import net.bla0.nightclient.utils.PacketHelper;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public class NoFallModule extends Module {
    protected NoFallModule() {
        super("NoFall", "Removes fall damage by resetting velocity when close to ground", ModuleType.TEST);
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onTick() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        Vec3d velocity = player.getVelocity();

        // Define the number of rays to cast and the angle between each ray
        int numRays = 5;
        float rayAngle = 15.0f; // in degrees

        // Calculate the starting position for each ray
        Vec3d[] rayStarts = new Vec3d[numRays];
        for (int i = 0; i < numRays; i++) {
            float yaw = player.getYaw() + (i - (numRays / 2)) * rayAngle;
            Vec3d rayDirection = new Vec3d(Math.sin(Math.toRadians(yaw)), -1, Math.cos(Math.toRadians(yaw))).normalize();
            rayStarts[i] = new Vec3d(player.getPos().getX(), player.getPos().getY() - 4, player.getPos().getZ()).add(rayDirection);
        }

        // Cast each ray and check for collisions
        boolean willCollide = false;
        for (Vec3d rayStart : rayStarts) {
            BlockHitResult result = player.world.raycast(new RaycastContext(rayStart, rayStart.add(new Vec3d(0, 1, 0)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player));
            if (result.getType() == HitResult.Type.BLOCK) {
                // There is a block that the player may collide with
                BlockState state = player.world.getBlockState(result.getBlockPos());
                // Do something with the block state
                willCollide = true;
                break;
            }
        }

        if (velocity.y < -0.5 && willCollide) {//MinecraftClient.getInstance().world.raycast(new RaycastContext(player.getPos(), player.getPos().add(new Vec3d(0,-6,0)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, player)).getType() == HitResult.Type.BLOCK) {
            PacketHelper.sendPosition(MinecraftClient.getInstance().player.getPos().subtract(0, 0.05, 0));
            //player.setVelocity(velocity.multiply(1,0,1).add(0,0.01,0));
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
