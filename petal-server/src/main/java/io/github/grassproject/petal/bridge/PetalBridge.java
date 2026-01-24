package io.github.grassproject.petal.bridge;

import io.github.grassproject.petal.Petal;
import io.github.grassproject.petal.bridge.event.PetalEvent;
import io.github.grassproject.petal.fabric.event.FabricEventBus;
import net.minecraft.server.MinecraftServer;
import org.bukkit.craftbukkit.CraftServer;

public final class PetalBridge {

    public static MinecraftServer minecraftServer;
    public static CraftServer craftServer;

    private static boolean fabricLoaded = false;
    private static boolean paperLoaded = false;

    static {
        Petal.init();
    }

    public PetalBridge() {
    }

    public static void attachMinecraftServer(MinecraftServer server) {
        minecraftServer = server;
    }

    public static void attachCraftServer(CraftServer server) {
        craftServer = server;
    }

    public static MinecraftServer getMinecraftServer() {
        return minecraftServer;
    }

    public static CraftServer getCraftServer() {
        return craftServer;
    }

    public static void markFabricLoaded() {
        fabricLoaded = true;
    }

    public static void markPaperLoaded() {
        paperLoaded = true;
    }

    public static boolean isFabricLoaded() {
        return fabricLoaded;
    }

    public static boolean isPaperLoaded() {
        return paperLoaded;
    }

    // Events
    public static void postEvent(PetalEvent event) {
        if (!fabricLoaded) {
            return;
        }
        FabricEventBus.post(event);
    }
}
