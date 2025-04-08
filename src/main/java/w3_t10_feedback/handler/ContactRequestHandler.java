package w3_t10_feedback.handler;

import w3_t10_feedback.message.FeedbackMessage;
import w3_t10_feedback.message.MessageType;

public class ContactRequestHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Forwarding contact request from " + message.getSenderEmail() + " to appropriate department.");
        } else {
            super.handle(message);
        }
    }
}