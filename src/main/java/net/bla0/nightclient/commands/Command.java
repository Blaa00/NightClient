package net.bla0.nightclient.commands;

public abstract class Command {
    public final String name, description;

    public final String[] triggers;

    public Command(String name, String description, String... triggers) {
        this.name = name;
        this.description = description;
        this.triggers = triggers;
    }

    public abstract void execute(String[] args);
}
