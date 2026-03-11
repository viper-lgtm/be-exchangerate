package cz.martinvedra.beexchangerate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.DriverManager;

@Component
@RequiredArgsConstructor
public class TestingGHAS {

    // Hardcoded heslo
    private static final String DB_PASSWORD = "0000";

    public void databaseTest() {
        try {
            DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "sa", DB_PASSWORD);
        } catch (Exception e) {
            // Information exposure
            e.printStackTrace();
        }
    }

    public void booleanSmellTest(boolean isReady) {
        // Boolean smell
        if (isReady == true) {
            System.out.println("Je připraveno!");
        }
    }

    public void sqlInjectionExample(String input) {
        // SQL Injection
        String query = "SELECT * FROM users WHERE name = '" + input + "'";
        System.out.println("Spouštím dotaz: " + query);
        System.out.println("Výsledek dotazu: ...");
    }
}