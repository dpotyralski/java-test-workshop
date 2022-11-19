package pl.dpotyralski.workshop.validator;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
class PersonValidationException extends RuntimeException {

    PersonValidationErrorType type;

}
