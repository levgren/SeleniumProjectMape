package pageObgects;

import driver.DriverConstructor;
import org.openqa.selenium.WebDriver;

abstract class AbstractPage {
    WebDriver driver = DriverConstructor.getInstance().getDriver();
}
