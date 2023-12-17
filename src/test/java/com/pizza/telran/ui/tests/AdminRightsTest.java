package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.data.GenerateRandomData;
import com.pizza.telran.pages.CafeListPage;
import com.pizza.telran.pages.CreateNewCafePage;
import com.pizza.telran.pages.HomePage;
import com.pizza.telran.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminRightsTest extends BaseTest {
    @BeforeMethod
    public void prepare() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
        new LogInPage(driver).logInWithBaseAdminAccess();
    }

    @Test
    public void createNewCafe() {
        String newCompanyName = new GenerateRandomData().generateCompanyName();
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafeListPage(driver).clickOnCreateNewCafeButton();
        new CreateNewCafePage(driver).createNewCafe(
                newCompanyName,
                new GenerateRandomData().generateCityOfCafe(),
                new GenerateRandomData().generateAddress(),
                new GenerateRandomData().generateEmail(),
                new GenerateRandomData().generateMobilePhone(),
                BaseConstants.CAFE_OPEN,
                BaseConstants.CAFE_CLOSE
        );
        Assert.assertTrue(new CreateNewCafePage(driver).isNewNameCompanyCorrect(newCompanyName));
    }

    @Test
    public void deleteCafe() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        new CafeListPage(driver).deleteCafe();
        Assert.assertFalse(new CafeListPage(driver).isCaffeExist(BaseConstants.LAST_CAFE_NAME));
    }
}
