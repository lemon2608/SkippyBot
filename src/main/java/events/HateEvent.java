package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class HateEvent extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equalsIgnoreCase("$hate")) {
            if(!event.getMember().getUser().isBot()) {
                String usern = "<@" + event.getMember().getUser().getId() + ">";
                String restOfMessage = "";
                for(int i = 1; i < messageSent.length; i ++){
                    restOfMessage += messageSent[i] + " ";
                }
                event.getChannel().sendMessage("friendly reminder that " + usern + " hates " + restOfMessage).queue();
                System.out.println("hate");
                //take in full rest of string if its not an @
                //if it is an @, make sure it only takes the @ and nothing after
            }
        }
    }
}

