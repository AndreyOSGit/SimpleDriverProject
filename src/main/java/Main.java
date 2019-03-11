import ReadWright.ApachePOIExcelRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static Driver.DriverManager.getDriver;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        ArrayList<Row> rows = null;// = ApachePOIExcelRead.readSells("D:/MyFirstExcel.xlsx");

       WebDriver driver = getDriver();
//        WebDriver driver = new ChromeDriver();
        driver.get("https://trading.umarkets.com");
        driver.findElement(By.cssSelector("#login")).sendKeys("webappteamgold7@abc.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("password123456");

        driver.findElement(By.cssSelector("#btLogin")).click();
driver.manage().window().maximize();

//        WebDriverManager.chromedriver().setup();
//        new ChromeDriver().get("https://google.com");
//
//        new ChromeDriver().get("https://yahoo.com");

//        WebDriverWait waitOne =
                new WebDriverWait(driver, 30).until(
                        ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#btLogin"))
                );
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.presenceOfElementLocated(By.cssSelector("canvas.chart-info.canvas-graphic_chart-1"))
        );
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("canvas.chart-info.canvas-graphic_chart-1"))
        );

//
//        new WebDriverWait(driver, 30).until(
//                ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#btLogin"))
//        );
driver.close();
//        driver.quit();
        System.out.println("testOK");
//        PageFactory.initElements(getDriver(), PO.class).waitSpinnerGone();

        for (int i = 0; i <rows.size(); i++) {

            try {

                driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input")).sendKeys(
                        rows.get(i).getCell(0).getStringCellValue()
                );
                System.out.println( rows.get(i).getCell(0).getStringCellValue());

//                driver.findElement(By.cssSelector("#fm-login-password")).sendKeys(
//                        rows.get(i).getCell(1).getStringCellValue()
//                );


            } catch (Exception e){
                System.out.println("Can`t get cell " + e);
            }

        }
//
//        driver.close();
//        driver.quit();
    }
}
