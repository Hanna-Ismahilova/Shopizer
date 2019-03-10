package tests;

import categories.CartTests;
import categories.PurchaseTests;
import dataModels.Address;
import dataModels.RegisteredUser;
import dataModels.UserBase;
import generators.RandomGenerator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class HanbagsCatalogueTest {

    private MainPage mainPage;
    private WebDriver driver;
    private dataModels.Address address;
    private RegisteredUser firstName;
    private RegisteredUser lastName;
    private dataModels.Address city;

    @Before
    public void startBrowser() {
        if (this.driver == null){
            this.driver = new ChromeDriver();
        }
        this.mainPage = new MainPage(this.driver);
        this.address = new Address (true);
        this.firstName = new RegisteredUser();
        this.lastName = new RegisteredUser();
        this.city = new Address(true);
    }

    @After
    public void closeBrowser() {
        mainPage.close();
    }

    @Category(PurchaseTests.class)
    @Test
    public void purchase() {
        mainPage.ChooseHandbagsCategory();
        HandbagsCataloguePage handbagsCataloguePage = new HandbagsCataloguePage(this.driver);
        handbagsCataloguePage.addBagToCart();
        handbagsCataloguePage.proceedToCheckout();

        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(this.driver);
        reviewYourOrderPage.clickProceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(this.driver);
        checkoutPage.completeShippingForm(address, firstName, lastName, city);
        checkoutPage.stateProvince();
        checkoutPage.postalCode();
        checkoutPage.submitOrder();
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(this.driver);
        String status = orderConfirmationPage.GetOrderStatusInfo();
        //Assertion to check that the ER = AR
        Assert.assertEquals(status, "Order completed");


    }
    @Category(CartTests.class)
    @Test
    public void addToCart() {
        mainPage.ChooseHandbagsCategory();
        HandbagsCataloguePage cataloguePage = new HandbagsCataloguePage(this.driver);
        cataloguePage.addBagToCart();
        cataloguePage.proceedToCheckout();
        ReviewYourOrderPage reviewYourOrderPage = new ReviewYourOrderPage(this.driver);
        //Assertion to check that the ER = AR
        Assert.assertTrue(reviewYourOrderPage.isCartContentCorrect());
    }

}
