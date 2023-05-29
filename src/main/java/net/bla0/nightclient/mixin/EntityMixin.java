package net.bla0.nightclient.mixin;

import net.bla0.nightclient.modules.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin {

    @Inject(at = @At("RETURN"), method = "getCameraPosVec", cancellable = true)
    public void getCameraPosVec(float deltaTick, CallbackInfoReturnable<Vec3d> ci) {
        if (ModuleRegistry.getByAlias("freecam").enabled) {
            ci.setReturnValue(MinecraftClient.getInstance().player.getPos().add(2, 2, 2));
        }
    }
}
