package com.epam.payment.control;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    @Bean
    Queue paymentResultQueue() {
        return new Queue("payment-result", false);
    }
}
