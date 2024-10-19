package testrunner;

import base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Convert;
import pages.Fiat;
import pages.Login;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static base.TestBase.driver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FiatTestRunner extends Utils {
    Login login;
    Fiat fiat;
    Convert convert;


    @BeforeTest
    public void doLogin() throws InterruptedException {
        login = new Login(driver);
        fiat = new Fiat(driver);
        visitUrl(LOCAL_URL);
        login.doLogin(USER_EMAIL, USER_PASSWORD);
    }

    //------------------------------------------- Deposit Fiat--------------------------------------------------------//

    @Test(priority = 1, description = "Verify user will successfully visit deposit fiat page", enabled = false)
    public void visitFiat() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        fiat = new Fiat(driver);
        fiat.visitFiat();
//        String depositTilte = getText(fiat.titleDepositFiat);
//        click(fiat.euroBalance);
//        assertTrue(depositTilte.contains("Deposit Fiat"));
        //Assertion
//      Assert.assertFalse(fiat.btnContinue.isEnabled());
    }

    @Test(priority = 2, description = "Verify User will successfully deposit with card using Stripe gapeway")
    public void depositWithStripe() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        convert = new Convert(driver);
        fiat = new Fiat(driver);
        fiat.visitSpotWallet("Euro");
//        click(fiat.);
//        double initialBalEuroSpot = extractDecimal(getText(fiat.euroBalance));
//        double[] depositValue = {11, 12.005, 500.45789, 78.001};
//        for (int i = 0; i < depositValue.length - 2; i++) {
//            convert.btnCurrency1.click();
//            Thread.sleep(1000);
//            fiat.depositFiat("Euro", String.valueOf(depositValue[i]));
//            //Asserting value in Modal
//            assertEquals(getText(fiat.paymentMethod1), "Online Payment");
//            String expectedDepositFee = formatdecimalDigits(depositValue[i] * (0.05 / 100), 5);
//            String actualDepositFee = formatdecimalDigits(extractDecimal(getText(fiat.depositFee)), 5);
//            assertEquals(actualDepositFee, expectedDepositFee);
//            String expectGetDepositAmount = formatdecimalDigits(depositValue[i] - Double.parseDouble(actualDepositFee), 5);
//            double expectedWalletBalEuro = Double.parseDouble(Utils.formatdecimalDigits(initialBalEuroSpot + Double.parseDouble(expectGetDepositAmount), 8));
//            String actualGetDepositAmount = Utils.formatdecimalDigits(Utils.extractDecimal(getText(fiat.getDepositAmount)), 5);
//            assertEquals(actualGetDepositAmount, expectGetDepositAmount);
//            Thread.sleep(5000);
//            // Switching to frame
//            switchToFrame(fiat.cardFrame);
//            Thread.sleep(2000);
//            fiat.inputIntoFrame("4111111111111111", "233", "123");
//            switchToDefaultContent();
//            fiat.clickPayBtn();
//            Thread.sleep(2000);
//            assertEquals(getText(fiat.depositSuccessMsg), "Your deposit request has been submitted successfully.");
//            Thread.sleep(1000);
////        Assert.assertEquals(fiat.titleDepositComplt.getText(),"Deposit Completed");
//            // Visit to transaction history
//            fiat.visitTransactionHistory();
////            assertEquals(fiat.status.get(1).getText(), "Completed"); // Status completed
////            assertEquals(fiat.status.get(2).getText(), "Completed"); // Payment Status completed
////            String feeDepositDetails = String.valueOf(Utils.formatdecimalDigits(Utils.extractDecimal(getText(fiat.feeDepositDetails)), 5));
////            String getAmountDepositDetails = String.valueOf(Utils.formatdecimalDigits(Utils.extractDecimal(getText(fiat.getAmountDepositDetails)), 5));
////            assertEquals(actualDepositFee, feeDepositDetails);
////            assertEquals(actualGetDepositAmount, getAmountDepositDetails);
//            Thread.sleep(2000);
//            fiat.visitSpotWallet("Euro");
//            Thread.sleep(2000);
//            assertEquals(Utils.extractDecimal(getText(fiat.euroBalance)), expectedWalletBalEuro);
    }

    //    }
