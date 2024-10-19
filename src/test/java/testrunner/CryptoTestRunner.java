package testrunner;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Crypto;
import pages.Fiat;
import pages.Login;
import utils.Utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class CryptoTestRunner extends Utils {
    Crypto crypto;
    Login login;
    Fiat fiat;

    @BeforeTest
    public void doLogin() throws InterruptedException {
        login = new Login(driver);
        visitUrl(LIVE_URL);
        login.doLogin(USER_EMAIL, USER_PASSWORD);
    }

    //-------------------------------------------Buy Crypto--------------------------------------------------------//
    @Test(priority = 1, description = "Verify user will successfully visit buy crypto page")
    public void visitBuyCrypto() throws InterruptedException {
        crypto = new Crypto(driver);
        crypto.visitBuyCrypto();
        assertEquals(crypto.titleBuyCrypto.getText(), "Buy Crypto");
    }

//    @Test(priority = 2, description = "Verify user will successfully buy crypto with stripe card")
//    public void executeBuyCrypto() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        fiat.visitSpotWallet("BTC");
//        crypto.btnCloseSideBarWallet.click();
//        Thread.sleep(3000);
//        double[] arr = {10.99, 100.9999, 1000.99999999};
//        for (int i = 0; i < arr.length - 2; i++) {
//            crypto.visitBuyCrypto();
//            crypto.selectCurrencies("EURO", "BTC");
//            crypto.txtFromAmount.sendKeys(String.valueOf(arr[i]));
//            fiat.radioBtnPaymentMethod1.click();
//            fiat.btnContinue.click();
//            crypto.btnSubmit.click();
//            Thread.sleep(3000);
//            fiat.btnConfirm.click();
//            Thread.sleep(10000);
//            //----------------------------------Switch to card frame-------------------------------------//
//            switchToFrame(fiat.cardFrame);
//            fiat.inputIntoFrame("4111111111111111", "233", "123");
//            switchToDefaultContent();
//            fiat.clickPayBtn();
//            Thread.sleep(2000);
//            //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//            assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//            assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//            fiat.visitTransactionHistory();
//            //----------------------------------Assertion in transaction history page-------------------------------------//
//
//            assertEquals(crypto.walletType.getText(), "Spot Wallet");
//            assertEquals(crypto.status.getText(), "Completed");
//            assertEquals(crypto.paymentStatus.getText(), "Completed");
//            fiat.visitSpotWallet("BTC");
//            crypto.btnCloseSideBarWallet.click();
//        }
//    }
//
//    @Test(priority = 3, description = "Verify admin will successfully change payment gateway")
//    public void changeGateway() throws InterruptedException {
//        WebDriver driver2 = new FirefoxDriver();
//        fiat = new Fiat(driver2);
//        login = new Login(driver2);
//        driver2.manage().window().maximize();
//        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver2.get(ADMIN_LOCAL_URL);
//        Thread.sleep(3000);
//        login.doLoginAdmin(ADMIN_EMAIL, ADMIN_PASSWORD);
//        fiat.changeGateway(driver2, "EURO");
//    }
//
//    @Test(priority = 4, description = "Verify user will successfully buy crypto with braintree paypal")
//    public void buyCryptoWithPaypal() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        refreshPage();
//        fiat.visitSpotWallet("MATIC");
//        crypto.btnCloseSideBarWallet.click();
//        Thread.sleep(3000);
//        crypto.visitBuyCrypto();
//        crypto.selectCurrencies("EURO", "MATIC");
//        crypto.txtFromAmount.sendKeys("1000.9999999");
//        fiat.radioBtnPaymentMethod1.click();
//        fiat.btnContinue.click();
//        crypto.btnSubmit.click();
//        Thread.sleep(3000);
//        fiat.btnConfirm.click();
//        Thread.sleep(20000);
//        fiat.paypaldBrainTree.click();
//        Thread.sleep(1000);
//        //----------------------------------Switch to paypal frame-------------------------------------//
//        switchToFrame(fiat.paypalFrameBrainTree);
//        fiat.btnPaypalCheckout.click();
//        Thread.sleep(1000);
//        String mainWindow = driver.getWindowHandle();
//        Set<String> allWindows = driver.getWindowHandles();
//        Iterator<String> iter = allWindows.iterator();
//        while (iter.hasNext()) {
//            String childWindow = iter.next();
//
//            if (mainWindow.equalsIgnoreCase(childWindow)) {
//                continue;
//            } else {
//                driver.switchTo().window(childWindow);
//                Thread.sleep(4000);
//            }
//        }
//        fiat.doLoginPaypal("sb-daijk27291886@personal.example.com", "Xg<5Od*[");
//        Thread.sleep(5000);
//        driver.switchTo().window(mainWindow);
//        Thread.sleep(2000);
//        switchToDefaultContent();
//        Thread.sleep(3000);
//        fiat.clickPayBtn();
//
//        //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//        assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//        assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//        fiat.visitTransactionHistoryForPaypal();
//
//        //----------------------------------Assertion in transaction history page-------------------------------------//
//
//        assertEquals(crypto.walletType.getText(), "Spot Wallet");
//        assertEquals(crypto.status.getText(), "Completed");
//        assertEquals(crypto.paymentStatus.getText(), "Completed");
//    }
//
//    @Test(priority = 5, description = "Verify user can submit buy crypto with bank deposit")
//    public void buyCryptoWithBank() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        fiat.visitSpotWallet("BTC");
//        crypto.btnCloseSideBarWallet.click();
//        crypto.visitBuyCrypto();
//        crypto.selectCurrencies("EURO", "BTC");
//        crypto.txtFromAmount.sendKeys("100.9999");
//        fiat.radioBtnPaymentMethod2.click();
//        fiat.btnContinue.click();
//        crypto.btnSubmit.click();
//        Thread.sleep(3000);
//        fiat.btnConfirm.click();
//        Thread.sleep(1000);
//        fiat.radioBtnBank1.click();
//        Thread.sleep(1000);
//        fiat.btnSubmit.click();
//        Thread.sleep(2000);
//
//        //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//        assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//        assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//
//        //----------------------------------Assertion in transaction history page-------------------------------------//
//        fiat.visitTransactionHistory();
//        Thread.sleep(1000);
//        fiat.makePaymentProcessing();
//        Thread.sleep(3000);
//        assertEquals(crypto.statusPending.getText(), "Pending");
//
//    }
//
//    @Test(priority = 6, description = "Verify admin can approve buying crypto request with bank deposit")
//    public void approveBankDepositByAdmin() throws InterruptedException {
//        WebDriver driver3 = new FirefoxDriver();
//        fiat = new Fiat(driver3);
//        login = new Login(driver3);
//        crypto = new Crypto(driver3);
//        driver3.manage().window().maximize();
//        driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver3.get(ADMIN_LOCAL_URL);
//        Thread.sleep(3000);
//        login.doLoginAdmin(ADMIN_EMAIL, ADMIN_PASSWORD);
//        crypto.menuArrowInAdmin.click();
//        Thread.sleep(1000);
//        crypto.approveBankDepositByAdmin(driver3);
//        Thread.sleep(2000);
//    }
//
//    @Test(priority = 7, description = "Verify user can buy crypto after admin approval")
//    public void checkHistoryAfterAdminApproval() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        refreshPage();
//        Thread.sleep(2000);
//        fiat.checkHistoryAfterAdminApprovalOrFail();
//        //----------------------------------Assertion in transaction history page-------------------------------------//
//        assertEquals(crypto.walletType.getText(), "Spot Wallet");
//        assertEquals(crypto.status.getText(), "Completed");
//        assertEquals(crypto.paymentStatus.getText(), "Completed");
//    }
//
//    @Test(priority = 8, description = "Verify user can cancel bank deposit request in buy crypto")
//    public void cancelBuyCryptoBankDepositByUser() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        fiat.visitSpotWallet("BTC");
//        crypto.btnCloseSideBarWallet.click();
//        crypto.visitBuyCrypto();
//        crypto.selectCurrencies("EURO", "BTC");
//        crypto.txtFromAmount.sendKeys("100.9999");
//        fiat.radioBtnPaymentMethod2.click();
//        fiat.btnContinue.click();
//        crypto.btnSubmit.click();
//        Thread.sleep(3000);
//        fiat.btnConfirm.click();
//        Thread.sleep(1000);
//        fiat.radioBtnBank1.click();
//        Thread.sleep(1000);
//        fiat.btnSubmit.click();
//        Thread.sleep(2000);
//
//        //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//        assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//        assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//
//        //----------------------------------Assertion in transaction history page-------------------------------------//
//        fiat.visitTransactionHistory();
//        Thread.sleep(1000);
//        fiat.cancelBankDepositByUser();
//        Thread.sleep(2000);
//        //----------------------------------Assertion after cancel bank deposit request-------------------------------------//
//        assertEquals(fiat.statusCancelled.getText(), "Cancelled");
//        assertEquals(fiat.paymentStatusCancelled.getText(), "Cancelled");
//    }
//
//    @Test(priority = 9, description = "Verify buy crypto after admin failed bank deposit request.")
//    public void makeFailBuyCryptoByAdmin() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        fiat.visitSpotWallet("BTC");
//        crypto.btnCloseSideBarWallet.click();
//        crypto.visitBuyCrypto();
//        crypto.selectCurrencies("EURO", "BTC");
//        crypto.txtFromAmount.sendKeys("100.9999");
//        fiat.radioBtnPaymentMethod2.click();
//        fiat.btnContinue.click();
//        crypto.btnSubmit.click();
//        Thread.sleep(3000);
//        fiat.btnConfirm.click();
//        Thread.sleep(1000);
//        fiat.radioBtnBank1.click();
//        Thread.sleep(1000);
//        fiat.btnSubmit.click();
//        Thread.sleep(2000);
//
//        //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//        assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//        assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//
//        //----------------------------------Assertion in transaction history page-------------------------------------//
//        fiat.visitTransactionHistory();
//        Thread.sleep(1000);
//        fiat.makePaymentProcessing();
//    }
//
//    @Test(priority = 10, description = "Verify buy crypto after admin failed bank deposit request.")
//    public void makeFailByAdmin() throws InterruptedException {
//        WebDriver driver5 = new FirefoxDriver();
//        fiat = new Fiat(driver5);
//        login = new Login(driver5);
//        crypto = new Crypto(driver5);
//        driver5.manage().window().maximize();
//        driver5.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver5.get(ADMIN_LOCAL_URL);
//        Thread.sleep(3000);
//        login.doLoginAdmin(ADMIN_EMAIL, ADMIN_PASSWORD);
//        crypto.menuArrowInAdmin.click();
//        Thread.sleep(1000);
//        crypto.makeFailBankDepositByAdmin(driver5, "Fraud");
//        Thread.sleep(2000);
//    }
//
//    @Test(priority = 11, description = "Verify transaction history after making fail by admin")
//    public void checkAfterFailByAdmin() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        refreshPage();
//        Thread.sleep(2000);
//        fiat.checkHistoryAfterAdminApprovalOrFail();
//        //----------------------------------Assertion in transaction history page-------------------------------------//
//        assertEquals(crypto.walletType.getText(), "Spot Wallet");
//        assertEquals(crypto.statusFailed.getText(), "Failed");
//        assertEquals(crypto.paymentStatusFailed.getText(), "Failed");
//    }
//
//    @Test(priority = 12, description = "Verify user will successfully buy crypto with wallet balance")
//    public void executeBuyCryptoWalletBalance() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        crypto.visitSpotWalletBuySellCrypto("SGD", "MATIC");
//        double[] arr = {10.99, 100.9999, 1000.99999999};
//        for (int i = 0; i < arr.length - 3; i++) {
//            crypto.visitBuyCrypto();
//            crypto.selectCurrencies("SGD", "MATIC");
//            crypto.txtFromAmount.sendKeys(String.valueOf(arr[i]));
//            fiat.radioBtnPaymentMethod3.click();
//            fiat.btnContinue.click();
//            crypto.btnSubmit.click();
//            Thread.sleep(3000);
//            fiat.btnConfirm.click();
//            Thread.sleep(2000);
//            //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//            assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//            assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//            fiat.visitTransactionHistory();
//
//            //----------------------------------Assertion in transaction history page-------------------------------------//
//
//            assertEquals(crypto.walletType.getText(), "Spot Wallet");
//            assertEquals(crypto.status.getText(), "Completed");
//            assertEquals(crypto.paymentStatus.getText(), "Completed");
//            Thread.sleep(2000);
//            crypto.visitSpotWalletBuySellCrypto("SGD", "MATIC");
//        }
//
//    }
//    @Test(priority =13,description = "Verify user can buy crypto by entering amount in crypto")
//    public void enterAmountInCrypto() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
////        crypto.visitSpotWalletBuySellCrypto("SGD", "MATIC");
//            crypto.visitBuyCrypto();
//            crypto.selectCurrencies("SGD", "MATIC");
//            crypto.txtToAmount.sendKeys("100");
//            fiat.radioBtnPaymentMethod3.click();
//            fiat.btnContinue.click();
//            crypto.btnSubmit.click();
//            Thread.sleep(3000);
//            fiat.btnConfirm.click();
//            Thread.sleep(2000);
//            //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//            assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//            assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//            fiat.visitTransactionHistory();
//
//            //----------------------------------Assertion in transaction history page-------------------------------------//
//
//            assertEquals(crypto.walletType.getText(), "Spot Wallet");
//            assertEquals(crypto.status.getText(), "Completed");
//            assertEquals(crypto.paymentStatus.getText(), "Completed");
//            Thread.sleep(2000);
//            crypto.visitSpotWalletBuySellCrypto("SGD", "MATIC");
//
//    }
//    @Test(priority = 14, description = "Verify user can successfully buy crypto with funding wallet")
//    public void buyCryptoWithFundingWallet() throws InterruptedException {
//        fiat = new Fiat(driver);
//        crypto = new Crypto(driver);
//        crypto.visitFundingWalletBuySellCrypto("SGD","MATIC");
//        crypto.visitBuyCrypto();
//        crypto.radioBtnFunding.click();
//        Thread.sleep(1000);
//        crypto.selectCurrencies("SGD", "MATIC");
//        crypto.txtFromAmount.sendKeys("100.9999");
//        fiat.radioBtnPaymentMethod3.click();
//        fiat.btnContinue.click();
//        crypto.btnSubmit.click();
//        Thread.sleep(3000);
//        fiat.btnConfirm.click();
//        Thread.sleep(2000);
//        //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//        assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//        assertEquals(crypto.buyCryptoReqstSubmitMsg.getText(), "Your buy crypto request has been submitted successfully.");
//        fiat.visitTransactionHistory();
//
//        //----------------------------------Assertion in transaction history page-------------------------------------//
//
//        assertEquals(crypto.walletType.getText(), "Funding Wallet");
//        assertEquals(crypto.status.getText(), "Completed");
//        assertEquals(crypto.paymentStatus.getText(), "Completed");
//        Thread.sleep(2000);
//        crypto.visitFundingWalletBuySellCrypto("SGD", "MATIC");
//
//    }
//        //-------------------------------------------Buy Crypto--------------------------------------------------------//
//
//        //-------------------------------------------Sell Crypto--------------------------------------------------------//
//
//        @Test(priority = 15,description = "Verify user will successfully visit sell crypto page")
//        public void visitSellCrypto() throws InterruptedException {
//            fiat = new Fiat(driver);
//            crypto = new Crypto(driver);
//            crypto.visitSellCrypto();
//            assertEquals(crypto.titleSellCrypto.getText(),"Sell Crypto");
//        }
//        @Test(priority = 16, description = "Verify user can successfully sell crypto")
//        public void sellCryptoWithSpotWallet() throws InterruptedException {
//            fiat = new Fiat(driver);
//            crypto = new Crypto(driver);
////            fiat.txtSearchCurrencySpot.clear();
//            crypto.visitSpotWalletBuySellCrypto("BTC", "EURO");
//            crypto.visitSellCrypto();
//            crypto.selectCurrencies("BTC", "EURO");
//            crypto.txtFromAmount.sendKeys("0.0005");
//            Thread.sleep(2000);
//            fiat.btnContinue.click();
//            crypto.btnSubmit.click();
//            Thread.sleep(2000);
//            assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//            assertEquals(crypto.sellCryptoReqstSubmitMsg.getText(), "Your sell crypto request has been submitted successfully.");
//            fiat.visitTransactionHistoryForSellCrypto();
//            assertEquals(crypto.walletType.getText(), "Spot Wallet");
//            assertEquals(crypto.status.getText(), "Completed");
//            Thread.sleep(2000);
//            crypto.walletType.click();
//            Thread.sleep(3000);
//            fiat.btnModalClose.click();
//            Thread.sleep(1000);
//            crypto.visitSpotWalletBuySellCrypto("BTC", "EURO");
//        }
//        @Test(priority = 17, description = "Verify user will successfully sell crypto with funding wallet")
//        public void sellCryptoWithFundingWallet() throws InterruptedException {
//            fiat = new Fiat(driver);
//            crypto = new Crypto(driver);
////            fiat.txtSearchCurrencySpot.clear();
//            crypto.visitFundingWalletBuySellCrypto("MATIC","EURO");
//            crypto.visitSellCrypto();
//            Thread.sleep(1000);
//            crypto.radioBtnFunding.click();
//            Thread.sleep(1000);
//            crypto.selectCurrencies("MATIC", "EURO");
//            crypto.txtFromAmount.sendKeys("100.9999");
//            Thread.sleep(2000);
//            fiat.btnContinue.click();
//            crypto.btnSubmit.click();
//            Thread.sleep(2000);
//            //----------------------------------Assertion after buy crypto success-------------------------------------//
//
//            assertEquals(crypto.reqstSubmitSuccessMsg.getText(), "Success");
//            assertEquals(crypto.sellCryptoReqstSubmitMsg.getText(), "Your sell crypto request has been submitted successfully.");
//            fiat.visitTransactionHistoryForSellCrypto();
//
//            assertEquals(crypto.walletType.getText(), "Funding Wallet");
//            assertEquals(crypto.status.getText(), "Completed");
//            assertEquals(crypto.paymentStatus.getText(), "Completed");
//            crypto.walletType.click();
//            Thread.sleep(3000);
//            fiat.btnModalClose.click();
//            Thread.sleep(1000);
//            crypto.visitFundingWalletBuySellCrypto("MATIC","EURO");
//
//        }
//        //-------------------------------------------Sell Crypto--------------------------------------------------------//
//

    }

