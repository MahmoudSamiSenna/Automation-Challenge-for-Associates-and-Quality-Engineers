import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @Test(priority = 1)
    public void checkVisibilityOfFields() {
        loginPage = new LoginPage(driver);
        System.out.println("Is username field visible " + loginPage.isUserNameFieldVisible());
        System.out.println("Is password field visible " + loginPage.isPasswordFieldVisible());
    }

    @Test(priority = 2)
    public void validCredentials() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.getWebsiteTitle().contains("Swag Labs"));
        System.out.println("Website name is " + homePage.getWebsiteTitle());
    }

    @Test(priority = 3)
    public void invalidCredentials() {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match "));
        System.out.println("Error message is " + loginPage.getErrorMessage());
    }

    @Test(priority = 4)
    public void emptyUsername() {
        loginPage = new LoginPage(driver);
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username is required"));
        System.out.println("Error message is " + loginPage.getErrorMessage());
    }

    @Test(priority = 5)
    public void emptyPassword() {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("performance_glitch_user");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Password is required"));
        System.out.println("Error message is " + loginPage.getErrorMessage());
    }
}
