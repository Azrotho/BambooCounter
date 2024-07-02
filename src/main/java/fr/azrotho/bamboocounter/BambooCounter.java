package fr.azrotho.bamboocounter;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.azrotho.bamboocounter.command.ResetTimeCommand;
import fr.azrotho.bamboocounter.listener.HopperListener;
import fr.azrotho.bamboocounter.runnable.AutoSaveRunnable;
import fr.azrotho.bamboocounter.runnable.DisplayActionBarRunnable;
import fr.azrotho.bamboocounter.utils.SaveAndLoad;

public class BambooCounter extends JavaPlugin {

    public static long bambooCount = 0;
    public static Plugin INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        SaveAndLoad.load();

        getLogger().info("BambooCounter enabled");
        getServer().getPluginManager().registerEvents(new HopperListener(), this);

        getCommand("resettime").setExecutor(new ResetTimeCommand());

        DisplayActionBarRunnable displayActionBarRunnable = new DisplayActionBarRunnable();
        displayActionBarRunnable.runTaskTimer(this, 0, 0);

        AutoSaveRunnable autoSaveRunnable = new AutoSaveRunnable();
        autoSaveRunnable.runTaskTimer(this, 0, 20 * 60);
    }

    @Override
    public void onDisable() {
        getLogger().info("BambooCounter disabled");
        SaveAndLoad.save();
    }
    
}
