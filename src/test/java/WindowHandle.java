import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.Iterator;

public class WindowHandle {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windows = driver.getWindowHandles(); /* toate ide-urile ale taburilor sunt setate aici */

        Iterator<String> id = windows.iterator();
        String parentId = id.next();
        String childId = id.next();
        driver.switchTo().window(childId);

        String email = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("at")[1].trim()
                .split(" ")[0];

        System.out.println(email);

        driver.switchTo().window(parentId);

        driver.findElement(By.id("username")).sendKeys(email);

        /*
         * Deci aici este prezenta o bucata de cod care face urmatoarele:
         * 1. Navigeaza la urlul dat
         * 2. Apasa clicl pe un a tah care contine un url ce face sa se dechida un tab
         * nou
         * 3. Seteaza pentru slenium toate taburile disponibile in browser
         * 4. Formateaza si itereaza prin taburi
         * 5. Le scoate pe fiecare disponibil sub forma de variabile pentru a naviga mai
         * usor
         * 6. Face switch lui selenium la tabul urmator deschis.
         * 7. Prelucreaza elenetul din care vrem sa extragem textul: face spl;it si trim
         * si scoate doar ceea de ce am nevoie, in cazul de fata email
         * 8. Face switch la tabul principal, cel care s-a deschis pentru tima oara in
         * driver get
         * 9. Gasete inputul in care vrem sa inseram acel text de la pasul 7 si il
         * insereaza
         */
    }
}
