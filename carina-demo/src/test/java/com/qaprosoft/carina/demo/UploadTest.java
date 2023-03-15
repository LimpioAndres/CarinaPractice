package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObject2;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UploadTest implements IAbstractTest {

    //https://the-internet.herokuapp.com/upload
    PageObject2 pageObject2 = null;

    @BeforeSuite
    public void startDriver() {
        pageObject2 = new PageObject2(getDriver());
    }

    @Test
    public void testUpload(){
        pageObject2.open();
        pageObject2.clickSelectFileButtom("C:\\Users\\gatm_\\Desktop\\SOLVD\\Tengen.jpg");
        pageObject2.clickUploadButtom();
    }

}
