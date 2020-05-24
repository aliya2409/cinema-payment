package com.epam.payment.control;

import com.epam.payment.entity.PaymentResultCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentResultRepository extends JpaRepository<PaymentResultCommand, UUID> {
}
