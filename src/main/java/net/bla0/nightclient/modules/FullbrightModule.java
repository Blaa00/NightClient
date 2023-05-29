package net.bla0.nightclient.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;

public class FullbrightModule extends Module {

    public static SimpleOption<Double> gammaValue = new SimpleOption<>("options.gamma", SimpleOption.emptyTooltip(), (optionText, value) -> Text.empty(), SimpleOption.DoubleSliderCallbacks.INSTANCE.withModifier(d -> (double) 20f, d -> 1), 1.0, value -> {});
    private double lastGamma = MinecraftClient.getInstance().options.getGamma().getValue();

    protected FullbrightModule() {
        super("Fullbright", "See bright!", ModuleType.TEST);
    }

    @Override
    public void onEnable() {
        //MinecraftClient.getInstance().player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, Integer.MAX_VALUE));
        //lastGamma = MinecraftClient.getInstance().options.getGamma().getValue();
        //MinecraftClient.getInstance().options.getGamma().setValue(gammaValue.getValue());
    }

    @Override
    public void onDisable() {
        //MinecraftClient.getInstance().player.removeStatusEffect(StatusEffects.NIGHT_VISION);
        //MinecraftClient.getInstance().options.getGamma().setValue(lastGamma);
    }

    @Override
    public void onTick() {
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
