package me.zircta.togglechat;

import me.zircta.togglechat.listener.KeybindListener;
import me.zircta.togglechat.utils.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.event.EventBus;
import net.weavemc.loader.api.event.ShutdownEvent;
import net.weavemc.loader.api.event.StartGameEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToggleChat implements ModInitializer {
    public static KeyBinding key = new KeyBinding("Toggle Chat", Keyboard.KEY_GRAVE, "Toggle Chat Mod");

    @Override
    public void preInit() {
        EventBus.subscribe(this);
    }

    @SubscribeEvent
    public void onStartGame(StartGameEvent.Post ev) {
        List<KeyBinding> keyBindings = new ArrayList<>(Arrays.asList(Minecraft.getMinecraft().gameSettings.keyBindings));
        keyBindings.add(key);
        Minecraft.getMinecraft().gameSettings.keyBindings = keyBindings.toArray(new KeyBinding[0]);

        EventBus.subscribe(new KeybindListener());

        ChatUtils.originalOpacity = Minecraft.getMinecraft().gameSettings.chatOpacity;
    }

    @SubscribeEvent
    public void onShutdown(ShutdownEvent ev) {
        Minecraft.getMinecraft().gameSettings.chatOpacity = ChatUtils.originalOpacity;
    }
}