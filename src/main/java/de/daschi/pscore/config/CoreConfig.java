package de.daschi.pscore.config;

import de.daschi.pscore.PSCore;
import java.io.File;
import java.io.IOException;
import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.exceptions.InvalidConfigurationException;

public class CoreConfig {

  private static YamlFile yamlFile;

  public static void loadConfig()
      throws IOException, InvalidConfigurationException {
    CoreConfig.yamlFile = new YamlFile(
        new File("PSCore\\" + PSCore.getVersion() + "\\config.yml"));
    if (!CoreConfig.yamlFile.exists()) {
      final File[] files = new File("PSCore").listFiles();
      if (files != null && files.length - 2 >= 0) {
        final YamlFile oldConfig = new YamlFile(
            files[files.length - 2].getAbsolutePath() + "\\config.yml");
        if (oldConfig.exists()) {
          oldConfig.copyTo(
              CoreConfig.yamlFile.getConfigurationFile().getAbsolutePath());
        }
      }
    }
    CoreConfig.yamlFile.createNewFile(false);
    CoreConfig.yamlFile.loadWithComments();

    CoreConfig.yamlFile.addDefault("mysql.usingMySQL", false);
    CoreConfig.yamlFile.addDefault("mysql.hostname", "");
    CoreConfig.yamlFile.addDefault("mysql.port", 3306);
    CoreConfig.yamlFile.addDefault("mysql.username", "");
    CoreConfig.yamlFile.addDefault("mysql.password", "");
    CoreConfig.yamlFile.addDefault("mysql.database", "");

    CoreConfig.yamlFile.saveWithComments();
    CoreConfig.yamlFile.options().copyDefaults();
  }

  public static boolean isUsingMySQL() {
    return CoreConfig.yamlFile.getBoolean("mysql.usingMySQL");
  }

  public static String getHostname() {
    return CoreConfig.yamlFile.getString("mysql.hostname");
  }

  public static int getPort() {
    return CoreConfig.yamlFile.getInt("mysql.port");
  }

  public static String getUsername() {
    return CoreConfig.yamlFile.getString("mysql.username");
  }

  public static String getPassword() {
    return CoreConfig.yamlFile.getString("mysql.password");
  }

  public static String getDatabase() {
    return CoreConfig.yamlFile.getString("mysql.database");
  }
}
