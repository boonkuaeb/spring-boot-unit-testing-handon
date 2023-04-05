package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;


//@DisplayNameGeneration(CustomDisplayName.ReplaceCamelCase.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setUpBeforeEach() {
        // set up
        demoUtils = new DemoUtils();
        System.out.println("@BeforeEach executes before the execution of each method");
    }

    @AfterEach
    void setUpAfterEach() {
        System.out.println("Running @AfterEach\n");
    }

    @BeforeAll
    static void setUpBeforeAll() {
        System.out.println("@BeforeAll executes only one before all test methods executions in the class\n");
    }

    @AfterAll
    static void setUpAfterAll() {
        System.out.println("@AfterAll executes only one after all test methods executions in the class\n");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    void testEqualsAndNotEquals() {

        // execute and assert
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
   @DisplayName("Null and Not null")
    void testNullAndNotNull() {

        String str1 = null;
        String str2 = "boonkuaeB";

        // execute and assert
        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }

    @Test
    @DisplayName("Same Not Not Same")
    void testSameAndNotSame() {
        String str = "Luv2Code Academy 222W";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to same object");
        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("True and False")
    void testTrueFalse() {
        int one = 10;
        int five = 5;
        assertTrue(demoUtils.isGreater(one, five), "This should return true");
        assertFalse(demoUtils.isGreater(five, one), "This should return false");

    }


}