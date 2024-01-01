package lesson17.task1;

import java.util.List;
import java.util.stream.Collectors;

public class AgeFilter implements PersonFilter {
    private int ageThreshold;

    public AgeFilter(int ageThreshold) {
        this.ageThreshold = ageThreshold;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() > ageThreshold)
                .collect(Collectors.toList());
    }
}