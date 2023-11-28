package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //1.1 mouse hover on men menu
        mouseHoverToElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/a[1]/span[2]"));

        //1.2 mouse hover on bottoms
        mouseHoverToElement(By.xpath("//body/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]/span[2]"));

        //1.3 click on pents
        clickOnElement(By.id("ui-id-23"));

        //1.4 Mouse Hover on product name Cronus Yoga Pant’ and click on size 32
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));

        //1.5 Mouse Hover on product name‘Cronus Yoga Pant’ and click on colour black
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.id("option-label-color-93-item-49"));

        //1.6 Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));

        //1.6 verify text
        verifyTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Cronus Yoga Pant to your shopping cart.");

        //1.7 Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //1.8 verify the text shopping cart
        verifyTextFromElement(By.xpath("//span[@class='base']"), "Shopping Cart");

        //1.9 Verify the product name ‘Cronus Yoga Pant’
        verifyTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");

        //1.10 Verify the product size ‘32’
        verifyTextFromElement(By.xpath("//dd[contains(text(),'32')]"), "32");

        //1.11 Verify the product colour ‘Black’
        verifyTextFromElement(By.xpath("//dd[contains(text(),'Black')]"), "Black");
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
