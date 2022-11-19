package pl.dpotyralski;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Year;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _11_JUnitDataDrivenMethodSourceTest {

    MovieTitleResolver resolver = new MovieTitleResolver();

    private static Stream<Arguments> provideMovieForFullTitleValidation() {
        return Stream.of(
                Arguments.of(new Movie("Shutter Island", Year.of(2010))),
                Arguments.of(new Movie("Inception", Year.of(2010))),
                Arguments.of(new Movie("Matrix", Year.of(1999)))
        );
    }

    @ParameterizedTest
    @MethodSource({"provideMovieForFullTitleValidation"})
    void shouldResolveFullTitleForPassedMovie(Movie movie) {
        //given
        String expected = movie.title() + " from " + movie.productionYear();

        //when
        String actual = resolver.resolveFullTitle(movie);

        //then
        assertEquals(expected, actual);
    }

    private static class MovieTitleResolver {
        String resolveFullTitle(Movie movie) {
            return movie.title() + " from " + movie.productionYear();
        }
    }

    record Movie(String title, Year productionYear) {
    }

}
