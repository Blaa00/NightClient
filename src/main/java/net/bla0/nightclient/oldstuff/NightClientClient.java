package net.bla0.nightclient.oldstuff.client;

import net.bla0.nightclient.oldstuff.NightClient;
import net.fabricmc.api.ClientModInitializer;

public class NightClientClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        NightClient.LOGGER.info("Client Initiated");
    }
}
