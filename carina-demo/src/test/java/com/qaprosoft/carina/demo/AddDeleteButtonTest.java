package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.PageObjects;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AddDeleteButtonTest implements IAbstractTest {

    // https://the-internet.herokuapp.com/add_remove_elements/
    PageObjects pageObjects = null;

    @BeforeSuite
    public void startDriver() {
        pageObjects = new PageObjects(getDriver());
    }

    @Test
    public void addElementTest(){
        pageObjects.open();
        pageObjects.clickAddButton();
        Assert.assertEquals(pageObjects.countElements(), 1, "The count was not expected");
    }

    @Test
    public void deleteButtonTest(){
        pageObjects.open();
        pageObjects.clickAddButton();
        pageObjects.clickDeleteButton();
        Assert.assertEquals(pageObjects.countElements(), 0, "The count was not expected");
    }
}
