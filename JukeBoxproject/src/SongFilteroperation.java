import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SongFilteroperation {
    public List<Song> getSongByArtist(List<Song>s1,String artistname){
        List<Song> SongByArtist=s1.stream().filter(p->p.getArtistname().equalsIgnoreCase(artistname) ).sorted(Comparator.comparing(Song::getArtistname)).collect(Collectors.toList());
        return SongByArtist;
    }
    public List<Song> searchbygenerame(List<Song> s2,String genername) {
        List<Song> f=new ArrayList<Song>();
        Optional<Song> traveler = s2.stream().filter(p -> (p.getGenername().equalsIgnoreCase(genername))).findAny();
        if (traveler.isPresent()) {
            f = s2.stream().filter(p -> (p.getGenername().equalsIgnoreCase(genername))).collect(Collectors.toList());
        }
        return f;
    }
    public List<Song> searchbyalbname(List<Song> s3,String album) {
        List<Song> f2=new ArrayList<Song>();
        Optional<Song> traveler = s3.stream().filter(p -> (p.getAlbumname().equalsIgnoreCase(album))).findAny();
        if (traveler.isPresent()) {
            f2 = s3.stream().filter(p ->  (p.getAlbumname().equalsIgnoreCase(album))).collect(Collectors.toList());
        }
        return f2;
    }
    public List<Song> searchbyartsname(List<Song> s4,String artistname) {
        List<Song> f1=new ArrayList<Song>();
        Optional<Song> t1 = s4.stream().filter(p -> (p.getArtistname().equalsIgnoreCase(artistname))).findAny();
        if (t1.isPresent()) {
            f1 = s4.stream().filter(p -> (p.getArtistname().equalsIgnoreCase(artistname))).collect(Collectors.toList());
        }
        return f1;
    }
    public List<Song> searchbysongname (List<Song> s5,String song){
        List<Song> f3=new ArrayList<Song>();
        Optional<Song> t2 = s5.stream().filter(p -> (p.getSongname().equalsIgnoreCase(song))).findAny();
        if (t2.isPresent()) {
            f3 = s5.stream().filter(p -> (p.getSongname().equalsIgnoreCase(song))).collect(Collectors.toList());
        }
        return f3;
    }
    public void display(List<Song>s6){
        Consumer<Song> consumer1 = a -> System.out.println(a);
        s6.forEach(consumer1);
        System.out.println("******");
    }
}
