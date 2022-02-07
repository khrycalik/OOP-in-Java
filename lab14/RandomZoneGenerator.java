import java.lang.reflect.Array;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RandomZoneGenerator {
    private Long l;
    RandomZoneGenerator(Long seed) {
        this.l = seed;
    }

    public ZoneId generate() {
        Random r = new Random(this.l);
        List<ZoneId> s = ZoneId.getAvailableZoneIds().stream().map(x -> ZoneId.of(x)).collect(Collectors.toList());
        return s.get(r.nextInt(s.size()));
    }
    
}
