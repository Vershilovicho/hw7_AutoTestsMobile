import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;
import java.util.Set;

public class HomeworkTest extends BaseTest{
    @AndroidFindBy(accessibility = "www.e-katalog")
    MobileElement title;
    @FindBy(xpath = "//div[@id=\"owl-slider\"]//a[text()=\"Мобильные\"]")
    MobileElement mobiles;
    @FindBy(xpath = "//a[text()=\"Apple\"]")
    MobileElement apple;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"по популярности\"]/parent::android.view.View")
    MobileElement byPopularityFilter;
    @AndroidFindBy(accessibility = "от дешевых к дорогим")
    MobileElement fromCheapToExpensiveFilter;
    @AndroidFindBy(uiAutomator = "new UiScrollable(scrollable(true)).flingToEnd(3)")
    MobileElement scroll;

    @Test
    void ekatalogWebView(){
        title.isDisplayed();
        changeDriverContextToWebView(driver);
        mobiles.click();
        apple.click();
        changeDriverContextToNative(driver);
        byPopularityFilter.click();
        fromCheapToExpensiveFilter.click();
        scroll.isDisplayed();
    }

    void changeDriverContextToWebView(AppiumDriver<?> driver){
        Set<String> contextHandles = driver.getContextHandles();
        for (String name: contextHandles){
            if (name.contains("WEBVIEW"))
                driver.context(name);
        }
    }
    void changeDriverContextToNative(AppiumDriver<?> driver){
        Set<String> contextHandles = driver.getContextHandles();
        for (String name: contextHandles) {
            if (name.contains("WEBVIEW"))
                driver.context(name);
        }
    }
}