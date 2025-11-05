package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.main.Gender.*;

public class main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Cena", FEMALE),
                new Person("Alex", MALE),
                new Person("Terry", MALE),
                new Person("Jushua", FEMALE),
                new Person("Jessica", FEMALE)
        );

        // imperative approach
        System.out.println("// imperative approach");
        List<Person> females = new ArrayList<>();

        for (Person person: people) {
            if(person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }

        for (Person female: females) {
            System.out.println(female);
        }

        Predicate<Person> personPredicate = person -> person.gender.equals(FEMALE);
        System.out.println("// declarative approach");
        people.stream()
//                .filter(person -> person.gender.equals(FEMALE))
                .filter(personPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


        enum Gender {
            MALE, FEMALE
        }

        static class Person {
            private final String name;
            private final Gender gender;
            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", gender=" + gender +
                        '}';
            }
            public Person(String name, Gender gender) {
                this.name = name;
                this.gender = gender;
            }
        }
    }
