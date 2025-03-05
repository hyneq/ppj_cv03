package app.assignments.app;

import app.assignments.message.CustomMessage;
import app.assignments.message.Message;
import app.assignments.message.PingMessage;
import app.assignments.message.ReplyMessage;
import app.assignments.writer.ListWriter;
import app.assignments.writer.StdoutWriter;
import app.assignments.writer.Writer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {


        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

        Message ping = (Message) applicationContext.getBean(PingMessage.class);
        Message hello = (Message) applicationContext.getBean(CustomMessage.class);
        Message pingReply = (Message) applicationContext.getBean(ReplyMessage.class);

        Writer stdoutWriter = (Writer) applicationContext.getBean(StdoutWriter.class);
        Writer listWriter = (Writer) applicationContext.getBean(ListWriter.class);
        stdoutWriter.write(ping);
        stdoutWriter.write(hello);
        stdoutWriter.write(pingReply);


        listWriter.write(ping);
        ((ListWriter) listWriter).listWrittenMessages().forEach(stdoutWriter::write);

    }

}
