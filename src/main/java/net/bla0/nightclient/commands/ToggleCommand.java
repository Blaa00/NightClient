package net.bla0.nightclient.commands;

import net.bla0.nightclient.modules.Module;
import net.bla0.nightclient.modules.ModuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class ToggleCommand extends Command {

    public ToggleCommand() {
        super("Toggle", "Toggles a module", "toggle", "enable", "disable", "state");
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Provide module a name!"));
            return;
        }
        String modName = args[0];
        Module modToToggle = ModuleRegistry.getByAlias(modName);
        if (modToToggle == null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Module doesn't exist!"));
            return;
        }
        modToToggle.setEnabled(!modToToggle.isEnabled());
        MinecraftClient.getInstance().player.sendMessage(Text.of(modToToggle.name + " is " + modToToggle.isEnabled()));
    }
}
