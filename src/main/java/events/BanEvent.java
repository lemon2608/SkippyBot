package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.*;
import java.util.*;

public class BanEvent extends ListenerAdapter {
    ArrayList<String> bannedList = new ArrayList<String>();
    String dad = "265671540954103809";
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        if(messageSent[0].equalsIgnoreCase("$ban")){
            if(!event.getMember().getUser().isBot() && event.getMember().getUser().getId().equals(dad)) {
                String banned = messageSent[1];

                event.getChannel().sendMessage(banned + " has been arrested for hubris on main").queue();
                //print out id saved in banned and id gotten from getmember getuser
                //event.getChannel().sendMessage("by " + event.getMember().getUser().getId()).queue();
                loadBanList();
                bannedList.add(messageSent[1]);
                ban(bannedList, messageSent[1]);
                System.out.println(event.getGuild().getMemberById(messageSent[1]).getUser() + " has been banned");
            }
        }
    }
    public void loadBanList(){
        try{
            bannedList.clear();
            BufferedReader reader = new BufferedReader(new FileReader("bannedList"));
            String line = reader.readLine();
            while(line != null){
                bannedList.add(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch(Exception e){
            System.err.println("im stupid");
        }
    }

    public ArrayList<String> getBannedList(){
        loadBanList();
        return bannedList;
    }

    public boolean isBanned(String userid){
        loadBanList();
        for(int i = 0; i < bannedList.size(); i++){
            if(bannedList.get(i).equals(userid)){
                return true;
            }
        }
        return false;
    }

    public void ban(ArrayList<String> bannedList, String userid){
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

