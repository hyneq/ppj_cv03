package app.assignments.message;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PingMessageTest {

    private PingMessage message;

    @Before
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
