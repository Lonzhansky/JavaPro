package lesson16.task2;

import org.junit.jupiter.api.Test;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

public class PredicateTest {

    @Test
    public void testStandardPredicate() {
        Predicate<Integer> standardPredicate = n -> n % 2 == 0;

        assertTrue(standardPredicate.test(4));
        assertFalse(standardPredicate.test(5));
    }

    @Test
    public void testCustomPredicate() {
        MyPredicate<Integer> customPredicate = new CustomPredicate();

        assertTrue(customPredicate.test(4));
        assertFalse(customPredicate.test(5));
    }

    @Test
    public void testNegatedCustomPredicate() {
        MyPredicate<Integer> customPredicate = new CustomPredicate();
        MyPredicate<Integer> negatedPredicate = customPredicate.negate();

        assertFalse(negatedPredicate.test(4));
        assertTrue(negatedPredicate.test(5));
    }
}
