package fr.azrotho.bamboocounter.listener;

import org.bukkit.Material;
import org.bukkit.block.Hopper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

import fr.azrotho.bamboocounter.BambooCounter;

public class HopperListener implements Listener {
    @EventHandler
    public void on(InventoryMoveItemEvent event) {
        if (event.getSource().getHolder() instanceof Hopper hopper) {
            if(hopper.getCustomName() != null && hopper.getCustomName().equals("Compteur")) {
                if(event.getItem().getType().equals(Material.BAMBOO)) {
                    BambooCounter.bambooCount += event.getItem().getAmount();
                }
            }
        }
    }
}
