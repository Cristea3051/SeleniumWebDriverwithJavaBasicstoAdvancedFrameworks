package CRMTest;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SendHttpRequestToCrm {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(200); // numărul de thread-uri

        for (int i = 0; i < 200; i++) {
            executor.submit(() -> {
                try {
                    String urlString = "http://crm-dash/login"; // URL-ul de test
                    URI uri = URI.create(urlString); // Creează URI
                    URL url = uri.toURL(); // Convertește URI în URL

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");

                    // Obținem și afișăm doar codul de răspuns
                    int responseCode = conn.getResponseCode();
                    System.out.println("URL: " + url + " | Status Code: " + responseCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}