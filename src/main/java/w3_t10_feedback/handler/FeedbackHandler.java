package w3_t10_feedback.handler;

import w3_t10_feedback.message.FeedbackMessage;

public abstract class FeedbackHandler {

    private FeedbackHandler nextHandler;

    public void setNextHandler(FeedbackHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(FeedbackMessage message) {
        if (nextHandler != null) {
            nextHandler.handle(message);
        } else {
            System.out.println("No handler available for message type: " + message.getType());
        }
    }
}
