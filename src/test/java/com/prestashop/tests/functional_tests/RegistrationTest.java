package com.prestashop.tests.functional_tests;

import com.prestashop.basics.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.sun.javafx.scene.control.skin.FXVK.Type.EMAIL;

public class RegistrationTest extends TestBase {

    @Test
    public void  positiveLogin() {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }
}