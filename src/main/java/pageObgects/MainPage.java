package pageObgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MainPage extends AbstractPage {

    private By searchInput = By.xpath("//input[@name='q']");

    public MainPage goTo(String address){
        driver.get(address);
        return this;
    }

    public SearchResultPage showResults(String searchedWord) {
        driver.findElement(searchInput).sendKeys(searchedWord);
        Allure.addAttachment("Google MainPage search input", "text: '" + searchedWord + "' is entered in search input");
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        Allure.addAttachment("Press enter","The button 'Enter' is pressed");
        return new SearchResultPage();
    }
}
