import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        var yes = list.stream().noneMatch(x->!x.contains("x"));
        System.out.println(yes);
    }
}
