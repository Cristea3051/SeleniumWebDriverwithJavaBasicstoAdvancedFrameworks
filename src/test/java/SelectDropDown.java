    import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.Select;
    
    public class SelectDropDown {
    
    
        public static void main(String[] args) throws InterruptedException{
    
            WebDriver driver = new ChromeDriver();
    
            // Face maximize la browser 
            driver.manage().window().maximize();
    
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

            // Dropdown with select tag in momentul cand un select dropdown este static
            WebElement staticDropdown =  driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
            Select dropdown = new Select(staticDropdown);
            dropdown.selectByIndex(3);
            System.out.println(dropdown.getFirstSelectedOption().getText());
            dropdown.selectByVisibleText("AED");
            System.out.println(dropdown.getFirstSelectedOption().getText());
            dropdown.selectByValue("INR");
            System.out.println(dropdown.getFirstSelectedOption().getText());

            // Cum interactionez cu un dropdown na un nivel mai avansat
            driver.findElement(By.id("divpaxinfo")).click();
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
            Thread.sleep(2000);
            int i = 1;
            while (i<5) {
                driver.findElement(By.id("hrefIncAdt")).click();
                i++;
                
            } 
            for(int s =1; s<5; s++) {
                driver.findElement(By.id("hrefIncAdt")).click();

            }
            driver.findElement(By.id("btnclosepaxoption")).click();
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

            // Dynamic dropdowns how to interact
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            driver.findElement(By.xpath("//a[@value='BLR']")).click();
            Thread.sleep(2000);

            // driver.findElement(By.xpath("(//a[@value=\"MAA\"])[2]")).click();

            driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

          // (//a[@value="MAA"])[2]

        //   Autosigestive dropdown or dynamic search dropdown

        driver.findElement(By.id("autosuggest")).sendKeys("aus");
        Thread.sleep(4000);
        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for(WebElement option :options) {
         if( option.getText().equalsIgnoreCase("Austria")){
            option.click();
            break;
         }

        }
            // driver.close();
        }
    }
