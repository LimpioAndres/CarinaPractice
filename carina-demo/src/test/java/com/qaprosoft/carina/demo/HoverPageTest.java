package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObjects;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverPageTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/hovers
    PageObjects pageObjects = null;

    @BeforeMethod
    public void startDriver(){
        pageObjects = new PageObjects(getDriver());
    }

    @Test
    public void hoverTest(){
        pageObjects.open();
        pageObjects.hoverBox();
        pageObjects.clickText();
    }
}
