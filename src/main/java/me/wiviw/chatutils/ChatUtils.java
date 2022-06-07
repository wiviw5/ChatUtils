package me.wiviw.chatutils;

import me.wiviw.chatutils.events.onChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ChatUtils.MODID, version = ChatUtils.VERSION)
public class ChatUtils {
    public static final String MODID = "chatutils";
    public static final String VERSION = "0.1.1";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new onChatEvent());
    }
}
