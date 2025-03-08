package app.assignments.config;

import app.assignments.message.CustomMessage;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public PingMessage pingMessage() {
        return new PingMessage();
    }

    @Bean
    public CustomMessage customMessage(
            @Value("A sender") String sender,
            @Value("A recipient") String recipient,
            @Value("Hello world!") String text) {
        return new CustomMessage(sender, recipient, text);
    }

    @Bean
    @Autowired
    public ReplyMessage replyMessage(PingMessage pingMessage) {
        return new ReplyMessage(pingMessage, "Ping reply");
    }
}
