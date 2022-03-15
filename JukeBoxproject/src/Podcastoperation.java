import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Podcastoperation {
    public boolean addpodcast(Podcast p1) {
        boolean result = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            int id1=getpodcasttypeid(p1.getPodcasttype());
            int id2=getnaratorid(p1.getNaratorname());
            int id3=getcelebretyid(p1.getCelebretyname());
            int id4=getpodcastdetailid(p1.getPodcastname(),id1,id2,id3);
            int id5=getpodcastepisodeid(p1.getEpisodename());
            if(id5==0) {
                String query = "insert into podcastepisode(episodename,episodeno,episodeduration,uploadeddate,podid) values (?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,p1.getEpisodename());
                ps.setInt(2,p1.getEpisodeno());
                ps.setString(3,p1.getEpisodeduration());
                ps.setDate(4, Date.valueOf(p1.getUploadeddate()));
                ps.setInt(5, id4);
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
    public int getpodcasttypeid(String name) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from podcasttype where podcasttype = '"+name+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            else{
                id=addpodcasttype(name);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }

    public int getnaratorid(String name) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from narator where naratorname = '"+name+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            else{
                id=addnarator(name);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int getcelebretyid(String name) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from celebrety where celebretyname = '"+name+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            else{
                id=addcelebrety(name);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int getpodcastdetailid(String names,int typeid,int narid,int clebretyid) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from podcastdetail where podcastname = '"+names+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            else{
                id=addpodcastdetail(names, typeid, narid, clebretyid);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int getpodcastepisodeid(String names) {
        int id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select* from podcastepisode where episodename = '"+names+"'");
            if (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return id;
    }
    public int addpodcasttype(String podname) {
        int podid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            String query = "insert into podcasttype(podcasttype) values (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,podname);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    podid = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return podid;
    }
    public int addnarator(String narname){
        int narid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            String query = "insert into narator(naratorname) values (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,narname);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    narid = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return narid;
    }
    public int addcelebrety(String celebretyname){
        int clbid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            String query = "insert into celebrety(celebretyname) values (?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,celebretyname);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    clbid = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return clbid;
    }
    public int addpodcastdetail(String podcastname,int typeid,int narid,int clebretyid){
        int clbid=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            String query = "insert into podcastdetail(podcastname,podcasttypeid,naratorid,celebretyid) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,podcastname);
            ps.setInt(2,typeid);
            ps.setInt(3,narid);
            ps.setInt(4,clebretyid);
            if (ps.executeUpdate() == 1) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    clbid = rs.getInt(1);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return clbid;
    }
    public List<Podcast> getallpodcast(){
        List<Podcast> s2=new ArrayList<Podcast>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectjava", "root", "password123");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select* from podcastdata");
            while (rs.next()) {
                Podcast sn=new Podcast(rs.getString(1),rs.getString(2), rs.getInt(3),rs.getDate(4).toString(),rs.getString(5),rs.getString(6).toString(),rs.getString(7),rs.getString(8));
                s2.add(sn);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return s2;
    }
}
