package com.epam.payment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.time.YearMonth;

@Getter
@NoArgsConstructor
public class CardInfo {
    private Long number;
    private YearMonth expires;
    private String cvv;
}
