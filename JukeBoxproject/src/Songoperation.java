import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Songoperation {
    public boolean addsong(Song s1) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            int id1=getartistid(s1.getArtistname(),s1.getArtistgender());
            System.out.println(id1);
            int id2=getalbumid(s1.getAlbumname(), s1.getAlbumreleasedate());
            System.out.println(id2);
            int id3=getgenerid(s1.getGenername());
            System.out.println(id3);
            int id4=getsongid(s1.getSongname());
            System.out.println(id4);
            if(id4==0) {
                String query = "insert into song (songname,songduration,artistid,albumid,generid) values (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, s1.getSongname());
                ps.setString(2, s1.getSongduration());
                ps.setInt(3, id1);
                ps.setInt(4, id2);
                ps.setInt(5, id3);
                int res1 = ps.executeUpdate();
                if (res1 == 1) {
                    result = true;
                }
                ps.close();
                con.close();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }
    public int getsongid(String name) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from song where songname = '"+name+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }

    public int getartistid(String name,String gender) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from artist where artistname = '"+name+"'");
                if (rs.next()) {
                     id = rs.getInt(1);
                }
                else{
                    id=addartist(name, gender);
                }
                con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int getalbumid(String name,String albdt) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from album where albumname = '"+name+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            else{
                id=addalbum(name,albdt);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int getgenerid(String names) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from gener where genername = '"+names+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            else{
                id=addgener(names);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int addartist(String artname,String gender) {
        int artid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            String query = "insert into  artist (artistname,artistgender) values (?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,artname);
            ps.setString(2,gender);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    artid = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return artid;
    }
    public int addalbum(String albname,String albdte){
        int albid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            String query = "insert into  album (albumname,albumreleasedate) values (?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,albname);
            ps.setDate(2, Date.valueOf(albdte));
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    albid = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return albid;
    }
    public int addgener(String genername){
        int gnrid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            String query = "insert into  gener (genername) values (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,genername);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    gnrid = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return gnrid;
    }
    public List<Song> getallsong(){
        List<Song> s1=new ArrayList<Song>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from songdata");
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
    }
