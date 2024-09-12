public class JavaBrushUp3 {

    public static void main(String[] args) {

        // Create a string

        String s1 = new String("welocme!");

        String s = "Rahul Shetty Academy";

        String[] splittedString = s.split("Shetty ");

        System.out.println(splittedString[0]);
        System.out.println(splittedString[1]);

        // chestia asta printeaza fiecare litera din string

        for (int i = 0; i < s1.length(); i++) {
            System.out.println(s1.charAt(i));
        }
        // chestia asta printeaza fiecare litera din string in ordine inversa
        for (int i = s1.length() - 1; i < s1.length(); i--) {
            System.out.println(s1.charAt(i));
        }

    }
}
