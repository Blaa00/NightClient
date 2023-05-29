package net.bla0.nightclient.commands;

import net.bla0.nightclient.modules.Module;
import net.bla0.nightclient.modules.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.Arrays;

public class ModulesCommand extends Command {

    public ModulesCommand() {
        super("Modules", "Shows all the modules", "modules", "module", "hacks", "hax");
    }

    @Override
    public void execute(String[] args) {
        for (Module module : ModuleRegistry.getModules()) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(module.name+", Description: "+module.description));
        }
    }
}
