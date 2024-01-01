package lesson17.task1;

import lesson17.task1.AgeFilter;
import lesson17.task1.Person;
import lesson17.task1.PersonFilter;
import lesson17.task1.PersonProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamApiTest {

    @Test
    public void testAgeFilter() {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Anna", 30),
                new Person("Mike", 22),
                new Person("Eva", 28),
                new Person("Tom", 35)
        );

        PersonFilter ageFilter = new AgeFilter(25);
        List<Person> filteredPeople = ageFilter.filter(people);

        assertEquals(3, filteredPeople.size());
        assertTrue(filteredPeople.stream().allMatch(person -> person.getAge() >= 25));
    }

    @Test
    public void testAgeFilterWithEmptyList() {
        List<Person> emptyList = Collections.emptyList();

        PersonFilter ageFilter = new AgeFilter(25);
        List<Person> filteredPeople = ageFilter.filter(emptyList);

        assertTrue(filteredPeople.isEmpty());
    }

    @Test
    public void testCalculateAverageAge() {
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Anna", 30),
                new Person("Mike", 22),
                new Person("Eva", 28),
                new Person("Tom", 35)
        );

        PersonProcessor personProcessor = new PersonProcessor();
        double averageAge = personProcessor.calculateAverageAge(people);

        assertEquals(28.0, averageAge, 0.01);
    }

    @Test
    public void testCalculateAverageAgeWithEmptyList() {
        List<Person> emptyList = Collections.emptyList();

        PersonProcessor personProcessor = new PersonProcessor();
        double averageAge = personProcessor.calculateAverageAge(emptyList);

        assertEquals(0.0, averageAge, 0.01);
    }

    @Test
    public void testCalculateAverageAgeWithSinglePerson() {
        List<Person> singlePersonList = Collections.singletonList(new Person("John", 30));

        PersonProcessor personProcessor = new PersonProcessor();
        double averageAge = personProcessor.calculateAverageAge(singlePersonList);

        assertEquals(30.0, averageAge, 0.01);
    }
}