package de.daschi.pscore;

import de.daschi.pscore.config.CoreConfig;
import de.daschi.pscore.mysql.CoreMySQL;
import java.io.IOException;
import org.bukkit.plugin.java.JavaPlugin;
import org.simpleyaml.exceptions.InvalidConfigurationException;

public final class PSCore extends JavaPlugin {

  private static JavaPlugin javaPlugin;

  public static String getVersion() {
    return PSCore.javaPlugin.getDescription().getVersion();
  }

  public static JavaPlugin getJavaPlugin() { return PSCore.javaPlugin; }

  @Override
  public void onLoad() {
    super.onLoad();
    PSCore.javaPlugin = this;

    try {
      CoreConfig.loadConfig();
    } catch (final IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }

    CoreMySQL.loadMySQL();
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
