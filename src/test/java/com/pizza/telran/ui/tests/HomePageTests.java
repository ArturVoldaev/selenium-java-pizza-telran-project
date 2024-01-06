package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.pages.BasePage;
import com.pizza.telran.pages.HomePage;
import com.pizza.telran.pages.LoginPage;
import org.testng.Assert;

import org.testng.annotations.Test;

public class HomePageTests extends BaseTests {
    @Test
    public void headerRedirectToHomePageTest() {
        new HomePage(driver).clickToHeaderButtonHomePage();
        Assert.assertEquals(new HomePage(driver).getTitleText(), BaseConstants.MAIN_PAGE_TITLE);
    }

    @Test
    public void headerRedirectToCafePageTest() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        Assert.assertEquals(new BasePage(driver).getCurrentUrl(), BaseConstants.BASE_URL + BaseConstants.CAFE_PAGE_URL);
    }

    @Test
    public void headerRedirectToLoginPageTest() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
        Assert.assertEquals(new BasePage(driver).getCurrentUrl(), BaseConstants.BASE_URL + BaseConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(new LoginPage(driver).getLoginPageTitle(), BaseConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void bodyClickToButtonCafesTest() {
        new HomePage(driver).clickToBodyButtonCafes();
        Assert.assertTrue(new BasePage(driver).getCurrentUrl().contains(BaseConstants.CAFE_PAGE_URL));
    }

    @Test
    public void bodyClickToButtonPizzasTest() {
        new HomePage(driver).clickToBodyButtonPizzas();
        Assert.assertTrue(new BasePage(driver).getCurrentUrl().contains(BaseConstants.PIZZAS_PAGE_URL));
    }
}
