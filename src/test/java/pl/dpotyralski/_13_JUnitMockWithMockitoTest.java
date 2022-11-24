package pl.dpotyralski;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class _13_JUnitMockWithMockitoTest {

    EmailGateway emailGateway = mock(EmailGateway.class);
    MessageSender messageSender = new MessageSender(emailGateway);

    @Test
    void shouldSendEmailViaGatewayWhenNoValidationErrors() {
        //given
        EmailMessage emailMessage = createTestEmailWithReceiver("kate@acme.com");

        //when
        messageSender.sendEmail(emailMessage);

        //then
        verify(emailGateway, times(1)).addToSendQueue(emailMessage);
//        verify(emailGateway, only()).addToSendQueue(emailMessage);
//        verify(emailGateway, timeout(1500)).sendSync(emailMessage);
    }

    @Test
    void shouldNotSendEmailInCaseOfValidationErrors() {
        //given
        EmailMessage emailMessage = createTestEmailWithReceiver("kate#acme.com");

        //when
        messageSender.sendEmail(emailMessage);

        //then
        verify(emailGateway, never()).addToSendQueue(emailMessage);
    }

    private EmailMessage createTestEmailWithReceiver(String receiver) {
        return new EmailMessage(receiver, "hello", "always look on the bright side of life");
    }

}
