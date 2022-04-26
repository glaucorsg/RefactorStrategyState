package br.edu.ifpb.foodstore.service.payment.strategy;

public class PaymentBillet implements Payment {
    @Override
    public String getPayment() {
        return "Do billet payment!";
    }
}
