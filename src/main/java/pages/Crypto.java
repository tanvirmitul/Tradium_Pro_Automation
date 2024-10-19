package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class Crypto extends Utils {
    public Crypto(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//button[contains(normalize-space(),'Crypto')]")
    public WebElement headerCrypto;
    @FindBy(xpath = "(//span[normalize-space()='Buy'])")
    public WebElement elementBuy;
    @FindBy(xpath = "(//a[normalize-space()='Sell'])[1]")
    public WebElement elementSell;
    @FindBy(xpath = "//h2[normalize-space()='Buy Crypto']")
    public WebElement titleBuyCrypto;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement selectCurrency1;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    public WebElement selectCurrency2;
    @FindBy(xpath = "//div[@class='SelectCoin_component_withdrawalCoinInfo__Kdzjv']")
    public WebElement selectCurrencyInModal;
    @FindBy(xpath = "//button[@class='CustomSidebar_component_close__jg2v3']")
    public WebElement btnCloseSideBarWallet;
    @FindBy(xpath = "//input[@name='fromAmount']")
    public WebElement txtFromAmount;
    @FindBy(xpath = "//input[contains(@name,'toAmount')]")
    public WebElement txtToAmount;
    @FindBy(xpath = "(//button[@type='button'])[5]")
    public WebElement btnSubmit;
    @FindBy(xpath = "//h3[normalize-space()='Success']")
    public WebElement reqstSubmitSuccessMsg;
    @FindBy(xpath = "//strong[contains(text(),'Your buy crypto request has been submitted success')]")
    public WebElement buyCryptoReqstSubmitMsg;
    @FindBy(xpath = "//strong[contains(text(),'Your sell crypto request has been submitted success')]")
    public WebElement sellCryptoReqstSubmitMsg;
    @FindBy(xpath = "(//small[@class='status-badge bg-success'])")
    public WebElement status;
    @FindBy(xpath = "//small[@class='status-badge bg-secondary']")
    public WebElement statusPending;
    @FindBy(xpath = "(//small[@class='status-badge bg-success'])[2]")
    public WebElement paymentStatus;
    @FindBy(xpath = "//small[@class='status-badge bg-info']")
    public WebElement paymentStatusProcessing;
    @FindBy(xpath = "(//div[@class='w-m-100'])[1]")
    public WebElement walletType;
    @FindBy(xpath = "(//div[@class='w-150'])[2]")
    public WebElement paymentAmount;
    @FindBy(xpath = "//div[@class='w-175']")
    public WebElement convertedTotalAmount;
    @FindBy(xpath = "(//div[@class='Quote_component_content__MaLAJ'])[4]")
    public WebElement convertedFee;
    @FindBy(xpath = "(//div[@class='Quote_component_content__MaLAJ'])[5]")
    public WebElement totalGetAmount;
    @FindBy(xpath = "(//div[@class='Quote_component_content__MaLAJ'])[1]")
    public WebElement currencyConversionRate;
    @FindBy(xpath = "//span[normalize-space()='Buy-Sell']")
    public WebElement menuBuySell;
    @FindBy(xpath = "//span[normalize-space()='Crypto History']")
    public WebElement elementCryptoHistory;
    @FindBy(xpath = "//a[normalize-space()='View Details']")
    public WebElement optViewDetailsInAdmin;
    @FindBy(xpath = "//button[normalize-space()='Approve & Complete']")
    public WebElement btnApproveAndCompleteInAdmin;
    @FindBy(xpath = "//a[normalize-space()='Confirm!']")
    public WebElement btnConfirmInAdmin;
    @FindBy(xpath = "//button[@id='dropdown-button-dark-example1']")
    public WebElement btnActionInAdmin;
    @FindBy(xpath = "//i[contains(@class,'fa-search')]")
    public WebElement iconSearchInAdmin;
    @FindBy(xpath = "//input[@class='g-search-input form-control']")
    public WebElement txtSearchInAdmin;
    @FindBy(xpath = "//span[normalize-space()='Buy-SellCrypto History']")
    public WebElement optBuySellCryptoHistory;
    @FindBy(xpath = "(//span[@class='menu-arrow'])[2]")
    public WebElement menuArrowInAdmin;
    @FindBy(xpath = "//button[normalize-space()='Make Fail']")
    public WebElement btnMakeFailInAdmin;
    @FindBy(xpath = "//textarea[@id='reason_note']")
    public WebElement txtReasonNoteInAdmin;
    @FindBy(xpath = "//small[contains(normalize-space(),'Failed')]")
    public WebElement statusFailed;
    @FindBy(xpath = "(//small[contains(normalize-space(),'Failed')])[2]")
    public WebElement paymentStatusFailed;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement btnSubmitInAdmin;
    @FindBy(xpath = "(//span[@class='Radio_tick__Ee5FP'])[2]")
    public WebElement radioBtnFunding;
    @FindBy(xpath = "(//span[@class='Radio_tick__Ee5FP'])[1]")
    public WebElement radioBtnSpot;
    @FindBy(xpath = "//h2[normalize-space()='Sell Crypto']")
    public WebElement titleSellCrypto;


    public void visitBuyCrypto() throws InterruptedException {
        headerCrypto.click();
        Thread.sleep(500);
        elementBuy.click();
        Thread.sleep(1000);
    }
    public void visitSellCrypto() throws InterruptedException {
        headerCrypto.click();
        Thread.sleep(500);
        elementSell.click();
        Thread.sleep(1000);
    }
    public void selectCurrencies(String currency1, String currency2) throws InterruptedException {
        Fiat fiat= new Fiat(driver);
        selectCurrency1.click();
        Thread.sleep(1000);
        fiat.txtSearchCurrency.sendKeys(currency1);
        Thread.sleep(1000);
        selectCurrencyInModal.click();
        Thread.sleep(1000);
        selectCurrency2.click();
        Thread.sleep(1000);
        fiat.txtSearchCurrency.sendKeys(currency2);
        Thread.sleep(1000);
        selectCurrencyInModal.click();
        Thread.sleep(1000);
    }
    public void visitSpotWalletBuySellCrypto(String fiatCurrency, String cryptoCurrency) throws InterruptedException {
        Fiat fiat= new Fiat(driver);
        fiat.headerWallet.click();
        Thread.sleep(1000);
        fiat.elementSpot.click();
        Thread.sleep(1000);
        fiat.txtSearchCurrencySpot.sendKeys(fiatCurrency);
        Thread.sleep(1000);
        fiat.currencyInTable.click();
        Thread.sleep(1000);
        btnCloseSideBarWallet.click();
        Thread.sleep(1000);
        fiat.txtSearchCurrencySpot.clear();
        fiat.txtSearchCurrencySpot.sendKeys(cryptoCurrency);
        Thread.sleep(1000);
        fiat.currencyInTable.click();
        Thread.sleep(1000);
        btnCloseSideBarWallet.click();
        Thread.sleep(1000);
    }
    public void visitFundingWalletBuySellCrypto(String fiatCurrency, String cryptoCurrency) throws InterruptedException {
        Fiat fiat= new Fiat(driver);
        fiat.headerWallet.click();
        Thread.sleep(1000);
        fiat.elementFunding.click();
        Thread.sleep(1000);
        fiat.txtSearchCurrencySpot.sendKeys(fiatCurrency);
        Thread.sleep(1000);
        fiat.currencyInTable.click();
        Thread.sleep(1000);
        btnCloseSideBarWallet.click();
        Thread.sleep(1000);
        fiat.txtSearchCurrencySpot.clear();
        fiat.txtSearchCurrencySpot.sendKeys(cryptoCurrency);
        Thread.sleep(1000);
        fiat.currencyInTable.click();
        Thread.sleep(1000);
        btnCloseSideBarWallet.click();
        Thread.sleep(1000);
    }
    public void approveBankDepositByAdmin(WebDriver driver3) throws InterruptedException {
        elementCryptoHistory.click();
        Thread.sleep(2000);
        btnActionInAdmin.click();
        Thread.sleep(1000);
        optViewDetailsInAdmin.click();
        Thread.sleep(2000);
        btnApproveAndCompleteInAdmin.click();
        Thread.sleep(2000);
        btnConfirmInAdmin.click();
        Thread.sleep(2000);
        driver3.quit();
    }
    public void makeFailBankDepositByAdmin(WebDriver driver5,String reason) throws InterruptedException {
        elementCryptoHistory.click();
        Thread.sleep(2000);
        btnActionInAdmin.click();
        Thread.sleep(1000);
        optViewDetailsInAdmin.click();
        Thread.sleep(2000);
        btnMakeFailInAdmin.click();
        Thread.sleep(2000);
        btnConfirmInAdmin.click();
        Thread.sleep(2000);
        txtReasonNoteInAdmin.sendKeys(reason);
        Thread.sleep(1000);
        btnSubmitInAdmin.click();
        Thread.sleep(1000);
        driver5.quit();
    }
}
