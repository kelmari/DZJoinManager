package ru.dercec.plugin.dzjoinmanager;

import org.bukkit.plugin.java.JavaPlugin;
import ru.dercec.plugin.dzjoinmanager.command.ReloadCommand;
import ru.dercec.plugin.dzjoinmanager.command.TabCompleter;
import ru.dercec.plugin.dzjoinmanager.event.onJoinEvent;

public final class DZJoinManager extends JavaPlugin {
    private static DZJoinManager instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new onJoinEvent(), this);
        getCommand("dzjoinmanager").setExecutor(new ReloadCommand());
        getCommand("dzjoinmanager").setTabCompleter(new TabCompleter());
    }

    @Override
    public void onDisable() {
    }

    public static DZJoinManager getInstance() {
        return instance;
    }
}
