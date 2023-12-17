package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.pages.BasePage;
import com.pizza.telran.pages.HomePage;
import com.pizza.telran.pages.LogInPage;
import org.testng.Assert;

import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    @Test
    public void headerRedirectToHomePage() {
        new HomePage(driver).clickToHeaderButtonHomePage();
        Assert.assertEquals(new HomePage(driver).getTitleText(), BaseConstants.MAIN_PAGE_TITLE);
    }

    @Test
    public void headerRedirectToCafePage() {
        new HomePage(driver).clickToHeaderButtonCafePage();
        Assert.assertEquals(new BasePage(driver).getCurrentUrl(), BaseConstants.BASE_URL + BaseConstants.CAFE_PAGE_URL);
    }

    @Test
    public void  headerRedirectToLoginPage() {
        new HomePage(driver).clickToHeaderButtonLogInPage();
        Assert.assertEquals(new HomePage(driver).getCurrentUrl(), BaseConstants.BASE_URL + BaseConstants.LOGIN_PAGE_URL);
        Assert.assertEquals(new LogInPage(driver).getLogInPageTitle(), BaseConstants.LOGIN_PAGE_TITLE);
    }

    @Test
    public void  bodyClickToButtonCafes() {
        new HomePage(driver).clickToBodyButtonCafes();
        Assert.assertTrue(new BasePage(driver).getCurrentUrl().contains(BaseConstants.CAFE_PAGE_URL));
    }

    @Test
    public void  bodyClickToButtonPizzas() {
        new HomePage(driver).clickToBodyButtonPizzas();
        Assert.assertTrue(new BasePage(driver).getCurrentUrl().contains(BaseConstants.PIZZAS_PAGE_URL));
    }

}
