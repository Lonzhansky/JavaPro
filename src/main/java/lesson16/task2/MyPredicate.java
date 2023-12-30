package lesson16.task2;

import java.util.function.Predicate;

@FunctionalInterface
public interface MyPredicate<T> extends Predicate<T> {
    default MyPredicate<T> negate() {
        return t -> !test(t);
    }
}