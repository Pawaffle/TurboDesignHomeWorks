package w3_t10_feedback;

import w3_t10_feedback.handler.*;
import w3_t10_feedback.message.*;

public class Main {

    public static void main(String[] args) {

        // Setup chain of responsibility
        FeedbackHandler handlerChain = new CompensationHandler();
        FeedbackHandler contactHandler = new ContactRequestHandler();
        FeedbackHandler suggestionHandler = new DevelopmentSuggestionHandler();
        FeedbackHandler generalHandler = new GeneralFeedbackHandler();

        handlerChain.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);

        // Create sample messages
        FeedbackMessage[] messages = {
                new FeedbackMessage(MessageType.COMPENSATION_CLAIM, "I had a bad experience and want a refund.", "user1@example.com"),
                new FeedbackMessage(MessageType.CONTACT_REQUEST, "Please contact me regarding my subscription.", "user2@example.com"),
                new FeedbackMessage(MessageType.DEVELOPMENT_SUGGESTION, "You should add dark mode.", "user3@example.com"),
                new FeedbackMessage(MessageType.GENERAL_FEEDBACK, "Great service overall!", "user4@example.com")
        };

        // Process all messages
        for (FeedbackMessage msg : messages) {
            System.out.println("\nProcessing new message:");
            handlerChain.handle(msg);
        }
    }
}
