package net.bla0.nightclient.modules;

import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

import javax.swing.text.html.parser.Entity;
import java.util.Objects;

public class ListModule extends Module {

    protected ListModule() {
        super("List", "A list with all enabled hacks.", ModuleType.TEST);
        enabled = true;
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

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
        int ay = 0;
        for (Module module : ModuleRegistry.getModules()) {
            if (module.isEnabled() && !Objects.equals(module.name, "list")) {
                DrawableHelper.drawTextWithShadow(stack, MinecraftClient.getInstance().textRenderer, Text.of(module.name), 5, 5+ay, 0xFFFFFF);
                ay += 10;
            }
        }
    }
}
