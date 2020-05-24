package com.epam.payment.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRequestCommand {
    private UUID commandId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime;
    private Long orderId;
    private Long showId;
    private CardInfo cardInfo;
    private int numberOfTickets;
}
