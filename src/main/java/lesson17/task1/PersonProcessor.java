package lesson17.task1;

import java.util.List;
import java.util.OptionalDouble;

public class PersonProcessor {
    public double calculateAverageAge(List<Person> people) {
        OptionalDouble averageAge = people.stream()
                .mapToInt(Person::getAge)
                .average();
        return averageAge.orElse(0);
    }
}