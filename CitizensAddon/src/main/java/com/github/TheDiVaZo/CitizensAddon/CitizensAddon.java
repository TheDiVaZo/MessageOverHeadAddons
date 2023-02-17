package com.github.TheDiVaZo.CitizensAddon;

import com.github.TheDiVaZo.CitizensAddon.listener.CitizensListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.dependency.Dependency;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;
import thedivazo.MessageOverHead;

@Plugin(name = "CitizensAddonMessageOverHead", version = "1.0-SNAPSHOT")
@Dependency(value = "MessageOverHead")
@Author(value = "TheDiVaZo")
@ApiVersion(value = ApiVersion.Target.v1_13)
public class CitizensAddon extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        MessageOverHead.getInstance().reloadConfigManager();
        Bukkit.getPluginManager().registerEvents(new CitizensListener(), this);
    }
}