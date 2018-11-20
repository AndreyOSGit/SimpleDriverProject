package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Driver.DriverManager.getDriver;

public class PO {


//    publi


    public void waitSpinnerGone(){
        try {
            new WebDriverWait(getDriver(), 60)
                    .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("")));
        }catch (Exception e){
            System.out.println("не додался " + e);
        }

    }


}
