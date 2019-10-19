import c1.q1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSuite {
    @DisplayName("test isAllUnique")
    @Test
    void c1Test() {

        assertTrue(q1.isAllUnique3("123"));
        assertTrue(q1.isAllUnique3("world"));
        assertTrue(q1.isAllUnique3("h"));
        assertTrue(q1.isAllUnique3(""));

        assertFalse(q1.isAllUnique3("hello world"));
        assertFalse(q1.isAllUnique3("hh"));
        assertFalse(q1.isAllUnique3("opo"));

    }
}
