package webdriver;

import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: jmartins
 * Date: 03/03/2014
 */
public class WebDriverSingleton {

    public static RemoteWebDriver createInstance(RemoteDriverProperties properties)
            throws Exception {

        DesiredCapabilities capabilities = DesiredCapabilitiesFactory.create(Browser.getBrowserBy(properties.getBrowser()));

        RemoteWebDriver driver = (RemoteWebDriver) new Augmenter().augment(
                new RemoteWebDriver(new URL("http://" + properties.getHubHost() + ":" + properties.getHubPort() + "/wd/hub"),
                        capabilities)
        );
        driver.setFileDetector(new LocalFileDetector());
        driver.manage().timeouts().implicitlyWait(2500, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        return driver;
    }

}
