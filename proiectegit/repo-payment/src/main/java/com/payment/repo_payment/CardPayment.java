package com.payment.repo_payment;

import org.springframework.stereotype.Service;

@Service("cardPayment")
public class CardPayment implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Plata in valoare de" +amount +"md a fost procesata prin CARD");

    }

}
