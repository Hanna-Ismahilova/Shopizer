package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputText {

    private int timeout = 10;
    private WebElement element;
    private WebDriver driver;

    public InputText(WebDriver driver, By by){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(this.driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable((by)));
    }

    public InputText sendKeys(String text){
        this.element.sendKeys(text);
        return this;
    }
    public InputText clearAndSendKyes(){
        Actions carActionSequence  = new Actions(driver);
        carActionSequence.moveToElement(this.element).click().perform();
        return this;
    }
//    public InputText sendKeysWithJs(){
//        JavascriptExecutor runner = (JavascriptExecutor) driver;
//        String script = "arguments[0].click();";
//        runner.executeScript(script, this.element);
//        return this;

    }

