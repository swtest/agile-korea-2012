package kr.co.swtest.agilekorea2012.tdd.example01;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitLifeCycleTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
    }

    @Before
    public void before() {
        System.out.println("  @Before");
    }

    @After
    public void after() {
        System.out.println("  @After");
    }

    @Test
    public void testMethod1() {
        System.out.println("    testMethod1");
    }

    @Test
    public void testMethod2() {
        System.out.println("    testMethod2");
    }

}
