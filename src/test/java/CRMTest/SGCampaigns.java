package CRMTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class SGCampaigns {
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
            // Obține input-urile pentru intervalul de date
            List<WebElement> dateRangeInputs = driver.findElements(By.cssSelector("#google-accounts-list-filter-" + randomFilterName + " .js-flatpickr.date-range-input"));

            // Dacă există checkbox-uri, selectează 3 aleatorii
            if (!checkboxes.isEmpty()) {
                Random checkboxRandom = new Random();
                for (int j = 0; j < 3 && j < checkboxes.size(); j++) {
                    int randomCheckboxIndex = checkboxRandom.nextInt(checkboxes.size());
                    WebElement checkbox = checkboxes.get(randomCheckboxIndex);
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].click();", checkbox);
                    Thread.sleep(2000);
                    System.out.println("Checkbox clicked with value: " + checkbox.getAttribute("value"));
                }
            } 
            // Dacă nu există checkbox-uri, verifică input-urile pentru intervalul de date
            else if (!dateRangeInputs.isEmpty()) {
                System.out.println("Se selectează interval de date.");
                // Click pe input pentru a deschide calendarul
                WebElement dateRangeInput = dateRangeInputs.get(0); // Selectează primul input
                Thread.sleep(1000);

                // Așteaptă ca calendarul să fie vizibil
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                driver.findElement(By.cssSelector(".js-flatpickr.date-range-input[placeholder='"+dateRangeInput+"']")).click();

                // Navighează cu 4 luni înapoi
                WebElement prevMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.flatpickr-calendar.open span.flatpickr-prev-month")));
                for (int k = 0; k < 4; k++) {
                    prevMonth.click();
                }
                Thread.sleep(2000);

                // Selectează ziua 13 din calendar
                driver.findElement(By.xpath("//div[contains(@class, 'flatpickr-calendar') and contains(@class, 'open')]//span[text()='13']")).click();
            }

            // Închide filtrul curent
            driver.findElement(By.cssSelector("div[data-collapse='" + randomFilterName + "']")).click();
            Thread.sleep(2000);
        }

        // După selectarea celor 3 filtre
        driver.findElement(By.id("google-accounts-list_wrapper")).click();
        Thread.sleep(2000);

        // Închide browser-ul
        driver.quit();
    }
}
