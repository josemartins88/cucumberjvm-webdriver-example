package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import util.PropertiesLoader;
import webdriver.RemoteDriverProperties;
import webdriver.WebDriverSingleton;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 13/01/15
 */

public class BaseWebDriverStepDefinitions {

    public static Scenario scenario;
    public static WebDriver driver;
    public static Properties properties = PropertiesLoader.loadProperties();

    private static final String BROWSER_PROPERTY = "driver.browser";
    private static final String HUB_HOST_PROPERTY = "driver.hubHost";
    private static final String HUB_PORT_PROPERTY = "driver.hubPort";

    @Before("@webdriver")
    public static void setupWebDriver(Scenario actualScenario) throws Throwable {
        scenario = actualScenario;
        RemoteDriverProperties remoteDriverProperties = new RemoteDriverProperties();
        String browser = System.getProperty(BROWSER_PROPERTY);
        if (StringUtils.isBlank(browser)) {
            browser = properties.getProperty(BROWSER_PROPERTY);
        }
        remoteDriverProperties.setBrowser(browser);

        String host = System.getProperty(HUB_HOST_PROPERTY);
        if (StringUtils.isBlank(host)) {
            host = properties.getProperty(HUB_HOST_PROPERTY);
        }
        remoteDriverProperties.setHubHost(host);

        String port = System.getProperty(HUB_PORT_PROPERTY);
        if (StringUtils.isBlank(port)) {
            port = properties.getProperty(HUB_PORT_PROPERTY);
        }
        remoteDriverProperties.setHubPort(port);
        driver = WebDriverSingleton.createInstance(remoteDriverProperties);

    }

    @After("@webdriver")
    public static void tearDownWebDriver() {
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        }
        driver.quit();
    }

}
