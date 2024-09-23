package ru.dercec.plugin.dzjoinmanager.event;

import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.dercec.plugin.dzjoinmanager.DZJoinManager;
import ru.dercec.plugin.dzjoinmanager.util.ConfigUtil;
import ru.dercec.plugin.dzjoinmanager.util.MessageUtil;

public class onJoinEvent implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        String name = e.getPlayer().getName();
        boolean bplay = player.hasPlayedBefore();

        if(!bplay){
            if(ConfigUtil.getBoolean("first-join.messages.enable")) MessageUtil.sendMessageArrayList("first-join.messages.message", player, name);
            if(ConfigUtil.getBoolean("first-join.cmd-commands.enable")) MessageUtil.consoleCommandSenderArrayList(DZJoinManager.getInstance().getConfig().getStringList("first-join.cmd-commands.commands"), name);
            if(ConfigUtil.getBoolean("first-join.sound-on-join.enable"))  player.playSound(player.getLocation(), Sound.valueOf(ConfigUtil.getString("first-join.sound-on-join.sound")), SoundCategory.MASTER, 1.0F, 1.0F);
            if(ConfigUtil.getBoolean("first-join.title.enable")) player.sendTitle(ConfigUtil.getString("first-join.title.Header"), ConfigUtil.getString("first-join.title.Footer"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_In"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Stay"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_Out"));
            if(ConfigUtil.getBoolean("first-join.actionbar.enable")) player.sendActionBar(ConfigUtil.getString("first-join.actionbar.message"));
        }
        if(bplay){
            if(ConfigUtil.getBoolean("on-join.messages.enable")) MessageUtil.sendMessageArrayList("on-join.messages.message", player, name);
            if(ConfigUtil.getBoolean("on-join.sound-on-join.enable"))  player.playSound(player.getLocation(), Sound.valueOf(ConfigUtil.getString("on-join.sound-on-join.sound")), SoundCategory.MASTER, 1.0F, 1.0F);
            if(ConfigUtil.getBoolean("on-join.title.enable")) player.sendTitle(ConfigUtil.getString("on-join.title.Header"), ConfigUtil.getString("on-join.title.Footer"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_In"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Stay"), DZJoinManager.getInstance().getConfig().getInt("settings.title-settings.Fade_Out"));
            if(ConfigUtil.getBoolean("on-join.actionbar.enable")) player.sendActionBar(ConfigUtil.getString("on-join.actionbar.message"));
        }
    }
}
