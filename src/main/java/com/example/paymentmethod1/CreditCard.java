package com.example.paymentmethod1;

import java.time.LocalDate;

public class CreditCard implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Betaling på " + amount + " kr. behandlet via kreditkort.");
    }

    @Override
    public String generateReceipt(double amount) {
        return "Kvittering for betaling:\n" +
                "Beløb: " + amount + " kr.\n" +
                "Metode: Kreditkort\n" +
                "Dato: " + LocalDate.now() + "\n";
    }
}