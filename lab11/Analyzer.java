import java.util.Random;

public abstract class Analyzer {

    protected String[] t1;
    protected String[] t2;
    protected String[] t3;

    protected Analyzer(int n, int m) {
        t1 = new String[n];
        t2 = new String[m];
        t3 = new String[m];

        Random random = new Random();
        String data ="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String toPaste = "";
        for (int i=0; i < n; i++) {
            int max = random.nextInt(16) + 5;
            toPaste = "";
            for (int j=0; j<max; j++) {
                toPaste += data.charAt(random.nextInt(data.length()));
            }
            // System.out.println(n);
            // System.out.println(toPaste);
            t1[i] = toPaste;
        }

        for (int i=0; i<m; i++) {
            t2[i] = t1[random.nextInt(t1.length)];
        }
        for (int i=0; i < m; i++) {
            int max = random.nextInt(16) + 5;
            toPaste = "";
            for (int j=0; j<max; j++) {
                toPaste += data.charAt(random.nextInt(data.length()));
            }
            t3[i] = toPaste;
        }

        // generate t1, t2, t3 arrays content
    }

    protected abstract void fillCollection();

    protected abstract void searchPresentElementsInCollection();

    protected abstract void searchMissingElementsInCollection();

    protected abstract void deleteAllElementsInCollection();

    public final void analyse(String collectionName) {
        long start = System.nanoTime();
        fillCollection();
        System.out.println("Filling " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchPresentElementsInCollection();
        System.out.println("Searching present in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        searchMissingElementsInCollection();
        System.out.println("Searching missing in " + collectionName + ": " + (System.nanoTime() - start) + " ms");

        start = System.nanoTime();
        deleteAllElementsInCollection();
        System.out.println("Deleting all from " + collectionName + ": " + (System.nanoTime() - start) + " ms");
    }
}