//
    @Test(priority = 3, description = "Verify admin will successfuly change payment gateway", enabled = false)
    public void changeGateway() throws InterruptedException {
        WebDriver driver2 = new FirefoxDriver();
        fiat = new Fiat(driver2);
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver2.get(ADMIN_LOCAL_URL);
        Thread.sleep(2000);
        login.doLoginAdmin(ADMIN_EMAIL, ADMIN_PASSWORD);
        fiat.menuFiatCurrency.click();
        Thread.sleep(1000);
        fiat.listFiatCurrency.click();
        Thread.sleep(1000);
        fiat.txtAdminSearchCurrency.sendKeys("EUR");
        Thread.sleep(1000);
        fiat.btnActionInAdmin.click();
        Thread.sleep(1000);
        Utils.scrolllToElement(driver2, fiat.optPaymentSettingAdmin);
        Thread.sleep(1000);
        fiat.optPaymentSettingAdmin.click();
        Thread.sleep(1000);
        fiat.radioBtnBraintree.click();
        fiat.btnSaveSettingAdmin.click();
        Thread.sleep(2000);
        driver2.quit();
    }

    @Test(priority = 4, description = "Verify user will successfully Depsoit with paypal", enabled = false)
    public void depositWithBraintree() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        Thread.sleep(1000);
        fiat = new Fiat(driver);
        convert = new Convert(driver);
        fiat.visitFiat();
        Thread.sleep(1000);
        double[] depositValue = {11, 22.05};
        for (int i = 0; i < depositValue.length; i++) {
            fiat.headerWallet.click();
            Thread.sleep(500);
            fiat.elementSpot.click();
            Thread.sleep(1000);
            fiat.txtSearchCurrencySpot.sendKeys("EUR");
            Thread.sleep(1000);
            fiat.currencyInTable.click();
            Thread.sleep(1000);
//            double initialBalEuroSpot = Utils.extractDecimal(fiat.euroBalance.getText());
            fiat.btnDeposit.click();
            Thread.sleep(1000);
            convert.btnCurrency1.click();
            Thread.sleep(2000);
            fiat.txtSearchCurrency.sendKeys("EURO");
            Thread.sleep(1000);
            fiat.currencyEuro.click();
            Thread.sleep(500);
            fiat.txtAmount.sendKeys(String.valueOf(depositValue[i]));
            Thread.sleep(1000);
//            fiat.radioBtn1.click();
            fiat.btnContinue.click();
            Thread.sleep(2000);
            //Asserting value in Modal
            assertEquals(fiat.paymentMethod1.getText(), "Online Payment");
            String expectedDepositFee = Utils.formatdecimalDigits(depositValue[i] * (0.05 / 100), 5);
            String actualDepositFee = Utils.formatdecimalDigits(Utils.extractDecimal(fiat.depositFee.getText()), 5);
//            Assert.assertEquals(actualDepositFee, expectedDepositFee);
            String expectGetDepositAmount = Utils.formatdecimalDigits(depositValue[i] - Double.parseDouble(actualDepositFee), 5);
//            double expectedWalletBalEuro = Double.parseDouble(Utils.formatdecimalDigits(initialBalEuroSpot + Double.parseDouble(expectGetDepositAmount), 8));
            String actualGetDepositAmount = Utils.formatdecimalDigits(Utils.extractDecimal(fiat.getDepositAmount.getText()), 5);
//            Assert.assertEquals(actualGetDepositAmount, expectGetDepositAmount);
            fiat.btnConfirm.click();
            Thread.sleep(10000);
            fiat.paypaldBrainTree.click();
            Thread.sleep(1000);
            switchToFrame(fiat.paypalFrameBrainTree);
            Thread.sleep(1000);
            fiat.btnPaypalCheckout.click();
            Thread.sleep(1000);

//            fiat.doLoginPaypal();
            Thread.sleep(5000);
            Thread.sleep(2000);
            switchToDefaultContent();
            Thread.sleep(3000);
            fiat.btnPay.click();
            Thread.sleep(2000);
            assertEquals(fiat.depositSuccessMsg.getText(), "Your deposit request has been submitted successfully.");
//        Thread.sleep(1000);
//        fiat.btnNotification.get(1).click();
//        Thread.sleep(1000);
//        Assert.assertEquals(fiat.titleDepositComplt.getText(),"Deposit Completed");
            Thread.sleep(500);
            fiat.optionHere.click();
            Thread.sleep(5000);
            driver.navigate().refresh();
            fiat.btnThreeDot.click();
            fiat.btnViewDetails.click();
            Thread.sleep(1000);
//            Assert.assertEquals(fiat.status.get(1).getText(), "Completed"); // Status completed
//            Assert.assertEquals(fiat.status.get(2).getText(), "Completed"); // Payment Status completed
            String feeDepositDetails = String.valueOf(Utils.formatdecimalDigits(Utils.extractDecimal(fiat.feeDepositDetails.getText()), 5));
            String getAmountDepositDetails = String.valueOf(Utils.formatdecimalDigits(Utils.extractDecimal(fiat.getAmountDepositDetails.getText()), 5));
//                Assert.assertEquals(actualDepositFee, feeDepositDetails);
//            Assert.assertEquals(actualGetDepositAmount, getAmountDepositDetails);
            Thread.sleep(2000);
            fiat.btnModalClose.click();
            Thread.sleep(1000);
            fiat.headerWallet.click();
            Thread.sleep(500);
            fiat.elementSpot.click();
            Thread.sleep(1000);
            fiat.txtSearchCurrencySpot.sendKeys("EUR");
            Thread.sleep(1000);
            fiat.currencyInTable.click();
            Thread.sleep(1000);
//                Assert.assertEquals(Utils.extractDecimal(fiat.euroBalance.getText()), expectedWalletBalEuro);
            fiat.btnDeposit.click();
        }
