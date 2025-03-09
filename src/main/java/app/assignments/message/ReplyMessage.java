package app.assignments.message;

import jakarta.annotation.PostConstruct;

public class ReplyMessage implements Message {

    private Message original;
    private String reply;

    public ReplyMessage() {
    }

    public ReplyMessage(Message original, String reply) {
        this.original = original;
        this.reply = reply;
    }

    public String getSender() {
        return original.getRecipient();
    }

    public String getRecipient() {
        return original.getSender();
    }

    public String getText() {
        return "ORIGINAL:\n" + original.getText() + "\nREPLY:\n" + reply;
    }

    @PostConstruct
    public void printSelf() {
        System.out.println("A reply message has been created.\n The original text is: " + original.getText() + "\n The reply is: " + this.reply);
    }
}
