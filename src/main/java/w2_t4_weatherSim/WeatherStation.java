package w2_t4_weatherSim;

public class WeatherStation extends Subject implements Runnable {

    private double temp = 0;
    private double tempChange;
    private int sleepMilliseconds;

    @Override
    public void run() {
        while (true) {

            // GPT - For a range (e.g. 1 to 100)
            // int n = (int)(Math.random() * 100) + 1;

            this.tempChange = Math.random() * 2 -1;
            this.temp = Math.round(this.temp + this.tempChange * 10) / 10.0;
            this.sleepMilliseconds = (int) (Math.random() * 5000); // 5000 milliseconds = 5 seconds
            System.out.println("Temperature: " + this.temp);

            try {
                System.out.println("Sleep: " + sleepMilliseconds);
                Thread.sleep(sleepMilliseconds);
            } catch (InterruptedException e) {
                System.out.println("Sleep was interrupted!");
            }
        }
    }
}
