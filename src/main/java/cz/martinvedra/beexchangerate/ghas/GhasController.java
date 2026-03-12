package cz.martinvedra.beexchangerate.ghas;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Controller určený pro testování schopností GitHub Advanced Security (GHAS).
 * Tento kód obsahuje záměrné chyby pro studijní účely.
 */
@RestController
@RequestMapping("/api/ghas")
@RequiredArgsConstructor
public class GhasController {

    private final GhasService ghasService;

    @GetMapping("/sql-test")
    public String testSqlInjection(@RequestParam String name) {
        // Tady začíná cesta nákazy (Source)
        ghasService.sqlInjectionExample(name);
        return "SQL dotaz s parametrem '" + name + "' byl odeslán ke zpracování.";
    }

    @GetMapping("/security-test")
    public String testSecurityFlow(@RequestParam boolean isReady) {
        // Testování logických chyb (Sonar) a úniku informací (CodeQL)
        ghasService.booleanSmellTest(isReady);
        ghasService.databaseTest();
        return "Bezpečnostní testy spuštěny. Zkontroluj konzoli a GitHub Security tab.";
    }
}
