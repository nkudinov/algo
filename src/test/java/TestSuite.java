import c1.q1;
import c1.q2;
import c1.q3;
import c1.q4;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSuite {
    @Test
    void q1Test() {
        assertTrue(q1.isAllUnique5("123"));
        assertTrue(q1.isAllUnique5("world"));
        assertTrue(q1.isAllUnique5("h"));
        assertTrue(q1.isAllUnique5(""));

        assertFalse(q1.isAllUnique5("hello world"));
        assertFalse(q1.isAllUnique5("hh"));
        assertFalse(q1.isAllUnique5("opo"));
    }

    @Test
    void q2Test() {
       assertTrue(Arrays.equals(q2.reverse3(new char[]{'a'}),new char[]{'a'}));
       assertTrue(Arrays.equals(q2.reverse3(new char[]{'a','b'}),new char[]{'b','a'}));
       assertTrue(Arrays.equals(q2.reverse3(new char[]{'a','b','c'}),new char[]{'c','b','a'}));

    }
    @Test
    void q3Test() {
        assertTrue(q3.isPermutation1("abc","acb"));
        assertTrue(q3.isPermutation1("helloworld","worldhello"));
        assertTrue(q3.isPermutation1("a","a"));

        assertFalse(q3.isPermutation1("a","b"));
    }
    @Test
    void q4Test() {
        assertTrue(Arrays.equals(q4.replaceBlanks(new char[]{'a'}),new char[]{'a'}));
        assertTrue(Arrays.equals(q4.replaceBlanks(new char[]{'a',' '}),new char[]{'a','%','2','0'}));
        assertTrue(Arrays.equals(q4.replaceBlanks(new char[]{' ','b','c'}),new char[]{'%','2','0','b','c'}));

    }

}
