package com.luv2code.junitdemo;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;


import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@DisplayNameGeneration(CustomDisplayName.ReplaceCamelCase.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setUpBeforeEach() {
        // set up
        demoUtils = new DemoUtils();
//        System.out.println("@BeforeEach executes before the execution of each method");
    }

    @AfterEach
    void setUpAfterEach() {
//        System.out.println("Running @AfterEach\n");
    }

    @BeforeAll
    static void setUpBeforeAll() {
//        System.out.println("@BeforeAll executes only one before all test methods executions in the class\n");
    }

    @AfterAll
    static void setUpAfterAll() {
//        System.out.println("@AfterAll executes only one after all test methods executions in the class\n");
    }

    @Test
    @DisplayName("Equals and Not Equals")
    @Order(3)
    void testEqualsAndNotEquals() {

        // execute and assert
        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");

    }

    @Test
    @DisplayName("Multiply")
    void testMultiply()
    {
        assertEquals(4,demoUtils.multiply(2,2),"2x4 must be 4");

    }

    @Test
   @DisplayName("Null and Not null")
    @Order(1)
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

    @DisplayName("Array Equals")
    @Test
    void testArrayEquals()
    {
        String[] stringArray = {"A","B","C"};
        assertArrayEquals(stringArray,demoUtils.getFirstThreeLettersOfAlphabet(),"Arrays should be the same");
    }

    @DisplayName("Iterable equals")
    @Test
    void testIterableEquals()
    {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(theList,demoUtils.getAcademyInList(),"Expected list should be same as actual list");
    }

    @DisplayName("Lines match")
    @Test
    void testLinesMatch()
    {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(theList,demoUtils.getAcademyInList(),"Lines should match");
    }

    @DisplayName("Throws and Does not Throws")
    @Test
    @Order(-1)
    void testThrowsAndDoesNotThrows()
    {
        // Use Lamda expression
        assertThrows(Exception.class,()->{demoUtils.throwException(-1);},"Should throw exception");
        assertDoesNotThrow(()->demoUtils.throwException(1),"Should not throw exeception");
    }


    @DisplayName("Timeout")
    @Test
    @Order(10)
    void testTimeout()
    {
        assertTimeoutPreemptively(Duration.ofMillis(3000),()->{demoUtils.checkTimeout();},"Method should execute in 3000 milliseconds");
    }

    @DisplayName("For Mac Only")
    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly()
    {
        assertEquals("a","a");
    }

    @DisplayName("For Windows Only")
    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowOnly()
    {
        assertEquals("a","a");
    }

    @DisplayName("For Windows And MAC")
    @Test
    @EnabledOnOs({OS.WINDOWS,OS.MAC})
    void testForWindowAndMac()
    {
        assertEquals("a","a");
    }


    @DisplayName("For JAVA 17 Only")
    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testForJava17Only()
    {
        assertEquals("a","a");
    }

    @DisplayName("For JAVA 17,11 Only")
    @Test
    @EnabledOnJre({JRE.JAVA_17,JRE.JAVA_11})
    void testForJava17And11()
    {
        assertEquals("a","a");
    }


    @DisplayName("For JAVA 11 Only")
    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testForJava11()
    {
        assertEquals("a","a");
    }


    @DisplayName("From JAVA 8 to 16")
    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_16)
    void testForJreRange8To16()
    {
        assertEquals("a","a");
    }

    @DisplayName("From JAVA 11 to 18")
    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_18)
    void testForJreRange11To18()
    {
        assertEquals("a","a");
    }


    @Test
    @DisplayName("Disable This Test")
    @Disabled
    void testDisable()
        {

        }
}