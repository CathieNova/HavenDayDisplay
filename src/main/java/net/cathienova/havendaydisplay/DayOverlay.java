package net.cathienova.havendaydisplay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

import java.awt.*;

import static net.cathienova.havendaydisplay.config.CommonConfig.*;

@EventBusSubscriber(value = Dist.CLIENT, modid = HavenDayDisplay.MODID)
public class DayOverlay
{
    public DayOverlay()
    {
    }

    @SubscribeEvent
    public static void onRenderGameOverlay(RenderGuiEvent.Post event)
    {
        if (!CONFIG.enableDayOverlay.get()) return;

        Minecraft client = Minecraft.getInstance();
        Level level = client.level;
        if (level == null) return;

        long worldTime = level.getOverworldClockTime();
        int currentDay = (int) (worldTime / 24000);

        int x = CONFIG.xPos.get();
        int y = CONFIG.yPos.get();
        Color color = new Color(255,255,255);

        Component textComponent = Component.translatable("overlay.havendaydisplay.day", currentDay);
        Font font = client.font;
        event.getGuiGraphics().text(font, textComponent, x, y, color.getRGB());
    }
}