package cz.martinvedra.beexchangerate.ai.service;

import cz.martinvedra.beexchangerate.ai.tool.WeatherAssistantSkills;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class MyAgentApp {

    interface Assistant {
//        @SystemMessage({
//                "Jsi robotický asistent. VŽDY a DOSLOVA používej výstupy z nástrojů. Nic si sám nevymýšlej, pokud bude existovat jasná logika pro výstup."
//        })
        String chat(String message);
    }

    public static void main(String[] args) {

        String apiKey = System.getenv("OPENAI_API_KEY");

        OpenAiChatModel model = OpenAiChatModel.builder()
                .apiKey(apiKey)
                .baseUrl("https://api.groq.com/openai/v1")
                .modelName("llama-3.3-70b-versatile")
                .temperature(0.0)
                .build();

        String result = "";
        Path path = Paths.get("agent-rules.md");
        try {
            result = Files.readString(path);
        } catch (Exception e) {
            System.out.println("No rules, will read default");
        }

        Assistant assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .tools(new WeatherAssistantSkills())
                .build();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Napiš něco agentovi:");

        while (true) {
            String userInput = scanner.nextLine();
            String response = assistant.chat(userInput);
            System.out.println("Agent: " + response);
        }
    }
}
