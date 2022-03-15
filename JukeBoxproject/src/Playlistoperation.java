import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Playlistoperation {
    public void findingDataFortPlaylist(int choice,String nameOfPlaylist,String data,String duration){
        Songoperation song=new Songoperation();
        Podcastoperation podcast=new Podcastoperation();
        int playLstId=0, trackId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
             playLstId=gettingPlayListId(nameOfPlaylist);
             switch(choice){
                 case 1:
                      trackId=song.getsongid(data);
                     System.out.println(trackId);
                     if(trackId!=0) {
                         addTrackToPlaylist(playLstId, trackId,duration);
                     }
                     break;
                 case 2:
                     int Id= song.getalbumid(data,null);
                     if(Id!=0) {
                         List<Song> s=getallSongMatchingWithAlbumName(data);
                         for(Song k:s){
                             System.out.println(k.getSongname());
                             trackId= song.getsongid(k.getSongname());
                             System.out.println(trackId);
                             addTrackToPlaylist(playLstId, trackId,duration);
                         }
                     }
                     break;
                 case 3:
                     trackId= podcast.getpodcastepisodeid(data);
                     if(trackId!=0){
                     addTrackToPlaylist(playLstId,trackId,duration);}
                     break;
                 case 4:
                     int Id1= podcast.getcelebretyid(data);
                     if(Id1!=0){
                         List<Podcast> p=getallSongMatchingWithCelebretyName(data);
                         for(Podcast k:p){
                             System.out.println(k.getCelebretyname());
                             trackId= song.getsongid(k.getCelebretyname());
                             System.out.println(trackId);
                             addTrackToPlaylist(playLstId, trackId,duration);
                         }}
                     break;
                 default:
                     System.out.println("wrong option");
             }

        } catch (Exception ex) {
            System.out.println(ex);
        }
            }
    public void addTrackToPlaylist(int plalistid,int trackid,String duration){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            if(checkingTheTrackingId(trackid)) {
                String query = "insert into playlistcontent(playlistid,trackid,contentduration) values(?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, plalistid);
                ps.setInt(2, trackid);
                ps.setString(3,duration);
                if (ps.executeUpdate() == 1) {
                    System.out.println("added successfully");
                }
            }
            else
                System.out.println("already exist");
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public int findingPlayListId(String playlistname){ //"insert into playlistcontent(playlistid,trackid) values
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from playlist where playlistname = '"+playlistname+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int gettingPlayListId(String playListName){
        int plalistid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            plalistid=findingPlayListId(playListName);
           // System.out.println(plalistid);
            if(plalistid==0){
                String query = "insert into playlist(playlistname) values (?)";
                PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,playListName);
                int res1 = ps.executeUpdate();
                if (res1 == 1) {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()) {
                        plalistid = rs.getInt(1);
                        rs.close();
                    }
                }
                ps.close();
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return plalistid;
    }
    public boolean checkingTheTrackingId(int trackid){ //"insert into playlistcontent(playlistid,trackid) values
        boolean result=true;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from playlistcontent where trackid = '"+trackid+"'");
            if (rs.next()) {
                result=false;
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }
    public void showPlaylist(List<PlaylistContent> pc){
        Consumer<PlaylistContent> playlistdisplay = a -> System.out.println(a);
        pc.forEach(playlistdisplay);
        System.out.println("******");
    }
    public List<PlaylistContent> gettingAllPlaylist(){
        List<PlaylistContent> pl1=new ArrayList<PlaylistContent>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select* from playlistdata");
            while (rs.next()) {
               // int value = rs.getInt(3);
                if (rs.getString(4) != null) {
                    SongType p = new SongType(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                    pl1.add(p);
                }
                else{
                    PodcatType p = new PodcatType(rs.getString(1), rs.getString(2), rs.getInt(6), rs.getString(7), rs.getString(8));
                    pl1.add(p);
                }
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return pl1;
    }
   public List<Song> getallSongMatchingWithAlbumName(String name){
       List<Song> s1=new ArrayList<Song>();
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from songdata where albumname= '"+name+"'");
           while (rs.next()) {
               Song sn=new Song(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toString(),rs.getString(7));
               s1.add(sn);
           }
       }
       catch (Exception ex) {
           System.out.println(ex);
       }
       return s1;
   }
    public List<Podcast> getallSongMatchingWithCelebretyName(String name){
        List<Podcast> p1=new ArrayList<Podcast>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select* from podcastdata where celebretyname= '"+name+"'");
            while (rs.next()) {
                Podcast pn=new Podcast(rs.getString(1),rs.getString(2), rs.getInt(3),rs.getDate(4).toString(),rs.getString(5),rs.getString(6).toString(),rs.getString(7),rs.getString(7));
                p1.add(pn);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return p1;
    }
    public List<SongType> sortbySong(List<PlaylistContent>p1){
        List<SongType>seachsong=new ArrayList<SongType>();
        for(PlaylistContent pl:p1){
            if(pl instanceof SongType){
                seachsong.add((SongType)pl);
            }
        }
        return seachsong;
    }

}
