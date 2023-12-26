package jp.yama2211.pllist;

import me.kaimu.haste.Hastebin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
public final class Main extends JavaPlugin
{
    public void onEnable()
    {
        saveDefaultConfig();
    }

    public void onDisable() {}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if( (sender.hasPermission("pllist.use")) || (sender.isOp()) ){
            if (args.length == 0)
            {
                Hastebin hastebin = new Hastebin();

                getConfig().set("pluginlist", getPluginList());
                saveConfig();

                    String text = getPluginList();
                    boolean raw = true;
                    try{
                        String url = hastebin.post(text,raw);
                        sender.sendMessage("Web View Link:" + url);
                    }catch (IOException e){
                        sender.sendMessage("NetWork Error! or Script Error!");
                    }
                }
                sender.sendMessage("PluginList Saveing!");
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
