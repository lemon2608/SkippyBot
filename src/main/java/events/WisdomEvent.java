package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class WisdomEvent extends ListenerAdapter {
    Vocab vocab = new Vocab();
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equalsIgnoreCase("$wisdom")){
            if(!event.getMember().getUser().isBot()) {
                String sentence = "";
                String filename = "testVocab";
                int l = (int)(Math.random() * 6) + 1;
                vocab.loadIntoList(filename);
                for(int i = 0; i < l; i++){
                    sentence += vocab.getWord(filename) + " ";
                }
                event.getChannel().sendMessage(sentence).queue();
                System.out.println("words of wisdom");
            }
        }
    }
}