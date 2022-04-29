package com.example.consumer;
import com.example.consumer.dto.MessageDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.consumer.config.RabbitMqConfig;

/**
 * @author IKKI_CARRANZA
 */
@Component
public class ConsumerListener {
    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void listener (MessageDto messageDto){
        System.out.println(messageDto);
    }
}
