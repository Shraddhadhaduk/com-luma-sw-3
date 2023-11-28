package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.time.Duration;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        //1.1 mouser hover on Women menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));

        //1.2 mouse hover on tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));

        //1.3 click on jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //1.4 select sort by filter product name
        selectByVisibleTextFromDropDown(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"),"Product Name");

        //1.5 verify the product name display in alphabetical order
        verifyTextFromElement(By.xpath("(//div[@class='toolbar toolbar-products']//p[@id='toolbar-amount'])[1]"), "12 Items");
    }

    @Test
    public void verifyTheSortByPriceFilter(){
        //2.1 mouser hover on Women menu
        mouseHoverToElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));

        //2.2 mouse hover on tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));

        //2.3 click on jackets
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //2.4 select sort by filter price
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");

        //2.5 verify products price display in low to high
        verifyTextFromElement(By.xpath("By.xpath(//div[@class = 'price-box price-final_price']"), "Price not ordered : Low to High ");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
