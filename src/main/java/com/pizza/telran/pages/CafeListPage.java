package com.pizza.telran.pages;

import com.pizza.telran.data.BaseConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CafeListPage extends BasePage {
    public CafeListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[normalize-space()='New']")
    WebElement createNewCafe;
    @FindBy(tagName = "th")
    List<WebElement> cafeTableHeading;
    @FindBy(tagName = "tr")
    List<WebElement> cafeRows;
    @FindBy(tagName = "td")
    List<WebElement> tableCeil;
    public Boolean isButtonNewVisible() {
        return createNewCafe.isDisplayed();
    }
    public CafeListPage clickOnCreateNewCafeButton() {
        clickOnElement(createNewCafe);
        return this;
    }
    public String nameLastCafe() {
        return BaseConstants.LAST_CAFE_NAME=getDataFromTable(
                "Name",
                cafeTableHeading,
                cafeRows,
                cafeRows.size()-1
        );
    }

    public WebElement findLastButtonDelete(int numberOfElem) {
        String xpath = "(//button[@type='submit'][normalize-space()='Delete'])["+ (numberOfElem) +"]";
        return driver.findElement(By.xpath(xpath));
    }

    public void deleteCafe() {
        clickOnElement(findLastButtonDelete(cafeRows.size() - 1));
    }

    public Boolean isCaffeExist(String nameCompany) {
        Boolean isCaffeExist = false;
        for (int i = 0; i < tableCeil.size(); i++) {
            System.out.println(tableCeil.get(i).getText());
            if (tableCeil.get(i).getText().equals(nameCompany)) {
                System.out.println("================");
                System.out.println(tableCeil.get(i).getText());
                isCaffeExist = true;
                break;
            }
        }
        return isCaffeExist;
    }
}
