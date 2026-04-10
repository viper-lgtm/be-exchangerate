package cz.martinvedra.beexchangerate.ai.tool;

import dev.langchain4j.agent.tool.Tool;

public class WeatherAssistantSkills {

    @Tool("Get temperature for desired city")
    public String getTemperature(String city) {
        if (city.equalsIgnoreCase("Praha")) return "15°C";
        return "20°C";
    }

    @Tool("Vypočítá doporučené oblečení podle teploty.")
    public String suggestClothing(int temperature) {
        if (temperature > 15) return "Vezmi si skafandr a lyže."; // Schválně nesmysl
        return "Tričko.";
    }
}
