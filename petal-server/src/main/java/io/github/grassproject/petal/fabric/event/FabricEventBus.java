package io.github.grassproject.petal.fabric.event;

import io.github.grassproject.petal.bridge.event.PetalEvent;

public class FabricEventBus {
    private FabricEventBus() {}

    public static void post(PetalEvent event) {
        System.out.println(
            "[Petal/Fabric] Event received: " + event.getClass().getSimpleName()
        );
    }
}
