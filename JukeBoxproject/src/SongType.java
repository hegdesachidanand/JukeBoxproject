public class SongType extends PlaylistContent{
    String name,lengthofsong;
    int sid;
    public SongType(String playlistname,String contentduration,int sid,String name,String lengthofsong){
        super( playlistname,contentduration);
        this. sid= sid;
        this.name=name;
        this.lengthofsong=lengthofsong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLengthofsong() {
        return lengthofsong;
    }

    public void setLengthofsong(String lengthofsong) {
        this.lengthofsong = lengthofsong;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString(){
        return super.toString()+" ,"+sid+"  ,"+name+"  ,"+lengthofsong;
    }
}
