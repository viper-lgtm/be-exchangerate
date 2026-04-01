package cz.martinvedra.beexchangerate.client;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class TestClassForCodeQL {
    public void test() {
        // Vytvoření klienta bez timeoutu (tvůj custom query by to mělo najít)
        OkHttpClient client = new OkHttpClient();

        // Použití klienta, aby zmizelo varování o nepoužité proměnné
        Request request = new Request.Builder()
                .url("https://api.example.com")
                .build();

        try {
            // Jen simulujeme použití, nemusí to reálně nikam volat
            System.out.println("Client created: " + client.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}