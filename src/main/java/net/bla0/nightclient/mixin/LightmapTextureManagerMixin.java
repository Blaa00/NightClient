package net.bla0.nightclient.mixin;

import net.bla0.nightclient.modules.ModuleRegistry;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import static net.bla0.nightclient.modules.FullbrightModule.gammaValue;

@Mixin(LightmapTextureManager.class)
public class LightmapTextureManagerMixin {

    /*
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/GameOptions;getGamma()Lnet/minecraft/client/option/SimpleOption;", opcode = Opcodes.INVOKEVIRTUAL), method = "update(F)V")
    private SimpleOption<Double> getFieldValue(GameOptions options) {
        if (ModuleRegistry.getByAlias("fullbright").enabled) {
            return gammaValue;
        } else {
            return options.getGamma();
        }
    }
    */
    @ModifyArgs(method = "update", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/NativeImage;setColor(III)V"))
    private void update(Args args) {
        if (ModuleRegistry.getByAlias("fullbright").enabled || ModuleRegistry.getByAlias("xray").enabled) {
            args.set(2, 0xFFFFFFFF);
        }
    }

}
