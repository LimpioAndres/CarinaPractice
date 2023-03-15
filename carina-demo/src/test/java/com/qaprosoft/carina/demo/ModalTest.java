package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObject2;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ModalTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/entry_ad
    PageObject2 pageObject2 = null;

    @BeforeSuite
    public void startDriver(){
        pageObject2 = new PageObject2(getDriver());
    }

    @Test
    public void modalTest(){
        pageObject2.open();
        pageObject2.showTitle();
        pageObject2.showBody();
        pageObject2.clickclose();
    }
}
