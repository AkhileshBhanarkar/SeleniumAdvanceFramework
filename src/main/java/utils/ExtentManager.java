package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Manages the ExtentReports instance for generating test reports.
 */
public class ExtentManager {
    private static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    /**
     * Creates and retrieves a singleton instance of the ExtentReports object.
     * @return ExtentReports instance.
     */
    public static synchronized ExtentReports getInstance(){
        if(extent==null){
            extent = new ExtentReports();

            String reportPath = "test-output/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("DemoQA Automation Report");
            spark.config().setDocumentTitle("Automation Test Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Akhilesh");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }
        return extent;
    }

    /**
     * Creates a new test in the report with the specified name.
     * @param name Name of the test to create.
     */
    public static void createTest(String name){
        ExtentTest extTest = getInstance().createTest(name);
        test.set(extTest);
    }

    /**
     * Retrieves the active test for the current thread.
     * @return The ExtentTest object for the current thread.
     */
    public static ExtentTest getTest(){ return test.get(); }

    /**
     * Flushes the ExtentReports object to save the report.
     */
    public static void flushReports(){
        if(extent!=null) extent.flush();
    }
}