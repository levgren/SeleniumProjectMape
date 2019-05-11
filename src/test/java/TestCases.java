import com.automation.remarks.video.annotations.Video;
import org.junit.Test;

public class TestCases extends TestHelper {

    @Test
    @Video
    public void verifyFirstLinkTitle(){
        mainPage.showResults(searchedWord)
                .openFirstLink()
                .getTextFromTitle();
    }

    @Test
    @Video
    public void verifyExpectedDomain(){
        mainPage.showResults(searchedWord)
                .verifyDomainOnSearchResultPage(domain, 5);
    }
}
