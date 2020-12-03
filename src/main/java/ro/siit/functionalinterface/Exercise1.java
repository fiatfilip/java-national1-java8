package ro.siit.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise1 {
    public static void main(String[] args) {
        String[] words = new String[]{"ana", "radar", "nana"};
        List<String> palindroms = Arrays.stream(words).filter(
                w -> {
//                    for (int i = 0; i < w.length() / 2; i++) {
//                        if(w.charAt(i) != w.charAt(w.length()-1-i)){
//                            return false;
//                        }
//                    }
//                    return true;
                    return IntStream.range(0, w.length() / 2)
                            .noneMatch(poz -> w.charAt(poz) != w.charAt(w.length()-1-poz));
                }
        ).collect(Collectors.toList());

        palindroms.parallelStream().forEach(System.out::println);
    }
}
