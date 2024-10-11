import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @BeforeMethod
    public void openWebSite(){
        driver.get("https://www.saucedemo.com/");
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
