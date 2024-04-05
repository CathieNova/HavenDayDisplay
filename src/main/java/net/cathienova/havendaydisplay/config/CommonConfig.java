package net.cathienova.havendaydisplay.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig
{
    public final ForgeConfigSpec.BooleanValue enableDayOverlay;
    public final ForgeConfigSpec.IntValue xPos;
    public final ForgeConfigSpec.IntValue yPos;


    public CommonConfig(ForgeConfigSpec.Builder builder)
    {
        enableDayOverlay = builder.comment("Enable the day overlay.").define("enableDayOverlay", true);
        xPos = builder.comment("The x position of the day overlay.").defineInRange("xPos", 3, 1, 10000);
        yPos = builder.comment("The y position of the day overlay.").defineInRange("yPos", 3, 1, 10000);
    }
}