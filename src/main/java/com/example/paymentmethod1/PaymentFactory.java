package com.example.paymentmethod1;

public class PaymentFactory {
    public PaymentMethod createPaymentMethod(PaymentType type) {
        switch (type) {
            case CREDIT_CARD:
                return new CreditCard();
            case PAYPAL:
                return new PayPal();
            case MOBILE_PAY:
                return new MobilePay();
            default:
                throw new IllegalArgumentException("Ukendt betalingsmetode: " + type);
        }
    }
}