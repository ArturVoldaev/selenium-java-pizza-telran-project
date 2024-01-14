package com.pizza.telran.pages;

import com.pizza.telran.data.GenerateRandomData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "tr")
    List<WebElement> rows;
    @FindBy(tagName = "td")
    List<WebElement> ceil;
    @FindBy(xpath = " //div[@class='error']")
    WebElement error;
    @FindBy(id="new_button")
    WebElement createNewButton;
    @FindBy(xpath="//button[normalize-space()='New']")
    WebElement createNewPizzaButton;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;
    @FindBy(id = "cafe_button")
    public
    WebElement cafeButton;
    @FindBy(id = "menu_button")
    public
    WebElement menuButton;

    @FindBy(id = "edit_button")
    public
    WebElement editButton;

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

    public WebElement findActionButton(int numberOfElem, String buttonAction) {
        String xpath = "(//button[@type='submit'][normalize-space()='" + buttonAction + "'])[" + (numberOfElem) + "]";
        return driver.findElement(By.xpath(xpath));
    }

    public void editLastElementInTable() {
        clickOnElement(findActionButton((rows.size() - 1), "Edit"));
    }

    public void deleteElementInTable() {
        int randomButton = new GenerateRandomData().generateRandomNumberInRange(1, parseTable().size());
        clickOnElement(findActionButton(randomButton, "Delete"));
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

    public List<Map<String, String>> parseTable() {
        List<Map<String, String>> tableDataList = new ArrayList<>();

        WebElement table = driver.findElement(By.xpath("(//table)[1]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> headers = rows.get(0).findElements(By.tagName("th"));

        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
            Map<String, String> tableData = new HashMap<>();
            for (int j = 0; j < headers.size(); j++) {
                String header = headers.get(j).getText();
                String cellValue = cells.get(j).getText();
                if (headers.get(j).getText().equals("Pic")) {
                    tableData.put(header, getPizzaSrc(i));
                    continue;
                }
                tableData.put(header, cellValue);
            }
            tableDataList.add(tableData);
        }
        return tableDataList;
    }

    public String getPizzaSrc(int iterator) {
        WebElement img = driver.findElement(By.xpath("(//img)" + "[" + iterator + "]"));
        return img.getAttribute("src");
    }

    public boolean checkParseData(List<Map<String, String>> hashMapA, List<Map<String, String>> hashMapB) {
        return hashMapA.equals(hashMapB);
    }

    public int generateRandomNumberOfActionButton() {
        return new GenerateRandomData().generateRandomNumberInRange(1, parseTable().size());
    }

    public Boolean isElementExistOnPage(WebElement webElement) {
        if (driver.findElements(By.id(webElement.getAttribute("id"))).size() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
