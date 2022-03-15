import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PodcastFilterOperation {
    public List<Podcast> sortbyepodcast(List<Podcast>p1, String podname){
        List<Podcast>sortbyepodcastname=p1.stream().filter(p->p.getPodcastname().equalsIgnoreCase(podname)).sorted(Comparator.comparing(Podcast::getPodcastname)).collect(Collectors.toList());
        return sortbyepodcastname;
    }
    public List<Podcast> searchbycelebretyname (List<Podcast> k1,String celebretyname) {
        List<Podcast> f3 = new ArrayList<Podcast>();
        Optional<Podcast> t2 = k1.stream().filter(p -> (p.getCelebretyname().equalsIgnoreCase(celebretyname))).findAny();
        if (t2.isPresent()) {
            f3 = k1.stream().filter(p -> (p.getCelebretyname().equalsIgnoreCase(celebretyname))).collect(Collectors.toList());
        }
        return f3;
    }
    public List<Podcast> searchbypodcastname (List<Podcast> k2,String podcastname) {
        List<Podcast> f3 = new ArrayList<Podcast>();
        Optional<Podcast> t2 = k2.stream().filter(p -> (p.getPodcastname().equalsIgnoreCase(podcastname))).findAny();
        if (t2.isPresent()) {
            f3 = k2.stream().filter(p -> (p.getPodcastname().equalsIgnoreCase(podcastname))).collect(Collectors.toList());
        }
        return f3;
    }
    public List<Podcast> searchbytypename (List<Podcast> k3,String typename) {
        List<Podcast> f3 = new ArrayList<Podcast>();
        Optional<Podcast> t2 = k3.stream().filter(p -> (p.getPodcasttype().equalsIgnoreCase(typename))).findAny();
        if (t2.isPresent()) {
            f3 = k3.stream().filter(p -> (p.getPodcasttype().equalsIgnoreCase(typename))).collect(Collectors.toList());
        }
        return f3;
    }
    public List<Podcast> searchbynaratorname (List<Podcast> k4,String naratorname) {
        List<Podcast> f3 = new ArrayList<Podcast>();
        Optional<Podcast> t2 = k4.stream().filter(p -> (p.getNaratorname().equalsIgnoreCase(naratorname))).findAny();
        if (t2.isPresent()) {
            f3 = k4.stream().filter(p -> (p.getNaratorname().equalsIgnoreCase(naratorname))).collect(Collectors.toList());
        }
        return f3;
    }
    public List<Podcast> searchbyepisodename (List<Podcast> k5,String episodename) {
        List<Podcast> f3 = new ArrayList<Podcast>();
        Optional<Podcast> t2 = k5.stream().filter(p -> (p.getEpisodename().equalsIgnoreCase(episodename))).findAny();
        if (t2.isPresent()) {
            f3 = k5.stream().filter(p -> (p.getEpisodename().equalsIgnoreCase(episodename))).collect(Collectors.toList());
        }
        return f3;
    }
    public void podcastdatadisplay(List<Podcast>s6){
        Consumer<Podcast> consumer1 = a -> System.out.println(a);
        s6.forEach(consumer1);
        System.out.println("******");
    }
}
