import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Scanner;

public class MusicPlayer {
    Scanner sc=new Scanner(System.in);
    public void playsong(List<String> song){
        InputStream music;
        try{
            for(int i=0;i<song.size();i++) {
                String choice = "";
                String name= song.get(i);
                name = name.trim();
                System.out.println(name);
                name = name + ".wav";
                File file = new File(name);
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                //System.out.println(name);
                System.out.println("press 'P' to playsong\n press 'S' to stop song \n press 'R' to restart \npress 'N' to next \n press 'Q' to quit");
                System.out.println("enter your choice");
                while (!(choice.equalsIgnoreCase("Q"))) {
                    choice = sc.next();
                    System.out.println("(P)--play,(S)-- stop, (R)-- restart,(Q)-- quit");
                    choice = choice.toUpperCase();
                    switch (choice) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("N"):
                            clip.close();

                                i++;
                                nextsong(song.get(i));

                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        default:
                            System.out.println("wrong choice");
                    }
                }
            }
            }
        catch(Exception ex){
            System.out.println(ex);
            }
        }
        public void nextsong(String name){
            InputStream music;
            try{
                String choice="";
                name=name.trim();
                System.out.println(name);
                name=name+".wav";
                File file=new File(name);
                AudioInputStream audio = AudioSystem.getAudioInputStream(file);
                Clip clip=AudioSystem.getClip();
                clip.open(audio);

                //System.out.println(name);
                System.out.println("press 'P' to playsong\n press 'S' to stop song \n press 'R' to restart \npress 'N' to next \n press 'Q' to quit");
                System.out.println("enter your choice");
                while(!choice.equalsIgnoreCase("Q")) {
                    choice=sc.next();
                    System.out.println("(P)--play,(S)-- stop, (R)-- restart,(Q)-- quit");
                    choice=choice.toUpperCase();
                    switch (choice) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            break;
                        case("Q"):
                            clip.close();
                            break;
                        default:
                            System.out.println("wrong choice");
                    }
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        }
}
