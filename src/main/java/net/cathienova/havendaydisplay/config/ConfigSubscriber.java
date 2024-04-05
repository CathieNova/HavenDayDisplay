package net.cathienova.havendaydisplay.config;

import net.cathienova.havendaydisplay.HavenDayDisplay;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = HavenDayDisplay.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigSubscriber {
    @SubscribeEvent
    public static void onModConfigEvent(final ModConfigEvent event) {
        HavenDayDisplayConfig.bake(event.getConfig());
    }
}