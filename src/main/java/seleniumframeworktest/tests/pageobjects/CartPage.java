package seleniumframeworktest.tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumframeworktest.tests.AbstractComponents.AbstractComponent;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css=".cartSection h3")
    private List<WebElement> productTittles;
    @FindBy(css=".totalRow button")
    WebElement checkoutElement;
    public Boolean verifyProductDisplay(String productName){
        Boolean match=productTittles.stream().anyMatch(s->s.getText().equalsIgnoreCase(productName));
        return match;
    }
    public CheckOutPage goToCheckout(){
        checkoutElement.click();
        return new CheckOutPage(driver);
    }

}
