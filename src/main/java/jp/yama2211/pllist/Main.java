package jp.yama2211.pllist;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main
        extends JavaPlugin
{
    public void onEnable()
    {
        saveDefaultConfig();
    }

    public void onDisable() {}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (args.length == 0)
        {
            getConfig().set("pluginlist", getPluginList());
            saveConfig();

            sender.sendMessage("Pluginlist Saveing!");
            return true;
        }
        return false;
    }

    private String getPluginList()
    {
        StringBuilder pluginlist = new StringBuilder();
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        for (Plugin plugin : plugins)
        {
            if (pluginlist.length() > 0) {
                pluginlist.append(", ");
            }
            pluginlist.append(plugin.getDescription().getName() + "[" + plugin.getDescription().getVersion() + "]");
        }
        return "(" + plugins.length + "): " + pluginlist.toString();
    }
}
