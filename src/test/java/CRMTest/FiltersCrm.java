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
    public static void main(String[] args) throws InterruptedException{
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
            driver.findElement(By.cssSelector("div.google-accounts-list-filter-title")).click();
            Thread.sleep(2000); 
            List<WebElement> filterItems = driver.findElements(By.cssSelector(".multiselect-item"));
        
            for (WebElement item : filterItems) {
                String filterName = item.getText();
                System.out.println("Filter Name: " + filterName);
            
                // Elimină spațiile din numele filtrului
                String dataCollapseValue = filterName.replaceAll(" ", "");
            
                // Folosește dataCollapseValue în selectorul CSS
               System.err.println(driver.findElement(By.cssSelector("div[data-collapse='" + dataCollapseValue + "']")));
                Thread.sleep(2000);
            }
            driver.findElement(By.cssSelector("div[data-collapse='AccountOwner']")).click();
       // Extrage checkbox-urile pentru Account Owner
       List<WebElement> checkboxes = driver.findElements(By.cssSelector("#google-accounts-list-filter-AccountOwner .custom-control-input"));
        
       // Lista pentru a stoca valorile
       List<String> values = new ArrayList<>();

       // Parcurge lista de checkbox-uri și extrage valorile
       for (WebElement checkbox : checkboxes) {
           String value = checkbox.getAttribute("value");
           values.add(value); // Adaugă valoarea la listă
           System.out.println("Account Owner: " + value);
       }
       
       // Verifică dacă sunt suficiente valori pentru a selecta 3
       if (values.size() < 3) {
           System.out.println("Nu sunt suficiente valori pentru a selecta 3 checkbox-uri.");
           return; // Ieși din program dacă nu sunt suficiente valori
       }

       // Alege 3 indexuri aleatorii
       Random random = new Random();
       for (int i = 0; i < 3; i++) {
           // Obține un index aleatoriu
           int randomIndex = random.nextInt(values.size());
           String randomValue = values.get(randomIndex);
           Thread.sleep(2000); 
           // Click pe checkbox folosind JavaScript
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("input[value='" + randomValue + "']")));
           Thread.sleep(2000); 
           // Afișează care checkbox a fost click-uit
           System.out.println("Checkbox clicked with value: " + randomValue);
       }
       Thread.sleep(2000); 
       driver.findElement(By.cssSelector("div[data-collapse='AccountOwner']")).click();

       Thread.sleep(2000); 
        driver.findElement(By.id("google-accounts-list_wrapper")).click();
            
        } 
            
    }
