import java.util.Arrays;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCard {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*
         * implicitlyWait seteaza timul global
         * Lucreaza in felul urmator: daca elementul pe pagina nu este gasint,
         * selenium asteapta cateva secunde in acest caz 10 si daca in aceste secunde
         * elementul nu apare,
         * selenium face fail la test
         */
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String[] itemsNeeded = { "Cucumber", "Cauliflower", "Brocolli", "Beetroot", "Carrot", "Tomato", "Beans" };

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacedemy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();

        /*
         * ExplictiWait se foloseste exact ca espresia de mai jos si anume:
         * Declaram o variabila, in cazul de fata este wait.
         * Dupa asta folosim expresia new WebDriverWait(driver, Duration.ofSeconds(10))
         * pentru a seta timpul de asteptare pentru pasul care urmeaza
         * Folosim variabila wait pentru a construi locatorul care vrem, iar el autmat
         * va astepta
         */

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded)

    {
        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++)

        {
            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName))

            {
                j++;

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length)

                {
                    break;
                }
            }
        }
    }
}
