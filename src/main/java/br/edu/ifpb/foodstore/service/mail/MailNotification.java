package br.edu.ifpb.foodstore.service.mail;

import br.edu.ifpb.foodstore.domain.Customer;
import br.edu.ifpb.foodstore.service.log.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailNotification {

    private final LogService logService;

    private String emailAdministration = "contact@food-store.com";

    public void sendMailNotificationToCustomer(String message, Customer customer) {
        logService.info("send mail notification to "+ customer.getEmail());
        logService.debug(message);
    }

    public void sendMailNotificationToAdmin(String message) {
        logService.info("send mail notification to "+emailAdministration);
        logService.debug(message);
    }

}
