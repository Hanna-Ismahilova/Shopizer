package pages;

import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.HanbagsCatalogueTest;

public class HandbagsCataloguePage extends BasePage{

        private final By chicVinategDeVillleBagSelector = By.cssSelector("div#productsContainer div[item-name='Chic vintage DeVille'] div.store-btn-addtocart");
        private final By shoppingCartSelector = By.cssSelector("#miniCartSummary > a");
        private final By checkoutSelector = By.cssSelector("#miniCartDetails > li.checkout-bg > a");

        private Button chicVinategDeVillleBagButton;
        private Button shoppingCartButton;
        private Button checkoutButton;

        public HandbagsCataloguePage(WebDriver driver){
            super(driver);
            this.url = "http://demo.shopizer.com:8080/shop/category/handbags.html/ref=c:1#";
            this.driver.get(this.url);
            this.chicVinategDeVillleBagButton = new Button(this.driver, this.chicVinategDeVillleBagSelector);
            this.shoppingCartButton = new Button(this.driver, this.shoppingCartSelector);
//            this.checkoutButton = new Button(this.driver, this.checkoutSelector);
        }

    public void addBagToCart(){
            this.chicVinategDeVillleBagButton.click();
        }
        public void proceedToCheckout(){
            this.shoppingCartButton.safeClick();
            this.checkoutButton = new Button(this.driver, this.checkoutSelector);
            this.checkoutButton.clickWithJs();

        }

    }

