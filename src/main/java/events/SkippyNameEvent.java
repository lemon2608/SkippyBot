package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class SkippyNameEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String usern = event.getMember().getNickname();
        if(messageSent[0].equalsIgnoreCase("$skippy")){
            if(!event.getMember().getUser().isBot()) {
                event.getChannel().sendMessage("oh geez thats me").queue();
                System.out.println("skippy is skippy");
            }
        }
    }
}
