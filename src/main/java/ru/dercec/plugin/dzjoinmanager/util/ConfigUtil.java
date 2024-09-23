package ru.dercec.plugin.dzjoinmanager.util;

import ru.dercec.plugin.dzjoinmanager.DZJoinManager;

public class ConfigUtil {
    public static String getString(String path) {
        return HexUtil.color(DZJoinManager.getInstance().getConfig().getString(path));
    }

    public static int getInt(String path) {
        return DZJoinManager.getInstance().getConfig().getInt(path);
    }

    public static Boolean getBoolean(String path){
        return DZJoinManager.getInstance().getConfig().getBoolean(path);
    }
}