package pl.dpotyralski;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class _2_JUnitLifeCycleTest {

    SubjectUnderTest sub = new SubjectUnderTest();

    @BeforeAll
    public static void init() {
        System.out.println("test init!");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("test cleanup!");
    }

    @BeforeEach
    public void triggeredBeforeEach(TestInfo testInfo) {
        System.out.println("starting before test: " + testInfo.getDisplayName());
    }

    @AfterEach
    public void triggeredAfterEach(TestInfo testInfo) {
        System.out.println("started after test: " + testInfo.getDisplayName());
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }

    @Test
    void test4() {
        System.out.println("test4");
    }

    public class SubjectUnderTest {
        public SubjectUnderTest() {
            System.out.println("SubjectUnderTest was initialised");
        }
    }

}
