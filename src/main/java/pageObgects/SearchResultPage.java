package pageObgects;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;

public class SearchResultPage extends AbstractPage{

    private By allLinksSelector = By.cssSelector(".iUh30");
    private By nextPageButton = By.cssSelector("#pnnext");

    public SitePage openFirstLink(){
        driver.findElements(allLinksSelector).get(0).click();
        Allure.addAttachment("Open the first link","The first link is opened");
        return new SitePage();
    }

    public SearchResultPage pressNextPageButton() {
        driver.findElement(nextPageButton).click();
        Allure.addAttachment("Press nextPageButton", "The nextPageButton was pressed");
        return this;
    }

    public boolean verifyDomainOnSearchResultPage(String expectedDomain, int numberOfSearchResultPages) {
        boolean searchResult = false;
        for (int i = 0; i < numberOfSearchResultPages; i++) {
            if (driver.getPageSource().contains(expectedDomain)) {
                searchResult = true;
                break;
            }
            pressNextPageButton();
        }
        if (searchResult){
            Allure.addAttachment("Verifying expected domain on SearchResultPage", "Success. " + expectedDomain + " is present on result page");
        }else {
            Allure.addAttachment("Verifying expected domain on SearchResultPage", "Oops. There is no " + expectedDomain + " on result pages");
        }
        return searchResult;
    }
}
