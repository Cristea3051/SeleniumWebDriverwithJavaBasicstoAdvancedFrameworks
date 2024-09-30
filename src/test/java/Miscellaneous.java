import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class Miscellaneous {

    public static void main(String[] args) throws IOException{
        
        WebDriver driver = new ChromeDriver();

        // Face tabul sa fie aratat in fullscreen
        driver.manage().window().maximize();
        // Sterge toate cookies
        driver.manage().deleteAllCookies();
        // Sterge doar un cookie anume cel care este indicat in name
        // driver.manage().deleteCookieNamed("sessionKey");

        driver.get("https://google.com");

        // Ca sa folosesc asta treb de bagat in pom.xml pachetul cela
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/home/victorcristea/Downloads/screen.png"));
        driver.quit();
    }
}
