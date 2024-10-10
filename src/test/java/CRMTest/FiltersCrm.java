package CRMTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class FiltersCrm {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("http://crm-dash/login");

        Thread.sleep(2000); 
        driver.findElement(By.id("login-username")).sendKeys("victor.cristea@vebo.io");

        driver.findElement(By.id("login-password")).sendKeys("Morris22##");

        driver.findElement(By.cssSelector("button.btn-alt-primary")).click();
        
        // Navighează la pagina cu filtrul
        driver.get("http://crm-dash/google-accounts");

        // Așteaptă ca filtrul să fie vizibil
        Thread.sleep(2000);
        
        // Click pe secțiunea de filtrare pentru a o extinde
        driver.findElement(By.cssSelector("div.google-accounts-list-filter-title")).click();
        Thread.sleep(2000);
        
        // Obține toate elementele de filtru
        List<WebElement> filterItems = driver.findElements(By.cssSelector(".multiselect-item"));
        
        // Lista care va conține numele filtrelor disponibile
        List<String> filterNames = new ArrayList<>();
        
        for (WebElement item : filterItems) {
            String filterName = item.getText().replaceAll(" ", ""); // Elimină spațiile din nume
            filterNames.add(filterName);
        }
        
        // Verifică dacă există suficiente filtre pentru a selecta 3 random
        if (filterNames.size() < 3) {
            System.out.println("Nu sunt suficiente filtre disponibile pentru a selecta 3.");
            return; // Iese dacă nu sunt suficiente filtre
        }

        // Alege 3 filtre random
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            // Obține un index aleatoriu pentru filtru
            int randomFilterIndex = random.nextInt(filterNames.size());
            String randomFilterName = filterNames.get(randomFilterIndex);
            System.out.println("Filtrul selectat: " + randomFilterName);
            
            // Click pe filtrul aleatoriu
            driver.findElement(By.cssSelector("div[data-collapse='" + randomFilterName + "']")).click();
            Thread.sleep(2000);

            // Obține checkbox-urile pentru filtrul selectat
            List<WebElement> checkboxes = driver.findElements(By.cssSelector("#google-accounts-list-filter-" + randomFilterName + " .custom-control-input"));

            // Lista pentru a stoca valorile din checkbox-uri
            List<String> values = new ArrayList<>();

            // Parcurge checkbox-urile și adaugă valorile lor în lista values
            for (WebElement checkbox : checkboxes) {
                String value = checkbox.getAttribute("value");
                values.add(value);
            }

            // Verifică dacă există suficiente valori pentru a selecta 3
            if (values.size() < 2) {
                System.out.println("Nu sunt suficiente valori în filtru " + randomFilterName);
                driver.findElement(By.cssSelector("div[data-collapse='" + randomFilterName + "']")).click(); // Închide filtrul
                continue; // Treci la următorul filtru dacă nu sunt suficiente valori
            }
                driver.findElement(By.cssSelector("div.flatpickr-calendar.open span.flatpickr-day.today")).click();

                WebElement prevMonth = driver.findElement(By.cssSelector("div.flatpickr-calendar.open span.flatpickr-prev-month"));
                for (int k=0; k<4; k++){
                prevMonth.click();
                }
               Thread.sleep(5000);
               driver.findElement(By.xpath("//div[contains(@class, 'flatpickr-calendar') and contains(@class, 'open')]//span[text()='13']")).click();
 
               driver.findElement(By.id("google-accounts-list_wrapper")).click();

            // Alege 3 valori random și selectează checkbox-urile corespunzătoare
            for (int j = 0; j < 2; j++) {
                int randomValueIndex = random.nextInt(values.size());
                String randomValue = values.get(randomValueIndex);

                // Click pe checkbox-ul corespunzător
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("input[value='" + randomValue + "']")));
                Thread.sleep(2000);

                System.out.println("Checkbox clicked with value: " + randomValue);
            }



            // Închide filtrul curent
            driver.findElement(By.cssSelector("div[data-collapse='" + randomFilterName + "']")).click();
            Thread.sleep(2000);
        }

        // După selectarea celor 3 filtre și checkbox-uri random
        driver.findElement(By.id("google-accounts-list_wrapper")).click();
        Thread.sleep(2000);
    }
}
