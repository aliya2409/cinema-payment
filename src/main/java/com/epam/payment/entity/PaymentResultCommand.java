package com.epam.payment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
@Table(name = "payment_results")
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
public class PaymentResultCommand {
    @Id
    private UUID commandId = UUID.randomUUID();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate = LocalDateTime.now();
    private Long orderId;
    @Enumerated(EnumType.STRING)
    private PaymentResult result;

    public static PaymentResultCommand createFrom(Long orderId, PaymentResult result) {
        val command = new PaymentResultCommand();
        command.orderId = orderId;
        command.result = result;
        return command;
    }
}
