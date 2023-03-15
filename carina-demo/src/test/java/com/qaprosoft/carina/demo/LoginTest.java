package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObjects;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest implements IAbstractTest {

    //  https://the-internet.herokuapp.com/login
    PageObjects pageObjects = null;

    @BeforeSuite
    public void startDriver() {
        pageObjects = new PageObjects(getDriver());
    }

    @Test
    public void testOpenPage() {
        pageObjects.open();
        pageObjects.typeUserName("tomsmith");
        pageObjects.typePassword("SuperSecretPassword!");
        pageObjects.clickSubmitButton();
    }

}
