package com.bitrix24.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.bitrix24.utilities.ConfigurationReader;
import com.bitrix24.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class AbstractTestBase {

    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName){
        System.out.println("Report: "+reportName);
        report = new ExtentReports();
        reportName= reportName==null ? "report.html" : reportName+".html";
        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\"+reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/"+reportName;
        }
        //is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Bitrix24 Test Automation Results");

    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod
    public void setup(){
        String URL= ConfigurationReader.getProperty("url");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),25);
        actions=new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        //if test failed, take a screenshot
        if (iTestResult.getStatus()==ITestResult.FAILURE) {
            String screenshotPath= BrowserUtilities.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName()); //attach test name that failed
            BrowserUtilities.wait(2);
            test.addScreenCaptureFromPath(screenshotPath,"Failed"); //attach screenshot
            test.fail(iTestResult.getThrowable()); //attach console output
        }
        BrowserUtilities.wait(1);
        Driver.closeDriver();
    }
}
