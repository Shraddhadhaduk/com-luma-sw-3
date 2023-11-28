package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    public void selectByValue(){
        String value;
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
//      Thread.sleep(3000);
//      waitUnitVisibilityOfElementLocated(by,2000);
        actions.moveToElement(mouseHoover).build().perform();
    }
    public void verifyTextFromElement(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText, actual);
    }
    public void clearTest(By by) {
        WebElement qty = driver.findElement(by);
        qty.clear();
    }
}
