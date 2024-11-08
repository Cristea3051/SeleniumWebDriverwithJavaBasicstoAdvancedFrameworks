package LearnJava;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class LearnJava1 {

    public static void main(String[] args) {
        // Prima metoda de filtrare care implica un array care este parcurs si iterat cu un for
        ArrayList<String> names = new ArrayList<String>();

        names.add("Andreea");
        names.add("Bogdan");
        names.add("Claudia");
        names.add("Daniel");
        names.add("Debil");
        names.add("Debi1");
        names.add("Debil2");
        names.add("DElena");
        names.add("DDGeorge");
        names.add("DIoana");
        names.add("Mihai");
        names.add("Radu");
        names.add("Sorin");

        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("D")) {
                count++;
            }
        }
        System.out.println("Număr de nume care încep cu 'D': " + count);
    }

    @Test 
    public void srtreamFilter() {
        ArrayList<String> names = new ArrayList<String>();

        names.add("Andreea");
        names.add("Bogdan");
        names.add("Claudia");
        names.add("Danielsdsds");
        names.add("Debildssds");
        names.add("Debi1sdsds");
        names.add("Debil2sdsdssd");
        names.add("Dssddslena");
        names.add("DGeorge");
        names.add("Ioana");
        names.add("Mihai");
        names.add("Radu");
        names.add("Sorin");

        long count = names.stream().filter(s -> s.startsWith("D")).count();
        System.out.println("Număr de nume care încep cu 'D' (stream): " + count);

        // Print the actual names that start with 'D'
        System.out.println("Nume care încep cu 'D':");
        names.stream()
             .filter(s -> s.startsWith("D"))
             .forEach(System.out::println);

        // Demonstrating the stream filtering with an array
        long d = Stream.of("Andreea", "Bogdan", "Claudia", "Debil2")
                       .filter(s -> s.startsWith("D"))
                       .count();
        System.out.println("Numărul de nume din array care încep cu 'D': " + d);

        // Print the actual names from the array that start with 'D'
        System.out.println("Nume din array care încep cu 'D':");
        Stream.of("Andreea", "Bogdan", "Claudia", "Debil2")
              .filter(s -> s.startsWith("D"))
              .forEach(System.out::println);

        // Count and print names starting with 'D' again
        long e = names.stream().filter(s -> s.startsWith("D")).count();
        System.out.println("Număr de nume care încep cu 'D': " + e);
    }

}