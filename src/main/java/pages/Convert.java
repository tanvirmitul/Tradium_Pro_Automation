package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Convert {
    @FindBy(xpath = "//button[contains(normalize-space(),'Trade')]")
    public WebElement tradeHeader;
    @FindBy(xpath = "//a[normalize-space()='Convert']")
    public WebElement menuConvert;
    @FindBy(xpath = "//h2[normalize-space()='Convert']")
    public WebElement titleConvert;
    @FindBy(xpath = "//h2[normalize-space()='Dashboard']")
    public WebElement titleDashboard;
    @FindBy(xpath = "//button[normalize-space()='BTC']")
    public WebElement currencyBTC;
    @FindBy(xpath = "//button[normalize-space()='USDT']")
    public WebElement currencyUSDT;
    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement btnSubmit;
    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement btnConfirm;
    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement btnPlaceHolder;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement btnToggle;
    @FindBy(xpath = "(//*[@stroke='currentColor'])[4]")
    public WebElement btnSetting;
    @FindBy(xpath = "//div[normalize-space()='7 days']")
    public WebElement expireDrpdwn;
    @FindBy(css = "[tabindex='-1\']")
    public List<WebElement> expireDrpDownElemnt;  // Expiration drop-down days in Limit.
    @FindBy(name ="from")
    public WebElement txtFrom; // Text box of From
    @FindBy(className = "Convert_section_content__qhYai")
    public List<WebElement> rates;  // All rates in modal
    @FindBy(id ="to")
    public WebElement txtTo;  // Text box of From
    @FindBy(xpath = "//span[contains(normalize-space(),'Order Placed')]")
    public WebElement msgOrderPlaced;
    @FindBy(xpath = "//p[contains(normalize-space(),'Your convert order placed successfully. You will be notified when it is completed.')]")
    public WebElement msgConvertSuccess;
    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement btnOk;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    public WebElement btnOk2;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement btnCurrency1;
    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement btncurrencyTo;
    @FindBy(xpath = "//button[@type='button']")
    public List<WebElement> btnCurrency;
    @FindBy(xpath = "(//p[contains(@role,'button')])[1]")
    public WebElement balanAbvTxtFrom; // Balence above From text box
    @FindBy(xpath = "//p[contains(@role,'button')]")
    public List<WebElement> balanAbvTxt;
    @FindBy(xpath = "//a[contains(.,'Convert History')]")
    public WebElement btnConvertHistory;
    @FindBy(xpath = "//h4[normalize-space()='Convert History']")
    public WebElement titleConvertHistory;
    @FindBy(xpath = "(//div[normalize-space()='Cancel request placed successfully. You will be notified when it is done.'])[4]")
    public WebElement popupMsgCancelOrder;
    @FindBy(xpath = "//h4[normalize-space()='Open Orders']")
    public WebElement titleOpenOrder;
    @FindBy(xpath = "//span[normalize-space()='Open']")
    public WebElement convertStatusOpen;
    @FindBy(xpath = "//span[normalize-space()='Open Orders']")
    public WebElement menuOpenOrder;
    @FindBy(xpath = "//small[normalize-space()='Ether']")
    public WebElement currencyETH;
    @FindBy(xpath = "//small[normalize-space()='Matic']")
    public WebElement currencyMATIC;
    @FindBy(xpath = "(//p[contains(@role,'button')])[2]")
    public WebElement balnToPlacholder;
    @FindBy(tagName = "small")
    public List<WebElement> balnLimitValMsg;
    @FindBy(xpath = "//li[normalize-space()='Limit']")
    public WebElement tabLimit;
    @FindBy(tagName = "button")
    public List<WebElement> button;
    @FindBy(xpath = "(//button[@type='button'])[6]")
    public WebElement buttonOK;
    @FindBy(tagName = "strong")
    public List<WebElement> currencyTagName;
    @FindBy(xpath = "(//div[contains(normalize-space(),'Convert Order Placed')])[9]")
    public WebElement titleOrderPlaced;  // Title after setting trade in limit
    @FindBy(xpath = "(//div[contains(normalize-space(),'Convert Cancelled')])[9]")
    public WebElement titleCancelledOrder;
    @FindBy(id = "convert")
    public WebElement placeholderConvertPrize; // Convert prize placeholder in Limit
    @FindBy(xpath = "//p[contains(@role,'button')]")
    public List<WebElement> balnAbvPlachlder; //Balence above placeholder
    @FindBy(xpath = "//input[@placeholder='Search coin']")
    public WebElement searchTextbox;

    public Convert(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doConvert(String amount) throws InterruptedException {
        txtFrom.sendKeys(amount);
        Thread.sleep(500);

    }
    public  void visitLimit() throws InterruptedException {
        tradeHeader.click();
        Thread.sleep(1000);
        menuConvert.click();
        Thread.sleep(1000);
        tabLimit.click();
        Thread.sleep(500);
    }
    public void visitMarket() throws InterruptedException {
        tradeHeader.click();
        Thread.sleep(1000);
        menuConvert.click();
        Thread.sleep(1000);
    }
}
