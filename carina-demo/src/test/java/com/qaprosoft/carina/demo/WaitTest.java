package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObject4;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WaitTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/dynamic_loading/1

    PageObject4 pageObjects4 = null;

    @BeforeSuite
    public void startDriver(){
        pageObjects4 = new PageObject4(getDriver());
    }

    @Test
    public void waitTest() {
        pageObjects4.open();
        pageObjects4.clickWaitButtom();
        Assert.assertEquals(pageObjects4.getMessage(),"Hello World!", "Wrong Message");
    }
}
