package net.bla0.nightclient.commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.Arrays;

public class SayCommand extends Command {

    public SayCommand() {
        super("Say", "Forward your message to the server", "say", "echo");
    }

    @Override
    public void execute(String[] args) {
        String smsg = "";
        for (String i : args) {
            smsg += i+" ";
        }

        MinecraftClient.getInstance().player.sendMessage(Text.of(smsg.toString()));
    }
}
