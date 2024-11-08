package LearnJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LearnJava2 {

     @Test
    public void streamMap(){

        // Print the names witch have last letter "a" with uppercase 
        Stream.of("Andreea", "Bogdan", "Claudia", "Debil2").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        
        // Prin names witch have first letter "a" with uppercase and sorted

        List<String> names = Arrays.asList("Andreea", "Bogdan", "Claudia", "Debil2");

        names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

         // Merge into arraylist
        //  Am doua arrays names1 si names, voi face un nou array cu elementele dina ceste doua

        ArrayList<String> brands = new ArrayList<String>();

        brands.add("Asus");
        brands.add("Apple");
        brands.add("Razer");
        brands.add("Lenovo");
        brands.add("HP");
        brands.add("MSI");
        brands.add("Dell"); 

      // Concatenez stream-urile și le colectez într-o listă pentru a putea folosi datele de mai multe ori
    List<String> combinedList = Stream.concat(names.stream(), brands.stream()).sorted().toList(); 

    // Printez și sortez toate elementele din lista nouă
    combinedList.forEach(s -> System.out.println(s));

    // Verific dacă lista conține elementul "Debil2"
    boolean flag = combinedList.stream().anyMatch(s -> s.equalsIgnoreCase("Debil2"));
    System.out.println(flag);
    Assert.assertTrue(flag);

    }

    @Test
    public void streamCollect(){

        List<String> ls = Stream.of("Andreea", "Bogdan", "Claudia", "Debil2").filter(s ->s.endsWith("a"))
        .map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls);

        List<Integer>numbers=Arrays.asList(1,2,3,4,4,5,5,1,4,5,6,7,8,9);
        // Print unique nummber form the list
        // Sort the array
        numbers.stream().distinct().forEach(s->System.out.println(s));
    }
}
