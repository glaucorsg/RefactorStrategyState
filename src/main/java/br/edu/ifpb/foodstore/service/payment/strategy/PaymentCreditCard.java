package br.edu.ifpb.foodstore.service.payment.strategy;

public class PaymentCreditCard implements Payment {
    @Override
    public String getPayment() {
        return "Do credit card payment!";
    }
}
