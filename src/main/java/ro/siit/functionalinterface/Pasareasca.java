package ro.siit.functionalinterface;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Pasareasca {
    public static void main(String[] args) {
        Supplier<Stream<String>> wordsSupplier = () -> Stream.of("Ana", "are", "mere");
        Supplier<Stream<String>> vocalsSupplier = () -> Stream.of("A", "E", "I", "O", "U", "a", "e", "i", "o", "u");


        wordsSupplier.get().map(
                word -> vocalsSupplier.get().reduce(word, (w, v) -> w.replaceAll(v, v + "p" + v.toLowerCase()))
        ).forEach(System.out::println);


        wordsSupplier.get()
            .map(word -> {
                for(String v: new String[] {"A", "E", "I", "O", "U", "a", "e", "i", "o", "u"})
                       word = word.replaceAll(v, v + "p" + v.toLowerCase());
                return word;
            }).forEach(System.out::println);

//        List<Integer> list = new ArrayList<Integer>();
//        list.add(2);
//        list.add(3);

//        parcurgereLista(list);

    }

    static void parcurgereLista(List<? extends Number> lista){
        // lista.add(2.7);
        lista.stream().forEach(System.out::println);
    }
}
