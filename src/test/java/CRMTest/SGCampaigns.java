package CRMTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class SGCampaigns {
public static void main(String[] args) throws InterruptedException {

    String monthNumber = "12";
    String date = "6";
    String year = "2030";

        WebDriver driver = new ChromeDriver();

        driver.get("http://crm-dash/login");

        Thread.sleep(2000); 
        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");

        driver.findElement(By.id("login-password")).sendKeys("Morris22##");

        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();
        
        // Navighează la pagina cu filtrul
        driver.get("http://crm-dash/google-accounts");

        // Așteaptă ca filtrul să fie vizibil
        Thread.sleep(2000);
        
        // Click pe secțiunea de filtrare pentru a o extinde
        driver.findElement(By.cssSelector("i[class='fas fa-caret-down']:nth-child(1)")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("div[data-collapse='Delivered']")).click();
        Thread.sleep(2000);
        // driver.findElement(By.cssSelector("input[data-date-format='Y-m-d']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("input[name='google_accounts.mb_delivery_date']")));
        Thread.sleep(5000);
        // Selectează toate elementele care respectă clasa
List<WebElement> todayElements = driver.findElements(By.cssSelector("span.flatpickr-day.today"));
System.out.println(todayElements);
// Verifică dacă sunt suficiente elemente și selectează al 12-lea
if (todayElements.size() >= 12) {
    WebElement twelfthElement = todayElements.get(11); // Indexul este zero-based, deci al 12-lea este la index 11
    twelfthElement.click();
} else {
    System.out.println("Nu există suficiente elemente today pentru a selecta al 12-lea.");
}

        // WebElement yearCalendar = driver
        //         .findElement(By.cssSelector("button[class ='react-calendar__navigation__label']"));

        // yearCalendar.click();
        // Thread.sleep(2000);
        // yearCalendar.click();
        // driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        // List<WebElement> monthElements = driver.findElements(
        //         By.cssSelector("button[class='react-calendar__tile react-calendar__year-view__months__month']"));

        // monthElements.get(Integer.parseInt(monthNumber) - 1).click();
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

        // List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        // for (int i = 0; i < actualList.size(); i++) {
        //     System.out.println(actualList.get(i).getAttribute("value"));
        // }
}
}
