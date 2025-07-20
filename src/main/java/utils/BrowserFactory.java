package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class BrowserFactory {
    public static WebDriver setUpDriver() {
        String browser = ConfigReader.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().cachePath("drivers").setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) chromeOptions.addArguments("--headless=new");
                return new ChromeDriver(chromeOptions);
            case "firefox":
                WebDriverManager.firefoxdriver().cachePath("drivers").setup();
                FirefoxOptions ffOptions = new FirefoxOptions();
                if (headless) ffOptions.addArguments("--headless");
                return new FirefoxDriver(ffOptions);
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }
    }

    public static WebDriver setMobileDriver(String deviceName) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", deviceName);
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        return new ChromeDriver(options);
    }

}
