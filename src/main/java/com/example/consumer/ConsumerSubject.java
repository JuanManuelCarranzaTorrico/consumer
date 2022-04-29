package com.example.consumer;
import com.example.consumer.dto.SubjectDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.consumer.config.RabbitMqConfig;
/**
 * @author IKKI_CARRANZA
 */
@Component
public class ConsumerSubject {
    @RabbitListener(queues = RabbitMqConfig.SU_QUEUE)
    public void listener (SubjectDto subjectDto){
        System.out.println(subjectDto);
    }
}
