package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utils;


import java.io.IOException;
import java.text.ParseException;

public class Fiat extends Utils {

    private static final String FILENAME = "./src/test/resources/saveValue/fiat.json";
    @FindBy(xpath = "//button[contains(normalize-space(),'Fiat')]")
    public WebElement headerFiat;

    @FindBy(xpath = "(//a[normalize-space()='Deposit'])[2]")
    public WebElement elementDeposit;

    @FindBy(xpath = "(//a[normalize-space()='Withdraw'])[2]")
    public WebElement elementWithdraw;

    @FindBy(xpath = "//h2[normalize-space()='Deposit Fiat']")
    public WebElement titleDepositFiat;

    @FindBy(xpath = "//h2[normalize-space()='Withdraw Fiat']")
    public WebElement titleDepositWithdraw;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement btnContinue;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement btnSubmit;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    public WebElement txtSearchCurrencySpot;

    @FindBy(xpath = "//strong[normalize-space()='EUR']")
    public WebElement currencyEuro;

    @FindBy(xpath = "//div[@class='coinWrapper t_10 Spot_coinWrapper___8oOq']")
    public WebElement currencyInTable;

    @FindBy(xpath = "//input[@id='amount']")
    public WebElement txtAmount;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement radioBtnPaymentMethod1;
    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement radioBtnPaymentMethod3;
    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement radioBtnPaymentMethod2;

    @FindBy(xpath = "//input[contains(@name,'paymentMethod')]")
    public WebElement radioBtnPaypal;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement radioBtn2;
    @FindBy(xpath = "(//input[contains(@name,'bank')])[1]")
    public WebElement radioBtnBank1;

    @FindBy(xpath = "(//span[contains(.,'Online Payment')])[2]")
    public WebElement paymentMethod1;

    @FindBy(xpath = "(//div[@class='PaymentToOptions_component_detailsItem__IVy96'])[3]")
    public WebElement depositFee;

    @FindBy(xpath = "(//div[@class='PaymentToOptions_component_detailsItem__IVy96'])[4]")
    public WebElement getDepositAmount;

    @FindBy(xpath = "//button[normalize-space()='Confirm']")
    public WebElement btnConfirm;

    @FindBy(xpath = "//button[normalize-space()='Make Payment Processing']")
    public WebElement btnMakePaymentProcessing;

    @FindBy(xpath = "//div[@class='braintree-option braintree-option__card']")
    public WebElement braintreeCard;
    @FindBy(xpath = "//div[normalize-space()='Upload']")
    public WebElement btnUpload;

    @FindBy(id = "Field-numberInput")
    public WebElement txtCardNum;

    @FindBy(id = "credit-card-number")
    public WebElement txtCardNumBraintree;

    @FindBy(className = "expirationDate")
    public WebElement txtExpirationBraintree;

    @FindBy(id = "cvv")
    public WebElement txtCVCNumBraintree;

    @FindBy(id = "Field-cvcInput")
    public WebElement txtCVC;

    @FindBy(xpath = "//button[normalize-space()='Pay']")
    public WebElement btnPay;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    public WebElement btnOk;

    @FindBy(xpath = "//a[normalize-space()='Confirm!']")
    public WebElement btnConfrimAdmin;

    @FindBy(xpath = "//button[normalize-space()='View Details']")
    public WebElement btnViewDetails;

    @FindBy(xpath = "//a[normalize-space()='View Details']")
    public WebElement btnViewDetailsAdmin;

    @FindBy(xpath = "//button[normalize-space()='Approve & Complete']")
    public WebElement btnApproveCompleteAdmin;

    @FindBy(xpath = "//div[contains(text(),'Deposit Completed')]")
    public WebElement titleDepositComplt;

    @FindBy(xpath = "//button[@class='Modal_close__qRRpj']")
    public WebElement btnModalClose;

    @FindBy(xpath = "(//div[@class='TransactionHistory_section_detailBox__VNJLu'])[7]")
    public WebElement feeDepositDetails;

    @FindBy(xpath = "(//div[@class='TransactionHistory_section_detailBox__VNJLu'])[8]")
    public WebElement getAmountDepositDetails;

    @FindBy(id = "Field-expiryInput")
    public WebElement txtExpiration;

    @FindBy(name = "btnNext")
    public WebElement btnNextPaypal;

    @FindBy(id = "email")
    public WebElement txtPaypalEmail;

    @FindBy(id = "password")
    public WebElement txtPaypalPassword;

    @FindBy(id = "btnLogin")
    public WebElement btnLoginPaypal;

    @FindBy(css = "[fill=\"currentColor\"]")
    public WebElement btnThreeDot;

    @FindBy(xpath = "//a[contains(normalize-space(),'Spot')]")
    public WebElement elementSpot;
    @FindBy(xpath = "//a[contains(normalize-space(),'Funding')]")
    public WebElement elementFunding;

    @FindBy(xpath = "//button[@id='payment-submit-btn']")
    public WebElement reviewOrderBtnPaypal;

