package lesson17.task1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Anna", 30),
                new Person("Mike", 22),
                new Person("Eva", 28),
                new Person("Tom", 35)
        );

        PersonFilter ageFilter = new AgeFilter(25);
        List<Person> filteredPeople = ageFilter.filter(people);

        System.out.println("Фільтрація за віком:");
        filteredPeople.forEach(System.out::println);

        PersonProcessor personProcessor = new PersonProcessor();
        double averageAge = personProcessor.calculateAverageAge(people);

        System.out.println("\nСередній вік: " + averageAge);
    }
}