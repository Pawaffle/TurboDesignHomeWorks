package w2_t4_weatherSim;

public class TemperatureObserver implements Observer {
    final private WeatherStation observable;
    private int temperature;
    final private String uniqName;
    
    public TemperatureObserver(String uniqueness, WeatherStation observable) {
        this.observable = observable;
        this.uniqName = uniqueness;
        observable.addObserver(this);
    }
    
    @Override
    public void update() {
        this.temperature = this.observable.getTemperature();
        System.out.println(this.uniqName + " updated temperature: " + this.temperature);
    }

    @Override
    public String toString() {
        return this.uniqName;
    }
}
