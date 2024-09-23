package ru.dercec.plugin.dzjoinmanager.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.dercec.plugin.dzjoinmanager.DZJoinManager;

import java.util.ArrayList;
import java.util.List;

public class MessageUtil {
    public static void sendMessageArrayList(String configPath, Player player, String name){
        List<String> message = new ArrayList<>();
        DZJoinManager.getInstance().getConfig().getStringList(configPath).forEach((str) -> {
            message.add(HexUtil.color(str));
        });
        for(String ms : message) {
            ms = ms.replace("{player-name}", name);
            player.sendMessage(ms);
        }
    }
    public static void consoleCommandSenderArrayList(List<String> message, String name){
        for(String ms : message){
            ms = ms.replace("{player-name}", name);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ms);
        }
    }
}
