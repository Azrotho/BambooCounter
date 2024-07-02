package fr.azrotho.bamboocounter.command;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ResetTimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        for(World world : Bukkit.getWorlds()) {
            world.setFullTime(0L);
        }
        sender.sendMessage("§aLe temps a été réinitialisé.");
        return true;
    }
    
}
