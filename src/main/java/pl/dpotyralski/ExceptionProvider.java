package pl.dpotyralski;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ExceptionProvider {

    void operationUnsupported() {
        throw new UnsupportedOperationException("Operation is not supported!");
    }

    void illegalStateException() {
        throw new IllegalStateException("State is not right!");
    }

    void withoutException() {
        log.info("Executing method!");
    }

}
