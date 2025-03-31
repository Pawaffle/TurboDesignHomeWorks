package w2_t5_logger;

import java.time.LocalTime;

public class Testing implements Runnable {

    private String uniqMessage;

    public Testing(String uniqMessage) {
        this.uniqMessage = uniqMessage;
    }

    @Override
    public void run() {
        Logger logger = Logger.getInstance();
        LocalTime now = LocalTime.now();
        logger.write(uniqMessage + now);
    }
}
