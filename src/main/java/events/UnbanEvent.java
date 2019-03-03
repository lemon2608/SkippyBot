package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.*;
import java.util.*;

public class UnbanEvent extends ListenerAdapter {
    ArrayList<String> bannedList = new ArrayList<String>();
    String dad = "265671540954103809";
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equalsIgnoreCase("$unban")){
            if(!event.getMember().getUser().isBot() && event.getMember().getUser().getId().equals(dad)) {
                String banned = messageSent[1];

                event.getChannel().sendMessage(banned + " is unbanned..........for now").queue();
                loadBanList();
                for (int i = 0; i < bannedList.size(); i++){
                    if(bannedList.get(i).equals(messageSent[1])){
                        bannedList.remove(i);
                    }
                }
                unban(bannedList, messageSent[1]);
                System.out.println(messageSent[1] + " has been unbanned");
            }
        }
    }
    public boolean loadBanList(){
        try{
            bannedList.clear();
            BufferedReader reader = new BufferedReader(new FileReader("bannedList"));
            String line = reader.readLine();
            while(line != null){
                bannedList.add(line);
                line = reader.readLine();
            }
            reader.close();
            return true;
        }
        catch(Exception e){
            System.err.println("im stupid");
        }
        return false;
    }

    public void unban(ArrayList<String> bannedList, String userid){
        //rewrites the ban list
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("bannedList", true));
            BufferedWriter erase = new BufferedWriter(new FileWriter("bannedList"));
            erase.write("");
            for(int i = 0; i < bannedList.size(); i++){
                writer.write(userid + "\n");
            }
            writer.close();
        }
        catch(Exception e){
            System.err.println("im stupid");
        }
    }

}

