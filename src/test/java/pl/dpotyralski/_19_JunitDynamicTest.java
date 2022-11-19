package pl.dpotyralski;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class _19_JunitDynamicTest {

    @TestFactory
    Collection<DynamicTest> dynamicTestsExample() { // Iterable, Iteration, Stream
        return Arrays.asList(
                DynamicTest.dynamicTest("Simple add test",
                        () -> {
                            //given
                            int expectedResult = 2;

                            //then
                            assertEquals(expectedResult, Math.addExact(1, 1));
                        }),
                DynamicTest.dynamicTest("Simple multiply Test",
                        () -> assertEquals(4, Math.multiplyExact(2, 2))));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        List<String> streets = Arrays.asList(
                "Wiejska", "1 sierpnia", "1 Maja");

        List<String> expectedPostalCodes = Arrays.asList(
                "00-480", "02-134", "02-495");

        PostalCodeResolver resolver = new PostalCodeResolver();

        return streets.stream()
                .map(input -> DynamicTest.dynamicTest("Resolving: " + input, () -> {
                    String expectedPostalCode = expectedPostalCodes.get(streets.indexOf(input));
                    assertEquals(expectedPostalCode, resolver.resolvePostalCode(input));
                }));
    }

    private static EmailMessage createTestEmailMessage(String receiver) {
        return new EmailMessage(receiver, "Hello", "Using Dynamic tests :)");
    }

    @TestFactory
    Stream<DynamicTest> concatTwoStreams() {
        List<EmailMessage> emails = Arrays.asList(
                createTestEmailMessage("receiver_1@acme.com"),
                createTestEmailMessage("receiver_2@acme.com")
        );

        EmailGateway gateway = mock(EmailGateway.class);
        MessageSender sender = new MessageSender(gateway);

        Stream<DynamicTest> syncEmailStream = emails.stream()
                .map(email -> DynamicTest.dynamicTest("Verifying send sync: " + email, () -> {
                    sender.sendEmailNow(email);
                    verify(gateway, times(1)).sendSync(email);
                }));

        Stream<DynamicTest> asyncEmailStream = emails.stream()
                .map(email -> DynamicTest.dynamicTest("Verifying send async: " + email, () -> {
                    sender.sendEmail(email);
                    verify(gateway, times(1)).sendSync(email);
                }));

        return Stream.concat(syncEmailStream, asyncEmailStream);
    }

}


