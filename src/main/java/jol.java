import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

import java.time.LocalDate;

public class jol {
    public static void main(String[] args) throws Exception {
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseClass(int[].class).toPrintable());
    }

}
