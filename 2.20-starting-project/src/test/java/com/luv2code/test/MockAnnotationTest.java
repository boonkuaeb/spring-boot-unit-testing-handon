package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;
    // #### Set up part
    // 1. Create Mock for DAO
    @Mock
    private ApplicationDao applicationDao;

    // #### Set up part
    // 2. Inject mock in Service
    @InjectMocks
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

}

























