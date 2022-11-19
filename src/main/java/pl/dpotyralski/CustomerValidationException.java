package pl.dpotyralski;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
class CustomerValidationException extends RuntimeException {


}
