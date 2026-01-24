package io.github.grassproject.petal.fabric;

import io.github.grassproject.petal.bridge.PetalBridge;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PetalFabricEndPoint implements ModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("Petal / Fabric");

    @Override
    public void onInitialize() {
        PetalBridge.markFabricLoaded();

        LOGGER.info("Loading...");
    }
}
