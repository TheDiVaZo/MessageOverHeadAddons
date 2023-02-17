package com.github.TheDiVaZo.CitizensAddon.listener;

import com.github.TheDiVaZo.CitizensAddon.bubblemessagemanager.CitizensBubbleMessageManager;
import net.citizensnpcs.api.ai.speech.Talkable;
import net.citizensnpcs.api.ai.speech.event.NPCSpeechEvent;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import thedivazo.BubbleMessage;
import thedivazo.MessageOverHead;
import thedivazo.config.ConfigBubble;

public class CitizensListener implements Listener {
    CitizensBubbleMessageManager citizensBubbleMessageManager = new CitizensBubbleMessageManager(MessageOverHead.getInstance());

    @EventHandler
    public void onCitizenSpeech(NPCSpeechEvent event) {
        NPC npc = event.getNPC();
        ConfigBubble configBubble = new ConfigBubble();
        configBubble.getMessageFormat().put(0, new ConfigBubble.Format("%message%", null));
        BubbleMessage<NPC> bubbleMessage = citizensBubbleMessageManager.generateBubbleMessage(null, configBubble, npc, event.getContext().getMessage());
        for (Talkable talkable : event.getContext()) {
            if(talkable.getEntity() instanceof Player) {
                citizensBubbleMessageManager.showBubble(bubbleMessage,(Player) talkable.getEntity(), (Player) talkable.getEntity());
            }
        }
    }
}
