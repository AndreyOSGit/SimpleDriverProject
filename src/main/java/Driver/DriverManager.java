package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {


    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            driver = new SafariDriver();

        }

        return driver;
    }

    public static void killDriver(){
        getDriver().close();
        getDriver().quit();
    }



}
