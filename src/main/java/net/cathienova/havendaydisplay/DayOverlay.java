package net.cathienova.havendaydisplay;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
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
    public void onRenderGameOverlay(RenderGuiEvent event)
    {
        if (!enableDayOverlay) return;

        PoseStack poseStack = event.getPoseStack();
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) return;

        long worldTime = minecraft.level.getDayTime();
        int currentDay = (int) (worldTime / 24000);

        Font font = minecraft.font;
        Component textComponent = Component.literal("Day " + currentDay);
        Color color = new Color(255, 255, 255);

        int colorValue = color.getRGB();
        font.draw(poseStack, textComponent, xPos, yPos, colorValue);
    }
}



