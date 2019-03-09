package pages;

import elements.InputText;
import elements.Select;
import org.openqa.selenium.By;
import sun.java2d.InvalidPipeException;

public class CheckoutPage extends BasePage {

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

    private By stateProvinceSelector = By.cssSelector("#billingStateProvince");
    private InputText stateProvinceInput;

    



}
