package ru.dercec.plugin.dzjoinmanager.command;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.dercec.plugin.dzjoinmanager.DZJoinManager;
import ru.dercec.plugin.dzjoinmanager.util.ConfigUtil;
import ru.dercec.plugin.dzjoinmanager.util.MessageUtil;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            if(commandSender instanceof Player){
                Player player = (Player) commandSender;
                if (player.hasPermission("dzjoinmanager.admin")) {
                    if(strings[0].equalsIgnoreCase("reload")) {
                        DZJoinManager.getInstance().reloadConfig();
                        MessageUtil.sendMessageArrayList("settings.other-settings.successfully-rebooted", player, player.getName());
                        return true;
                    }
                    if(strings[0].equalsIgnoreCase("firstjoin")){
                        if(ConfigUtil.getBoolean("first-join.messages.enable")) MessageUtil.sendMessageArrayList("first-join.messages.message", player, player.getName());
                        if(ConfigUtil.getBoolean("first-join.cmd-commands.enable")) MessageUtil.consoleCommandSenderArrayList(DZJoinManager.getInstance().getConfig().getStringList("first-join.cmd-commands.commands"), player.getName());
                        if(ConfigUtil.getBoolean("first-join.sound-on-join.enable"))  player.playSound(player.getLocation(), Sound.valueOf(ConfigUtil.getString("first-join.sound-on-join.sound")), SoundCategory.MASTER, 1.0F, 1.0F);
                        if(ConfigUtil.getBoolean("first-join.title.enable")) player.sendTitle(ConfigUtil.getString("first-join.title.Header"), ConfigUtil.getString("first-join.title.Footer"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_In"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Stay"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_Out"));
                        if(ConfigUtil.getBoolean("first-join.actionbar.enable")) player.sendActionBar(ConfigUtil.getString("first-join.actionbar.message"));
                        return true;
                    }
                    if(strings[0].equalsIgnoreCase("join")){
                        if(ConfigUtil.getBoolean("on-join.messages.enable")) MessageUtil.sendMessageArrayList("on-join.messages.message", player, player.getName());
                        if(ConfigUtil.getBoolean("on-join.sound-on-join.enable"))  player.playSound(player.getLocation(), Sound.valueOf(ConfigUtil.getString("on-join.sound-on-join.sound")), SoundCategory.MASTER, 1.0F, 1.0F);
                        if(ConfigUtil.getBoolean("on-join.title.enable")) player.sendTitle(ConfigUtil.getString("on-join.title.Header"), ConfigUtil.getString("on-join.title.Footer"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_In"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Stay"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_Out"));
                        if(ConfigUtil.getBoolean("on-join.actionbar.enable")) player.sendActionBar(ConfigUtil.getString("on-join.actionbar.message"));}
                        return true;
                } else{
                    MessageUtil.sendMessageArrayList("settings.other-settings.no-permission", player, player.getName());
                    return true;
                }

            } else{
                DZJoinManager.getInstance().reloadConfig();
                commandSender.sendMessage("Плагин успешно перезагружен!");
                return true;
            }
        }
        commandSender.sendMessage("Сделан с любовью! by DeadWithMe_");
        return true;
    }
}