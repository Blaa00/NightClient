package net.bla0.nightclient.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public abstract class CameraMixin {

    @Shadow protected abstract void moveBy(double x, double y, double z);

    @Inject(at = @At("TAIL"), method = "update")
    void update(CallbackInfo ci) {
        //this.moveBy(MinecraftClient.getInstance().player.getVelocity().x+2, MinecraftClient.getInstance().player.getVelocity().y+2, MinecraftClient.getInstance().player.getVelocity().z+2);
        //MinecraftClient.getInstance().player.setVelocity(0, 0, 0);
    }
}
