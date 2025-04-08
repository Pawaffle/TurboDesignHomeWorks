package w3_t10_feedback.handler;

import w3_t10_feedback.message.FeedbackMessage;
import w3_t10_feedback.message.MessageType;


public class CompensationHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("CompensationHandler: Reviewing compensation claim from " + message.getSenderEmail());
            // Simulate approval/rejection
            System.out.println("CompensationHandler: Claim reviewed and processed.");
        } else {
            super.handle(message);
        }
    }
}