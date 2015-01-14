package page_objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 07/11/2014
 */
public abstract class BasePageObject {

    public WebDriver driver;

    public final Logger LOG = Logger.getLogger(getClass());

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }



    /*
            add generic page object methods below
                            .
                            .
                            .
                            .
                            .
     */

    public void insertTextInput(WebElement textInputBox, String textInput) {
        textInputBox.sendKeys(textInput);
    }

    public void click(WebElement elementToBeClicked) {
        elementToBeClicked.click();
    }

    public void waitForElementVisible(int timeOutInSeconds, WebElement element) {
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }

}
