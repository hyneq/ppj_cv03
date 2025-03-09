package app.assignments.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CustomMessageTest {

    CustomMessage emptyMsg;

    @BeforeEach
    public void initialize() {
        emptyMsg = new CustomMessage();
    }

    @Test
    public void testCreateMessageEmptyConstructor() {
        CustomMessage msg = new CustomMessage();

        assertNull(msg.getSender());
        assertNull(msg.getRecipient());
        assertNull(msg.getText());
    }

    @ParameterizedTest
    @MethodSource("constructorParams")
    public void testCreateMessageConstructorWithParameters(String sender, String recipient, String text) {
        CustomMessage msg = new CustomMessage(sender, recipient, text);

        assertEquals(sender, msg.getSender());
        assertEquals(recipient, msg.getRecipient());
        assertEquals(text, msg.getText());
    }

    private static Stream<Arguments> constructorParams() {
        return Stream.of(
                arguments("", "", ""),
                arguments("Sender1", "Recipient1", "Text1"),
                arguments("2S", "2R", "2T"),
                arguments("Hynek Vaclav Svobodny", "John Doe", "Hello, this is a test case.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Sender1", "2S", "Hynek Vaclav Svobodny"})
    public void testSetSender(String sender) {
        emptyMsg.setSender(sender);
        assertEquals(sender, emptyMsg.getSender());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Recipient1", "2R", "John Doe"})
    public void testSetRecipient(String recipient) {
        emptyMsg.setRecipient(recipient);
        assertEquals(recipient, emptyMsg.getRecipient());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Recipient1", "2R", "John Doe"})
    public void testSetText(String text) {
        emptyMsg.setText(text);
        assertEquals(text, emptyMsg.getText());
    }

}
