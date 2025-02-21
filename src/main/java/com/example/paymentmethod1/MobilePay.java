package com.example.paymentmethod1;

import java.time.LocalDate;

public class MobilePay implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Betaling på " + amount + " kr. behandlet via MobilePay.");
    }

    @Override
    public String generateReceipt(double amount) {
        return "Kvittering for betaling:\n" +
                "Beløb: " + amount + " kr.\n" +
                "Metode: MobilePay\n" +
                "Dato: " + LocalDate.now() + "\n";
    }
}