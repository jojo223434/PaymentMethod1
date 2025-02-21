package com.example.paymentmethod1;

import java.time.LocalDate;

public class PayPal implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Betaling på " + amount + " kr. behandlet via PayPal.");
    }

    @Override
    public String generateReceipt(double amount) {
        return "Kvittering for betaling:\n" +
                "Beløb: " + amount + " kr.\n" +
                "Metode: PayPal\n" +
                "Dato: " + LocalDate.now() + "\n";
    }
}