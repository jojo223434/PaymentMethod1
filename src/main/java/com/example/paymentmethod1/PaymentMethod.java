package com.example.paymentmethod1;

public interface PaymentMethod {
    void processPayment(double amount);
    String generateReceipt(double amount);
}