package net.bla0.nightclient.utils;

import net.bla0.nightclient.mixin.ClientConnectionInvoker;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;

public class PacketHelper {

    public static void sendPosition(Vec3d pos) {
        ClientConnectionInvoker conn = (ClientConnectionInvoker) MinecraftClient.getInstance().player.networkHandler.getConnection();
        conn.sendIm(new PlayerMoveC2SPacket.PositionAndOnGround(pos.x, pos.y, pos.z, false), null);
    }
}
