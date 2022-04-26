package br.edu.ifpb.foodstore.service.payment.strategy;

import br.edu.ifpb.foodstore.service.payment.PaymentService;

public class PaymentFactory {

    public PaymentService.PaymentType type;

    public Payment typePayment(PaymentService.PaymentType type) throws Exception {
        this.type = type;

        switch (this.type) {
            case CREDIT_CARD:
                return new PaymentCreditCard();
            case BILLET:
                return new PaymentBillet();
            case DEBIT:
                return new PaymentDebit();
            case PAYPAL:
                return new PaymentPaypal();
            default:
                throw new Exception("unknown payment method");
        }
    }
}
