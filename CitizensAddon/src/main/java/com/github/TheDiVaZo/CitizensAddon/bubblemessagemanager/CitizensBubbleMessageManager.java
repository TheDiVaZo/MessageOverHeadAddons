package com.github.TheDiVaZo.CitizensAddon.bubblemessagemanager;

import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import thedivazo.BubbleMessage;
import thedivazo.bubblemessagemanager.BubbleMessageManager;
import thedivazo.config.ConfigBubble;

public class CitizensBubbleMessageManager extends BubbleMessageManager<NPC> {
    public CitizensBubbleMessageManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public Location getLocation(NPC object) {
        return object.getStoredLocation();
    }

    @Override
    public BukkitRunnable getBukkitBehaviorTask(NPC object, ConfigBubble configBubble, BubbleMessage<NPC> bubbleMessage) {
        return new BukkitRunnable() {
            @Override
            public void run() {
                Location loc = object.getStoredLocation().clone();
                loc.setY(loc.getY() + configBubble.getBiasY());
                bubbleMessage.setPosition(loc);
            }
        };
    }
}
