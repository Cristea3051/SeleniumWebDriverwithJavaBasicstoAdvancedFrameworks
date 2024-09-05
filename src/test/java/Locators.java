import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {


    public static void main(String[] args) {

        // Declaram driverul
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        
        // Caut elementul cu care vreau sa interactionez in acest caz este inputul username
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        // Caut elementul care este inputul password si introduc datele mele in el
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        // Click sing in button 
        driver.findElement(By.className("signInBtn")).click();

        // Construct CSSselector. 
        // In cazul in care inputul are id -> tagname#id -> input#inputUsername
        // In cauzl in care nu este id -> Tagname[attribute='value'] -> input[placeholder='Username']

        // implicit wait - 
        // Localizeaza error textul dupa locatorul csssSelector
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // Linktext locator exemplu
        driver.findElement(By.linkText("Forgot your password?")).click();

        // Xpath locator example
        // pentru a crea un locator xpath se foloseste urmatoarea sintaxa => //tagname[@attribute='value'] => //input[@placeholder='Username']

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Test");

        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("john@rsa.com");

    }
}
