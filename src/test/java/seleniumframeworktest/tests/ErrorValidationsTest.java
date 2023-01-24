package seleniumframeworktest.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumframeworktest.tests.TestComponents.BaseTest;
import seleniumframeworktest.tests.pageobjects.*;

import java.io.IOException;
import java.util.List;

public class ErrorValidations extends BaseTest {

        @Test
        public void LoginErrorValidation () throws IOException,InterruptedException{

            landingPage.loginApplication("anshika@gmail.com", "Iamking@00011");
            Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());

        }
         @Test
         public void ProductErrorValidation () throws IOException,InterruptedException{

        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue=landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductCart(productName);
        productCatalogue.goToCartPage();
        CartPage cartPage = new CartPage(driver);
        Boolean match = cartPage.verifyProductDisplay(productName);
        Assert.assertFalse(match);
    }

    }
