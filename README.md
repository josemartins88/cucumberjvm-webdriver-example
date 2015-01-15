# cucumberjvm-webdriver-example
This is the skeleton of a test framework using maven, cucumber-jvm and selenium webdriver.
This follows a Page object design pattern using PageFactory to instantiate the page objects.
This contains a scenario for demo purposes with the BBC webpage.


## How to run the tests:
To run the full suite locally you should have a selenium grid hub and at least one node running on your machine.
To do that follow the steps below:

- Download the most recent selenium server (http://www.seleniumhq.org/download/)

- Download ChromeDriver (https://sites.google.com/a/chromium.org/chromedriver/downloads)

- Start the selenium grid hub locally (change the selenium-server version as needed)
```bash
   java -jar selenium-server-standalone-2.44.0.jar -role hub
```

- Start a selenium grid node locally
```bash
java -jar selenium-server-standalone-2.44.0.jar -role node  -hub http://localhost:4444/grid/register -Dwebdriver.chrome.driver='chrome driver path'
```

- Run in the project directory
```bash
mvn clean test
```

## Structure

- **test/resources/features**:
Contains all the feature files written in gherkin syntax. It is possible to specify which scenarios or features are
browser based by adding a '@webdriver' tag to it.

- **test/resources/config**:
This package contains the configuration files such as WebDriver properties. In that file is possible to specify the
address and port where the selenium hub is running and which browser should be used.

- **test/java/step_definitions**:
This package contains a BaseWebDriverStepDefinitions class, which has before and after hooks. For webdriver based scenarios
it is responsible to create a webdriver instance reading the properties from the webdriver.properties. It also allows to
overwrite these properties using system properties.

- **test/java/RunTest**:
This class is the test suite runner. It is possible to change the CucumberOptions (http://cukes.info/api/cucumber/jvm/javadoc/cucumber/api/CucumberOptions.html)
annotation to run the test suite in different ways.

- **main/java/page/objects**:
All page objects should be in this package. It contains an abstract class (BasePageObject) that all of the other page objects should extend from.
This class contains all the generic methods for a page object.

- **main/java/util**:
Utilities should go here. 
Example: PropertiesLoader that is responsible for loading the webdriver properties from a configuration file.

- **main/java/webdriver**:
All the necessary classes to configure webdriver. Each scenario should create its own instance of WebDriver so we never end up sharing one driver amongst several scenarios in case we want to run tests in parallel.


