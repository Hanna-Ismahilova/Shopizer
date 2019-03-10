package pages;

import elements.Button;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewYourOrderPage extends BasePage{

    private By proceedCheckoutSelector = By.cssSelector("body > div.cart-main-area.ptb-40 > div > div > div > div > div > div.row > div.col-lg-4.col-md-4.col-sm-5.col-xs-12 > div.wc-proceed-to-checkout > a");
    private Button proceedCheckoutButton;

    private By addedItemNameSelector = By.cssSelector("td[data-th='Item'] span");
    private Label addedItemNameLabel;
    private By addedItemQuantitySelector = By.cssSelector("td[data-th='Quantity'] input.quantity");
    private Label addedItemQuantityLabel;
    private By addedItemPriceSelector = By.cssSelector("td[data-th='Price']");
    private Label addedItemPriceLabel;
    private By addedItemTotalSelector = By.cssSelector("td[data-th='Total']");
    private Label addedItemTotalLabel;

    public ReviewYourOrderPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/cart/shoppingCart.html";
        this.driver.get(this.url);
        this.proceedCheckoutButton = new Button(this.driver, this.proceedCheckoutSelector);
    }
    public void clickProceedToCheckout(){

        this.proceedCheckoutButton.click();
    }
    public boolean isCartContentCorrect(){
        String actualName = new Label(this.driver, addedItemNameSelector).read();
        int actualQuantity = Integer.parseInt(new Label(this.driver, addedItemQuantitySelector).getValue());
        double actualPrice = Double.parseDouble(new Label(this.driver, addedItemPriceSelector).read().substring(1));
        double actualTotal = Double.parseDouble(new Label(this.driver, addedItemTotalSelector).read().substring(1));

        String expectedName = "Chic vintage DeVille";
        int expectedQuantity = 1;
        double expectedPrice = 78.00;
        double expectedTotal = expectedPrice * expectedQuantity;

        return actualName.equals(expectedName) && actualQuantity == expectedQuantity && actualPrice == expectedPrice && actualTotal == expectedTotal;
    }
}
