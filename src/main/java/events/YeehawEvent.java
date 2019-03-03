package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class YeehawEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String usern = event.getMember().getNickname();
        if(messageSent[0].equalsIgnoreCase("$yeehaw")){
            if(!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("howdy, " + usern + " :cowboy:").queue();
                System.out.println("yeehaw");
            }
        }
    }
}
