package pageObgects;

public class SitePage extends AbstractPage{
    public String getTextFromTitle(){
        return driver.getTitle();
    }
}
