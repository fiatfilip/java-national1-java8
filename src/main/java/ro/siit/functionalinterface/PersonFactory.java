package ro.siit.functionalinterface;

@FunctionalInterface
public interface PersonFactory {
    Person createPerson(String name, Integer age);
}
