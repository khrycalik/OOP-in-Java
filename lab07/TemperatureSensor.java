import java.util.Random;

public class TemperatureSensor implements Sensor {
    private final int temp;
    private boolean isWorking = false;
    private String name;

    public TemperatureSensor(String name){
        this.temp = new Random().nextInt(61) - 30;
        this.name = name;
    }


    public boolean isOn(){
        return this.isWorking;
    }

    public void setOn() {
        this.isWorking = true;
    }

    public void setOff() {
        this.isWorking = false;
    }

    public int read() throws IllegalStateException{
        if (this.isWorking) {
            return this.temp;
        } else 
            throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return this.name + " ,running:" + this.isWorking; 
    }
}
