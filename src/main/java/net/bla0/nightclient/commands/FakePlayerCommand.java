package net.bla0.nightclient.commands;

import net.bla0.nightclient.client.FakePlayerEntity;

public class FakePlayerCommand extends Command {
    public FakePlayerCommand() {
        super("FakePlayer", "Spawns a fake player", "spawnplayer", "fakeplayer");
    }

    @Override
    public void execute(String[] args) {
        new FakePlayerEntity();
    }
}
