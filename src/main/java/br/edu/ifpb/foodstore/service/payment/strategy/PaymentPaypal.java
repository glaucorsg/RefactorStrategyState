package br.edu.ifpb.foodstore.service.payment.strategy;

public class PaymentPaypal implements Payment {
    @Override
    public String getPayment() {
        return "Do paypal payment!";
    }
}
