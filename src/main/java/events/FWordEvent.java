package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class FWordEvent extends ListenerAdapter {
        public void onGuildMessageReceived(GuildMessageReceivedEvent event){
            String messageSent[] = event.getMessage().getContentRaw().split(" ");
            String usern = event.getMember().getNickname();
            if(messageSent[0].equalsIgnoreCase("$fuck")){
                if(!event.getMember().getUser().isBot()) {
                    int rand = (int) (Math.random() * 12);
                    if (rand == 0) {
                        event.getChannel().sendMessage("fuck").queue();
                    } else if (rand == 1) {
                        event.getChannel().sendMessage("FUCK!").queue();
                    } else if (rand == 2) {
                        event.getChannel().sendMessage("fuuuuUuukuUUUUUUuck").queue();
                    } else if (rand == 3) {
                        event.getChannel().sendMessage("f*ck").queue();
                    } else if (rand == 4) {
                        event.getChannel().sendMessage("hey, watch your fucking language. jfc").queue();
                    } else if (rand == 5) {
                        event.getChannel().sendMessage("fuck fuck fuck").queue();
                    } else if (rand == 6) {
                        event.getChannel().sendMessage("what does \"fuck\" mean??").queue();
                    } else if (rand == 7) {
                        event.getChannel().sendMessage("please no swearing, im baby").queue();
                    } else if (rand == 8) {
                        event.getChannel().sendMessage("Fuck.").queue();
                    } else if (rand == 9) {
                        event.getChannel().sendMessage("frick frack!!! uwu teehee").queue();
                    } else if (rand == 10) {
                        event.getChannel().sendMessage("fuck you in particular, " + usern).queue();
                    } else {
                        event.getChannel().sendMessage("no swearing in my christian minecraft server").queue();
                    }
                    System.out.println("someone swore");
                }
            }
    }
}
