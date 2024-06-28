package fr.azrotho.bamboocounter.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fr.azrotho.bamboocounter.BambooCounter;

public class SaveAndLoad {
    public static void save() {
        // Save the bamboo count to a bamboo.txt file
        if(BambooCounter.INSTANCE.getDataFolder().exists()) {
            try {
                File file = new File(BambooCounter.INSTANCE.getDataFolder(), "bamboo.txt");
                FileWriter writer = new FileWriter(file);
                writer.write(String.valueOf(BambooCounter.bambooCount));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            BambooCounter.INSTANCE.getDataFolder().mkdir();
            save();
        }
    }

    public static void load() {
        // Load the bamboo count from a bamboo.txt file
        if(BambooCounter.INSTANCE.getDataFolder().exists()) {
            File file = new File(BambooCounter.INSTANCE.getDataFolder(), "bamboo.txt");
            if(file.exists()) {
                FileReader reader;
                try {
                    reader = new FileReader(file);
                    BambooCounter.INSTANCE.getLogger().info("Loading bamboo count from file, ");
                    String content = "";
                    for(int i = 0; i < file.length(); i++) {
                        content += (char)reader.read();
                    }
                    BambooCounter.INSTANCE.getLogger().info(content);
                    BambooCounter.bambooCount = Long.parseLong(content);
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            BambooCounter.INSTANCE.getDataFolder().mkdir();
        }
    }
}
