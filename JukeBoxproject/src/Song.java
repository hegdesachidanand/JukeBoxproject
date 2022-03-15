import java.util.Date;

public class Song {
    String songname,artistname,artistgender,albumname,genername,songduration;
    String albumreleasedate;
    public Song(String songname,String songduration,String artistname,String artistgender,String albumname,String albumreleasedate,String genername){
        this.songname=songname;
        this.songduration=songduration;
        this.artistname=artistname;
        this.artistgender=artistgender;
        this.albumname=albumname;
        this.albumreleasedate=albumreleasedate;
        this.genername=genername;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {

        this.songname = songname;
    }

    public String getArtistname() {

        return artistname;
    }

    public void setArtistname(String artistname) {

        this.artistname = artistname;
    }

    public String getArtistgender() {

        return artistgender;
    }

    public void setArtistgender(String artistgender) {

        this.artistgender = artistgender;
    }

    public String getAlbumname() {

        return albumname;
    }

    public void setAlbumname(String albumname) {

        this.albumname = albumname;
    }

    public String getGenername() {
        return genername;
    }

    public void setGenername(String genername) {

        this.genername = genername;
    }

    public String getSongduration() {
        return songduration;
    }

    public void setSongduration(String songduration) {
        this.songduration = songduration;
    }

    public String getAlbumreleasedate() {
        return albumreleasedate;
    }

    public void setAlbumreleasedate(String albumreleasedate) {
        this.albumreleasedate = albumreleasedate;
    }

    @Override
    public String toString(){
        return songname+" ,"+songduration+" ,"+artistname+" ,"+artistgender+" ,"+albumname+" ,"+albumreleasedate+" ,"+genername;
    }
}
