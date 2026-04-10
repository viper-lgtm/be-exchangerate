package cz.martinvedra.beexchangerate.ai.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestReadFiles {
    public static void main(String[] args) {
        String result = "";
        Path path = Paths.get("agent-rules.md");

        try {
            result = Files.readString(path);
        } catch (IOException e) {
            System.out.println("No rules found at " + path.toAbsolutePath() + ", using default.");
            result = "default rules content";
        }

        System.out.println(result);
    }
}
