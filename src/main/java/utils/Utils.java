package utils;
import base.TestBase;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils  extends TestBase {
    public static final String USER_PROPERTIES_LOCATION = "./src/test/resources/properties/user.properties";
    public static final String ADMIN_PROPERTIES_LOCATION = "./src/test/resources/properties/admin.properties";
    public static final String LIVE_URL = getEnvironmentConfig(USER_PROPERTIES_LOCATION,"liveUrl");
    public static final String LOCAL_URL = getEnvironmentConfig(USER_PROPERTIES_LOCATION,"localUrl");
    public static final String ADMIN_LIVE_URL = getEnvironmentConfig(ADMIN_PROPERTIES_LOCATION,"liveUrl");
    public static final String ADMIN_LOCAL_URL = getEnvironmentConfig(ADMIN_PROPERTIES_LOCATION,"localUrl");

    public static final String USER_EMAIL = getEnvironmentConfig(USER_PROPERTIES_LOCATION,"email");
    public static final String USER_PASSWORD = getEnvironmentConfig(USER_PROPERTIES_LOCATION,"password");
    public static final String PAYPAL_PERSONAL_EMAIL = getEnvironmentConfig(USER_PROPERTIES_LOCATION,"payPalPersonalEmail");
    public static final String ADMIN_EMAIL = getEnvironmentConfig(ADMIN_PROPERTIES_LOCATION,"email");
    public static final String ADMIN_PASSWORD = getEnvironmentConfig(ADMIN_PROPERTIES_LOCATION,"password");



    public static String getLiveDashboardUrl() {
        return liveDashboardUrl;
    }

    public static void setLiveDashboardUrl(String liveDashboardUrl) {
        Utils.liveDashboardUrl = liveDashboardUrl;
    }

    public static String getLocalashboardUrl() {
        return localashboardUrl;
    }

    public static void setLocalashboardUrl(String localashboardUrl) {
        Utils.localashboardUrl = localashboardUrl;
    }

    private static String liveDashboardUrl;
    private static String localashboardUrl;

    public static void url() {
        setLocalashboardUrl("http://localhost:3001/dashboard");
        setLiveDashboardUrl("https://exchange-tradex.nftarttoken.xyz/dashboard");
    }

    public static void wait(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public static void setCollectionVariable(String key,String value) throws ConfigurationException, ConfigurationException {
        PropertiesConfiguration propertiesConfiguration=new PropertiesConfiguration("./src/test/resources/user.properties");
        propertiesConfiguration.setProperty(key,value);
        propertiesConfiguration.save();
    }
    public void switchToWindow() throws InterruptedException {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iter = allWindows.iterator();
        while (iter.hasNext()) {
            String childWindow = iter.next();

            if (mainWindow.equalsIgnoreCase(childWindow)) {
                continue;
            } else {
                driver.switchTo().window(childWindow);
                Thread.sleep(4000);

            }
        }
    }
    public void switchToMainWindow(WebDriver driver){
        String mainWindow = driver.getWindowHandle();
        driver.switchTo().window(mainWindow);
    }


    public static double extractDecimal(String input) {
        Pattern pattern = Pattern.compile("(\\d+\\.\\d+) BTC");

        // Create a Matcher object to find the pattern in the input string
        Matcher matcher = pattern.matcher(input);

        // Check if the pattern is found
        if (matcher.find()) {
            // Extract the matched value from the first group
            String str = matcher.group(1);

            // Convert the extracted value to a double if needed
            double decimalvalue = Double.parseDouble(str);
            return decimalvalue;

        } else {
            throw new IllegalArgumentException("Decimal value not found in the input string.");
        }

    }


    public static double extractDecimal2(String val) {
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(val);
        ArrayList<Double> ar = new ArrayList<>();
        while (matcher.find()) {
            ar.add(Double.valueOf(matcher.group(1)));
        }
        double dec = ar.get(0);
        return dec;

    }

    public static double extractDecimal1(String val) {
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(val);
        ArrayList<Double> ar = new ArrayList<>();
        while (matcher.find()) {
            ar.add(Double.valueOf(matcher.group(1)));
        }
        double dec = ar.get(0);
        return dec;

    }

    public static double extractDecimal3(String val) {
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(val);
        ArrayList<Double> ar = new ArrayList<>();
        while (matcher.find()) {
            ar.add(Double.valueOf(matcher.group(1)));
        }
        double dec = ar.get(0);
        return dec;

    }

    public static String splitDecimal(String val,int position) {
        String str = val;
        String[] arr = val.split(" ");
        String db = arr[position];
        return db;

    }

    public static double splitDecimal2(String val) {
        String str = val;
        String[] arr = val.split(" ");
        double db = Double.parseDouble(arr[2]);
        return db;

    }
    public static String splitString(String val) {
        String[] arr = val.split(" ");
        String str = arr[2];
        return str;

    }

    public static double splitDecimalEqual3(String val) {
        String str = val;
        String[] str2 = str.split(" ");
        double db = Double.parseDouble(str2[3]);
        return db;

    }

    public static double formatdecimal(double dec) {
        DecimalFormat df = new DecimalFormat("#.########");
        double val = Double.parseDouble(df.format(dec));
        return val;
    }

    public static double formatdecimal8(double dec) {
        DecimalFormat df = new DecimalFormat("#.#####");
        double val = Double.parseDouble(df.format(dec));
        return val;
    }

    public static String formatdecimalDigits(double dec, int num) {
        String formattedResult = String.format("%." + num + "f", dec);
        return formattedResult;
    }
    public static void saveJson1(String varaible, String value,String fileName) throws IOException, ParseException, org.json.simple.parser.ParseException {
//        String fileName="./src/test/resources/Value.json";
        JSONParser jsonParser=new JSONParser();
        Object obj= jsonParser.parse(new FileReader(fileName));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(varaible, value);
        JSONObject userObject = new JSONObject();
        FileWriter file = new FileWriter(fileName);
        file.write(jsonObject.toJSONString());
        file.flush();
        file.close();
    }
    public static void saveJson(String variable,String value){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(variable, value);
    }
    public static void saveJsonArray(String fileName,JSONObject jsonObject) throws IOException, org.json.simple.parser.ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.add(jsonObject);
        FileWriter fw = new FileWriter(fileName);
        fw.write(jsonArray.toJSONString());
        fw.flush();
        fw.close();
    }

    public static String readJSONFile(String filename,String value) throws IOException, ParseException, org.json.simple.parser.ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(filename));
        JSONObject jsonObject = (JSONObject) object;
        String var = (String) jsonObject.get(value);
        return var;
    }

    public void doScroll(WebDriver driver, int num) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + num + ")");
    }

    public static void scrolllToElement(WebDriver driver, WebElement locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", locator);

    }

    public static String getEnvironmentConfig(String location,String propertyName) {
        return getPropertyValue(location, propertyName);
    }

    public static String getPropertyValue(String location, String propertyName) {
        String propertyValue = null;
        Properties prop = new Properties();
        FileInputStream file;
        {
            try {
                file = new FileInputStream(location);
                prop.load(file);
                propertyValue = prop.getProperty(propertyName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return propertyValue;

    }
    public void visitUrl(String url){
        driver.get(url);
    }
    public String getText(By by){
        String text= driver.findElement(by).getText();
        return text;
    }
    public void switchToFrame(WebElement locator)
    {
        driver.switchTo().frame(locator);
    }
    public void switchToDefaultContent()
    {
        driver.switchTo().defaultContent();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(formatdecimal8((1000.999* 0.00004)*(7.5/100)));
    }
}

