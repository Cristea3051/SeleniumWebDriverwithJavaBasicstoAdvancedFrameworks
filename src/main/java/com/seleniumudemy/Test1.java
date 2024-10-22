package com.seleniumudemy;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Test1 {

    public static void main(String[] args) {
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

        names.stream().filter(s->s.startsWith("A"))
    }
}
