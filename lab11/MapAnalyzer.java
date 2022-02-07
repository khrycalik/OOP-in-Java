import java.util.Map;

public class MapAnalyzer extends Analyzer {

    private final Map<String, String> mapa;
    public MapAnalyzer(Map<String, String> mapa, int n, int m) {
        super(n, m);
        this.mapa = mapa;
    }
    @Override
    protected void fillCollection(){
        for(int i=0; i<this.t1.length; i++) {
            mapa.put(this.t1[i], this.t1[i]);
        }
    }

    @Override
    protected void searchPresentElementsInCollection(){
        for (int i=0; i<t2.length; i++) {
            mapa.get(t2[i]);
        }
    }

    @Override
    protected void searchMissingElementsInCollection(){
        for (int i=0; i<t3.length; i++) {
            mapa.get(t3[i]);
        }
    }

    @Override
    protected void deleteAllElementsInCollection(){
        mapa.clear();
    }
    
}
