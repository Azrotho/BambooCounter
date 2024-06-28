package fr.azrotho.bamboocounter.runnable;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.azrotho.bamboocounter.BambooCounter;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class DisplayActionBarRunnable extends BukkitRunnable {

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(
                ChatMessageType.ACTION_BAR,
                new TextComponent("§a§lBambou: §r§f" + formatLong(BambooCounter.bambooCount) + " | §a§lJour: §f§l" + getDayNumber())
            );
        }
    }

    public static String formatLong(long number) {
        if (number == 0) {
            return "0";
        }
        
        String formattedNumber = String.format("%,.0f", number / 1.0);
        return formattedNumber;
    }

    public static String getDayNumber() {
        World world = Bukkit.getWorld("world");
        long time = world.getFullTime();
        long day = time / 24000;
        return String.valueOf(day);
    }
}
