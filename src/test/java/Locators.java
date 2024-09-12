import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        // Declaram driverul
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Accesez url-ul cu pagina unde vreau sa testez
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        // Caut elementul cu care vreau sa interactionez in acest caz este inputul
        // username
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");

        // Caut elementul care este inputul password si introduc datele mele in el
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");

        // Click sing in button
        driver.findElement(By.className("signInBtn")).click();

        // Construct CSSselector.
        // In cazul in care inputul are id -> tagname#id -> input#inputUsername
        // In cauzl in care nu este id -> Tagname[attribute='value'] ->
        // input[placeholder='Username']

        // implicit wait -
        // Localizeaza error textul dupa locatorul csssSelector
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        // Linktext locator exemplu
        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(2000);

        // Xpath locator example
        // pentru a crea un locator xpath se foloseste urmatoarea sintaxa =>
        // //tagname[@attribute='value'] => //input[@placeholder='Username']

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Test");

        // Exemplu de cssSelector, se formeaza exact ca acel xpath de mai sus
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

        // Aici am luat xpath-ul care este caracteristic pentru mai multe elemente si
        // l-am localizat pe cel necesar mie prin [2]
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

        // La ca in cazul de mai sus doar ca de data asta cu cssSelector
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

        // Locator xppath format din parinte si copil in cazul de fata parintele este
        // forma si copilul este input parenttag/child
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("+225200");

        // Locator pentru a apasa pe buttonul reset dupa clasa pe care o are
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        // cssSelector construit dupa modelul xpath parinte si child
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        // Select go to login button
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        Thread.sleep(2000);

        // Asa se foloseste un cssSelector in care localizam dupa id
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

        // Asa se foloseste un cssSelector in care localizam dupa partial link text.
        // Practic, selenium scaneaza prin toate elementele care au type si cauta
        // cuvantul pass
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.id("chkboxOne")).click();

        // regular expression by xpath, aici cheia expresiei este cuvantul contains,
        // in interiorul caruia ii dam atribuntul dupa care vrem sa cautam in cazul de
        // fata este class submit
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

        Thread.sleep(2000);

        System.out.println(driver.findElement(By.cssSelector("div p")).getText());

    }
}
