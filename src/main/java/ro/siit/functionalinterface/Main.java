package ro.siit.functionalinterface;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        PersonFactory factory = Person::new;
        // PersonFactory factory = (name, age) -> new Person(name, age);

//        Set<Person> personSet =
//                new TreeSet<>((p1, p2) -> p1.getName().compareTo(p2.getName()));

        Set<Person> personSet =
                new TreeSet<>(Comparator.comparing(Person::getAge));

        Set<Person> personSet1bis =
                new TreeSet<Person>((p1, p2) -> {
                    if(p1.getName().compareTo(p2.getName()) == 0){
                        return p1.getAge().compareTo(p2.getAge());
                    }
                    return p1.getName().compareTo(p2.getName());
                });

        personSet.add(factory.createPerson("Ion", 25));
        personSet.add(new Person("Marcela", 22));

        personSet.stream().forEach(p -> System.out.println(p));

        personSet.stream().forEach(System.out::println);


        Set<Person> personSet2 =
                new TreeSet<>(Comparator.comparing(Person::getAge));
        personSet2.addAll(personSet);

        personSet2.stream()
                .filter(p -> p.getAge() > 23)
                .map(Person::getName)
                .forEach(System.out::println);

//        Runnable fir = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Executie fir");
//            }
//        };

        Runnable fir = () -> System.out.println("Executie fir");

        new Thread(fir).start();



    }
}
