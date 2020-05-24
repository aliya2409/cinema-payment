package com.epam.payment.control;

import com.epam.payment.entity.PaymentRequestCommand;
import com.epam.payment.entity.PaymentResult;
import com.epam.payment.entity.PaymentResultCommand;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProcessPaymentRequestService {
    private final PaymentResultRepository paymentResultRepository;
    private final PaymentResultEventSender paymentResultEventSender;

    public void process(PaymentRequestCommand request) {
        //mocked for success for now
        val result = PaymentResultCommand.createFrom(request.getOrderId(), PaymentResult.SUCCESS);
        paymentResultRepository.save(result);
        paymentResultEventSender.send(result);
    }
}
