import events.*;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class SBot {
    public static void main(String[] args) throws Exception{
        System.out.println("good morning! uwu");
        JDA jda = new JDABuilder("NTUwNTAzMzc5MjAyMjExODU1.D1jX4w.sTu3RgIvarBzkyabzYN65sBhmKk").build();

        jda.addEventListener(new YeehawEvent());
        jda.addEventListener(new FWordEvent());
        jda.addEventListener(new NewChannelEvent());
        jda.addEventListener(new LoveEvent());
        jda.addEventListener(new HateEvent());
        jda.addEventListener(new ImpartialEvent());
        jda.addEventListener(new Vocab());
        jda.addEventListener(new WisdomEvent());
        jda.addEventListener(new BanEvent());
        jda.addEventListener(new UnbanEvent());
        jda.addEventListener(new SkippyNameEvent());

    }
}
