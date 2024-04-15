package net.cathienova.havendaydisplay.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class CommonConfig
{
    public static final Pair<CommonConfig, ModConfigSpec> SPEC_PAIR = new ModConfigSpec.Builder().configure(CommonConfig::new);
    public static final CommonConfig CONFIG = SPEC_PAIR.getLeft();
    public static final ModConfigSpec SPEC = SPEC_PAIR.getRight();
    public final ModConfigSpec.ConfigValue<Boolean> enableDayOverlay;
    public final ModConfigSpec.ConfigValue<Integer> xPos;
    public final ModConfigSpec.ConfigValue<Integer> yPos;
    public CommonConfig(ModConfigSpec.Builder builder)
    {
        enableDayOverlay = builder.comment("Enable the day overlay.").define("enableDayOverlay", true);
        xPos = builder.comment("The x position of the day overlay.").defineInRange("xPos", 3, 1, 10000);
        yPos = builder.comment("The y position of the day overlay.").defineInRange("yPos", 3, 1, 10000);
    }



}