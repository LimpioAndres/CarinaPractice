package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PageObjects3 extends AbstractPage {

    private ExtendedWebElement driver;

    public PageObjects3(WebDriver driver){
        super(driver);
    }

    /*Start Attritubes and methods for frames 2*/

    @FindBy(tagName = "frame-top")
    private ExtendedWebElement topF;

    @FindBy(tagName = "frame-left")
    private ExtendedWebElement leftF;

    @FindBy (tagName = "frame-bottom")
    private ExtendedWebElement bottomF;

    @FindBy (tagName = "body")
    private ExtendedWebElement body;

    String topFrame = "frame-top";
    String leftFrame = "frame-left";
    String bottomFrame = "frame-bottom";

    public void switchToLeftFrame(){
        getDriver().switchTo().frame(topFrame);
        getDriver().switchTo().frame(leftFrame);
    }

    public void switchToBottomFrame(){
        getDriver().switchTo().frame(bottomFrame);
    }

    private void switchToMainFrame(){
        getDriver().switchTo().parentFrame();
    }

    public void verifyLeftFrame(){
        switchToLeftFrame();
        Assert.assertEquals(body.getElement().getText(), "LEFT");
        switchToMainFrame();
        switchToMainFrame();
    }

    public void verifyBottomFrame(){
        switchToBottomFrame();
        Assert.assertEquals(body.getElement().getText(), "BOTTOM");
        switchToMainFrame();
    }

    /*Finish Attritubes and methods for frames 2*/
}
