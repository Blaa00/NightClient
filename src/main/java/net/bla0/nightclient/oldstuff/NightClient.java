package net.bla0.nightclient.oldstuff;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NightClient implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("nightclient");
    @Override
    public void onInitialize() {
        LOGGER.info("NightClient");
    }
}
