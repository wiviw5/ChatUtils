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

    private static final Pattern messageStartFriend = Pattern.compile((char) 167 + "aFriend > ", Pattern.LITERAL);
    private static final Pattern messageStartGuild = Pattern.compile((char) 167 + "2Guild > ", Pattern.LITERAL);
    private static final Pattern joinPattern = Pattern.compile((char) 167 + "r" + (char) 167 + "ejoined", Pattern.LITERAL);

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        if (event.type == 0 || event.type == 1) {
            String message = event.message.getFormattedText();
            Matcher friendMatcher = messageStartFriend.matcher(message);
            Matcher guildMatcher = messageStartGuild.matcher(message);
            Matcher joinedMatcher = joinPattern.matcher(message);
            boolean friendMatcherBool = friendMatcher.find();
            boolean guildMatcherBool = guildMatcher.find();
            boolean joinedMatcherBool = joinedMatcher.find();
            if (friendMatcherBool || guildMatcherBool) {
                int subStringSplit = friendMatcherBool ? 15 : 14;
                if (joinedMatcherBool) {
                    event.setCanceled(true);
                    IChatComponent comp = new ChatComponentText(message);
                    String user = message.substring(subStringSplit).split(" ")[0];
                    char userColor = message.charAt(subStringSplit - 1);
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
