package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedAnnotations;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PageObject4 extends AbstractPage {

    private ExtendedAnnotations driver;

    public PageObject4(WebDriver driver){
        super(driver);
    }

    /*Start Attritubes and methods for wait*/

    @FindBy(xpath = "//button[contains(text(),'Start')]")
    private ExtendedWebElement startButtom;

    @FindBy(xpath = "//div[@id='loading']/img")
    private ExtendedWebElement loadingDisplay;

    @FindBy(id = "finish")
    private ExtendedWebElement textHidden;

    public void clickWaitButtom() {
        startButtom.click();
        waitUntil(ExpectedConditions.invisibilityOf(loadingDisplay.getElement()), 10);
    }

    public String getMessage(){
        return textHidden.getText();
    }
    /*Finish Attritubes and methods for wait*/
    //------------------------------------------------------------
    /*Start Attritubes and methods for Javascript scroll (large and DOM)*/

    @FindBy(xpath = "//table[@id='large-table']")
    private ExtendedWebElement table;

    public void scrollTable(){
        WebElement tableElement = table.getElement();
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)getDriver()).executeScript(script, tableElement);

    }
    /*Finish Attritubes and methods for Javascript scroll (large and DOM)*/
    //------------------------------------------------------------
    /*Start Attritubes and methods for Javascript infinite scroll*/

    @FindBy(className = "jscroll-added")
    private ExtendedWebElement textBlock;

    public void infiniteScroll(int index){
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        JavascriptExecutor jsExecutor = (JavascriptExecutor)getDriver();

        while(getNumberOfParagraph() < index){
            jsExecutor.executeScript(script);
        }
    }
    private int getNumberOfParagraph(){
        return getDriver().findElements(By.className("jscroll-added")).size();
    }

    /*Finish Attritubes and methods for Javascript infinite scroll*/
    //---------------------------------------------------------------
    /*Start Attritubes and methods for Drag and Drop*/

    @FindBy(id = "draggable")
    private ExtendedWebElement drag;

    @FindBy(id = "droppable")
    private ExtendedWebElement drop;

    @FindBy(xpath = "//*[@id='content']/iframe")
    private ExtendedWebElement frame;

    public void switchFrame(){
        getDriver().switchTo().frame(frame.getElement());
    }

    public void dragAndDropElement(){
        dragAndDrop(drag,drop);
    }

    /*Finish Attritubes and methods for Drag and Drop*/

}
