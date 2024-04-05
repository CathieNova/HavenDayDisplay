package net.cathienova.havendaydisplay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

import static net.cathienova.havendaydisplay.config.HavenDayDisplayConfig.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT, modid = HavenDayDisplay.MODID)
public class DayOverlay
{
    private static final Minecraft CLIENT = Minecraft.getInstance();

    public DayOverlay()
    {
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGuiOverlayEvent event)
    {
        if (!enableDayOverlay) return;

        Level level = CLIENT.level;
        assert level != null;
        long worldTime = level.getDayTime();
        int currentDay = (int) (worldTime / 24000);

        int x = xPos;
        int y = yPos;
        Color color = new Color(255,255,255);

        Component textComponent = Component.nullToEmpty("Day " + currentDay);
        Font font = CLIENT.font;
        event.getGuiGraphics().drawString(font,textComponent, x, y, color.getRGB());
    }
}



