import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SensorManager {

    private final Map<String, Sensor> sensorMap;

    public SensorManager() {
        sensorMap = new HashMap<>();
    }

    public void printSensors() {
        sensorMap.values().forEach(System.out::println);
    }

    public void addTemperatureSensor(String name) throws SensorPresentException {
        sensorMap.put(name, new TemperatureSensor(name));
    }

    public void addAverageSensor(String name) throws SensorPresentException {
        if (sensorMap.containsKey(name)) throw new SensorPresentException();
        sensorMap.put(name, new AverageSensor(name));
    }

    public void addTemperatureSensorToAverageSensor(String average, String temperature) throws SensorNotFoundException {
        if (sensorMap.containsKey(average) && sensorMap.containsKey(temperature)) {
            ((AverageSensor)sensorMap.get(average)).addSensor(sensorMap.get(temperature));
        }
        else {
            throw new SensorNotFoundException();
        }
    }

    public void turnOff(String name) throws SensorNotFoundException {
        if (sensorMap.containsKey(name)) {
            sensorMap.get(name).setOff();;
        } else {
            throw new SensorNotFoundException();
        }
    }

    public void turnOn(String name) throws SensorNotFoundException {
        if (sensorMap.containsKey(name)) {
            sensorMap.get(name).setOn();;
        } else {
            throw new SensorNotFoundException();
        }
    }
    public int getSensorReadings(String name) throws SensorNotFoundException {
        if (sensorMap.containsKey(name)) {
            return sensorMap.get(name).read();
        } else {
            throw new SensorNotFoundException();
        }
    }

    public List<Integer> getAverageSensorReadingList(String name) throws SensorNotFoundException {
        if (sensorMap.containsKey(name)) {
            return ((AverageSensor)sensorMap.get(name)).readings();
        } else {
            throw new SensorNotFoundException();
        }
    }
}
