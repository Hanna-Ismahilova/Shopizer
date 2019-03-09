package pages;

import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage extends BasePage{

    private By orderConfirmationSelector = By.cssSelector("#main-content > h1");
    private Label orderConfirmationLabel;


    public OrderConfirmationPage(WebDriver driver){
        super(driver);
        this.url = "http://demo.shopizer.com:8080/shop/order/confirmation.html";
        this.orderConfirmationLabel = new Label(this.driver, this.orderConfirmationSelector);
    }
    public String GetOrderStatusInfo(){

        return this.orderConfirmationLabel.read();
    }

}
