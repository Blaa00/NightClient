package net.bla0.nightclient;

import com.mojang.serialization.Codec;
import net.bla0.nightclient.commands.CommandRegistry;
import net.bla0.nightclient.modules.XRayModule;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.BackupPromptScreen;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import org.lwjgl.glfw.Callbacks;

import java.util.Arrays;

public class NightClient implements ModInitializer {
    public static String PREFIX = ".";

    public static MinecraftClient client = MinecraftClient.getInstance();

    private static float speedValue = 2f;



    public static SimpleOption<Integer> speed = new SimpleOption("hax.options.speed", SimpleOption.emptyTooltip(), (optionText, value) -> {
        return Text.of("Speed: "+value);
    }, new SimpleOption.ValidatingIntSliderCallbacks(0, 10), Codec.INT, 2, (value) -> {});

    @Override
    public void onInitialize() {
        speed.setValue(2);
        System.out.println(speed == null);
        /*CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
        if (dispatcher.startsWith(NightClient.PREFIX)) {
            System.out.printf("Command received: %s%n", message);
            String strippedMessage = message.substring(NightClient.PREFIX.length());
            if (strippedMessage.isBlank() || strippedMessage.isEmpty()) {
                MinecraftClient.getInstance().player.sendMessage(Text.of("NightClient :)"));return;}
            String[] args = strippedMessage.trim().split(" +");
            String command = args[0];
            args = Arrays.copyOfRange(args, 1, args.length);
            if (CommandRegistry.getByAlias(command) == null) {
                MinecraftClient.getInstance().player.sendMessage(Text.of("Invalid Command!"));
                return;
            }

            CommandRegistry.getByAlias(command).execute(args);

        } else {
            MinecraftClient.getInstance().player.sendMessage(Text.of(message));
        }
        }));*/
    }
}
