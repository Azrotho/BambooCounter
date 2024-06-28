package fr.azrotho.bamboocounter.runnable;

import org.bukkit.scheduler.BukkitRunnable;

import fr.azrotho.bamboocounter.utils.SaveAndLoad;

public class AutoSaveRunnable extends BukkitRunnable {

    @Override
    public void run() {
        SaveAndLoad.save();
    }

}
