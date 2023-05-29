package net.bla0.nightclient.mixin;

import net.bla0.nightclient.NightClient;
import net.bla0.nightclient.commands.CommandRegistry;
import net.bla0.nightclient.modules.Module;
import net.bla0.nightclient.modules.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    MinecraftClient MC = MinecraftClient.getInstance();

    @Inject(method = "tick", at = @At("TAIL"))
    void postTick(CallbackInfo ci) {
        for (Module module : ModuleRegistry.getModules()) {
            if (module.isEnabled()) {
                module.onTick();
            }
            module.onBackgroundTick();
        }
    }

}
