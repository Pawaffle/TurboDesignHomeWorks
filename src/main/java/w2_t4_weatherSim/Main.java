package w2_t4_weatherSim;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation(5);
        Thread weatherThread = new Thread(station);


        TemperatureObserver receiver1 = new TemperatureObserver("receiver1", station);
        TemperatureObserver receiver2 = new TemperatureObserver("receiver2", station);
        TemperatureObserver receiver3 = new TemperatureObserver("receiver3", station);

        weatherThread.start();

        Sleep(10);

        station.removeObserver(receiver1);

        Sleep(10);

        TemperatureObserver receiver4 = new TemperatureObserver("receiver4", station);

        Sleep(10);

        station.terminate();
    }

    private static void Sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Sleep was interrupted!");
        }
    }
}
