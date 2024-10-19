package testrunner;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Convert;
import pages.Login;
import utils.Utils;

import java.util.ArrayList;

public class ConvertTestRunner extends TestBase {
    Login login;
    Convert convert;
    //    @Test(priority = 1, description = "Login with valid credentials")
    @Test
    public void doLogin() throws InterruptedException {
        convert=new Convert(driver);
        Login login= new Login(driver);
        Utils.url();
        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/");
        Thread.sleep(1000);
//        login.btnNext.click();



//        Actions actions= new Actions(driver);
//        actions.sendKeys(Keys.CONTROL+"t").perform();
//        driver.get(Utils.getLiveUrl());
//        login.doLogin("tradexuser007@mailinator.com","Tanvirmitul0+");
//        Thread.sleep(1000);
//        Assert.assertEquals(convert.titleDashboard.getText(),"Dashboard");
//        Thread.sleep(500);
    }

    //------------------------------------------- Convert Market--------------------------------------------------------

//    @Test(priority = 1, description = "Verify that user can successfully visit the trade convert page.")
//    public void visitConvert() throws InterruptedException {
//        convert= new Convert(driver);
//        convert.visitMarket();
//        Thread.sleep(1000);
//        Assert.assertEquals(convert.titleConvert.getText(), "Convert");
//        Assert.assertEquals(convert.currencyBTC.getText(),"BTC");
//        Assert.assertEquals(convert.currencyUSDT.getText(),"USDT");
//        Assert.assertFalse(convert.btnSubmit.isEnabled());
//        Thread.sleep(500);
//    }
    @Test(priority = 2, description = "Verify that user can successfully convert currency from From currency.")
    public void convertSuccessful() throws InterruptedException {
        //Visit Market
        convert=new Convert(driver);
        driver.get(Utils.getLocalashboardUrl());
        convert.visitMarket();
        // Performing conversion in From
        double amount[]={0.01,1.00098,2.4656465465464,2};
        for(int i=0;i< amount.length;i++){
            double expectFromBalence=Utils.formatdecimal8(Utils.splitDecimal2(convert.balanAbvTxtFrom.getText())-amount[i]);
            double toBalence=Utils.splitDecimal2(convert.balnToPlacholder.getText());
            convert.doConvert(String.valueOf(amount[i]));
            convert.button.get(16).click(); // Preview Conversion button
            Thread.sleep(2500);
            convert.button.get(17).click();  //Confirm button
            Assert.assertEquals(convert.msgOrderPlaced.getText(),"Order Placed");
            Assert.assertEquals(convert.msgConvertSuccess.getText(),"Your convert order placed successfully. You will be notified when it is completed.");
            double rate=Utils.splitDecimalEqual3(convert.rates.get(0).getText()); // Rate in modal in market
//            double convertFee=Utils.splitDecimal(convert.rates.get(3).getText());
//            int expectedGetAmount=(int) ((rate*amount[i])-convertFee);
            double actualGetAmount=Utils.extractDecimal1(convert.rates.get(4).getText()); // Actual get amount
//            Assert.assertEquals((int)actualGetAmount,expectedGetAmount);
            Thread.sleep(1000);
            double actualFromBalence=Utils.splitDecimal2(convert.balanAbvTxtFrom.getText());
            double actualToBalence=Utils.splitDecimal2(convert.balnToPlacholder.getText());
            double expectToBalence=Utils.formatdecimal8(toBalence+actualGetAmount);
            Assert.assertEquals(actualFromBalence,expectFromBalence);
            Assert.assertEquals(actualToBalence,expectToBalence);
            convert.btnOk.click();
        }
        convert.btnToggle.click();
        Thread.sleep(2000);

        // Performing conversion in From
        int count=0;
        double amount2[] = {700.5464654, 44545, 5566.454545545455, 45000};
        for(int i=0;i< amount2.length;i++) {
            double expectFromBalence = Utils.formatdecimal8(Utils.splitDecimal2(convert.balanAbvTxtFrom.getText()) - amount2[i]);
            double toBalence = Utils.splitDecimal2(convert.balnToPlacholder.getText());
            convert.doConvert(String.valueOf(amount2[i]));
            convert.button.get(16).click(); // Preview Conversion button
            Thread.sleep(1000);
            convert.button.get(17).click();  //Confirm button
            Assert.assertEquals(convert.msgOrderPlaced.getText(), "Order Placed");
            Assert.assertEquals(convert.msgConvertSuccess.getText(), "Your convert order placed successfully. You will be notified when it is completed.");
            double rate=Utils.splitDecimalEqual3(convert.rates.get(0).getText()); // Rate in modal in market
            System.out.println(rate);
//            double convertFee = Utils.splitDecimal(convert.rates.get(3).getText());
//            int expectedGetAmount = (int) ((rate * amount2[i]) - convertFee);
            double actualGetAmount = Utils.extractDecimal1(convert.rates.get(4).getText());
//            Assert.assertEquals((int) actualGetAmount, expectedGetAmount);
            Thread.sleep(1000);
            Thread.sleep(500);
            convert.btnOk.click();
            double actualFromBalence = Utils.splitDecimal2(convert.balanAbvTxtFrom.getText());
            double actualToBalence = Utils.splitDecimal2(convert.balnToPlacholder.getText());
            double expectToBalence = Utils.formatdecimal8(toBalence + actualGetAmount);
            Assert.assertEquals(actualFromBalence, expectFromBalence);
            Assert.assertEquals(actualToBalence, expectToBalence);
        }
    }
//    @Test(enabled = false)
//    public void checkConvert() throws InterruptedException, FileNotFoundException {
//        Login login= new Login(driver);
//        driver.get(Utils.getLocalashboardUrl());
//        Thread.sleep(2000);
//        convert= new Convert(driver);
//        convert.tradeHeader.click();
//        Thread.sleep(1000);
//        convert.menuConvert.click();
//        Thread.sleep(1000);
//        convert.btnToggle.click();
//        Thread.sleep(1000);
//        File file=new File("/home/tanvirmitul/Automation/TRADEX/value");
//        Scanner scanner= new Scanner(file);
//        while (scanner.hasNext()){
//            convert.doConvert(String.valueOf(scanner.next()));
//            convert.btnConfirm.click();
//            Thread.sleep(2000);
//            convert.btnOk.click();
//        }
////        double arr[]={70000,70000,70000,70000,70000,70000,70000,70000,70000,70000,70000,70000,70000,70000,70000};
////        for(int i=0;i< arr.length;i++){
////            convert.doConvert(String.valueOf(arr[i]));
////            convert.btnConfirm.click();
////            Thread.sleep(2000);
////            convert.btnOk.click();
////        }
//
//
//
////        login.doLogin("tradexuser007@mailinator.com","Tanvirmitul0-1996");
////        Thread.sleep(1000);
////        convert= new Convert(driver);
////        convert.headerTrade.click();
//    }
//    @Test(priority = 3,description = "Verify that user can successfully select desireable currency from 'From' & placeholder.")
//    public void selectCurrency() throws InterruptedException {
//        // Visit Market
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//
//        convert.visitMarket();
//        Thread.sleep(1000);
//
//        // Select currency
//        convert.btncurrencyFrom.click();
//        Thread.sleep(500);
//        convert.currencyETH.click();
//        Thread.sleep(500);
//        convert.btncurrencyTo.click();
//        Thread.sleep(500);
//        convert.currencyMATIC.click();
//    }
//    @Test(priority = 4,description = "Verify currency conversion total convert time.")
//    public void currencyConvertTime() throws InterruptedException {
//        // Visit Market
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert.visitMarket();
//
//        // Checking conversion time
//        convert.doConvert("0.05");
//        convert.button.get(16).click(); // Preview Conversion button
//        Thread.sleep(35000);
//        Assert.assertEquals(convert.btnConfirm.getText(),"Refresh Quote");
//    }
//    @Test(priority = 5)
//    public void validationMsg() throws InterruptedException {
//        // Visit market
//        convert=new Convert(driver);
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert.visitMarket();
//
//        // Checking less than minimum limit validation message in Market
//        convert.txtFrom.sendKeys("-1");
//        Assert.assertEquals(convert.balnLimitValMsg.get(0).getText(),"Amount is too small");
//        convert.txtFrom.clear();
//
//        // Checking greater than maximum limit validation message in Market
//        convert.txtFrom.sendKeys("1001");
//        Assert.assertEquals(convert.balnLimitValMsg.get(0).getText(),"Amount exceeded");
//        convert.txtFrom.clear();
//
//        // Checking greater than available balance validation message in Market
//        convert.txtFrom.sendKeys("100");
//        Assert.assertEquals(convert.balnLimitValMsg.get(0).getText(),"You do not have enough fund");
//    }
//
//    //------------------------------------------- Convert Market--------------------------------------------------------
//
//
//    //------------------------------------------- Convert Limit--------------------------------------------------------
//
//
//
//    @Test(priority = 6, description = "Verify that user can successfully visit to convert limit")
//    public void visitConvertLimit() throws InterruptedException {
//        // Visit Limit
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert.visitLimit();
//        String backColor=convert.tabLimit.getCssValue("background-color");
//        Assert.assertEquals(Color.fromString(backColor).asHex(),"#353945");
//        Thread.sleep(500);
//    }
//    @Test(priority = 7)
//    public void verifyLimitConvert() throws InterruptedException {
//        // Visit Limit
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert= new Convert(driver);
//        convert.visitLimit();
//        int max=Integer.MIN_VALUE;
//
//        double arr[]={0.0098,1.986646,2.464645664};
//        int count=0;
//
//        // Check conversion in limit
//        for(int i=0;i< arr.length;i++){
//            convert.txtFrom.sendKeys(String.valueOf(arr[i]));
//            Thread.sleep(1000);
//            double expectFromBalence = Utils.formatdecimal8(Utils.splitDecimal2(convert.balanAbvTxtFrom.getText()) - arr[i]);
//            convert.balnAbvPlachlder.get(1).click();// Market prize above Convert prize placeholder in Limit
//            Thread.sleep(1000);
//            double prize=Utils.splitDecimal2(convert.balnAbvPlachlder.get(1).getText())+20000;
//            convert.placeholderConvertPrize.clear();
//            Thread.sleep(1000);
//            convert.placeholderConvertPrize.sendKeys(String.valueOf(prize));
//            Thread.sleep(1000);
//            double convertPrize= Utils.formatdecimal8(Double.parseDouble(convert.placeholderConvertPrize.getAttribute("value")));
//            double exchangeAmount=Utils.formatdecimal8(arr[i]*convertPrize);
//            Thread.sleep(1000);
//            double balnToplaceholder=Utils.formatdecimal8(Double.parseDouble(convert.txtTo.getAttribute("value")));
//            Thread.sleep(1000);
//            Assert.assertEquals(exchangeAmount,balnToplaceholder);
//            convert.btnSetting.click();
//            Thread.sleep(1000);
//            convert.expireDrpdwn.click(); // expire date dropdown icon
//            Thread.sleep(1000);
//            convert.expireDrpDownElemnt.get(0).click();   // Expiration date 1 in expiration drop-down
//            convert.button.get(19).click(); // Cross button in expiration
//            convert.btnPlaceHolder.click();
//            Thread.sleep(1000);
//            double exchangeRate = Utils.extractDecimal2(convert.rates.get(1).getText()); //Exchange rate in Limit modal
//            Assert.assertEquals(convertPrize,exchangeRate);
//            double actualGetAmount=Utils.extractDecimal3(convert.rates.get(4).getText()); // Actual get amount in Limit modal.
//            double convertFee=Utils.extractDecimal3(convert.rates.get(3).getText());
//            double expectedGetAmount=Utils.formatdecimal8(balnToplaceholder-convertFee);
//            Assert.assertEquals(expectedGetAmount,actualGetAmount);
//            convert.button.get(19).click(); // Confirm button in Limit modal
//            Thread.sleep(1000);
//            convert.btnOk2.click(); //Ok button
//            Thread.sleep(1000);
//
//            // Check notification
//            convert.button.get(4).click(); // Notification icon
//            Thread.sleep(1000);
//            Assert.assertEquals(convert.titleOrderPlaced.getText(),"Convert Order Placed");
//            convert.button.get(5).click(); // Clear all button in notification body
//            Thread.sleep(1000);
//
//            // Check placeholder balance
//            double actualFromBaln=Utils.formatdecimal8(Utils.splitDecimal2(convert.balanAbvTxtFrom.getText()));
//            Assert.assertEquals(expectFromBalence,actualFromBaln);
//            convert.txtFrom.clear();
//            Thread.sleep(1000);
//            convert.txtFrom.click();
//            Thread.sleep(1000);
//
//            // Cancel order
//            convert.btnConvertHistory.click();
//            Thread.sleep(1000);
//            convert.menuOpenOrder.click();
//            Thread.sleep(2000);
//            convert.button.get(15).click(); // Cancel button
////            convert.button.get(22).click();
//            convert.buttonOK.click();
//            Thread.sleep(3000);
//            convert.tradeHeader.click();
//            convert.menuConvert.click();
//            convert.tabLimit.click();
//            Thread.sleep(1000);
//        }
//    }
//
//   @Test(priority = 8, description = "Verify 'From' placeholder balance is updated after cancel open orders.")
//   public void checkCancelBalance() throws InterruptedException {
//       // Visit limit page
////       driver.get("http://localhost:3001/login");
//       driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//       convert= new Convert(driver);
//       convert.visitLimit();
//
//       // Check balance after cancel open order
//       String balnFromPlaceholder=convert.balanAbvTxtFrom.getText();
//       convert.txtFrom.sendKeys(String.valueOf(0.0098));
//       Thread.sleep(1000);
//       convert.balnAbvPlachlder.get(1).click();// Market prize above Convert prize placeholder in Limit
//       Thread.sleep(1000);
//       convert.placeholderConvertPrize.sendKeys("989");
//       Thread.sleep(1000);
//       convert.btnSetting.click();
//       Thread.sleep(1000);
//       convert.expireDrpdwn.click(); // expire date dropdown
//       Thread.sleep(1000);
//       convert.expireDrpDownElemnt.get(0).click();   // Expiration date 1 in expiration drop-down
//       convert.button.get(19).click(); // Cross button in expiration
//       convert.btnPlaceHolder.click();
//       Thread.sleep(1000);
//       convert.button.get(19).click(); // Confirm button in Limit modal
//       Thread.sleep(1000);
//       convert.btnOk2.click(); //Ok button
//       Thread.sleep(1000);
//       convert.button.get(4).click(); // Notification icon
//       Thread.sleep(500);
//       convert.button.get(5).click(); // Clear all button in notification body
//       Thread.sleep(1000);
//       convert.txtFrom.click();
//
//       // Visit convert history page
//       convert.btnConvertHistory.click();
//       Thread.sleep(2000);
//       Assert.assertEquals(convert.titleConvertHistory.getText(),"Convert History");
//       Assert.assertEquals(convert.convertStatusOpen.getText(),"Open");
//
//       //Cancel Order
//        convert.menuOpenOrder.click();
//        Thread.sleep(1000);
//        Assert.assertEquals(convert.titleOpenOrder.getText(),"Open Orders");
//        Assert.assertEquals(convert.button.get(15).getText(),"Cancel");
//        convert.button.get(15).click(); // Cancel button
//        convert.button.get(22).click(); // Confirm button in cancel order modal
//       Thread.sleep(1500);
////       convert.button.get(4).click(); // Notification icon
//       convert.button.get(4).click();
//       Thread.sleep(3000);
//
//       Assert.assertEquals(convert.titleCancelledOrder.getText(),"Convert Cancelled");
//       convert.button.get(5).click(); // Clear all button in notification body
//       Thread.sleep(1000);
////
//       // Visit limit to check page
//       convert.tradeHeader.click();
//       Thread.sleep(1000);
//       convert.menuConvert.click();
//       Thread.sleep(1000);
//       convert.tabLimit.click();
//       Thread.sleep(2000);
//       Assert.assertEquals(balnFromPlaceholder,convert.balanAbvTxtFrom.getText());
//   }
//   @Test(priority = 9, description = "Verify currency those have pair in From text box.")
//   public void availableCurrnFrom() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
//       // Visit limit page
//       String fileName="./src/test/resources/Value.json";
//       Login login= new Login(driver);
////       driver.get("http://localhost:3001/login");
//       driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//       Thread.sleep(2000);
//       convert= new Convert(driver);
//       convert.tradeHeader.click();
//       Thread.sleep(1000);
//       convert.menuConvert.click();
//       Thread.sleep(1000);
//       convert.tabLimit.click();
//       Thread.sleep(1500);
//       convert.btnCurrency.get(3).click(); // Select currency button in From
//       String str[]={"BTC","ETH","MATIC","USDT"};
//
//       for(String currency: str ){
//           convert.searchTextbox.sendKeys(currency);
//           Thread.sleep(2000);
//           Utils.saveJson(convert.currencyTagName.get(1).getText(),fileName);
//           Thread.sleep(2000);
//           Assert.assertEquals(convert.currencyTagName.get(1).getText(),Utils.readJSONFile(fileName));
//           convert.searchTextbox.clear();
//           Thread.sleep(1000);
//       }
//       convert.button.get(20).click(); // Cross button in select currency modal
//       Thread.sleep(1000);
//   }
//   @Test(priority = 9,enabled = false)
//    public void availabCurrencyTo() throws InterruptedException, IOException, ParseException, org.json.simple.parser.ParseException {
//       String fileName="./src/test/resources/Variable.json";
////       driver.get("http://localhost:3001/login");
//       driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//       convert.visitLimit();
//        String str[]={"BTC","ETH","MATIC","USDT"};
//        for(int i=0;i< str.length-3;i++ ){
//            convert.button.get(14).click(); // Select currency button in From
//            convert.searchTextbox.clear();
//            convert.searchTextbox.sendKeys(str[i]);
//            Thread.sleep(1000);
//            Utils.saveJson(convert.currencyTagName.get(1).getText(),fileName);
//            Thread.sleep(1000);
//            convert.currencyTagName.get(1).click();
//            Thread.sleep(3000);
//            String readCurrency=Utils.readJSONFile(fileName);
//            System.out.println(readCurrency);
//            if(readCurrency.equals("BTC")){
//                convert.button.get(17).click(); // Select currency button in To
//                String cur[]={"USDT","Ether"};
//                for(String curr:cur){
//                    convert.searchTextbox.sendKeys(curr);
//                    Thread.sleep(1000);
//                    Utils.saveJson(convert.currencyTagName.get(1).getText(),fileName);
//                    Thread.sleep(1000);
//                    Assert.assertEquals(convert.currencyTagName.get(1).getText(),Utils.readJSONFile(fileName));
//                    convert.searchTextbox.clear();
//                    Thread.sleep(1000);
//                }
//                convert.button.get(20).click(); // Cross button in select currency modal
//                Thread.sleep(1000);
//            }
////            if(Utils.readJSONFile(fileName)=="USDT"){
////                convert.button.get(17).click(); // Select currency button in To
////                String cur[]={"BTC","ETHER"};
////                for(String curr:cur){
////                    convert.searchTextbox.sendKeys(curr);
////                    Thread.sleep(1000);
////                    Utils.saveJson(convert.currencyTagName.get(1).getText(),fileName);
////                    Thread.sleep(1000);
////                    Assert.assertEquals(convert.currencyTagName.get(1).getText(),Utils.readJSONFile(fileName));
////                    convert.searchTextbox.clear();
////                    Thread.sleep(1000);
////                }
////            }
////            if(Utils.readJSONFile(fileName)=="ETH"){
////                convert.button.get(17).click(); // Select currency button in To
////                String cur[]={"BTC","MATIC","USDT"};
////                for(String curr:cur){
////                    convert.searchTextbox.sendKeys(curr);
////                    Thread.sleep(1000);
////                    Utils.saveJson(convert.currencyTagName.get(1).getText(),fileName);
////                    Thread.sleep(1000);
////                    Assert.assertEquals(convert.currencyTagName.get(1).getText(),Utils.readJSONFile(fileName));
////                    convert.searchTextbox.clear();
////                    Thread.sleep(1000);
////                }
////            }
////            if(Utils.readJSONFile(fileName)=="MATIC"){
////                convert.button.get(17).click(); // Select currency button in To
////                String cur[]={"ETH"};
////                for(String curr:cur){
////                    convert.searchTextbox.sendKeys(curr);
////                    Thread.sleep(1000);
////                    Utils.saveJson(convert.currencyTagName.get(1).getText(),fileName);
////                    Thread.sleep(1000);
////                    Assert.assertEquals(convert.currencyTagName.get(1).getText(),Utils.readJSONFile(fileName));
////                    convert.searchTextbox.clear();
////                    Thread.sleep(1000);
////                }
////            }
//
//        }
//
//
//    }
//    @Test(priority = 10,description = "Verify From text box validation message with minimum, less than minimum, maximum, greater than maximum, available balaence, greater than available in Limit")
//    public void currencyValidationMessage() throws InterruptedException {
//        //Visit Limit
//        convert=new Convert(driver);
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert.visitLimit();
//
//        // Checking validation message with minimum & less than minimum limit  in Limit
//        convert.txtFrom.sendKeys("0.00098");
//        convert.txtFrom.clear();
//        convert.txtFrom.sendKeys("-1");
//        Assert.assertEquals(convert.balnLimitValMsg.get(2).getText(),"Amount is too small");
//        convert.txtFrom.clear();
//
//        // Checking validation message with greater than maximum limit validation message in Limit
//        convert.txtFrom.sendKeys("1001");
//        Assert.assertEquals(convert.balnLimitValMsg.get(2).getText(),"Amount exceeded");
//        convert.txtFrom.clear();
//
//        // Checking greater than available balance validation message in Limit
//        convert.txtFrom.sendKeys("100");
//        Assert.assertEquals(convert.balnLimitValMsg.get(2).getText(),"You do not have enough fund");
//    }
//    @Test (priority = 11, description = "Verify the toggle button.")
//    public void checkToggle() throws InterruptedException {
//        //Visit Limit
//        convert=new Convert(driver);
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert.visitLimit();
//
//        //Checking toggle
//        String currencyFrom=convert.btnCurrency.get(3).getText(); // Currency button in From
//        String currencyTo=convert.btnCurrency.get(6).getText();   // Currency button in To
//        convert.btnCurrency.get(5).click(); // Clicking toggle button
//        Thread.sleep(1000);
//        Assert.assertEquals(currencyTo,convert.btnCurrency.get(3).getText());
//        Assert.assertEquals(currencyFrom,convert.btnCurrency.get(6).getText());
//    }
//
//    @Test(priority = 12,description = "Verify 'From' currency available balance will be placed in placeholder.")
//    public void clickingLabel() throws InterruptedException {
//        //Visit Limit
//        convert=new Convert(driver);
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert.visitLimit();
//
//        //Click above balance in From text box
//        String balanceFrom= String.valueOf(Utils.formatdecimal8(Utils.splitDecimal2(convert.balanAbvTxt.get(0).getText())));
//        convert.balanAbvTxt.get(0).click();
//        Thread.sleep(500);
//        Assert.assertEquals(String.valueOf(Utils.formatdecimal8(Double.parseDouble(convert.txtFrom.getAttribute("value")))),balanceFrom);
//
//     //Click above balance in To text box
//        String balanceTo= String.valueOf(Utils.splitDecimal2(convert.balanAbvTxt.get(2).getText()));
//        convert.txtTo.clear();
//        convert.balanAbvTxt.get(2).click();
//        Thread.sleep(500);
//        Assert.assertEquals(convert.txtTo.getAttribute("value"),balanceTo);
//
//    }
//
//    @Test(priority = 13,description = "Verify select currency in 'To' text-box")
//    public void selectCurrencyTo() throws InterruptedException {
//        //Visit Limit
//        convert = new Convert(driver);
////        driver.get("http://localhost:3001/login");
//        driver.get("https://exchange-tradex.nftarttoken.xyz/dashboard");
//        convert.visitLimit();
//        Thread.sleep(1500);
//
//        //Select currency in To
//        convert.btnCurrency.get(6).click();
//        Thread.sleep(1000);
//        convert.currencyTagName.get(2).click();
//        Thread.sleep(1000);
//        Assert.assertFalse(convert.btnPlaceHolder.isEnabled());
//
//    }

    //------------------------------------------- Convert Limit--------------------------------------------------------



}
