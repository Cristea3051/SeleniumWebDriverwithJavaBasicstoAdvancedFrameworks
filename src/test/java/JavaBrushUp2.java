import java.util.ArrayList;
public class JavaBrushUp2 {
    public static void main(String[] args){

        int[] array = {1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i<array.length; i++){
            if(array[i] % 2 == 0){
            System.out.println(array[i]);
            }else {
                System.out.println(array[i] + " nu se inparte exact la 2");
            }
        }
        for (int i = 0; i<array.length; i++){
            if(array[i] % 2 == 0){
            System.out.println(array[i]);
            }else {
                System.out.println(array[i] + " nu se inparte exact la 2");
            }
        }
// Code exercise
        int[] numbers = {122,23,34,56,323};

        System.out.println(numbers[0]);
        System.out.println(numbers[4]);

        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
        int total = 0;

        for (int number : numbers) {
            total += number;  // Adună valoarea curentă la total
        }

        // Afișarea rezultatului
        System.out.println("Suma totală a numerelor din array este: " + total);

// ArrauList lection 

        ArrayList<String> a = new ArrayList<String>();
        a.add("test");
        a.add("test1");
        a.add("selenium");
        a.add("java");
        a.add("distribuie");
        a.add("travis");
        a.add("scott");
        a.remove(1); // Asta sterge un element din array list
        System.out.println(a.get(2));

        for(int i = 0; i<a.size(); i++){
            System.out.println(a.get(i));

        }
        System.out.println("******************************");
        
        for (String val:a){
            System.out.println(val);
        }

        System.out.println("******************************");
        // Verifica daca elementul este prezent in aceasta lista sau nu

       System.out.println(a.contains("test1"));

    }
}
