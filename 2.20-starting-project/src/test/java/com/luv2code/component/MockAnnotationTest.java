package com.luv2code.component;

import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    // ##################################
    // ###### This block of code Replace by @MockBean
    //    // ## Set up part
    //    // 1. Create Mock for DAO
    //    @Mock
    //    private ApplicationDao applicationDao;
    //
    //    // #### Set up part
    //    // 2. Inject mock in Service
    //    @InjectMocks
    //    private ApplicationService applicationService;
    //    // ##################################


    @MockBean
    private ApplicationDao applicationDao;

    @Autowired
    private ApplicationService applicationService;

    // Set up part
    @BeforeEach
    public void beforeEach()
    {
        studentOne.setFirstname("BK");
        studentOne.setLastname("BST");
        studentOne.setEmailAddress("bk@bst.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When and Verify")
    @Test
    public void assertEqualsTestAddGrades()
    {
        // #### Set up part
        // Assign return value when call Mock
        when(applicationDao.addGradeResultsForSingleClass(
                             studentGrades.getMathGradeResults()))
            .thenReturn(100.00);

        // 3. 100 value is Set up expectations
        // 4. Call Method under test and assert result
        assertEquals(100,applicationService.addGradeResultsForSingleClass(
                                    studentOne.getStudentGrades().getMathGradeResults()),"Add grade results for single class must be 100");

        // 5 Verify method calls
        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
        verify(applicationDao,times(1)).addGradeResultsForSingleClass(
                                                                    studentGrades.getMathGradeResults());
    }


    @DisplayName("Find Gpa")
    @Test
    public void assertEqualsTestFindGpa()
    {
        when(applicationDao.findGradePointAverage(studentGrades.getMathGradeResults()))
                .thenReturn(88.31);

        assertEquals(88.31, applicationService.findGradePointAverage(
                                                            studentOne.getStudentGrades().getMathGradeResults()));

        verify(applicationDao,times(1)).findGradePointAverage(
                studentGrades.getMathGradeResults());
    }

    @DisplayName("Not Null")
    @Test
    public void testAssertNotNull()
    {
        when(applicationDao.checkNull(studentGrades.getMathGradeResults()))
                .thenReturn(true);

        assertNotNull(applicationService.checkNull(
                                          studentOne.getStudentGrades().getMathGradeResults()),
                "Object should not be null");

        verify(applicationDao,times(1)).checkNull(
                studentGrades.getMathGradeResults());
    }


    @DisplayName("Throw runtime error")
    @Test
    public void throwRuntimeError()
    {
        CollegeStudent nullStudent = (CollegeStudent)  context.getBean("collegeStudent");

        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullStudent);

        assertThrows(RuntimeException.class,()->{
            applicationService.checkNull(nullStudent);
        });
        verify(applicationDao,times(1)).checkNull(nullStudent);

    }

    @DisplayName("Multiple Stubbing")
    @Test
    public void stubbingConsecutiveCalls()
    {
        CollegeStudent nullStudent = (CollegeStudent)  context.getBean("collegeStudent");

        when(applicationDao.checkNull(nullStudent))
                .thenThrow(new RuntimeException())
                .thenReturn("Do not throw exception second time");

        assertThrows(RuntimeException.class,()->{
            applicationService.checkNull(nullStudent);
        });

        assertEquals("Do not throw exception second time",applicationService.checkNull(nullStudent));
        verify(applicationDao,times(2)).checkNull(nullStudent);
    }


}

























