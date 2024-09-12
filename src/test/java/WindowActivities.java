import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        // Face maximize la browser
        driver.manage().window().maximize();

        driver.get("https://google.com/");

        // Din acelasi browser, deschide un nou url specificat mai jos
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");

        // pentru ma intoarce inapoi pe url-ul de la care al facut navigate foolosesc:
        driver.navigate().back();

        // Metoda pentru a se intoarce inapoi la navigate
        driver.navigate().forward();

        driver.close();
    }
}
