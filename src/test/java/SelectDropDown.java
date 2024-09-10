    import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
    
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

            // Select roundtrip
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();


            // Cum interactionez cu un dropdown La un nivel mai avansat
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

            // Assert equals in testng
            Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "9 Adult");




            // Dynamic dropdowns how to interact
            driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
            driver.findElement(By.xpath("//a[@value='BLR']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

            // Calendar select data
            driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();

            // Select roundtrip
            driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
            System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled() + " asta la calendar");




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
        // Select and verify checkboxes
        // Assert false in testng, va compara daca nu este selectat cheboxul va da false si va fi egal cu asertul din test ng ceea ce va face ca testul sa fie passed
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertFalse(false);
        // Va printa in colosla true sau false in dependenta daca este sau nu apasat acel checkbox
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        // Va da click pe checkbox
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
       // Va printa in colosla true sau false in dependenta daca este sau nu apasat acel checkbox
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

        // asert true/false daca a fost sau nu apasat chechboxul
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        Assert.assertTrue(true);

        // Count the number of all checkboxes in pagina
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

            driver.close();
        }
    }
