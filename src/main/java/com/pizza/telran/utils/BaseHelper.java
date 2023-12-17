package com.pizza.telran.utils;

import com.google.common.io.Files;
import com.pizza.telran.pages.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class BaseHelper extends BasePage {

    public BaseHelper(WebDriver driver) {
        super(driver);
    }

    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            System.out.println(testResult.getStatus());
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("screenshot\\" + testResult.getName() + "-"
                    + System.currentTimeMillis() / 1000 + ".jpg"));
        }
    }
}
