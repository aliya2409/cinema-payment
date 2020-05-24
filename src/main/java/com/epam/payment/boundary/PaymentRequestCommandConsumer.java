package com.epam.payment.boundary;

import com.epam.payment.control.ProcessPaymentRequestService;
import com.epam.payment.entity.PaymentRequestCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = "payment-request")
@RequiredArgsConstructor
public class PaymentRequestCommandConsumer {
    private final ObjectMapper mapper;
    private final ProcessPaymentRequestService processPaymentRequestService;

    @RabbitHandler
    public void receive(String in) {
        try {
            val command = mapper.readValue(in, PaymentRequestCommand.class);
            processPaymentRequestService.process(command);
        } catch (JsonProcessingException e) {
            log.error("Unable to parse line: " + in);
        }
    }
}
