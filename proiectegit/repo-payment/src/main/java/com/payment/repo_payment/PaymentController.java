package com.payment.repo_payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService cardPaymentService;
    private final PaymentService cashPaymentService;

    // Spring injecta implementarea corecta  utilizind numele componentului
    @Autowired
    public PaymentController(
            @Qualifier("cardPayment") PaymentService cardPaymentService,
            @Qualifier("cashPayment") PaymentService cashPaymentService) {
        this.cardPaymentService = cardPaymentService;
        this.cashPaymentService = cashPaymentService;
    }

    @PostMapping("/card")
    public String payWithCard(@RequestParam double amount) {
        cardPaymentService.processPayment(amount);
        return "Plata cu cardul in proces.";
    }

    @PostMapping("/cash")
    public String payWithCash(@RequestParam double amount) {
        cashPaymentService.processPayment(amount);
        return "Plata cash in proces.";
    }
}
