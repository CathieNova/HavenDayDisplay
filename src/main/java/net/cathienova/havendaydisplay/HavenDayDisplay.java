package net.cathienova.havendaydisplay;

import net.cathienova.havendaydisplay.config.CommonConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(HavenDayDisplay.MODID)
public class HavenDayDisplay
{
    public static final String MODID = "havendaydisplay";

    public HavenDayDisplay(ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC);
    }
}