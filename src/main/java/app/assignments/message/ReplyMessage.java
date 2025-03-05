package app.assignments.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReplyMessage implements Message {

    private Message original;
    private String reply;

    public ReplyMessage() {
    }

    public ReplyMessage(Message original, String reply) {
        this.original = original;
        this.reply = reply;
    }

    @Autowired
    public void setPingMessage(PingMessage original) {
        this.original = original;
    }

    @Value("Ping reply")
    public void setReply(String reply) {
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
}
