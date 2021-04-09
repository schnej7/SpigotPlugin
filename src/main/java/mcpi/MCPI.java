package mcpi;

import mcpi.boom.BoomCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class MCPI extends JavaPlugin {
    @Override
    public void onDisable() {
        // Don't log disabling, Spigot does that for you automatically!
    }

    @Override
    public void onEnable() {
        // Don't log enabling, Spigot does that for you automatically!

        // Commands enabled with following method must have entries in plugin.yml
        getCommand("boom").setExecutor(new BoomCommand(this));
    }
}
