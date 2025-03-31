package w2_t4_weatherSim;

public class WeatherStation extends Subject implements Runnable {

    private boolean running = true;
    private int temp;
    private int tempChange;
    private int sleepMilliseconds;

    WeatherStation(int temperature) {
        super();
        this.temp = temperature;
    }

    public void terminate(){
        this.running = false;
    }

    public int getTemperature() {
        return temp;
    }

    @Override
    public void run() {
        while (running) {

            this.tempChange = Math.random() < 0.5 ? -1 : 1;
            this.temp += this.tempChange;
            this.temp = Math.max(-30, Math.min(this.temp, +30)); // fixed between ±30
            this.sleepMilliseconds = (int) (Math.random() * 5000); // 5000 milliseconds = 5 seconds
            //System.out.println("Temperature: " + this.temp);
            notifyObservers();

            try {
                System.out.println("Sleep: " + sleepMilliseconds + " milliseconds \n");
                Thread.sleep(sleepMilliseconds);
            } catch (InterruptedException e) {
                System.out.println("Sleep was interrupted!");
            }
        }
        System.out.println("Station terminated");
    }
}
