package net.bla0.nightclient.client;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.data.DataTracker;

public class FakePlayerEntity extends OtherClientPlayerEntity {
    public FakePlayerEntity() {
        super(MinecraftClient.getInstance().world, MinecraftClient.getInstance().player.getGameProfile());
        copyFrom(MinecraftClient.getInstance().player);
        MinecraftClient.getInstance().world.addEntity(getId(), this);

    }
}
