package de.daschi.pscore;

import de.daschi.pscore.config.CoreConfig;
import de.daschi.pscore.mysql.CoreMySQL;
import de.daschi.pscore.ps.PSMain;
import java.io.IOException;
import org.simpleyaml.exceptions.InvalidConfigurationException;

public final class PSCore extends PSMain {

  public static String getVersion() {
    return PSMain.getJavaPlugin().getDescription().getVersion();
  }

  @Override
  public void load() {
    try {
      CoreConfig.loadConfig();
    } catch (final IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }

    CoreMySQL.loadMySQL();
  }

  @Override
  public void enable() {}

  @Override
  public void disable() {}
}