//        fiat.cardBrainTree.click();
//        Thread.sleep(1000);
//        driver.switchTo().frame(fiat.cardFrameBrainTree);
//        Thread.sleep(2000);
////        Utils.wait(driver,fiat.txtCardNum);
//        fiat.txtCardNumBraintree.sendKeys("4111111111111111");
//        Thread.sleep(3000);
////        fiat.txtExpirationBraintree.sendKeys("233");
//        fiat.txtCVCNumBraintree.click();
//        driver.switchTo().defaultContent();
//        fiat.btnPay.click();
//        Thread.sleep(2000);
//        Assert.assertEquals(fiat.depositSuccessMsg.getText(),"Your deposit request has been submitted successfully.");

    }




    //
//    @Test(priority = 5, description = "Verify user can successfully deposit by bank")
//    public void bankDeposit() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
//        double[] depositValue = {11, 22.05};
//        fiat = new Fiat(driver);
//        convert= new Convert(driver);
//        String fileName="./src/test/resources/value.json";
//        fiat.visitFiat();
//        for (int i = 0; i < depositValue.length - 1; i++) {
//            fiat.headerWallet.click();
//            Thread.sleep(500);
//            fiat.elementSpot.click();
//            Thread.sleep(1000);
//            fiat.txtSearchCurrencySpot.sendKeys("EUR");
//            Thread.sleep(1000);
//            fiat.currencyInTable.click();
//            Thread.sleep(1000);
//            double initialBalEuroSpot = Utils.extractDecimal(fiat.euroBalance.getText());
//            fiat.btnDeposit.click();
//            Thread.sleep(1000);
//            convert.btnCurrency1.click();
//            Thread.sleep(2000);
//            fiat.txtSearchCurrency.sendKeys("EURO");
//            Thread.sleep(1000);
//            fiat.currencyEuro.click();
//            Thread.sleep(500);
//            fiat.txtAmount.sendKeys(String.valueOf(depositValue[i]));
//            Thread.sleep(1000);
//            fiat.radioBtn2.click();
//            Thread.sleep(1000);
//            fiat.btnContinue.click();
//            fiat.btnConfirm.click();
//            Thread.sleep(1000);
//            fiat.radioBtn2.click();
//            fiat.btnSubmit.click();
//            Thread.sleep(500);
//            fiat.optionHere.click();
//            Thread.sleep(5000);
//            fiat.txtTXID.click();
//            fiat.txtTXID.sendKeys(Keys.CONTROL+"a");
//            Thread.sleep(500);
//            fiat.txtTXID.sendKeys(Keys.CONTROL+"c");
//            Thread.sleep(1000);
//            fiat.btnThreeDot.click();
//            fiat.btnViewDetails.click();
//            Thread.sleep(2000);
////            saveJson("txID",fiat.txID.getText(),fileName);
//            fiat.btnMakePaymentProcessing.click();
//            Thread.sleep(500);
//            fiat.btnConfirm.click();
//        }
//    }
//    @Test(priority = 6,enabled = false)
//    public void confirmDepositFrmAdmin() throws InterruptedException {
//        WebDriver driver3 = new FirefoxDriver();
//        fiat = new Fiat(driver3);
//        driver3.manage().window().maximize();
//        driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver3.get(ADMIN_LOCAL_URL);
//        Thread.sleep(2000);
//        fiat.doLoginAdmin(ADMIN_EMAIL,ADMIN_PASSWORD);
//        scrolllToElement(driver3,fiat.menuUserWallet);
//        Thread.sleep(1000);
//        fiat.menuUserWallet.click();
//        Thread.sleep(1000);
//        fiat.depositUserWallet.click();
//        Thread.sleep(1000);
//        fiat.btnFiatSection.click();
//        fiat.txtAdminSerchCurrncyFiatSec.click();
//        fiat.txtAdminSerchCurrncyFiatSec.sendKeys(Keys.CONTROL+"v");
//        Thread.sleep(1000);
//        fiat.btnActionInAdmin.click();
//        Thread.sleep(1000);
//        fiat.btnViewDetailsAdmin.click();
//        Thread.sleep(1000);
//        scrolllToElement(driver3,fiat.btnApproveCompleteAdmin);
//        Thread.sleep(500);
//        fiat.btnApproveCompleteAdmin.click();
//        Thread.sleep(500);
//        fiat.btnConfrimAdmin.click();
//        Thread.sleep(1000);
//        driver3.quit();
//    }
//    @Test(priority = 7,enabled = false)
//    public void checkBankDeposit() throws InterruptedException {
//        fiat= new Fiat(driver);
//        driver.navigate().refresh();
//        Thread.sleep(1000);
//        fiat.headerWallet.click();
//        Thread.sleep(500);
//        fiat.elementSpot.click();
//        Thread.sleep(1000);
//        fiat.txtSearchCurrencySpot.sendKeys("EUR");
//        Thread.sleep(1000);
//        fiat.currencyInTable.click();
//        Thread.sleep(1000);
//    }
//    //------------------------------------------- Deposit Fiat--------------------------------------------------------//
//
//    //-------------------------------------------  Withdraw Fiat--------------------------------------------------------//
    @Test(priority = 8, description = "Verify user will successfully visit fiat Withdraw Page ")
    public void visitFiatWithdraw() throws InterruptedException {
        fiat = new Fiat(driver);
        fiat.visitFiatWithdrawPage();
        assertEquals(fiat.titleDepositWithdraw.getText(), "Withdraw Fiat");
    }

    @Test(priority = 9)
    public void withDrawWithPaypal() throws InterruptedException {
        fiat = new Fiat(driver);
        convert = new Convert(driver);
        login = new Login(driver);
        convert.btnCurrency1.click();
        Thread.sleep(2000);
        double[] amountWithdrawal = {10, 12.50, 750.2, 13.60};
        for (int i = 0; i < amountWithdrawal.length - 3; i++) {
            fiat.inputFiatWithdraw("Euro", String.valueOf(amountWithdrawal[i]));
//            inputText(login.txtEmail,PAYPAL_PERSONAL_EMAIL);
            Thread.sleep(1000);
            fiat.btnContinue.click();
//            click(fiat.btnContinue);
//            Thread.sleep(4000);
//            String walletType=splitString(getText(((fiat.walletType))));
//            String withdrawAmount=splitString(getText(fiat.withdrawAmount));
//            String withdrawFee=splitString(getText(fiat.withdrawFee));
//            System.out.println(walletType);
//            System.out.println(withdrawFee);
//            System.out.println(withdrawAmount);
        }

    }

    @Test(priority = 10)
    public void withdrawalWithBank() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
        double[] withdrawValue = {11, 22.05};
        fiat = new Fiat(driver);
        convert = new Convert(driver);
        String fileName = "./src/test/resources/value.json";
        fiat.visitFiat();
        for (int i = 0; i < withdrawValue.length - 1; i++) {
//            click(fiat.headerWallet);
//            Thread.sleep(500);
//            click(fiat.elementSpot);;
//            Thread.sleep(1000);
//            inputText(fiat.txtSearchCurrencySpot,"EUR");
//            Thread.sleep(1000);
//            click(fiat.currencyInTable);
//            Thread.sleep(1000);
//            double initialBalEuroSpot = Utils.extractDecimal(getText(fiat.euroBalance));
//            click(fiat.btnDeposit);;
//            Thread.sleep(1000);
//            convert.btnCurrency1.click();
//            Thread.sleep(2000);
//            inputText(fiat.txtSearchCurrency,"EUR");
//            Thread.sleep(1000);
//            click(fiat.currencyEuro);
//            Thread.sleep(500);
//            inputText(fiat.txtAmount,String.valueOf(withdrawValue[i]));
//            Thread.sleep(1000);
//            click(fiat.radioBtn2);
//            Thread.sleep(1000);
//            click(fiat.btnContinue);
//            click(fiat.btnConfirm);;
//            Thread.sleep(1000);
//            click(fiat.radioBtn2);;
//            click(fiat.btnSubmit);;
//            Thread.sleep(500);
//            click(fiat.optionHere);;
//            Thread.sleep(5000);
//            click(fiat.txtTXID);
//            inputText( fiat.txtTXID, Keys.CONTROL+"a");
//            Thread.sleep(500);
//            inputText( fiat.txtTXID, Keys.CONTROL+"c");
//            Thread.sleep(1000);
//            click(fiat.btnThreeDot);;
//            Thread.sleep(2000);
////            saveJson("txID",fiat.txID.getText(),fileName);
//            click(fiat.btnMakePaymentProcessing);;
//            Thread.sleep(500);
//            click(fiat.btnConfirm);;
        }

    }

    @Test(priority = 11)
    public void confrimFromAdmin() throws InterruptedException {
//        WebDriver driver4 = new ChromeDriver();
//        fiat = new Fiat(driver4);
//        driver4.manage().window().maximize();
//        driver4.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver4.get(ADMIN_LOCAL_URL);
//        Thread.sleep(4000);
//        click(fiat.txtAdminEmail);
//        inputText(fiat.txtAdminEmail,"admin");
////        fiat.doLoginAdmin(ADMIN_EMAIL,ADMIN_PASSWORD);
//        Thread.sleep(1000);
//       click(fiat.menuUserWallet);
//        Thread.sleep(1000);
//        click(fiat.depositUserWallet);
//        Thread.sleep(1000);
//        click(fiat.btnFiatSection);;
//        click(fiat.txtAdminSerchCurrncyFiatSec);
//        inputText(fiat.txtAdminSerchCurrncyFiatSec,Keys.CONTROL+"v");
//        Thread.sleep(1000);
//        click(fiat.btnActionInAdmin);
//        Thread.sleep(1000);
//        click(fiat.btnViewDetailsAdmin);;
//        Thread.sleep(1000);
//        scrolllToElement(driver4,fiat.btnApproveCompleteAdmin);
//        Thread.sleep(500);
//        click(fiat.btnApproveCompleteAdmin);;
//        Thread.sleep(500);
//        click(fiat.btnConfrimAdmin);
//        Thread.sleep(1000);
//        driver4.quit();
    }

    //------------------------------------------- Withdraw Fiat--------------------------------------------------------//

}
