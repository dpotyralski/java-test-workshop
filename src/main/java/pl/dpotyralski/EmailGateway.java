package pl.dpotyralski;

public interface EmailGateway {

    void addToSendQueue(EmailMessage emailMessage);

    void sendSync(EmailMessage emailMessage);

}
