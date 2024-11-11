package LearnJava;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterDataLoopInfoFromTable {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on column
        driver.findElement(By.cssSelector("th[aria-label='Veg/fruit name: activate to sort column ascending']")).click();

        // Capture all webelements into list 
         List<WebElement> elementsList = driver.findElements(By.cssSelector(".table > tbody > tr"));

         // Extract the text
         List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
        
        // Sort ito list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < originalList.size(); i++) {
            System.out.println(originalList.get(i) + "---------" + sortedList.get(i));
        }
        // Check if is sortet with assertions
        Assert.assertTrue(originalList.equals(sortedList));

    }
}
