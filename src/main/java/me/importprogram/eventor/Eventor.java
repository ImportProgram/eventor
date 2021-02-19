package me.importprogram.eventor;

import java.io.File;

import me.importprogram.eventor.listeners.ChatListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Eventor.MODID, version = Eventor.VERSION, guiFactory = Eventor.GUI_FACTORY)
public class Eventor
{
    public static final String MODID = "IPEventor";
    public static final String MODNAME = "ImportProgram's Eventor";
    public static final String VERSION = "1.0";
    public static final String GUI_FACTORY = "me.importprogram.eventor.config.EventorGUIFactory";
   
    public static Configuration config;

    public static String CONFIG_playersBedwarsBedBrokenRequest;
    public static String CONFIG_playersBedwarsDiesRequest;
    public static String CONFIG_playersBedwarsKillRequest;
    public static String CONFIG_playersBedwarsBreaksBedRequest;
    public static String CONFIG_playersBedwarsWinsRequest;


    @EventHandler
    public void init (FMLPreInitializationEvent event) {
        File configFile = new File(event.getModConfigurationDirectory(), Eventor.MODID + ".cfg");
        config = new Configuration(configFile);
        try {
            // Load config
            config.load();
            // Now sync it
            Eventor.syncConfig();
        } catch (Exception e) {
            // Failed reading/writing, just continue
        } finally {
            // Save props to config IF config changed
            if (config.hasChanged()) config.save();
        }
    } 
    public static void syncConfig() {
                // Read props from config
        Property playersBedwarsBedBrokenProp = config.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
                "playerBedwarsBedBroken", // Property name
                "http://localhost:1234/playersBedBroken", // Default value
                "HTTP Request sent when the players (you) has their bed broken in Bedwars"); // Comment

        Property playerBedwarsDiesProp = config.get(Configuration.CATEGORY_GENERAL,
                "playerBedwarsDies", 
                "http://localhost:1234/playerDies", 
                "HTTP Request sent when the player dies in Bedwars"); 

        Property playerBedwarsKillProp = config.get(Configuration.CATEGORY_GENERAL, 
                "playerBedwarsKill", 
                "http://localhost:1234/playerKill", 
                "HTTP Request sent when the player kills another player in Bedwars"); 
        
        Property playerBedwarsBreaksBedProp = config.get(Configuration.CATEGORY_GENERAL, 
                "playerBedwarsBreakBed", 
                "http://localhost:1234/playerBreakBed", 
                "HTTP Request sent when the player breaks a bed in Bedwars");
        
        Property playerBedwarsWinsProp = config.get(Configuration.CATEGORY_GENERAL, 
            "playerBedwarsBreakBed", 
            "http://localhost:1234/playerBreakBed", 
            "HTTP Request sent when the player wins a match in Bedwars"); 

        
        // Update any mod global variables to the newly saved config information (if updated, else just load them)
        CONFIG_playersBedwarsBedBrokenRequest = playersBedwarsBedBrokenProp.getString(); 
        CONFIG_playersBedwarsDiesRequest = playerBedwarsDiesProp.getString(); 
        CONFIG_playersBedwarsKillRequest = playerBedwarsKillProp.getString(); 
        CONFIG_playersBedwarsBreaksBedRequest = playerBedwarsBreaksBedProp.getString(); 
        CONFIG_playersBedwarsWinsRequest = playerBedwarsWinsProp.getString(); 

    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        System.out.println("Eventor Initialized!!!");
        MinecraftForge.EVENT_BUS.register(ChatListener.getInstance());
        MinecraftForge.EVENT_BUS.register(new ConfigEventHandler());
    }
    public static class ConfigEventHandler {
        
        @SubscribeEvent
        public void onConfigChanged(ConfigChangedEvent event) {
            System.out.println("[eventor] Saving Config");
            if (event.modID.equals(Eventor.MODID)) {
                // Save the config
                Eventor.config.save();
                // Sync the config
                Eventor.syncConfig();
            }
        }

    }

   
}
