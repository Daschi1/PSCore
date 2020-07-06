package de.daschi.pscore.mysql;

import de.daschi.core.MySQL;
import de.daschi.pscore.config.CoreConfig;

public class CoreMySQL {
  public static void loadMySQL() {
    if (!CoreConfig.isUsingMySQL()) {
      return;
    }
    MySQL.using(new MySQL(CoreConfig.getHostname(), CoreConfig.getPort(),
                          CoreConfig.getUsername(), CoreConfig.getPassword(),
                          CoreConfig.getDatabase()));
    MySQL.autoDisconnect(true);
  }
}
