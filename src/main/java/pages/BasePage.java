package pages;

import base.TestBase;
import org.openqa.selenium.By;

import static base.TestBase.driver;


public class BasePage extends TestBase {
    public void click(By by) {
        driver.findElement(by).click();
    }
    public void inputText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    public String getText(By by)
    {
       String text= driver.findElement(by).getText();
        return text;
    }

}
