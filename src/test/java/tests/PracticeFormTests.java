package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void practiceFormPositiveTest(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);
        Student student = new Student("Petya","Petrov",
                "petyapetrov@gmail.com", Gender.MALE,
                "0123456789", "12 May 2002",
                "Maths,Chemistry,Commerce",hobbies,""
                ,"street 1", StateCity.RAJASTHAN.getState(),
                StateCity.RAJASTHAN.getCity()[0]);
        new HomePage((getDriver())).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
//        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative());
        System.out.println("test failed!");
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(),
                "test passed");
    }

    @Test
    public void practiceFormPositiveTestWithSoftAssert(){
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);
        Student student = new Student("Petya","Petrov",
                "petyapetrov@gmail.com", Gender.MALE,
                "0123456789", "12 May 2002",
                "Maths,Chemistry,Commerce",hobbies,""
                ,"street 1", StateCity.RAJASTHAN.getState(),
                StateCity.RAJASTHAN.getCity()[0]);
        new HomePage((getDriver())).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
//        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative(),
//                "validate modalNegative Message");
        System.out.println("test failed!");
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(),
                "validate Modal Message");
        System.out.println("test passed");
        softAssert.assertTrue(getDriver().findElement(By
                .xpath("//tbody/tr/td[last()]"))
                .getText().contains(student.getLastName()), "validate last name");
        softAssert.assertTrue(getDriver().findElement(By
                        .xpath("//tbody/tr/td[last()]"))
                .getText().contains(student.getFirstName()), "validate first name");
        softAssert.assertAll();
    }
}
