import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compare {

    static List<String> readFile(String path) throws IOException {
        return Files.lines(Path.of(path)).toList();
    }

    public static void main(String[] args) throws IOException {
        String nCodes = "N1051905\n" +
                "N3025345\n" +
                "N3025601\n" +
                "N1050683\n" +
                "N3021307\n" +
                "N3026296\n" +
                "N1052575\n" +
                "N3023218\n" +
                "N3029359\n" +
                "N3024938\n" +
                "N3012705\n" +
                "N3026009\n" +
                "N3022304\n" +
                "N1046507\n" +
                "N3027514\n" +
                "N1053683\n" +
                "N3025990\n" +
                "N3022526\n" +
                "N3022055\n" +
                "N3019461\n" +
                "N3022082\n" +
                "N1050548\n" +
                "N3022867\n" +
                "N3025689\n" +
                "N1047647\n" +
                "N3020027\n" +
                "N3020879\n" +
                "N1046210";
        String[] nCodesArr = nCodes.split("\n");
        System.out.println(nCodesArr.length);

        List<String> sp = readFile("/Users/nkudinov/work/dsa/sp/sp_data.csv");
        List<String> sb = readFile("/Users/nkudinov/work/dsa/sb/sb_data.csv");
        List<String> all = new ArrayList<>(sp);
        all.addAll(sb);

        for(String nCode : nCodesArr) {
            boolean found = false;
            for(String str : all) {
                if (str.contains(nCode)) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                System.out.println(nCode + " not found");
            }
        }
    }
}
