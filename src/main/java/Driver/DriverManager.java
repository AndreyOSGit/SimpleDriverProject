package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class DriverManager {


    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            WebDriver driver = new ChromeDriver();

        }

        return driver;
    }

    public static void killDriver(){
        getDriver().close();
        getDriver().quit();
    }



}
