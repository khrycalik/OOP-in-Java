import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        String f1 = "";
        String f2 = "";
        String f3 = "";
        HashMap<Double, Double> hm = new HashMap<>();
        BufferedReader stdin = new BufferedReader(
            new InputStreamReader(System.in));
        
        try {
            System.out.println("Podaj nazwe pierwszego pliku");
            f1 = stdin.readLine();
            System.out.println("Podaj nazwe drugiego pliku");
            f2 = stdin.readLine();
        } catch(IOException e){

        }
        Path p1 = Paths.get(f1);
        Path p2 = Paths.get(f2);

        Charset charset = Charset.forName("UTF-8");
        try {
            BufferedReader r1 =Files.newBufferedReader(p1, charset);
            BufferedReader r2 =Files.newBufferedReader(p2, charset);
            String l1 = null;
            String l2 = null;
            while ((l1 = r1.readLine()) != null && (l2 = r2.readLine()) != null)  {
                if (!l1.split(" ")[0].equals(l2.split(" ")[0])) {
                    // System.out.println(l2.split(" ")[0]);
                    // System.out.println(l1.split(" ")[0]);
                    // throw new IOException("inne wsp");
                    continue;
                } 
                hm.put(Double.parseDouble(l1.split(" ")[0]), Double.parseDouble(l1.split(" ")[1]) + Double.parseDouble(l2.split(" ")[1]));
            }
        } catch (IOException x) {
            System.err.println("IOException " + x);
            return;
        }

        try {
            BufferedWriter w1;
            Path p3;
            while (true) {
                System.out.println("Podaj nazwe pliku do zapisania danych");
                f3 = stdin.readLine();
                p3 = Paths.get(f3);
                if (Files.exists(p3)) {
                    System.out.println("Plik o tej nazwie istnieje, czy chesz go nadpisac");
                    f3 = stdin.readLine();
                    if (!f3.equals("no")) {
                        w1 = Files.newBufferedWriter(p3);
                        for (double d : hm.keySet()) {
                            w1.write("" + d + " " + hm.get(d) + "\n");
                        }
                        w1.close();
                        break;
                    }
                } else {
                    w1 = Files.newBufferedWriter(p3);
                        for (double d : hm.keySet()) {
                            w1.write("" + d + " " + hm.get(d) + "\n");
                        }
                        w1.close();
                        break;
                    }

            }
        } catch(IOException x) {
            System.err.println("IOException " + x);

        }

    }
}
