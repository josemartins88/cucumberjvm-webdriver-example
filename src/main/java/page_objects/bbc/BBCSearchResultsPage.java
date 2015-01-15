package page_objects.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page_objects.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 15/01/15
 */
public class BBCSearchResultsPage extends BasePageObject {

    @FindBy(css = "ol.search-results.results")
    WebElement searchResultsContainer;

    public BBCSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchResultsContainerVisible() {
        try {
            return searchResultsContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
