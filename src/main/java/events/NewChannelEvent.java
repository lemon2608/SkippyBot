package events;

import net.dv8tion.jda.core.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class NewChannelEvent extends ListenerAdapter {

    public void onTextChannelCreate(TextChannelCreateEvent e){
        String channelid = e.getChannel().getId();
        e.getGuild().getTextChannelById(channelid).sendMessage("first").queue();
        System.out.println("new channel made");
    }

}