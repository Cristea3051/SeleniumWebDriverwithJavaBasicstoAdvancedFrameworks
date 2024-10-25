package com.seleniumudemy;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Test1 {

    public static void main(String[] args) {
        // Prima metoda de filtrare care implica un array care este parcurs si iterat cu un for
        // Pentru unele scenarii merge si aceasta varianta
        ArrayList<String> names = new ArrayList<String>();

        names.add("Andreea");
        names.add("Bogdan");
        names.add("Claudia");
        names.add("Daniel");
        names.add("Debil");
        names.add("Debi1");
        names.add("Debil2");
        names.add("Elena");
        names.add("George");
        names.add("Ioana");
        names.add("Mihai");
        names.add("Radu");
        names.add("Sorin");

        int count = 0;
        for(int i = 0; i<names.size(); i ++){
            String actual = names.get(i);
            if(actual.startsWith("D")){
                count++;
            }

        }
        System.out.println(count);
    }

    @Test 
    // Aceasta este a doua varianta care tot implica un masiv doar ca de data asta nu iterez cu for si if ca metoda de mai sus
    // Este o metoda mai simplificata
    public void srtreamFilter(){
        ArrayList<String> names = new ArrayList<String>();

        names.add("Andreea");
        names.add("Bogdan");
        names.add("Claudia");
        names.add("Daniel");
        names.add("Debil");
        names.add("Debi1");
        names.add("Debil2");
        names.add("Elena");
        names.add("George");
        names.add("Ioana");
        names.add("Mihai");
        names.add("Radu");
        names.add("Sorin");

        Long c = names.stream().filter(s->s.startsWith("D")).count();

        System.out.println(c);

        // Din cate inteleg aceasta este metoda cea mai simpla cand bagi totul intr-o linie
        // Dar in output ar trebui sa fie exact ceea ce este in cele linii de mai sus
        // How to use filter in stream API
      long d =  Stream.of("Andreea","Bogdan","Claudia","Debil2").filter(s->
        {  
            s.startsWith("A");
            return false;
        }).count();
        System.out.println(d);
    }
    // Comitul de pe 25.10.24

}