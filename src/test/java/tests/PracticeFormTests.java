package tests;

import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {
    @Test
    public void practiceFormPositiveTest(){
        Student student = new Student("Petya","Petrov",
                "petyapetrov@gmail.com", "Male",
                "0123456789", "12 May 2002",
                "Maths,Chemistry,Commerce", "Sports",""
                ,"street 1", "NCR", "Delhi");
        new HomePage((getDriver())).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
    }
}
