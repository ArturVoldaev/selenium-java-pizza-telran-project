package com.pizza.telran.pages;

import com.pizza.telran.data.GenerateRandomData;
import com.pizza.telran.data.PizzaTableConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(tagName = "th")
    List<WebElement> tableHeading;
    @FindBy(tagName = "tr")
    List<WebElement> rows;
    @FindBy(tagName = "td")
    List<WebElement> ceil;
    @FindBy(xpath = " //div[@class='error']")
    WebElement error;
    @FindBy(xpath = "//button[normalize-space()='New']")
    WebElement createNewButton;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;
    public WebElement getErrorElement() {
        return error;
    }
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
    public WebElement getCreateNewButton() {
        return createNewButton;
    }
    public void clickOnElement(WebElement nameOfWebElement) {
        nameOfWebElement.click();
    }
    public void fillField(String text, WebElement element) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public int findNumberOfColumn(String needData, List<WebElement> elements) {
        int numberOfColumn = 0;
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            if (element.getText().equals(needData)) {
                numberOfColumn = i;
                break;
            }
        }
        return numberOfColumn;
    }
    public int getRowAmount( List<WebElement> rows) {
        return rows.size();
    }
    public int generateRandomRow(int elemAmount) {
        return PizzaTableConstant.PIZZA_NUMBER = new GenerateRandomData().generateRandomNumberInRange(1, elemAmount-1);
    }
    public String getDataFromTable(String pizzaParam, List<WebElement> row, List<WebElement> unit, int numberOfRow) {
        WebElement element = unit.get(numberOfRow);
        List<WebElement> children = element.findElements(By.tagName("td"));
        return children.get(findNumberOfColumn(pizzaParam, row)).getText();
    }
    public WebElement findLastActionButton(int numberOfElem, String buttonAction) {
        String xpath = "(//button[@type='submit'][normalize-space()='"+buttonAction+"'])["+ (numberOfElem) +"]";
        return driver.findElement(By.xpath(xpath));
    }
    public void editLastElementInTable() {
        clickOnElement(findLastActionButton((rows.size() - 1), "Edit"));
    }
    public void deleteLastElementInTable() {
        clickOnElement(findLastActionButton((rows.size() - 1), "Delete"));
    }
    public Boolean isElementExistInTable(String nameCompany) {
        boolean isCompanyInList = false;
        for (WebElement webElement : ceil) {
            if (webElement.getText().equals(nameCompany)) {
                isCompanyInList = true;
                break;
            }
        }
        return isCompanyInList;
    }
    public String getWebElementText(WebElement webElement) {
        return webElement.getText();
    }
    public BasePage clickSubmit() {
        clickOnElement(submitButton);
        return this;
    }
    public BasePage editItem(String newData, WebElement nameInput) {
        fillField(newData, nameInput);
        clickSubmit();
        return this;
    }
}
