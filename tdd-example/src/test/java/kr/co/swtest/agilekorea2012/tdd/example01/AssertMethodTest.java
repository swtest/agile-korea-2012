package kr.co.swtest.agilekorea2012.tdd.example01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AssertMethodTest {

    @Test
    public void assertTrueTest() {
        assertTrue(true);
    }

    @Test
    public void assertFalseTest() {
        assertFalse(false);
    }

    @Test
    public void assertNotNullTest() {
        assertNotNull(new Object());
    }

    @Test
    public void assertNullTest() {
        assertNull(null);
    }

    @Test
    public void assertEqualsTest_case1() {
        assertEquals(12L, 12L);
    }

    @Test
    public void assertEqualsTest_case2() {
        assertEquals(new Long(12), new Long(12));
    }

    @Test
    public void assertEqualsTest_case3() {
        assertEquals("Capacity", 12.0, 11.99, 0.1);
    }

    @Test
    public void assertEqualsTest_case4() {
        assertEquals((Object) null, (Object) null);
    }

    @Test
    public void assertEqualsTest_case5() {
        assertEquals("a", "a");
    }

    @Test
    public void assertSameTest_case1() {
        assertSame(12, 12);
    }

    @Test
    public void assertSameTest_case2() {
        assertSame(12L, 12L);
    }

    @Test
    public void assertSameTest_case3() {
        assertSame(new Long(12), new Long(12)); // fail
    }

    @Test
    public void assertSameTest_case4() {
        assertSame(12.0, 11.99); // fail
    }

    @Test
    public void assertSameTest_case5() {
        assertSame((Object) null, (Object) null); // success
    }

    @Test
    public void assertSameTest_case6() {
        assertSame("a", new String("a")); // fail
    }

    @Test
    public void assertSameTest_case7() {
        String a = "a";
        String b = a;
        assertSame(a, b); // success
    }

}
