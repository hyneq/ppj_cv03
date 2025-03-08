package app.assignments.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("app.assignments")
@Import({MessageConfig.class, WriterConfig.class})
public class AppConfig {}
