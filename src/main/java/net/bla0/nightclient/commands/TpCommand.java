package net.bla0.nightclient.commands;

import net.bla0.nightclient.utils.PacketHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class TpCommand extends Command {
    public TpCommand() {
        super("Tp", "Tp anywhere", "tp");
    }

    @Override
    public void execute(String[] args) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (args.length < 3) {
            player.sendMessage(Text.of("Invalid Arguments"));
            return;
        }
        int[] intArgs = new int[3];
        try {
            for (int i = 0; i < 3; i++) {
                intArgs[i] = Integer.parseInt(args[i]);
            }
        } catch (Exception exception) {
            player.sendMessage(Text.of(exception.getMessage()));
            return;
        }

        Vec3d tpPos = new Vec3d(intArgs[0], intArgs[1], intArgs[2]);

        double tplength = player.getPos().multiply(1, 0, 1).add(0, 324, 0).distanceTo(player.getPos())+player.getPos().multiply(1, 0, 1).add(0, 324, 0).distanceTo(tpPos.multiply(1,0,1).add(0, 324, 0))+tpPos.distanceTo(tpPos.multiply(1,0,1).add(0, 324, 0));
        for (int i = 0; i < Math.ceil(Math.sqrt(tplength)); i++) {
            PacketHelper.sendPosition(player.getPos());
        }
        PacketHelper.sendPosition(player.getPos().multiply(1, 0, 1).add(0, 324, 0));
        PacketHelper.sendPosition(tpPos.multiply(1,0,1).add(0, 324, 0));
        PacketHelper.sendPosition(tpPos);
    }
}
