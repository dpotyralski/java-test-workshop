package pl.dpotyralski;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;

@Slf4j
@AllArgsConstructor
class MessageSender {

    private final EmailGateway emailGateway;
    private final EmailValidator emailValidator = EmailValidator.getInstance();

    public void sendEmail(EmailMessage email) {
        if (emailValidator.isValid(email.getReceiver())) {
            emailGateway.addToSendQueue(email);
        }
    }

    public void sendEmailNow(EmailMessage email) {
        if (emailValidator.isValid(email.getReceiver())) {
            emailGateway.sendSync(email);
        }
    }

}
