import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import java.util.Date;

public class CaptureBrowserConsoleLogs {
    public static void main(String[] args)throws InterruptedException{
        // Configurarea ChromeOptions pentru a activa logarea
          // Inițializarea driver-ului cu ChromeOptions
          WebDriver driver = new ChromeDriver();
        // Navighează la o pagină
        driver.get("http://crm-dash/login"); // Schimbă cu URL-ul dorit

        Thread.sleep(4000);
        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");

        driver.findElement(By.id("login-password")).sendKeys("j8L3pc5hJ20Sjn10Lp!");

        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();

        Thread.sleep(4000);

        LogEntries logEntries = driver.manage().logs().get("browser");

        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            String errorLogType= entry.getLevel().toString();
            String errorLog= entry.getMessage().toString();
            if(errorLog.contains("404")){
            System.out.println("Error LogType: "+ errorLogType+" Error Log message: "+errorLog); 
            } 
            }

    }
}


