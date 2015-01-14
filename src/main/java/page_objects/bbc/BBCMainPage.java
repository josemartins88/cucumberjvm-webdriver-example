package page_objects.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.BasePageObject;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 14/01/15
 */
public class BBCMainPage extends BasePageObject {

    @FindBy(id = "orb-search-q")
    WebElement searchInputBox;

    @FindBy(id = "orb-search-button")
    WebElement searchButton;

    @FindBy(css = "section.search-content")
    WebElement searchContentContainer;

    public BBCMainPage(WebDriver driver) {
        super(driver);
    }

    // Actions

    public void searchFor(String searchTerm) {
        LOG.info("Searching BBC page for " + searchTerm);
        insertSearchTerm(searchTerm);
        clickSearchButton();
        waitForElementVisible(5, searchContentContainer);
    }


    // Get sections

    public BBCFooterSection getBBCFooterSection() {
        return PageFactory.initElements(driver, BBCFooterSection.class);
    }


    // Internal methods

    private void insertSearchTerm(String searchTerm) {
        insertTextInput(searchInputBox, searchTerm);
    }

    private void clickSearchButton() {
        click(searchButton);
    }


}
