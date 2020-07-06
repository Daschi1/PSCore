package de.daschi.pscore.ps;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class PSMain extends JavaPlugin {

  private static JavaPlugin javaPlugin;

  public static JavaPlugin getJavaPlugin() { return PSMain.javaPlugin; }

  public abstract void load();

  public abstract void enable();

  public abstract void disable();

  @Override
  public void onLoad() {
    super.onLoad();

    PSMain.javaPlugin = this;

    this.load();
  }

  @Override
  public void onEnable() {
    super.onEnable();

    this.enable();
  }

  @Override
  public void onDisable() {
    super.onDisable();

    this.disable();
  }
}