    @FindBy(xpath = "//div[@class='mb-4 Spot_spotTableModalHoldings__gHClz']")
    public WebElement spotBalance;

    @FindBy(xpath = "//input[@class='TextInput_input__ThD99']")
    public WebElement txtSearchCurrency;

    @FindBy(xpath = "//iframe[@title='Secure payment input frame']")
    public WebElement cardFrame;

    @FindBy(xpath = "//button[contains(normalize-space(),'Wallet')]")
    public WebElement headerWallet;

    @FindBy(xpath = "(//a[normalize-space()='Deposit'])[6]")
    public WebElement btnDeposit;


    @FindBy(xpath = "//button[contains(normalize-space(),'Fiat')]")
    public WebElement btnFiatSection;

    @FindBy(xpath = "//input[@placeholder='Search by Name or Code']")
    public WebElement txtAdminSearchCurrency;

    @FindBy(xpath = "//input[@placeholder='Search by ID, TxId, etc']")
    public WebElement txtAdminSerchCurrncyFiatSec;

    @FindBy(xpath = "//button[@id='dropdown-button-dark-example1']")
    public WebElement btnActionInAdmin;

    @FindBy(xpath = "(//div[@class='CustomTooltip_iconContainer__EZa8Y'])[11]")
    public WebElement txID;

    @FindBy(xpath = "//input[@placeholder='Enter TxID']")
    public WebElement txtTXID;

    @FindBy(xpath = "//input[@id='braintree']")
    public WebElement radioBtnBraintree;

    @FindBy(xpath = "//a[contains(@role,'button')][normalize-space()='Payment Settings']")
    public WebElement optPaymentSettingAdmin;

    @FindBy(xpath = "//div[@aria-label='Paying with Card']")
    public WebElement cardBrainTree;

    @FindBy(xpath = "//div[@class='braintree-option braintree-option__paypal']")
    public WebElement paypaldBrainTree;

    @FindBy(xpath = "//iframe[@id='braintree-hosted-field-number']")
    public WebElement cardFrameBrainTree;

    @FindBy(xpath = "//iframe[@title='PayPal']")
    public WebElement paypalFrameBrainTree;

    @FindBy(xpath = "//button[normalize-space()='Save Settings']")
    public WebElement btnSaveSettingAdmin;

    @FindBy(className = "paypal-button-layout-horizontal")
    public WebElement btnPaypalCheckout;

    @FindBy(xpath = "//span[normalize-space()='Fiat Currency']")
    public WebElement menuFiatCurrency;

    @FindBy(xpath = "//span[normalize-space()='User Wallet']")
    public WebElement menuUserWallet;

    @FindBy(xpath = "//div[@class='collapse show']//li[@class='side-nav-item']")
    public WebElement listFiatCurrency;

    @FindBy(xpath = "//span[normalize-space()='Deposit']")
    public WebElement depositUserWallet;

    @FindBy(xpath = "//a[normalize-space()='here']")
    public WebElement optionHere;

    @FindBy(xpath = "//div[@class='PaymentToOptions_component_detailsItem__IVy96'])[3]")
    public WebElement walletType;

    @FindBy(xpath = "//span[normalize-space()='PayPal']")
    public WebElement paymentMethod;

    @FindBy(xpath = "(//div[@class='PaymentToOptions_component_detailsItem__IVy96'])[4]")
    public WebElement withdrawAmount;

    @FindBy(xpath = "(//div[@class='PaymentToOptions_component_detailsItem__IVy96'])[5]")
    public WebElement withdrawFee;

    @FindBy(xpath = "(//div[@class='PaymentToOptions_component_detailsItem__IVy96'])[6]")
    public WebElement withdrawTotalAmount;
    @FindBy(xpath = "(//div[@class='PaymentToOptions_component_detailsItem__IVy96'])[2]")
    public WebElement emailWithdrawDetailModal;

    @FindBy(xpath = "//div[normalize-space()='Withdrawal Details']")
    public WebElement titleWithdrawDetailsInModal;

    @FindBy(xpath = "//strong[contains(text(),'Your deposit request has been submitted successful')]")
    public WebElement depositSuccessMsg;
    @FindBy(xpath = "(//button[normalize-space()='Cancel'])[2]")
    public WebElement btnCancel;
    @FindBy(xpath = "//small[contains(normalize-space(),'Cancelled')]")
    public WebElement statusCancelled;
    @FindBy(xpath = "(//small[contains(normalize-space(),'Cancelled')])[2]")
    public WebElement paymentStatusCancelled;


    public Fiat(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void visitFiat() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        headerFiat.click();
        Thread.sleep(1000);
        elementDeposit.click();
        Thread.sleep(1000);
    }

    public void visitSpotWallet(String currency) throws InterruptedException {
        headerWallet.click();
        Thread.sleep(1000);
        elementSpot.click();
        Thread.sleep(1000);
        txtSearchCurrencySpot.sendKeys(currency);
        Thread.sleep(1000);
        currencyInTable.click();
        Thread.sleep(1000);
    }

