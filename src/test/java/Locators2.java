import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        String name = "Mos Vij";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);

        // Asa se foloseste un cssSelector in care localizam dupa partial link text.
        // Practic, selenium scaneaza prin toate elementele care au type si cauta
        // cuvantul pass
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);

        driver.findElement(By.id("chkboxOne")).click();

        // regular expression by xpath, aici cheia expresiei este cuvantul contains,
        // in interiorul caruia ii dam atribuntul dupa care vrem sa cautam in cazul de
        // fata este class submit
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.cssSelector("div p")).getText());

        // Comaparam textul primit cu cel asteptat cu ajutorul lui Assertion din Testng
        Assert.assertEquals(driver.findElement(By.cssSelector("div p")).getText(), "You are successfully logged in.");

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello Mos Vij,");

        // Aceasta este metoda pentru a gasi locatorul care are in el un text
        // caracteristic pentru button,
        // Deci asa gasim un button dupa mesajul care este in el, important este ca
        // textul trebuie luat din DOM
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        driver.close();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        String pass = driver.findElement(By.cssSelector("form p")).getText();

        // Aceasta este metoda cu care extrag un cuvant dintr-un sintring separat. Treb
        // de vazut si de facut s-o inteleg ca lumea
        String[] passArray = pass.split("'");
        String password = passArray[1].split("'")[0];
        return password;

    }
}
