package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes WebDriver based on browser configuration
     * Sets up browser instance with appropriate options including headless mode as well
     * @param browser for cross browser testing
     * @param headless to run on headless mode
     * @param implicitWait to provide the syncronization to the script
     */
    public static void initDriver(String browser, boolean headless, int implicitWait){
        if(driver.get()!=null) return;

        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if(headless) chromeOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
                driver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if(headless) firefoxOptions.addArguments("-headless");
                driver.set(new FirefoxDriver(firefoxOptions));
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                 EdgeOptions edgeOptions = new EdgeOptions();
                 if (headless) edgeOptions.addArguments("--headless");
                 driver.set(new EdgeDriver(edgeOptions));
                 break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.get().manage().window().maximize();
    }

    /**
     * To get the driver instance
     */
    public static WebDriver getDriver(){
        return driver.get();
    }

    /**
     * To quit the driver instance
     */
    public static void quitDriver(){
        if(driver.get()!=null){
            driver.get().quit();
            driver.remove();
        }
    }
}
