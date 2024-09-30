import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

    public static void main(String[] args) {
        // Declara metoda principală, care este punctul de intrare al programului.

        ChromeOptions options = new ChromeOptions();
        // Crează o instanță de ChromeOptions, care va conține opțiunile pentru
        // configurarea browserului Chrome.

        Proxy proxy = new Proxy();
        // Crează o instanță de Proxy, care va fi folosită pentru a defini setările de
        // proxy pentru browser.

        proxy.setHttpProxy("ipaddress:4444");
        // Configurează proxy-ul HTTP cu adresa IP și portul specificate (înlocuiește
        // "ipaddress" cu o adresă reală).

        options.setCapability("proxy", proxy);
        // Adaugă setările de proxy la opțiunile browserului, astfel încât Chrome să
        // utilizeze proxy-ul definit.

        Map<String, Object> prefs = new HashMap<String, Object>();
        // Creează un obiect Map pentru a stoca preferințele de configurare ale
        // browserului.

        prefs.put("download.default_directory", "/directory/path");
        // Setează directorul implicit pentru descărcări la calea specificată
        // (treb de inlocuit cu un director real).

        options.setExperimentalOption("prefs", prefs);
        // Adaugă preferințele de descărcare la opțiunile browserului.

        options.setAcceptInsecureCerts(true);
        // Permite browserului să accepte certificatele de securitate nesigure, cum ar fi cele expirate.

        System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
        // Setează proprietatea sistemului pentru a specifica calea către executabilul ChromeDriver.

        WebDriver driver = new ChromeDriver(options);
        // Creează o instanță de ChromeDriver, folosind opțiunile specificate anterior pentru a lansa browserul.

        driver.get("https://expired.badssl.com/");
        // Accesează un site web cu un certificat SSL expirat pentru a testa comportamentul browserului.

        System.out.println(driver.getTitle());
        // Afișează titlul paginii curente în consolă.
    }

}