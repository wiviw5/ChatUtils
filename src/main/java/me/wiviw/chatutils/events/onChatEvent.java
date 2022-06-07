package me.wiviw.chatutils.events;

import net.minecraft.client.Minecraft;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class onChatEvent {
    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        if (event.type==0 || event.type==1) {
            String message = event.message.getFormattedText();
            Pattern messageStartFriend = Pattern.compile((char) 167 + "aFriend > ", Pattern.LITERAL);
            Matcher matcher1 = messageStartFriend.matcher(message);
            Pattern messageStart = Pattern.compile((char) 167 + "2Guild > ", Pattern.LITERAL);
            Matcher matcher2 = messageStart.matcher(message);
            Pattern joinPattern = Pattern.compile("joined", Pattern.LITERAL);
            Matcher matcher3 = joinPattern.matcher(message);
            //Friend Boop
            if (matcher1.find()){
                if (matcher3.find()){
                    event.setCanceled(true);
                    IChatComponent comp = new ChatComponentText(message);
                    String user = message.substring(15).split(" ")[0];
                    char userColor = message.charAt(14);
                    System.out.println((char) 167 + "dBoop! " + (char) 167 + userColor + user);
                    IChatComponent boopMessage = new ChatComponentText((char) 167 + "dBoop! " + (char) 167 + userColor + user);
                    ChatStyle style = new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/boop " + user)).setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, boopMessage));
                    comp.setChatStyle(style);
                    Minecraft.getMinecraft().thePlayer.addChatMessage(comp);
                }
            }
            //Guild Boop
            if (matcher2.find()){
                if (matcher3.find()){
                    event.setCanceled(true);
                    IChatComponent comp = new ChatComponentText(message);
                    String user = message.substring(14).split(" ")[0];
                    char userColor = message.charAt(13);
                    System.out.println((char) 167 + "dBoop! " + (char) 167 + userColor + user);
                    IChatComponent boopMessage = new ChatComponentText((char) 167 + "dBoop! " + (char) 167 + userColor + user);
                    ChatStyle style = new ChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/boop " + user)).setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, boopMessage));
                    comp.setChatStyle(style);
                    Minecraft.getMinecraft().thePlayer.addChatMessage(comp);
                }
            }
        }
    }
}
