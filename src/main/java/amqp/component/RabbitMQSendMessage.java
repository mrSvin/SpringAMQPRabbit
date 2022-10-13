package amqp.component;

import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSendMessage implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQSendMessage(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    @SneakyThrows
    public void run(String... args) {
        while (true) {
            System.out.println("Sending message...");
            rabbitTemplate.convertAndSend("myQueue", "Hello from RabbitMQ!");
            Thread.sleep(100);
        }

    }

}

