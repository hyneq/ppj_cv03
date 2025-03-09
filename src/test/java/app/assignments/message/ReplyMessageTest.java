package app.assignments.message;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ReplyMessageTest {

    private static Stream<Arguments> originalMessages() {
        return Stream.of(
                arguments(new PingMessage(), "Ping reply"),
                arguments(new CustomMessage(
                        "Original sender",
                        "Original recipient",
                        "Original text."),
                        "Reply to Original text."
                )
        );
    }

    @ParameterizedTest
    @MethodSource("originalMessages")
    public void testCreateMessage(Message original, String reply) {
        ReplyMessage msg = new ReplyMessage(original, reply);

        assertEquals(original.getRecipient(), msg.getSender());
        assertEquals(original.getSender(), msg.getRecipient());
        assertEquals("ORIGINAL:\n" + original.getText() + "\nREPLY:\n" + reply, msg.getText());
    }
}
