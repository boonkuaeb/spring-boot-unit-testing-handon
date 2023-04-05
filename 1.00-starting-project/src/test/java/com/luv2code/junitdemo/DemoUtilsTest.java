package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setUpBeforeEach()
    {
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each method");
    }

    @AfterEach
    void setUpAfterEach()
    {
        System.out.println("Running @AfterEach\n");
    }

    @BeforeAll
    static void setUpBeforeAll()
    {
        System.out.println("@BeforeAll executes only one before all test methods executions in the class\n");
    }

    @AfterAll
    static void setUpAfterAll()
    {
        System.out.println("@AfterAll executes only one after all test methods executions in the class\n");
    }
    @Test
    void testEqualsAndNotEquals() {

        System.out.println("Running testEqualsAndNotEquals");

        // assert
        assertEquals(6, demoUtils.add(2, 4),"2+4 must be 6");
        assertNotEquals(6,demoUtils.add(1,9),"1+9 must not be 6");
    }

    @Test
    void testNullAndNotNull() {
        System.out.println("Running testNullAndNotNull");

        String str1 = null;
        String str2 = "boonkuaeB";

        // Assert
        assertNull(demoUtils.checkNull(str1),"Object should be null");
        assertNotNull(demoUtils.checkNull(str2),"Object should not be null");
    }
}