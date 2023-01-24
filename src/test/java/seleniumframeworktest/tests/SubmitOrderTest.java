package seleniumframeworktest.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import seleniumframeworktest.tests.pageobjects.*;

import java.time.Duration;
import java.util.List;

public class SubmitOrderTest {
    public static void main(String[] args) throws InterruptedException {
        String productName= "ZARA COAT 3";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.loginApplication("anshika@gmail.com","Iamking@000");
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        List<WebElement> products=productCatalogue.getProductList();
        productCatalogue.addProducrCart(productName);
        productCatalogue.goToCartPage();
        CartPage cartPage=new CartPage(driver);
        Boolean match=cartPage.verifyProductDisplay(productName);
        Assert.assertTrue(match);
        CheckOutPage checkoutPage=cartPage.goToCheckout();
        checkoutPage.selectCountry("India");
        ConfirmationPage confirmationPage=checkoutPage.submitOrder();
        String confirmMessage=confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        //driver.close();
    }

}
