package pl.dpotyralski;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class _12_JUnitDataDrivenArgumentsSourceTest {

    @ParameterizedTest
    @ArgumentsSource(CustomArgumentsProvider.class)
    void shouldSupportAllPassedLanguages(String language) {
        //given
        List<String> supportedLanguages = Arrays.asList("java", "c++", "typescript", "kotlin", "rust");

        //then
        assertTrue(supportedLanguages.contains(language));
//        Assertions.assertThat(supportedLanguages).contains(language);
    }

    static class CustomArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of("java", "kotlin", "typescript").map(Arguments::of);
        }
    }

}
