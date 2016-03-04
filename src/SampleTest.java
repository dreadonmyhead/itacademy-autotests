import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static java.sql.DriverManager.getDriver;

public class SampleTest {

    @Test
    public void testCase() throws InterruptedException{

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);

//        File file = new File("C:/Users/User/Downloads/IEDriverServer_Win32_2.52.0/IEDriverServer.exe");
//        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
//        WebDriver driver = new InternetExplorerDriver();

        driver.get("https://www.swedbank.lt/lt/spreadsheets/consumer2");

//        //Sleep vs wait
//        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));

        //Input
        WebElement loanAmount = driver.findElement(By.id("SpreadsheetRequestedLoanAmount"));
        WebElement secondInput = driver.findElement(By.id("SpreadsheetNetMonthlyIncome"));
        WebElement firstRadio = driver.findElement(By.id("SpreadsheetWageAccount1"));
        WebElement secondRadio = driver.findElement(By.id("SpreadsheetHasOutstandingLoan1"));
        loanAmount.clear();
        loanAmount.sendKeys("500");
        secondInput.clear();
        secondInput.sendKeys("125");
        firstRadio.click();
        secondRadio.click();

//        //Select
//        Select selectA = new Select(driver.findElement(By.xpath("")));
//        selectA.selectByIndex(1);

        //Sumbit
        secondRadio.submit();

        Thread.sleep(1000);

        //Assert
        WebElement ActualSum = driver.findElement(By.xpath("//div[contains(@class, 'consumerResultValue')]"));
        Assert.assertEquals("14,48 Eur", ActualSum.getText());
        driver.quit();
    }
}