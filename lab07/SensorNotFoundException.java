public class SensorNotFoundException extends Exception{

    public SensorNotFoundException(){
        super("nie znaleziono podanego czujnika");
    }
}
