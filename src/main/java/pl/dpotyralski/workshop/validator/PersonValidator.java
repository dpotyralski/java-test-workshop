package pl.dpotyralski.workshop.validator;

import static pl.dpotyralski.workshop.validator.PersonValidationErrorType.EMPTY_NAME;
import static pl.dpotyralski.workshop.validator.PersonValidationErrorType.NAME_TOO_LONG;
import static pl.dpotyralski.workshop.validator.PersonValidationErrorType.NOT_OLD_ENOUGH;

class PersonValidator {

    public static final int MAX_NAME_LENGTH = 30;

    void validate(Person person) {
        validateName(person.getName());
        validateAge(person.getAge());
    }

    private void validateAge(int age) {
        if (age <= 18) {
            throw new PersonValidationException(NOT_OLD_ENOUGH);
        }
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new PersonValidationException(EMPTY_NAME);
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new PersonValidationException(NAME_TOO_LONG);
        }
    }

}
