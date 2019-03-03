package events;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.io.*;
import java.util.*;

public class NewVocab extends ListenerAdapter {
    ArrayList<String> testVocabList = new ArrayList<String>();
    BanEvent b = new BanEvent();
    private String filename = "";
    boolean isBanned = false;
    ArrayList<String> bannedList = b.getBannedList();
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String sender = "<@" + event.getMember().getUser().getId() + ">";
        ArrayList<String> words = new ArrayList<String>();
        if(messageSent[0].equalsIgnoreCase("$vocab")){
            if(!event.getMember().getUser().isBot() && !isBanned(sender)) {
                words.clear();
                for (int i = 2; i < messageSent.length; i++) {
                    words.add(messageSent[i]);
                }
                filename = messageSent[1];
                BufferedWriter writer;
                if (!filename.equals("sort")){
                    try {
                        filename += ".txt";
                        writer = new BufferedWriter(new FileWriter(filename, true));

                        for (int i = 2; i < messageSent.length; i++) {
                            writer.write(messageSent[i] + "\n");
                        }
                        event.getChannel().sendMessage("i learned some new " + filename + "s! teehee").queue();
                        System.out.println("i learned new words");

                        writer.close();
                    } catch (IOException e) {
                        System.err.println("tried to learn new words but im stupid");
                    }
                }
            }
            if(b.isBanned(sender)){
                event.getChannel().sendMessage("you cant teach me anything until you learn from your mistakes.").queue();
                System.out.println("someone banned tried to teach me");
            }
        }
    }
    public boolean loadIntoList(String filename){
        try{
            testVocabList.clear();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null){
                testVocabList.add(line);
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
    public String getWord(String filename){
        loadIntoList(filename);
        int rand = (int)(Math.random() * testVocabList.size());
        String w = testVocabList.get(rand);
        return w;
    }

    public boolean isBanned(String userid){
        b.getBannedList();
        for(int i = 0; i < bannedList.size(); i++){
            if(bannedList.get(i).equals(userid)){
                return true;
            }
        }
        return false;
    }

}

