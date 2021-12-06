import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AverageSensor implements Sensor {
    public Set<Sensor> sensors = new HashSet<>();
    private final String name;

    public AverageSensor(String name){
        this.name = name;
    }

    public void addSensor(Sensor s) {
        sensors.add(s);
    }

    public boolean isOn(){
        boolean flag = true;
        for(Sensor s : sensors) {
            if(!s.isOn()) {
                flag = false;
            }
        }
        return flag;
    }

    public void setOn() {
        for(Sensor s : sensors) {
            s.setOn();
        }
    }

    public void setOff() {
        for(Sensor s : sensors) {
            s.setOff();
        }
    }

    public int read() throws IllegalStateException{
        if (!this.isOn()) {
            throw new IllegalStateException();
        }
        int counter = 0;
        int sum = 0;
        for(Sensor s : sensors) {
            counter++;
            sum += s.read();
        }
        return sum/counter;
    }

    public List<Integer> readings() {
        List<Integer> temps = new ArrayList<>();
        for(Sensor s : sensors) {
            temps.add(s.read());
        }
        return temps;
    }

    @Override
    public String toString() {
        String data = name + ": [";
        for (Sensor s : sensors) {
            data = data + (" " + s.toString());
        } 
        return data + "]";
    }
}
