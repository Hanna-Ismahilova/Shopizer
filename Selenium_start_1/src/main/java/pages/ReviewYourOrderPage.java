package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewYourOrderPage extends BasePage{

    private By proceedCheckoutSelector = By.cssSelector("body > div.cart-main-area.ptb-40 > div > div > div > div > div > div.row > div.col-lg-4.col-md-4.col-sm-5.col-xs-12 > div.wc-proceed-to-checkout > a");
    private Button proceedCheckoutButton;

    public ReviewYourOrderPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html";
        this.driver.get(this.url);
        this.proceedCheckoutButton = new Button(this.driver, this.proceedCheckoutSelector);
    }
    public void clickProceedToCheckout(){
        this.proceedCheckoutButton.click();
    }
}
