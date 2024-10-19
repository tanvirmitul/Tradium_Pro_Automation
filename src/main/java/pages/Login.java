package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;


public class Login extends Utils {
    @FindBy(id = "email")
    public WebElement txtEmail;
    @FindBy(id = "password")
    public WebElement txtPassword;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    public WebElement btnLogin;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement txtAdminEmail;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement txtAdminPassword;

    @FindBy(xpath = "//button[normalize-space()='Log In']")
    public WebElement btnAdminlogin;


    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void doLogin(String email, String password) throws InterruptedException {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        btnLogin.click();
        Thread.sleep(7000);
    }
    public void doLoginAdmin(String email, String password) throws InterruptedException {
        txtAdminEmail.sendKeys(email);
        txtAdminPassword.sendKeys(password);
        btnAdminlogin.click();
        Thread.sleep(6000);
    }

}
