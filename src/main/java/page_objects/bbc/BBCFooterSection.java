package page_objects.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 14/01/15
 */
public class BBCFooterSection extends BasePageObject {

    @FindBy(css = ".orb-footer-inner a[href*='/terms/']")
    WebElement termsAndConditionsLink;

    public BBCFooterSection(WebDriver driver) {
        super(driver);
    }

    public boolean isTermsAndConditionsLinkVisible() {
        try {
            return termsAndConditionsLink.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
