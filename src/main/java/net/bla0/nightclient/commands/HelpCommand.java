package net.bla0.nightclient.commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.Arrays;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("Help", "Shows the help menu", "help", "h", "how", "hjälp", "?");
    }

    @Override
    public void execute(String[] args) {
        MinecraftClient.getInstance().player.sendMessage(Text.of(".help, Shows the help menu"));
        MinecraftClient.getInstance().player.sendMessage(Text.of(".commands, Shows all the commands"));
        MinecraftClient.getInstance().player.sendMessage(Text.of("., Info about the client"));
    }
}
