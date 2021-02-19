package me.importprogram.eventor.config;

import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;


/**
 * Creates a GUI Factory that open the Config Menu (via Forges Config button in the Mods menu)
 * @author ?
 */
public class EventorGUIFactory implements IModGuiFactory {

    @Override
    public void initialize(Minecraft minecraftInstance) {
        // Doesn't really have a use right now
    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return GUIEventorConfig.class; // Return the *class* of the Config GUI
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null; 
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null; 
    }

}