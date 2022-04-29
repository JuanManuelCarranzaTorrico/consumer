package com.example.consumer;
import com.example.consumer.dto.TeacherDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.example.consumer.config.RabbitMqConfig;
/**
 * @author IKKI_CARRANZA
 */
@Component
public class ConsumerTeacher {
    @RabbitListener(queues = RabbitMqConfig.T_QUEUE)
    public void listener (TeacherDto teacherDto){
        System.out.println(teacherDto);
    }
}
