import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CompleteAndSubmit {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new ChromeDriver();
    
            // Face maximize la browser 
            driver.manage().window().maximize();

            driver.get("https://rahulshettyacademy.com/angularpractice/");

            driver.findElement(By.name("name")).sendKeys("Test Name");
            driver.findElement(By.name("email")).sendKeys("test@email.com");
            driver.findElement(By.id("exampleInputPassword1")).sendKeys("testpass123");
            System.out.println(driver.findElement(By.id("exampleCheck1")).isSelected());
            driver.findElement(By.id("exampleCheck1")).click();
            System.out.println(driver.findElement(By.id("exampleCheck1")).isSelected());
            WebElement select = driver.findElement(By.id("exampleFormControlSelect1"));
            Select option = new Select(select);
            option.selectByVisibleText("Male");
            driver.findElement(By.id("inlineRadio1")).click();
            driver.findElement(By.name("bday")).sendKeys("06121996");
            driver.findElement(By.cssSelector(".btn-success")).click();
            Thread.sleep(3000);
            System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());
            driver.close();


    }
}
