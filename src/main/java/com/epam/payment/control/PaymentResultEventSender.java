package com.epam.payment.control;

import com.epam.payment.entity.PaymentRequestCommand;
import com.epam.payment.entity.PaymentResultCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentResultEventSender {
    private final RabbitTemplate template;
    private final Queue paymentResultQueue;
    private final ObjectMapper objectMapper;

    public void send(PaymentResultCommand command) {
        try {
            val message = objectMapper.writeValueAsString(command);
            this.template.convertAndSend(paymentResultQueue.getName(), message);
            log.debug(" [x] Sent '" + message + "'");
        }
        catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
