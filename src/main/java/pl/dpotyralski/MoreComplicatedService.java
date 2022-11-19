package pl.dpotyralski;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class MoreComplicatedService {

    private final ExampleFinalClass finalClassFromSomewhere;

    public boolean useMethodFromFinalClass() {
        return finalClassFromSomewhere.methodIWantToMock();
    }

}
