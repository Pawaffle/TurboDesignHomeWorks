package w3_t10_feedback.handler;

import w3_t10_feedback.message.FeedbackMessage;
import w3_t10_feedback.message.MessageType;

public class GeneralFeedbackHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Thanking " + message.getSenderEmail() + " for their feedback.");
        } else {
            super.handle(message);
        }
    }
}