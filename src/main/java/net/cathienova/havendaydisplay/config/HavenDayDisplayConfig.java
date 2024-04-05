package net.cathienova.havendaydisplay.config;

import net.cathienova.havendaydisplay.HavenDayDisplay;
import net.minecraftforge.fml.config.ModConfig;

public class HavenDayDisplayConfig
{
    public static boolean enableDayOverlay;
    public static int xPos;
    public static int yPos;

    public static void bake(ModConfig config)
    {
        enableDayOverlay = HavenDayDisplay.c_config.enableDayOverlay.get();
        xPos = HavenDayDisplay.c_config.xPos.get();
        yPos = HavenDayDisplay.c_config.yPos.get();
    }
}