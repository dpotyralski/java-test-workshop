package pl.dpotyralski;

import lombok.Value;

@Value
class EmailMessage {
    String receiver;
    String topic;
    String message;
}
