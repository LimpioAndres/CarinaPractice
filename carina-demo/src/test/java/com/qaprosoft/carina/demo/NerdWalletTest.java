package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageOb;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NerdWalletTest implements IAbstractTest {

    //https://www.nerdwallet.com/
    PageOb pageOb = null;

    @BeforeSuite
    public void startDriver(){
        pageOb = new PageOb(getDriver());
    }

    @Test
    public void testNerdWalletWeb(){
        pageOb.open();
        pageOb.clickButtom();
        Assert.assertEquals(pageOb.getMessage(), "Get rewards for the way you travel", "Wrong Message");
    }
}
