package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;

public class PageObject2 extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ExtendedWebElement driver;

    public PageObject2(WebDriver driver) {
        super(driver);
    }

    /*Start Attritubes and methods for upload files*/

    @FindBy(id= "file-upload")
    private ExtendedWebElement selectFileButtom;

    @FindBy(id= "file-submit")
    private ExtendedWebElement uploadButtom;

    public void clickSelectFileButtom(String fullPath){
       selectFileButtom.getElement().sendKeys(fullPath);
    }
    public void clickUploadButtom(){
        uploadButtom.click();
    }

    /*Finish Attritubes and methods for upload files*/
//-------------------------------------------------------------------------
    /*Start Attritubes and methods for modals*/

    @FindBy(xpath ="//div[@class='modal-title']")
    private  ExtendedWebElement modalTitle;

    @FindBy(xpath ="//div[@class='modal-body']//p")
    private  ExtendedWebElement modalBody;

    @FindBy(xpath = "//p[text()='Close']")
    private ExtendedWebElement modalFooter;

    public void showTitle(){
        String s1 = modalTitle.getText();
        LOGGER.info(s1);
    }

    public void showBody(){
        String s2 = modalBody.getText();
        LOGGER.info(s2);
    }
    public void clickclose(){
            modalFooter.clickByActions();
    }

    /*Finish Attritubes and methods for modals*/

    /*Start Attritubes and methods for frames*/

    @FindBy(id = "tinymce")
    private ExtendedWebElement textArea;

    @FindBy(xpath = "(//*[name()='svg'])[8]")
    private ExtendedWebElement boldButtom;

    String editorFrame = "mce_0_ifr";

    private void switchToMainArea(){
        getDriver().switchTo().parentFrame();
    }

    public void switchToEditArea(){
        getDriver().switchTo().frame(editorFrame);
    }

    public void clearTextArea(){
        switchToEditArea();
        textArea.getElement().clear();
        switchToMainArea();
    }

    public void typeTextArea(String text){
        switchToEditArea();
        textArea.getElement().sendKeys(text);
        switchToMainArea();
    }

    public void boldText(){
        boldButtom.click();
    }

    /*Finish Attritubes and methods for frames*/
    //------------------------------------------------------
    /*Start Attritubes and methods for Context Menu (Right Click)*/
    @FindBy(id = "hot-spot")
    private ExtendedWebElement box;

    public void rightClickBox(){
        box.rightClick();
    }

    public void acceptAlert(){
        Alert acceptW = getDriver().switchTo().alert();
        Assert.assertEquals(acceptW.getText(), "You selected a context menu");
        acceptW.accept();
    }


    /*Finish Attritubes and methods for Context Menu (Right Click)*/

}
