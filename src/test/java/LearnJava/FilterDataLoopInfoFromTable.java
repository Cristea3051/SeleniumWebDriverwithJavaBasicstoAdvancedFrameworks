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

        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on column
        driver.findElement(By.cssSelector("th[aria-label='Veg/fruit name: activate to sort column ascending']")).click();

        // Capture all webelements into list 
         List<WebElement> elementsList = driver.findElements(By.xpath("//div[@class='products-wrapper']//table//tr//td[1]"));

         // Extract the text
         List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
        
        // Sort ito list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < originalList.size(); i++) {
            System.out.println(originalList.get(i) + "---------" + sortedList.get(i));
        }
        // Check if is sortet with assertions
        Assert.assertTrue(originalList.equals(sortedList));

        // Scan thename column with getText() option
        // For example Beans->print the price of the Beans 
        List<String> price;
        do{
       List<WebElement> rows = driver.findElements(By.xpath("//div[@class='products-wrapper']//table//tr//td[1]"));
       price = rows.stream().filter(s -> s.getText().contains("Rice"))
            .map(s->getPriceVeggie(s)).collect(Collectors.toList()); 

            price.forEach(a->System.out.println(a));

            // navigate to the page that contains rice and scan it
            if(price.size()<1){
                 driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }while(price.size()<1);

            driver.quit();

    }
    private static String getPriceVeggie(WebElement s){

       String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText(); 
        return pricevalue;
    } 
}
