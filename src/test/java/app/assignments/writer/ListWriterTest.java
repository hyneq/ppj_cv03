package app.assignments.writer;

import app.assignments.message.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListWriterTest extends WriterTest {

    ListWriter emptyWriter;

    @BeforeEach
    public void initialize() {
        emptyWriter = new ListWriter();
    }

    @Test
    public void testCreateWriter() {
        ListWriter writer = new ListWriter();

        assertEquals(
                Collections.unmodifiableList(new ArrayList<>()),
                writer.listWrittenMessages()
        );
    }

    @ParameterizedTest
    @MethodSource("messages")
    public void testWrite(List<Message> messages) {
        for (Message msg : messages) {
            emptyWriter.write(msg);
        }

        assertEquals(messages, emptyWriter.listWrittenMessages());
    }
}
