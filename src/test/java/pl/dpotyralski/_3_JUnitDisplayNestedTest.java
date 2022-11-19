package pl.dpotyralski;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class _3_JUnitDisplayNestedTest {

    @Test
    @DisplayName(("Uuu super fancy test!"))
    void testDisplay() {
    }

    @Test
    @DisplayName(("Should just print hello world ;)"))
    void nightmare_method_name_something_x() {
    }

    @Nested
    class GetProductList {
        @Test
        void allFieldsAreIncluded() {
        }

        @Test
        void promotionApplied() {
        }

        @Test
        void filterParameterAvailable() {
        }
    }

    @Nested
    class DeleteProducts {
        @Test
        void shouldDisappearFromTheBoard() {
        }

        @Test
        void stockDecreased() {
        }

        @Test
        void productPropertiesRemovedAlong() {
        }
    }

}
