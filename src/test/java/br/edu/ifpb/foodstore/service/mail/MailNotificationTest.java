package br.edu.ifpb.foodstore.service.mail;

import br.edu.ifpb.foodstore.domain.Customer;
import br.edu.ifpb.foodstore.domain.Order;
import br.edu.ifpb.foodstore.domain.OrderItem;
import br.edu.ifpb.foodstore.domain.Product;
import br.edu.ifpb.foodstore.service.log.LogService;
import br.edu.ifpb.foodstore.service.order.OrderManager;
import br.edu.ifpb.foodstore.service.payment.PaymentService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
public class MailNotificationTest {

    @SpyBean
    private MailNotification mailNotification;

    @MockBean
    private LogService logService;

    private Customer customer;

    @BeforeEach
    public void init() {
        customer = Customer.builder()
                .email("testuser@test.com")
                .name("Diego Pessoa")
                .address("Super address")
                .build();
    }

    @SneakyThrows
    @Test
    void sendMailNotificationToCustomerTest() {
        mailNotification.sendMailNotificationToCustomer("test message", customer);
        InOrder orderVerifier = Mockito.inOrder(logService);
        orderVerifier.verify(logService).info("send mail notification to "+customer.getEmail());
        orderVerifier.verify(logService).debug("test message");
    }

    @SneakyThrows
    @Test
    void sendMailNotificationToAdminTest() {
        String adminEmail = "contact@food-store.com";
        mailNotification.sendMailNotificationToAdmin("test message");
        InOrder orderVerifier = Mockito.inOrder(logService);
        orderVerifier.verify(logService).info("send mail notification to "+adminEmail);
        orderVerifier.verify(logService).debug("test message");
    }

}
