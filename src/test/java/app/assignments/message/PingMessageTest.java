package app.assignments.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PingMessageTest {

    private PingMessage message;

    @BeforeEach
    public void initialize() {
        message = new PingMessage();
    }

    @Test
    public void testMessageCreated() {
        new PingMessage();
    }

    @Test
    public void testSender() {
        assertEquals("ping", message.getSender());
    }

    @Test
    public void testRecipient() {
        assertEquals("pong", message.getRecipient());
    }

    @Test
    public void testText() {
        assertEquals("Ping has empty body", message.getText());
    }
}
