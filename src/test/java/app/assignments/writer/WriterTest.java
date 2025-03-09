package app.assignments.writer;

import app.assignments.message.CustomMessage;
import app.assignments.message.PingMessage;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public abstract class WriterTest {

    private static Stream<Arguments> messages() {
        return Stream.of(
                arguments(List.of(new PingMessage())),
                arguments(List.of(new PingMessage(), new CustomMessage("", "", ""))),
                arguments(List.of(new CustomMessage(
                                "Original sender",
                                "Original recipient",
                                "Original text."
                        ))
                )
        );
    }
}
