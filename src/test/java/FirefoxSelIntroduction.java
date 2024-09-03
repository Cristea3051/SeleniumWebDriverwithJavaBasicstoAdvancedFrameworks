import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxSelIntroduction {
   public static void main(String[] args){
         
        // Invoking Browser
        FirefoxDriver driver = new FirefoxDriver();

        // Metoda pentru a chema un url din browser
        driver.get("https://rahulshettyacademy.com/");
        
        // Metoda pentru a printa titlul paginii din tabul browserului. 
        // Aceasta se va printa in consola cu ajutorul System.out.println
        System.out.println(driver.getTitle());

        // Metoda pentru a extrage URL ul curent din browser
        // tot cu ajutorul la System.out.println il afisez in consola
        System.out.println(driver.getCurrentUrl());

        // Inchide sesiunea cu totul chiar daca am mai multe taburi deschise
        driver.quit();
    }
}
