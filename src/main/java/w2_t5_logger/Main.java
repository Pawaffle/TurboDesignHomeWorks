package w2_t5_logger;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("log_file.txt");

        Thread t1 = new Thread(new Testing("Thread 1 message at "));
        Thread t2 = new Thread(new Testing("Thread 2 message at "));
        Thread t3 = new Thread(new Testing("Thread 3 message at "));

        t1.start();
        Sleep(1);

        t2.start();
        t3.start();

        // Wait for all threads to finish before closing logger
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.close();

        /*
        output example:

        Thread 1 message at 14:54:22.501097100
        Thread 3 message at 14:54:23.495290400
        Thread 2 message at 14:54:23.495290400
         */

    }

    private static void Sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Sleep was interrupted!");
        }
    }
}
