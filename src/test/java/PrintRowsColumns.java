import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class PrintRowsColumns {

    public static void main(String[] args) throws InterruptedException {

        // Print Rows, Columns and Second Row content

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,450)");
        Thread.sleep(2000);

        List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
        List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
        List<WebElement> secondRow = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));

        for (int i = 0; i < columns.size(); i++) {
            String header = columns.get(i).getText();
            String content = (i < secondRow.size()) ? secondRow.get(i).getText() : "";
            System.out.println(header + " -> " + content);
        }
        int totalRows = rows.size();
        int totalColumns = columns.size();

        System.out.println("Total Rows: " + totalRows);
        System.out.println("Total Columns: " + totalColumns);

    }
}
