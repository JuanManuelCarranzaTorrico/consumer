package com.example.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jrojas
 */
@Configuration
public class RabbitMqConfig {

    public static final String QUEUE = "test_queue";
    public static final String EXCHANGE = "test_exchange";
    public static final String ROUTING_KEY = "test_routing_key";
    //variables student
    public static final String S_QUEUE = "student_queue";
    public static final String S_EXCHANGE = "student_exchange";
    public static final String S_ROUTING_KEY = "student";
    //variables Teacher
    public static final String T_QUEUE = "teacher_queue";
    public static final String T_EXCHANGE = "teacher_exchange";
    public static final String T_ROUTING_KEY = "teacher";
    //variables Subject
    public static final String SU_QUEUE = "subject_queue";
    public static final String SU_EXCHANGE = "subject_exchange";
    public static final String SU_ROUTING_KEY = "subject";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
    /**
     * @author IKKI_CARRANZA
     */
    //Cola Student
    @Bean
    public Queue queue1() {
        return new Queue(S_QUEUE);
    }

    @Bean
    public DirectExchange exchange1() {
        return new DirectExchange(S_EXCHANGE);
    }

    @Bean
    public Binding binding1(Queue queue1, DirectExchange exchange1) {
        return BindingBuilder
                .bind(queue1)
                .to(exchange1)
                .with(S_ROUTING_KEY);
    }

    //Cola Teacher
    @Bean
    public Queue queue2() {
        return new Queue(T_QUEUE);
    }

    @Bean
    public DirectExchange exchange2() {
        return new DirectExchange(T_EXCHANGE);
    }

    @Bean
    public Binding binding2(Queue queue2, DirectExchange exchange2) {
        return BindingBuilder
                .bind(queue2)
                .to(exchange2)
                .with(T_ROUTING_KEY);
    }
    //Cola Subject
    @Bean
    public Queue queue3() {
        return new Queue(SU_QUEUE);
    }

    @Bean
    public DirectExchange exchange3() {
        return new DirectExchange(SU_EXCHANGE);
    }

    @Bean
    public Binding binding3(Queue queue3, DirectExchange exchange3) {
        return BindingBuilder
                .bind(queue3)
                .to(exchange3)
                .with(SU_ROUTING_KEY);
    }


}
