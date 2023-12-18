package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.utils.MyListener;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    EventFiringWebDriver driver;
        @BeforeMethod
        public void setUp() {
            FirefoxOptions options = new FirefoxOptions();
            driver = new EventFiringWebDriver(new FirefoxDriver(options.addArguments("--headless")));
            driver.get(BaseConstants.BASE_URL);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.register(new MyListener());
        }
        @AfterMethod
        public void tearDown(ITestResult testResult) throws IOException {
            if (testResult.getStatus() == ITestResult.FAILURE) {
                System.out.println(testResult.getStatus());
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("screenshot\\" + testResult.getName() + "-"
                        + System.currentTimeMillis() / 1000 + ".jpg"));
            }
        driver.quit();
    }
}
