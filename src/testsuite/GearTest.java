package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(2);
        //3.1 mouser hover on gear menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));

        //3.2 click on beg
        clickOnElement(By.xpath("//span[normalize-space()='Bags']"));

        //3.3 Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        //3.4 Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), Keys.DELETE + "3");

        //3.5 click on add to cart button
        clickOnElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[1]/div[4]/form[1]/div[1]/div[1]/div[2]/button[1]/span[1]"));

        //3.6 verify text
        verifyTextFromElement(By.xpath("//body/div[2]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"), "You added Overnight Duffle to your shopping cart.");

        //3.7 click on shopping cart
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //3.8 verify product name cronus yoga pant
        verifyTextFromElement(By.xpath("//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");

        //3.9 change quality 3
        verifyTextFromElement(By.xpath("//input[@id='cart-487572-qty']"),"3");

        //3.10 Verify the product price ‘$135.00’
        verifyTextFromElement(By.xpath("td[class='col subtotal'] span[class='price']"),"$135.00");

        // 3.11 Change Qty to ‘5’
        clearTest(By.xpath("//input[@id='cart-488855-qty']"));
        sendTextToElement(By.xpath("//input[@id='cart-488855-qty']"),  "5");

        //3.12 Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));

        //3.13 Verify the product price '$225.00'
        verifyTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"), "$225.00");
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
