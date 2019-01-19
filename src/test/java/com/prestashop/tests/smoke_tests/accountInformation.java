package com.prestashop.tests.smoke_tests;

import com.prestashop.basics.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class accountInformation extends TestBase {
    // Login: my account
    // 1.Go to http://automationpractice.com/index.php
    String fullNameOnTop;


    @Test

    public void Login1() throws InterruptedException {
        //use it for accountInformation test
        // 2.Click Signin link
        driver.findElement(By.linkText("Sign in")).click();

        // 3.Login using valid username and password
        driver.findElement(By.id("email")).sendKeys("mainb@mail.ru");
        driver.findElement(By.id("passwd")).sendKeys("Password1");
        driver.findElement(By.id("SubmitLogin")).click();
        String fullNameOnTop = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
        System.out.println(fullNameOnTop);
        // 4.Verify that titlecontainsMy account
        String expectedTitle = "My account";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 5.Verify that account holder full name is displayed next to the Sign out link
        String name = "Baha Maxic";
        Assert.assertEquals(name, fullNameOnTop);


        // Login: My personal information


        // 6.Click on My personal information button
        driver.findElement(By.xpath("//a[@title='Information']/span")).click();

        // 7.Verify title contains Identity
        String expectedIdentity = "Identity";
        String actualIdentity = driver.getTitle();
        System.out.println(actualIdentity);
        Assert.assertTrue(actualIdentity.contains(expectedIdentity));

        // 8.Verify that first name and last name matches the full name on top

        String firstName = driver.findElement(By.id("firstname")).getAttribute("value");
        String lastName = driver.findElement(By.id("lastname")).getAttribute("value");
        String expectedFullName = firstName + " " + lastName;


        Assert.assertEquals(fullNameOnTop, expectedFullName);

        // 9.Click on Save button

        driver.findElement(By.name("submitIdentity")).click();

        // 10.Verify error message “The password you entered is incorrect.”
        String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ol/li")).getText();
        String expecterMessage = "The password you entered is incorrect.";
        Assert.assertEquals(errorMessage, expecterMessage);


        // 11.Click onBack to your account
        driver.findElement(By.linkText("Back to your account")).click();

        // 12.Verify that title contains My account
        String expectedTitle3 = "My account";
        String actualTitle3 = driver.getTitle();
        Assert.assertTrue(actualTitle3.contains(expectedTitle3));

        // Login: My addresses
        // 13.Click on My addresses
        driver.findElement(By.xpath("//a[@title='Addresses']")).click();

        // 14.Click on Add a new address
        driver.findElement(By.xpath("//a[@title='Add an address']")).click();


        // 15.Verify that first name and last name matches the full name on top
        String firstName2 = driver.findElement(By.id("firstname")).getAttribute("value");
        String lastName2 = driver.findElement(By.id("lastname")).getAttribute("value");
        String expectedFullName2 = firstName2 + " " + lastName2;
        Assert.assertEquals(expectedFullName2, fullNameOnTop);

        // 16.Delete the first name
        driver.findElement(By.id("firstname")).clear();

        // 17.Click save
        driver.findElement(By.id("submitAddress")).click();

        // 18.Verify error message “firstname is required.”
        Thread.sleep(2000);
        String actualMessage = driver.findElement(By.xpath("//*[@id='center_column']/div/div/ol/li[1]")).getText();
        String expectedMessage = "firstname is required.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
