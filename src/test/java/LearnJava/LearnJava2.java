package LearnJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class LearnJava2 {

     @Test
    public void streamMap(){

        // Print the names witch have last letter "a" with uppercase 
        Stream.of("Andreea", "Bogdana", "Claudia", "Debil2").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
        
        // Prin names witch have first letter "a" with uppercase and sorted

        List<String> names = Arrays.asList("Andreea", "Bogdana", "Claudia", "Debil2");

        names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        // Merge into arraylist

        

    }
}
