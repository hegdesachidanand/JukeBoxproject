public class Podcast {
    String episodename,episodeduration,uploadeddate,podcastname,celebretyname,naratorname,podcasttype;
    int episodeno;
    public Podcast(String episodename,String episodeduration,int episodeno,String uploadeddate,String podcastname,String celebretyname,String naratorname,String podcasttype){
        this.episodename=episodename;
        this.episodeduration=episodeduration;
        this.episodeno=episodeno;
        this.uploadeddate=uploadeddate;
        this.podcastname=podcastname;
        this.celebretyname=celebretyname;
        this.naratorname=naratorname;
        this.podcasttype=podcasttype;
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

    public String getUploadeddate() {
        return uploadeddate;
    }

    public void setUploadeddate(String uploadeddate) {
        this.uploadeddate = uploadeddate;
    }

    public String getPodcastname() {
        return podcastname;
    }

    public void setPodcastname(String podcastname) {
        this.podcastname = podcastname;
    }

    public String getCelebretyname() {
        return celebretyname;
    }

    public void setCelebretyname(String celebretyname) {
        this.celebretyname = celebretyname;
    }

    public String getNaratorname() {
        return naratorname;
    }

    public void setNaratorname(String naratorname) {
        this.naratorname = naratorname;
    }

    public String getPodcasttype() {
        return podcasttype;
    }

    public void setPodcasttype(String podcasttype) {
        this.podcasttype = podcasttype;
    }

    public int getEpisodeno() {
        return episodeno;
    }

    public void setEpisodeno(int episodeno) {
        this.episodeno = episodeno;
    }

    @Override
    public String toString(){
        return episodename+" ,"+episodeduration+" ,"+episodeno+" ,"+uploadeddate+" ,"+podcastname+" ,"+celebretyname+" ,"+naratorname+" ,"+podcasttype;
    }
}
