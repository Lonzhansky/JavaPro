package lesson16.task2;

public class CustomPredicate implements MyPredicate<Integer> {
    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }

    @Override
    public MyPredicate<Integer> negate() {
        return number -> !test(number);
    }
}