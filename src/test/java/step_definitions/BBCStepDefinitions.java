package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import page_objects.bbc.BBCMainPage;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 14/01/15
 */
public class BBCStepDefinitions {

    @Given("^I am on the BBC main page$")
    public void I_am_on_the_BBC_main_page() throws Throwable {
        BaseWebDriverStepDefinitions.driver.get("http://www.bbc.co.uk/");
    }

    @Then("^.* see the terms and conditions link in the footer$")
    public void I_can_see_the_terms_and_conditions_link_in_the_footer() throws Throwable {
        BBCMainPage bbcMainPage = PageFactory.initElements(BaseWebDriverStepDefinitions.driver, BBCMainPage.class);
        assert bbcMainPage.getBBCFooterSection().isTermsAndConditionsLinkVisible();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String searchTerm) throws Throwable {
        BBCMainPage bbcMainPage = PageFactory.initElements(BaseWebDriverStepDefinitions.driver, BBCMainPage.class);
        bbcMainPage.searchFor(searchTerm);
    }
}
