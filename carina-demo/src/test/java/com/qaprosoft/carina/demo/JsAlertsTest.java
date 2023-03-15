package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObjects;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsAlertsTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/javascript_alerts

    PageObjects pageObjects = null;

    @BeforeMethod
    public void startDriver(){
        pageObjects = new PageObjects(getDriver());
    }

    @Test
    public void alertsTest(){
        pageObjects.open();
        pageObjects.clickAlertButtom();
        pageObjects.acceptAlert();
        Assert.assertEquals(pageObjects.getMessage(),"You successfully clicked an alert", "Results text incorrect");
    }

    @Test
    public void confirmTest(){
        pageObjects.open();
        pageObjects.clickConfirmButtom();
        pageObjects.dismissButtom();
        Assert.assertEquals(pageObjects.getMessage(),"You clicked: Cancel", "You clicked: Ok");
    }

    @Test
    public void promptTest(){
        pageObjects.open();
        pageObjects.clickPromptButtom();
        pageObjects.promptButtom("Andres Limpio Test");
        String alertmsg = pageObjects.getMessage();
        Assert.assertEquals(alertmsg,"You entered: Andres Limpio Test", "Result text incorrect");
    }
}
