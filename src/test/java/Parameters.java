import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
 public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://crm-dash/login");

        Thread.sleep(2000);
        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");
        driver.findElement(By.id("login-password")).sendKeys("Morris22##");
        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();

        // Navighează la pagina cu filtrul
        driver.get("http://crm-dash/google-dashboard/sg-campaigns");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".phpdebugbar-close-btn")).click();

      // get title
      String title = driver.getTitle();
   
      // get current url
      String url = driver.getCurrentUrl();

      String currentUrl = driver.getCurrentUrl();
            System.out.println("URL curent: " + currentUrl);

            // Extrage partea de interes din URL
            String[] urlParts = currentUrl.split("/"); // separă URL-ul în părți
            String locator = urlParts[urlParts.length - 1]; // obține ultima parte

      System.out.println("Locator extras: " + locator);
      System.out.println(title);
      System.out.println(url);
}
}