package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class HanbagsCatalogueTest {

    private MainPage mainPage;
    private WebDriver driver;

    @Before
    public void startBrowser() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }

    @Test
    public void purchase() {
        mainPage.ChooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(this.driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(this.driver);
        reviewYourOrderPage.clickProceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.completeShippingForm();
        checkoutPage.stateProvince();
        checkoutPage.postalCode();
        checkoutPage.submitOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(this.driver);
        String status = orderConfirmationPage.GetOrderStatusInfo();
        Assert.assertEquals(status, "Order completed");


        //Asssertion
    }

}
