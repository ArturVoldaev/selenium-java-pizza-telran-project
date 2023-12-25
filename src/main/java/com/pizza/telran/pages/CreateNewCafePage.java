package com.pizza.telran.pages;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.data.GenerateRandomData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewCafePage extends BasePage {
    public CreateNewCafePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "name")
    WebElement cafeNameInput;
    @FindBy(id = "city")
    WebElement cafeCityInput;
    @FindBy(id = "address")
    WebElement cafeAddressInput;
    @FindBy(id = "email")
    WebElement cafeEmailInput;
    @FindBy(id = "phone")
    WebElement cafePhoneInput;
    @FindBy(id = "open")
    WebElement cafeOpenInput;
    @FindBy(id = "close")
    WebElement cafeCloseInput;
    public CreateNewCafePage createNewCafe(
            String cafeName,
            String cafeCity,
            String cafeAddress,
            String cafeEmail,
            String cafePhone,
            String cafeOpen,
            String cafeClose
    ) {
        fillField(cafeName, cafeNameInput);
        fillField(cafeCity, cafeCityInput);
        fillField(cafeAddress, cafeAddressInput);
        fillField(cafeEmail, cafeEmailInput);
        fillField(cafePhone, cafePhoneInput);
        fillField(cafeOpen, cafeOpenInput);
        fillField(cafeClose, cafeCloseInput);
        clickSubmit();
        return this;
    }
    public CreateNewCafePage editCafe() {
        editItem(BaseConstants.EDIT_PARAM, cafeCityInput);
        return this;
    }
    public String newCafeName() {
        return new GenerateRandomData().generateCompanyName();
    }
}
