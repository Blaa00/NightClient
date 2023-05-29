package net.bla0.nightclient.commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.Comparator;

public class CommandsCommand extends Command {

    public CommandsCommand() {
        super("Commands", "Shows all the commands", "commands", "command", "programs");
    }

    @Override
    public void execute(String[] args) {
        for (Command command : CommandRegistry.getCommands()) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(command.name+", Description: "+command.description+", alias: " + Arrays.toString(command.triggers).strip()));
        }
    }
}
