//package utilities;
//
//import java.io.File;
//import java.io.IOException;
//import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import stepDefinitions.Hooks;
//
//public class ExtentReportManager2 extends Hooks implements ITestListener {
//    static ExtentSparkReporter sparkReporter;
//    static ExtentReports extent;
//    static ExtentTest test;
//    static Logger log = Logger.getLogger("ExtentReportManager");
//
//    private static final String REPORT_DIR = System.getProperty("user.dir") + "/Final_Project_Report";
//    private static final String SCREENSHOT_DIR = REPORT_DIR + "/SSFolder";
//    private static final String REPORT_FILE = REPORT_DIR + "/Luma.html";
//
//    public void onStart(ITestContext context) {
//        try {
//            FileUtils.deleteDirectory(new File(REPORT_DIR));
//        } catch (IOException e) {
//            log.warn("Could not delete existing report folder: " + e.getMessage());
//        }
//
//        new File(SCREENSHOT_DIR).mkdirs();
//        log.info("Report and screenshot directories created.");
//
//        sparkReporter = new ExtentSparkReporter(REPORT_FILE);
//        sparkReporter.config().setDocumentTitle("Automation Report");
//        sparkReporter.config().setReportName("Functional Testing");
//        sparkReporter.config().setTheme(Theme.DARK);
//
//        extent = new ExtentReports();
//        extent.attachReporter(sparkReporter);
//        extent.setSystemInfo("Computer Name", "localhost");
//
//        log.info("ExtentReports initialized.");
//    }
//
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getMethod().getMethodName());
//        log.info("Test started: " + result.getMethod().getMethodName());
//    }
//
//    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
//        attachScreenshot(result.getMethod().getMethodName());
//    }
//
//    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
//        test.log(Status.FAIL, result.getThrowable());
//        attachScreenshot(result.getMethod().getMethodName());
//    }
//
//    public void onTestSkipped(ITestResult result) {
//        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
//    }
//
//    public void onFinish(ITestContext context) {
//        extent.flush();
//        log.info("ExtentReports flushed.");
//    }
//}
