package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObject4;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LargeDeepDOMTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/large
    PageObject4 pageObject4 = null;

    @BeforeMethod
    public void startDriver(){
        pageObject4 = new PageObject4(getDriver());
    }

    @Test
    public void javascriptScroll(){
        pageObject4.open();
        pageObject4.scrollTable();
    }
}
