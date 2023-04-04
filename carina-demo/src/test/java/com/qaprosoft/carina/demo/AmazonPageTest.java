package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageOb;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonPageTest implements IAbstractTest {

    //https://www.amazon.com.mx/

    PageOb pageOb = null;

    @BeforeMethod
    public void StartDriver(){
        pageOb = new PageOb(getDriver());
    }

    @Test
    public void AmazonTestLogin(){
        pageOb.open();
        pageOb.clickIdentifyButtom();
        pageOb.inputEmail("alimpio.laba@solvd.com"); //I just a example, not real
        pageOb.clickContinueButtom();
        pageOb.inputPassword("123456");
        pageOb.clickSignInButtom();
        Assert.assertEquals(pageOb.getNameAccount(), "Hola Andres", "Wrong Message");
    }
}
