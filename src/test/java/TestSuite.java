import c1.q1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSuite {
    @DisplayName("test isAllUnique")
    @Test
    void c1Test() {

        assertTrue(q1.isAllUnique1("123"));
        assertTrue(q1.isAllUnique1("world"));
        assertTrue(q1.isAllUnique1("h"));
        assertTrue(q1.isAllUnique1(""));

        assertFalse(q1.isAllUnique1("hello world"));
        assertFalse(q1.isAllUnique1("hh"));
        assertFalse(q1.isAllUnique1("opo"));

    }
}
