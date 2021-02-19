package me.importprogram.eventor.listeners;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import me.importprogram.eventor.Eventor;

/**
 * Creates a GUI Factory that open the Config Menu (via Forges Config button in the Mods menu)
 * @author ?
 */
public class ChatListener {
    private static ChatListener INSTANCE = new ChatListener();

    private ChatListener() {}

    public static ChatListener getInstance() {
        return INSTANCE;
    }

    @SubscribeEvent
    public void onClientChat(ClientChatReceivedEvent event) {
        // Get the unformatted text of chat
        String message = event.message.getUnformattedText();
        // Check if the chat message in the front starts with the "BED DESTRUCTION > Your Bed"
        if (message.startsWith("BED DESTRUCTION > Your Bed")) {
            System.out.print("[Eventor] Bed has been broken!");
            URL url;
            try {
                url = new URL(Eventor.CONFIG_playersBedwarsBedBrokenRequest);
                try {
                    URLConnection urlc = url.openConnection();
                    // Send the request, but don't do anything with it
                    urlc.getContentType();   
                } catch (IOException e) {
                    System.out.println(e);
                }
            } catch (MalformedURLException e) {
                System.out.println(e);
            }
        }
    }
}
