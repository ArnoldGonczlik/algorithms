package org.pg4200.ex08;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class StreamTest {
    public static void main(String[] args) {
        /*

        String[] nameTest = {"Volvo", "BMW", "Ford", "Mazdaaaa"};

        Stream<String> nameStream = Stream.of(nameTest);

        System.out.println(nameStream.map(String::length).filter(length -> length > 3).mapToInt(x -> x).sum());

        //System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("Arnold","Jonas"));

         */

        System.out.println(transform(asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"))));

        //return people.stream().filter(p -> p.getAge() == people.stream().map(pe -> pe.getAge()).mapToInt(v -> v).max().getAsInt()).findFirst().orElse(null);
    }

    public static List<String> transform(List<List<String>> collection) {
        return collection.stream().flatMap(l -> l.stream()).collect(toList());
    }
}
