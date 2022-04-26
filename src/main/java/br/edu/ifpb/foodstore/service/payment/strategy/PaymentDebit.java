package br.edu.ifpb.foodstore.service.payment.strategy;

public class PaymentDebit implements Payment {
    @Override
    public String getPayment() {
        return "Do debit payment!";
    }
}
