
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Jukeboxmain {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Playlistoperation pl=new Playlistoperation();
        List<PlaylistContent>playlist= pl.gettingAllPlaylist();
        List<SongType>playlistbysong =pl.sortbySong(playlist);
        MusicPlayer playmusic=new MusicPlayer();
        List<String> names=new ArrayList<String>();
        for(SongType s:playlistbysong){
           names.add(s.getName());
        }
        System.out.println(names.size());
        playmusic.playsong(names);
       // Podcastoperation podcast=new Podcastoperation();
        //podcast.addpodcast(new Podcast("episode2","13.09",2,"2020-09-11","Ramayan","ram","valmiki","drama"));
      //  List<Podcast> p1=podcast.getallpodcast();
       // PodcastFilterOperation podcastfilter=new PodcastFilterOperation();
          /* Songoperation sp = new Songoperation();
        SongFilteroperation sf=new SongFilteroperation();
        List<Song>s1= sp.getallsong();
       System.out.println("Press 1 : for Viewing all the Songs \n Press 2 : for Adding Song  \n Press 3 : sort based on Artist \n Press 4 :  search based upon Songname \n press 5 : search based upon album\n  press 6 : search based upon Genre\n  press 7 : search based upon artistsname" );
        int choice1= sc.nextInt();
        switch(choice1){
            case 1:
                sf.display(s1);
                break;
            case 2:
                int option=0;
                do {
                    sc.nextLine();
                    String songname=sc.nextLine();
                    String songduration=sc.nextLine();
                    String artistname=sc.nextLine();
                    String artistgender=sc.nextLine();
                    String albumname=sc.nextLine();
                    String albumbdate=sc.nextLine();
                    String genername=sc.nextLine();
                    // sp.addsong(new Song("Accha Chalta Hoo", "3:15","arijit singh","male","movie","2020-05-10","abc"));
                    sp.addsong(new Song(songname, songduration,artistname,artistgender,albumname,albumbdate,genername));
                    s1 = sp.getallsong();
                    sf.display(s1);
                     option=sc.nextInt();
                }while(option!=0);
                break;
            case 3:
                List<Song> s2=  sf.getSongByArtist(s1,"sonu nigam");
                sf.display(s2);
                break;
            case 4:
                List<Song> s3=sf.searchbysongname(s1,"Accha Chalta Hoo");
                sf.display(s3);
                break;
            case 5:
                List<Song> s4=sf.searchbyalbname(s1,"movie");
                sf.display(s4);
                break;
            case 6:
                List<Song> s5=sf.searchbygenerame(s1,"abc");
                sf.display(s5);
                break;
            case 7:
                List<Song> s6= sf.searchbyartsname(s1,"sonu nigam");
                sf.display(s6);
                break;
            default:
                System.out.println("wrong choice");
        }*/
      /*  System.out.println("Press 1 : for Viewing all the Podcast \n Press 2 : for Adding Podcast  \n Press 3 : sort based on Podcastname \n Press 4 :  search based upon searchbycelebretyname \n press 5 : search based upon searchbypodcastname\n  press 6 : search based upon searchbytypename\n  press 7 : search based upon searchbynaratorname \n  press 8 : search based upon searchbyepisodename" );
        int choice= sc.nextInt();
        switch(choice){
            case 1:
                podcastfilter.podcastdatadisplay(p1);
                break;
            case 2:
               // podcast.addpodcast(new Podcast(episodename,duration,number,date,podcastname,celebrity,naratorname,type));
                podcast.addpodcast(new Podcast("episode2","13.09",2,"2020-09-11","Ramayan","ram","valmiki","drama"));
                p1=podcast.getallpodcast();
                podcastfilter.podcastdatadisplay(p1);
                break;
            case 3:
                List<Podcast> p2= podcastfilter.sortbyepodcast(p1,"Ramayan");
                podcastfilter.podcastdatadisplay(p2);
                break;
            case 4:
                List<Podcast> p3= podcastfilter.searchbycelebretyname(p1,"ram");
                podcastfilter.podcastdatadisplay(p3);
                break;
            case 5:
                List<Podcast> p4= podcastfilter.searchbypodcastname(p1,"Ramayan");
                podcastfilter.podcastdatadisplay(p4);
                break;
            case 6:
                List<Podcast> p5= podcastfilter.searchbyepisodename(p1,"episode1");
                podcastfilter.podcastdatadisplay(p5);
                break;
            case 7:
                List<Podcast> p6= podcastfilter.searchbynaratorname(p1,"valmiki");
                podcastfilter.podcastdatadisplay(p6);
                break;
            case 8:
                List<Podcast> p7= podcastfilter.searchbytypename(p1,"drama");
                podcastfilter.podcastdatadisplay(p7);
                break;
            default:
                System.out.println("wrong choice");
        }*/

        /*Playlistoperation pl=new Playlistoperation();
        List<PlaylistContent>playlist= pl.gettingAllPlaylist();
        List<SongType>playlistbysong =pl.sortbySong(playlist);*/
        /*System.out.println("option 1:Show Playlist\n option 2: Create Playlist or add add data to Playlist");
        int choice2=sc.nextInt();
      switch(choice2){
          case 1:
              pl.showPlaylist(playlist);
              break;
          case 2:
              System.out.println("option 1:adding song to Playlist\n option 2: adding song by album name to Playlist\noption 3:adding podcast to Playlist\n option 2: adding podcast by Celebrity name to Playlist\n");
              pl.findingDataFortPlaylist(2,"my song","Ae Dil Hai Mushkil","20");
              break;
          default:
              System.out.println("wrong choice");
      }*/
    }
}
