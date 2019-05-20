import com.automation.remarks.junit.VideoRule;
import driver.DriverConstructor;
import driver.ThreadLocalDriver;
import org.junit.*;
import pageObgects.MainPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestHelper {

    MainPage mainPage = new MainPage();

    private static FileInputStream fileInputStream;
    private static Properties properties;

    protected static String url;
    protected static String searchedWord;
    protected static String domain;

    @Rule
    public VideoRule videoRule = new VideoRule();

    @BeforeClass
    public static void configProperties() throws Exception {
        try {
            fileInputStream = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        url = properties.getProperty("url");
        domain = properties.getProperty("domain");
        searchedWord = properties.getProperty("searchedWord");
        System.setProperty("browser", properties.getProperty("browser"));
    }

    @Before
    public void openGoogleSearchPage(){
        mainPage.goTo(url);
    }

    @After
    public void closeDriver(){
        ThreadLocalDriver.quitThreadLocalDriver();
    }
}
