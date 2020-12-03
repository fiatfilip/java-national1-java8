package ro.siit.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainStreams {
    public static void main(String[] args) {
        Stream<String> girls = Stream.of("Ana", "Dana", "Ioana", "Ana");
        girls.distinct()
                .filter(g -> g.length() != 4)
                .map(g -> "Hello " + g + "!").forEach(System.out::println);
        // girls.forEach(System.out::println);

        String[] elems = {"Ana", "Dana", "Ana"};
        Stream<String> elemsStream = Stream.of(elems);
        // System.out.println(elemsStream.distinct().count());

        IntStream numbers = IntStream.of(1, 2);
        IntStream a = numbers.map(
                n -> {
                    System.out.println("map 1 " + n);
                    return 2 * n;
                })
                .map(n -> {
                    System.out.println("map 2 " + n);
                    return n + 2;
                });//
        a.forEach(System.out::println);
        System.out.println(".........");
        List<Integer> integerList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        integerList.parallelStream().forEach(System.out::println);


        System.out.println("......");

        // IntStream.rangeClosed(1, 100).collect(0, Collectors.summingInt(Integer::intValue));
        int sum = IntStream.rangeClosed(1, 100).reduce(0, (n, m) -> n+m);
        System.out.println(sum);

    }
}
