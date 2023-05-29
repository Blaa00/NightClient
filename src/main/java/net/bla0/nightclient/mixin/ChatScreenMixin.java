package net.bla0.nightclient.mixin;

import net.bla0.nightclient.NightClient;
import net.bla0.nightclient.commands.CommandRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(ChatScreen.class)
public abstract class ChatScreenMixin {

    @Inject(method = "sendMessage(Ljava/lang/String;Z)Z", at = @At("HEAD"), cancellable = true)
    void redirectSendChatMessage(String message, boolean addToHistory, CallbackInfoReturnable<Boolean> cir) {
        if (message.startsWith(NightClient.PREFIX)) {
            System.out.printf("Command received: %s%n", message);
            String strippedMessage = message.substring(NightClient.PREFIX.length());
            if (strippedMessage.isBlank() || strippedMessage.isEmpty()) {
                MinecraftClient.getInstance().player.sendMessage(Text.of("NightClient :)"));cir.setReturnValue(true);return;}
            String[] args = strippedMessage.trim().split(" +");
            String command = args[0];
            args = Arrays.copyOfRange(args, 1, args.length);
            if (CommandRegistry.getByAlias(command) == null) {
                System.out.println("Hi");
                MinecraftClient.getInstance().player.sendMessage(Text.of("Invalid Command!"));
                cir.setReturnValue(true);
                return;
            }

            CommandRegistry.getByAlias(command).execute(args);
            cir.setReturnValue(true);
        } else {
            //MinecraftClient.getInstance().player.sendMessage(Text.of(message));
        }
    }
}
