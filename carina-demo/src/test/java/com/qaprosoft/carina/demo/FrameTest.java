package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObject2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/tinymce

    PageObject2 pageObject2 = null;

    @BeforeMethod
    public void startDriver(){
        pageObject2 = new PageObject2(getDriver());
    }

    @Test
    public void frameTest(){
        String text = "Hello World, testing this frame";
        pageObject2.open();
        pageObject2.clearTextArea();
        pageObject2.boldText();
        pageObject2.typeTextArea(text);
    }


}
