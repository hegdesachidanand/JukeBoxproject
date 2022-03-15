public class PodcatType extends PlaylistContent{
    String episodename, episodeduration;
    int pid;
    public PodcatType(String playlistname,String contentduration,int pid,String episodename,String episodeduration){
        super( playlistname,contentduration);
        this.episodename=episodename;
        this.episodeduration=episodeduration;
    }

    public String getEpisodename() {
        return episodename;
    }

    public void setEpisodename(String episodename) {
        this.episodename = episodename;
    }

    public String getEpisodeduration() {
        return episodeduration;
    }

    public void setEpisodeduration(String episodeduration) {
        this.episodeduration = episodeduration;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString(){
        return super.toString()+" ,"+pid+"  ,"+episodename+"  ,"+episodename;
    }
}
