package com.seleniumudemy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(200); // numărul de thread-uri

        for (int i = 0; i < 200; i++) {
            executor.submit(() -> {
                try {
                    String url = "http://crm-dash/login"; // URL-ul de test
                    HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
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