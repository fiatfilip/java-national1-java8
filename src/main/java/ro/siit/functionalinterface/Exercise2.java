package ro.siit.functionalinterface;

import java.util.stream.IntStream;

public class Exercise2 {
    public static void main(String[] args) {
        IntStream.range(2, 100)
                .filter(
//                     nr -> IntStream.rangeClosed(2, n/2)
//                             .noneMatch(div -> nr % div == 0)
                        nr -> IntStream.rangeClosed(2, (int)Math.round(Math.sqrt(nr)))
                                .noneMatch(div -> nr % div == 0)
                ).forEach(System.out::println);
    }
}
