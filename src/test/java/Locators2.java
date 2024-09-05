import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {


    public static void main(String[] args) throws InterruptedException  {


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

        // Asa se foloseste un cssSelector in care localizam dupa partial link text. 
        // Practic, selenium scaneaza prin toate elementele care au type si cauta cuvantul pass
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("chkboxOne")).click();

        // regular expression by xpath, aici cheia expresiei este cuvantul contains,  
        // in interiorul caruia ii dam atribuntul dupa care vrem sa cautam in cazul de fata este class submit
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

            Thread.sleep(2000);

        System.out.println(driver.findElement(By.cssSelector("div p")).getText());

    }
}
