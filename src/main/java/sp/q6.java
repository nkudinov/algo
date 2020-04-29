package sp;

import java.time.LocalDate;
import java.util.Locale;

public class q6 {

    public static void main(String[] args) {
       LocalDate ld = LocalDate.of(2020,12,1);
        System.out.println(ld.getYear()*100 +ld.getMonthValue());
    }

}
