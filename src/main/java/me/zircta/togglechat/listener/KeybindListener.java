package me.zircta.togglechat.listener;

import me.zircta.togglechat.ToggleChat;
import me.zircta.togglechat.utils.ChatUtils;
import net.weavemc.loader.api.event.KeyboardEvent;
import net.weavemc.loader.api.event.MouseEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class KeybindListener {
    @SubscribeEvent
    public void onKeyUpdate(KeyboardEvent ev) {
        if (Keyboard.getEventKey() == ToggleChat.key.getKeyCode() && ev.getKeyState()) {
            ChatUtils.toggleChat();
        }
    }

    @SubscribeEvent
    public void onMouseUpdate(MouseEvent ev) {
        if (Mouse.getEventButton() == ToggleChat.key.getKeyCode() + 100 && ev.getButtonState()) {
            ChatUtils.toggleChat();
        }
    }
}
