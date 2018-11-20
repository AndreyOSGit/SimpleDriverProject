import Driver.DriverManager;
import PageObject.PO;
import ReadWright.ApachePOIExcelRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static Driver.DriverManager.getDriver;
import static ReadWright.ApachePOIExcelRead.readSells;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        ArrayList<Row> rows = ApachePOIExcelRead.readSells("D:/MyFirstExcel.xlsx");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com.ua");

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

        driver.close();
        driver.quit();
    }
}
