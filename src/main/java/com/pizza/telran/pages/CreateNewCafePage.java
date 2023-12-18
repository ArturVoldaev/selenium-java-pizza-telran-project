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
    public String newCompanyName() {
        return BaseConstants.NEW_COMPANY_NAME = new GenerateRandomData().generateCompanyName();
    }
    public void createNewCafe(
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
        clickOnElement(new HomePage(driver).submitButton);
    }
}
