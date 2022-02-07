import java.util.Iterator;
import java.util.List;

public class ListAnalyzer extends Analyzer {
    private final List<String> lista;
    public ListAnalyzer(List<String> lista, int n, int m) {
        super(n, m);
        this.lista = lista;
    }
    @Override
    protected void fillCollection(){
        for(int i=0; i<this.t1.length; i++) {
            lista.add(this.t1[i]);
        }
    }

    @Override
    protected void searchPresentElementsInCollection(){
        for (int i=0; i<t2.length; i++) {
            lista.contains(t2[i]);
        }
    }

    @Override
    protected void searchMissingElementsInCollection(){
        for (int i=0; i<t3.length; i++) {
            lista.contains(t3[i]);
        }
    }

    @Override
    protected void deleteAllElementsInCollection(){
        lista.clear();
    }

    public void indexedForLoop() {
        for(int i=0; i<lista.size(); i++) {
            lista.get(i);
        }
    }

    public void forEachLoop() {
        for(String s : lista) {

        }
    }
    
    public void iteratorLoop() {
        Iterator<String> it = lista.iterator();
        while(it.hasNext()) {
            it.next();
        }
    }

    public void analyzeList(String listName) {
    fillCollection();

    long start = System.nanoTime();
    indexedForLoop();
    System.out.println("Indexed for loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");

    start = System.nanoTime();
    forEachLoop();
    System.out.println("For each loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");

    start = System.nanoTime();
    iteratorLoop();
    System.out.println("Iterator loop over " + listName + ": " +
    (System.nanoTime() - start) + " ms");
    }
}
