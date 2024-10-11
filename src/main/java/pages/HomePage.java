package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By getHeader=By.xpath("//div[@class='app_logo']");
    public String getWebsiteTitle (){
        return driver.findElement(getHeader).getText();
    }
}
