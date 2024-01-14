package com.pizza.telran.ui.tests;

import com.pizza.telran.data.BaseConstants;
import com.pizza.telran.utils.MyListener;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTests {
    public static String browser = System.getProperty("browser", "firefox");
    EventFiringWebDriver driver;

    @BeforeMethod
    public void setUp() {
        if (browser.contains("chrome")) {
            System.out.println("chrome");
            ChromeOptions options = new ChromeOptions();
            driver = new EventFiringWebDriver(new ChromeDriver(options.addArguments("--headless")));
        } else if (browser.contains("edge")) {
            System.out.println("edge");
            EdgeOptions options = new EdgeOptions();
            driver = new EventFiringWebDriver(new EdgeDriver(options.addArguments("--headless")));
        } else {
            System.out.println("firefox");
            FirefoxOptions options = new FirefoxOptions();
            driver = new EventFiringWebDriver(new FirefoxDriver(options.addArguments("--headless")));
        }
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
