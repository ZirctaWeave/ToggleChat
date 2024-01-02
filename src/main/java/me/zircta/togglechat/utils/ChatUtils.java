package me.zircta.togglechat.utils;

import net.minecraft.client.Minecraft;

public class ChatUtils {
    private static final Minecraft mc = Minecraft.getMinecraft();

    public static float originalOpacity;
    public static boolean chatVisible = true;

    public static void toggleChat() {
        if (chatVisible) {
            originalOpacity = mc.gameSettings.chatOpacity;
            mc.gameSettings.chatOpacity = 0.0f;
        } else {
            mc.gameSettings.chatOpacity = originalOpacity;
        }

        chatVisible = !chatVisible;
    }
}
