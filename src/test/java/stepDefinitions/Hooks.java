package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import pages.Add_to_Cart;
import pages.LoginPage;
import pages.Search_ProductPage;
import utilities.BaseClass;

public class Hooks {

    public static WebDriver driver;
    static LoginPage lp;
    static Search_ProductPage sp;
    static Add_to_Cart ap;

    private static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static final String REPORT_FOLDER = System.getProperty("user.dir") + "/Final_Project_Report";
    private static final String SCREENSHOT_FOLDER = REPORT_FOLDER + "/SSFolder";
    private ExtentTest test;

    @Before(order = 0)
    public void initializeReport() {
        // Initialize Extent Report only once
        if (extent == null) {
            new File(SCREENSHOT_FOLDER).mkdirs();

            // Set up Extent Report configuration
            spark = new ExtentSparkReporter(REPORT_FOLDER + "/Report.html");
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Functional Testing");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Cucumber with TestNG");
        }
    }

    @Before(order = 1)
    public void setUp(Scenario scenario) {
        // Start a new scenario for the Extent report
        test = extent.createTest(scenario.getName());

        // Log the start of the scenario in the Extent Report
        test.info("Scenario started: " + scenario.getName());

        // Initialize WebDriver and Page Objects
        driver = BaseClass.initializeDriver();
        lp = new LoginPage(driver);
        sp = new Search_ProductPage(driver);
        ap = new Add_to_Cart(driver);
    }

    @Before(order = 2)
    public void setupScenarioTags(Scenario scenario) throws Throwable {
        // Custom setup based on tags
        if (scenario.getSourceTagNames().contains("@Search") || 
            scenario.getSourceTagNames().contains("@AddtoCart") || 
            scenario.getSourceTagNames().contains("@Checkout")) {

            lp.click_on_signup_login();
            lp.enter_valid_Email_Password();
            lp.click_on_Login();
            BaseClass.Verify_Successfull_Login();
        }

        if (scenario.getSourceTagNames().contains("@AddtoCart") || 
            scenario.getSourceTagNames().contains("@Checkout")) {
            sp.click_on_Products();
            sp.Search_product();
            sp.click_on_SearchIcon();
            sp.verify_product();
        }

        if (scenario.getSourceTagNames().contains("@Checkout")) {
            try {
                ap.click_on_Add_to_Cart();
                ap.click_on_view_cart();
            } catch (Exception e) {
                System.out.println("Invalid session");
            }
        }
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws IOException {
        // Capture the screenshot after the scenario
        String screenshotPath = captureScreenshot1(scenario.getName().replaceAll(" ", "_"));

        if (scenario.isFailed()) {
            test.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
        } else {
            test.log(Status.PASS, "Scenario Passed: " + scenario.getName());
        }

        // Attach screenshot to the Extent report
        if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath);
        }

        // Quit the driver after test completes
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @After(order = 2)
    public void flushReport() {
        // Flush the Extent Reports at the end
        if (extent != null) {
            extent.flush();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String captureScreenshot1(String filename) throws IOException {
		try {
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dest = "./Final_Project_Report/SSFolder/" + filename + ".png";
			Files.copy(source.toPath(), Paths.get(dest));
		} catch (Exception e) {
		}
		return filename;
    }
}
