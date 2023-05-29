package net.bla0.nightclient.commands;

import net.minecraft.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandRegistry {
    private static final List<Command> commands = Util.make(new ArrayList<>(), CommandRegistry::initCommands);

    private static void initCommands(List<Command> commands) {
        commands.add(new SayCommand());
        commands.add(new ToggleCommand());
        commands.add(new HelpCommand());
        commands.add(new CommandsCommand());
        commands.add(new ModulesCommand());
        commands.add(new TpCommand());
        commands.add(new FakePlayerCommand());
    }

    public static List<Command> getCommands() {
        return commands;
    }

    public static Command getByAlias(String lookCommand) {
        for (Command command : getCommands()) {
            if (Arrays.stream(command.triggers).anyMatch(s -> s.equalsIgnoreCase(lookCommand))) {
                return command;
            }
        }
        return null;
    }
}
