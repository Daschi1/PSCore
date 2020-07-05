package de.daschi.pscore;

import de.daschi.pscore.config.CoreConfig;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class PSCore extends JavaPlugin {

    private static JavaPlugin javaPlugin;

    public static String getVersion() {
        return PSCore.javaPlugin.getDescription().getVersion();
    }

    public static JavaPlugin getJavaPlugin() {
        return PSCore.javaPlugin;
    }

    @Override
    public void onLoad() {
        super.onLoad();

        try {
            CoreConfig.initialise();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
