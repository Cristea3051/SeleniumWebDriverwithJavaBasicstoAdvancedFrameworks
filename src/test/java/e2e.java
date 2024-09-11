import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

           // Select ckeckbox
           System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
           // Va da click pe checkbox
           driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
           // Va printa in colosla true sau false in dependenta daca este sau nu apasat acel checkbox
           System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());

            // Select destination from to 
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            driver.findElement(By.xpath("//a[@value='DEL']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

            // Calendar select data
            driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();

            // verifica daca al doilea calendar este disable
            if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
                System.out.println("its enabled");
                Assert.assertTrue(false);
            }else {
                Assert.assertTrue(true);
            }

            // Select cati pasageri vor calatori
            driver.findElement(By.id("divpaxinfo")).click();
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
            Thread.sleep(2000);
            for(int s =1; s<5; s++) {
                driver.findElement(By.id("hrefIncAdt")).click();

            }
            driver.findElement(By.id("btnclosepaxoption")).click();
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
            // Assert equals in testng
            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

            // Select Currency
             WebElement select = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
             Select option = new Select(select);
             option.selectByVisibleText("USD");

            // Submit button
            driver.findElement(By.cssSelector("input[type='submit']")).click();


    }

}
