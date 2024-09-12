public class JavaBrushUp1 {

    public static void main(String[] args) {

        // Integer variablie declaration
        int myNum = 5;

        // String variabile declaration
        String myString = "Selenium Java Course variabile";

        // Pentru un sigur caracter:
        char letter = 'v';

        // Decimale
        double dec = 5.34;

        // Boolean
        boolean myCard = true;

        // How to print
        System.out.println(myNum + " " + myString + " " + letter + " " + dec + " " + dec + " " + myCard);

        // Arrays
        // Sintaxa neaparat trebuie sa fie ca mai jos tipul de variabila stocata plus
        // paranteze patrata

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 5;
        arr[3] = 10;
        arr[4] = 200;

        int[] arr2 = { 1, 2, 5, 10, 200 };

        // For loop pentru a afisa continutul din array
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        String[] name = { "selenium", "victor", "test", "dsadsads", "dsadsa" };

        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }

        // Alta metoda de a face for lop prin array
        for (String s : name) {
            System.out.println(s);
        }

        for (int a : arr2) {
            System.out.println(a);
        }

    }

}