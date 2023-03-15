package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObject2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContextMenuTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/context_menu
    PageObject2 pageObject2 = null;

    @BeforeMethod
    public void startDriver(){
        pageObject2 = new PageObject2(getDriver());
    }

    @Test
    public void boxTest(){
        pageObject2.open();
        pageObject2.rightClickBox();
        pageObject2.acceptAlert();
    }
}
