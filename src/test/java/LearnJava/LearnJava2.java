package LearnJava;

import java.util.stream.Stream;

import org.testng.annotations.Test;

public class LearnJava2 {

     @Test
    public void streamMap(){

        // Print the names witch have last letter "a" with uppercase 
        Stream.of("Andreea", "Bogdan", "Claudia", "Debil2").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

    }
}
