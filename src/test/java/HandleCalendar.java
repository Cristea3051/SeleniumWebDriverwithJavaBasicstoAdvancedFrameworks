import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleCalendar {

    public static void main(String[] args) throws InterruptedException {
        String monthNumber = "12";
        String date = "6";
        String year = "2030";

        String[] expectedLsit = { monthNumber, date, year };

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        driver.findElement(By.cssSelector("div[class ='react-date-picker__inputGroup']")).click();

        WebElement yearCalendar = driver
                .findElement(By.cssSelector("button[class ='react-calendar__navigation__label']"));

        yearCalendar.click();
        Thread.sleep(2000);
        yearCalendar.click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        List<WebElement> monthElements = driver.findElements(
                By.cssSelector("button[class='react-calendar__tile react-calendar__year-view__months__month']"));

        monthElements.get(Integer.parseInt(monthNumber) - 1).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedLsit[i + 1]);
        }
        driver.close();
    }
}
