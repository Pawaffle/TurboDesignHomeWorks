package w3_t10_feedback.handler;

import w3_t10_feedback.message.FeedbackMessage;
import w3_t10_feedback.message.MessageType;

public class DevelopmentSuggestionHandler extends FeedbackHandler {

    @Override
    public void handle(FeedbackMessage message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevelopmentSuggestionHandler: Logging development suggestion: \"" + message.getContent() + "\"");
        } else {
            super.handle(message);
        }
    }
}