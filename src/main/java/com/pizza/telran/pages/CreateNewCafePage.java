package com.pizza.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;
    @FindBy(tagName = "td")
    List<WebElement> tablePage;
        public void createNewCafe(
            String cafeName,
            String cafeCity,
            String cafeAddress,
            String cafeEmail,
            String cafePhone,
            String cafeOpen,
            String cafeClose
            ) {
        fillField(cafeName,cafeNameInput);
        fillField(cafeCity,cafeCityInput);
        fillField(cafeAddress,cafeAddressInput);
        fillField(cafeEmail,cafeEmailInput);
        fillField(cafePhone,cafePhoneInput);
        fillField(cafeOpen,cafeOpenInput);
        fillField(cafeClose,cafeCloseInput);
        clickOnElement(submitButton);
        }

    public Boolean isNewNameCompanyCorrect(String nameCompany) {
        boolean isCompanyInList = false;
        for (WebElement webElement : tablePage) {
            if (webElement.getText().equals(nameCompany)) {
                isCompanyInList = true;
                break;
            }
        }
        return isCompanyInList;
    }
}
