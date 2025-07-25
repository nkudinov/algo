import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FlameParser {
    public static void main(String[] args) {

        String filePath = "/Users/nkudinov/work/flamegraph/flamegraph.html"; // Replace with the actual path to your file
        Set<String> threads = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("tid")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < line.length(); i++) {
                        if (line.charAt(i) == '[') {
                            stringBuilder.append(line.charAt(i));
                        } else if (line.charAt(i) == ']') {
                            break;

                        } else if (!stringBuilder.isEmpty()) {
                            stringBuilder.append(line.charAt(i));
                        }
                    }
                    threads.add(stringBuilder.toString());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace(); // For debugging purposes
        }
        for(String thread : threads) {
            System.out.println(thread);
        }

    }
}
