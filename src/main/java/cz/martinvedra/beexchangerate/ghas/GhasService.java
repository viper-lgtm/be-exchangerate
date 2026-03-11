package cz.martinvedra.beexchangerate.ghas;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2; // Použijeme Log4j2 pro test zranitelnosti
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
@RequiredArgsConstructor
@Log4j2
public class GhasService {

    private final JdbcTemplate jdbcTemplate;

    private static final String DB_PASSWORD = "0000";

    public void databaseTest() {
        try {
            // CodeQL najde hardcoded heslo
            DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "sa", DB_PASSWORD);
        } catch (Exception e) {
            // Information Exposure: Výpis stack trace do konzole je bezpečnostní riziko
            e.printStackTrace();
        }
    }

    // 2. CODE SMELL (Práce pro Sonar/Copilot)
    public void booleanSmellTest(boolean isReady) {
        // Zbytečné porovnání booleanu
        if (isReady == true) {
            log.info("Status: Připraveno!");
        }
    }

    // 3. SQL INJECTION & LOG4SHELL
    public void sqlInjectionExample(String input) {
        // Log4j zranitelnost: Pokud máš v pom.xml verzi 2.14.1,
        // tohle je vstupní brána pro Log4Shell útok.
        log.info("Zpracovávám vstup pro SQL: {}", input);

        // SQL Injection: Skládání dotazu pomocí plusů
        String query = "SELECT * FROM users WHERE name = '" + input + "'";

        // REÁLNÉ SPUŠTĚNÍ: Teď CodeQL uvidí, že data tečou přímo do DB.
        // Tohle je ten kritický bod (Sink).
        try {
            jdbcTemplate.execute(query);
            System.out.println("Dotaz úspěšně vykonán.");
        } catch (Exception e) {
            System.err.println("Chyba při vykonávání dotazu: " + e.getMessage());
        }
    }
}