package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObjects3;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest2 implements IAbstractTest {

    //https://the-internet.herokuapp.com/nested_frames
    PageObjects3 pageObject3 = null;

    @BeforeMethod
    public void startDriver(){
        pageObject3 = new PageObjects3(getDriver());
    }

    @Test
    public void frameTest2(){
        pageObject3.open();
        pageObject3.verifyLeftFrame();
        pageObject3.verifyBottomFrame();

    }
}
