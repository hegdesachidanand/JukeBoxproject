public class PlaylistContent {
    String playlistname,contentduration;
    public PlaylistContent(String playlistname,String contentduration){
        this.playlistname=playlistname;
        this.contentduration=contentduration;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }

    public String getContentduration() {
        return contentduration;
    }

    public void setContentduration(String contentduration) {
        this.contentduration = contentduration;
    }

    @Override
    public String toString() {
        return playlistname+" ,"+ contentduration;
    }
}
