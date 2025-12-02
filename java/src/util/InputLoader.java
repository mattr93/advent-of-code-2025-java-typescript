package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputLoader {
    public static String read(String path) {
        try {
            String result = new String(Files.readAllBytes(Paths.get(path)));
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input: " + path, e);
        }
    }
}
