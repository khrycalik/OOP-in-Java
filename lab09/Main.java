import java.util.Arrays;
import java.lang.Math;
import java.lang.reflect.*;

public class Main {
    // private static final Class<?> Double = null;
    public static void main(String[] args) {
        if (args.length==0) {
            System.out.println("No arguments to calculate.");
            return;
        }

        String[] splitted = splitArgs(args[0]);

        try {
        if (splitted.length == 3) {
            Method m = Math.class.getMethod(splitted[0], double.class, double.class);
            System.out.println("Result: " + m.invoke(double.class, Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])));
        } else if (splitted.length == 2) {
            Method m = Math.class.getMethod(splitted[0], double.class);
            System.out.println("Result: " + m.invoke(double.class, Double.parseDouble(splitted[1])));
        } else {
            System.out.println("Wrong number of arguments passed to the function, enter one or two numbers.");
        }

        }catch (IllegalAccessException e ) {
            System.out.println(e.getMessage() + "1");
            
        }
        catch (InvocationTargetException e ) {
            System.out.println(e.getMessage()+ "2");
            
        }
        catch (IllegalArgumentException e ) {
            System.out.println("Function arguments must be numbers.");
            
        }
        catch (NullPointerException e ) {
            System.out.println(e.getMessage()+ "4");
            
        }
        catch (ExceptionInInitializerError e ) {
            System.out.println(e.getMessage()+ "5");
            
        }
        catch (NoSuchMethodException e ) {
            System.out.println("There is no such method.");           
        }
        catch (SecurityException e ) {
            System.out.println(e.getMessage()+ "7");
            
        }
        
    }
    

    public static String[] splitArgs(String arg) {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> !w.isEmpty()).toArray(String[]::new);
    }
}