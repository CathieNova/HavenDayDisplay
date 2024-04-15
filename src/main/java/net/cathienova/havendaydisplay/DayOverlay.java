package net.cathienova.havendaydisplay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RenderGuiOverlayEvent;

import java.awt.*;

import static net.cathienova.havendaydisplay.config.CommonConfig.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT, modid = HavenDayDisplay.MODID)
public class DayOverlay
{
    private static final Minecraft CLIENT = Minecraft.getInstance();

    public DayOverlay()
    {
    }

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGuiOverlayEvent.Pre event)
    {
        if (!CONFIG.enableDayOverlay.get()) return;

        Level level = CLIENT.level;
        assert level != null;
        long worldTime = level.getDayTime();
        int currentDay = (int) (worldTime / 24000);

        int x = CONFIG.xPos.get();
        int y = CONFIG.yPos.get();
        Color color = new Color(255,255,255);

        Component textComponent = Component.nullToEmpty("Day " + currentDay);
        Font font = CLIENT.font;
        event.getGuiGraphics().drawString(font,textComponent, x, y, color.getRGB());
    }
}