    public void visitFiatWithdrawPage() throws InterruptedException {
        headerFiat.click();
        Thread.sleep(1000);
        elementWithdraw.click();
        Thread.sleep(2000);
    }

    public void doLoginPaypal(String email,String password) {
        try {
            txtPaypalEmail.sendKeys(email);
            btnNextPaypal.click();
            Thread.sleep(1000);
            txtPaypalPassword.sendKeys(password);
            btnLoginPaypal.click();
            Thread.sleep(4000);
            reviewOrderBtnPaypal.click();
        } catch (Exception e) {
            reviewOrderBtnPaypal.click();
        }
    }

    public void inputFiatWithdraw(String currency, String amount) throws InterruptedException {
        txtSearchCurrency.sendKeys(currency);
        Thread.sleep(1000);
        currencyEuro.click();
        Thread.sleep(500);
        txtAmount.sendKeys(amount);
        Thread.sleep(1000);
        radioBtnPaypal.click();
        btnContinue.click();

    }

    public void checkNotification() {
//        click();btnNotification.get(1).click();
//        Thread.sleep(1000);
    }

    public void clickDepositButton() {
        btnDeposit.click();
    }

    public void depositFiat(String currency, String amount) throws InterruptedException {
        JSONObject jsonObject = new JSONObject();
        Thread.sleep(500);
        txtSearchCurrency.sendKeys(currency);
        Thread.sleep(500);
        currencyEuro.click();
        Thread.sleep(500);
        txtAmount.sendKeys(amount);
        Thread.sleep(1000);
        radioBtnPaymentMethod1.click();
        btnContinue.click();
        Thread.sleep(3000);
        btnConfirm.click();
        Thread.sleep(5000);

    }

    public void inputIntoFrame(String cardNum, String expirationDate, String cvcNum) throws InterruptedException {
        txtCardNum.sendKeys(cardNum);
        Thread.sleep(1000);
        txtExpiration.sendKeys(expirationDate);
        txtCVC.sendKeys(cvcNum);
    }

    public void clickPayBtn() {
        btnPay.click();
    }

    public void visitTransactionHistory() throws InterruptedException {
        Thread.sleep(500);
        optionHere.click();
        Thread.sleep(5000);
        refreshPage();
        Thread.sleep(1000);
        btnThreeDot.click();
        Thread.sleep(1000);
        btnViewDetails.click();
        Thread.sleep(3000);
        btnModalClose.click();
        Thread.sleep(4000);
    }
    public void visitTransactionHistoryForSellCrypto() throws InterruptedException {
        Thread.sleep(500);
        optionHere.click();
        Thread.sleep(2000);
//        refreshPage();
//        Thread.sleep(1000);
//        btnThreeDot.click();
//        Thread.sleep(1000);
//        btnViewDetails.click();
//        Thread.sleep(3000);
//        btnModalClose.click();
//        Thread.sleep(4000);
    }
    public void makePaymentProcessing() throws InterruptedException {
        btnThreeDot.click();
        Thread.sleep(1000);
        btnViewDetails.click();
        Thread.sleep(3000);
        btnMakePaymentProcessing.click();
        btnConfirm.click();
    }
    public void cancelBankDepositByUser() throws InterruptedException {
        btnThreeDot.click();
        Thread.sleep(1000);
        btnViewDetails.click();
        Thread.sleep(3000);
        btnCancel.click();
        Thread.sleep(1000);
        btnConfirm.click();
    }
    public void uploadDocument(String fileAdrress) throws InterruptedException {
        btnThreeDot.click();
        Thread.sleep(1000);
        btnViewDetails.click();
        Thread.sleep(3000);
        btnUpload.click();
        Thread.sleep(1000);
        btnUpload.sendKeys(fileAdrress);
    }
    public void visitTransactionHistoryForPaypal() throws InterruptedException {
        Thread.sleep(500);
        optionHere.click();
        Thread.sleep(5000);
        for(int i=0;i<3;i++){
            refreshPage();
            Thread.sleep(2000);
        }
        btnThreeDot.click();
        Thread.sleep(1000);
        btnViewDetails.click();
        Thread.sleep(3000);
        btnModalClose.click();
        Thread.sleep(4000);
    }


    public void changeGateway(WebDriver driver2, String currency) throws InterruptedException {
        menuFiatCurrency.click();
        Thread.sleep(1000);
        listFiatCurrency.click();
        Thread.sleep(1000);
        txtAdminSearchCurrency.sendKeys(currency);
        Thread.sleep(1000);
        btnActionInAdmin.click();
        Thread.sleep(1000);
        Utils.scrolllToElement(driver2, optPaymentSettingAdmin);
        Thread.sleep(1000);
        optPaymentSettingAdmin.click();
        Thread.sleep(1000);
        radioBtnBraintree.click();
        btnSaveSettingAdmin.click();
        Thread.sleep(2000);
        driver2.quit();
    }
    public void checkHistoryAfterAdminApprovalOrFail() throws InterruptedException {
        btnThreeDot.click();
        Thread.sleep(1000);
        btnViewDetails.click();
        Thread.sleep(3000);
        btnModalClose.click();
    }
}

