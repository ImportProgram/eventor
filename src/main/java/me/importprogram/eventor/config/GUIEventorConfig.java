package me.importprogram.eventor.config;

import me.importprogram.eventor.Eventor;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GUIEventorConfig extends GuiConfig {
    public GUIEventorConfig(GuiScreen parentScreen) { // The screen we were before entering our Config GUI
        super(parentScreen, // Let Forge know the GUI we were at before
                new ConfigElement(Eventor.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), // What category of config to show in the GUI, can be something else (HAS TO BE IN YOUR CONFIG ALREADY!!!)
                Eventor.MODID, // The MODID of course
                true, // Whether changing config requires you to relog/restart world
                false, // Whether changing config requires you to relaunch Minecraft
                Eventor.MODNAME); // Config title; this will return the config path
    }
}
