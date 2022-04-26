package br.edu.ifpb.foodstore.service.payment;

import br.edu.ifpb.foodstore.service.log.LogHandler;
import br.edu.ifpb.foodstore.service.log.LogService;
import br.edu.ifpb.foodstore.service.payment.strategy.Payment;
import br.edu.ifpb.foodstore.service.payment.strategy.PaymentFactory;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    public Payment        payment;
    public PaymentFactory typePayment = new PaymentFactory();

    public enum PaymentType {
        CREDIT_CARD, DEBIT, BILLET, PAYPAL
    }

    private final LogService logService;

    public void doPayment(PaymentService.PaymentType paymentType) throws Exception {
        this.payment = this.typePayment.typePayment(paymentType);
        logService.info(this.payment.getPayment());
    }

}
