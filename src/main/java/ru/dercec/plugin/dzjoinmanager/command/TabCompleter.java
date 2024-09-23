package ru.dercec.plugin.dzjoinmanager.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender.isOp() || commandSender.hasPermission("dzjoinmanager.reload")) {
            if (strings.length == 1) {
                List<String> completions = new ArrayList<>();
                completions.add("reload");
                completions.add("firstjoin");
                completions.add("join");
                return completions;
            }
        }
        return null;
    }
}
