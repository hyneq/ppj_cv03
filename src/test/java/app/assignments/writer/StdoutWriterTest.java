package app.assignments.writer;

import app.assignments.message.Message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StdoutWriterTest extends WriterTest {

    private final ByteArrayOutputStream fakeOut = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private StdoutWriter writer;

    @BeforeEach
    public void initialize() {
        System.setOut(new PrintStream(fakeOut));
        writer = new StdoutWriter();
    }

    @AfterEach
    public void restore() {
        System.setOut(originalOut);
    }

    @Test
    public void testCreateWriter() {
        StdoutWriter writer = new StdoutWriter();
    }

    @ParameterizedTest
    @MethodSource("messages")
    public void testWrite(List<Message> messages) {
        StringBuilder expectedOut = new StringBuilder();
        for (Message msg : messages) {
            writer.write(msg);
            expectedOut.append(String.format("MESSAGE\nFrom: %s\nTo: %s\n\n%s\n" + System.lineSeparator(),
                    msg.getSender(),
                    msg.getRecipient(),
                    msg.getText()));
        }

        assertEquals(expectedOut.toString(), fakeOut.toString());
    }
}
