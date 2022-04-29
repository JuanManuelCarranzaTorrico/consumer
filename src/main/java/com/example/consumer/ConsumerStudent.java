package com.example.consumer;
import com.example.consumer.dto.MessageDto;
import com.example.consumer.dto.StudentDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.consumer.config.RabbitMqConfig;
/**
 * @author IKKI_CARRANZA
 */
@Component
public class ConsumerStudent {
    @RabbitListener(queues = RabbitMqConfig.S_QUEUE)
    public void listener (StudentDto studentDto){
        System.out.println(studentDto);
    }
}
