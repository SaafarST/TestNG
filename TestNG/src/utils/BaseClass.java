package utils;

//NOTE: THIS CLASS IS USED TO LAUNCH AND QUIT THE BROWSER

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseClass extends CommonMethods{

    public static WebDriver driver;

    public static void setUp(String url) {

        ConfigsReader.loadProperties(Constants.CONFIGURATION_FILEPATH);

        switch (ConfigsReader.getProperties("browser").toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.msedgedriver.driver", "drivers/gecko.exe");
                driver = new FirefoxDriver();
            }
            default -> throw new RuntimeException("Browser is not imported");
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));

    }
    public static void tearDown() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(driver!= null){ //We use this to prevent NullPointerException
        driver.quit();}
    }
}
