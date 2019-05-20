package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class DriverConstructor {

    private static WebDriver driver = null;
    public DriverConstructor() {
        if (driver == null && System.getProperty("browser").equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ThreadLocalDriver.setDriver(driver);
        }
        if (driver == null && System.getProperty("browser").equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            ThreadLocalDriver.setDriver(driver);
        }
        if (driver == null && System.getProperty("browser").equals("opera")){
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
            ThreadLocalDriver.setDriver(driver);
        }
        if (driver == null && System.getProperty("browser").equals("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            ThreadLocalDriver.setDriver(driver);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static DriverConstructor getInstance() {
        return new DriverConstructor();
    }

    public WebDriver getDriver() {
        return ThreadLocalDriver.getDriver();
    }
}
