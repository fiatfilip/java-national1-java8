package ro.siit;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker() {
            public void doJob() {
                System.out.println("Super job");
            }
        };
        worker1.doJob();

//        Worker worker2 = new Worker() {
//            public void doJob() {
//                System.out.println("Super job 2");
//            }
//        };

        Worker worker2 = () -> System.out.println("Super job 2");
        worker2.doJob();

        // x -> System.out.println(x);
        Stream.of(2, 3, 4).forEach(
                    x -> {
                        System.out.println(2 * x);
                        System.out.println(x);
                    }
                );
        Stream.of(2.0, 3.0, 4.0).forEach(x -> printer(x, 2*x));

    }

    static void printer(Double x, Double y){
        System.out.println(x + " " + y);
    }
}
