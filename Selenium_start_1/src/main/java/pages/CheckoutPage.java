package pages;

import elements.Button;
import elements.InputText;
import elements.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
        firstNameInput = new InputText(driver, firstNameSelector);
        lastNameInput = new InputText(driver, lastNameSelector);
        streetAddressInput = new InputText(driver, streetAddressSelector);
        cityInput = new InputText(driver, citySelector);
        countrySelect = new Select(driver, countrySelector);
        emailAddressInput = new InputText(driver, emailAddressSelector);
        phoneNumberInput = new InputText(driver, phoneNumberSelector);
    }


    private By firstNameSelector = By.cssSelector("#customer\\2e firstName");
    private InputText firstNameInput;

    private By lastNameSelector = By.cssSelector("#customer\\2e lastName");
    private InputText lastNameInput;

    private By streetAddressSelector = By.cssSelector("#customer\\2e billing\\2e address");
    private InputText streetAddressInput;

    private By citySelector = By.cssSelector("#customer\\2e billing\\2e city");
    private InputText cityInput;

    private By countrySelector = By.cssSelector("#customer\\2e billing\\2e country");
    private Select countrySelect;

    private By emailAddressSelector = By.cssSelector("#customer\\2e emailAddress");
    private InputText emailAddressInput;

    private By phoneNumberSelector = By.cssSelector("#customer\\2e billing\\2e phone");
    private InputText phoneNumberInput;

    //robimy odzielna metode poniewaz po wybraniu Country z dropdown list ponizsze pola odswirzaja sie
    public void stateProvince() {
        By stateProvinceSelector = By.cssSelector("#billingStateProvince");
        InputText stateProvinceInput = new InputText(driver, stateProvinceSelector);
        stateProvinceInput.sendKeys("Gdansk");
    }

    //robimy odzielna metode poniewaz po wybraniu Country z dropdown list ponizsze pola odswirzaja sie
    public void postalCode() {
        By postalCodeSelector = By.cssSelector("#billingStateProvince");
        InputText postalCodeInput = new InputText(driver, postalCodeSelector);
        postalCodeInput.sendKeys("80-180");
    }

    //robimy odzielna metode poniewaz po wybraniu Country z dropdown list ponizsze pola odswirzaja sie
    public void submitOrder() {
        By sumbitOrderSelector = By.cssSelector("#submitOrder");
        Button submitOrderButton;

    }

    public void completeShippingForm() {
        firstNameInput.sendKeys("Hanna");
        lastNameInput.sendKeys("Ismahilova");
        streetAddressInput.sendKeys("Street");
        cityInput.sendKeys("City");
        countrySelect.choose("Brazil");
        emailAddressInput.sendKeys("test@example.com");
        phoneNumberInput.sendKeys("0123465789");
    }
}
